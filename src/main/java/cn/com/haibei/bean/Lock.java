package cn.com.haibei.bean;

public class Lock extends Device implements java.io.Serializable {

	private static final long serialVersionUID = 6596613266475203244L;
	
	private String lockId;// 锁的数据库编号
	private String lockName;// 锁的名称
	private String doorId;// 门编号(预留)
	private String lockAddr;// 锁的物理编号16进制
	private String floorId;// 楼层编号
	private int lockFlag;// 2：未知 1：离线  0：在线
	private String lockMemo;
	private int lockStatus; // 2：删除 1：停用 0：在用
	private String lastUpdate;

	public String getLockId() {
		return lockId;
	}

	public void setLockId(String lockId) {
		this.lockId = lockId;
	}

	public String getLockName() {
		return lockName;
	}

	public void setLockName(String lockName) {
		this.lockName = lockName;
	}

	public String getDoorId() {
		return doorId;
	}

	public void setDoorId(String doorId) {
		this.doorId = doorId;
	}

	public String getLockAddr() {
		return lockAddr;
	}

	public void setLockAddr(String lockAddr) {
		this.lockAddr = lockAddr;
	}

	public String getFloorId() {
		return floorId;
	}

	public void setFloorId(String floorId) {
		this.floorId = floorId;
	}

	public int getLockFlag() {
		return lockFlag;
	}

	public void setLockFlag(int lockFlag) {
		this.lockFlag = lockFlag;
	}

	public String getLockMemo() {
		return lockMemo;
	}

	public void setLockMemo(String lockMemo) {
		this.lockMemo = lockMemo;
	}

	public int getLockStatus() {
		return lockStatus;
	}

	public void setLockStatus(int lockStatus) {
		this.lockStatus = lockStatus;
	}

	public String getLastUpdate() {
		return lastUpdate;
	}

	public void setLastUpdate(String lastUpdate) {
		this.lastUpdate = lastUpdate;
	}

	@Override
	public String toString() {
		return "Lock [lockId=" + lockId + ", lockName=" + lockName + ", doorId=" + doorId + ", lockAddr=" + lockAddr + ", floorId=" + floorId
				+ ", lockFlag=" + lockFlag + ", lockMemo=" + lockMemo + ", lockStatus=" + lockStatus + ", lastUpdate=" + lastUpdate + "]";
	}

}
