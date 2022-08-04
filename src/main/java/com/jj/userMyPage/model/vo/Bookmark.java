package com.jj.userMyPage.model.vo;

import java.util.Date;

import com.jj.member.model.vo.Member;

public class Bookmark {

	private Member member;
	private Class cls;
	private Date clLikeDate;
	
	public Member getMember() {
		return member;
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
	public Date getClLikeDate() {
		return clLikeDate;
	}
	public void setClLikeDate(Date clLikeDate) {
		this.clLikeDate = clLikeDate;
	}
	public Bookmark(Member member, Class cls, Date clLikeDate) {
		super();
		this.member = member;
		this.cls = cls;
		this.clLikeDate = clLikeDate;
	}
	public Bookmark() {
		super();

	}
	@Override
	public String toString() {
		return "Bookmark [member=" + member + ", cls=" + cls + ", clLikeDate=" + clLikeDate + "]";
	}
	
	
	
	
	
}
