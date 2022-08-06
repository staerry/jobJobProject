package com.jj.userMyPage.model.vo;

import java.sql.Date;

import com.jj.member.model.vo.Member;

public class ClassIng {

//	필요한 정보 : 클래스 정보 
	
	
	private Member member; //userNo
	private Class cls;
	private Date clStartDate;  //수강시작일 
	public Member getMember() {
		return member;
	}
	
	public ClassIng() {
		super();
	}
	
	public void setMember(Member member) {
		this.member = member;
	}
	public Class getCls() {
		return cls;
	}
	public void setCls(Class cls) {
		this.cls = cls;
	}
	public Date getClStartDate() {
		return clStartDate;
	}
	public void setClStartDate(Date clStartDate) {
		this.clStartDate = clStartDate;
	}
	public ClassIng(Member member, Class cls, Date clStartDate) {
		super();
		this.member = member;
		this.cls = cls;
		this.clStartDate = clStartDate;
	}
	@Override
	public String toString() {
		return "ClassIng [member=" + member + ", cls=" + cls + ", clStartDate=" + clStartDate + "]";
	}
	
	
	
}
