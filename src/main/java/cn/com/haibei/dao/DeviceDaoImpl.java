package cn.com.haibei.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import org.springframework.dao.DataAccessException;
import org.springframework.jdbc.CannotGetJdbcConnectionException;
import org.springframework.stereotype.Repository;

import cn.com.haibei.bean.Device;
import cn.com.haibei.bean.Lock;

@Repository
public class DeviceDaoImpl extends AutowiringJdbcDao implements DeviceDao {

	public Device queryDeviceByIp(String ip) throws DataAccessException, SQLException {
		return null;
	}

	public Device queryDeviceById(String id) throws DataAccessException, SQLException {
		String sql = "select * from haibei_device_v where dev_id= ?";
		Device d = null;
		PreparedStatement ps = null;
		ResultSet rs = null;
		Connection conn = null;
		try {
			conn = this.getConnection();
			ps = conn.prepareStatement(sql, ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_READ_ONLY);
			ps.setString(1, id);
			rs = ps.executeQuery();
			rs.last(); // 移动到最后一行
			int rownum = rs.getRow(); // 获得当前行的行号，即记录的条数
			if (rownum != 1) {
				if (!rs.isClosed())
					rs.close();
				if (!ps.isClosed())
					ps.close();
				return d;
			}
			rs.absolute(1); // 将指针返回至第一条记录
			d = new Device();
			d.setDevId(rs.getString("dev_id"));
			d.setDevName(rs.getString("dev_name"));
			d.setBuildingId(rs.getString("building_id"));
			d.setBuildingName(rs.getString("building_name"));
			d.setDevStatus(rs.getInt("dev_status"));
			d.setDevMemo(rs.getString("dev_memo"));
			d.setDevIp(rs.getString("dev_ip"));
			d.setDevType(rs.getInt("dev_type"));
			d.setDevTypeName(rs.getString("type_name"));
			d.setCrc(rs.getInt("dev_crc"));
			d.setEncrypt(rs.getInt("dev_encrypt"));
		} catch (CannotGetJdbcConnectionException e) {
			e.printStackTrace();
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			try {
				if (!rs.isClosed())
					rs.close();
				if (!ps.isClosed())
					ps.close();
				ps = null;
				if (null != conn && !conn.isClosed()) {
					conn.close();
					conn = null;
				}
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		return d;
	}

	public void saveDevice(Device dev) throws DataAccessException, SQLException {

	}

	public void updateDevice(Device dev) throws DataAccessException, SQLException {

	}

	public List<Device> queryDevice() {
		List<Device> l = new ArrayList<Device>();
		String sql = "select dev_id, dev_name, dev_ip, dev_status, d.dev_type, dev_parsing, t.type_name, t.dev_crc, t.dev_encrypt, t.dev_key, building_id, building_name from haibei_device_t d, haibei_device_type_t t where d.dev_type = t.dev_type and dev_status = 0";
		PreparedStatement ps = null;
		ResultSet rs = null;
		Connection conn = null;
		try {
			conn = this.getConnection();
			ps = conn.prepareStatement(sql, ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_READ_ONLY);
			rs = ps.executeQuery();
			while (rs.next()) {
				Device d = new Device();
				d.setDevId(rs.getString("dev_id"));
				d.setDevName(rs.getString("dev_name"));
				d.setDevIp(rs.getString("dev_ip"));
				d.setDevStatus(rs.getInt("dev_status"));
				d.setDevType(rs.getInt("dev_type"));
				d.setDevTypeName(rs.getString("dev_ip"));
				d.setCrc(rs.getInt("dev_crc"));
				d.setEncrypt(rs.getInt("dev_encrypt"));
				d.setKey(rs.getString("dev_key"));
				d.setDevParsing(rs.getString("dev_parsing"));
				l.add(d);
			}
		} catch (CannotGetJdbcConnectionException e) {
			e.printStackTrace();
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			try {
				if (!rs.isClosed())
					rs.close();
				if (!ps.isClosed())
					ps.close();
				ps = null;
				if (null != conn && !conn.isClosed()) {
					conn.close();
					conn = null;
				}
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		if (l.size() == 0)
			return null;
		else
			return l;
	}

	public void updateLockWaterNo(String dev_id, String water_no, String lock_addr) {
		String sql = "update haibei_lock_t set water_no = ? where dev_id = ?  and lock_addr = ?";
		PreparedStatement ps = null;
		Connection conn = null;
		try {
			conn = this.getConnection();
			ps = conn.prepareStatement(sql);
			ps.setString(1, water_no);
			ps.setString(2, dev_id);
			ps.setString(3, lock_addr);
			ps.execute();
		} catch (CannotGetJdbcConnectionException e) {
			e.printStackTrace();
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			try {
				if (!ps.isClosed())
					ps.close();
				ps = null;
				if (null != conn && !conn.isClosed()) {
					conn.close();
					conn = null;
				}
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
	}

	public String queryLockWaterNoByDeviceIdLockAddr(String dev_id, String lock_addr) {
		String sql = "select water_no from haibei_lock_t where dev_id = ? and lock_addr = ?";
		String water_no = null;
		PreparedStatement ps = null;
		ResultSet rs = null;
		Connection conn = null;
		try {
			conn = this.getConnection();
			ps = conn.prepareStatement(sql, ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_READ_ONLY);
			ps.setString(1, dev_id);
			ps.setString(2, lock_addr);
			rs = ps.executeQuery();
			rs.last(); // 移动到最后一行
			int rownum = rs.getRow(); // 获得当前行的行号，即记录的条数
			if (rownum != 1)
				return water_no;

			rs.absolute(1); // 将指针返回至第一条记录
			water_no = rs.getString(1);
		} catch (CannotGetJdbcConnectionException e) {
			e.printStackTrace();
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			try {
				if (!rs.isClosed())
					rs.close();
				if (!ps.isClosed())
					ps.close();
				ps = null;
				if (null != conn && !conn.isClosed()) {
					conn.close();
					conn = null;
				}
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}

		return water_no;
	}

	public Lock queryLockByDeviceIdLockAddr(String dev_id, String lock_addr) {
		String sql = "select lock_id, lock_name, door_id, lock_addr, dev_id, floor_id, lock_flag, lock_memo, lock_status, last_update from haibei_lock_t where dev_id = ? and lock_addr = ?";
		Lock lock = null;
		PreparedStatement ps = null;
		ResultSet rs = null;
		Connection conn = null;
		try {
			conn = this.getConnection();
			ps = conn.prepareStatement(sql, ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_READ_ONLY);
			ps.setString(1, dev_id);
			ps.setString(2, lock_addr);
			rs = ps.executeQuery();
			rs.last(); // 移动到最后一行
			int rownum = rs.getRow(); // 获得当前行的行号，即记录的条数
			if (rownum != 1)
				return lock;

			rs.absolute(1); // 将指针返回至第一条记录
			lock = new Lock();
			lock.setLockId(rs.getString("lock_id"));
			lock.setLockName(rs.getString("lock_name"));
			lock.setLockAddr(rs.getString("lock_addr"));
			lock.setDoorId(rs.getString("door_id"));
			lock.setDevId(rs.getString("dev_id"));
			lock.setFloorId(rs.getString("floor_id"));
			lock.setLockFlag(rs.getInt("lock_flag"));
			lock.setLockMemo(rs.getString("lock_memo"));
			lock.setLockStatus(rs.getInt("lock_status"));
		} catch (CannotGetJdbcConnectionException e) {
			e.printStackTrace();
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			try {
				if (!rs.isClosed())
					rs.close();
				if (!ps.isClosed())
					ps.close();
				ps = null;
				if (null != conn && !conn.isClosed()) {
					conn.close();
					conn = null;
				}
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}

		return lock;
	}

	public Lock queryLockByPk(String lock_id) {
		String sql = "select * from haibei_lock_t where lock_id = ?";
		Lock lock = null;
		PreparedStatement ps = null;
		ResultSet rs = null;
		Connection conn = null;
		try {
			conn = this.getConnection();
			ps = conn.prepareStatement(sql, ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_READ_ONLY);
			ps.setString(1, lock_id);
			rs = ps.executeQuery();
			rs.last(); // 移动到最后一行
			int rownum = rs.getRow(); // 获得当前行的行号，即记录的条数
			if (rownum != 1)
				return lock;
			rs.absolute(1); // 将指针返回至第一条记录
			lock = new Lock();
			lock.setLockId(rs.getString("lock_id"));
			lock.setLockName(rs.getString("lock_name"));
			lock.setLockAddr(rs.getString("lock_addr"));
			lock.setDoorId(rs.getString("door_id"));
			lock.setDevId(rs.getString("dev_id"));
			lock.setFloorId(rs.getString("floor_id"));
			lock.setLockFlag(rs.getInt("lock_flag"));
			lock.setLockMemo(rs.getString("lock_memo"));
			lock.setLockStatus(rs.getInt("lock_status"));
			lock.setWaterNo(rs.getString("water_no"));
		} catch (CannotGetJdbcConnectionException e) {
			e.printStackTrace();
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			try {
				if (!rs.isClosed())
					rs.close();
				if (!ps.isClosed())
					ps.close();
				ps = null;
				if (null != conn && !conn.isClosed()) {
					conn.close();
					conn = null;
				}
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		return lock;
	}

	@Override
	public List<Lock> queryLockByDevId(String dev_id) {
		List<Lock> l = new ArrayList<Lock>();
		String sql = "select * from haibei_lock_t where dev_id = ?";
		PreparedStatement ps = null;
		ResultSet rs = null;
		Connection conn = null;
		try {
			conn = this.getConnection();
			ps = conn.prepareStatement(sql, ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_READ_ONLY);
			ps.setString(1, dev_id);
			rs = ps.executeQuery();
			rs = ps.executeQuery();
			while (rs.next()) {
				Lock lock = new Lock();
				lock.setLockId(rs.getString("lock_id"));
				lock.setLockName(rs.getString("lock_name"));
				lock.setLockAddr(rs.getString("lock_addr"));
				lock.setDoorId(rs.getString("door_id"));
				lock.setDevId(rs.getString("dev_id"));
				lock.setFloorId(rs.getString("floor_id"));
				lock.setLockFlag(rs.getInt("lock_flag"));
				lock.setLockMemo(rs.getString("lock_memo"));
				lock.setLockStatus(rs.getInt("lock_status"));
				lock.setWaterNo(rs.getString("water_no"));
				l.add(lock);
			}
		} catch (CannotGetJdbcConnectionException e) {
			e.printStackTrace();
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			try {
				if (!rs.isClosed())
					rs.close();
				if (!ps.isClosed())
					ps.close();
				ps = null;
				if (null != conn && !conn.isClosed()) {
					conn.close();
					conn = null;
				}
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		if (l.size() == 0)
			return null;
		else
			return l;
	}

	@Override
	public void updateLockFlag(String dev_id, String lock_addr, int flag) {
		String sql = "update haibei_lock_t set lock_flag = ? , last_update = to_char(sysdate,'yyyy-mm-dd hh24:mi:ss') where dev_id = ?  and lock_addr = ?";
		PreparedStatement ps = null;
		Connection conn = null;
		try {
			conn = this.getConnection();
			ps = conn.prepareStatement(sql);
			ps.setInt(1, flag);
			ps.setString(2, dev_id);
			ps.setString(3, lock_addr);
			ps.execute();
		} catch (CannotGetJdbcConnectionException e) {
			e.printStackTrace();
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			try {
				if (!ps.isClosed())
					ps.close();
				ps = null;
				if (null != conn && !conn.isClosed()) {
					conn.close();
					conn = null;
				}
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
	}
}
