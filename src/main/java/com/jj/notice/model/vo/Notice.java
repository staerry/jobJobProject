package com.jj.notice.model.vo;

import java.util.Date;

public class Notice {
	private int noticeNo;
	private int userNo;
	private String noticeTitle;
	private String noticeContent;
	private Date noticeEnrolldate;
	private Date noticeModifyDate;
	private int noticeCount;
	
	public Notice() {
		
	}

	public Notice(int noticeNo, int userNo, String noticeTitle, String noticeContent, Date noticeEnrolldate,
			Date noticeModifyDate, int noticeCount) {
		super();
		this.noticeNo = noticeNo;
		this.userNo = userNo;
		this.noticeTitle = noticeTitle;
		this.noticeContent = noticeContent;
		this.noticeEnrolldate = noticeEnrolldate;
		this.noticeModifyDate = noticeModifyDate;
		this.noticeCount = noticeCount;
	}

	public int getNoticeNo() {
		return noticeNo;
	}

	public void setNoticeNo(int noticeNo) {
		this.noticeNo = noticeNo;
	}

	public int getUserNo() {
		return userNo;
	}

	public void setUserNo(int userNo) {
		this.userNo = userNo;
	}

	public String getNoticeTitle() {
		return noticeTitle;
	}

	public void setNoticeTitle(String noticeTitle) {
		this.noticeTitle = noticeTitle;
	}

	public String getNoticeContent() {
		return noticeContent;
	}

	public void setNoticeContent(String noticeContent) {
		this.noticeContent = noticeContent;
	}

	public Date getNoticeEnrolldate() {
		return noticeEnrolldate;
	}

	public void setNoticeEnrolldate(Date noticeEnrolldate) {
		this.noticeEnrolldate = noticeEnrolldate;
	}

	public Date getNoticeModifyDate() {
		return noticeModifyDate;
	}

	public void setNoticeModifyDate(Date noticeModifyDate) {
		this.noticeModifyDate = noticeModifyDate;
	}

	public int getNoticeCount() {
		return noticeCount;
	}

	public void setNoticeCount(int noticeCount) {
		this.noticeCount = noticeCount;
	}

	@Override
	public String toString() {
		return "Notice [noticeNo=" + noticeNo + ", userNo=" + userNo + ", noticeTitle=" + noticeTitle
				+ ", noticeContent=" + noticeContent + ", noticeEnrolldate=" + noticeEnrolldate + ", noticeModifyDate="
				+ noticeModifyDate + ", noticeCount=" + noticeCount + "]";
	}
}