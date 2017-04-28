package com.haibei.pojo.lock;

public class Cmd {
    private String seqNo;

    private String devIp;

    private String devId;

    private String cmdPlain;

    private String cmdCipher;

    private String timeCreate;

    private String rtnPlain;

    private String rtnCipher;

    private Short timeCost;

    private Short cmdFlag;

    private Short eventId;

    private Short cmdStatus;

    private String lockAddr;

    private String timeDownload;

    private String timeReturn;

    private String lockId;

    private String lockName;

    private String rtn;

    private String lockUserSeq;
    
    private LockUser user;

    public String getSeqNo() {
        return seqNo;
    }

    public void setSeqNo(String seqNo) {
        this.seqNo = seqNo == null ? null : seqNo.trim();
    }

    public String getDevIp() {
        return devIp;
    }

    public void setDevIp(String devIp) {
        this.devIp = devIp == null ? null : devIp.trim();
    }

    public String getDevId() {
        return devId;
    }

    public void setDevId(String devId) {
        this.devId = devId == null ? null : devId.trim();
    }

    public String getCmdPlain() {
        return cmdPlain;
    }

    public void setCmdPlain(String cmdPlain) {
        this.cmdPlain = cmdPlain == null ? null : cmdPlain.trim();
    }

    public String getCmdCipher() {
        return cmdCipher;
    }

    public void setCmdCipher(String cmdCipher) {
        this.cmdCipher = cmdCipher == null ? null : cmdCipher.trim();
    }

    public String getTimeCreate() {
        return timeCreate;
    }

    public void setTimeCreate(String timeCreate) {
        this.timeCreate = timeCreate == null ? null : timeCreate.trim();
    }

    public String getRtnPlain() {
        return rtnPlain;
    }

    public void setRtnPlain(String rtnPlain) {
        this.rtnPlain = rtnPlain == null ? null : rtnPlain.trim();
    }

    public String getRtnCipher() {
        return rtnCipher;
    }

    public void setRtnCipher(String rtnCipher) {
        this.rtnCipher = rtnCipher == null ? null : rtnCipher.trim();
    }

    public Short getTimeCost() {
        return timeCost;
    }

    public void setTimeCost(Short timeCost) {
        this.timeCost = timeCost;
    }

    public Short getCmdFlag() {
        return cmdFlag;
    }

    public void setCmdFlag(Short cmdFlag) {
        this.cmdFlag = cmdFlag;
    }

    public Short getEventId() {
        return eventId;
    }

    public void setEventId(Short eventId) {
        this.eventId = eventId;
    }

    public Short getCmdStatus() {
        return cmdStatus;
    }

    public void setCmdStatus(Short cmdStatus) {
        this.cmdStatus = cmdStatus;
    }

    public String getLockAddr() {
        return lockAddr;
    }

    public void setLockAddr(String lockAddr) {
        this.lockAddr = lockAddr == null ? null : lockAddr.trim();
    }

    public String getTimeDownload() {
        return timeDownload;
    }

    public void setTimeDownload(String timeDownload) {
        this.timeDownload = timeDownload == null ? null : timeDownload.trim();
    }

    public String getTimeReturn() {
        return timeReturn;
    }

    public void setTimeReturn(String timeReturn) {
        this.timeReturn = timeReturn == null ? null : timeReturn.trim();
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

    public String getRtn() {
        return rtn;
    }

    public void setRtn(String rtn) {
        this.rtn = rtn == null ? null : rtn.trim();
    }

    public String getLockUserSeq() {
        return lockUserSeq;
    }

    public void setLockUserSeq(String lockUserSeq) {
        this.lockUserSeq = lockUserSeq == null ? null : lockUserSeq.trim();
    }

	public LockUser getUser() {
		return user;
	}

	public void setUser(LockUser user) {
		this.user = user;
	}
}