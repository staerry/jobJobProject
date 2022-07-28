package com.jj.faq.model.vo;

import java.util.Date;

public class Faq {
	private int faqNo;
	private String userNo;
	private String faqTitle;
	private String faqAnswer;
	private Date faqEnrolldate;
	private int faqCount;
	
	public Faq() {
		
	}

	public Faq(int faqNo, String userNo, String faqTitle, String faqAnswer, Date faqEnrolldate, int faqCount) {
		super();
		this.faqNo = faqNo;
		this.userNo = userNo;
		this.faqTitle = faqTitle;
		this.faqAnswer = faqAnswer;
		this.faqEnrolldate = faqEnrolldate;
		this.faqCount = faqCount;
	}

	public int getFaqNo() {
		return faqNo;
	}

	public void setFaqNo(int faqNo) {
		this.faqNo = faqNo;
	}

	public String getUserNo() {
		return userNo;
	}

	public void setUserNo(String userNo) {
		this.userNo = userNo;
	}

	public String getFaqTitle() {
		return faqTitle;
	}

	public void setFaqTitle(String faqTitle) {
		this.faqTitle = faqTitle;
	}

	public String getFaqAnswer() {
		return faqAnswer;
	}

	public void setFaqAnswer(String faqAnswer) {
		this.faqAnswer = faqAnswer;
	}

	public Date getFaqEnrolldate() {
		return faqEnrolldate;
	}

	public void setFaqEnrolldate(Date faqEnrolldate) {
		this.faqEnrolldate = faqEnrolldate;
	}

	public int getFaqCount() {
		return faqCount;
	}

	public void setFaqCount(int faqCount) {
		this.faqCount = faqCount;
	}

	@Override
	public String toString() {
		return "Faq [faqNo=" + faqNo + ", userNo=" + userNo + ", faqTitle=" + faqTitle + ", faqAnswer=" + faqAnswer
				+ ", faqEnrolldate=" + faqEnrolldate + ", faqCount=" + faqCount + "]";
	}
}