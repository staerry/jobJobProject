package com.jj.userMyPage.model.vo;

import java.util.Date;

public class Review {
	private int reviewNo;
	private int clNo;
	private int userNo;
	private int reviewScore;
	private String reviewContent;
	private Date reviewEnrolldate;
	public int getReviewNo() {
		return reviewNo;
	}
	public void setReviewNo(int reviewNo) {
		this.reviewNo = reviewNo;
	}
	public int getClNo() {
		return clNo;
	}
	public void setClNo(int clNo) {
		this.clNo = clNo;
	}
	public int getUserNo() {
		return userNo;
	}
	public void setUserNo(int userNo) {
		this.userNo = userNo;
	}
	public int getReviewScore() {
		return reviewScore;
	}
	public void setReviewScore(int reviewScore) {
		this.reviewScore = reviewScore;
	}
	public String getReviewContent() {
		return reviewContent;
	}
	public void setReviewContent(String reviewContent) {
		this.reviewContent = reviewContent;
	}
	public Date getReviewEnrolldate() {
		return reviewEnrolldate;
	}
	public void setReviewEnrolldate(Date reviewEnrolldate) {
		this.reviewEnrolldate = reviewEnrolldate;
	}
	public Review() {
		super();
	}
	public Review(int reviewNo, int clNo, int userNo, int reviewScore, String reviewContent, Date reviewEnrolldate) {
		super();
		this.reviewNo = reviewNo;
		this.clNo = clNo;
		this.userNo = userNo;
		this.reviewScore = reviewScore;
		this.reviewContent = reviewContent;
		this.reviewEnrolldate = reviewEnrolldate;
	}
	@Override
	public String toString() {
		return "Review [reviewNo=" + reviewNo + ", clNo=" + clNo + ", userNo=" + userNo + ", reviewScore=" + reviewScore
				+ ", reviewContent=" + reviewContent + ", reviewEnrolldate=" + reviewEnrolldate + "]";
	}
	
	
	
}
