package cn.com.haibei.bean;

public class Device implements java.io.Serializable {

	private static final long serialVersionUID = 6267285910344778968L;

	private String devId;
	private String devName;
	private String devIp;
	private int devType;
	private String devTypeName;
	private int crc;
	private int encrypt;
	private String key;
	private int devStatus;
	private String devMemo;
	private String devParsing;

	private String buildingId;
	private String buildingName;

	private boolean finished;// 是否有正在执行的命令
	private String download;// 记录命令开始执行的时间
	private int index; // 正在执行命令的位置索引
	private boolean online;// 是否已经连线
	private int failed;// 命令执行失败次数
	private String waterNo;// 流水记录当前行号
	private Integer readCmdFromDbFlag;

	public Device() {
		super();
		index = 0;
		failed = 0;
		finished = true;
		online = false;
		readCmdFromDbFlag = new Integer(0);
		waterNo = "00000000";
	}

	public Integer getReadCmdFromDbFlag() {
		return readCmdFromDbFlag;
	}

	public void setReadCmdFromDbFlag(Integer readCmdFromDbFlag) {
		this.readCmdFromDbFlag = readCmdFromDbFlag;
	}

	public String getWaterNo() {
		return waterNo;
	}

	public void setWaterNo(String waterNo) {
		this.waterNo = waterNo;
	}

	public int getFailed() {
		return failed;
	}

	public void setFailed(int failed) {
		this.failed = failed;
	}

	public String getDevParsing() {
		return devParsing;
	}

	public void setDevParsing(String devParsing) {
		this.devParsing = devParsing;
	}

	public String getDownload() {
		return download;
	}

	public void setDownload(String download) {
		this.download = download;
	}

	public String getKey() {
		return key;
	}

	public void setKey(String key) {
		this.key = key;
	}

	public boolean isOnline() {
		return online;
	}

	public void setOnline(boolean online) {
		this.online = online;
	}

	public int getIndex() {
		return index;
	}

	public void setIndex(int index) {
		this.index = index;
	}

	public boolean isFinished() {
		return finished;
	}

	public void setFinished(boolean finished) {
		this.finished = finished;
	}

	public String getDevId() {
		return devId;
	}

	public void setDevId(String devId) {
		this.devId = devId;
	}

	public String getDevName() {
		return devName;
	}

	public void setDevName(String devName) {
		this.devName = devName;
	}

	public String getDevIp() {
		return devIp;
	}

	public void setDevIp(String devIp) {
		this.devIp = devIp;
	}

	public int getDevType() {
		return devType;
	}

	public void setDevType(int devType) {
		this.devType = devType;
	}

	public String getDevTypeName() {
		return devTypeName;
	}

	public void setDevTypeName(String devTypeName) {
		this.devTypeName = devTypeName;
	}

	public int getCrc() {
		return crc;
	}

	public void setCrc(int crc) {
		this.crc = crc;
	}

	public int getEncrypt() {
		return encrypt;
	}

	public void setEncrypt(int encrypt) {
		this.encrypt = encrypt;
	}

	public int getDevStatus() {
		return devStatus;
	}

	public void setDevStatus(int devStatus) {
		this.devStatus = devStatus;
	}

	public String getDevMemo() {
		return devMemo;
	}

	public void setDevMemo(String devMemo) {
		this.devMemo = devMemo;
	}

	public String getBuildingId() {
		return buildingId;
	}

	public void setBuildingId(String buildingId) {
		this.buildingId = buildingId;
	}

	public String getBuildingName() {
		return buildingName;
	}

	public void setBuildingName(String buildingName) {
		this.buildingName = buildingName;
	}

}
