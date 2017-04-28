package com.haibei.pojo.lock;

public class Lock {
    private String lockId;

    private String lockName;

    private String doorId;

    private String lockAddr;

    private String devId;

    private String floorId;

    private Short lockFlag;

    private String lockMemo;

    private Short lockStatus;

    private String lastUpdate;

    private String waterNo;
    
    /*private Device device;*/

    public String getLockId() {
        return lockId;
    }

    public void setLockId(String lockId) {
        this.lockId = lockId == null ? null : lockId.trim();
    }

    public String getLockName() {
        return lockName;
    }

    public void setLockName(String lockName) {
        this.lockName = lockName == null ? null : lockName.trim();
    }

    public String getDoorId() {
        return doorId;
    }

    public void setDoorId(String doorId) {
        this.doorId = doorId == null ? null : doorId.trim();
    }

    public String getLockAddr() {
        return lockAddr;
    }

    public void setLockAddr(String lockAddr) {
        this.lockAddr = lockAddr == null ? null : lockAddr.trim();
    }

    public String getDevId() {
        return devId;
    }

    public void setDevId(String devId) {
        this.devId = devId == null ? null : devId.trim();
    }

    public String getFloorId() {
        return floorId;
    }

    public void setFloorId(String floorId) {
        this.floorId = floorId == null ? null : floorId.trim();
    }

    public String getLockFlag() {
        return lockFlag==null?"":lockFlag.toString();
    }

    public void setLockFlag(String lockFlag) {
        this.lockFlag = Short.parseShort(lockFlag==null?"0":lockFlag);
    }

    public String getLockMemo() {
        return lockMemo;
    }

    public void setLockMemo(String lockMemo) {
        this.lockMemo = lockMemo == null ? null : lockMemo.trim();
    }

    public String getLockStatus() {
        return lockStatus==null?"":lockStatus.toString();
    }

    public void setLockStatus(String lockStatus) {
        this.lockStatus = Short.parseShort(lockStatus==null?"0":lockStatus);
    }

    public String getLastUpdate() {
        return lastUpdate;
    }

    public void setLastUpdate(String lastUpdate) {
        this.lastUpdate = lastUpdate == null ? null : lastUpdate.trim();
    }

    public String getWaterNo() {
        return waterNo;
    }

    public void setWaterNo(String waterNo) {
        this.waterNo = waterNo == null ? null : waterNo.trim();
    }


/*	public Device getDevice() {
		return device;
	}

	public void setDevice(Device device) {
		this.device = device;
	}*/
}