package cn.com.haibei.service;

import java.sql.SQLException;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.stereotype.Repository;

import cn.com.haibei.bean.Cmd;
import cn.com.haibei.bean.Device;
import cn.com.haibei.bean.Job;
import cn.com.haibei.bean.Lock;
import cn.com.haibei.bean.User;
import cn.com.haibei.bean.Water;
import cn.com.haibei.dao.DeviceDao;
import cn.com.haibei.dao.JobDao;

@Repository
public class DaoImpl implements DaoDelegate {
	@Autowired
	private DeviceDao device;

	@Autowired
	private JobDao job;

	public List<Device> queryDevice() {
		return device.queryDevice();
	}

	public Device queryDeviceByIp(String ip) throws DataAccessException, SQLException {
		return device.queryDeviceByIp(ip);
	}

	public Device queryDeviceById(String id) throws DataAccessException, SQLException {
		return device.queryDeviceById(id);
	}

	public void saveDevice(Device dev) throws DataAccessException, SQLException {
		device.saveDevice(dev);
	}

	public void updateDevice(Device dev) throws DataAccessException, SQLException {
		device.updateDevice(dev);
	}

	public List<Cmd> queryCmdByDevId(String dev_id, int size) {
		return job.queryCmdByDevId(dev_id, size);
	}

	public void saveCmdRtnByPk(String seq_no, String rtn_plain, String rtn_cipher, Long time_cost, String time_download, int cmd_flag,
			String time_return) {
		job.saveCmdRtnByPk(seq_no, rtn_plain, rtn_cipher, time_cost, time_download, cmd_flag, time_return);
	}

	public void saveCmdFlagByPk(String seq_no, int cmd_flag, String time_return) {
		job.saveCmdFlagByPk(seq_no, cmd_flag, time_return);
	}

	public void updateLockWaterNo(String dev_id, String water_no, String lock_addr) {
		device.updateLockWaterNo(dev_id, water_no, lock_addr);

	}

	public String queryLockWaterNoByDeviceIdLockAddr(String dev_id, String lock_addr) {
		return device.queryLockWaterNoByDeviceIdLockAddr(dev_id, lock_addr);
	}

	public Lock queryLockByDeviceIdLockAddr(String dev_id, String lock_addr) {
		return device.queryLockByDeviceIdLockAddr(dev_id, lock_addr);
	}

	public Lock queryLockByPk(String lock_id) {
		return device.queryLockByPk(lock_id);
	}

	public User queryLockUserByPk(String lock_id, String card_phy_id, int open_type) {
		return job.queryLockUserByPk(lock_id, card_phy_id, open_type);
	}

	public void saveCmd(Cmd cmd) {
		job.saveCmd(cmd);
	}

	public void updateLockUserStatusBySeqNo(String seq_no, int status) {
		job.updateLockUserStatusBySeqNo(seq_no, status);
	}

	public List<User> queryLockUserByStatus(String lock_id, int status) {
		return job.queryLockUserByStatus(lock_id, status);
	}

	public User queryLockUserMaxAddr(String lock_id) {
		return job.queryLockUserMaxAddr(lock_id);
	}

	public void saveLockUser(User u) {
		job.saveLockUser(u);
	}

	public void saveWater(Water w) {
		job.saveWater(w);
	}

	public void updateLockUser(User u) {
		job.updateLockUser(u);
	}

	public User queryLockUserBySeqNo(String seq_no) {
		return job.queryLockUserBySeqNo(seq_no);
	}

	public Water queryWaterByCmdNo(String cmd_no) {
		return job.queryWaterByCmdNo(cmd_no);
	}

	@Override
	public int queryNewCmd(List<Job> j, int size) {
		return job.queryNewCmd(j, size);
	}

	@Override
	public List<Lock> queryLockByDevId(String dev_id) {
		return device.queryLockByDevId(dev_id);
	}

	@Override
	public void updateLockFlag(String dev_id, String lock_addr, int flag) {
		device.updateLockFlag(dev_id, lock_addr, flag);
	}

	@Override
	public List<Map<String, String>> queryLog(Long timestamp) {
		return job.queryLog(timestamp);
	}

	@Override
	public int updateDeviceCmd4RunAgain(String dev_id, int size, int flag, int run_cnt, int[] event) {
		return job.updateDeviceCmd4RunAgain(dev_id, size, flag, run_cnt, event);
	}
}
