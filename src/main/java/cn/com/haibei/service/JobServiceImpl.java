package cn.com.haibei.service;

import java.io.IOException;
import java.nio.ByteBuffer;
import java.nio.channels.SocketChannel;
import java.sql.Timestamp;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.UUID;
import java.util.concurrent.CopyOnWriteArrayList;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import net.sf.json.JSONObject;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.client.RestClientException;
import org.springframework.web.client.RestTemplate;

import cn.com.haibei.bean.Cmd;
import cn.com.haibei.bean.Device;
import cn.com.haibei.bean.Job;
import cn.com.haibei.bean.Lock;
import cn.com.haibei.bean.User;
import cn.com.haibei.bean.Water;
import cn.com.haibei.device.DeviceProtocl;
import cn.com.haibei.tool.CoreException;
import cn.com.haibei.tool.TokenTools;
import cn.com.haibei.tool.Tools;

public class JobServiceImpl implements JobService {
	protected final String SYS_ID = "008";
	protected final String SYS_CERT = "YgzqwmEDoQXRJRLJtCOAg70mi72KEqiLEkjxBrolCuoUGclQeFb0Dk6aCewCpTj0Jwe0qJfOB5DsQaGbzeJvIAoUrkW8a6M6voRYu5UIyRtmYAQSBWZ9wIQqlOZ4KO";
	protected final Logger LOG = LoggerFactory.getLogger(getClass());
	@Value("${CMDSIZE}")
	private int size;// 一次取出指令的最大数量

	private SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss,SSS");

	private DaoDelegate dao;

	private Set<String> black;// 未注册IP

	private List<Job> job = new CopyOnWriteArrayList<Job>();

	private List<Map<String, Object>> read = new CopyOnWriteArrayList<Map<String, Object>>();

	private List<DeviceProtocl> protocl;

	public List<DeviceProtocl> getProtocl() {
		return protocl;
	}

	public void setProtocl(List<DeviceProtocl> protocl) {
		this.protocl = protocl;
	}

	@Autowired
	public JobServiceImpl(DaoDelegate d) {
		super();
		dao = d;
		black = new HashSet<String>();
	}

	public int getDBDevice() {
		List<Device> dev = dao.queryDevice();
		for (int i = 0; i < dev.size(); i++) {
			Job j = new Job();
			j.setDev(dev.get(i));
			j.setCmd(null);
			j.setSocket(null);
			job.add(j);
		}
		return dev.size();
	}

	public boolean checkBlack(String ip) {
		for (String s : black) {
			if (s.equals(ip))
				return true;
		}
		return false;
	}

	public boolean addBlack(String ip) {
		return black.add(ip);
	}

	public DaoDelegate getDao() {
		return dao;
	}

	public Device getDeviceByIp(String ip) {
		for (Job j : job) {
			Device d = j.getDev();
			if (d.getDevIp().equals(ip))
				return d;
		}
		return null;
	}

	public int getNewCmd(List<Job> job, int size) {
		return dao.queryNewCmd(job, size);
	}

	public Cmd getDeviceCmdById(String id, int index) {
		for (Job j : job) {
			Device d = j.getDev();
			if (d.getDevId().equals(id)) {
				if (null == j.getCmd() || j.getCmd().size() == 0)
					return null;
				else
					return j.getCmd().get(index);
			}
		}
		return null;
	}

	public int getDeviceCmdSizeById(String id) {
		for (Job j : job) {
			Device d = j.getDev();
			if (d.getDevId().equals(id)) {
				if (null == j.getCmd())
					return 0;
				else
					return j.getCmd().size();
			}
		}
		return 0;
	}

	public boolean removeDeviceCmdById(String id, int index) {
		for (Job j : job) {
			Device d = j.getDev();
			if (d.getDevId().equals(id)) {
				j.getCmd().remove(index);
				return true;
			}
		}
		return false;
	}

	public void saveCmdRtnByPk(String seq_no, String rtn_plain, String rtn_clipher, Long time_cost, String time_download, int cmd_flag,
			String time_return) {
		dao.saveCmdRtnByPk(seq_no, rtn_plain, rtn_clipher, time_cost, time_download, cmd_flag, time_return);
	}

	public void setDeviceOnlineFlag(String id, boolean flag) {
		for (Job j : job) {
			Device d = j.getDev();
			if (d.getDevId().equals(id)) {
				j.getDev().setOnline(flag);
				return;
			}
		}
	}

	public int getDeviceOnlineCnt() {
		int i = 0;
		for (Job j : job) {
			Device d = j.getDev();
			if (d.isOnline())
				i++;
		}
		return i;
	}

	public void setDeviceCmdById(String id, List<Cmd> cmd) {
		for (Job j : job) {
			Device d = j.getDev();
			if (d.getDevId().equals(id)) {
				j.setCmd(cmd);
				return;
			}
		}
	}

	public void setDeviceSocketChannel(String dev_id, SocketChannel socket) {
		for (Job j : job) {
			Device d = j.getDev();
			if (d.getDevId().equals(dev_id)) {
				if (j.getSocket() == null) {
					LOG.info(String.format("Online %s[%s]。", d.getDevName(), d.getDevIp()));
					j.setSocket(socket);
				} else {
					LOG.warn(String.format("Reonline %s[%s]。", d.getDevName(), d.getDevIp()));
					try {
						j.getSocket().close();
						j.setSocket(null);
					} catch (IOException e) {
						e.printStackTrace();
					}
					j.setSocket(socket);
				}
			}
		}
	}

	public List<Job> getJob() {
		return job;
	}

	public void pushSocketRead(String dev_ip, String msg, Long stamp) {
		Map<String, Object> m = new HashMap<String, Object>();
		m.put("IP", dev_ip);
		m.put("MSG", msg);
		m.put("STAMP", stamp);
		read.add(m);
	}

	public int getReadCnt() {
		return read.size();
	}

	public void dealRead() {
		for (Map<String, Object> map : read) {
			try {
				// System.out.println(map.toString());
				synchronized (map) {
					String ip = (String) map.get("IP");
					String read_cipher = (String) map.get("MSG");
					Long read_time = (Long) map.get("STAMP");
					Timestamp ts = new Timestamp(read_time);
					String return_time = sdf.format(ts);
					read.remove(map);
					Pattern pet;
					Matcher match;
					String read_plain = read_cipher;

					Device d = getDeviceByIp(ip);
					if (null == d)
						continue;
					if (d.getEncrypt() == 1) {// 需要解密
						try {
							read_plain = decryptCmdDecrypt(read_cipher, d.getDevType());
						} catch (Exception e) {
							e.printStackTrace();
							LOG.error(String.format("DECRYPT ERROR %s[%s], data %s", d.getDevName(), ip, read_cipher));
							break;
						}
					}
					// 处理客户端返回
					Map<String, Object> m = parsingCmd(read_plain, d);
					String lock_addr = (String) m.get("LOCK_ADDR");
					LOG.info(String.format("Read %s[%s] event id %s; data %s; lock address %s", d.getDevName(), ip, m.get("EVENT_ID"), read_plain,
							lock_addr));
					switch ((Integer) m.get("SUCCEED")) {
					case 1:// 成功
						switch ((Integer) m.get("PASSIVE")) {
						case 1:// 客户端主动发送事件
							if (m.get("CALL_BACK") != null) {
								String call_back_plain = (String) m.get("CALL_BACK");
								String call_back_cipher = encryptCmdEncrypt(call_back_plain, d.getDevType());
								if (null != call_back_cipher) {
									try {
										byte[] cmd = Tools.hexString2Bytes(call_back_cipher);
										ByteBuffer sendData = ByteBuffer.allocate(cmd.length);
										sendData.put(cmd);
										sendData.clear();
										while (sendData.hasRemaining())
											getJobByDevId(d.getDevId()).getSocket().write(sendData);
										LOG.info(String.format("CALLBACK %s[%s], data %s", d.getDevName(), ip, call_back_plain));
									} catch (IOException e) {
										LOG.error(String.format("ERROR CALLBACK %s[%s], data %s", d.getDevName(), ip, call_back_plain));
										e.printStackTrace();
									}
								}
							}
							// 心跳
							if ((Integer) m.get("EVENT_ID") == 0) {
								dao.updateLockFlag(d.getDevId(), lock_addr, 0);
							}
							// 忽略未注册事件
							if ((Integer) m.get("EVENT_ID") < 1)
								continue;

							Cmd water = new Cmd();
							water.setDevIp(d.getDevIp());
							water.setDevId(d.getDevId());
							Lock lock = getLockByDeviceIdLockAddr(d.getDevId(), lock_addr);
							if (null == lock) {
								LOG.error(String.format("ERROR DB data, device %s; lock addr %s", ip, lock_addr));
								continue;
							}
							water.setDevName(d.getDevName());
							water.setLockAddr(lock_addr);
							water.setLockId(lock.getLockId());
							water.setLockName(lock.getLockName());
							water.setRtnPlain(read_plain);
							water.setRtnCipher(read_cipher);
							water.setCmdFlag(1);
							water.setCmdStatus(1);
							water.setTimeCost(0L);
							water.setTimeCreate(sdf.format(new Date()));
							water.setEventId((Integer) m.get("EVENT_ID"));

							if (m.get("OPEN_TIME") != null)
								water.setTimeReturn((String) m.get("OPEN_TIME"));
							else
								water.setTimeReturn(sdf.format(new Date()));
							if (m.get("CARD_ID") != null)
								water.setCardPhyId((String) m.get("CARD_ID"));
							if (m.get("JSON") != null)
								water.setRtnJson((String) m.get("JSON"));
							saveCmd2Water(water);
							continue;
						case 0:// 被动事件，需要查看是否是等待命令的返回
							Cmd cmd = getDeviceCmdById(d.getDevId(), d.getIndex());
							if (!d.isFinished()) {
								pet = Pattern.compile(cmd.getRtn());
								match = pet.matcher(read_plain);
								if (match.matches()) {
									// 如果返回的是预期的数据
									cmd.setRtnPlain(read_plain);
									cmd.setRtnCipher(read_cipher);
									// cmd.setDownload(d.getDownload());
									cmd.setTimeCost(read_time - cmd.getStart());
									cmd.setCmdFlag(1);
									if (m.get("JSON") != null)
										cmd.setRtnJson((String) m.get("JSON"));

									if ((Integer) m.get("EVENT_ID") == 0) {// 主动检测心跳
										d.setOnline(true);
										// 更新数据状态
										dao.updateLockFlag(d.getDevId(), lock_addr, 0);
									}

									if ((Integer) m.get("EVENT_ID") == 105 || (Integer) m.get("EVENT_ID") == 107) {
										JSONObject json = JSONObject.fromObject(m.get("JSON"));
										String card_phy_id = json.getString("CARD_ID");
										cmd.setCardPhyId(card_phy_id);
									}
									removeDeviceCmdById(d.getDevId(), d.getIndex());
									getDeviceByIp(ip).setFinished(true);
									saveCmd2Water(cmd);
									saveCmdRtnByPk(cmd.getSeqNo(), read_plain, read_cipher, read_time - cmd.getStart(), cmd.getDownload(), 1,
											return_time);
									if (read_time - cmd.getStart() < 0) {
										LOG.error(String.format("%s: read_time %d, start_time %d ", cmd.getSeqNo(), read_time, cmd.getStart()));
									}
									LOG.info(String.format("Pattern success %s[%s] event id %s; pattern %s", d.getDevName(), ip, m.get("EVENT_ID"),
											cmd.getRtn()));
								} else {
									// 返回的不是预期的数据
									LOG.error(String.format("Pattern failed %s[%s] data %s; pattern %s", d.getDevName(), ip, read_plain, cmd.getRtn()));
								}
							} else {
								LOG.error(String.format("数据处理，设备：%s；读取的无法处理的数据：%s", ip, read_plain));
							}
						}
						break;
					case 0:// 失败
						LOG.error(String.format("失败事件，设备：%s；明文：%s；事件：%d", ip, read_plain, m.get("EVENT")));
						break;
					}
				}
			} catch (Exception e) {
				LOG.info(String.format("ERROR dealRead MAP %s", map.toString()));
				e.printStackTrace();
			}
		}
	}

	public void saveCmdTimeOutByPk(String seq_no, int cmd_flag, String time_return) {
		dao.saveCmdFlagByPk(seq_no, cmd_flag, time_return);
	}

	public String decryptCmdDecrypt(String s, int dev_type) {
		for (int i = 0; i < protocl.size(); i++) {
			DeviceProtocl p = protocl.get(i);
			if (p.getType() == dev_type)
				return p.decryptCmd(s);
		}
		return null;
	}

	public Map<String, Object> parsingCmd(String cmd, Device d) {
		for (int i = 0; i < protocl.size(); i++) {
			DeviceProtocl p = protocl.get(i);
			if (p.getType() == d.getDevType())
				return p.parsingCmd(cmd, d);
		}
		return null;
	}

	public String encryptCmdEncrypt(String s, int dev_type) {
		for (int i = 0; i < protocl.size(); i++) {
			DeviceProtocl p = protocl.get(i);
			if (p.getType() == dev_type)
				return p.encryptCmd(s);
		}
		return null;
	}

	public Lock getLockByDeviceIdLockAddr(String dev_id, String lock_addr) {
		return dao.queryLockByDeviceIdLockAddr(dev_id, lock_addr);
	}

	public String addLockUser(String lock_id, String identify, int type) throws CoreException {
		UUID uuid = UUID.randomUUID();
		Lock lock = dao.queryLockByPk(lock_id);
		if (null == lock)
			throw new CoreException(String.format("No Lock defined [%s]", lock_id));

		Device device = null;
		try {
			device = dao.queryDeviceById(lock.getDevId());
		} catch (Exception e) {
			e.printStackTrace();
		}
		if (null == device)
			throw new CoreException(String.format("No Lock defined [%s]", lock.getDevId()));

		DeviceProtocl protocl = getDeviceProtocl(device.getDevId());
		int addr = 0;
		// 查询此用户是否已存在
		User user = dao.queryLockUserByPk(lock_id, identify, type);
		String lock_user_seq = "";
		if (null == user) {
			// 查询到当前最大的addr或者查询到已经删除的用户地址
			List<User> user_del = dao.queryLockUserByStatus(lock_id, 2);
			if (user_del == null) {
				// 无失效用户，取出最大地址，并将存入数据库中，防止被占用
				User user_max = dao.queryLockUserMaxAddr(lock_id);
				if (null == user_max) {
					addr = protocl.getLockUserNextAddr(0);
				} else {
					addr = protocl.getLockUserNextAddr(user_max.getUserAddr());
					if (addr < 0)
						throw new CoreException(String.format("Lock Address %d", addr));
				}
				UUID uuid_user = UUID.randomUUID();
				User user_empty = new User();
				user_empty.setSeqNo(uuid_user.toString().replace("-", ""));
				user_empty.setLockId(lock_id);
				user_empty.setUserId(uuid.toString().substring(0, 10));
				user_empty.setUserName("00");
				user_empty.setCardPhyId(identify);
				user_empty.setUserAddr(addr);
				user_empty.setUserStatus(3);
				user_empty.setOpenType(type);
				lock_user_seq = user_empty.getSeqNo();
				dao.saveLockUser(user_empty);
			} else {
				// 有失效用户，取出第一个用户，更新状态为3，防止被其他人所用
				lock_user_seq = user_del.get(0).getSeqNo();
				dao.updateLockUserStatusBySeqNo(user_del.get(0).getSeqNo(), 3);
				addr = user_del.get(0).getUserAddr();
			}
		} else {
			lock_user_seq = user.getSeqNo();
			addr = user.getUserAddr();
		}
		// 生成命令
		String cmdPlain = protocl.addLockUser(lock.getLockAddr(), identify, type, 1, addr);
		String cmdCipher = protocl.encryptCmd(cmdPlain);
		Cmd cmd = new Cmd();
		cmd.setSeqNo(uuid.toString().replace("-", ""));
		cmd.setDevId(device.getDevId());
		cmd.setDevIp(device.getDevIp());
		cmd.setCmdCipher(cmdCipher);
		cmd.setCmdPlain(cmdPlain);
		cmd.setTimeCreate(sdf.format(new Date()));
		cmd.setLockAddr(lock.getLockAddr());
		cmd.setLockId(lock.getLockId());
		cmd.setLockName(lock.getLockName());
		cmd.setRtn(protocl.getCmdPattern(type == 1 ? 105 : 107, lock.getLockAddr()));
		cmd.setEventId(type == 1 ? 105 : 107);
		cmd.setLockUserSeqNo(lock_user_seq);
		dao.saveCmd(cmd);
		return cmd.getSeqNo();
	}

	public DeviceProtocl getDeviceProtocl(String dev_id) throws CoreException {
		Device device = null;
		try {
			device = dao.queryDeviceById(dev_id);
		} catch (Exception e) {
			e.printStackTrace();
		}
		if (null == device)
			throw new CoreException(String.format("No Lock defined [%s]", dev_id));
		for (int i = 0; i < protocl.size(); i++) {
			DeviceProtocl p = protocl.get(i);
			if (p.getType() == device.getDevType())
				return p;
		}
		return null;
	}

	public void setLockUserStatusBySeqNo(String seq_no, int status) {
		dao.updateLockUserStatusBySeqNo(seq_no, status);
	}

	public String getLockTime(String lock_id) throws CoreException {
		UUID uuid = UUID.randomUUID();
		Lock lock = dao.queryLockByPk(lock_id);
		if (null == lock)
			throw new CoreException(String.format("No Lock defined [%s]", lock_id));

		Device device = null;
		try {
			device = dao.queryDeviceById(lock.getDevId());
		} catch (Exception e) {
			e.printStackTrace();
		}
		if (null == device)
			throw new CoreException(String.format("No Lock defined [%s]", lock.getDevId()));

		DeviceProtocl protocl = getDeviceProtocl(device.getDevId());

		// 生成命令
		String cmdPlain = protocl.getLockLocalTime(lock.getLockAddr());
		String cmdCipher = protocl.encryptCmd(cmdPlain);
		Cmd cmd = new Cmd();
		cmd.setSeqNo(uuid.toString().replace("-", ""));
		cmd.setDevId(device.getDevId());
		cmd.setDevIp(device.getDevIp());
		cmd.setCmdCipher(cmdCipher);
		cmd.setCmdPlain(cmdPlain);
		cmd.setLockAddr(lock.getLockAddr());
		cmd.setLockId(lock.getLockId());
		cmd.setLockName(lock.getLockName());
		cmd.setTimeCreate(sdf.format(new Date()));
		cmd.setRtn(protocl.getCmdPattern(1, lock.getLockAddr()));
		cmd.setEventId(1);
		dao.saveCmd(cmd);
		return cmd.getSeqNo();
	}

	public String setLockTime(String lock_id) throws CoreException {
		UUID uuid = UUID.randomUUID();
		Lock lock = dao.queryLockByPk(lock_id);
		if (null == lock)
			throw new CoreException(String.format("No Lock defined [%s]", lock_id));

		Device device = null;
		try {
			device = dao.queryDeviceById(lock.getDevId());
		} catch (Exception e) {
			e.printStackTrace();
		}
		if (null == device)
			throw new CoreException(String.format("No Lock defined [%s]", lock.getDevId()));

		DeviceProtocl protocl = getDeviceProtocl(device.getDevId());

		// 生成命令
		String cmdPlain = protocl.setLockLocalTime(lock.getLockAddr());
		String cmdCipher = protocl.encryptCmd(cmdPlain);
		Cmd cmd = new Cmd();
		cmd.setSeqNo(uuid.toString().replace("-", ""));
		cmd.setDevId(device.getDevId());
		cmd.setDevIp(device.getDevIp());
		cmd.setCmdCipher(cmdCipher);
		cmd.setCmdPlain(cmdPlain);
		cmd.setLockAddr(lock.getLockAddr());
		cmd.setLockId(lock.getLockId());
		cmd.setLockName(lock.getLockName());
		cmd.setRtn(protocl.getCmdPattern(2, lock.getLockAddr()));
		cmd.setEventId(2);
		cmd.setTimeCreate(sdf.format(new Date()));
		dao.saveCmd(cmd);
		return cmd.getSeqNo();
	}

	public String removeLockUser(String lock_id, String identify, int type) throws CoreException {
		UUID uuid = UUID.randomUUID();
		Lock lock = dao.queryLockByPk(lock_id);
		if (null == lock)
			throw new CoreException(String.format("No Lock defined [%s]", lock_id));

		Device device = null;
		try {
			device = dao.queryDeviceById(lock.getDevId());
		} catch (Exception e) {
			e.printStackTrace();
		}
		if (null == device)
			throw new CoreException(String.format("No Lock defined [%s]", lock.getDevId()));

		DeviceProtocl protocl = getDeviceProtocl(device.getDevId());
		// 查询此用户是否已存在
		User user = dao.queryLockUserByPk(lock_id, identify, type);
		if (null == user) {
			return null;
		}
		// 生成命令
		String cmdPlain = protocl.delLockUser(lock.getLockAddr(), user.getUserAddr(), identify, type);
		String cmdCipher = protocl.encryptCmd(cmdPlain);
		Cmd cmd = new Cmd();
		cmd.setSeqNo(uuid.toString().replace("-", ""));
		cmd.setDevId(device.getDevId());
		cmd.setDevIp(device.getDevIp());
		cmd.setCmdCipher(cmdCipher);
		cmd.setCmdPlain(cmdPlain);
		cmd.setLockAddr(lock.getLockAddr());
		cmd.setLockId(lock.getLockId());
		cmd.setLockName(lock.getLockName());
		cmd.setRtn(protocl.getCmdPattern(103, lock.getLockAddr()));
		cmd.setEventId(103);
		cmd.setTimeCreate(sdf.format(new Date()));
		cmd.setLockUserSeqNo(user.getSeqNo());
		dao.saveCmd(cmd);
		return cmd.getSeqNo();
	}

	public void closScoketConnection() {
		for (Job j : job) {
			Device d = j.getDev();
			try {
				if (j.getSocket() != null) {
					LOG.info(String.format("Close client connection, %s[%s]", d.getDevName(), d.getDevIp()));
					j.getSocket().close();
					j.setSocket(null);
				}
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
		job.clear();
		read.clear();
	}

	public Job getJobByDevId(String dev_id) {
		for (Job j : job) {
			Device d = j.getDev();
			if (d.getDevId().equals(dev_id)) {
				return j;
			}
		}
		return null;
	}

	public String removeLockUserByPk(String seq_no) throws CoreException {
		UUID uuid = UUID.randomUUID();
		User user = dao.queryLockUserBySeqNo(seq_no);
		if (null == user)
			throw new CoreException(String.format("No User defined [%s]", seq_no));

		Lock lock = dao.queryLockByPk(user.getLockId());
		if (null == lock)
			throw new CoreException(String.format("No Lock defined [%s]", user.getLockId()));

		DeviceProtocl protocl = getDeviceProtocl(lock.getDevId());

		// 生成命令
		String cmdPlain = protocl.delLockUser(lock.getLockAddr(), user.getUserAddr(), user.getCardPhyId(), user.getOpenType());
		String cmdCipher = protocl.encryptCmd(cmdPlain);
		Cmd cmd = new Cmd();
		cmd.setSeqNo(uuid.toString().replace("-", ""));
		cmd.setDevId(lock.getDevId());
		cmd.setDevIp(lock.getDevIp());
		cmd.setCmdCipher(cmdCipher);
		cmd.setCmdPlain(cmdPlain);
		cmd.setLockAddr(lock.getLockAddr());
		cmd.setLockId(lock.getLockId());
		cmd.setLockName(lock.getLockName());
		cmd.setRtn(protocl.getCmdPattern(103, lock.getLockAddr()));
		cmd.setEventId(103);
		cmd.setTimeCreate(sdf.format(new Date()));
		cmd.setLockUserSeqNo(user.getSeqNo());
		dao.saveCmd(cmd);
		return cmd.getSeqNo();
	}

	public String removeLockUserByPk(String lock_id, String user_id) throws CoreException {
		return null;
	}

	public String remoteOpenLock(String lock_id, String identify) throws CoreException {
		UUID uuid = UUID.randomUUID();
		Lock lock = dao.queryLockByPk(lock_id);
		if (null == lock)
			throw new CoreException(String.format("No Lock defined [%s]", lock_id));
		Device device = null;
		try {
			device = dao.queryDeviceById(lock.getDevId());
		} catch (Exception e) {
			e.printStackTrace();
		}
		if (null == device)
			throw new CoreException(String.format("No Lock defined [%s]", lock.getDevId()));
		DeviceProtocl protocl = getDeviceProtocl(lock.getDevId());

		// 生成命令
		String cmdPlain = protocl.remoteOpenLock(lock.getLockAddr(), identify);
		String cmdCipher = protocl.encryptCmd(cmdPlain);
		Cmd cmd = new Cmd();
		cmd.setSeqNo(uuid.toString().replace("-", ""));
		cmd.setDevId(lock.getDevId());
		cmd.setDevIp(device.getDevIp());
		cmd.setCmdCipher(cmdCipher);
		cmd.setCmdPlain(cmdPlain);
		cmd.setLockAddr(lock.getLockAddr());
		cmd.setLockId(lock.getLockId());
		cmd.setLockName(lock.getLockName());
		cmd.setRtn(null);
		cmd.setTimeCreate(sdf.format(new Date()));
		cmd.setEventId(10);
		cmd.setLockUserSeqNo(null);
		dao.saveCmd(cmd);
		return cmd.getSeqNo();
	}

	@Override
	public void setDeviceReadCmdFromDb(String dev_id, Integer flag) {
		for (Job j : job) {
			Device d = j.getDev();
			if (d.getDevId().equals(dev_id))
				synchronized (d.getReadCmdFromDbFlag()) {
					d.setReadCmdFromDbFlag(flag);
					return;
				}
		}
	}

	@Override
	public String sendLockPulse(String lock_id) throws CoreException {
		UUID uuid = UUID.randomUUID();

		Lock lock = dao.queryLockByPk(lock_id);
		if (null == lock)
			throw new CoreException(String.format("No Lock defined [%s]", lock_id));
		Device device = null;
		try {
			device = dao.queryDeviceById(lock.getDevId());
		} catch (Exception e) {
			e.printStackTrace();
		}
		if (null == device)
			throw new CoreException(String.format("No Lock defined [%s]", lock.getDevId()));
		DeviceProtocl protocl = getDeviceProtocl(lock.getDevId());

		// 生成命令
		String cmdPlain = protocl.getLockPulse(lock.getLockAddr());
		String cmdCipher = protocl.encryptCmd(cmdPlain);
		Cmd cmd = new Cmd();
		cmd.setSeqNo(uuid.toString().replace("-", ""));
		cmd.setDevId(lock.getDevId());
		cmd.setDevIp(device.getDevIp());
		cmd.setCmdCipher(cmdCipher);
		cmd.setCmdPlain(cmdPlain);
		cmd.setLockAddr(lock.getLockAddr());
		cmd.setLockId(lock.getLockId());
		cmd.setLockName(lock.getLockName());
		cmd.setRtn(protocl.getCmdPattern(0, lock_id));
		cmd.setEventId(0);
		cmd.setTimeCreate(sdf.format(new Date()));
		dao.saveCmd(cmd);
		return cmd.getSeqNo();
	}

	@Override
	public List<Cmd> getDeviceCmd(String dev_id) {
		for (Job j : job) {
			Device d = j.getDev();
			if (d.getDevId().equals(dev_id)) {
				return j.getCmd();
			}
		}
		return null;
	}

	@Override
	public List<Cmd> getDBDeviceCmd(String dev_id, int size) {
		return dao.queryCmdByDevId(dev_id, size);
	}

	@Override
	public void saveCmd2Water(Cmd c) {
		String rtnData = c.getRtnPlain();// 返回的数据，用16进制存储
		String rtnJson = c.getRtnJson();// 返回的数据，用json存储
		Water w = new Water();
		w.setUserId("00000000");
		w.setUserName("N/A");
		w.setDeptId("000000");
		w.setDeptName("N/A");
		if (c.getEventId() == 901) {
			String stamp = String.valueOf(System.currentTimeMillis());
			String[] hex_card_phy_id = Tools.hexString2Array(c.getCardPhyId());
			Long long_card_phy_id = Long.parseLong(Tools.hexStringArray2String(hex_card_phy_id, true), 16);
			String[] param = { SYS_ID, String.valueOf(long_card_phy_id), stamp };
			String url = "http://202.118.89.14/service/000107?sysid=" + SYS_ID + "&cardphyid=" + String.valueOf(long_card_phy_id) + "&stamp=" + stamp
					+ "&token=" + TokenTools.genSHA1Token(param, SYS_CERT);
			// System.out.println(url);
			RestTemplate restTemplate = new RestTemplate();
			try {
				String json_user = restTemplate.getForObject(url, String.class);
				System.out.println("901------" + json_user);
				JSONObject obj = JSONObject.fromObject(json_user);
				Integer code = obj.getInt("code");
				if (code == 0) {
					JSONObject json_user_data = obj.getJSONObject("data");
					w.setUserId(json_user_data.getString("sno"));
					w.setUserName(json_user_data.getString("name"));
					w.setDeptId(json_user_data.getString("deptcode"));
					w.setDeptName(json_user_data.getString("deptname"));
				} else {
					LOG.error(String.format("Get User Infor(901) [%s], JSON: %s", c.getCardPhyId(), json_user));
				}
			} catch (RestClientException e) {
				LOG.error(String.format("Get User Infor(901) [%s], MSG: %s", c.getCardPhyId(), e.getMessage()));
				e.printStackTrace();
			}
		}
		if (c.getEventId() == 105) {
			try {
				User lock_user = dao.queryLockUserBySeqNo(c.getLockUserSeqNo());
				String card_phy_id = c.getCardPhyId();
				lock_user.setUserStatus(0);
				String stamp = String.valueOf(System.currentTimeMillis());
				String[] hex_card_phy_id = Tools.hexString2Array(card_phy_id);
				Long long_card_phy_id = Long.parseLong(Tools.hexStringArray2String(hex_card_phy_id, true), 16);
				String[] param = { SYS_ID, String.valueOf(long_card_phy_id), stamp };
				String url = "http://202.118.89.14/service/000107?sysid=" + SYS_ID + "&cardphyid=" + String.valueOf(long_card_phy_id) + "&stamp="
						+ stamp + "&token=" + TokenTools.genSHA1Token(param, SYS_CERT);
				RestTemplate restTemplate = new RestTemplate();
				String json_user = restTemplate.getForObject(url, String.class);
				JSONObject obj = JSONObject.fromObject(json_user);
				System.out.println("105-----" + json_user);
				Integer code = obj.getInt("code");
				if (code == 0) {
					JSONObject json_user_data = obj.getJSONObject("data");
					lock_user.setUserId(json_user_data.getString("sno"));
					lock_user.setUserName(json_user_data.getString("name"));
					lock_user.setDeptId(json_user_data.getString("deptcode"));
					lock_user.setDeptName(json_user_data.getString("deptname"));
				} else {
					lock_user.setUserId(card_phy_id);
					lock_user.setUserName(card_phy_id);
					LOG.error(String.format("Get User Infor(105) [%s], JSON: %s", c.getCardPhyId(), json_user));
				}

				lock_user.setCardPhyId(card_phy_id);
				lock_user.setUserAddr(lock_user.getUserAddr());
				c.setCardPhyId(card_phy_id);
				dao.updateLockUser(lock_user);
			} catch (Exception e) {
				LOG.error(String.format("Get User Infor(105) [%s], MSG: %s", c.getCardPhyId(), e.getMessage()));
				e.printStackTrace();
			}
		}
		w.setDevId(c.getDevId());
		w.setDevIp(c.getDevIp());
		w.setDevName(c.getDevName());
		w.setCmdNo(c.getSeqNo());
		w.setCardPhyId(c.getCardPhyId());
		w.setEventId(c.getEventId());
		w.setRtnFlag(c.getCmdFlag());
		w.setRtnData(rtnData);
		w.setRtnJson(rtnJson);
		w.setLockId(c.getLockId());
		w.setLockName(c.getLockName());
		w.setTimeCreate(c.getTimeCreate());
		w.setTimeReturn(c.getTimeReturn());
		try {
			dao.saveWater(w);
		} catch (Exception e) {
			LOG.error(String.format("Save Water [%s], MSG: %s", c.toString(), e.getMessage()));
			e.printStackTrace();
		}
	}

	@Override
	public boolean setDeviceCmdStart(String id, int index, Long start) {
		for (Job j : job) {
			Device d = j.getDev();
			if (d.getDevId().equals(id)) {
				if (null == j.getCmd() || j.getCmd().size() == 0) {
					return false;
				} else {
					j.getCmd().get(index).setStart(start);
					j.getCmd().get(index).setDownload(sdf.format(new Date()));
					return true;
				}
			}
		}
		return false;
	}

	@Override
	public List<Cmd> getDBDeviceCmdByFlag(String dev_id, int size, int flag) {
		return dao.queryCmdByDevId(dev_id, size);
	}
}
