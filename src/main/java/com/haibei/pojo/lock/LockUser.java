package com.haibei.pojo.lock;

public class LockUser extends LockUserKey {
    private String userName;

    private Short lockUserAddr;

    private Short lockUserStatus;

    private String lockUserMemo;

    private String lastUpdate;

    private String validFrom;

    private String validTo;

    private String deptId;

    private String deptName;

    private String seqNo;

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName == null ? null : userName.trim();
    }

    public Short getLockUserAddr() {
        return lockUserAddr;
    }

    public void setLockUserAddr(Short lockUserAddr) {
        this.lockUserAddr = lockUserAddr;
    }

    public Short getLockUserStatus() {
        return lockUserStatus;
    }

    public void setLockUserStatus(Short lockUserStatus) {
        this.lockUserStatus = lockUserStatus;
    }

    public String getLockUserMemo() {
        return lockUserMemo;
    }

    public void setLockUserMemo(String lockUserMemo) {
        this.lockUserMemo = lockUserMemo == null ? null : lockUserMemo.trim();
    }

    public String getLastUpdate() {
        return lastUpdate;
    }

    public void setLastUpdate(String lastUpdate) {
        this.lastUpdate = lastUpdate == null ? null : lastUpdate.trim();
    }

    public String getValidFrom() {
        return validFrom;
    }

    public void setValidFrom(String validFrom) {
        this.validFrom = validFrom == null ? null : validFrom.trim();
    }

    public String getValidTo() {
        return validTo;
    }

    public void setValidTo(String validTo) {
        this.validTo = validTo == null ? null : validTo.trim();
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

    public String getSeqNo() {
        return seqNo;
    }

    public void setSeqNo(String seqNo) {
        this.seqNo = seqNo == null ? null : seqNo.trim();
    }
}