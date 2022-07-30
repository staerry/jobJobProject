package com.jj.classSelect.model.dao;

import java.io.FileInputStream;
import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Properties;

import com.jj.classSelect.model.vo.Class;
import static com.jj.common.JDBCTemplate.*;

public class ClassDao {
	
	Properties prop = new Properties();
	
	public ClassDao() {
		try {
			prop.loadFromXML(new FileInputStream(ClassDao.class.getResource("/db/sql/classSelect-mapper.xml").getPath()));
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	public int selectListCountAll(Connection conn) {
		int listCount = 0;
		PreparedStatement pstmt = null;
		ResultSet rset = null;
		String sql = prop.getProperty("selectListCountAll");
		
		try {
			pstmt = conn.prepareStatement(sql);
			rset = pstmt.executeQuery();
			
			if(rset.next()) {
				listCount = rset.getInt("count");
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			close(rset);
			close(pstmt);
		}
		
		return listCount;
		
	}
	
	public int selectListCount(Connection conn, int category) {
		int listCount = 0;
		PreparedStatement pstmt = null;
		ResultSet rset = null;
		String sql = prop.getProperty("selectListCount");
		
		try {
			pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1, category);
			rset = pstmt.executeQuery();
			
			if(rset.next()) {
				listCount = rset.getInt("count");
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			close(rset);
			close(pstmt);
		}
		
		return listCount;
		
	}
	
	public ArrayList<Class> selectListAll(Connection conn) {
		ArrayList<Class> list = new ArrayList<>();
		PreparedStatement pstmt = null;
		ResultSet rset = null;
		String sql = prop.getProperty("selectListAll");
		
		try {
			pstmt = conn.prepareStatement(sql);
			rset = pstmt.executeQuery();
			
			while(rset.next()) {
				list.add(new Class(rset.getInt("cl_no"),
								   rset.getString("user_name"),
								   rset.getString("mt_company"),
								   rset.getString("clcg_name"),
								   rset.getString("cl_title"),
								   rset.getString("cl_subtitle"),
								   rset.getString("cl_info"),
								   rset.getString("cl_curri"),
								   rset.getInt("cl_price"),
								   rset.getDate("cl_enrolldate"),
								   rset.getString("cl_grant"),
								   rset.getString("cl_thumbnailpath")			
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
	
	public ArrayList<Class> selectList(Connection conn, int category) {
		ArrayList<Class> list = new ArrayList<>();
		PreparedStatement pstmt = null;
		ResultSet rset = null;
		String sql = prop.getProperty("selectList");
		
		try {
			pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1, category);
			rset = pstmt.executeQuery();
			
			while(rset.next()) {
				list.add(new Class(rset.getInt("cl_no"),
								   rset.getString("user_name"),
								   rset.getString("mt_company"),
								   rset.getString("clcg_name"),
								   rset.getString("cl_title"),
								   rset.getString("cl_subtitle"),
								   rset.getString("cl_info"),
								   rset.getString("cl_curri"),
								   rset.getInt("cl_price"),
								   rset.getDate("cl_enrolldate"),
								   rset.getString("cl_grant"),
								   rset.getString("cl_thumbnailpath")			
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
