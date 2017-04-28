package com.haibei.pojo.lock;

public class Device {
    private String devId;

    private String devName;

    private String buildingId;

    private String buildingName;

    private Short devStatus;

    private String devMemo;

    private String devIp;

    private Short devType;

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

    public String getBuildingId() {
        return buildingId;
    }

    public void setBuildingId(String buildingId) {
        this.buildingId = buildingId == null ? null : buildingId.trim();
    }

    public String getBuildingName() {
        return buildingName;
    }

    public void setBuildingName(String buildingName) {
        this.buildingName = buildingName == null ? null : buildingName.trim();
    }

    public Short getDevStatus() {
        return devStatus;
    }

    public void setDevStatus(Short devStatus) {
        this.devStatus = devStatus;
    }

    public String getDevMemo() {
        return devMemo;
    }

    public void setDevMemo(String devMemo) {
        this.devMemo = devMemo == null ? null : devMemo.trim();
    }

    public String getDevIp() {
        return devIp;
    }

    public void setDevIp(String devIp) {
        this.devIp = devIp == null ? null : devIp.trim();
    }

    public String getDevType() {
        return devType==null?"":devType.toString();
    }

    public void setDevType(String devType) {
        this.devType = Short.parseShort(devType==null?"0":devType);
    }
}