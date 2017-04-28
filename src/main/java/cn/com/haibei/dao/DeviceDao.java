package cn.com.haibei.dao;

import java.sql.SQLException;
import java.util.List;

import org.springframework.dao.DataAccessException;

import cn.com.haibei.bean.Device;
import cn.com.haibei.bean.Lock;

public interface DeviceDao {

	/**
	 * 读取多少有在用的设备 haibei_device_t
	 * 
	 * @return
	 * @throws DataAccessException
	 * @throws SQLException
	 */
	public List<Device> queryDevice();

	/**
	 * 根据IP地址查询控制器
	 * 
	 * @param ip
	 * @return
	 * @throws DataAccessException
	 * @throws SQLException
	 */
	public Device queryDeviceByIp(String ip) throws DataAccessException, SQLException;

	/**
	 * 根据ID查询控制器
	 * 
	 * @param id
	 * @return
	 * @throws DataAccessException
	 * @throws SQLException
	 */
	public Device queryDeviceById(String id) throws DataAccessException, SQLException;

	/**
	 * 保存新建控制器
	 * 
	 * @param ctrl
	 * @throws DataAccessException
	 * @throws SQLException
	 */
	public void saveDevice(Device dev) throws DataAccessException, SQLException;

	/**
	 * 更新控制器
	 * 
	 * @param ctrl
	 * @throws DataAccessException
	 * @throws SQLException
	 */
	public void updateDevice(Device dev) throws DataAccessException, SQLException;

	/**
	 * 更新锁的当前流水行号
	 * 
	 * @param dev_id
	 * @param water_no
	 * @param lock_addr
	 */
	public void updateLockWaterNo(String dev_id, String water_no, String lock_addr);

	/**
	 * 更新锁的在线标识
	 * 
	 * @param dev_id
	 * @param lock_addr
	 * @param flag
	 */
	public void updateLockFlag(String dev_id, String lock_addr, int flag);

	/**
	 * 根据组件查询锁
	 * 
	 * @param lock_id
	 * @return
	 */
	public Lock queryLockByPk(String lock_id);

	/**
	 * 根据设备ID查询锁
	 * 
	 * @param lock_id
	 * @return
	 */
	public List<Lock> queryLockByDevId(String dev_id);

	/**
	 * 根据设备ip和锁的物理位置查询锁的信息
	 * 
	 * @param dev_id
	 * @param lock_addr
	 * @return
	 */
	public String queryLockWaterNoByDeviceIdLockAddr(String dev_id, String lock_addr);

	/**
	 * 根据Lock的UN查询锁的信息
	 * 
	 * @param dev_id
	 * @param lock_addr
	 * @return
	 */
	public Lock queryLockByDeviceIdLockAddr(String dev_id, String lock_addr);
}
