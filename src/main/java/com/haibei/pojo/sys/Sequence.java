package com.haibei.pojo.sys;

public class Sequence {
    private String sequenceCode;

    private Long sequenceLastId;

    private Long sequenceIncrease;

    public String getSequenceCode() {
        return sequenceCode;
    }

    public void setSequenceCode(String sequenceCode) {
        this.sequenceCode = sequenceCode;
    }

    public Long getSequenceLastId() {
        return sequenceLastId;
    }

    public void setSequenceLastId(Long sequenceLastId) {
        this.sequenceLastId = sequenceLastId;
    }

    public Long getSequenceIncrease() {
        return sequenceIncrease;
    }

    public void setSequenceIncrease(Long sequenceIncrease) {
        this.sequenceIncrease = sequenceIncrease;
    }
}