package com.jj.classSelect.model.vo;

import java.util.Date;

public class Class {
	private int clNo;
	private String userNo;
	private String clCategory;
	private String clTitle;
	private String clSubtitle;
	private String clInfo;
	private String clCurri;
	private int clPrice;
	private Date clEnrolldate;
	private String clGrant;
	private String clThumbnailPath;
	
	public Class() {
		
	}

	public Class(int clNo, String userNo, String clCategory, String clTitle, String clSubtitle, String clInfo,
			String clCurri, int clPrice, Date clEnrolldate, String clGrant, String clThumbnailPath) {
		super();
		this.clNo = clNo;
		this.userNo = userNo;
		this.clCategory = clCategory;
		this.clTitle = clTitle;
		this.clSubtitle = clSubtitle;
		this.clInfo = clInfo;
		this.clCurri = clCurri;
		this.clPrice = clPrice;
		this.clEnrolldate = clEnrolldate;
		this.clGrant = clGrant;
		this.clThumbnailPath = clThumbnailPath;
	}

	public int getClNo() {
		return clNo;
	}

	public void setClNo(int clNo) {
		this.clNo = clNo;
	}

	public String getUserNo() {
		return userNo;
	}

	public void setUserNo(String userNo) {
		this.userNo = userNo;
	}

	public String getClCategory() {
		return clCategory;
	}

	public void setClCategory(String clCategory) {
		this.clCategory = clCategory;
	}

	public String getClTitle() {
		return clTitle;
	}

	public void setClTitle(String clTitle) {
		this.clTitle = clTitle;
	}

	public String getClSubtitle() {
		return clSubtitle;
	}

	public void setClSubtitle(String clSubtitle) {
		this.clSubtitle = clSubtitle;
	}

	public String getClInfo() {
		return clInfo;
	}

	public void setClInfo(String clInfo) {
		this.clInfo = clInfo;
	}

	public String getClCurri() {
		return clCurri;
	}

	public void setClCurri(String clCurri) {
		this.clCurri = clCurri;
	}

	public int getClPrice() {
		return clPrice;
	}

	public void setClPrice(int clPrice) {
		this.clPrice = clPrice;
	}

	public Date getClEnrolldate() {
		return clEnrolldate;
	}

	public void setClEnrolldate(Date clEnrolldate) {
		this.clEnrolldate = clEnrolldate;
	}

	public String getClGrant() {
		return clGrant;
	}

	public void setClGrant(String clGrant) {
		this.clGrant = clGrant;
	}

	public String getClThumbnailPath() {
		return clThumbnailPath;
	}

	public void setClThumbnailPath(String clThumbnailPath) {
		this.clThumbnailPath = clThumbnailPath;
	}

	@Override
	public String toString() {
		return "Class [clNo=" + clNo + ", userNo=" + userNo + ", clCategory=" + clCategory + ", clTitle=" + clTitle
				+ ", clSubtitle=" + clSubtitle + ", clInfo=" + clInfo + ", clCurri=" + clCurri + ", clPrice=" + clPrice
				+ ", clEnrolldate=" + clEnrolldate + ", clGrant=" + clGrant + ", clThumbnailPath=" + clThumbnailPath
				+ "]";
	}
}