package com.jj.community.model.vo;

import java.util.Date;

public class Review {
	private int reviewNo;
	private String clNo;
	private String userNo;
	private int reviewScore;
	private String reviewContent;
	private Date reviewEnrolldate;
	private String reviewCreatedate;	// TO_CHAR 함수용 추가 (박태은 작성)
	
	public Review() {
		
	}

		
	public Review(int reviewNo, String clNo, String userNo, int reviewScore, String reviewContent,
			String reviewCreatedate) {
		super();
		this.reviewNo = reviewNo;
		this.clNo = clNo;
		this.userNo = userNo;
		this.reviewScore = reviewScore;
		this.reviewContent = reviewContent;
		this.reviewCreatedate = reviewCreatedate;
	}

	public Review(int reviewNo, String clNo, String userNo, int reviewScore, String reviewContent,
			Date reviewEnrolldate) {
		super();
		this.reviewNo = reviewNo;
		this.clNo = clNo;
		this.userNo = userNo;
		this.reviewScore = reviewScore;
		this.reviewContent = reviewContent;
		this.reviewEnrolldate = reviewEnrolldate;
	}

	
	
	public String getReviewCreatedate() {
		return reviewCreatedate;
	}


	public void setReviewCreatedate(String reviewCreateDate) {
		this.reviewCreatedate = reviewCreateDate;
	}


	public int getReviewNo() {
		return reviewNo;
	}

	public void setReviewNo(int reviewNo) {
		this.reviewNo = reviewNo;
	}

	public String getClNo() {
		return clNo;
	}

	public void setClNo(String clNo) {
		this.clNo = clNo;
	}

	public String getUserNo() {
		return userNo;
	}

	public void setUserNo(String userNo) {
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

	@Override
	public String toString() {
		return "Review [reviewNo=" + reviewNo + ", clNo=" + clNo + ", userNo=" + userNo + ", reviewScore=" + reviewScore
				+ ", reviewContent=" + reviewContent + ", reviewEnrolldate=" + reviewEnrolldate + "]";
	}
}