package com.jj.mentorSelect.model.vo;

import java.sql.Date;

public class MtQuestion {
	
	private int mtQueNo;	// 멘토에게 질문글 고유번호
	private String queWriterNo;	// 질문 작성자(일반회원) 고유번호
	private String queTitle;
	private String queContent;	// 질문 작성일
	private Date queEnrolldate;
	private int queLike;	// 질문글에 달린 좋아요 수
	private String ansWriterNo;	// 답변 작성자(멘토==강의자) 고유번호
	private String ansContent;
	private Date ansEnrollDate;	// 답변 작성일

	public MtQuestion() {}

	public MtQuestion(int mtQueNo, String queWriterNo, String queTitle, String queContent, Date queEnrolldate,
			int queLike, String ansWriterNo, String ansContent, Date ansEnrollDate) {
		super();
		this.mtQueNo = mtQueNo;
		this.queWriterNo = queWriterNo;
		this.queTitle = queTitle;
		this.queContent = queContent;
		this.queEnrolldate = queEnrolldate;
		this.queLike = queLike;
		this.ansWriterNo = ansWriterNo;
		this.ansContent = ansContent;
		this.ansEnrollDate = ansEnrollDate;
	}

	public int getMtQueNo() {
		return mtQueNo;
	}

	public void setMtQueNo(int mtQueNo) {
		this.mtQueNo = mtQueNo;
	}

	public String getQueWriterNo() {
		return queWriterNo;
	}

	public void setQueWriterNo(String queWriterNo) {
		this.queWriterNo = queWriterNo;
	}

	public String getQueTitle() {
		return queTitle;
	}

	public void setQueTitle(String queTitle) {
		this.queTitle = queTitle;
	}

	public String getQueContent() {
		return queContent;
	}

	public void setQueContent(String queContent) {
		this.queContent = queContent;
	}

	public Date getQueEnrolldate() {
		return queEnrolldate;
	}

	public void setQueEnrolldate(Date queEnrolldate) {
		this.queEnrolldate = queEnrolldate;
	}

	public int getQueLike() {
		return queLike;
	}

	public void setQueLike(int queLike) {
		this.queLike = queLike;
	}

	public String getAnsWriterNo() {
		return ansWriterNo;
	}

	public void setAnsWriterNo(String ansWriterNo) {
		this.ansWriterNo = ansWriterNo;
	}

	public String getAnsContent() {
		return ansContent;
	}

	public void setAnsContent(String ansContent) {
		this.ansContent = ansContent;
	}

	public Date getAnsEnrollDate() {
		return ansEnrollDate;
	}

	public void setAnsEnrollDate(Date ansEnrollDate) {
		this.ansEnrollDate = ansEnrollDate;
	}

	@Override
	public String toString() {
		return "MtQuestion [mtQueNo=" + mtQueNo + ", queWriterNo=" + queWriterNo + ", queTitle=" + queTitle
				+ ", queContent=" + queContent + ", queEnrolldate=" + queEnrolldate + ", queLike=" + queLike
				+ ", ansWriterNo=" + ansWriterNo + ", ansContent=" + ansContent + ", ansEnrollDate=" + ansEnrollDate
				+ "]";
	}
	
}
