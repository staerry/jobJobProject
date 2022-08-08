package com.jj.mentorMyPage.model.vo;

import java.sql.Date;

import com.jj.member.model.vo.Member;
import com.jj.member.model.vo.Mentor;

public class MtQuestion{
	
	private int mtQueNo;	// 멘토에게 질문글 고유번호
	private Member queUser;
	private String queTitle;
	private String queContent;	// 질문 작성일
	private Date queEnrolldate;
	private String queDate;	// TO_CHAR 사용 
	private int queLike;	// 질문글에 달린 좋아요 수
	private Mentor ansMentor;
	private String ansContent;
	private Date ansDate;	// 답변 작성일
	private String ansEnrollDate;	// TO_CHAR 사용
	public int getMtQueNo() {
		return mtQueNo;
	}
	public void setMtQueNo(int mtQueNo) {
		this.mtQueNo = mtQueNo;
	}
	public Member getQueUser() {
		return queUser;
	}
	public void setQueUser(Member queUser) {
		this.queUser = queUser;
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
	public String getQueDate() {
		return queDate;
	}
	public void setQueDate(String queDate) {
		this.queDate = queDate;
	}
	public int getQueLike() {
		return queLike;
	}
	public void setQueLike(int queLike) {
		this.queLike = queLike;
	}
	public Mentor getAnsMentor() {
		return ansMentor;
	}
	public void setAnsMentor(Mentor ansMentor) {
		this.ansMentor = ansMentor;
	}
	public String getAnsContent() {
		return ansContent;
	}
	public void setAnsContent(String ansContent) {
		this.ansContent = ansContent;
	}
//	public Date getAnsEnrollDate() {
//		return ansEnrollDate;
//	}
//	public void setAnsEnrollDate(Date ansEnrollDate) {
//		this.ansEnrollDate = ansEnrollDate;
//	}
	public Date getAnsDate() {
		return ansDate;
	}
	public void setAnsDate(Date ansDate) {
		this.ansDate = ansDate;
	}
	public MtQuestion() {
		super();
	}
	@Override
	public String toString() {
		return "MtQuestion [mtQueNo=" + mtQueNo + ", queUser=" + queUser + ", queTitle=" + queTitle + ", queContent="
				+ queContent + ", queEnrolldate=" + queEnrolldate + ", queDate=" + queDate + ", queLike=" + queLike
				+ ", ansMentor=" + ansMentor + ", ansContent=" + ansContent + ", ansEnrollDate=" + ansEnrollDate
				+ ", ansDate=" + ansDate + "]";
	}

	
	
}
