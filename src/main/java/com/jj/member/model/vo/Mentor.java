package com.jj.member.model.vo;

import java.sql.Date;

public class Mentor {
	private int userNo;
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
	
	public Mentor() {}

	public Mentor(int userNo, int clcgNo, String mtCompany, String mtJob, int mtGrade, String mtGrant,
			Date mt_Enrolldate, String empCardPath, String empCardOriginName, String idCardPath,
			String idCardOriginName) {
		super();
		this.userNo = userNo;
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
		return "Mentor [userNo=" + userNo + ", clcgNo=" + clcgNo + ", mtCompany=" + mtCompany + ", mtJob=" + mtJob
				+ ", mtGrade=" + mtGrade + ", mtGrant=" + mtGrant + ", mt_Enrolldate=" + mt_Enrolldate
				+ ", empCardPath=" + empCardPath + ", empCardOriginName=" + empCardOriginName + ", idCardPath="
				+ idCardPath + ", idCardOriginName=" + idCardOriginName + "]";
	}

	

	

	
	
	
}
