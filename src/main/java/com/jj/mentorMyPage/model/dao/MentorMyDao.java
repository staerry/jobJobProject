package com.jj.mentorMyPage.model.dao;

import java.io.FileInputStream;
import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.Properties;

import com.jj.member.model.vo.Member;
import com.jj.mentorMyPage.model.vo.CreateClass;


public class MentorMyDao {

	
	
Properties prop = new Properties();
	
	public MentorMyDao() {
		try {
			prop.loadFromXML(new FileInputStream(MentorMyDao.class.getResource("/db/sql/mentorMyPage-mapper.xml").getPath()));
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	
	public int CreateClass(Connection conn, CreateClass cc, int userNo) {
		int result=0;
		PreparedStatement pstmt = null;
	
		String sql = prop.getProperty("crateClass");
		try {
			pstmt = conn.prepareStatement(sql);
			
			pstmt.setInt(1, userNo);
			pstmt.setInt(2,cc.getClCategory());
			pstmt.setString(3, cc.getClTitle());
			pstmt.setString(4, cc.getClSubTitle());
			pstmt.setString(5, cc.getClInfo());
			pstmt.setString(6, cc.getClCurri());
			pstmt.setInt(7, cc.getClPrice());
			pstmt.setString(8,cc.getClImg());
			
			
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		
		return result;
		
	}
	
	
	
	
	
	
	
	
}
