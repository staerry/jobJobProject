package com.jj.mentorSelect.model.vo;

public class Lecturer {
	
	private int userNo;
	private String userName;
	private String ltrCompany;
	private String ltrJob;
	private String ltrCategory;	// 멘토링 분야
	private String ltrInfo;
	private String ltrCareer;
	private String ltrProfilePath;
	
	public Lecturer() {}

	public Lecturer(int userNo, String ltrInfo, String ltrCareer, String ltrProfilePath) {
		super();
		this.userNo = userNo;
		this.ltrInfo = ltrInfo;
		this.ltrCareer = ltrCareer;
		this.ltrProfilePath = ltrProfilePath;
	}
	
	public Lecturer(int userNo, String userName, String ltrCompany, String ltrJob, String ltrCategory, String ltrInfo,
			String ltrCareer, String ltrProfilePath) {
		super();
		this.userNo = userNo;
		this.userName = userName;
		this.ltrCompany = ltrCompany;
		this.ltrJob = ltrJob;
		this.ltrCategory = ltrCategory;
		this.ltrInfo = ltrInfo;
		this.ltrCareer = ltrCareer;
		this.ltrProfilePath = ltrProfilePath;
	}

	public int getUserNo() {
		return userNo;
	}

	public void setUserNo(int userNo) {
		this.userNo = userNo;
	}

	public String getLtrInfo() {
		return ltrInfo;
	}

	public void setLtrInfo(String ltrInfo) {
		this.ltrInfo = ltrInfo;
	}

	public String getLtrCareer() {
		return ltrCareer;
	}

	public void setLtrCareer(String ltrCareer) {
		this.ltrCareer = ltrCareer;
	}

	public String getLtrProfilePath() {
		return ltrProfilePath;
	}

	public void setLtrProfilePath(String ltrProfilePath) {
		this.ltrProfilePath = ltrProfilePath;
	}

	public String getUserName() {
		return userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}

	public String getLtrCompany() {
		return ltrCompany;
	}

	public void setLtrCompany(String ltrCompany) {
		this.ltrCompany = ltrCompany;
	}

	public String getLtrJob() {
		return ltrJob;
	}

	public void setLtrJob(String ltrJob) {
		this.ltrJob = ltrJob;
	}

	public String getLtrCategory() {
		return ltrCategory;
	}

	public void setLtrCategory(String ltrCategory) {
		this.ltrCategory = ltrCategory;
	}


	@Override
	public String toString() {
		return "Lecturer [userNo=" + userNo + ", userName=" + userName + ", ltrCompany=" + ltrCompany + ", ltrJob="
				+ ltrJob + ", ltrCategory=" + ltrCategory + ", ltrInfo=" + ltrInfo + ", ltrCareer=" + ltrCareer
				+ ", ltrProfilePath=" + ltrProfilePath + "]";
	}
	
	
	

}
