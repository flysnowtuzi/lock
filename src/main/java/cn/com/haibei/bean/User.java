package cn.com.haibei.bean;

public class User extends Lock implements java.io.Serializable {

	private static final long serialVersionUID = 2163852887957222815L;
	private String seqNo;// 流水号
	private String cardPhyId;
	private String userId;// 用户id
	private String userName;// 卡户名
	private String deptId;// 用户部门id
	private String deptName;// 用户部门名称
	private String validFrom;// 有效期开始日期
	private String validTo;// 有效期结束日期
	private int openType;// 1:卡片用户；2:密码用户
	private int userAddr;// 锁上存储位置
	private int userStatus;// 0：有效；1：暂停；2：删除

	public String getSeqNo() {
		return seqNo;
	}

	public void setSeqNo(String seqNo) {
		this.seqNo = seqNo;
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

	public String getValidFrom() {
		return validFrom;
	}

	public void setValidFrom(String validFrom) {
		this.validFrom = validFrom;
	}

	public String getValidTo() {
		return validTo;
	}

	public void setValidTo(String validTo) {
		this.validTo = validTo;
	}

	public int getOpenType() {
		return openType;
	}

	public void setOpenType(int openType) {
		this.openType = openType;
	}

	public int getUserAddr() {
		return userAddr;
	}

	public void setUserAddr(int userAddr) {
		this.userAddr = userAddr;
	}

	public int getUserStatus() {
		return userStatus;
	}

	public void setUserStatus(int userStatus) {
		this.userStatus = userStatus;
	}

	@Override
	public String toString() {
		return "User [seqNo=" + seqNo + ", cardPhyId=" + cardPhyId + ", userId=" + userId + ", userName=" + userName + ", deptId=" + deptId
				+ ", deptName=" + deptName + ", validFrom=" + validFrom + ", validTo=" + validTo + ", openType=" + openType + ", userAddr="
				+ userAddr + ", userStatus=" + userStatus + "]";
	}

}
