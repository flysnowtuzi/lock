package cn.com.haibei.device;

import java.util.Map;

import cn.com.haibei.bean.Device;

public interface DeviceProtocl {

	public int getType();

	public void setType(int type);

	/**
	 * 解析流水
	 * 
	 * @param s
	 * @param d
	 * @return
	 */
	public Map<String, Object> parsingCmd(String s, Device d);

	/**
	 * 读取锁状态，心跳
	 * 
	 * @param lockAddr
	 * @return
	 */
	public String getLockStatus(String lockAddr);

	/**
	 * 读取锁的时间
	 * 
	 * @param lockAddr
	 * @return
	 */
	public String getLockLocalTime(String lockAddr);

	/**
	 * 设置锁时间
	 * 
	 * @param lockAddr
	 * @return
	 */
	public String setLockLocalTime(String lockAddr);

	/**
	 * 远程开锁
	 * 
	 * @param lockAddr
	 * @param identify
	 * @return
	 */
	public String remoteOpenLock(String lockAddr, String identify);

	/**
	 * 清空锁的白名单
	 * 
	 * @param lockAddr
	 * @return
	 */
	public String setLockUserClean(String lockAddr);

	/**
	 * 读取锁白名单
	 * 
	 * @param lockAddr
	 * @param userAddr
	 * @return
	 */
	public String getLockUser(String lockAddr, String userAddr);

	/**
	 * 计算锁的下一个存储位置
	 * 
	 * @param lockAddr
	 * @param userAddr
	 * @return
	 */
	public int getLockUserNextAddr(int addr);

	/**
	 * 删除锁白名单
	 * 
	 * @param lockAddr
	 * @param userAddr
	 * @param identify
	 * @param type
	 * @return
	 */
	public String delLockUser(String lockAddr, int userAddr, String identify, int type);

	/**
	 * 更新锁白名单
	 * 
	 * @param lockAddr
	 * @param userAddr
	 * @return
	 */
	public String updateLockUser(String lockAddr, String userAddr);

	/**
	 * 设置锁白名单
	 * 
	 * @param lockAddr
	 * @param cardPhyId
	 * @param type
	 * @param flag
	 * @param userAddr
	 * @return
	 */
	public String addLockUser(String lockAddr, String cardPhyId, int type, int flag, int userAddr);

	/**
	 * 读取流水
	 * 
	 * @param lockAddr
	 * @param lineNum
	 * @return
	 */
	public String getWater(String lockAddr, String lineNum);

	/**
	 * 清空设备流水，初始化用
	 * 
	 * @param lockAddr
	 * @return
	 */
	public String setWaterClean(String lockAddr);

	/**
	 * 重启设备
	 * 
	 * @param lockAddr
	 * @return
	 */
	public String restart(String lockAddr);

	/**
	 * 将字符串解密
	 * 
	 * @param s
	 * @return
	 */
	public String decryptCmd(String s);

	/**
	 * 将字符串加密
	 * 
	 * @param s
	 * @return
	 */
	public String encryptCmd(String s);

	/**
	 * 获取命令返回匹配正则表达式
	 * 
	 * @param eventId
	 * @param lockAddr
	 * @return
	 */
	public String getCmdPattern(int eventId, String lockAddr);

	public String getLockPulse(String lockAddr);

}
