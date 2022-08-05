package com.jj.mentorMyPage.model.vo;

import java.sql.Date;

import com.jj.member.model.vo.Member;
import com.jj.member.model.vo.Mentor;

public class MtQuestion {
	
	private int mtQueNo;	// 멘토에게 질문글 고유번호
	private Member member;
//	private int queWriterNo;	// 질문 작성자(일반회원) 고유번호
//	private String queWriterName;
	private String queTitle;
	private String queContent;	// 질문 작성일
	private Date queEnrolldate;
	private String queDate;	// TO_CHAR 사용 
	private int queLike;	// 질문글에 달린 좋아요 수
	private Mentor mentor;
//	private int ansWriterNo;	// 답변 작성자(멘토==강의자) 고유번호
//	private String ansWriterName;
	private String ansContent;
	private Date ansEnrollDate;	// 답변 작성일
	private Date ansDate;	// TO_CHAR 사용

//	MT_QUE_NO,
//
//	QUE_TITLE,
//	QUE_CONTENT,
//	QUE_ENROLLDATE,
//
//	ANS_NO,
//	ANS_CONTENT,
//	ANS_DATE
	
	public MtQuestion() {
		
	}
	
	
	
	
	public MtQuestion(int mtQueNo, String queTitle, String queContent, Date queEnrolldate, String ansContent,
			Date ansDate) {
		super();
		this.mtQueNo = mtQueNo;
		this.queTitle = queTitle;
		this.queContent = queContent;
		this.queEnrolldate = queEnrolldate;
		this.ansContent = ansContent;
		this.ansDate = ansDate;
	}

	/**
	 * 관리자 페이지 멘토 질문/답변 관리 페이지 생성자
	 */
//	public MtQuestion(int mtQueNo, String queWriterName, String queTitle, String queContent, Date queEnrolldate,
//			int queLike, String ansWriterName, String ansContent, Date ansEnrollDate) {
//		super();
//		this.mtQueNo = mtQueNo;
//		this.queWriterName = queWriterName;
//		this.queTitle = queTitle;
//		this.queContent = queContent;
//		this.queEnrolldate = queEnrolldate;
//		this.queLike = queLike;
//		this.ansWriterName = ansWriterName;
//		this.ansContent = ansContent;
//		this.ansEnrollDate = ansEnrollDate;
//	}
//
//	public MtQuestion(int mtQueNo, int queWriterNo, String queWriterName, String queTitle, String queContent,
//			Date queEnrolldate) {
//		super();
//		this.mtQueNo = mtQueNo;
//		this.queWriterNo = queWriterNo;
//		this.queWriterName = queWriterName;
//		this.queTitle = queTitle;
//		this.queContent = queContent;
//		this.queEnrolldate = queEnrolldate;
//	}
//
//	public MtQuestion(int mtQueNo, int queWriterNo, String queWriterName, String queDate, String queTitle,
//			String queContent, int ansWriterNo, String ansWriterName, String ansDate, String ansContent) {
//		super();
//		this.mtQueNo = mtQueNo;
//		this.queWriterNo = queWriterNo;
//		this.queWriterName = queWriterName;
//		this.queDate = queDate;
//		this.queTitle = queTitle;
//		this.queContent = queContent;
//		this.ansWriterNo = ansWriterNo;
//		this.ansWriterName = ansWriterName;
//		this.ansDate = ansDate;
//		this.ansContent = ansContent;
//	}
//
//	public MtQuestion(int mtQueNo, int queWriterNo, String queTitle, String queContent, Date queEnrolldate,
//			int queLike, int ansWriterNo, String ansContent, Date ansEnrollDate) {
//		super();
//		this.mtQueNo = mtQueNo;
//		this.queWriterNo = queWriterNo;
//		this.queTitle = queTitle;
//		this.queContent = queContent;
//		this.queEnrolldate = queEnrolldate;
//		this.queLike = queLike;
//		this.ansWriterNo = ansWriterNo;
//		this.ansContent = ansContent;
//		this.ansEnrollDate = ansEnrollDate;
//	}
//
//	public MtQuestion(int mtQueNo, int queWriterNo, String queWriterName, String queTitle, String queContent,
//			Date queEnrolldate, int queLike, int ansWriterNo, String ansContent, Date ansEnrollDate) {
//		super();
//		this.mtQueNo = mtQueNo;
//		this.queWriterNo = queWriterNo;
//		this.queWriterName = queWriterName;
//		this.queTitle = queTitle;
//		this.queContent = queContent;
//		this.queEnrolldate = queEnrolldate;
//		this.queLike = queLike;
//		this.ansWriterNo = ansWriterNo;
//		this.ansContent = ansContent;
//		this.ansEnrollDate = ansEnrollDate;
//	}

	public String getQueDate() {
		return queDate;
	}

	public void setQueDate(String queDate) {
		this.queDate = queDate;
	}

//	public String getAnsWriterName() {
//		return ansWriterName;
//	}
//
//	public void setAnsWriterName(String ansWriterName) {
//		this.ansWriterName = ansWriterName;
//	}

	public Date getAnsDate() {
		return ansDate;
	}

	public void setAnsDate(Date ansDate) {
		this.ansDate = ansDate;
	}

//	public int getQueWriterNo() {
//		return queWriterNo;
//	}
//
//	public String getQueWriterName() {
//		return queWriterName;
//	}
//
//	public void setQueWriterName(String queWriterName) {
//		this.queWriterName = queWriterName;
//	}
//
//	public void setQueWriterNo(int queWriterNo) {
//		this.queWriterNo = queWriterNo;
//	}

	public int getMtQueNo() {
		return mtQueNo;
	}

	public void setMtQueNo(int mtQueNo) {
		this.mtQueNo = mtQueNo;
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

//	public int getAnsWriterNo() {
//		return ansWriterNo;
//	}
//
//	public void setAnsWriterNo(int ansWriterNo) {
//		this.ansWriterNo = ansWriterNo;
//	}

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
		return "MtQuestion [mtQueNo=" + mtQueNo + ", member=" + member
				+ ", queTitle=" + queTitle + ", queContent=" + queContent + ", queEnrolldate=" + queEnrolldate
				+ ", queLike=" + queLike + ", mentor=" + mentor + ", ansContent=" + ansContent
				+ ", ansEnrollDate=" + ansEnrollDate + "]";
	}
	
}
