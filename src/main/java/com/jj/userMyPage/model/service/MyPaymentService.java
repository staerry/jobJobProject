package com.jj.userMyPage.model.service;

import static com.jj.common.JDBCTemplate.close;
import static com.jj.common.JDBCTemplate.getConnection;

import java.sql.Connection;
import java.util.ArrayList;

import com.jj.userMyPage.model.dao.MyPaymentDao;
import com.jj.userMyPage.model.vo.Payment;

public class MyPaymentService {

	public ArrayList<Payment> myPaymentList(int userNo) {
		
		Connection conn = getConnection();
		ArrayList<Payment> list = new MyPaymentDao().myPaymentList(conn, userNo);
		close(conn);
		return list;
	}
	
	public Payment myPaymentDetails(int payNo){
		
		Connection conn = getConnection();
		Payment p = new MyPaymentDao().myPaymentDetails(conn, payNo);
		close(conn);
		return p;
	}
}
