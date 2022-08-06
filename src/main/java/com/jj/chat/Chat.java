package com.jj.chat;

import java.sql.Date;

public class Chat {
	private int chat_no;
	private String user_no;
	private String sendTo;
	private String message;
	private Date sendDate;
	private String userName;
	
	public Chat() {
		
	}

	public Chat(int chat_no, String user_no, String sendTo, String message, Date sendDate) {
		super();
		this.chat_no = chat_no;
		this.user_no = user_no;
		this.sendTo = sendTo;
		this.message = message;
		this.sendDate = sendDate;
	}
	public Chat(int chat_no, String user_no, String sendTo, String message, Date sendDate, String userName) {
		super();
		this.chat_no = chat_no;
		this.user_no = user_no;
		this.sendTo = sendTo;
		this.message = message;
		this.sendDate = sendDate;
		this.userName = userName;
	}

	
	public Chat(String userName, String user_no) {
		super();
		this.userName = userName;
		this.user_no = user_no;
	}

	public int getChat_no() {
		return chat_no;
	}

	public void setChat_no(int chat_no) {
		this.chat_no = chat_no;
	}

	public String getUser_no() {
		return user_no;
	}

	public void setUser_no(String user_no) {
		this.user_no = user_no;
	}

	public String getSendTo() {
		return sendTo;
	}

	public void setSendTo(String sendTo) {
		this.sendTo = sendTo;
	}

	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}

	public Date getSendDate() {
		return sendDate;
	}

	public void setSendDate(Date sendDate) {
		this.sendDate = sendDate;
	}

	public String getUserName() {
		return userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}

	@Override
	public String toString() {
		return "Chat [chat_no=" + chat_no + ", user_no=" + user_no + ", sendTo=" + sendTo + ", message=" + message
				+ ", sendDate=" + sendDate + ", userName=" + userName + "]";
	}
}