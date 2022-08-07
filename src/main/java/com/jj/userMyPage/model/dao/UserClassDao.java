package com.jj.userMyPage.model.dao;

import static com.jj.common.JDBCTemplate.*;

import java.io.FileInputStream;
import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.Properties;

import com.jj.member.model.vo.Member;
import com.jj.mentorMyPage.model.vo.Vod;
import com.jj.userMyPage.model.vo.Bookmark;
import com.jj.userMyPage.model.vo.Class;
import com.jj.userMyPage.model.vo.ClassIng;
import com.jj.userMyPage.model.vo.UCoupon;

public class UserClassDao {
	Properties prop = new Properties();
	
	public UserClassDao() {
		try {
			prop.loadFromXML(new FileInputStream(UserClassDao.class.getResource("/db/sql/userMyPage-mapper.xml").getPath()));
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
//	
	public List<Bookmark> selectWishList(Connection conn, Member member) {
		PreparedStatement pstmt = null;
		ResultSet rset = null;
		List<Bookmark> list = new ArrayList<Bookmark>();
		String sql = prop.getProperty("selectListWish");
		
		try {
			pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1, member.getUserNo());
			rset = pstmt.executeQuery();
			
			while(rset.next()) {
				
				Bookmark bookmark = new Bookmark();
				
				bookmark.setMember(member);
				Class cls = new Class();
				cls.setClNo(rset.getInt("CL_NO"));
				cls.setClTitle(rset.getString("CL_TITLE"));
				cls.setClThumbnailPath(rset.getString("cl_thumbnailpath"));
				
				bookmark.setCls(cls);
				
				Member mentor = new Member();
				mentor.setUserName(rset.getString("user_name"));
				mentor.setMtCompany(rset.getString("mt_company"));
				
				bookmark.setMember(mentor);
				
				list.add(bookmark);
				
			}
		} catch (SQLException e) {
			
			e.printStackTrace();
		}finally {
			close(rset);
			close(pstmt);
		}
		
		return list;
	}
	public List<Bookmark> selectWishAllList(Connection conn, Member member) {
		PreparedStatement pstmt = null;
		ResultSet rset = null;
		List<Bookmark> list = new ArrayList<Bookmark>();
		String sql = prop.getProperty("selectWishAllList");
		
		try {
			pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1, member.getUserNo());
			rset = pstmt.executeQuery();
			
			while(rset.next()) {
				
				Bookmark bookmark = new Bookmark();
				
				bookmark.setMember(member);
				Class cls = new Class();
				cls.setClNo(rset.getInt("CL_NO"));
				cls.setClTitle(rset.getString("CL_TITLE"));
				cls.setClThumbnailPath(rset.getString("cl_thumbnailpath"));
				
				bookmark.setCls(cls);
				
				Member mentor = new Member();
				mentor.setUserName(rset.getString("user_name"));
				mentor.setMtCompany(rset.getString("mt_company"));
				
				bookmark.setMember(mentor);
				
				list.add(bookmark);
				
			}
		} catch (SQLException e) {
			
			e.printStackTrace();
		}finally {
			close(rset);
			close(pstmt);
		}
		
		return list;
	}
//	public ArrayList<ClassIng> selectClassIng(Connection conn, Member member) {
//		
//		PreparedStatement pstmt = null;
//		ResultSet rset = null;
//		ArrayList<ClassIng> list = new ArrayList<>();
//		String sql = prop.getProperty("selectClassIng");
//		
//		try {
//			pstmt = conn.prepareStatement(sql);
//			pstmt.setInt(1, member.getUserNo());
//			rset = pstmt.executeQuery();
//			
//			while(rset.next()) {
//						
//			list.add(new ClassIng(rset.))
//				
//				bookmark.setMember(member);
//				Class cls = new Class();
//				cls.setClNo(rset.getInt("CL_NO"));
//				cls.setClTitle(rset.getString("CL_TITLE"));
//				cls.setClThumbnailPath(rset.getString("cl_thumbnailpath"));
//				
//				bookmark.setCls(cls);
//				
////				Member clMember = new Member();
////				clMember.setUserNo(rset.getInt("cl_user_no"));
////				clMember.setUserId(rset.getString("cl_user_id"));
////				clMember.setUserName(rset.getString("cl_user_name"));
//				
//				
//				bookmark.setClLikeDate(rset.getDate("CL_LIKEDATE"));
//				
//				
//			}
//		} catch (SQLException e) {
//			
//			e.printStackTrace();
//		}finally {
//			close(rset);
//			close(pstmt);
//		}
//		
//		return list;
//
//}
	
	//데이터 4개만 로드함
	public List<ClassIng> selectClassingList(Connection conn, Member member) {
		PreparedStatement pstmt = null;
		ResultSet rset = null;
		List<ClassIng> list = new ArrayList<ClassIng>();
		String sql = prop.getProperty("selectClassingList");
		
		try {
			pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1, member.getUserNo());
			rset = pstmt.executeQuery();
			
			while(rset.next()) {
						
				ClassIng cing = new ClassIng();
				Class cls = new Class();
				cls.setClNo(rset.getInt("cl_no"));
				cls.setClTitle(rset.getString("cl_title"));
				cls.setClThumbnailPath(rset.getString("cl_thumbnailpath"));
				cing.setCls(cls);
				Member mentor = new Member();
				mentor.setUserName(rset.getString("user_name"));
				mentor.setMtCompany(rset.getString("mt_company"));
				cing.setMember(mentor);
				
				
				list.add(cing);
				
			}
		} catch (SQLException e) {
			
			e.printStackTrace();
		}finally {
			close(rset);
			close(pstmt);
		}
		
		return list;
	}
	public List<ClassIng> selectClassIngAllList(Connection conn, Member member) {
		PreparedStatement pstmt = null;
		ResultSet rset = null;
		List<ClassIng> list = new ArrayList<ClassIng>();
		String sql = prop.getProperty("selectClassIngAllList");
		
		try {
			pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1, member.getUserNo());
			rset = pstmt.executeQuery();
			
			while(rset.next()) {
						
				ClassIng cing = new ClassIng();
				Class cls = new Class();
				cls.setClNo(rset.getInt("cl_no"));
				cls.setClTitle(rset.getString("cl_title"));
				cls.setClThumbnailPath(rset.getString("cl_thumbnailpath"));
				cing.setCls(cls);
				Member mentor = new Member();
				mentor.setUserName(rset.getString("user_name"));
				mentor.setMtCompany(rset.getString("mt_company"));
				cing.setMember(mentor);
				
				
				list.add(cing);
				
			}
		} catch (SQLException e) {
			
			e.printStackTrace();
		}finally {
			close(rset);
			close(pstmt);
		}
		
		return list;
	}
	public List<Vod> selectVodListByClNo(Connection conn, int clNo) {
		PreparedStatement pstmt = null;
		ResultSet rset = null;
		List<Vod> list = new ArrayList<Vod>();
		String sql = prop.getProperty("selectVodListByClNo");
		
		try {
			pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1, clNo);
			rset = pstmt.executeQuery();
			
			while(rset.next()) {
						
				Vod vod = new Vod();
				vod.setVodNo(rset.getInt("vod_no"));
				vod.setVodTitle(rset.getString("VOD_TITLE"));
				
				Class cls = new Class();
				cls.setClNo(clNo);
				cls.setClTitle(rset.getString("cl_title"));
				cls.setClSubtitle(rset.getString("cl_subtitle"));
				vod.setCls(cls);

				list.add(vod);
				
			}
		} catch (SQLException e) {
			
			e.printStackTrace();
		}finally {
			close(rset);
			close(pstmt);
		}
		
		return list;
	}
	public Vod selectOneVod(Connection conn, int vodNo) {
		PreparedStatement pstmt = null;
		ResultSet rset = null;
		Vod vod = new Vod();
		String sql = prop.getProperty("selectOneVod");
		
		try {
			pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1, vodNo);
			rset = pstmt.executeQuery();
			
			while(rset.next()) {
				vod.setVodNo(vodNo);
				Class cls = new Class();
				cls.setClTitle(rset.getString("cl_title"));
				vod.setCls(cls);
				vod.setVodTitle(rset.getString("VOD_TITLE"));
				vod.setVodFile(rset.getString("VOD_FILE"));
				
			}
		} catch (SQLException e) {
			
			e.printStackTrace();
		}finally {
			close(rset);
			close(pstmt);
		}
		
		return vod;
	}
}
