package cn.com.haibei.device;

import java.util.HashMap;
import java.util.Map;

import net.sf.json.JSONObject;
import cn.com.haibei.bean.Device;
import cn.com.haibei.tool.Tools;

public class LRD_W16_K1688 implements DeviceProtocl {
	private int type;

	public int getType() {
		return type;
	}

	public void setType(int type) {
		this.type = type;
	}

	public Map<String, Object> parsingCmd(String s, Device d) {
		Map<String, Object> m = new HashMap<String, Object>();
		Map<String, Object> rtn = new HashMap<String, Object>();
		String[] a = Tools.hexString2Array(s);
		JSONObject json = null;
		StringBuffer bf;
		int event_id = 0;
		switch (Integer.valueOf(a[4], 16)) {
		case 0xb0:
			// 流水记录
			// 02 02 16 40 B0 30 40 00 00 00 00 00 00 00 00 00 00 00 07 00 01 01
			// 00 00 00 03 90
			m.put("Type", Integer.valueOf(a[6], 16));
			m.put("LockAddr", a[0]);
			switch (Integer.valueOf(a[6], 16)) {
			case 0x30:
				event_id = 902;
				break;
			case 0x31:
				event_id = 901;
				break;
			case 0x40:
				event_id = 990;
				break;
			case 0x50:
				event_id = 991;
				break;
			case 0x51:
				event_id = 9993;
				break;
			case 0x53:
				event_id = 9993;
				break;
			case 0x54:
				event_id = 994;
				break;
			case 0x90:
				event_id = 980;
				break;
			case 0xa0:
				event_id = 981;
				break;
			case 0xa1:
				event_id = 982;
				break;
			case 0xa2:
				event_id = 983;
				break;
			case 0xa3:
				event_id = 984;
				break;
			case 0xa4:
				event_id = 995;
				break;
			case 0xa5:
				event_id = 996;
				break;
			case 0xa6:
				event_id = 985;
				break;
			case 0xe0:
				event_id = 997;
				break;
			case 0xee:
				event_id = 998;
				break;
			case 0xf0:
				event_id = 999;
				break;
			default:
				event_id = -1;
			}
			m.put("EventId", event_id);
			bf = new StringBuffer();
			for (int i = Integer.valueOf(a[7], 16) + 7; i > 7; i--) {
				bf.append(a[i]);
			}
			m.put("CardPhyId", bf.toString());
			m.put("WaterTime",
					String.format("%1$04d", Integer.valueOf(a[19], 16)) + "-" + String.format("%1$02d", Integer.valueOf(a[20], 16)) + "-"
							+ String.format("%1$02d", Integer.valueOf(a[21], 16)) + " " + String.format("%1$02d", Integer.valueOf(a[22], 16)) + "-"
							+ String.format("%1$02d", Integer.valueOf(a[23], 16)) + "-" + String.format("%1$02d", Integer.valueOf(a[24], 16)));
			json = JSONObject.fromObject(m);
			rtn.put("JSON", json.toString());
			return rtn;
		case 0x90:
			switch (Integer.valueOf(a[5], 16)) {
			case 0x30:// 添加用户
				// 04 02 1b 80 90 30
				// 32 卡片用户
				// 04 卡号长度
				// 912B21DE000000000000 卡片物理卡号
				// 0f0515140a0a 有效期开始
				// 1f0515140a0a 有效期结束
				// 0d
				// 04 02 04 86 90 30 01 03 22
				m.put("EventId", 105);
				m.put("LockAddr", a[0]);
				if (a[3].equals("86")) {
					m.put("Succeed", new Integer(1));

					m.put("UserAddr", Integer.valueOf(a[6], 16));
				} else {
					m.put("Succeed", new Integer(0));
					m.put("Err", Integer.valueOf(a[6], 16));
				}
				json = JSONObject.fromObject(m);
				rtn.put("JSON", json.toString());
				return rtn;
			case 0x31:// 修改指定用户ID
				m.put("EventId", 104);
				m.put("LockAddr", a[0]);
				if (a[3].equals("86")) {
					m.put("Succeed", new Integer(1));
					m.put("UserAddr", Integer.valueOf(a[6], 16));
				} else {
					m.put("Succeed", new Integer(0));
					m.put("Err", Integer.valueOf(a[6], 16));
				}
				json = JSONObject.fromObject(m);
				rtn.put("JSON", json.toString());
				return rtn;
			case 0x40:// 删除用户
				m.put("EventId", 103);
				m.put("LockAddr", a[0]);
				if (a[3].equals("86")) {
					m.put("Succeed", new Integer(1));
				} else {
					m.put("Succeed", new Integer(0));
					m.put("Err", Integer.valueOf(a[6], 16));
				}
				json = JSONObject.fromObject(m);
				rtn.put("JSON", json.toString());
				return rtn;
			case 0x41:// 按ID删除用户
				m.put("EventId", 103);
				m.put("LockAddr", a[0]);
				if (a[3].equals("86")) {
					m.put("Succeed", new Integer(1));
				} else {
					m.put("Succeed", new Integer(0));
					m.put("Err", Integer.valueOf(a[6], 16));
				}
				json = JSONObject.fromObject(m);
				rtn.put("JSON", json.toString());
				return rtn;
			case 0x42:// 用来清空记录 , 初始化用
				m.put("EventId", 106);
				m.put("LockAddr", a[0]);
				if (a[3].equals("86")) {
					m.put("Succeed", new Integer(1));
				} else {
					m.put("Succeed", new Integer(0));
					m.put("Err", Integer.valueOf(a[6], 16));
				}
				json = JSONObject.fromObject(m);
				rtn.put("JSON", json.toString());
				return rtn;
			case 0x60:// 设置锁的时间
				m.put("EventId", 103);
				m.put("LockAddr", a[0]);
				if (a[3].equals("86")) {
					m.put("Succeed", new Integer(1));
				} else {
					m.put("Succeed", new Integer(0));
					m.put("Err", Integer.valueOf(a[6], 16));
				}
				json = JSONObject.fromObject(m);
				rtn.put("JSON", json.toString());
				return rtn;
			case 0x61:// 远程开门
				m.put("EventId", 10);
				m.put("LockAddr", a[0]);
				if (a[3].equals("86")) {
					m.put("Succeed", new Integer(1));
				} else {
					m.put("Succeed", new Integer(0));
					m.put("Err", Integer.valueOf(a[6], 16));
				}
				json = JSONObject.fromObject(m);
				rtn.put("JSON", json.toString());
				return rtn;
			case 0x62:// 设置开门权限
				if (a[3].equals("86")) {
					m.put("Succeed", new Integer(1));
				} else {
					m.put("Succeed", new Integer(0));
					m.put("Err", Integer.valueOf(a[6], 16));
				}
				json = JSONObject.fromObject(m);
				rtn.put("JSON", json.toString());
				return rtn;
			default:// 未定义
				return null;
			}
		case 0x91:
			switch (Integer.valueOf(a[5], 16)) {
			case 0x30:// 读状态
				// 02 02 0f 86 91 30 04 04 3439 000101052b20 07 30 031d
				m.put("EventId", 0);
				m.put("LockAddr", a[0]);
				if (a[3].equals("86")) {
					m.put("Succeed", new Integer(1));
					m.put("CardUserCnt", Integer.valueOf(a[6], 16));
					m.put("PasswdUserCnt", Integer.valueOf(a[7], 16));
					m.put("VoltValue", a[8].substring(1) + "." + a[9].substring(1));
					m.put("LockTime", String.format("%1$04d", Integer.valueOf(a[10], 16)) + "-" + String.format("%1$02d", Integer.valueOf(a[11], 16))
							+ "-" + String.format("%1$02d", Integer.valueOf(a[12], 16)) + " " + String.format("%1$02d", Integer.valueOf(a[13], 16))
							+ "-" + String.format("%1$02d", Integer.valueOf(a[14], 16)) + "-" + String.format("%1$02d", Integer.valueOf(a[15], 16)));
					m.put("SensorStatus", Integer.toBinaryString(Integer.valueOf(a[16], 16)));
				} else {
					m.put("Succeed", new Integer(0));
					m.put("Err", Integer.valueOf(a[6], 16));
				}
				json = JSONObject.fromObject(m);
				rtn.put("JSON", json.toString());
				return rtn;
			case 0x31:// 读固件版本
				if (a[3].equals("86")) {
					m.put("Succeed", new Integer(1));
					m.put("Version", Integer.valueOf(a[6], 16));
				} else {
					m.put("Succeed", new Integer(0));
					m.put("Err", Integer.valueOf(a[6], 16));
				}
				json = JSONObject.fromObject(m);
				rtn.put("JSON", json.toString());
				return rtn;
			case 0x50:// 读取用户
				if (a[3].equals("86")) {
					m.put("Succeed", new Integer(1));
					m.put("UserType", a[6]);
					bf = new StringBuffer();
					for (int i = Integer.valueOf(a[7], 16) + 7; i > 7; i--) {
						bf.append(a[i]);
					}
					m.put("CardPhyId", bf.toString());
				} else {
					m.put("Succeed", new Integer(0));
					m.put("Err", Integer.valueOf(a[6], 16));
				}
				json = JSONObject.fromObject(m);
				rtn.put("JSON", json.toString());
				return rtn;
			case 0x51:// 读取管理员
				if (a[3].equals("86")) {
					m.put("Succeed", new Integer(1));
					m.put("UserType", a[6]);
					bf = new StringBuffer();
					for (int i = Integer.valueOf(a[7], 16) + 7; i > 7; i--) {
						bf.append(a[i]);
					}
					m.put("CardPhyId", bf.toString());
				} else {
					m.put("Succeed", new Integer(0));
					m.put("Err", Integer.valueOf(a[6], 16));
				}
				json = JSONObject.fromObject(m);
				rtn.put("JSON", json.toString());
				return rtn;
			default:// 未定义
				return null;
			}
		case 0x92:
			switch (Integer.valueOf(a[5], 16)) {
			case 0x31:// 读参数
				// 02 02 0F 86 92 31 00 00 00 00 00 00 00 00 00 00 00 00 03 2B
				break;
			default:// 未定义
				return null;
			}
		}
		return null;
	}

	public String getLockStatus(String lockAddr) {
		return null;
	}

	public String getLockLocalTime(String lockAddr) {
		return null;
	}

	public String setLockLocalTime(String lockAddr) {
		return null;
	}

	public String remoteOpenLock(String lockAddr, String identify) {
		return null;
	}

	public String setLockUserClean(String lockAddr) {
		return null;
	}

	public String getLockUser(String lockAddr, String userAddr) {
		return null;
	}

	public String delLockUser(String lockAddr, int userAddr, String identify, int type) {
		return null;
	}

	public String updateLockUser(String lockAddr, String userAddr) {
		return null;
	}

	public String addLockUser(String lockAddr, String cardPhyId, int type, int flag, int userAddr) {
		return null;
	}

	public String getWater(String lockAddr, String lineNum) {
		return null;
	}

	public String setWaterClean(String lockAddr) {
		return null;
	}

	public String restart(String lockAddr) {
		return null;
	}

	public String decryptCmd(String s) {
		return s;
	}

	public String encryptCmd(String s) {
		return s;
	}

	public int getLockUserNextAddr(int addr) {
		return 0;
	}

	public String getCmdPattern(int eventId, String lockAddr) {
		String pattern = null;
		switch (eventId) {
		case 105:// 下发卡用户
			pattern = String.format("0001%s02[0-9a-f]{4}[0-9a-f]{8}0201[f]{32}[0-9a-f]{2}", lockAddr);
			break;
		case 107:// 下发密码用户
			pattern = String.format("0001%s02[0-9a-f]{4}[0-9a-f]{8}0401[f]{32}[0-9a-f]{2}", lockAddr);
			break;
		case 103:// 删除名单
			pattern = String.format("0001%s02[0-9a-f]{4}[0-9a-f]{8}0201[f]{32}[0-9a-f]{2}", lockAddr);
			;
			break;
		}
		return pattern;
	}

	@Override
	public String getLockPulse(String lockAddr) {
		// TODO Auto-generated method stub
		return null;
	}
}
