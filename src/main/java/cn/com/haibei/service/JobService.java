package cn.com.haibei.service;

import java.nio.channels.SocketChannel;
import java.util.List;
import java.util.Map;

import cn.com.haibei.bean.Cmd;
import cn.com.haibei.bean.Device;
import cn.com.haibei.bean.Job;
import cn.com.haibei.bean.Lock;
import cn.com.haibei.device.DeviceProtocl;
import cn.com.haibei.tool.CoreException;

/**
 * @author gaol
 *
 */
public interface JobService {

	/**
	 * 从数据库读取所有在用注册设备
	 * 
	 * @return
	 */
	public int getDBDevice();

	/**
	 * 获取数据库连接
	 * 
	 * @return
	 */
	public DaoDelegate getDao();

	/**
	 * 从黑名单中检查是否存在此ip
	 * 
	 * @param ip
	 * @return
	 */
	public boolean checkBlack(String ip);

	/**
	 * 将ip加入到黑名单集合
	 * 
	 * @param ip
	 * @return
	 */
	public boolean addBlack(String ip);

	/**
	 * 根据ip获取设备信息
	 * 
	 * @param ip
	 * @return
	 */
	public Device getDeviceByIp(String ip);

	/**
	 * 从数据库中读取设备的命令列表
	 * 
	 * @param job
	 * @param size
	 * @return
	 */
	public int getNewCmd(List<Job> job, int size);

	/**
	 * 从内存中读取设备的命令列表
	 * 
	 * @param job
	 * @param size
	 * @return
	 */
	public List<Cmd> getDeviceCmd(String dev_id);

	/**
	 * 从数据库中读取设备的命令列表
	 * 
	 * @param dev_id
	 * @param size
	 * @return
	 */
	public List<Cmd> getDBDeviceCmd(String dev_id, int size);

	/**
	 * 从数据库中读取设备的运行超时的命令列表
	 * 
	 * @param dev_id
	 * @param size
	 * @param flag
	 * @return
	 */
	public List<Cmd> getDBDeviceCmdByFlag(String dev_id, int size, int flag);

	/**
	 * 设置设备内存中的命令
	 * 
	 * @param id
	 * @param cmd
	 */
	public void setDeviceCmdById(String id, List<Cmd> cmd);

	/**
	 * 获取当前执行的命令，默认index=0
	 * 
	 * @param id
	 * @param index
	 * @return
	 */
	public Cmd getDeviceCmdById(String id, int index);

	/**
	 * 获取当前执行的命令，默认index=0
	 * 
	 * @param id
	 * @param index
	 * @return TODO
	 * @return
	 */
	public boolean setDeviceCmdStart(String id, int index, Long start);

	/**
	 * 获取设备未执行命令数量
	 * 
	 * @param id
	 * @return
	 */
	public int getDeviceCmdSizeById(String id);

	/**
	 * 从列表中删除执行完的命令
	 * 
	 * @param id
	 * @param index
	 * @return
	 */
	public boolean removeDeviceCmdById(String id, int index);

	/**
	 * 在数据库中保存命令返回结果，并标识命令状态
	 * 
	 * @param seq_no
	 * @param rtn_plain
	 * @param rtn_clipher
	 * @param time_cost
	 * @param time_download
	 * @param cmd_flag
	 * @param time_return
	 */
	public void saveCmdRtnByPk(String seq_no, String rtn_plain, String rtn_clipher, Long time_cost, String time_download, int cmd_flag,
			String time_return);

	/**
	 * 设置设备在线状态
	 * 
	 * @param id
	 * @param flag
	 */
	public void setDeviceOnlineFlag(String id, boolean flag);

	/**
	 * 显示设备在线数
	 * 
	 * @return
	 */
	public int getDeviceOnlineCnt();

	/**
	 * 保存设备的socket
	 * 
	 * @param dev_id
	 * @param socket
	 */
	public void setDeviceSocketChannel(String dev_id, SocketChannel socket);

	/**
	 * 获取内存中所有的Job
	 * 
	 * @return
	 */
	public List<Job> getJob();

	/**
	 * 处理客户端发送的数据
	 * 
	 * @param dev_ip
	 * @param msg
	 * @param stamp
	 */
	public void pushSocketRead(String dev_ip, String msg, Long stamp);

	/**
	 * 将命令保存为流水
	 * 
	 * @param c
	 */
	public void saveCmd2Water(Cmd c);

	/**
	 * 获取未处理流水数量
	 * 
	 * @return
	 */
	public int getReadCnt();

	/**
	 * 将流水保存到数据库中
	 */
	public void dealRead();

	/**
	 * @param seq_no
	 * @param cmd_flag
	 * @param time_return
	 */
	public void saveCmdTimeOutByPk(String seq_no, int cmd_flag, String time_return);

	/**
	 * 将字符串解密
	 * 
	 * @param s
	 * @param dev_type
	 * @return
	 */
	public String decryptCmdDecrypt(String s, int dev_type);

	/**
	 * 将字符串加密
	 * 
	 * @param s
	 * @param dev_type
	 * @return
	 */
	public String encryptCmdEncrypt(String s, int dev_type);

	/**
	 * 解析命令
	 * 
	 * @param cmd
	 * @param d
	 * @return
	 */
	public Map<String, Object> parsingCmd(String cmd, Device d);

	/**
	 * 根据Lock的UN查询锁的信息
	 * 
	 * @param dev_id
	 * @param lock_addr
	 * @return
	 */
	public Lock getLockByDeviceIdLockAddr(String dev_id, String lock_addr);

	/**
	 * 增加开门用户
	 * 
	 * @param lock_id
	 *            锁id
	 * @param identify
	 *            卡片物理id或者开门
	 * @param type
	 *            1：卡片开门；2：密码开门
	 * @return
	 * 
	 * @throws CoreException
	 */
	public String addLockUser(String lock_id, String identify, int type) throws CoreException;

	/**
	 * 查询用户的处理协议
	 * 
	 * @param dev_id
	 * @return
	 * @throws CoreException
	 */
	public DeviceProtocl getDeviceProtocl(String dev_id) throws CoreException;

	/**
	 * 更新锁用户的状态
	 * 
	 * @param seq_no
	 * @param status
	 */
	public void setLockUserStatusBySeqNo(String seq_no, int status);

	/**
	 * 获取锁本地时间
	 * 
	 * @param lock_id
	 * @return
	 * @throws CoreException
	 */
	public String getLockTime(String lock_id) throws CoreException;

	/**
	 * 发送心跳查询
	 * 
	 * @param lock_id
	 * @return
	 * @throws CoreException
	 */
	public String sendLockPulse(String lock_id) throws CoreException;

	/**
	 * 同步锁时间
	 * 
	 * @param lock_id
	 * @return
	 * @throws CoreException
	 */
	public String setLockTime(String lock_id) throws CoreException;

	/**
	 * 关闭所有socket连接
	 * 
	 */
	public void closScoketConnection();

	/**
	 * 取得设备所对应的job
	 * 
	 * @param dev_id
	 * @return
	 */
	public Job getJobByDevId(String dev_id);

	/**
	 * @param lock_id
	 * @param identify
	 * @param type
	 * @return
	 * @throws CoreException
	 */
	public String removeLockUser(String lock_id, String identify, int type) throws CoreException;

	/**
	 * @param seq_no
	 * @return
	 * @throws CoreException
	 */
	public String removeLockUserByPk(String seq_no) throws CoreException;

	/**
	 * 根据用户编号删除锁用户
	 * 
	 * @param lock_id
	 * @param user_id
	 * @return
	 * @throws CoreException
	 */
	public String removeLockUserByPk(String lock_id, String user_id) throws CoreException;

	/**
	 * 远程开锁
	 * 
	 * @param lockAddr
	 * @param identify
	 * @return
	 */
	public String remoteOpenLock(String lock_id, String identify) throws CoreException;

	/**
	 * 设置设备正在从数据库读取新命令的标识
	 * 
	 * @param dev_id
	 * @param flag
	 */
	public void setDeviceReadCmdFromDb(String dev_id, Integer flag);
}
