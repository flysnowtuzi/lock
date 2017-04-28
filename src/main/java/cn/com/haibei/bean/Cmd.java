package cn.com.haibei.bean;

public class Cmd extends Lock implements java.io.Serializable {

	private static final long serialVersionUID = -7084564467136233962L;

	private String seqNo;// 流水号UUID
	private String cmdPlain;// 命令明文
	private String cmdCipher;// 命令密文
	private String rtnPlain;// 返回明文
	private String rtnCipher;// 返回密文
	private int cmdFlag;// 命令标识 0：初始；1：成功，2：失败，3：超时
	private int eventId;// 事件编号
	private String eventName;// 时间名称
	private int cmdStatus;// 命令状态 0：未执行；1：已执行；2：已加载；3：运行中
	private Long timeCost;// 命令耗时
	private String timeCreate;// 命令创建时间
	private String timeDownload;// 命令下发时间
	private String timeReturn;// 命令返回时间
	private String rtnJson;// 返回的数据，用json存储

	private String rtn;// 返回匹配
	private String cardPhyId;// 物理卡号
	private String lockUserSeqNo;// haibei_lock_user_t的流水号
	private String batchNo;// 命令下发批次
	private String cmdUser;// 命令下发人
	private int runCnt;// 执行次数

	private Long start;// 用于记录命令下发的时间戳

	public int getRunCnt() {
		return runCnt;
	}

	public void setRunCnt(int runCnt) {
		this.runCnt = runCnt;
	}

	public Long getStart() {
		return start;
	}

	public void setStart(Long start) {
		this.start = start;
	}

	public String getBatchNo() {
		return batchNo;
	}

	public void setBatchNo(String batchNo) {
		this.batchNo = batchNo;
	}

	public String getCmdUser() {
		return cmdUser;
	}

	public void setCmdUser(String cmdUser) {
		this.cmdUser = cmdUser;
	}

	public String getLockUserSeqNo() {
		return lockUserSeqNo;
	}

	public void setLockUserSeqNo(String lockUserSeqNo) {
		this.lockUserSeqNo = lockUserSeqNo;
	}

	public String getCardPhyId() {
		return cardPhyId;
	}

	public void setCardPhyId(String cardPhyId) {
		this.cardPhyId = cardPhyId;
	}

	public String getRtnJson() {
		return rtnJson;
	}

	public void setRtnJson(String rtnJson) {
		this.rtnJson = rtnJson;
	}

	public Long getTimeCost() {
		return timeCost;
	}

	public void setTimeCost(Long timeCost) {
		this.timeCost = timeCost;
	}

	public String getRtn() {
		return rtn;
	}

	public void setRtn(String rtn) {
		this.rtn = rtn;
	}

	public String getSeqNo() {
		return seqNo;
	}

	public void setSeqNo(String seqNo) {
		this.seqNo = seqNo;
	}

	public String getCmdPlain() {
		return cmdPlain;
	}

	public void setCmdPlain(String cmdPlain) {
		this.cmdPlain = cmdPlain;
	}

	public String getCmdCipher() {
		return cmdCipher;
	}

	public void setCmdCipher(String cmdCipher) {
		this.cmdCipher = cmdCipher;
	}

	public String getRtnPlain() {
		return rtnPlain;
	}

	public void setRtnPlain(String rtnPlain) {
		this.rtnPlain = rtnPlain;
	}

	public String getRtnCipher() {
		return rtnCipher;
	}

	public void setRtnCipher(String rtnCipher) {
		this.rtnCipher = rtnCipher;
	}

	public int getCmdFlag() {
		return cmdFlag;
	}

	public void setCmdFlag(int cmdFlag) {
		this.cmdFlag = cmdFlag;
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

	public int getCmdStatus() {
		return cmdStatus;
	}

	public void setCmdStatus(int cmdStatus) {
		this.cmdStatus = cmdStatus;
	}

	public String getTimeCreate() {
		return timeCreate;
	}

	public void setTimeCreate(String timeCreate) {
		this.timeCreate = timeCreate;
	}

	public String getTimeDownload() {
		return timeDownload;
	}

	public void setTimeDownload(String timeDownload) {
		this.timeDownload = timeDownload;
	}

	public String getTimeReturn() {
		return timeReturn;
	}

	public void setTimeReturn(String timeReturn) {
		this.timeReturn = timeReturn;
	}

	@Override
	public String toString() {
		return "Cmd [seqNo=" + seqNo + ", cmdPlain=" + cmdPlain + ", cmdCipher=" + cmdCipher + ", rtnPlain=" + rtnPlain + ", rtnCipher=" + rtnCipher
				+ ", cmdFlag=" + cmdFlag + ", eventId=" + eventId + ", eventName=" + eventName + ", cmdStatus=" + cmdStatus + ", timeCost="
				+ timeCost + ", timeCreate=" + timeCreate + ", timeDownload=" + timeDownload + ", timeReturn=" + timeReturn + ", rtnJson=" + rtnJson
				+ ", rtn=" + rtn + ", cardPhyId=" + cardPhyId + ", lockUserSeqNo=" + lockUserSeqNo + ", batchNo=" + batchNo + ", cmdUser=" + cmdUser
				+ ", runCnt=" + runCnt + ", start=" + start + "]";
	}
}
