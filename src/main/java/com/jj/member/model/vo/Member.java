package com.jj.member.model.vo;

import java.sql.Date;

public class Member {
		
	private int userNo;
	private String userId;
	private String userPwd;
	private String userName;
	private String userEmail;
	private String userPhone;
	private Date enrollDate;
	private String userStatus;
	private String adminStatus;
	private int userDivision;
	private int clcgNo;
	private String mtCompany;
	private String mtJob;
	private int mtGrade;
	private String mtGrant;
	private Date mt_Enrolldate;
	private String empCardPath;
	private String empCardOriginName;
	private String idCardPath;
	private String idCardOriginName;
	
	public Member() {}

	public Member(String userId, String userPwd, String userName, String userEmail, String userPhone) {
		super();
		this.userId = userId;
		this.userPwd = userPwd;
		this.userName = userName;
		this.userEmail = userEmail;
		this.userPhone = userPhone;
	}

	public Member(int userNo, String userId, String userPwd, String userName, String userEmail, String userPhone,
			Date enrollDate, String userStatus, String adminStatus, int userDivision) {
		super();
		this.userNo = userNo;
		this.userId = userId;
		this.userPwd = userPwd;
		this.userName = userName;
		this.userEmail = userEmail;
		this.userPhone = userPhone;
		this.enrollDate = enrollDate;
		this.userStatus = userStatus;
		this.adminStatus = adminStatus;
		this.userDivision = userDivision;
	}

	public Member(int userNo, String userId, String userPwd, String userName, String userEmail, String userPhone,
			Date enrollDate, String userStatus, String adminStatus, int userDivision, int clcgNo, String mtCompany,
			String mtJob, int mtGrade, String mtGrant, Date mt_Enrolldate, String empCardPath, String empCardOriginName,
			String idCardPath, String idCardOriginName) {
		super();
		this.userNo = userNo;
		this.userId = userId;
		this.userPwd = userPwd;
		this.userName = userName;
		this.userEmail = userEmail;
		this.userPhone = userPhone;
		this.enrollDate = enrollDate;
		this.userStatus = userStatus;
		this.adminStatus = adminStatus;
		this.userDivision = userDivision;
		this.clcgNo = clcgNo;
		this.mtCompany = mtCompany;
		this.mtJob = mtJob;
		this.mtGrade = mtGrade;
		this.mtGrant = mtGrant;
		this.mt_Enrolldate = mt_Enrolldate;
		this.empCardPath = empCardPath;
		this.empCardOriginName = empCardOriginName;
		this.idCardPath = idCardPath;
		this.idCardOriginName = idCardOriginName;
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

	public String getUserEmail() {
		return userEmail;
	}

	public void setUserEmail(String userEmail) {
		this.userEmail = userEmail;
	}

	public String getUserPhone() {
		return userPhone;
	}

	public void setUserPhone(String userPhone) {
		this.userPhone = userPhone;
	}

	public Date getEnrollDate() {
		return enrollDate;
	}

	public void setEnrollDate(Date enrollDate) {
		this.enrollDate = enrollDate;
	}

	public String getUserStatus() {
		return userStatus;
	}

	public void setUserStatus(String userStatus) {
		this.userStatus = userStatus;
	}

	public String getAdminStatus() {
		return adminStatus;
	}

	public void setAdminStatus(String adminStatus) {
		this.adminStatus = adminStatus;
	}

	public int getUserDivision() {
		return userDivision;
	}

	public void setUserDivision(int userDivision) {
		this.userDivision = userDivision;
	}

	public int getClcgNo() {
		return clcgNo;
	}

	public void setClcgNo(int clcgNo) {
		this.clcgNo = clcgNo;
	}

	public String getMtCompany() {
		return mtCompany;
	}

	public void setMtCompany(String mtCompany) {
		this.mtCompany = mtCompany;
	}

	public String getMtJob() {
		return mtJob;
	}

	public void setMtJob(String mtJob) {
		this.mtJob = mtJob;
	}

	public int getMtGrade() {
		return mtGrade;
	}

	public void setMtGrade(int mtGrade) {
		this.mtGrade = mtGrade;
	}

	public String getMtGrant() {
		return mtGrant;
	}

	public void setMtGrant(String mtGrant) {
		this.mtGrant = mtGrant;
	}

	public Date getMt_Enrolldate() {
		return mt_Enrolldate;
	}

	public void setMt_Enrolldate(Date mt_Enrolldate) {
		this.mt_Enrolldate = mt_Enrolldate;
	}

	public String getEmpCardPath() {
		return empCardPath;
	}

	public void setEmpCardPath(String empCardPath) {
		this.empCardPath = empCardPath;
	}

	public String getEmpCardOriginName() {
		return empCardOriginName;
	}

	public void setEmpCardOriginName(String empCardOriginName) {
		this.empCardOriginName = empCardOriginName;
	}

	public String getIdCardPath() {
		return idCardPath;
	}

	public void setIdCardPath(String idCardPath) {
		this.idCardPath = idCardPath;
	}

	public String getIdCardOriginName() {
		return idCardOriginName;
	}

	public void setIdCardOriginName(String idCardOriginName) {
		this.idCardOriginName = idCardOriginName;
	}

	@Override
	public String toString() {
		return "Member [userNo=" + userNo + ", userId=" + userId + ", userPwd=" + userPwd + ", userName=" + userName
				+ ", userEmail=" + userEmail + ", userPhone=" + userPhone + ", enrollDate=" + enrollDate
				+ ", userStatus=" + userStatus + ", adminStatus=" + adminStatus + ", userDivision=" + userDivision
				+ ", clcgNo=" + clcgNo + ", mtCompany=" + mtCompany + ", mtJob=" + mtJob + ", mtGrade=" + mtGrade
				+ ", mtGrant=" + mtGrant + ", mt_Enrolldate=" + mt_Enrolldate + ", empCardPath=" + empCardPath
				+ ", empCardOriginName=" + empCardOriginName + ", idCardPath=" + idCardPath + ", idCardOriginName="
				+ idCardOriginName + "]";
	}
	
}
