package com.jj.mtm.model.vo;

import java.util.Date;

public class Mtm {
	private int mtmNo;
	private String userNo;
	private String mtmTitle;
	private String mtmContent;
	private Date mtmEnrolldate;
	private String mtmAnswer;
	private Date mtmAnswerDate;
	private String adminNo;
	
	public Mtm() {
		
	}

	public Mtm(int mtmNo, String userNo, String mtmTitle, String mtmContent, Date mtmEnrolldate, String mtmAnswer,
			Date mtmAnswerDate, String adminNo) {
		super();
		this.mtmNo = mtmNo;
		this.userNo = userNo;
		this.mtmTitle = mtmTitle;
		this.mtmContent = mtmContent;
		this.mtmEnrolldate = mtmEnrolldate;
		this.mtmAnswer = mtmAnswer;
		this.mtmAnswerDate = mtmAnswerDate;
		this.adminNo = adminNo;
	}

	public int getMtmNo() {
		return mtmNo;
	}

	public void setMtmNo(int mtmNo) {
		this.mtmNo = mtmNo;
	}

	public String getUserNo() {
		return userNo;
	}

	public void setUserNo(String userNo) {
		this.userNo = userNo;
	}

	public String getMtmTitle() {
		return mtmTitle;
	}

	public void setMtmTitle(String mtmTitle) {
		this.mtmTitle = mtmTitle;
	}

	public String getMtmContent() {
		return mtmContent;
	}

	public void setMtmContent(String mtmContent) {
		this.mtmContent = mtmContent;
	}

	public Date getMtmEnrolldate() {
		return mtmEnrolldate;
	}

	public void setMtmEnrolldate(Date mtmEnrolldate) {
		this.mtmEnrolldate = mtmEnrolldate;
	}

	public String getMtmAnswer() {
		return mtmAnswer;
	}

	public void setMtmAnswer(String mtmAnswer) {
		this.mtmAnswer = mtmAnswer;
	}

	public Date getMtmAnswerDate() {
		return mtmAnswerDate;
	}

	public void setMtmAnswerDate(Date mtmAnswerDate) {
		this.mtmAnswerDate = mtmAnswerDate;
	}

	public String getAdminNo() {
		return adminNo;
	}

	public void setAdminNo(String adminNo) {
		this.adminNo = adminNo;
	}

	@Override
	public String toString() {
		return "Mtm [mtmNo=" + mtmNo + ", userNo=" + userNo + ", mtmTitle=" + mtmTitle + ", mtmContent=" + mtmContent
				+ ", mtmEnrolldate=" + mtmEnrolldate + ", mtmAnswer=" + mtmAnswer + ", mtmAnswerDate=" + mtmAnswerDate
				+ ", adminNo=" + adminNo + "]";
	}
}