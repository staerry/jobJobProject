package com.jj.notice.model.vo;

import java.util.Date;

public class Notice {
	private int noticeNo;
	private String userNo;
	private String noticeTitle;
	private String noticeContent;
	private Date noticeEnrolldate;
	private Date noticeModifydate;
	private int noticeCount;
	
	public Notice() {}

	public Notice(int noticeNo, String userNo, String noticeTitle, String noticeContent, int noticeCount) {
		super();
		this.noticeNo = noticeNo;
		this.userNo = userNo;
		this.noticeTitle = noticeTitle;
		this.noticeContent = noticeContent;
		this.noticeCount = noticeCount;
	}

	public Notice(int noticeNo, String noticeTitle, String noticeContent, String userNo, Date noticeEnrolldate, Date noticeModifydate) {
		super();
		this.noticeNo = noticeNo;
		this.noticeTitle = noticeTitle;
		this.noticeContent = noticeContent;
		this.userNo = userNo;
		this.noticeEnrolldate = noticeEnrolldate;
		this.noticeModifydate = noticeModifydate;
	}

	public Notice(int noticeNo, String noticeTitle, int noticeCount) {
		super();
		this.noticeNo = noticeNo;
		this.noticeTitle = noticeTitle;
		this.noticeCount = noticeCount;
	}

	public Notice(int noticeNo, String userNo, String noticeTitle, String noticeContent, Date noticeEnrolldate,
			Date noticeModifydate, int noticeCount) {
		super();
		this.noticeNo = noticeNo;
		this.userNo = userNo;
		this.noticeTitle = noticeTitle;
		this.noticeContent = noticeContent;
		this.noticeEnrolldate = noticeEnrolldate;
		this.noticeModifydate = noticeModifydate;
		this.noticeCount = noticeCount;
	}

	public int getNoticeNo() {
		return noticeNo;
	}

	public void setNoticeNo(int noticeNo) {
		this.noticeNo = noticeNo;
	}

	public String getUserNo() {
		return userNo;
	}

	public void setUserNo(String userNo) {
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

	public Date getNoticeModifydate() {
		return noticeModifydate;
	}

	public void setNoticeModifydate(Date noticeModifydate) {
		this.noticeModifydate = noticeModifydate;
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
				+ ", noticeContent=" + noticeContent + ", noticeEnrolldate=" + noticeEnrolldate + ", noticeModifydate="
				+ noticeModifydate + ", noticeCount=" + noticeCount + "]";
	}

}
