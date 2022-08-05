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
	public List<Bookmark> selectAllWishList(Connection conn, Member member) {
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
				
//				Member clMember = new Member();
//				clMember.setUserNo(rset.getInt("cl_user_no"));
//				clMember.setUserId(rset.getString("cl_user_id"));
//				clMember.setUserName(rset.getString("cl_user_name"));
				
				
				bookmark.setClLikeDate(rset.getDate("CL_LIKEDATE"));
				
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
//	
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
}
