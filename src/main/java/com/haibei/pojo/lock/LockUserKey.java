package com.haibei.pojo.lock;

public class LockUserKey {
    private String cardPhyid;

    private String lockId;

    private Short openType;

    private String userId;

    public String getCardPhyid() {
        return cardPhyid;
    }

    public void setCardPhyid(String cardPhyid) {
        this.cardPhyid = cardPhyid == null ? null : cardPhyid.trim();
    }

    public String getLockId() {
        return lockId;
    }

    public void setLockId(String lockId) {
        this.lockId = lockId == null ? null : lockId.trim();
    }

    public Short getOpenType() {
        return openType;
    }

    public void setOpenType(Short openType) {
        this.openType = openType;
    }

    public String getUserId() {
        return userId;
    }

    public void setUserId(String userId) {
        this.userId = userId == null ? null : userId.trim();
    }
}