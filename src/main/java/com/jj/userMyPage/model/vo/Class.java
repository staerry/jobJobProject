package com.jj.userMyPage.model.vo;

import java.util.Date;

import com.jj.member.model.vo.Member;

public class Class {
	private int clNo;
	private Member member;
//	private String userNo;
	private String mtCompany;
	private String clCategory;
	private String clTitle;
	private String clSubtitle;
	private String clInfo;
	private String clCurri;
	private int clPrice;
	private String clPriceWon;	// TO_CHAR 변환 위함
	private Date clEnrolldate;
	private String clGrant;
	private String clThumbnailPath;
	private String ltrInfo;
	private String ltrCareer;
	private String ltrProfilePath;
	private double clScore;
	public int getClNo() {
		return clNo;
	}
	public void setClNo(int clNo) {
		this.clNo = clNo;
	}
	public Member getMember() {
		return member;
	}
	public void setMember(Member member) {
		this.member = member;
	}
	public String getMtCompany() {
		return mtCompany;
	}
	public void setMtCompany(String mtCompany) {
		this.mtCompany = mtCompany;
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
	public String getClPriceWon() {
		return clPriceWon;
	}
	public void setClPriceWon(String clPriceWon) {
		this.clPriceWon = clPriceWon;
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
	public String getLtrInfo() {
		return ltrInfo;
	}
	public void setLtrInfo(String ltrInfo) {
		this.ltrInfo = ltrInfo;
	}
	public String getLtrCareer() {
		return ltrCareer;
	}
	public void setLtrCareer(String ltrCareer) {
		this.ltrCareer = ltrCareer;
	}
	public String getLtrProfilePath() {
		return ltrProfilePath;
	}
	public void setLtrProfilePath(String ltrProfilePath) {
		this.ltrProfilePath = ltrProfilePath;
	}
	public double getClScore() {
		return clScore;
	}
	public void setClScore(double clScore) {
		this.clScore = clScore;
	}
	public Class() {
		super();
	}
	public Class(int clNo, Member member, String mtCompany, String clCategory, String clTitle, String clSubtitle,
			String clInfo, String clCurri, int clPrice, String clPriceWon, Date clEnrolldate, String clGrant,
			String clThumbnailPath, String ltrInfo, String ltrCareer, String ltrProfilePath, double clScore) {
		super();
		this.clNo = clNo;
		this.member = member;
		this.mtCompany = mtCompany;
		this.clCategory = clCategory;
		this.clTitle = clTitle;
		this.clSubtitle = clSubtitle;
		this.clInfo = clInfo;
		this.clCurri = clCurri;
		this.clPrice = clPrice;
		this.clPriceWon = clPriceWon;
		this.clEnrolldate = clEnrolldate;
		this.clGrant = clGrant;
		this.clThumbnailPath = clThumbnailPath;
		this.ltrInfo = ltrInfo;
		this.ltrCareer = ltrCareer;
		this.ltrProfilePath = ltrProfilePath;
		this.clScore = clScore;
	}
	@Override
	public String toString() {
		return "Class [clNo=" + clNo + ", member=" + member + ", mtCompany=" + mtCompany + ", clCategory=" + clCategory
				+ ", clTitle=" + clTitle + ", clSubtitle=" + clSubtitle + ", clInfo=" + clInfo + ", clCurri=" + clCurri
				+ ", clPrice=" + clPrice + ", clPriceWon=" + clPriceWon + ", clEnrolldate=" + clEnrolldate
				+ ", clGrant=" + clGrant + ", clThumbnailPath=" + clThumbnailPath + ", ltrInfo=" + ltrInfo
				+ ", ltrCareer=" + ltrCareer + ", ltrProfilePath=" + ltrProfilePath + ", clScore=" + clScore + "]";
	}
	
	
}