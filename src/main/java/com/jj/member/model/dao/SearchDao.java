package com.jj.member.model.dao;

import static com.jj.common.JDBCTemplate.close;

import java.io.FileInputStream;
import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Properties;

public class SearchDao {
	
	private Properties prop = new Properties();
	
	public SearchDao() {
		String filePath = MemberDao.class.getResource("/db/sql/search-mapper.xml").getPath();
	
		try {
			prop.loadFromXML(new FileInputStream(filePath));
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	public int searchCount(Connection conn, String keyword, String select) {
		int count = 0;
		
		PreparedStatement pstmt = null;
		ResultSet rset = null;
		
		String sql = null;
		
		if(select.equals("class")) {
			sql = prop.getProperty("searchClassCount");
			
		}else if(select.equals("lecturer")) {
			sql = prop.getProperty("searchLecturerCount");
			
		}else if(select.equals("community")) {
			sql = prop.getProperty("searchCommunityCount");
		}
		
		try {
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, "%" + keyword + "%");
			pstmt.setString(2, "%" + keyword + "%");
			pstmt.setString(3, "%" + keyword + "%");
			rset = pstmt.executeQuery();
			
			if(rset.next()) {
				count = rset.getInt("count");
			}
			
		} catch (SQLException e) {
			e.printStackTrace();
		}finally {
			close(rset);
			close(pstmt);
		}
		
		return count;
	}
}
