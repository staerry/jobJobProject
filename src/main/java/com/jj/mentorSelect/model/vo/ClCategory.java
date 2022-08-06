package com.jj.mentorSelect.model.vo;

public class ClCategory {

	private int clcgNo; 
	private String clcgName;
	public int getClcgNo() {
		return clcgNo;
	}
	public void setClcgNo(int clcgNo) {
		this.clcgNo = clcgNo;
	}
	public String getClcgName() {
		return clcgName;
	}
	public void setClcgName(String clcgName) {
		this.clcgName = clcgName;
	}
	public ClCategory() {
		super();
	}
	public ClCategory(int clcgNo, String clcgName) {
		super();
		this.clcgNo = clcgNo;
		this.clcgName = clcgName;
	}
	@Override
	public String toString() {
		return "ClCategory [clcgNo=" + clcgNo + ", clcgName=" + clcgName + "]";
	}
	
	
	
}
