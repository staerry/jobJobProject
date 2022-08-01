package com.jj.coupon.vo;

import java.sql.Date;

public class IssuanceCoupon {
	private int isuCpNo;
	private String userNo;
	private String cpNo;
	private String cpStatus;
	private Date cpIssuDate;
	private Date cpEndDate;
	
	public IssuanceCoupon() {}

	public IssuanceCoupon(int isuCpNo, String userNo, String cpNo, String cpStatus, Date cpIssuDate, Date cpEndDate) {
		super();
		this.isuCpNo = isuCpNo;
		this.userNo = userNo;
		this.cpNo = cpNo;
		this.cpStatus = cpStatus;
		this.cpIssuDate = cpIssuDate;
		this.cpEndDate = cpEndDate;
	}

	public int getIsuCpNo() {
		return isuCpNo;
	}

	public void setIsuCpNo(int isuCpNo) {
		this.isuCpNo = isuCpNo;
	}

	public String getUserNo() {
		return userNo;
	}

	public void setUserNo(String userNo) {
		this.userNo = userNo;
	}

	public String getCpNo() {
		return cpNo;
	}

	public void setCpNo(String cpNo) {
		this.cpNo = cpNo;
	}

	public String getCpStatus() {
		return cpStatus;
	}

	public void setCpStatus(String cpStatus) {
		this.cpStatus = cpStatus;
	}

	public Date getCpIssuDate() {
		return cpIssuDate;
	}

	public void setCpIssuDate(Date cpIssuDate) {
		this.cpIssuDate = cpIssuDate;
	}

	public Date getCpEndDate() {
		return cpEndDate;
	}

	public void setCpEndDate(Date cpEndDate) {
		this.cpEndDate = cpEndDate;
	}

	@Override
	public String toString() {
		return "IssuanceCoupon [isuCpNo=" + isuCpNo + ", userNo=" + userNo + ", cpNo=" + cpNo + ", cpStatus=" + cpStatus
				+ ", cpIssuDate=" + cpIssuDate + ", cpEndDate=" + cpEndDate + "]";
	}
	
	
}
