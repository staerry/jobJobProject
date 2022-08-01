package com.jj.classSelect.model.vo;

import java.util.Date;

public class Vod {
	private int vodNo;
	private String clNo;
	private String vodTitle;
	private String vodFile;
	private Date vodEnrolldate;
	private String vodStatus;
	private String mentorName; // vod승인 페이지에서 강사명 조회시 필요
	
	public Vod() {
		
	}

	public Vod(int vodNo, String clNo, String vodTitle, String vodFile, Date vodEnrolldate, String vodStatus,
			String mentorName) {
		super();
		this.vodNo = vodNo;
		this.clNo = clNo;
		this.vodTitle = vodTitle;
		this.vodFile = vodFile;
		this.vodEnrolldate = vodEnrolldate;
		this.vodStatus = vodStatus;
		this.mentorName = mentorName;
	}
	
	
	public Vod(int vodNo, String clNo, String vodTitle, String mentorName) {
		super();
		this.vodNo = vodNo;
		this.clNo = clNo;
		this.vodTitle = vodTitle;
		this.mentorName = mentorName;
	}
	
	public Vod(int vodNo, String vodTitle, String vodFile) {
		super();
		this.vodNo = vodNo;
		this.vodTitle = vodTitle;
		this.vodFile = vodFile;
	}

	public int getVodNo() {
		return vodNo;
	}

	public void setVodNo(int vodNo) {
		this.vodNo = vodNo;
	}

	public String getClNo() {
		return clNo;
	}

	public void setClNo(String clNo) {
		this.clNo = clNo;
	}

	public String getVodTitle() {
		return vodTitle;
	}

	public void setVodTitle(String vodTitle) {
		this.vodTitle = vodTitle;
	}

	public String getVodFile() {
		return vodFile;
	}

	public void setVodFile(String vodFile) {
		this.vodFile = vodFile;
	}

	public Date getVodEnrolldate() {
		return vodEnrolldate;
	}

	public void setVodEnrolldate(Date vodEnrolldate) {
		this.vodEnrolldate = vodEnrolldate;
	}

	public String getVodStatus() {
		return vodStatus;
	}

	public void setVodStatus(String vodStatus) {
		this.vodStatus = vodStatus;
	}

	public String getMentorName() {
		return mentorName;
	}

	public void setMentorName(String mentorName) {
		this.mentorName = mentorName;
	}

	@Override
	public String toString() {
		return "Vod [vodNo=" + vodNo + ", clNo=" + clNo + ", vodTitle=" + vodTitle + ", vodFile=" + vodFile
				+ ", vodEnrolldate=" + vodEnrolldate + ", vodStatus=" + vodStatus + ", mentorName=" + mentorName + "]";
	}
}