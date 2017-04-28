package com.haibei.pojo.lock;

public class Type {
    private Short devType;

    private String typeName;

    private Short devCrc;

    private Short devEncrypt;

    private String devKey;

    private String devParsing;

    public Short getDevType() {
        return devType;
    }

    public void setDevType(Short devType) {
        this.devType = devType;
    }

    public String getTypeName() {
        return typeName;
    }

    public void setTypeName(String typeName) {
        this.typeName = typeName == null ? null : typeName.trim();
    }

    public Short getDevCrc() {
        return devCrc;
    }

    public void setDevCrc(Short devCrc) {
        this.devCrc = devCrc;
    }

    public String getDevEncrypt() {
        return devEncrypt==null?"":devEncrypt.toString();
    }

    public void setDevEncrypt(String devEncrypt) {
        this.devEncrypt = Short.parseShort(devEncrypt==null?"0":devEncrypt);
    }

    public String getDevKey() {
        return devKey;
    }

    public void setDevKey(String devKey) {
        this.devKey = devKey == null ? null : devKey.trim();
    }

    public String getDevParsing() {
        return devParsing;
    }

    public void setDevParsing(String devParsing) {
        this.devParsing = devParsing == null ? null : devParsing.trim();
    }
}