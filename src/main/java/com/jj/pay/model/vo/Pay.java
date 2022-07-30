package com.jj.pay.model.vo;

import java.sql.Date;

import com.jj.common.model.vo.PageInfo;

public class Pay {
	private int payNo;
	private String userNo;
	private String clNo;
	private String isuCpNo;
	private String payment;
	private String refund;
	private int finalPayment;
	private String orderName;
	private String orderPhone;
	private String orderEmail;
	private Date payDate;
	private Date refundDate;
	private PageInfo pi;
	
	public Pay() {}

	public Pay(int payNo, String userNo, String clNo, String isuCpNo, String payment, String refund,
			int finalPayment, String orderName, String orderPhone, String orderEmail, Date payDate,
			Date refundDate) {
		super();
		this.payNo = payNo;
		this.userNo = userNo;
		this.clNo = clNo;
		this.isuCpNo = isuCpNo;
		this.payment = payment;
		this.refund = refund;
		this.finalPayment = finalPayment;
		this.orderName = orderName;
		this.orderPhone = orderPhone;
		this.orderEmail = orderEmail;
		this.payDate = payDate;
		this.refundDate = refundDate;
	}
	
	

	public Pay(int payNo, String userNo, String clNo, String isuCpNo, String payment, String refund, int finalPayment,
			String orderName, String orderPhone, String orderEmail, Date payDate, Date refundDate, PageInfo pi) {
		super();
		this.payNo = payNo;
		this.userNo = userNo;
		this.clNo = clNo;
		this.isuCpNo = isuCpNo;
		this.payment = payment;
		this.refund = refund;
		this.finalPayment = finalPayment;
		this.orderName = orderName;
		this.orderPhone = orderPhone;
		this.orderEmail = orderEmail;
		this.payDate = payDate;
		this.refundDate = refundDate;
		this.pi = pi;
	}

	public int getPayNo() {
		return payNo;
	}

	public void setPayNo(int payNo) {
		this.payNo = payNo;
	}

	public String getUserNo() {
		return userNo;
	}

	public void setUserNo(String userNo) {
		this.userNo = userNo;
	}

	public String getClNo() {
		return clNo;
	}

	public void setClNo(String clNo) {
		this.clNo = clNo;
	}

	public String getIsuCpNo() {
		return isuCpNo;
	}

	public void setIsuCpNo(String isuCpNo) {
		this.isuCpNo = isuCpNo;
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

	@Override
	public String toString() {
		return "Pay [payNo=" + payNo + ", userNo=" + userNo + ", clNo=" + clNo + ", isuCpNo=" + isuCpNo + ", payment="
				+ payment + ", refund=" + refund + ", finalPayment=" + finalPayment + ", orderName=" + orderName
				+ ", orderPhone=" + orderPhone + ", orderEmail=" + orderEmail + ", payDate=" + payDate + ", refundDate="
				+ refundDate + "]";
	}
	
	
}


