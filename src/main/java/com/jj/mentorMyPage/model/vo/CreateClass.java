package com.jj.mentorMyPage.model.vo;

import java.sql.Date;

public class CreateClass {
	

			
//	 입력받은순서
//	강의분야
//	클래스제목
//	클래스소제목
//	커버이미지
//	강의소개
//	커리큘럼
//	수강료
	
//	컬럼순서
//	CL_NO
//	USER_NO
//	CL_CATEGORY
//	CL_TITLE
//	CL_SUBTITLE
//	CL_INFO
//	CL_CURRI
//	CL_PRICE
//	CL_ENROLLDATE
//	CL_GRANT
//	CL_THUMBNAILPATH
	private int clNo;
	private String userNo;
	private int clCategory;
	private String clTitle;
	private String clSubTitle;
	private String clInfo;
	private String clCurri;
	private int clPrice;
	private Date clEnrollDate;
	private String clGrant;
	private String clImg;  // 썸네일 이미지경로
	
	

public CreateClass() {}






public CreateClass(int clNo, String userNo, int clCategory, String clTitle, String clSubTitle, String clInfo,
		String clCurri, int clPrice, Date clEnrollDate, String clGrant, String clImg) {
	super();
	this.clNo = clNo;
	this.userNo = userNo;
	this.clCategory = clCategory;
	this.clTitle = clTitle;
	this.clSubTitle = clSubTitle;
	this.clInfo = clInfo;
	this.clCurri = clCurri;
	this.clPrice = clPrice;
	this.clEnrollDate = clEnrollDate;
	this.clGrant = clGrant;
	this.clImg = clImg;
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



public int getClCategory() {
	return clCategory;
}



public void setClCategory(int clCategory) {
	this.clCategory = clCategory;
}



public String getClTitle() {
	return clTitle;
}



public void setClTitle(String clTitle) {
	this.clTitle = clTitle;
}



public String getClSubTitle() {
	return clSubTitle;
}



public void setClSubTitle(String clSubTitle) {
	this.clSubTitle = clSubTitle;
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



public Date getClEnrollDate() {
	return clEnrollDate;
}



public void setClEnrollDate(Date clEnrollDate) {
	this.clEnrollDate = clEnrollDate;
}



public String getClGrant() {
	return clGrant;
}



public void setClGrant(String clGrant) {
	this.clGrant = clGrant;
}



public String getClImg() {
	return clImg;
}



public void setClImg(String clImg) {
	this.clImg = clImg;
}






@Override
public String toString() {
	return "CreateClass [clNo=" + clNo + ", userNo=" + userNo + ", clCategory=" + clCategory + ", clTitle=" + clTitle
			+ ", clSubTitle=" + clSubTitle + ", clInfo=" + clInfo + ", clCurri=" + clCurri + ", clPrice=" + clPrice
			+ ", clEnrollDate=" + clEnrollDate + ", clGrant=" + clGrant + ", clImg=" + clImg + "]";
}









}