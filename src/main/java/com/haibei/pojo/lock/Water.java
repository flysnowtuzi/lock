package com.haibei.pojo.lock;

public class Water {
    private Long seqNo;

    private String devId;

    private String devName;

    private String lockId;

    private String lockName;

    private Short eventId;

    private String eventName;

    private String cardPhyid;

    private String timeCreate;

    private String timeReturn;

    private String userId;

    private String userName;

    private String deptId;

    private String deptName;

    private Short rtnFlag;

    private String rtnData;

    private String rtnJson;

    private String cmdNo;

    private Cmd cmd;
    
    public Long getSeqNo() {
        return seqNo;
    }

    public void setSeqNo(Long seqNo) {
        this.seqNo = seqNo;
    }

    public String getDevId() {
        return devId;
    }

    public void setDevId(String devId) {
        this.devId = devId == null ? null : devId.trim();
    }

    public String getDevName() {
        return devName;
    }

    public void setDevName(String devName) {
        this.devName = devName == null ? null : devName.trim();
    }

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

    public Short getEventId() {
        return eventId;
    }

    public void setEventId(Short eventId) {
        this.eventId = eventId;
    }

    public String getEventName() {
        return eventName;
    }

    public void setEventName(String eventName) {
        this.eventName = eventName == null ? null : eventName.trim();
    }

    public String getCardPhyid() {
        return cardPhyid;
    }

    public void setCardPhyid(String cardPhyid) {
        this.cardPhyid = cardPhyid == null ? null : cardPhyid.trim();
    }

    public String getTimeCreate() {
        return timeCreate;
    }

    public void setTimeCreate(String timeCreate) {
        this.timeCreate = timeCreate == null ? null : timeCreate.trim();
    }

    public String getTimeReturn() {
        return timeReturn;
    }

    public void setTimeReturn(String timeReturn) {
        this.timeReturn = timeReturn == null ? null : timeReturn.trim();
    }

    public String getUserId() {
        return userId;
    }

    public void setUserId(String userId) {
        this.userId = userId == null ? null : userId.trim();
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName == null ? null : userName.trim();
    }

    public String getDeptId() {
        return deptId;
    }

    public void setDeptId(String deptId) {
        this.deptId = deptId == null ? null : deptId.trim();
    }

    public String getDeptName() {
        return deptName;
    }

    public void setDeptName(String deptName) {
        this.deptName = deptName == null ? null : deptName.trim();
    }

    public Short getRtnFlag() {
        return rtnFlag;
    }

    public void setRtnFlag(Short rtnFlag) {
        this.rtnFlag = rtnFlag;
    }

    public String getRtnData() {
        return rtnData;
    }

    public void setRtnData(String rtnData) {
        this.rtnData = rtnData == null ? null : rtnData.trim();
    }

    public String getRtnJson() {
        return rtnJson;
    }

    public void setRtnJson(String rtnJson) {
        this.rtnJson = rtnJson == null ? null : rtnJson.trim();
    }

    public String getCmdNo() {
        return cmdNo;
    }

    public void setCmdNo(String cmdNo) {
        this.cmdNo = cmdNo == null ? null : cmdNo.trim();
    }

	public Cmd getCmd() {
		return cmd;
	}

	public void setCmd(Cmd cmd) {
		this.cmd = cmd;
	}
}