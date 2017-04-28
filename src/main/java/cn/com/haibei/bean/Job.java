package cn.com.haibei.bean;

import java.nio.channels.SocketChannel;
import java.util.ArrayList;
import java.util.List;

public class Job {

	private Device dev;
		
	private List<Cmd> cmd = new ArrayList<Cmd>();

	private SocketChannel socket;

	public SocketChannel getSocket() {
		return socket;
	}

	public void setSocket(SocketChannel socket) {
		this.socket = socket;
	}

	public Device getDev() {
		return dev;
	}

	public void setDev(Device dev) {
		this.dev = dev;
	}

	public List<Cmd> getCmd() {
		return cmd;
	}

	public void setCmd(List<Cmd> cmd) {
		this.cmd = cmd;
	}

}
