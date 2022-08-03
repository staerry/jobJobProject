package com.jj.userMyPage.model.vo;

import java.sql.Date;

public class Post {
	
	private int cmNo;
	private int userNo;
	private int cmcgNo;
	private String cmTitle;
	private String cmContent;
	private Date cmEnrollDate;
	private int cmCount;
	private int cmLikeCount;
	private String userName;
	
	public Post(int cmNo, int userNo, int cmcgNo, String cmTitle, String cmContent, Date cmEnrollDate, int cmCount,
			int cmLikeCount, String userName) {
		super();
		this.cmNo = cmNo;
		this.userNo = userNo;
		this.cmcgNo = cmcgNo;
		this.cmTitle = cmTitle;
		this.cmContent = cmContent;
		this.cmEnrollDate = cmEnrollDate;
		this.cmCount = cmCount;
		this.cmLikeCount = cmLikeCount;
		this.userName = userName;
	}
	
	

	public Post(int cmNo, int cmcgNo, String cmTitle, String cmContent, Date cmEnrollDate, int cmCount, String userName) {
		super();
		this.cmNo = cmNo;
		this.cmcgNo = cmcgNo;
		this.cmTitle = cmTitle;
		this.cmContent = cmContent;
		this.cmEnrollDate = cmEnrollDate;
		this.cmCount = cmCount;
		this.userName = userName;
	}

	public String getUserName() {
		return userName;
	}
	
	public void setUserName(String userName) {
		this.userName = userName;
	}

	public int getCmNo() {
		return cmNo;
	}

	public void setCmNo(int cmNo) {
		this.cmNo = cmNo;
	}

	public int getUserNo() {
		return userNo;
	}

	public void setUserNo(int userNo) {
		this.userNo = userNo;
	}

	public int getCmcgNo() {
		return cmcgNo;
	}

	public void setCmcgNo(int cmcgNo) {
		this.cmcgNo = cmcgNo;
	}

	public String getCmTitle() {
		return cmTitle;
	}

	public void setCmTitle(String cmTitle) {
		this.cmTitle = cmTitle;
	}

	public String getCmContent() {
		return cmContent;
	}

	public void setCmContent(String cmContent) {
		this.cmContent = cmContent;
	}

	public Date getCmEnrollDate() {
		return cmEnrollDate;
	}

	public void setCmEnrollDate(Date cmEnrollDate) {
		this.cmEnrollDate = cmEnrollDate;
	}

	public int getCmCount() {
		return cmCount;
	}

	public void setCmCount(int cmCount) {
		this.cmCount = cmCount;
	}

	public int getCmLikeCount() {
		return cmLikeCount;
	}

	public void setCmLikeCount(int cmLikeCount) {
		this.cmLikeCount = cmLikeCount;
	}
	
	
	
}
