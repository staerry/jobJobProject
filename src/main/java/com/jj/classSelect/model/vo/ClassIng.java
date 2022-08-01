package com.jj.classSelect.model.vo;

import java.sql.Date;

public class ClassIng {
	private int userNo;
	private int clNo;
	private Date clStartDate;
	
	public ClassIng() {}

	public ClassIng(int userNo, int clNo, Date clStartDate) {
		super();
		this.userNo = userNo;
		this.clNo = clNo;
		this.clStartDate = clStartDate;
	}
	
	

	public ClassIng(int userNo) {
		super();
		this.userNo = userNo;
	}

	public int getUserNo() {
		return userNo;
	}

	public void setUserNo(int userNo) {
		this.userNo = userNo;
	}

	public int getClNo() {
		return clNo;
	}

	public void setClNo(int clNo) {
		this.clNo = clNo;
	}

	public Date getClStartDate() {
		return clStartDate;
	}

	public void setClStartDate(Date clStartDate) {
		this.clStartDate = clStartDate;
	}

	@Override
	public String toString() {
		return "ClassIng [userNo=" + userNo + ", clNo=" + clNo + ", clStartDate=" + clStartDate + "]";
	}
	
	
}
