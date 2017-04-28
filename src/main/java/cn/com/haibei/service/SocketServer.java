package cn.com.haibei.service;

import java.io.IOException;
import java.net.InetSocketAddress;
import java.nio.ByteBuffer;
import java.nio.channels.ClosedChannelException;
import java.nio.channels.SelectionKey;
import java.nio.channels.Selector;
import java.nio.channels.ServerSocketChannel;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.ScheduledFuture;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicInteger;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Repository;

import cn.com.haibei.bean.Cmd;
import cn.com.haibei.bean.Device;
import cn.com.haibei.bean.Job;
import cn.com.haibei.bean.Lock;
import cn.com.haibei.tool.Tools;

@Repository
public class SocketServer {
	protected final Logger LOG = LoggerFactory.getLogger(getClass());
	protected final String SYS_ID = "008";
	protected final String SYS_CERT = "YgzqwmEDoQXRJRLJtCOAg70mi72KEqiLEkjxBrolCuoUGclQeFb0Dk6aCewCpTj0Jwe0qJfOB5DsQaGbzeJvIAoUrkW8a6M6voRYu5UIyRtmYAQSBWZ9wIQqlOZ4KO";

	@Value("${BUFFERSIZE}")
	private int BufferSize = 1024; // 缓冲区大小
	@Value("${LOOPOUT}")
	private int LoopOut = 5; // 命令超时时间，单位秒
	@Value("${TIMEOUT}")
	private int TimeOut = 30 * 1000; // 超时时间，单位毫秒
	@Value("${PORT}")
	private int ListenPort = 5005; // 本地监听端口
	@Value("${PULSETASK}")
	private int Pulse = 20;// 心跳间隔，单位分钟
	@Value("${READTASK}")
	private int Read = 500;// 心跳间隔，单位毫秒
	@Value("${WRITETASK}")
	private int Write = 1;// 心跳间隔，单位秒
	@Value("${JOBSIZE}")
	private int Size = 20;// 默认取出任务数量
	@Value("${READFAILEDSIZE}")
	private int FailedSize = 5;// 默认取出执行失败任务数量
	@Value("${RUNFAILEDCNT}")
	private int FailedCnt = 3;// 默认再执行的次数

	private final int[] EventRunAgain = { 105, 107 };
	private SimpleDateFormat sdf = null;
	private JobService job;
	private boolean stop = true;
	// private boolean busy = false;
	private int idleCnt = 0;
	private AtomicInteger aiThread = new AtomicInteger(0);

	private ScheduledExecutorService scheduler = Executors.newScheduledThreadPool(3);
	private ScheduledFuture<?>[] future = new ScheduledFuture<?>[3];

	private SocketThread socketThread;
	protected SocketTask socketTask;

	public int cmdRunCnt = 0;
	public int cmdRunFailedCnt = 0;
	public int cmdRunSuccessCnt = 0;

	public void StartService() {
		if (!stop)
			return;
		stop = false;
		int cnt = job.getDBDevice();// 从数据库获取锁的信息
		if (cnt == 0) {
			LOG.info("No registered devices");
			return;
		}
		LOG.info(String.format("Initializing devices cnt is %d", cnt));

		String threadName = "";
		LOG.info(String.format("Start SOCKET Thread"));
		socketTask = new SocketTask();
		threadName = "Haibei-elock-socket";// + System.identityHashCode(this);
		socketThread = new SocketThread(threadName);
		socketThread.start();

		future[0] = scheduler.scheduleWithFixedDelay(new ClientMsgTask(), 0, Read, TimeUnit.MILLISECONDS);
		LOG.info(String.format("Start READ Task"));

		future[1] = scheduler.scheduleWithFixedDelay(new WriteMsgTask(), 10, Write, TimeUnit.SECONDS);
		LOG.info(String.format("Start WRITE Task"));

		future[2] = scheduler.scheduleWithFixedDelay(new PulseCheckTask(), 1, Pulse, TimeUnit.MINUTES);
		LOG.info(String.format("Start PULSE Task"));
	}

	public void StopService() {
		stop = true;
	}

	@Autowired
	public SocketServer(JobServiceImpl j) {
		super();
		job = j;
		sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss,SSS");
	}

	private class SocketThread extends Thread {
		public SocketThread(String name) {
			super(name);
		}

		public void run() {
			socketTask.run();
		}
	}

	private class SocketTask implements Runnable {
		public void run() {
			Selector selector = null;
			try {
				selector = Selector.open();
			} catch (IOException e) {
				LOG.error(String.format("ERROR Selector.open", e.getMessage()));
				e.printStackTrace();
				return;
			}
			ServerSocketChannel server_scoket_hannel = null;
			try {
				server_scoket_hannel = ServerSocketChannel.open();
			} catch (IOException e) {
				LOG.error(String.format("ERROR ServerSocketChannel.open", e.getMessage()));
				e.printStackTrace();
				return;
			}
			try {
				server_scoket_hannel.socket().bind(new InetSocketAddress(ListenPort));
			} catch (IOException e) {
				LOG.error(String.format("ERROR ServerSocketChannel.socket().bind", e.getMessage()));
				e.printStackTrace();
				return;
			}
			try {
				server_scoket_hannel.configureBlocking(false);
			} catch (IOException e) {
				LOG.error(String.format("ERROR ServerSocketChannel.configureBlocking", e.getMessage()));
				e.printStackTrace();
				return;
			}
			try {
				server_scoket_hannel.register(selector, SelectionKey.OP_ACCEPT);
			} catch (ClosedChannelException e) {
				LOG.error(String.format("ERROR ServerSocketChannel.register", e.getMessage()));
				e.printStackTrace();
				return;
			}

			TCPProtocol protocol = new TCPProtocolImpl(BufferSize, job);

			while (!stop) {
				try {
					if (selector.select(LoopOut) == 0)
						continue;
				} catch (IOException e) {
					LOG.error(String.format("ERROR Selector.select", e.getMessage()));
					e.printStackTrace();
					continue;
				}

				Iterator<SelectionKey> keyIter = selector.selectedKeys().iterator();
				while (keyIter.hasNext()) {
					SelectionKey key = keyIter.next();
					keyIter.remove();
					try {
						if (key.isAcceptable()) {
							protocol.handleAccept(key);
						}
						if (key.isWritable()) {
							protocol.handleWrite(key);
						}
						if (key.isReadable()) {
							protocol.handleRead(key);
						}
					} catch (IOException e) {
						LOG.error(String.format("ERROR Selector.selectedKeys", e.getMessage()));
						e.printStackTrace();
						continue;
					}
				}
			}
			try {
				server_scoket_hannel.close();
				selector.close();
				job.closScoketConnection();
			} catch (IOException e) {
				LOG.error(String.format("ERROR close", e.getMessage()));
				e.printStackTrace();
			}
			try {
				scheduler.shutdown();
			} catch (Exception e) {
				LOG.error(String.format("ERROR shutdown", e.getMessage()));
				e.printStackTrace();
			}
			LOG.info("SOCKET Thread Stoped");
		}
	}

	private class ClientMsgTask implements Runnable {
		public void run() {
			try {
				LOG.info("Read cnt: " + job.getReadCnt() + "  Online cnt: " + job.getDeviceOnlineCnt());
				if (job.getReadCnt() > 0)
					job.dealRead();
			} catch (Exception e) {
				LOG.error("ClientMsgTask msg: " + e.getMessage());
				e.printStackTrace();
			}
		}
	}

	private class WriteMsgTask implements Runnable {
		public void run() {
			int wait_cnt = 0;
			int failed_cnt = 0;
			int send_cnt = 0;
			if (job == null)
				LOG.error("JOB is null");
			try {
				for (Job j : job.getJob()) {
					if (j.getSocket() == null || !j.getSocket().isOpen())
						continue;
					Device d = j.getDev();
					List<Cmd> list = job.getDeviceCmd(d.getDevId());
					if (list == null || list.size() == 0) {
						// 检查数据库是否有新命令
						List<Cmd> new_list = job.getDBDeviceCmd(d.getDevId(), Size);
						if (new_list == null || new_list.size() == 0) {
							continue;
						} else {
							LOG.info(String.format("Load cmd (%d) from DB for %s[%s]", new_list.size(), d.getDevName(), d.getDevIp()));
							job.setDeviceCmdById(d.getDevId(), new_list);
						}
					} else {
						LOG.info(String.format("Load cmd (%d) from MEM for %s[%s]", list.size(), d.getDevName(), d.getDevIp()));
					}
					if (d.isFinished()) {
						Cmd c = job.getDeviceCmdById(d.getDevId(), d.getIndex());
						if (c == null) {
							LOG.error(String.format("ERROR READY for write %s[%s] CMD ", d.getDevName(), d.getDevIp()));
							continue;
						}
						d.setFinished(false);
						// d.setDownload(sdf.format(new Date()));
						job.setDeviceCmdStart(d.getDevId(), d.getIndex(), System.currentTimeMillis());
						// LOG.info(String.format("READY for write %s[%s] CMD ",
						// d.getDevName(), d.getDevIp(), c.toString()));
						try {
							byte[] cmd = Tools.hexString2Bytes(c.getCmdCipher());
							ByteBuffer sendData = ByteBuffer.allocate(cmd.length);
							sendData.put(cmd);
							sendData.clear();
							while (sendData.hasRemaining())
								j.getSocket().write(sendData);
							send_cnt++;
							LOG.info(String.format("Write CMD for %s[%s] plain text [%s]", d.getDevName(), d.getDevIp(), c.getCmdPlain()));
						} catch (IOException e) {
							LOG.error(String.format("ERROR - Write CMD for %s[%s] msg %s", d.getDevName(), d.getDevIp(), e.getMessage()));
							e.printStackTrace();
						}
						if (c.getRtn() == null) {
							d.setFinished(true);
							c.setRtnPlain("FFFFFFFF");
							c.setRtnCipher("FFFFFFFF");
							c.setDownload(d.getDownload());
							c.setTimeCost(0L);
							c.setCmdFlag(1);
							job.saveCmdRtnByPk(c.getSeqNo(), "FFFFFFFF", "FFFFFFFF", 0L, d.getDownload(), 1, sdf.format(new Date()));
							job.removeDeviceCmdById(d.getDevId(), d.getIndex());
							job.saveCmd2Water(c);
						}
					} else {
						Long diff = System.currentTimeMillis() - job.getDeviceCmdById(d.getDevId(), d.getIndex()).getStart();
						LOG.info(String.format("CMD Waiting for return %s[%s](%d)", d.getDevName(), d.getDevIp(), diff));
						wait_cnt++;
						if (diff >= TimeOut) {
							// 命令返回超时
							d.setFinished(true);
							int failed = d.getFailed();
							d.setFailed(failed + 1);
							Cmd c = job.getDeviceCmdById(d.getDevId(), d.getIndex());
							job.removeDeviceCmdById(d.getDevId(), d.getIndex());
							job.saveCmdTimeOutByPk(c.getSeqNo(), 3, sdf.format(new Date()));
							c.setCmdFlag(3);
							job.saveCmd2Water(c);
							failed_cnt++;
						}
					}
				}
				LOG.info(String.format("Write Task Run Once. Send: %d, Waitting: %d, TimeOut: %d", send_cnt, wait_cnt, failed_cnt));
				if (send_cnt + wait_cnt + failed_cnt == 0) {
					idleCnt++;
				} else {
					idleCnt = 0;
				}
				// 如果空闲循环大于10次，则处理关于下发名单和下发开门密码的指令
				if (idleCnt > 10) {
					int update_failed_cnt = 0;
					for (Job j : job.getJob()) {
						if (j.getSocket() == null || !j.getSocket().isOpen())
							continue;
						update_failed_cnt += job.getDao().updateDeviceCmd4RunAgain(j.getDev().getDevId(), FailedSize, 3, FailedCnt, EventRunAgain);
					}
					LOG.info(String.format("Write Task Run Failed. Update: %d", update_failed_cnt));
				}
			} catch (Exception e) {
				LOG.error(String.format("ERROR WriteMsgTask", e.getMessage()));
				e.printStackTrace();
			}
		}
	}

	private class PulseCheckTask implements Runnable {
		public void run() {
			LOG.info(String.format("Check pulse，every %d minutes", Pulse));
			// 读取在线设备列表，主动发送心跳包
			for (Device d : job.getDao().queryDevice()) {
				for (Lock lock : job.getDao().queryLockByDevId(d.getDevId())) {
					// 先更新为不在线，再发送心跳
					switch (lock.getLockFlag()) {
					case 0:// 在线状态，更新为未知状态
						job.getDao().updateLockFlag(d.getDevId(), lock.getLockAddr(), 2);
						break;
					case 1:// 如果已经是离线状态，更新为离线状态
						job.getDao().updateLockFlag(d.getDevId(), lock.getLockAddr(), 1);
						break;
					case 2:// 未知状态，更新为离线状态
						job.getDao().updateLockFlag(d.getDevId(), lock.getLockAddr(), 1);
						break;
					default:

					}
					// job.sendLockPulse(lock.getLockId());
					// try {
					// Thread.sleep(2000);
					// } catch (InterruptedException e) {
					// e.printStackTrace();
					// }
				}
			}
		}
	}
}