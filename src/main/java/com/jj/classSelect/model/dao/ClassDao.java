package com.jj.classSelect.model.dao;

import static com.jj.common.JDBCTemplate.close;

import java.io.FileInputStream;
import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Properties;

import com.jj.classSelect.model.vo.Class;
import com.jj.community.model.vo.Review;

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
	
	public int selectListCount(Connection conn, String category) {
		int listCount = 0;
		PreparedStatement pstmt = null;
		ResultSet rset = null;
		String sql = prop.getProperty("selectListCount");
		
		try {
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, category);
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
								   rset.getString("clcg_no"),
								   rset.getString("cl_title"),
								   rset.getString("cl_subtitle"),
								   rset.getString("cl_info"),
								   rset.getString("cl_curri"),
								   rset.getString("cl_price"),
								   rset.getDate("cl_enrolldate"),
								   rset.getString("cl_grant"),
								   rset.getString("cl_thumbnailpath"),
								   rset.getDouble("review_score")					   
						));
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			close(rset);
			close(pstmt);
		}
		
		System.out.println(list);
		
		return list;
		
	}
	
	public ArrayList<Class> selectList(Connection conn, String category) {
		ArrayList<Class> list = new ArrayList<>();
		PreparedStatement pstmt = null;
		ResultSet rset = null;
		String sql = prop.getProperty("selectList");
		
		try {
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, category);
			rset = pstmt.executeQuery();
			
			while(rset.next()) {
				list.add(new Class(rset.getInt("cl_no"),
								   rset.getString("user_name"),
								   rset.getString("mt_company"),
								   rset.getString("clcg_no"),
								   rset.getString("cl_title"),
								   rset.getString("cl_subtitle"),
								   rset.getString("cl_info"),
								   rset.getString("cl_curri"),
								   rset.getString("cl_price"),
								   rset.getDate("cl_enrolldate"),
								   rset.getString("cl_grant"),
								   rset.getString("cl_thumbnailpath"),
								   rset.getDouble("review_score")
						));
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			close(rset);
			close(pstmt);
		}
		System.out.println(list);
		return list;
	}
	
	public Class selectClass(Connection conn, int clNo) {
		Class c = null;
		PreparedStatement pstmt = null;
		ResultSet rset = null;
		String sql = prop.getProperty("selectClass");
		
		try {
			pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1, clNo);
			rset = pstmt.executeQuery();
			
			if(rset.next()) {
				c = new Class(rset.getInt("cl_no"),
							  rset.getString("user_name"),
							  rset.getString("cl_category"),
							  rset.getString("cl_title"),
							  rset.getString("cl_subtitle"),
							  rset.getString("cl_info"),
							  rset.getString("cl_curri"),
							  rset.getString("cl_price"),
							  rset.getString("cl_thumbnailpath"),
							  rset.getString("ltr_info"),
							  rset.getString("ltr_career"),
							  rset.getString("profile_path")
							 );
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			close(rset);
			close(pstmt);
		}
		
		return c;
	}
	
	public int selectStudentCount(Connection conn, int clNo) {
		int studentCount = 0;
		PreparedStatement pstmt = null;
		ResultSet rset = null;
		String sql = prop.getProperty("selectStudentCount");
		
		try {
			pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1, clNo);
			
			rset = pstmt.executeQuery();
			
			if(rset.next()) {
				studentCount = rset.getInt("student_count");
			}
			
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			close(rset);
			close(pstmt);
		}
		
		return studentCount;
		
	}
	
	public int selectBookmarkCount(Connection conn, int clNo) {
		int bookmarkCount = 0;
		PreparedStatement pstmt = null;
		ResultSet rset = null;
		String sql = prop.getProperty("selectBookmarkCount");
		
		try {
			pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1, clNo);
			
			rset = pstmt.executeQuery();
			
			if(rset.next()) {
				bookmarkCount = rset.getInt("bookmark_count");
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			close(rset);
			close(pstmt);
		}
		
		return bookmarkCount;
	}
	
	public ArrayList<Review> selectReview(Connection conn, int clNo) {
		ArrayList<Review> list = new ArrayList<>();
		PreparedStatement pstmt = null;
		ResultSet rset = null;
		String sql = prop.getProperty("selectReview");
		
		try {
			pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1, clNo);
			rset = pstmt.executeQuery();
			
			while(rset.next()) {
				list.add(new Review(rset.getInt("review_no"),
						 			rset.getString("cl_no"),
						 			rset.getString("user_name"),
						 			rset.getInt("review_score"),
						 			rset.getString("review_content"),
						 			rset.getDate("review_enrolldate")
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
	
	public ArrayList<Class> selectListAllByPrice(Connection conn) {
		ArrayList<Class> list = new ArrayList<>();
		PreparedStatement pstmt = null;
		ResultSet rset = null;
		String sql = prop.getProperty("selectListAllByPrice");
		
		try {
			pstmt = conn.prepareStatement(sql);
			rset = pstmt.executeQuery();
			while(rset.next()) {
				list.add(new Class(rset.getInt("cl_no"),
						   rset.getString("user_name"),
						   rset.getString("mt_company"),
						   rset.getString("clcg_no"),
						   rset.getString("cl_title"),
						   rset.getString("cl_subtitle"),
						   rset.getString("cl_info"),
						   rset.getString("cl_curri"),
						   rset.getString("cl_price"),
						   rset.getDate("cl_enrolldate"),
						   rset.getString("cl_grant"),
						   rset.getString("cl_thumbnailpath"),
						   rset.getDouble("review_score")
				));
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			close(rset);
			close(pstmt);
		}
		System.out.println(list);
		return list;
		
	}
	
	public ArrayList<Class> selectListByPrice(Connection conn, String category) {
		ArrayList<Class> list = new ArrayList<>();
		PreparedStatement pstmt = null;
		ResultSet rset = null;
		String sql = prop.getProperty("selectListByPrice");
		
		try {
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, category);
			rset = pstmt.executeQuery();
			
			while(rset.next()) {
				list.add(new Class(rset.getInt("cl_no"),
								   rset.getString("user_name"),
								   rset.getString("mt_company"),
								   rset.getString("clcg_no"),
								   rset.getString("cl_title"),
								   rset.getString("cl_subtitle"),
								   rset.getString("cl_info"),
								   rset.getString("cl_curri"),
								   rset.getString("cl_price"),
								   rset.getDate("cl_enrolldate"),
								   rset.getString("cl_grant"),
								   rset.getString("cl_thumbnailpath"),
								   rset.getDouble("review_score")
						));
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			close(rset);
			close(pstmt);
		}
		System.out.println(list);
		return list;
	}
	
	public ArrayList<Class> selectListAllByScore(Connection conn) {
		ArrayList<Class> list = new ArrayList<>();
		PreparedStatement pstmt = null;
		ResultSet rset = null;
		String sql = prop.getProperty("selectListAllByScore");
		
		try {
			pstmt = conn.prepareStatement(sql);
			rset = pstmt.executeQuery();
			while(rset.next()) {
				list.add(new Class(rset.getInt("cl_no"),
						   rset.getString("user_name"),
						   rset.getString("mt_company"),
						   rset.getString("clcg_no"),
						   rset.getString("cl_title"),
						   rset.getString("cl_subtitle"),
						   rset.getString("cl_info"),
						   rset.getString("cl_curri"),
						   rset.getString("cl_price"),
						   rset.getDate("cl_enrolldate"),
						   rset.getString("cl_grant"),
						   rset.getString("cl_thumbnailpath"),
						   rset.getDouble("review_score")
				));
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			close(rset);
			close(pstmt);
		}
		System.out.println(list);
		return list;
	}
	
	public ArrayList<Class> selectListByScore(Connection conn, String category) {
		ArrayList<Class> list = new ArrayList<>();
		PreparedStatement pstmt = null;
		ResultSet rset = null;
		String sql = prop.getProperty("selectListByScore");
		
		try {
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, category);
			rset = pstmt.executeQuery();
			
			while(rset.next()) {
				list.add(new Class(rset.getInt("cl_no"),
								   rset.getString("user_name"),
								   rset.getString("mt_company"),
								   rset.getString("clcg_no"),
								   rset.getString("cl_title"),
								   rset.getString("cl_subtitle"),
								   rset.getString("cl_info"),
								   rset.getString("cl_curri"),
								   rset.getString("cl_price"),
								   rset.getDate("cl_enrolldate"),
								   rset.getString("cl_grant"),
								   rset.getString("cl_thumbnailpath"),
								   rset.getDouble("review_score")
						));
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			close(rset);
			close(pstmt);
		}
		System.out.println(list);
		return list;
	}

}
