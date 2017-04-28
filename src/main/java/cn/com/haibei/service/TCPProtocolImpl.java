package cn.com.haibei.service;

import java.io.IOException;
import java.nio.ByteBuffer;
import java.nio.CharBuffer;
import java.nio.channels.SelectionKey;
import java.nio.channels.ServerSocketChannel;
import java.nio.channels.SocketChannel;
import java.nio.charset.Charset;
import java.nio.charset.CharsetDecoder;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import cn.com.haibei.bean.Device;
import cn.com.haibei.bean.Lock;
import cn.com.haibei.tool.Tools;

public class TCPProtocolImpl implements TCPProtocol {
	protected final Logger LOG = LoggerFactory.getLogger(getClass());
	ByteBuffer sendData;
	ByteBuffer readData = ByteBuffer.allocate(1024);
	CharBuffer charData = CharBuffer.allocate(1024);
	Charset iso = Charset.forName("ISO-8859-1");
	CharsetDecoder decoder = iso.newDecoder();
	private int bufferSize;
	private JobService job;

	public TCPProtocolImpl(int bufferSize, JobService j) {
		this.bufferSize = bufferSize;
		job = j;
	}

	public void handleAccept(SelectionKey key) throws IOException {
		boolean accept = false;
		SocketChannel client = ((ServerSocketChannel) key.channel()).accept();
		String client_ip = client.getRemoteAddress().toString();
		client_ip = Tools.getIp(client_ip);
		// 检查是否在黑名单中
		if (job.checkBlack(client_ip))
			return;

		// 检查是否是注册的设备
		Device d = job.getDeviceByIp(client_ip);
		if (d == null) {
			// 写入黑名单
			job.addBlack(client_ip);
		} else {
			// 修改注册的设备的状态，并重新获取命令列表
			job.setDeviceOnlineFlag(d.getDevId(), true);
			job.setDeviceSocketChannel(d.getDevId(), client);
			accept = true;
		}

		if (accept) {
			client.configureBlocking(false);
			client.register(key.selector(), SelectionKey.OP_READ, ByteBuffer.allocate(bufferSize));
			// 同步时间
			List<Lock> lock = job.getDao().queryLockByDevId(d.getDevId());
			if (lock == null || lock.size() == 0)
				return;
			for (int i = 0; i < lock.size(); i++)
				job.setLockTime(lock.get(i).getLockId());
		}
	}

	public void handleRead(SelectionKey key) {
		String read = "";
		SocketChannel clientChannel;
		try {
			clientChannel = (SocketChannel) key.channel();
		} catch (Exception e) {
			LOG.error(String.format("Read Msg: %s", e.getMessage()));
			return;
		}
		String ip = null;
		try {
			ip = clientChannel.getRemoteAddress().toString();
		} catch (IOException e) {
			LOG.error(String.format("Read Msg: %s", e.getMessage()));
			return;
		}
		if (ip == null)
			return;
		// 读取信息获得读取的字节数
		long bytesRead = 0;
		try {
			bytesRead = clientChannel.read(readData);
		} catch (IOException e) {
			LOG.error(String.format("Read %s Msg: %s", ip, e.getMessage()));
			return;
		}
		if (bytesRead == -1) {
			// 没有读取到内容的情况
			try {
				clientChannel.close();
			} catch (IOException e) {
				LOG.error(String.format("Read %s Msg: %s", ip, e.getMessage()));
			}
			return;
		} else {
			readData.flip();
			byte b[] = readData.array();
			StringBuffer bf = new StringBuffer();
			for (int i = 0; i < bytesRead; i++)
				bf.append(Tools.byte2HexString(b[i]));
			read = bf.toString();
			readData.clear();
			charData.clear();
		}
		ip = Tools.getIp(ip);
		job.pushSocketRead(ip, read, System.currentTimeMillis());

	}

	public void handleWrite(SelectionKey key) throws IOException {
		SocketChannel sock = (SocketChannel) key.channel();
		byte[] cmd = { 0x02, 0x02, 0x03, (byte) 0x80, (byte) 0x90, 0x61, 0x0d };
		sendData = ByteBuffer.allocate(cmd.length);
		sendData.put(cmd);
		sendData.clear();
		while (sendData.hasRemaining())
			sock.write(sendData);
	}

	public void writeCMD(SocketChannel sock, byte[] cmd) throws IOException {
		// System.out.println(Tools.byte2HexString(cmd));
		sendData = ByteBuffer.allocate(cmd.length);
		sendData.put(cmd);
		sendData.clear();
		while (sendData.hasRemaining())
			sock.write(sendData);
	}
}