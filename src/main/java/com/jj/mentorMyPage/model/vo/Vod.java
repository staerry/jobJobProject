package com.jj.mentorMyPage.model.vo;

import java.util.Date;

import com.jj.userMyPage.model.vo.Class;

public class Vod {

	private int vodNo;
	private Class cls;
	private String vodTitle;
	private String vodFile;
	private Date vodEnrollDate;
	private String vodStatus;
	public int getVodNo() {
		return vodNo;
	}
	public void setVodNo(int vodNo) {
		this.vodNo = vodNo;
	}
	public Class getCls() {
		return cls;
	}
	public void setCls(Class cls) {
		this.cls = cls;
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
	public Date getVodEnrollDate() {
		return vodEnrollDate;
	}
	public void setVodEnrollDate(Date vodEnrollDate) {
		this.vodEnrollDate = vodEnrollDate;
	}
	public String getVodStatus() {
		return vodStatus;
	}
	public void setVodStatus(String vodStatus) {
		this.vodStatus = vodStatus;
	}
	public Vod() {
		super();
	}
	public Vod(int vodNo, Class cls, String vodTitle, String vodFile, Date vodEnrollDate, String vodStatus) {
		super();
		this.vodNo = vodNo;
		this.cls = cls;
		this.vodTitle = vodTitle;
		this.vodFile = vodFile;
		this.vodEnrollDate = vodEnrollDate;
		this.vodStatus = vodStatus;
	}
	@Override
	public String toString() {
		return "Vod [vodNo=" + vodNo + ", cls=" + cls + ", vodTitle=" + vodTitle + ", vodFile=" + vodFile
				+ ", vodEnrollDate=" + vodEnrollDate + ", vodStatus=" + vodStatus + "]";
	}
	
	
	
}
