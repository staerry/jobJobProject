package com.jj.coupon.vo;

import java.sql.Date;

public class Coupon {
	private int cpNo;
	private String cpName;
	private int discount;
	private Date cpAddDate;
	private String cpStatus;
	
	public Coupon() {}

	public Coupon(int cpNo, String cpName, int discount, Date cpAddDate, String cpStatus) {
		super();
		this.cpNo = cpNo;
		this.cpName = cpName;
		this.discount = discount;
		this.cpAddDate = cpAddDate;
		this.cpStatus = cpStatus;
	}

	public int getCpNo() {
		return cpNo;
	}

	public void setCpNo(int cpNo) {
		this.cpNo = cpNo;
	}

	public String getCpName() {
		return cpName;
	}

	public void setCpName(String cpName) {
		this.cpName = cpName;
	}

	public int getDiscount() {
		return discount;
	}

	public void setDiscount(int discount) {
		this.discount = discount;
	}

	public Date getCpAddDate() {
		return cpAddDate;
	}

	public void setCpAddDate(Date cpAddDate) {
		this.cpAddDate = cpAddDate;
	}

	public String getCpStatus() {
		return cpStatus;
	}

	public void setCpStatus(String cpStatus) {
		this.cpStatus = cpStatus;
	}

	@Override
	public String toString() {
		return "Coupon [cpNo=" + cpNo + ", cpName=" + cpName + ", discount=" + discount + ", cpAddDate=" + cpAddDate
				+ ", cpStatus=" + cpStatus + "]";
	}
	
	
}
