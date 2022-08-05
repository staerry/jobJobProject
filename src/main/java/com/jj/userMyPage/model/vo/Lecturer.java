package com.jj.userMyPage.model.vo;

import com.jj.member.model.vo.Member;
import com.jj.member.model.vo.Mentor;

public class Lecturer {
	
//	private int userNo;
	private Member member;
//	private String userName;
	private Mentor mentor;
//	private String ltrCompany;
//	private String ltrJob;
//	private String ltrCategory;	// 멘토링 분야
	private String ltrInfo;
	private String ltrCareer;
	private String profilePath;
	public Member getMember() {
		return member;
	}
	public void setMember(Member member) {
		this.member = member;
	}
	public Mentor getMentor() {
		return mentor;
	}
	public void setMentor(Mentor mentor) {
		this.mentor = mentor;
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
	public String getProfilePath() {
		return profilePath;
	}
	public void setProfilePath(String profilePath) {
		this.profilePath = profilePath;
	}
	public Lecturer(Member member, Mentor mentor, String ltrInfo, String ltrCareer, String profilePath) {
		super();
		this.member = member;
		this.mentor = mentor;
		this.ltrInfo = ltrInfo;
		this.ltrCareer = ltrCareer;
		this.profilePath = profilePath;
	}
	@Override
	public String toString() {
		return "Lecturer [member=" + member + ", mentor=" + mentor + ", ltrInfo=" + ltrInfo + ", ltrCareer=" + ltrCareer
				+ ", profilePath=" + profilePath + "]";
	}
	
	
	
	

}
