package com.jj.admin.model.vo;

public class GraphDate {
	private String x;
	private int y;
	
	public GraphDate() {}

	public GraphDate(String x, int y) {
		super();
		this.x = x;
		this.y = y;
	}
	
	public GraphDate(String x) {
		super();
		this.x = x;
		
	}
	
	public GraphDate(int y) {
		super();
		this.y = y;
	}

	public String getX() {
		return x;
	}

	public void setX(String x) {
		this.x = x;
	}

	public int getY() {
		return y;
	}

	public void setY(int y) {
		this.y = y;
	}

	@Override
	public String toString() {
		return "GraphDate [x=" + x + ", y=" + y + "]";
	}
	
	
}
