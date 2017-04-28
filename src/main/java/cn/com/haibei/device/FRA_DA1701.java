package cn.com.haibei.device;

import java.util.HashMap;
import java.util.Map;

import net.sf.json.JSONObject;

import org.springframework.beans.factory.annotation.Autowired;

import cn.com.haibei.bean.Device;
import cn.com.haibei.service.DaoDelegate;
import cn.com.haibei.tool.Tools;

public class FRA_DA1701 implements DeviceProtocl {
	protected final String key = "603deb1015ca71be2b73aef0857d7781";
	private int type;
	private DaoDelegate dao;

	@Autowired
	public FRA_DA1701(DaoDelegate dao) {
		super();
		this.dao = dao;
	}

	public int getType() {
		return type;
	}

	public void setType(int type) {
		this.type = type;
	}

	private String fillStringWithFF(String s, int len) {
		StringBuffer bf = new StringBuffer();
		for (int i = 0; i < len; i++) {
			bf.append("ff");
		}
		return bf.toString();
	}

	public Map<String, Object> parsingCmd(String s, Device d) {
		// Map<String, Object> m = new HashMap<String, Object>();
		Map<String, Object> rtn = new HashMap<String, Object>();
		JSONObject json = null;
		// String project = s.substring(0, 4);
		String lock_addr = s.substring(4, 12);
		String rw = s.substring(12, 14);
		String cmd = s.substring(14, 18);
		String data = s.substring(18, s.length() - 2);
		String crc = s.substring(s.length() - 2, s.length());
		// System.out.println(crc);
		// System.out.println(s.substring(0, s.length() - 2));
		String crc_cal = Tools.byte2HexString(Tools.calcCrc8(Tools.hexString2Bytes(s.substring(0, s.length() - 2))));
		// System.out.println(crc_cal);
		if (!crc.equalsIgnoreCase(crc_cal)) {
			rtn.put("SUCCEED", 0);
			rtn.put("ERROR", "CRC校验错误" + crc_cal);
			return rtn;
		}
		rtn.put("LOCK_ADDR", lock_addr);

		switch (Integer.valueOf(cmd, 16)) {
		case 0x00: // 时间
			// 000100000001010000110302100e23ffffffffffffffffffffffffffffffff61
			rtn.put("PASSIVE", 0);// 被动事件
			switch (Integer.valueOf(rw, 16)) {
			case 0x01:// 读
				rtn.put("EVENT_ID", 1);
				rtn.put("SUCCEED", 1);
				data = data.substring(0, 12);// 读取的时间
				String[] lock_time = Tools.hexString2Array(data);
				String time = "20" + String.format("%1$02d", Integer.valueOf(lock_time[0], 16)) + "-"
						+ String.format("%1$02d", Integer.valueOf(lock_time[1], 16)) + "-"
						+ String.format("%1$02d", Integer.valueOf(lock_time[2], 16)) + " "
						+ String.format("%1$02d", Integer.valueOf(lock_time[3], 16)) + ":"
						+ String.format("%1$02d", Integer.valueOf(lock_time[4], 16)) + ":"
						+ String.format("%1$02d", Integer.valueOf(lock_time[5], 16));
				rtn.put("LOCK_TIME", time);
				json = JSONObject.fromObject(rtn);
				rtn.put("JSON", json.toString());
				return rtn;
			case 0x02:// 写
				rtn.put("EVENT_ID", 2);
				rtn.put("SUCCEED", 1);
				return rtn;
			default:
				rtn.put("SUCCEED", 0);
				rtn.put("ERROR", "读写标识位错误" + rw);
				return rtn;
			}
		case 0x01: // 开门记录
			// 0001-00000001-01-0001-c62d1d25-02-110302103709-00000003-ffffffffffffff-67
			rtn.put("PASSIVE", 1);// 被动事件
			String phy_id_01 = data.substring(0, 8);
			String open_type_01 = data.substring(8, 10);
			String open_time_01 = data.substring(10, 22);
			String record_num_01 = data.substring(22, 30);
			if (Integer.valueOf(rw, 16) != 0x01) {
				rtn.put("SUCCEED", 0);
				rtn.put("ERROR", "读写标识位错误(0x" + rw + ")");
				return rtn;
			}
			if (phy_id_01.equalsIgnoreCase("ffffffff")) {
				rtn.put("SUCCEED", 0);
				rtn.put("ERROR", "没有新的开门记录了(0x" + phy_id_01 + ")");
				return rtn;
			}
			switch (Integer.valueOf(open_type_01, 16)) {
			case 0x02:
				rtn.put("EVENT_ID", 901);
				break;
			case 0x04:
				rtn.put("EVENT_ID", 903);
				break;
			default:
				rtn.put("EVENT_ID", 901);
				rtn.put("SUCCEED", 0);
				rtn.put("ERROR", "开门方式错误(0x" + rw + ")");
				return rtn;
			}

			rtn.put("SUCCEED", 1);
			String[] lock_time_01 = Tools.hexString2Array(open_time_01);
			String time_01 = "20" + String.format("%1$02d", Integer.valueOf(lock_time_01[0], 16)) + "-"
					+ String.format("%1$02d", Integer.valueOf(lock_time_01[1], 16)) + "-"
					+ String.format("%1$02d", Integer.valueOf(lock_time_01[2], 16)) + " "
					+ String.format("%1$02d", Integer.valueOf(lock_time_01[3], 16)) + ":"
					+ String.format("%1$02d", Integer.valueOf(lock_time_01[4], 16)) + ":"
					+ String.format("%1$02d", Integer.valueOf(lock_time_01[5], 16));
			rtn.put("OPEN_TIME", time_01);
			rtn.put("CARD_ID", phy_id_01);
			rtn.put("RECORD_NUM", record_num_01);
			json = JSONObject.fromObject(rtn);
			rtn.put("JSON", json.toString());
			rtn.put("CALL_BACK", getWater(lock_addr, record_num_01));
			try {
				dao.updateLockWaterNo(d.getDevId(), record_num_01, lock_addr);
			} catch (Exception e) {
				e.printStackTrace();
			}
			return rtn;
		case 0x02: // 远程开锁
			rtn.put("SUCCEED", 0);
			rtn.put("ERROR", "命令错误(0x" + cmd + ")");
			json = JSONObject.fromObject(rtn);
			rtn.put("JSON", json.toString());
			return rtn;
		case 0x03: // 开锁事件
			// 0001-00000001-01-0003-c62d1d25-04-110302113321-ffffffffffffffffffffff-39
			rtn.put("SUCCEED", 1);
			rtn.put("EVENT_ID", -1);
			String water_no = dao.queryLockWaterNoByDeviceIdLockAddr(d.getDevId(), lock_addr);
			if (null == water_no)
				water_no = "00000000";
			rtn.put("CALL_BACK", getWater(lock_addr, water_no));
			rtn.put("PASSIVE", 1);// 主动事件
			json = JSONObject.fromObject(rtn);
			rtn.put("JSON", json.toString());
			return rtn;
		case 0x1b:// 非白名单刷卡
			// 0001-00000001-01-001b-666ef976-02-1103020a2215-00000003ffffffffffffff-96
			rtn.put("PASSIVE", 1);// 主动事件
			String phy_id_1b = data.substring(0, 8);
			// String open_type_1b = data.substring(8, 10);
			String open_time_1b = data.substring(10, 22);
			if (Integer.valueOf(rw, 16) != 0x01) {
				rtn.put("ERROR", "读写标识位错误(0x" + rw + ")");
				rtn.put("SUCCEED", 0);
				return rtn;
			}
			rtn.put("EVENT_ID", 999);
			rtn.put("SUCCEED", 1);

			String[] lock_time_1b = Tools.hexString2Array(open_time_1b);
			String time_1b = "20" + String.format("%1$02d", Integer.valueOf(lock_time_1b[0], 16)) + "-"
					+ String.format("%1$02d", Integer.valueOf(lock_time_1b[1], 16)) + "-"
					+ String.format("%1$02d", Integer.valueOf(lock_time_1b[2], 16)) + " "
					+ String.format("%1$02d", Integer.valueOf(lock_time_1b[3], 16)) + ":"
					+ String.format("%1$02d", Integer.valueOf(lock_time_1b[4], 16)) + ":"
					+ String.format("%1$02d", Integer.valueOf(lock_time_1b[5], 16));
			rtn.put("OPEN_TIME", time_1b);
			rtn.put("CARD_ID", phy_id_1b);
			json = JSONObject.fromObject(rtn);
			rtn.put("JSON", json.toString());
			return rtn;
		case 0x1c: // 外部复位标识
			// 0001-00000001-01-0003-c62d1d25-04-110302113321-ffffffffffffffffffffff-39
			rtn.put("SUCCEED", 1);
			rtn.put("CALL_BACK", "");
			return rtn;
		case 0x1d: // 心跳检测
			// 0001-00000001-01-0003-c62d1d25-04-110302113321-ffffffffffffffffffffff-39
			rtn.put("EVENT_ID", 0);
			rtn.put("SUCCEED", 1);
			switch (Integer.valueOf(rw, 16)) {
			case 0x01:// 用户主动发送的心跳请求
				rtn.put("PASSIVE", 0);
				break;
			case 0x02:// 设备主动发送的心跳请求
				rtn.put("PASSIVE", 1);
				break;
			default:
				rtn.put("SUCCEED", 0);
				rtn.put("ERROR", "读写标识位错误" + rw);
			}
			json = JSONObject.fromObject(rtn);
			rtn.put("JSON", json.toString());
			return rtn;
		case 0x1e: // 清空所有用户数据
			// 0001-00000001-01-0003-c62d1d25-04-110302113321-ffffffffffffffffffffff-39
			rtn.put("SUCCEED", 1);
			rtn.put("CALL_BACK", "");
			return rtn;
		case 0x1f: // 重启
			// 0001-00000001-01-0003-c62d1d25-04-110302113321-ffffffffffffffffffffff-39
			rtn.put("SUCCEED", 1);
			rtn.put("CALL_BACK", "");
			return rtn;
		default:
			if (Integer.valueOf(cmd, 16) >= 0x20 && Integer.valueOf(cmd, 16) <= 0x7F) {
				// 写卡用户
				rtn.put("PASSIVE", 0);// 被动事件
				String phy_id = data.substring(0, 8);
				String type = data.substring(8, 10);
				String flag = data.substring(10, 12);
				rtn.put("CARD_ID", phy_id);
				rtn.put("USER_ADDR", Integer.valueOf(cmd, 16).toString());
				switch (Integer.valueOf(rw, 16)) {
				case 0x01:// 读
					rtn.put("EVENT_ID", 3);
					rtn.put("OPEN_TYPE", type.equals("02") ? 1 : 2);
					rtn.put("SUCCEED", 1);
					json = JSONObject.fromObject(rtn);
					rtn.put("JSON", json.toString());
					return rtn;
				case 0x02:// 写
					switch (Integer.valueOf(type, 16)) {
					case 0x02:
						rtn.put("OPEN_TYPE", 1);
						switch (Integer.valueOf(flag, 16)) {
						case 0x01:// 有效
							rtn.put("EVENT_ID", 105);
							break;
						case 0x00:// 无效
							rtn.put("EVENT_ID", 103);
							break;
						default:
							rtn.put("SUCCEED", 0);
							rtn.put("ERROR", "是否有效标识位错误" + type);
							json = JSONObject.fromObject(rtn);
							rtn.put("JSON", json.toString());
							return rtn;
						}
						break;
					case 0x04:
						rtn.put("OPEN_TYPE", 2);
						switch (Integer.valueOf(flag, 16)) {
						case 0x01:// 有效
							rtn.put("EVENT_ID", 107);
							break;
						case 0x00:// 无效
							rtn.put("EVENT_ID", 103);
							break;
						default:
							rtn.put("SUCCEED", 0);
							rtn.put("ERROR", "是否有效标识位错误" + type);
							json = JSONObject.fromObject(rtn);
							rtn.put("JSON", json.toString());
							return rtn;
						}
						break;
					default:
						rtn.put("SUCCEED", 0);
						rtn.put("ERROR", "开门方式标识位错误" + type);
						json = JSONObject.fromObject(rtn);
						rtn.put("JSON", json.toString());
						return rtn;
					}
					rtn.put("SUCCEED", 1);
					json = JSONObject.fromObject(rtn);
					rtn.put("JSON", json.toString());
					return rtn;
				default:
					rtn.put("SUCCEED", 0);
					rtn.put("ERROR", "读写标识位错误" + rw);
					json = JSONObject.fromObject(rtn);
					rtn.put("JSON", json.toString());
					return rtn;
				}
			} else {
				rtn.put("ERROR", "读写标识位错误(0x" + cmd + ")");
				rtn.put("SUCCEED", 0);
				json = JSONObject.fromObject(rtn);
				rtn.put("JSON", json.toString());
				return rtn;
			}
		}
	}

	public String getLockStatus(String lockAddr) {
		return null;
	}

	public String getLockLocalTime(String lockAddr) {
		// 0x00 0x01(项目编号) + 0x00 0x00 0x00 0x01(门锁编号) + 0x01(读操作) + 0x00
		// 0x00(指令行号0) + (数据为空 均用0xff填充) 得到31字节长度数据
		StringBuffer bf = new StringBuffer();
		bf.append("0001");// 项目编号
		bf.append(lockAddr);// 门锁编号
		bf.append("01");// 读操作
		bf.append("0000");// 指令行号
		bf.append(fillStringWithFF(bf.toString(), 31 - bf.length() / 2));
		byte crc = Tools.calcCrc8(Tools.hexString2Bytes(bf.toString()));
		bf.append(Tools.byte2HexString(crc));
		return bf.toString();
	}

	public String setLockLocalTime(String lockAddr) {
		StringBuffer bf = new StringBuffer();
		bf.append("0001");// 项目编号
		bf.append(lockAddr);// 门锁编号
		bf.append("02");// 写操作
		bf.append("0000");// 指令行号
		bf.append(Tools.getTime());
		bf.append(fillStringWithFF(bf.toString(), 31 - bf.length() / 2));
		byte crc = Tools.calcCrc8(Tools.hexString2Bytes(bf.toString()));
		bf.append(Tools.byte2HexString(crc));
		return bf.toString();
	}

	public String remoteOpenLock(String lockAddr, String identify) {
		StringBuffer bf = new StringBuffer();
		bf.append("0001");// 项目编号
		bf.append(lockAddr);// 门锁编号
		bf.append("02");// 写操作
		bf.append("0002");// 指令行号
		bf.append(identify);
		bf.append("0401");
		bf.append(fillStringWithFF(bf.toString(), 31 - bf.length() / 2));
		byte crc = Tools.calcCrc8(Tools.hexString2Bytes(bf.toString()));
		bf.append(Tools.byte2HexString(crc));
		return bf.toString();
	}

	public String setLockUserClean(String lockAddr) {
		return null;
	}

	public String getLockUser(String lockAddr, String userAddr) {
		return null;
	}

	public String delLockUser(String lockAddr, int userAddr, String identify, int type) {
		StringBuffer bf = new StringBuffer();
		bf.append("0001");// 项目编号
		bf.append(lockAddr);// 门锁编号
		bf.append("02");// 写操作
		bf.append("00" + Integer.toHexString(userAddr));// 指令行号
		bf.append(identify);//
		bf.append(type == 1 ? "02" : "04");
		bf.append("00");
		bf.append(fillStringWithFF(bf.toString(), 31 - bf.length() / 2));
		byte crc = Tools.calcCrc8(Tools.hexString2Bytes(bf.toString()));
		bf.append(Tools.byte2HexString(crc));
		return bf.toString();
	}

	public String updateLockUser(String lockAddr, String userAddr) {
		return null;
	}

	public String addLockUser(String lockAddr, String cardPhyId, int type, int flag, int userAddr) {
		// 000100000001020032c62d1d250201ffffffffffffffffffffffffffffffffe0
		// 9b4b5e58f130d72a4228e70bae81e6160e9f9949069a074ee271fe88eafeb09c

		StringBuffer bf = new StringBuffer();
		bf.append("0001");// 项目编号
		bf.append(lockAddr);// 门锁编号
		bf.append("02");// 写操作
		bf.append("00" + Integer.toHexString(userAddr));// 指令行号
		bf.append(cardPhyId);//
		bf.append(type == 1 ? "02" : "04");
		bf.append(flag == 1 ? "01" : "00");
		bf.append(fillStringWithFF(bf.toString(), 31 - bf.length() / 2));
		byte crc = Tools.calcCrc8(Tools.hexString2Bytes(bf.toString()));
		bf.append(Tools.byte2HexString(crc));
		return bf.toString();
	}

	public String getWater(String lockAddr, String lineNum) {
		if (lineNum.length() != 8)
			return null;
		StringBuffer bf = new StringBuffer();
		bf.append("0001");// 项目编号
		bf.append(lockAddr);// 门锁编号
		bf.append("01");// 写操作
		bf.append("0001");// 指令行号
		bf.append("ffffffffffffffffffffff");// 填充
		bf.append(lineNum);// 流水行号
		bf.append(fillStringWithFF(bf.toString(), 31 - bf.length() / 2));
		byte crc = Tools.calcCrc8(Tools.hexString2Bytes(bf.toString()));
		bf.append(Tools.byte2HexString(crc));
		return bf.toString();
	}

	public String setWaterClean(String lockAddr) {
		StringBuffer bf = new StringBuffer();
		bf.append("0001");// 项目编号
		bf.append(lockAddr);// 门锁编号
		bf.append("02");// 写操作
		bf.append("001e");// 指令行号
		bf.append(fillStringWithFF(bf.toString(), 31 - bf.length() / 2));
		byte crc = Tools.calcCrc8(Tools.hexString2Bytes(bf.toString()));
		bf.append(Tools.byte2HexString(crc));
		return bf.toString();
	}

	public String restart(String lockAddr) {
		StringBuffer bf = new StringBuffer();
		bf.append("0001");// 项目编号
		bf.append(lockAddr);// 门锁编号
		bf.append("02");// 写操作
		bf.append("001f");// 指令行号
		bf.append(fillStringWithFF(bf.toString(), 31 - bf.length() / 2));
		byte crc = Tools.calcCrc8(Tools.hexString2Bytes(bf.toString()));
		bf.append(Tools.byte2HexString(crc));
		return bf.toString();
	}

	public String decryptCmd(String s) {
		try {
			return Tools.decrypt(s, key);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}

	public String encryptCmd(String s) {
		try {
			return Tools.encrypt(s, key);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}

	public int getLockUserNextAddr(int addr) {
		if (addr == 0)
			return 32;
		if (addr < 32)
			return -1;
		if (addr > 127)
			return -2;
		return addr + 1;

	}

	public String getCmdPattern(int eventId, String lockAddr) {
		String pattern = null;
		switch (eventId) {
		case 0:// 心跳
			pattern = String.format("0001%s01001d[0-9a-f]{46}", lockAddr);
			break;
		case 1:// 读锁时间
			pattern = String.format("0001%s010000[0-9a-f]{46}", lockAddr);
			break;
		case 2:// 同步时间
			pattern = String.format("0001%s020000[0-9a-f]{46}", lockAddr);
			break;
		case 105:// 下发卡用户
			pattern = String.format("0001%s02[0-9a-f]{4}[0-9a-f]{8}0201[f]{32}[0-9a-f]{2}", lockAddr);
			break;
		case 107:// 下发密码用户
			pattern = String.format("0001%s02[0-9a-f]{4}[0-9a-f]{8}0401[f]{32}[0-9a-f]{2}", lockAddr);
			break;
		case 103:// 删除名单
			pattern = String.format("0001%s02[0-9a-f]{4}[0-9a-f]{10}00[f]{32}[0-9a-f]{2}", lockAddr);
			break;
		}
		return pattern;
	}

	@Override
	public String getLockPulse(String lockAddr) {
		StringBuffer bf = new StringBuffer();
		bf.append("0001");// 项目编号
		bf.append(lockAddr);// 门锁编号
		bf.append("01");// 写操作
		bf.append("001d");// 指令行号
		bf.append(fillStringWithFF(bf.toString(), 31 - bf.length() / 2));
		byte crc = Tools.calcCrc8(Tools.hexString2Bytes(bf.toString()));
		bf.append(Tools.byte2HexString(crc));
		return bf.toString();
	}
}
