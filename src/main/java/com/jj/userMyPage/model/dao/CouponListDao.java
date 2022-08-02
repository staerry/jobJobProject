package com.jj.userMyPage.model.dao;

import java.io.FileInputStream;
import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Properties;
import static com.jj.common.JDBCTemplate.*;

import com.jj.userMyPage.model.vo.UCoupon;

public class CouponListDao {
	
	Properties prop = new Properties();
	
	public CouponListDao() {
		try {
			prop.loadFromXML(new FileInputStream(CouponListDao.class.getResource("/db/sql/userMyPage-mapper.xml").getPath()));
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	public ArrayList<UCoupon> selectListCp(Connection conn, int UserNo){
		
		ArrayList <UCoupon> list = new ArrayList<>();
		PreparedStatement pstmt = null;
		ResultSet rset =null;
		
		String sql = prop.getProperty("selectListCp");
		
		try {
			pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1, UserNo);
			rset = pstmt.executeQuery();
			
			while(rset.next()) {
						
				list.add(new UCoupon(rset.getString("cp_name"),
										rset.getInt("discount"),
									 rset.getDate("cp_enddate")
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
	
	
	
	public int countCp(Connection conn, int userNo) {
		
		int result=0;
		PreparedStatement pstmt = null;
		ResultSet rset = null;
		String sql = prop.getProperty("countCp");
		
		try {
			pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1,userNo);
			rset = pstmt.executeQuery();
			
			if(rset.next()) {
				result = rset.getInt("count");
			}
		} catch (SQLException e) {
					
			
			e.printStackTrace();
		}
		
		return result;
	}
	
	
	
	
	
	
	
	
	

}
