package com.jj.userMyPage.model.vo;

import java.sql.Date;

public class UCoupon {
	private String cpName;
	private int discount;
	private Date endDate;
	private int count;
	
	public UCoupon() {
		
	}
	
	public UCoupon(String cpName, int discount, Date endDate, int count) {
		super();
		this.cpName = cpName;
		this.discount = discount;
		this.endDate = endDate;
		this.count = count;
	}
	
	public UCoupon(String cpName, int discount, Date endDate) {
		super();
		this.cpName = cpName;
		this.discount = discount;
		this.endDate = endDate;
		
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

	public Date getEndDate() {
		return endDate;
	}

	public void setEndDate(Date endDate) {
		this.endDate = endDate;
	}

	public int getCount() {
		return count;
	}

	public void setCount(int count) {
		this.count = count;
	}

	@Override
	public String toString() {
		return "UCoupon [cpName=" + cpName + ", discount=" + discount + ", endDate=" + endDate + ", count=" + count
				+ "]";
	}

	
	
	
	
	
	
	
}
