package cn.com.haibei.service;

import java.io.IOException;
import java.nio.channels.SelectionKey;
import java.nio.channels.SocketChannel;

public interface TCPProtocol {
	/**
	 * 接收一个SocketChannel的处理
	 * 
	 * @param key
	 * @throws IOException
	 */
	public void handleAccept(SelectionKey key) throws IOException;

	/**
	 * 从一个SocketChannel读取信息的处理
	 * 
	 * @param key
	 * @throws IOException
	 */
	void handleRead(SelectionKey key);

	/**
	 * 向一个SocketChannel写入信息的处理
	 * 
	 * @param key
	 * @throws IOException
	 */
	void handleWrite(SelectionKey key) throws IOException;

	void writeCMD(SocketChannel sock, byte[] cmd) throws IOException;
}
