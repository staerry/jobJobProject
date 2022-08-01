package com.jj.mentorSelect.model.dao;

import static com.jj.common.JDBCTemplate.close;

import java.io.FileInputStream;
import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Properties;

import com.jj.community.model.dao.CommunityDao;
import com.jj.mentorSelect.model.vo.Lecturer;

public class LecturerDao {

Properties prop = new Properties();
	
	public LecturerDao() {
		try {
			prop.loadFromXML(new FileInputStream( CommunityDao.class.getResource("/db/sql/mentorSelect-mapper.xml").getPath()));
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	public int selectListCount(Connection conn) {
		int listCount = 0;
		PreparedStatement pstmt = null;
		ResultSet rset = null;
		String sql = prop.getProperty("selectListCount");
		
		try {
			pstmt = conn.prepareStatement(sql);
			rset = pstmt.executeQuery();
			
			if(rset.next()) {
				listCount = rset.getInt("lt_count");
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			close(rset);
			close(pstmt);
		}
		
		return listCount;
	}
	
	public ArrayList<Lecturer> selectList(Connection conn) {
		ArrayList<Lecturer> list = new ArrayList<>();
		PreparedStatement pstmt = null;
		ResultSet rset = null;
		String sql = prop.getProperty("selectList");
		
		try {
			pstmt = conn.prepareStatement(sql);
			rset = pstmt.executeQuery();
			
			while(rset.next()) {
				list.add(new Lecturer(rset.getInt("user_no"),
									  rset.getString("user_name"),
									  rset.getString("mt_company"),
									  rset.getString("mt_job"),
									  rset.getString("clcg_name"),
									  rset.getString("ltr_info"),
									  rset.getString("ltr_career"),
									  rset.getString("profile_path")
						));
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			close(rset);
			close(pstmt);
		}
		
		return list;
		
	}
}
