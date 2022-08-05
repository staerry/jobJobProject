package com.jj.userMyPage.model.vo;

import java.sql.Date;

public class Payment {
	private int payNo;
	private int userNo;
	private int clNo;
	private int isucpNo;
	private String payment;
	private	String refund;
	private int finalPayment;
	private String orderName;
	private String orderPhone;
	private String orderEmail;
	private Date payDate;
	private Date refundDate;
	private String clTitle;
	private String userName;
	private int clPrice;
	private int discount;
	
	public Payment(int payNo, int userNo, int clNo, int isucpNo, String payment, String refund, int finalPayment,
			String orderName, String orderPhone, String orderEmail, Date payDate, Date refundDate, String clTitle,
			String userName, int clPrice, int discount) {
		super();
		this.payNo = payNo;
		this.userNo = userNo;
		this.clNo = clNo;
		this.isucpNo = isucpNo;
		this.payment = payment;
		this.refund = refund;
		this.finalPayment = finalPayment;
		this.orderName = orderName;
		this.orderPhone = orderPhone;
		this.orderEmail = orderEmail;
		this.payDate = payDate;
		this.refundDate = refundDate;
		this.clTitle = clTitle;
		this.userName = userName;
		this.clPrice = clPrice;
		this.discount = discount;
	}
	
	
	public Payment(int payNo, String clTitle, String userName, Date payDate) {
		super();
		this.payNo = payNo;
		this.payDate = payDate;
		this.clTitle = clTitle;
		this.userName = userName;
	}
	
	


	public Payment(int payNo, String payment, String refund, int finalPayment, String orderName, String orderPhone,
			String orderEmail, Date payDate, String clTitle, int clPrice, int discount) {
		super();
		this.payNo = payNo;
		this.payment = payment;
		this.refund = refund;
		this.finalPayment = finalPayment;
		this.orderName = orderName;
		this.orderPhone = orderPhone;
		this.orderEmail = orderEmail;
		this.payDate = payDate;
		this.clTitle = clTitle;
		this.clPrice = clPrice;
		this.discount = discount;
	}


	public int getPayNo() {
		return payNo;
	}
	public void setPayNo(int payNo) {
		this.payNo = payNo;
	}
	public int getUserNo() {
		return userNo;
	}
	public void setUserNo(int userNo) {
		this.userNo = userNo;
	}
	public int getClNo() {
		return clNo;
	}
	public void setClNo(int clNo) {
		this.clNo = clNo;
	}
	public int getIsucpNo() {
		return isucpNo;
	}
	public void setIsucpNo(int isucpNo) {
		this.isucpNo = isucpNo;
	}
	public String getPayment() {
		return payment;
	}
	public void setPayment(String payment) {
		this.payment = payment;
	}
	public String getRefund() {
		return refund;
	}
	public void setRefund(String refund) {
		this.refund = refund;
	}
	public int getFinalPayment() {
		return finalPayment;
	}
	public void setFinalPayment(int finalPayment) {
		this.finalPayment = finalPayment;
	}
	public String getOrderName() {
		return orderName;
	}
	public void setOrderName(String orderName) {
		this.orderName = orderName;
	}
	public String getOrderPhone() {
		return orderPhone;
	}
	public void setOrderPhone(String orderPhone) {
		this.orderPhone = orderPhone;
	}
	public String getOrderEmail() {
		return orderEmail;
	}
	public void setOrderEmail(String orderEmail) {
		this.orderEmail = orderEmail;
	}
	public Date getPayDate() {
		return payDate;
	}
	public void setPayDate(Date payDate) {
		this.payDate = payDate;
	}
	public Date getRefundDate() {
		return refundDate;
	}
	public void setRefundDate(Date refundDate) {
		this.refundDate = refundDate;
	}
	public String getClTitle() {
		return clTitle;
	}
	public void setClTitle(String clTitle) {
		this.clTitle = clTitle;
	}
	public String getUserName() {
		return userName;
	}
	public void setUserName(String userName) {
		this.userName = userName;
	}
	public int getClPrice() {
		return clPrice;
	}
	public void setClPrice(int clPrice) {
		this.clPrice = clPrice;
	}
	public int getDiscount() {
		return discount;
	}
	public void setDiscount(int discount) {
		this.discount = discount;
	}
	@Override
	public String toString() {
		return "Payment [payNo=" + payNo + ", userNo=" + userNo + ", clNo=" + clNo + ", isucpNo=" + isucpNo
				+ ", payment=" + payment + ", refund=" + refund + ", finalPayment=" + finalPayment + ", orderName="
				+ orderName + ", orderPhone=" + orderPhone + ", orderEmail=" + orderEmail + ", payDate=" + payDate
				+ ", refundDate=" + refundDate + ", clTitle=" + clTitle + ", userName=" + userName + ", clPrice="
				+ clPrice + ", discount=" + discount + "]";
	}
	
	

	
}
