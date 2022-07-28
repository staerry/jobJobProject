package com.jj.community.model.vo;

import java.util.Date;

public class Reply {
	private int replyNo;
	private String cmNo;
	private String userNo;
	private String replyContent;
	private Date replyEnrolldate;
	
	public Reply() {
		
	}

	public Reply(int replyNo, String cmNo, String userNo, String replyContent, Date replyEnrolldate) {
		super();
		this.replyNo = replyNo;
		this.cmNo = cmNo;
		this.userNo = userNo;
		this.replyContent = replyContent;
		this.replyEnrolldate = replyEnrolldate;
	}

	public int getReplyNo() {
		return replyNo;
	}

	public void setReplyNo(int replyNo) {
		this.replyNo = replyNo;
	}

	public String getCmNo() {
		return cmNo;
	}

	public void setCmNo(String cmNo) {
		this.cmNo = cmNo;
	}

	public String getUserNo() {
		return userNo;
	}

	public void setUserNo(String userNo) {
		this.userNo = userNo;
	}

	public String getReplyContent() {
		return replyContent;
	}

	public void setReplyContent(String replyContent) {
		this.replyContent = replyContent;
	}

	public Date getReplyEnrolldate() {
		return replyEnrolldate;
	}

	public void setReplyEnrolldate(Date replyEnrolldate) {
		this.replyEnrolldate = replyEnrolldate;
	}

	@Override
	public String toString() {
		return "Reply [replyNo=" + replyNo + ", cmNo=" + cmNo + ", userNo=" + userNo + ", replyContent=" + replyContent
				+ ", replyEnrolldate=" + replyEnrolldate + "]";
	}
}