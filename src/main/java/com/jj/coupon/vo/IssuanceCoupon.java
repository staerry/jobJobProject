package com.jj.coupon.vo;

import java.sql.Date;

public class IssuanceCoupon {
	private int isuCpNo;
	private String userNo;
	private String cpNo;
	private String cpStatus;
	private Date cpIssuDate;
	private Date cpEndDate;
	private String userName;
	private String cpName;
	private String discount;
	private String discountWon;	// TO_CHAR 형태 변환용 (태은)
	
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

	public IssuanceCoupon(int isuCpNo, String cpName, String cpNo, Date cpEndDate, String discount,
			String discountWon) {
		super();
		this.isuCpNo = isuCpNo;
		this.cpName = cpName;
		this.cpNo = cpNo;
		this.cpEndDate = cpEndDate;
		this.discount = discount;
		this.discountWon = discountWon;
	}

	public IssuanceCoupon(int isuCpNo, String userNo, String cpNo, String cpStatus, Date cpIssuDate, Date cpEndDate,
			String userName, String cpName) {
		super();
		this.isuCpNo = isuCpNo;
		this.userNo = userNo;
		this.cpNo = cpNo;
		this.cpStatus = cpStatus;
		this.cpIssuDate = cpIssuDate;
		this.cpEndDate = cpEndDate;
		this.userName = userName;
		this.cpName = cpName;
	}
	
	public IssuanceCoupon(int isuCpNo, String cpName, String cpNo, Date cpEndDate, String discount) {
		super();
		this.isuCpNo = isuCpNo;
		this.cpName = cpName;
		this.cpNo = cpNo;
		this.cpEndDate = cpEndDate;
		this.discount = discount;
	}

	
	
	public String getDiscountWon() {
		return discountWon;
	}



	public void setDiscountWon(String discountWon) {
		this.discountWon = discountWon;
	}



	public String getDiscount() {
		return discount;
	}

	public void setDiscount(String discount) {
		this.discount = discount;
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
	
	

	public String getUserName() {
		return userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}
	
	

	public String getCpName() {
		return cpName;
	}

	public void setCpName(String cpName) {
		this.cpName = cpName;
	}

	@Override
	public String toString() {
		return "IssuanceCoupon [isuCpNo=" + isuCpNo + ", userNo=" + userNo + ", cpNo=" + cpNo + ", cpStatus=" + cpStatus
				+ ", cpIssuDate=" + cpIssuDate + ", cpEndDate=" + cpEndDate + "]";
	}
	
	
}
