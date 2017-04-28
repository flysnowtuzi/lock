package cn.com.haibei.service;

import java.io.IOException;
import java.sql.Timestamp;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.socket.CloseStatus;
import org.springframework.web.socket.TextMessage;
import org.springframework.web.socket.WebSocketHandler;
import org.springframework.web.socket.WebSocketMessage;
import org.springframework.web.socket.WebSocketSession;

public class WebsocketEndPoint implements WebSocketHandler {

	protected final Logger logger = LoggerFactory.getLogger(getClass());
	@Autowired
	private DaoDelegate dao;
	private static final ArrayList<WebSocketSession> users = new ArrayList<>();
	private static int onlineCount = 0;
	DateFormat sdf = new SimpleDateFormat("HH:mm:ss,SSS");
	private static Long timestamp = System.currentTimeMillis();

	// 初次链接成功执行
	@Override
	public void afterConnectionEstablished(WebSocketSession session) throws Exception {
		users.add(session);
		while (true) {
			StringBuffer bf = new StringBuffer();
			try {
				List<Map<String, String>> data = dao.queryLog(timestamp);
				if (data.size() == 0)
					continue;
				for (int i = 0; i < data.size(); i++) {
					Map<String, String> m = data.get(i);
					if (i == data.size() - 1)
						timestamp = Long.parseLong(m.get("TIME"));
					Timestamp ts = new Timestamp(Long.parseLong(m.get("TIME")));
					bf.append(sdf.format(ts));
					bf.append("&nbsp;[");
					bf.append(m.get("LEVEL"));
					bf.append("]&nbsp;");
					// bf.append(m.get("LOGGER"));
					bf.append("&nbsp;-&nbsp;");
					bf.append(m.get("MSG"));
					bf.append("<br/>");
				}
			} catch (Exception e1) {
				e1.printStackTrace();
			}
			for (WebSocketSession user : users) {
				try {
					if (user.isOpen()) {
						user.sendMessage(new TextMessage(bf.toString().getBytes()));
					}
				} catch (IOException e) {
					e.printStackTrace();
				}
			}
			try {
				Thread.sleep(5000);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
	}

	@Override
	public void handleMessage(WebSocketSession webSocketSession, WebSocketMessage<?> webSocketMessage) throws Exception {
		sendMessageToUsers(new TextMessage(webSocketMessage.getPayload() + ""));
	}

	@Override
	public void handleTransportError(WebSocketSession webSocketSession, Throwable throwable) throws Exception {
		if (webSocketSession.isOpen()) {
			webSocketSession.close();
		}
		logger.debug("链接出错，关闭链接......");
		users.remove(webSocketSession);
	}

	@Override
	public void afterConnectionClosed(WebSocketSession webSocketSession, CloseStatus closeStatus) throws Exception {
		logger.debug("链接关闭......" + closeStatus.toString());
		users.remove(webSocketSession);
	}

	@Override
	public boolean supportsPartialMessages() {
		return false;
	}

	public void sendMessageToUsers(TextMessage message) {
		for (WebSocketSession user : users) {
			try {
				if (user.isOpen()) {
					user.sendMessage(message);
				}
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
	}

	public void sendMessageToUser(String userName, TextMessage message) {
		for (WebSocketSession user : users) {
			try {
				if (user.isOpen()) {
					user.sendMessage(message);
				}
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
	}
}
