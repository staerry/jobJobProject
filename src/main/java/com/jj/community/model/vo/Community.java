package com.jj.community.model.vo;

import java.sql.Date;

public class Community {
	
	private int commNo;	// 글 번호
	private String commWriter;	// 작성 시 번호 | 조회 시 이름 
	private String commWriterId;
	private String commCategory;	// 작성 시 번호 | 조회 시 카테고리명
	private String commTitle;
	private String commContent;
	private Date createDate;
	private int count;
	private int likeCount; 
	private int replyCount;
	
	public Community() {}

	public Community(int commNo, String commWriter, String commTitle, String commContent, int count) {
		super();
		this.commNo = commNo;
		this.commWriter = commWriter;
		this.commTitle = commTitle;
		this.commContent = commContent;
		this.count = count;
	}

	public Community(int commNo, String commWriter, String commCategory, String commTitle, String commContent,
			Date createDate, int count, int likeCount) {
		super();
		this.commNo = commNo;
		this.commWriter = commWriter;
		this.commCategory = commCategory;
		this.commTitle = commTitle;
		this.commContent = commContent;
		this.createDate = createDate;
		this.count = count;
		this.likeCount = likeCount;
	}

	public Community(int commNo, String commWriter, String commCategory, String commTitle, String commContent,
			Date createDate, int count, int likeCount, int replyCount) {
		super();
		this.commNo = commNo;
		this.commWriter = commWriter;
		this.commCategory = commCategory;
		this.commTitle = commTitle;
		this.commContent = commContent;
		this.createDate = createDate;
		this.count = count;
		this.likeCount = likeCount;
		this.replyCount = replyCount;
	}
	
	public Community(int commNo, String commWriter, String commWriterId, String commCategory, String commTitle,
			String commContent, Date createDate, int count, int likeCount) {
		super();
		this.commNo = commNo;
		this.commWriter = commWriter;
		this.commWriterId = commWriterId;
		this.commCategory = commCategory;
		this.commTitle = commTitle;
		this.commContent = commContent;
		this.createDate = createDate;
		this.count = count;
		this.likeCount = likeCount;
	}

	
	
	public Community(int commNo, String commWriter, String commTitle, int count, Date createDate) {
		super();
		this.commNo = commNo;
		this.commWriter = commWriter;
		this.commTitle = commTitle;
		this.count = count;
		this.createDate = createDate;
	}

	public String getCommWriterId() {
		return commWriterId;
	}

	public void setCommWriterId(String commWriterId) {
		this.commWriterId = commWriterId;
	}

	public int getCommNo() {
		return commNo;
	}

	public void setCommNo(int commNo) {
		this.commNo = commNo;
	}

	public String getCommWriter() {
		return commWriter;
	}

	public void setCommWriter(String commWriter) {
		this.commWriter = commWriter;
	}

	public String getCommCategory() {
		return commCategory;
	}

	public void setCommCategory(String commCategory) {
		this.commCategory = commCategory;
	}

	public String getCommTitle() {
		return commTitle;
	}

	public void setCommTitle(String commTitle) {
		this.commTitle = commTitle;
	}

	public String getCommContent() {
		return commContent;
	}

	public void setCommContent(String commContent) {
		this.commContent = commContent;
	}

	public Date getCreateDate() {
		return createDate;
	}

	public void setCreateDate(Date createDate) {
		this.createDate = createDate;
	}

	public int getCount() {
		return count;
	}

	public void setCount(int count) {
		this.count = count;
	}

	public int getLikeCount() {
		return likeCount;
	}

	public void setLikeCount(int likeCount) {
		this.likeCount = likeCount;
	}
	
	public int getReplyCount() {
		return replyCount;
	}

	public void setReplyCount(int replyCount) {
		this.replyCount = replyCount;
	}

	@Override
	public String toString() {
		return "Community [commNo=" + commNo + ", commWriter=" + commWriter + ", commWriterId=" + commWriterId
				+ ", commCategory=" + commCategory + ", commTitle=" + commTitle + ", commContent=" + commContent
				+ ", createDate=" + createDate + ", count=" + count + ", likeCount=" + likeCount + ", replyCount="
				+ replyCount + "]";
	}
	
	

}
