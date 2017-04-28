package cn.com.haibei.bean;

public class Water extends Device implements java.io.Serializable {

	private static final long serialVersionUID = 5924674977123612620L;
	private String seqNo;// 流水号
	private String cmdNo;// 对应命令返回的流水号UUID
	private String cardPhyId;// 物理卡号
	private String lockId;//
	private String lockName;//
	private String lockAddr;//
	private String userId;// 用户id
	private String userName;// 卡户名
	private String deptId;// 用户部门id
	private String deptName;// 用户部门名称
	private String timeCreate;// 流水创建时间
	private String timeReturn;// 流水返回时间
	private int eventId;// 事件编号
	private String eventName;// 时间名称
	private int rtnFlag;// 返回的结果是否正确
	private String rtnData;// 返回的数据，用16进制存储
	private String rtnJson;// 返回的数据，用json存储

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

	public String getLockAddr() {
		return lockAddr;
	}

	public void setLockAddr(String lockAddr) {
		this.lockAddr = lockAddr;
	}

	public String getRtnJson() {
		return rtnJson;
	}

	public void setRtnJson(String rtnJson) {
		this.rtnJson = rtnJson;
	}

	public String getSeqNo() {
		return seqNo;
	}

	public void setSeqNo(String seqNo) {
		this.seqNo = seqNo;
	}

	public String getCmdNo() {
		return cmdNo;
	}

	public void setCmdNo(String cmdNo) {
		this.cmdNo = cmdNo;
	}

	public String getCardPhyId() {
		return cardPhyId;
	}

	public void setCardPhyId(String cardPhyId) {
		this.cardPhyId = cardPhyId;
	}

	public String getUserId() {
		return userId;
	}

	public void setUserId(String userId) {
		this.userId = userId;
	}

	public String getUserName() {
		return userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}

	public String getDeptId() {
		return deptId;
	}

	public void setDeptId(String deptId) {
		this.deptId = deptId;
	}

	public String getDeptName() {
		return deptName;
	}

	public void setDeptName(String deptName) {
		this.deptName = deptName;
	}

	public String getTimeCreate() {
		return timeCreate;
	}

	public void setTimeCreate(String timeCreate) {
		this.timeCreate = timeCreate;
	}

	public String getTimeReturn() {
		return timeReturn;
	}

	public void setTimeReturn(String timeReturn) {
		this.timeReturn = timeReturn;
	}

	public int getEventId() {
		return eventId;
	}

	public void setEventId(int eventId) {
		this.eventId = eventId;
	}

	public String getEventName() {
		return eventName;
	}

	public void setEventName(String eventName) {
		this.eventName = eventName;
	}

	public int getRtnFlag() {
		return rtnFlag;
	}

	public void setRtnFlag(int rtnFlag) {
		this.rtnFlag = rtnFlag;
	}

	public String getRtnData() {
		return rtnData;
	}

	public void setRtnData(String rtnData) {
		this.rtnData = rtnData;
	}

	@Override
	public String toString() {
		return "Water [seqNo=" + seqNo + ", cmdNo=" + cmdNo + ", cardPhyId=" + cardPhyId + ", userId=" + userId + ", userName=" + userName
				+ ", deptId=" + deptId + ", deptName=" + deptName + ", timeCreate=" + timeCreate + ", timeReturn=" + timeReturn + ", eventId="
				+ eventId + ", eventName=" + eventName + ", rtnFlag=" + rtnFlag + ", rtnData=" + rtnData + ", rtnJson=" + rtnJson + "]";
	}

}
