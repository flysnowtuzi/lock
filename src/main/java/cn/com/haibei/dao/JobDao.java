package cn.com.haibei.dao;

import java.sql.SQLException;
import java.util.List;
import java.util.Map;

import org.springframework.dao.DataAccessException;

import cn.com.haibei.bean.Cmd;
import cn.com.haibei.bean.Job;
import cn.com.haibei.bean.User;
import cn.com.haibei.bean.Water;

public interface JobDao {

	/**
	 * 根据设备ID查询未执行命令
	 * 
	 * @param dev_id
	 * @param size
	 * @return
	 * @throws DataAccessException
	 * @throws SQLException
	 */
	public List<Cmd> queryCmdByDevId(String dev_id, int size);

	/**
	 * 从数据库查询设备的新命令
	 * 
	 * @param j
	 * @param size
	 * @return
	 */
	public int queryNewCmd(List<Job> j, int size);

	/**
	 * 在数据库中保存命令返回结果，并标识命令状态
	 * 
	 * @param seq_no
	 * @param rtn_plain
	 * @param rtn_cipher
	 * @param time_cost
	 * @param time_download
	 * @param cmd_flag
	 * @param time_return
	 */
	public void saveCmdRtnByPk(String seq_no, String rtn_plain, String rtn_cipher, Long time_cost, String time_download, int cmd_flag,
			String time_return);

	/**
	 * 更新命令标识
	 * 
	 * @param seq_no
	 * @param cmd_flag
	 * @param time_return
	 */
	public void saveCmdFlagByPk(String seq_no, int cmd_flag, String time_return);

	/**
	 * 保存命令
	 * 
	 * @param cmd
	 */
	public void saveCmd(Cmd cmd);

	/**
	 * 根据组件查询锁用户
	 * 
	 * @param lock_id
	 * @param card_phy_id
	 * @param open_type
	 * @return
	 */
	public User queryLockUserByPk(String lock_id, String card_phy_id, int open_type);

	/**
	 * 根据流水号查询锁用户
	 * 
	 * @param seq_no
	 * @return
	 */
	public User queryLockUserBySeqNo(String seq_no);

	/**
	 * 更新锁用户的状态
	 * 
	 * @param seq_no
	 * @param status
	 */
	public void updateLockUserStatusBySeqNo(String seq_no, int status);

	/**
	 * 更新所用户
	 * 
	 * @param u
	 */
	public void updateLockUser(User u);

	/**
	 * 根据状态查询锁用户状态
	 * 
	 * @param lock_id
	 * @param status
	 * @return
	 */
	public List<User> queryLockUserByStatus(String lock_id, int status);

	/**
	 * 获取到最大的地址用户信息
	 * 
	 * @param lock_id
	 * @return
	 */
	public User queryLockUserMaxAddr(String lock_id);

	/**
	 * 保存命令
	 * 
	 * @param u
	 */
	public void saveLockUser(User u);

	/**
	 * 保存流水
	 * 
	 * @param w
	 */
	public void saveWater(Water w);

	/**
	 * 根据命令编号查询流水haibei_cmd_t
	 * 
	 * @param cmd_no
	 * @return
	 */
	public Water queryWaterByCmdNo(String cmd_no);

	/**
	 * 查询日志
	 * 
	 * @param timestamp
	 *            事件流水号
	 * @return
	 */
	public List<Map<String, String>> queryLog(Long timestamp);

	/**
	 * 根据状态和执行次数更新的命令状态
	 * 
	 * @param dev_id
	 * @param size
	 * @param flag
	 * @param run_cnt
	 * @param event
	 * @return
	 */
	public int updateDeviceCmd4RunAgain(String dev_id, int size, int flag, int run_cnt, int[] event);
}
