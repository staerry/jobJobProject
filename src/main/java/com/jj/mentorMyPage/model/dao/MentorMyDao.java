package com.jj.mentorMyPage.model.dao;

import java.io.FileInputStream;
import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Properties;
import static com.jj.common.JDBCTemplate.close;
import com.jj.member.model.vo.Member;
import com.jj.mentorMyPage.model.vo.CreateClass;
import com.jj.mentorMyPage.model.vo.Vod;
import com.jj.userMyPage.model.vo.Class;


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
		}finally {
			close(pstmt);
		}
		
		
		return result;
		
	}
	
	public  ArrayList<CreateClass> selectClass(Connection conn, int userNo){
		ArrayList<CreateClass> list = new ArrayList<>();
		PreparedStatement pstmt = null;
		ResultSet rset = null;
		
		String sql = prop.getProperty("selectClass");
		
		try {
			pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1, userNo);
			rset = pstmt.executeQuery();
			
			while(rset.next()) {
				list.add(new CreateClass(rset.getInt("cl_no"),
										rset.getInt("cl_category"),
										 rset.getString("cl_title"),
										 rset.getDate("cl_enrolldate"),
										 rset.getString("cl_grant")
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


	public int selectVodNo(Connection conn, int clNo) {
		int vodNo = 0;
		PreparedStatement pstmt = null;
		ResultSet rset = null;
		
		String sql = prop.getProperty("selectVodNo");
		try {
			pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1, clNo);
			rset = pstmt.executeQuery();
			
			while(rset.next()) {
				
				vodNo = rset.getInt("vod_count");
			
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}finally {
			close(rset);
			close(pstmt);
		}
		return vodNo;
	}


	public int insertVod(Connection conn, Vod vod) {
		int result = 0;
		PreparedStatement pstmt = null;
		
		String sql = prop.getProperty("insertVod");
		try {
			pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1, vod.getCls().getClNo());
			pstmt.setString(2, vod.getVodTitle());
			pstmt.setString(3, vod.getVodFile());
			result = pstmt.executeUpdate();

		} catch (SQLException e) {
			e.printStackTrace();
		}finally {

			close(pstmt);
		}
		return result;
	}


	public Class selectOneClass(Connection conn, int clNo) {
		Class cls = new Class();;
		PreparedStatement pstmt = null;
		ResultSet rset = null;
		
		String sql = prop.getProperty("selectOneClass");
		try {
			pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1, clNo);
			rset = pstmt.executeQuery();
			
			while(rset.next()) {
				cls.setClNo(clNo);
				cls.setClTitle(rset.getString("cl_title"));
				cls.setClSubtitle(rset.getString("cl_subtitle"));
				cls.setClInfo(rset.getString("cl_info"));
				cls.setClCurri(rset.getString("cl_curri"));
				cls.setClPrice(rset.getInt("cl_price"));
				cls.setClEnrolldate(rset.getDate("cl_enrolldate"));
				cls.setClGrant(rset.getString("cl_grant"));
			
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}finally {
			close(rset);
			close(pstmt);
		}
		return cls;
	}
	
	
	
	
	
	
}
