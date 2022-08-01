package com.jj.member.model.vo;

import java.sql.Date;

public class SlideAttachment {
	
	private int fileNo;
	private String fileName;
	private String filePath;
	private Date uploadDate;
	
	public SlideAttachment() {};
	
	public SlideAttachment(int fileNo, String fileName, String filePath, Date uploadDate) {
		super();
		this.fileNo = fileNo;
		this.fileName = fileName;
		this.filePath = filePath;
		this.uploadDate = uploadDate;
	}

	public int getFileNo() {
		return fileNo;
	}

	public void setFileNo(int fileNo) {
		this.fileNo = fileNo;
	}

	public String getFileName() {
		return fileName;
	}

	public void setFileName(String fileName) {
		this.fileName = fileName;
	}

	public String getFilePath() {
		return filePath;
	}

	public void setFilePath(String filePath) {
		this.filePath = filePath;
	}

	public Date getUploadDate() {
		return uploadDate;
	}

	public void setUploadDate(Date uploadDate) {
		this.uploadDate = uploadDate;
	}

	@Override
	public String toString() {
		return "SlideAttachment [fileNo=" + fileNo + ", fileName=" + fileName + ", filePath=" + filePath
				+ ", uploadDate=" + uploadDate + "]";
	}

}
