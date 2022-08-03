package com.jj.userMyPage.model.vo;

import java.sql.Date;

public class Reply {
	private int replyNo;
	private int cmNo;
	private int userNo;
	private String replyContent;
	private Date replyEnrollDate;
	
	public Reply() {
		
	}

	public Reply(int replyNo, int cmNo, int userNo, String replyContent, Date replyEnrollDate) {
		super();
		this.replyNo = replyNo;
		this.cmNo = cmNo;
		this.userNo = userNo;
		this.replyContent = replyContent;
		this.replyEnrollDate = replyEnrollDate;
	}

	
	public Reply(int replyNo, int cmNo, String replyContent, Date replyEnrollDate) {
		super();
		this.replyNo = replyNo;
		this.cmNo = cmNo;
		this.replyContent = replyContent;
		this.replyEnrollDate = replyEnrollDate;
	}

	public int getReplyNo() {
		return replyNo;
	}

	public void setReplyNo(int replyNo) {
		this.replyNo = replyNo;
	}

	public int getCmNo() {
		return cmNo;
	}

	public void setCmNo(int cmNo) {
		this.cmNo = cmNo;
	}

	public int getUserNo() {
		return userNo;
	}

	public void setUserNo(int userNo) {
		this.userNo = userNo;
	}

	public String getReplyContent() {
		return replyContent;
	}

	public void setReplyContent(String replyContent) {
		this.replyContent = replyContent;
	}

	public Date getReplyEnrollDate() {
		return replyEnrollDate;
	}

	public void setReplyEnrollDate(Date replyEnrollDate) {
		this.replyEnrollDate = replyEnrollDate;
	}

	@Override
	public String toString() {
		return "Reply [replyNo=" + replyNo + ", cmNo=" + cmNo + ", userNo=" + userNo + ", replyContent=" + replyContent
				+ ", replyEnrollDate=" + replyEnrollDate + "]";
	}

}
