package com.haibei.pojo.sys;

import java.util.Date;

public class Code {
    private Integer codeId;

    private String codeName;

    private String codeDescribing;

    private String codeOrder;

    private String codeParentNo;

    private String codeNo;

    private String codeType;

    private Integer createdBy;

    private Date creationTime;

    private Integer modifiedBy;

    private Date modificationTime;

    private String deleteStatus;

    private String codeParentName;
    
    private Integer tableVer;

    public Integer getCodeId() {
        return codeId;
    }

    public void setCodeId(Integer codeId) {
        this.codeId = codeId;
    }

    public String getCodeName() {
        return codeName;
    }

    public void setCodeName(String codeName) {
        this.codeName = codeName;
    }

    public String getCodeDescribing() {
        return codeDescribing;
    }

    public void setCodeDescribing(String codeDescribing) {
        this.codeDescribing = codeDescribing;
    }

    public String getCodeOrder() {
        return codeOrder;
    }

    public void setCodeOrder(String codeOrder) {
        this.codeOrder = codeOrder;
    }

    public String getCodeParentNo() {
        return codeParentNo;
    }

    public void setCodeParentNo(String codeParentNo) {
        this.codeParentNo = codeParentNo;
    }

    public String getCodeNo() {
        return codeNo;
    }

    public void setCodeNo(String codeNo) {
        this.codeNo = codeNo;
    }

    public String getCodeType() {
        return codeType;
    }

    public void setCodeType(String codeType) {
        this.codeType = codeType;
    }

    public Integer getCreatedBy() {
        return createdBy;
    }

    public void setCreatedBy(Integer createdBy) {
        this.createdBy = createdBy;
    }

    public Date getCreationTime() {
        return creationTime;
    }

    public void setCreationTime(Date creationTime) {
        this.creationTime = creationTime;
    }

    public Integer getModifiedBy() {
        return modifiedBy;
    }

    public void setModifiedBy(Integer modifiedBy) {
        this.modifiedBy = modifiedBy;
    }

    public Date getModificationTime() {
        return modificationTime;
    }

    public void setModificationTime(Date modificationTime) {
        this.modificationTime = modificationTime;
    }

    public String getDeleteStatus() {
        return deleteStatus;
    }

    public void setDeleteStatus(String deleteStatus) {
        this.deleteStatus = deleteStatus;
    }

    public Integer getTableVer() {
        return tableVer;
    }

    public void setTableVer(Integer tableVer) {
        this.tableVer = tableVer;
    }

	public String getCodeParentName() {
		return codeParentName;
	}

	public void setCodeParentName(String codeParentName) {
		this.codeParentName = codeParentName;
	}
    
    
}