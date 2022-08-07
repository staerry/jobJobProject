package com.jj.admin.model.vo;

public class BoardData {
	private String date;
	private int classBuy;
	private int sale;
	private int join;
	private int que;
	private int board;
	
	public BoardData() {}

	public BoardData(String date, int classBuy, int sale, int join, int que, int board) {
		super();
		this.date = date;
		this.classBuy = classBuy;
		this.sale = sale;
		this.join = join;
		this.que = que;
		this.board = board;
	}

	public BoardData(String date) {
		super();
		this.date = date;
	}

	public String getDate() {
		return date;
	}

	public void setDate(String date) {
		this.date = date;
	}

	public int getClassBuy() {
		return classBuy;
	}

	public void setClassBuy(int classBuy) {
		this.classBuy = classBuy;
	}

	public int getSale() {
		return sale;
	}

	public void setSale(int sale) {
		this.sale = sale;
	}

	public int getJoin() {
		return join;
	}

	public void setJoin(int join) {
		this.join = join;
	}

	public int getQue() {
		return que;
	}

	public void setQue(int que) {
		this.que = que;
	}

	public int getBoard() {
		return board;
	}

	public void setBoard(int board) {
		this.board = board;
	}

	@Override
	public String toString() {
		return "BoardData [date=" + date + ", classBuy=" + classBuy + ", sale=" + sale + ", join=" + join + ", que="
				+ que + ", borad=" + board + "]";
	};
	
	
}
