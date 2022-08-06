package com.jj.userMyPage.model.dao;

import static com.jj.common.JDBCTemplate.close;

import java.io.FileInputStream;
import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Properties;

import com.jj.userMyPage.model.vo.Payment;


public class MyPaymentDao {
	
	
	Properties prop = new Properties();
	
	public MyPaymentDao() {
		try {
			prop.loadFromXML(new FileInputStream(MyPaymentDao.class.getResource("/db/sql/userMyPage-mapper.xml").getPath()));
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	public ArrayList<Payment> myPaymentList(Connection conn, int userNo){
		
		ArrayList <Payment> list = new ArrayList<>();
		PreparedStatement pstmt = null;
		ResultSet rset =null;
		
		String sql = prop.getProperty("myPaymentList");
		
		try {
			pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1, userNo);
			rset = pstmt.executeQuery();
			
			while(rset.next()) {
						
				list.add(new Payment(
						   rset.getInt("pay_no")
						 , rset.getString("CL_TITLE")
						 , rset.getString("USER_NAME")
						 , rset.getDate("PAY_DATE")
					
					));
			
				
				}
			} catch (SQLException e) {
				
				e.printStackTrace();
			}finally {
				close(rset);
				close(pstmt);
			}
			
			return list;
		}
	
	public Payment myPaymentDetails(Connection conn, int payNo){
		
		Payment p = null;
		PreparedStatement pstmt = null;
		ResultSet rset =null;
		
		String sql = prop.getProperty("myPaymentDetails");
		
		try {
			pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1, payNo);
			rset = pstmt.executeQuery();
			
			if(rset.next()) {
						
				p = new Payment(rset.getInt("PAY_NO")
						, rset.getString("PAYMENT")
						, rset.getString("REFUND")
						, rset.getInt("FINAL_PAYMENT")
						, rset.getString("ORDER_NAME")
						, rset.getString("ORDER_PHONE")
						, rset.getString("ORDER_EMAIL")
						, rset.getDate("PAY_DATE")
						 , rset.getString("CL_TITLE")
						 , rset.getInt("CL_PRICE")
						 , rset.getInt("DISCOUNT")
					);
			
				
				}
			} catch (SQLException e) {
				
				e.printStackTrace();
			}finally {
				close(rset);
				close(pstmt);
			}
			
			return p;
		}
	
	
}
