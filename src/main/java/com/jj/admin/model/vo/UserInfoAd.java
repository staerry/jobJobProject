package com.jj.admin.model.vo;

public class UserInfoAd {
	private int userNo;
	private String userId;
	private String userPwd;
	private String userName;
	private String adminStatus;
	
	public UserInfoAd() {}
	
	public UserInfoAd(int userNo, String userId, String userPwd, String userName, String adminStatus) {
		super();
		this.userNo = userNo;
		this.userId = userId;
		this.userPwd = userPwd;
		this.userName = userName;
		this.adminStatus = adminStatus;
	}

	public int getUserNo() {
		return userNo;
	}

	public void setUserNo(int userNo) {
		this.userNo = userNo;
	}

	public String getUserId() {
		return userId;
	}

	public void setUserId(String userId) {
		this.userId = userId;
	}

	public String getUserPwd() {
		return userPwd;
	}

	public void setUserPwd(String userPwd) {
		this.userPwd = userPwd;
	}

	public String getUserName() {
		return userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}

	public String getAdminStatus() {
		return adminStatus;
	}

	public void setAdminStatus(String adminStatus) {
		this.adminStatus = adminStatus;
	}

	@Override
	public String toString() {
		return "UserInfo [userNo=" + userNo + ", userId=" + userId + ", userPwd=" + userPwd + ", userName=" + userName
				+ ", adminStatus=" + adminStatus + "]";
	}
	
	
}
