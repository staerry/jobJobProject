package com.jj.bookmark.model.vo;

import java.sql.Date;

public class Bookmark {
	
	private String userNo;
	private int clNo;
	private Date clLikedate;
	
	public Bookmark() {}

	public Bookmark(String userNo, int clNo, Date clLikedate) {
		super();
		this.userNo = userNo;
		this.clNo = clNo;
		this.clLikedate = clLikedate;
	}

	public String getUserNo() {
		return userNo;
	}

	public void setUserNo(String userNo) {
		this.userNo = userNo;
	}

	public int getClNo() {
		return clNo;
	}

	public void setClNo(int clNo) {
		this.clNo = clNo;
	}

	public Date getClLikedate() {
		return clLikedate;
	}

	public void setClLikedate(Date clLikedate) {
		this.clLikedate = clLikedate;
	}

	@Override
	public String toString() {
		return "Bookmark [userNo=" + userNo + ", clNo=" + clNo + ", clLikedate=" + clLikedate + "]";
	}
	
	

}
