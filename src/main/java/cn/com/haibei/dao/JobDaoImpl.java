package cn.com.haibei.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.jdbc.CannotGetJdbcConnectionException;
import org.springframework.stereotype.Repository;

import cn.com.haibei.bean.Cmd;
import cn.com.haibei.bean.Job;
import cn.com.haibei.bean.User;
import cn.com.haibei.bean.Water;

@Repository
public class JobDaoImpl extends AutowiringJdbcDao implements JobDao {

	public List<Cmd> queryCmdByDevId(String dev_id, int size) {
		List<Cmd> l = new ArrayList<Cmd>();
		String sql = "select seq_no, c.dev_ip, c.dev_id, d.dev_name, lock_id, lock_name, lock_addr, cmd_plain, cmd_cipher, rtn_plain, rtn_cipher, cmd_flag, cmd_status, time_cost, time_create, time_download, time_return, c.event_id, e.event_name, rtn, lock_user_seq, run_cnt  "
				+ "from haibei_cmd_t c, haibei_event_t e, haibei_device_t d where c.dev_id = d.dev_id and c.event_id = e.event_id and c.dev_id = ? and cmd_flag = 0 and cmd_status = 0 and rownum <= ?";
		PreparedStatement ps = null;
		PreparedStatement ps_update = null;
		ResultSet rs = null;
		Connection conn = null;
		try {
			conn = this.getConnection();
			ps = conn.prepareStatement(sql, ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_READ_ONLY);
			ps.setString(1, dev_id);
			ps.setInt(2, size);
			rs = ps.executeQuery();
			while (rs.next()) {
				String sql_update = "update haibei_cmd_t set cmd_status = 2 where seq_no = ?";
				ps_update = conn.prepareStatement(sql_update);
				ps_update.setString(1, rs.getString("seq_no"));
				ps_update.execute();
				ps_update.close();

				Cmd c = new Cmd();
				c.setSeqNo(rs.getString("seq_no"));
				c.setDevIp(rs.getString("dev_ip"));
				c.setDevId(rs.getString("dev_id"));
				c.setDevName(rs.getString("dev_name"));
				c.setLockId(rs.getString("lock_id"));
				c.setLockName(rs.getString("lock_name"));
				c.setLockAddr(rs.getString("lock_addr"));
				c.setCmdPlain(rs.getString("cmd_plain"));
				c.setCmdCipher(rs.getString("cmd_cipher"));
				c.setRtnPlain(rs.getString("rtn_plain"));
				c.setRtnCipher(rs.getString("rtn_cipher"));
				c.setCmdFlag(rs.getInt("cmd_flag"));
				c.setCmdStatus(rs.getInt("cmd_status"));
				c.setTimeCost(rs.getLong("time_cost"));
				c.setTimeCreate(rs.getString("time_create"));
				c.setTimeDownload(rs.getString("time_download"));
				c.setTimeReturn(rs.getString("time_return"));
				c.setEventId(rs.getInt("event_id"));
				c.setEventName(rs.getString("event_name"));
				c.setRtn(rs.getString("rtn"));
				c.setLockUserSeqNo(rs.getString("lock_user_seq"));
				c.setRunCnt(rs.getInt("run_cnt"));
				l.add(c);
			}
		} catch (CannotGetJdbcConnectionException e) {
			e.printStackTrace();
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			try {
				if (rs != null && !rs.isClosed())
					rs.close();
				if (ps != null && !ps.isClosed())
					ps.close();
				if (ps_update != null && !ps_update.isClosed())
					ps_update.close();
				ps = null;
				ps_update = null;
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

	public void saveCmdRtnByPk(String seq_no, String rtn_plain, String rtn_cipher, Long time_cost, String time_download, int cmd_flag,
			String time_return) {
		String sql = "update haibei_cmd_t set rtn_plain = ?, rtn_cipher = ?, time_cost = ?, time_download = ?, cmd_flag = ?, cmd_status = 1, time_return = ?, run_cnt = run_cnt + 1  where seq_no = ?";
		PreparedStatement ps = null;
		Connection conn = null;
		try {
			conn = this.getConnection();
			ps = conn.prepareStatement(sql);
			ps.setString(1, rtn_plain);
			ps.setString(2, rtn_cipher);
			ps.setLong(3, time_cost);
			ps.setString(4, time_download);
			ps.setInt(5, cmd_flag);
			ps.setString(6, time_return);
			ps.setString(7, seq_no);
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

	public void saveCmdFlagByPk(String seq_no, int cmd_flag, String time_return) {
		String sql = "update haibei_cmd_t set cmd_flag = ?, cmd_status=1, time_return = ? where seq_no = ?";
		PreparedStatement ps = null;
		Connection conn = null;
		try {
			conn = this.getConnection();
			ps = conn.prepareStatement(sql);
			ps.setInt(1, cmd_flag);
			ps.setString(2, time_return);
			ps.setString(3, seq_no);
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

	public User queryLockUserByPk(String lock_id, String card_phy_id, int open_type) {
		User u = null;
		String sql = "select * from haibei_lock_user_v where lock_id = ? and card_phyid = ? and open_type = ?";
		PreparedStatement ps = null;
		ResultSet rs = null;
		Connection conn = null;
		try {
			conn = this.getConnection();
			ps = conn.prepareStatement(sql, ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_READ_ONLY);
			ps.setString(1, lock_id);
			ps.setString(2, card_phy_id);
			ps.setInt(3, open_type);
			rs = ps.executeQuery();
			rs.last(); // 移动到最后一行
			int rownum = rs.getRow(); // 获得当前行的行号，即记录的条数
			if (rownum != 1)
				return u;

			rs.absolute(1); // 将指针返回至第一条记录
			u = new User();
			u.setSeqNo(rs.getString("seq_no"));
			u.setUserId(rs.getString("user_id"));
			u.setUserName(rs.getString("user_name"));
			u.setDeptId(rs.getString("dept_id"));
			u.setDeptName(rs.getString("dept_name"));
			u.setValidFrom(rs.getString("valid_from"));
			u.setValidTo(rs.getString("valid_to"));
			u.setOpenType(rs.getInt("open_type"));
			u.setCardPhyId(rs.getString("card_phyid"));
			u.setUserAddr(rs.getInt("lock_user_addr"));
			u.setUserStatus(rs.getInt("lock_user_status"));
			u.setLastUpdate(rs.getString("last_update"));

			u.setLockId(rs.getString("lock_id"));
			u.setLockName(rs.getString("lock_name"));
			u.setDoorId(rs.getString("door_id"));
			u.setLockAddr(rs.getString("lock_addr"));
			u.setDevId(rs.getString("dev_id"));
			u.setFloorId(rs.getString("floor_id"));
			u.setLockFlag(rs.getInt("lock_flag"));
			u.setWaterNo(rs.getString("water_no"));
			u.setLockStatus(rs.getInt("lock_status"));

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
		return u;
	}

	public void saveCmd(Cmd cmd) {
		String sql = "insert into haibei_cmd_t(seq_no, dev_id, dev_ip, cmd_plain, cmd_cipher, lock_addr, lock_id, lock_name, event_id, rtn, lock_user_seq,cmd_status,cmd_flag,time_create,batch_no,cmd_user) values(?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?)";
		PreparedStatement ps = null;
		Connection conn = null;
		try {
			conn = this.getConnection();
			ps = conn.prepareStatement(sql);
			ps.setString(1, cmd.getSeqNo());
			ps.setString(2, cmd.getDevId());
			ps.setString(3, cmd.getDevIp());
			ps.setString(4, cmd.getCmdPlain());
			ps.setString(5, cmd.getCmdCipher());
			ps.setString(6, cmd.getLockAddr());
			ps.setString(7, cmd.getLockId());
			ps.setString(8, cmd.getLockName());
			ps.setInt(9, cmd.getEventId());
			ps.setString(10, cmd.getRtn());
			ps.setString(11, cmd.getLockUserSeqNo() == null ? "N/A" : cmd.getLockUserSeqNo());
			ps.setInt(12, 0);
			ps.setInt(13, 0);
			ps.setString(14, cmd.getTimeCreate());
			ps.setString(15, cmd.getBatchNo());
			ps.setString(16, cmd.getCmdUser() == null ? "SYS" : cmd.getCmdUser());
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

	public void updateLockUserStatusBySeqNo(String seq_no, int status) {
		String sql = "update haibei_lock_user_t set lock_user_status = ? where seq_no = ?";
		PreparedStatement ps = null;
		Connection conn = null;
		try {
			conn = this.getConnection();
			ps = conn.prepareStatement(sql);
			ps.setInt(1, status);
			ps.setString(2, seq_no);
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

	public List<User> queryLockUserByStatus(String lock_id, int status) {
		List<User> l = new ArrayList<User>();
		String sql = "select * from haibei_lock_user_v where lock_id = ? and lock_user_status = ?";
		PreparedStatement ps = null;
		ResultSet rs = null;
		Connection conn = null;
		try {
			conn = this.getConnection();
			ps = conn.prepareStatement(sql, ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_READ_ONLY);
			ps.setString(1, lock_id);
			ps.setInt(2, status);
			rs = ps.executeQuery();
			while (rs.next()) {
				User u = new User();
				u.setSeqNo(rs.getString("seq_no"));
				u.setUserId(rs.getString("user_id"));
				u.setUserName(rs.getString("user_name"));
				u.setDeptId(rs.getString("dept_id"));
				u.setDeptName(rs.getString("dept_name"));
				u.setValidFrom(rs.getString("valid_from"));
				u.setValidTo(rs.getString("valid_to"));
				u.setOpenType(rs.getInt("open_type"));
				u.setCardPhyId(rs.getString("card_phyid"));
				u.setUserAddr(rs.getInt("lock_user_addr"));
				u.setUserStatus(rs.getInt("lock_user_status"));
				u.setLastUpdate(rs.getString("last_update"));

				u.setLockId(rs.getString("lock_id"));
				u.setLockName(rs.getString("lock_name"));
				u.setDoorId(rs.getString("door_id"));
				u.setLockAddr(rs.getString("lock_addr"));
				u.setDevId(rs.getString("dev_id"));
				u.setFloorId(rs.getString("floor_id"));
				u.setLockFlag(rs.getInt("lock_flag"));
				u.setWaterNo(rs.getString("water_no"));
				u.setLockStatus(rs.getInt("lock_status"));
				l.add(u);
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

	public User queryLockUserMaxAddr(String lock_id) {
		User u = null;
		String sql = "select * from (select * from haibei_lock_user_v where lock_id = ? order by lock_user_addr desc) where rownum = 1";
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
				return u;

			rs.absolute(1); // 将指针返回至第一条记录
			u = new User();
			u.setSeqNo(rs.getString("seq_no"));
			u.setUserId(rs.getString("user_id"));
			u.setUserName(rs.getString("user_name"));
			u.setDeptId(rs.getString("dept_id"));
			u.setDeptName(rs.getString("dept_name"));
			u.setValidFrom(rs.getString("valid_from"));
			u.setValidTo(rs.getString("valid_to"));
			u.setOpenType(rs.getInt("open_type"));
			u.setCardPhyId(rs.getString("card_phyid"));
			u.setUserAddr(rs.getInt("lock_user_addr"));
			u.setUserStatus(rs.getInt("lock_user_status"));
			u.setLastUpdate(rs.getString("last_update"));

			u.setLockId(rs.getString("lock_id"));
			u.setLockName(rs.getString("lock_name"));
			u.setDoorId(rs.getString("door_id"));
			u.setLockAddr(rs.getString("lock_addr"));
			u.setDevId(rs.getString("dev_id"));
			u.setFloorId(rs.getString("floor_id"));
			u.setLockFlag(rs.getInt("lock_flag"));
			u.setWaterNo(rs.getString("water_no"));
			u.setLockStatus(rs.getInt("lock_status"));

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
		return u;
	}

	public void saveLockUser(User u) {
		String sql = "insert into haibei_lock_user_t(lock_id, user_id, user_name, card_phyid, lock_user_addr,lock_user_status, open_type, seq_no) values(?,?,?,?,?,?,?,?)";
		PreparedStatement ps = null;
		Connection conn = null;
		try {
			conn = this.getConnection();
			ps = conn.prepareStatement(sql);
			ps.setString(1, u.getLockId());
			ps.setString(2, u.getUserId());
			ps.setString(3, u.getUserName());
			ps.setString(4, u.getCardPhyId());
			ps.setInt(5, u.getUserAddr());
			ps.setInt(6, u.getUserStatus());
			ps.setInt(7, u.getOpenType());
			ps.setString(8, u.getSeqNo());
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

	public void saveWater(Water w) {
		String sql = "insert into haibei_water_t(seq_no, dev_id, dev_name, lock_id, lock_name, event_id, event_name, card_phyid, time_create, time_return,  user_id, user_name, dept_id, dept_name, rtn_flag, rtn_data, rtn_json, cmd_no) values"
				+ "(haibei_water_s.nextval,?,?,?,?,?,(select event_name from haibei_event_t where event_id= ?),?,?,?,?,?,?,?,?,?,?,?)";
		PreparedStatement ps = null;
		Connection conn = null;
		try {
			conn = this.getConnection();
			ps = conn.prepareStatement(sql);
			ps.setString(1, w.getDevId());
			ps.setString(2, w.getDevName());
			ps.setString(3, w.getLockId());
			ps.setString(4, w.getLockName());
			ps.setInt(5, w.getEventId());
			ps.setInt(6, w.getEventId());
			ps.setString(7, w.getCardPhyId());
			ps.setString(8, w.getTimeCreate());
			ps.setString(9, w.getTimeReturn());
			ps.setString(10, w.getUserId());
			ps.setString(11, w.getUserName());
			ps.setString(12, w.getDeptId());
			ps.setString(13, w.getDeptName());
			ps.setInt(14, w.getRtnFlag());
			ps.setString(15, w.getRtnData());
			ps.setString(16, w.getRtnJson());
			ps.setString(17, w.getCmdNo());
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

	public void updateLockUser(User u) {
		String sql = "update haibei_lock_user_t set lock_user_status = ?, user_id = ?, user_name = ?, card_phyid = ?, lock_user_addr = ?, last_update = to_char(sysdate,'yyyy-mm-dd hh24:mi:ss'), open_type = ?, dept_id = ?, dept_name = ?, valid_from = to_char(sysdate,'yyyy-mm-dd') where seq_no = ?";
		PreparedStatement ps = null;
		Connection conn = null;
		try {
			conn = this.getConnection();
			ps = conn.prepareStatement(sql);
			ps.setInt(1, u.getUserStatus());
			ps.setString(2, u.getUserId());
			ps.setString(3, u.getUserName());
			ps.setString(4, u.getCardPhyId());
			ps.setInt(5, u.getUserAddr());
			ps.setInt(6, u.getOpenType());
			ps.setString(7, u.getDeptId());
			ps.setString(8, u.getDeptName());
			ps.setString(9, u.getSeqNo());
			ps.execute();
		} catch (CannotGetJdbcConnectionException e) {
			e.printStackTrace();
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			try {
				if (null != ps && !ps.isClosed())
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

	public Water queryWaterByCmdNo(String cmd_no) {
		Water w = null;
		String sql = "select * from haibei_water_t where cmd_no = ?";
		PreparedStatement ps = null;
		ResultSet rs = null;
		Connection conn = null;
		try {
			conn = this.getConnection();
			ps = conn.prepareStatement(sql, ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_READ_ONLY);
			ps.setString(1, cmd_no);
			rs = ps.executeQuery();
			rs.last(); // 移动到最后一行
			int rownum = rs.getRow(); // 获得当前行的行号，即记录的条数
			if (rownum != 1)
				return w;

			rs.absolute(1); // 将指针返回至第一条记录
			w = new Water();
			w.setSeqNo(rs.getString("seq_no"));
			w.setDevId(rs.getString("dev_id"));
			w.setDevName(rs.getString("dev_name"));
			w.setLockId(rs.getString("lock_id"));
			w.setLockName(rs.getString("lock_name"));
			w.setEventId(rs.getInt("event_id"));
			w.setEventName(rs.getString("event_name"));
			w.setCardPhyId(rs.getString("card_phyid"));
			w.setTimeCreate(rs.getString("time_create"));
			w.setTimeReturn(rs.getString("time_return"));
			w.setUserId(rs.getString("user_id"));
			w.setUserName(rs.getString("user_name"));
			w.setDeptId(rs.getString("dept_id"));
			w.setDeptName(rs.getString("dept_name"));
			w.setRtnFlag(rs.getInt("rtn_flag"));
			w.setRtnData(rs.getString("rtn_data"));
			w.setRtnJson(rs.getString("rtn_json"));
			w.setCmdNo(rs.getString("cmd_no"));

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
		return w;
	}

	public User queryLockUserBySeqNo(String seq_no) {
		User u = null;
		String sql = "select * from haibei_lock_user_v where seq_no = ? ";
		PreparedStatement ps = null;
		ResultSet rs = null;
		Connection conn = null;
		try {
			conn = this.getConnection();
			ps = conn.prepareStatement(sql, ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_READ_ONLY);
			ps.setString(1, seq_no);
			rs = ps.executeQuery();
			rs.last(); // 移动到最后一行
			int rownum = rs.getRow(); // 获得当前行的行号，即记录的条数
			if (rownum != 1)
				return u;

			rs.absolute(1); // 将指针返回至第一条记录
			u = new User();
			u.setSeqNo(rs.getString("seq_no"));
			u.setUserId(rs.getString("user_id"));
			u.setUserName(rs.getString("user_name"));
			u.setDeptId(rs.getString("dept_id"));
			u.setDeptName(rs.getString("dept_name"));
			u.setValidFrom(rs.getString("valid_from"));
			u.setValidTo(rs.getString("valid_to"));
			u.setOpenType(rs.getInt("open_type"));
			u.setCardPhyId(rs.getString("card_phyid"));
			u.setUserAddr(rs.getInt("lock_user_addr"));
			u.setUserStatus(rs.getInt("lock_user_status"));
			u.setLastUpdate(rs.getString("last_update"));

			u.setLockId(rs.getString("lock_id"));
			u.setLockName(rs.getString("lock_name"));
			u.setDoorId(rs.getString("door_id"));
			u.setLockAddr(rs.getString("lock_addr"));
			u.setDevId(rs.getString("dev_id"));
			u.setFloorId(rs.getString("floor_id"));
			u.setLockFlag(rs.getInt("lock_flag"));
			u.setWaterNo(rs.getString("water_no"));
			u.setLockStatus(rs.getInt("lock_status"));

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
		return u;
	}

	@Override
	public int queryNewCmd(List<Job> j, int size) {
		int r = 0;
		PreparedStatement ps_query = null;
		PreparedStatement ps_update = null;
		ResultSet rs = null;
		Connection conn = null;
		try {
			conn = this.getConnection();
			for (int i = 0; i < j.size(); i++) {
				if (!j.get(i).getDev().isOnline())
					continue;
				if (j.get(i).getDev().getReadCmdFromDbFlag().intValue() == 1)
					continue;
				if (j.get(i).getCmd() != null && j.get(i).getCmd().size() != 0)
					continue;
				j.get(i).getDev().setReadCmdFromDbFlag(new Integer(1));
				String sql_query = "select seq_no, c.dev_ip, c.dev_id, d.dev_name, lock_id, lock_name, lock_addr, cmd_plain, cmd_cipher, rtn_plain, rtn_cipher, cmd_flag, cmd_status, time_cost, time_create, time_download, time_return, c.event_id, e.event_name, rtn, lock_user_seq  "
						+ "from haibei_cmd_t c, haibei_event_t e, haibei_device_t d where c.dev_id = d.dev_id and c.event_id = e.event_id and c.dev_id = ? and cmd_status > 0 and cmd_flag = 0 and rownum <= ?";

				ps_query = conn.prepareStatement(sql_query, ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_READ_ONLY);
				ps_query.setString(1, j.get(i).getDev().getDevId());
				ps_query.setInt(2, size);
				rs = ps_query.executeQuery();
				while (rs.next()) {
					Cmd c = new Cmd();
					c.setSeqNo(rs.getString("seq_no"));
					c.setDevIp(rs.getString("dev_ip"));
					c.setDevId(rs.getString("dev_id"));
					c.setDevName(rs.getString("dev_name"));
					c.setLockId(rs.getString("lock_id"));
					c.setLockName(rs.getString("lock_name"));
					c.setLockAddr(rs.getString("lock_addr"));
					c.setCmdPlain(rs.getString("cmd_plain"));
					c.setCmdCipher(rs.getString("cmd_cipher"));
					c.setRtnPlain(rs.getString("rtn_plain"));
					c.setRtnCipher(rs.getString("rtn_cipher"));
					c.setCmdFlag(rs.getInt("cmd_flag"));
					c.setCmdStatus(rs.getInt("cmd_status"));
					c.setTimeCost(rs.getLong("time_cost"));
					c.setTimeCreate(rs.getString("time_create"));
					c.setTimeDownload(rs.getString("time_download"));
					c.setTimeReturn(rs.getString("time_return"));
					c.setEventId(rs.getInt("event_id"));
					c.setEventName(rs.getString("event_name"));
					c.setRtn(rs.getString("rtn"));
					c.setLockUserSeqNo(rs.getString("lock_user_seq"));
					if (j.get(i).getCmd() == null)
						j.get(i).setCmd(new ArrayList<Cmd>());
					j.get(i).getCmd().add(c);
					r++;

					String sql_update = "update haibei_cmd_t set cmd_status = 2 where seq_no = ?";
					ps_update = conn.prepareStatement(sql_update);
					ps_update.setString(1, c.getSeqNo());
					ps_update.execute();
					ps_update.close();
				}
				ps_query.close();
				j.get(i).getDev().setReadCmdFromDbFlag(new Integer(0));
			}
		} catch (CannotGetJdbcConnectionException e) {
			e.printStackTrace();
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			try {
				if (rs != null && !rs.isClosed())
					rs.close();
				if (ps_query != null && !ps_query.isClosed())
					ps_query.close();
				ps_query = null;
				if (ps_update != null && !ps_update.isClosed())
					ps_update.close();
				ps_update = null;
				if (null != conn && !conn.isClosed()) {
					conn.close();
					conn = null;
				}
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		return r;
	}

	@Override
	public List<Map<String, String>> queryLog(Long timestamp) {
		List<Map<String, String>> rtn = new ArrayList<Map<String, String>>();
		PreparedStatement ps_query = null;
		PreparedStatement ps_update = null;
		ResultSet rs = null;
		Connection conn = null;
		try {
			conn = this.getConnection();
			String sql_query = "select timestmp, formatted_message, level_string, logger_name,event_id  from LOGGING_EVENT  where timestmp > ? order by event_id asc ";
			ps_query = conn.prepareStatement(sql_query, ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_READ_ONLY);
			ps_query.setLong(1, timestamp);
			rs = ps_query.executeQuery();
			while (rs.next()) {
				Map<String, String> m = new HashMap<String, String>();
				m.put("TIME", String.valueOf(rs.getLong("timestmp")));
				m.put("MSG", rs.getString("formatted_message"));
				m.put("LEVEL", rs.getString("level_string"));
				m.put("LOGGER", rs.getString("logger_name"));
				m.put("EVENT", String.valueOf(rs.getInt("event_id")));
				rtn.add(m);
			}
		} catch (CannotGetJdbcConnectionException e) {
			e.printStackTrace();
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			try {
				if (rs != null && !rs.isClosed())
					rs.close();
				if (ps_query != null && !ps_query.isClosed())
					ps_query.close();
				ps_query = null;
				if (ps_update != null && !ps_update.isClosed())
					ps_update.close();
				ps_update = null;
				if (null != conn && !conn.isClosed()) {
					conn.close();
					conn = null;
				}
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		return rtn;
	}

	@Override
	public int updateDeviceCmd4RunAgain(String dev_id, int size, int flag, int run_cnt, int[] event) {
		String sql = "select seq_no, dev_ip, dev_id, cmd_flag, cmd_status, event_id, run_cnt  from haibei_cmd_t "
				+ "where dev_id = ? and cmd_flag = ? and cmd_status = 1 and run_cnt <= ? order by run_cnt asc,time_create asc";
		PreparedStatement ps = null;
		PreparedStatement ps_update = null;
		ResultSet rs = null;
		Connection conn = null;
		int cnt = 0;
		try {
			conn = this.getConnection();
			ps = conn.prepareStatement(sql, ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_READ_ONLY);
			ps.setString(1, dev_id);
			ps.setInt(2, flag);
			ps.setInt(3, run_cnt);
			rs = ps.executeQuery();
			while (rs.next()) {
				int event_id = rs.getInt("event_id");
				for (int i = 0; i < event.length; i++) {
					if (event_id == event[i]) {
						cnt++;
						String sql_update = "update haibei_cmd_t set cmd_status = 0, cmd_flag = 0 where seq_no = ?";
						ps_update = conn.prepareStatement(sql_update);
						ps_update.setString(1, rs.getString("seq_no"));
						ps_update.execute();
						ps_update.close();
						if (cnt == size)
							break;
					}
				}
			}
		} catch (CannotGetJdbcConnectionException e) {
			e.printStackTrace();
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			try {
				if (rs != null && !rs.isClosed())
					rs.close();
				if (ps != null && !ps.isClosed())
					ps.close();
				if (ps_update != null && !ps_update.isClosed())
					ps_update.close();
				ps = null;
				ps_update = null;
				if (null != conn && !conn.isClosed()) {
					conn.close();
					conn = null;
				}
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		return cnt;
	}
}
