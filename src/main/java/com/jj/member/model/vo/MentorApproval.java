package com.jj.member.model.vo;

public class MentorApproval {
	private String userNo;
	private String userName;
	private String userPhone;
	private String mtCompany;
	private String mtJob;
	private String userEmail;
	private String clcgNo;
	private String empCardPath;
	private String empCardOriginName;
	private String idCardPath;
	private String idCardoriginName;
	
	public MentorApproval() {
		
	}

	public MentorApproval(String userNo, String userName, String userEmail, String userPhone, String mtCompany,
			String mtJob) {
		super();
		this.userNo = userNo;
		this.userName = userName;
		this.userEmail = userEmail;
		this.userPhone = userPhone;
		this.mtCompany = mtCompany;
		this.mtJob = mtJob;
	}
	
	public MentorApproval(String userNo, String userName, String userPhone, String mtCompany, String mtJob,
			String userEmail, String clcgNo, String empCardPath, String idCardPath) {
		super();
		this.userNo = userNo;
		this.userName = userName;
		this.userPhone = userPhone;
		this.mtCompany = mtCompany;
		this.mtJob = mtJob;
		this.userEmail = userEmail;
		this.clcgNo = clcgNo;
		this.empCardPath = empCardPath;
		this.idCardPath = idCardPath;
	}

	public String getUserNo() {
		return userNo;
	}

	public void setUserNo(String userNo) {
		this.userNo = userNo;
	}

	public String getUserName() {
		return userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}

	public String getUserPhone() {
		return userPhone;
	}

	public void setUserPhone(String userPhone) {
		this.userPhone = userPhone;
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

	public String getUserEmail() {
		return userEmail;
	}

	public void setUserEmail(String userEmail) {
		this.userEmail = userEmail;
	}

	public String getClcgNo() {
		return clcgNo;
	}

	public void setClcgNo(String clcgNo) {
		this.clcgNo = clcgNo;
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

	public String getIdCardoriginName() {
		return idCardoriginName;
	}

	public void setIdCardoriginName(String idCardoriginName) {
		this.idCardoriginName = idCardoriginName;
	}

	@Override
	public String toString() {
		return "MentorApproval [userNo=" + userNo + ", userName=" + userName + ", userPhone=" + userPhone
				+ ", mtCompany=" + mtCompany + ", mtJob=" + mtJob + ", userEmail=" + userEmail + ", clcgNo=" + clcgNo
				+ ", empCardPath=" + empCardPath + ", empCardOriginName=" + empCardOriginName + ", idCardPath="
				+ idCardPath + ", idCardoriginName=" + idCardoriginName + "]";
	}
}