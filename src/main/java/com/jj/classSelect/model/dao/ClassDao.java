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
import com.jj.coupon.vo.IssuanceCoupon;

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
		
//		System.out.println(list);
		
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
//		System.out.println(list);
		return list;
	}
	
	public Class selectClass(Connection conn, int clNo) {
		Class c = new Class();
		PreparedStatement pstmt = null;
		ResultSet rset = null;
		String sql = prop.getProperty("selectClass");
		
		try {
			pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1, clNo);
			rset = pstmt.executeQuery();
			
			if(rset.next()) {
//				c = new Class(rset.getInt("cl_no"),
//				  rset.getString("user_name"),
//				  rset.getString("cl_category"),
//				  rset.getString("cl_title"),
//				  rset.getString("cl_subtitle"),
//				  rset.getString("cl_info"),
//				  rset.getString("cl_curri"),
//				  rset.getString("cl_price"),
//				  rset.getString("cl_thumbnailpath"),
//				  rset.getString("ltr_info"),
//				  rset.getString("ltr_career"),
//				  rset.getString("profile_path")
//				 );
				
				// 500 에러 수정 가능?
				
				c.setClNo(rset.getInt("cl_no"));
				c.setUserNo(rset.getString("user_name"));
				c.setClCategory(rset.getString("cl_category"));
				c.setClTitle(rset.getString("cl_title"));
				c.setClSubtitle(rset.getString("cl_subtitle"));
				c.setClInfo(rset.getString("cl_info"));
				c.setClCurri(rset.getString("cl_curri"));
				c.setClPriceWon(rset.getString("cl_price"));
				c.setClThumbnailPath(rset.getString("cl_thumbnailpath"));
				c.setLtrInfo(rset.getString("ltr_info"));
				c.setLtrCareer(rset.getString("ltr_career"));
				c.setLtrProfilePath(rset.getString("profile_path"));

			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			close(rset);
			close(pstmt);
		}
		System.out.println(c);
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
//		System.out.println(list);
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
//		System.out.println(list);
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
//		System.out.println(list);
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
//		System.out.println(list);
		return list;
	}
	
	public ArrayList<Class> selectClassList(Connection conn, String keyword) {
		ArrayList<Class> list = new ArrayList<>();
		PreparedStatement pstmt = null;
		ResultSet rset = null;
		String sql = prop.getProperty("selectClassList");
		
		try {
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, "%" + keyword + "%");
			pstmt.setString(2, "%" + keyword + "%");
			pstmt.setString(3, "%" + keyword + "%");
			rset = pstmt.executeQuery();
			
			while(rset.next()) {
				list.add(new Class(rset.getInt("cl_no")
						         , rset.getString("cl_title")
						         , rset.getString("cl_subtitle")
				                 , rset.getString("user_name")
				                 , rset.getString("clcg_name")
				                 , rset.getString("cl_thumbnailpath")));
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			close(rset);
			close(pstmt);
		}
		return list;
	}

	public Class selectClassEnroll(Connection conn, int clNo){
		Class c = null;
		PreparedStatement pstmt = null;
		ResultSet rset = null;
		String sql = prop.getProperty("selectClassEnroll");
		
		try {
			pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1, clNo);
			
			rset = pstmt.executeQuery();
			
			if(rset.next()) {
				c = new Class(rset.getInt("cl_no"),
						      rset.getString("cl_title"),
						      rset.getString("user_name"),
						      rset.getInt("cl_price"),
						      rset.getString("cl_price_won"),
						      rset.getString("cl_thumbnailpath"),
						      rset.getDate("cl_enrolldate"));
			}
			
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			close(rset);
			close(pstmt);
		}
		
		return c;
		
	}
	
	public ArrayList<IssuanceCoupon> selectCouponList(Connection conn, int userNo) {
		ArrayList<IssuanceCoupon> list = new ArrayList<>();
		PreparedStatement pstmt = null;
		ResultSet rset = null;
		String sql = prop.getProperty("selectCouponList");
		
		System.out.println(userNo);
		
		try {
			pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1, userNo);
					
			rset = pstmt.executeQuery();
			
			while(rset.next()) {
				list.add(new IssuanceCoupon(rset.getInt("isucp_no"),
											rset.getString("cp_name"),
											rset.getString("cp_no"),
											rset.getDate("cp_enddate"),
											rset.getString("discount"),
											rset.getString("discount_won")
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
	
	public int classEnrollCheck(Connection conn, int userNo, int clNo) {
		int listCount = 0;
		PreparedStatement pstmt = null;
		ResultSet rset = null;
		String sql = prop.getProperty("classEnrollCheck");
		
		try {
			pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1, userNo);
			pstmt.setInt(2, clNo);
			
			rset = pstmt.executeQuery();
			
			if(rset.next()) {
				listCount = rset.getInt("LISTCOUNT");
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			close(rset);
			close(pstmt);
		}
		
		return listCount;
		
	}
	
	public int insertPayWithCoupon(Connection conn, int userNo, int clNo, String isuCpNo, String payment, int finalPayment, String orderName, String orderPhone, String orderEmail) {
		int payResult = 0;
		PreparedStatement pstmt = null;
		String sql = prop.getProperty("insertPayWithCoupon");
		
		try {
			pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1, userNo);
			pstmt.setInt(2, clNo);
			pstmt.setString(3, isuCpNo);
			pstmt.setString(4, payment);
			pstmt.setInt(5, finalPayment);
			pstmt.setString(6,  orderName);
			pstmt.setString(7, orderPhone);
			pstmt.setString(8, orderEmail);
			
			payResult = pstmt.executeUpdate();			
			
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			close(pstmt);
		}
		
		return payResult;
	}
	
	public int updateIssuanceCoupon(Connection conn, String isuCpNo, int userNo) {
		int couponResult = 0;
		PreparedStatement pstmt = null;
		String sql = prop.getProperty("updateIssuanceCoupon");
		
		try {
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, isuCpNo);
//			pstmt.setInt(2, userNo);
//			pstmt.setInt(3, clNo);
			
			couponResult = pstmt.executeUpdate();
			
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			close(pstmt);
		}

		return couponResult;
		
	}
	
	public int insertClassIng(Connection conn, int userNo, int clNo) {
		int ingResult = 0;
		PreparedStatement pstmt = null;
		String sql = prop.getProperty("insertClassIng");
		
		try {
			pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1, userNo);
			pstmt.setInt(2, clNo);
			
			ingResult = pstmt.executeUpdate();
			
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			close(pstmt);
		}
		return ingResult;
	}
	
	public int insertPayNoCoupon(Connection conn, int userNo, int clNo, String payment, int finalPayment, String orderName, String orderPhone, String orderEmail) {
		int payResult = 0;
		PreparedStatement pstmt = null;
		String sql = prop.getProperty("insertPayNoCoupon");
		
		try {
			pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1, userNo);
			pstmt.setInt(2, clNo);
			pstmt.setString(3, payment);
			pstmt.setInt(4, finalPayment);
			pstmt.setString(5, orderName);
			pstmt.setString(6, orderPhone);
			pstmt.setString(7, orderEmail);
			
			payResult = pstmt.executeUpdate();
			
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			close(pstmt);
		}
		
		return payResult;
		
	}
	
	public int selectBookmark(Connection conn, int clNo, int userNo) {
		int likeCheck = 0;
		PreparedStatement pstmt = null;
		ResultSet rset = null;
		String sql = prop.getProperty("selectBookmark");
		
		try {
			pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1, clNo);
			pstmt.setInt(2, userNo);
			
			rset = pstmt.executeQuery();
			
			if(rset.next()) {
				likeCheck = rset.getInt("count");
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			close(rset);
			close(pstmt);
		}
		return likeCheck;
		
	}
	
	public int insertBookmark(Connection conn, int clNo, int userNo) {
		int result = 0;
		PreparedStatement pstmt = null;
		String sql = prop.getProperty("insertBookmark");
		
		try {
			pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1, userNo);
			pstmt.setInt(2, clNo);
			
			result = pstmt.executeUpdate();
			
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			close(pstmt);
		}
		
		return result;
		
	}
	
	public int deleteBookmark(Connection conn, int clNo, int userNo) {
		int result = 0;
		PreparedStatement pstmt = null;
		String sql = prop.getProperty("deleteBookmark");
		
		try {
			pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1, userNo);
			pstmt.setInt(2, clNo);
			
			result = pstmt.executeUpdate();
			
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			close(pstmt);
		}
		
		return result;
	}
	
	public ArrayList<Review> selectReviewByDate(Connection conn, int clNo) {
		ArrayList<Review> sortedList = new ArrayList<>();
		PreparedStatement pstmt = null;
		ResultSet rset = null;
		String sql = prop.getProperty("selectReviewDate");
		
		try {
			pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1, clNo);
			rset = pstmt.executeQuery();
			
			while(rset.next()) {
				sortedList.add(new Review(rset.getInt("review_no"),
								 		  rset.getString("cl_no"),
								 		  rset.getString("user_name"),
								 		  rset.getInt("review_score"),
								 		  rset.getString("review_content"),
								 		  rset.getString("review_createdate")
										 ));	
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			close(rset);
			close(pstmt);
		}
		
		return sortedList;
	}
	
	public ArrayList<Review> selectReviewByScoreDesc(Connection conn, int clNo){
		ArrayList<Review> sortedList = new ArrayList<>();
		PreparedStatement pstmt = null;
		ResultSet rset = null;
		String sql = prop.getProperty("selectReviewByScoreDesc");
		
		try {
			pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1, clNo);
			rset = pstmt.executeQuery();

			while(rset.next()) {
				sortedList.add(new Review(rset.getInt("review_no"),
									  rset.getString("cl_no"),
									  rset.getString("user_name"),
									  rset.getInt("review_score"),
									  rset.getString("review_content"),
									  rset.getString("review_createdate")
						  ));
			}
			
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			close(rset);
			close(pstmt);
		}
		System.out.println("리스트 : " + sortedList);
		return sortedList;
	}
	
	public ArrayList<Review> selectReviewByScoreAsc(Connection conn, int clNo){
		ArrayList<Review> sortedList = new ArrayList<>();
		PreparedStatement pstmt = null;
		ResultSet rset = null;
		String sql = prop.getProperty("selectReviewByScoreAsc");
		
		try {
			pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1, clNo);
			rset = pstmt.executeQuery();
			
			while(rset.next()) {
			sortedList.add(new Review(rset.getInt("review_no"),
									  rset.getString("cl_no"),
									  rset.getString("user_name"),
									  rset.getInt("review_score"),
									  rset.getString("review_content"),
									  rset.getString("review_createdate")
						  ));
			}
			
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			close(rset);
			close(pstmt);
		}
		return sortedList;
	}
	
	public int selectBuyFirst(Connection conn, int userNo) {
		int firstCheck = 0;
		PreparedStatement pstmt = null;
		ResultSet rset = null;
		String sql = prop.getProperty("selectBuyFirst");
		
		try {
			pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1, userNo);
			rset = pstmt.executeQuery();
			
			if(rset.next()) {
				firstCheck = rset.getInt("first_check");
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return firstCheck;
	}
	
	public int insertIssuanceFirstCoupon(Connection conn, int userNo) {
		int issueFirstCpResult = 0;
		PreparedStatement pstmt = null;
		String sql = prop.getProperty("insertIssuanceFirstCoupon");
		
		try {
			pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1, userNo);
			
			issueFirstCpResult = pstmt.executeUpdate();
	
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			close(pstmt);
		}
		
		return issueFirstCpResult;
		
	}
	
	public int selectNoRefund(Connection conn, int userNo) {
		int noRefund = 0;
		PreparedStatement pstmt = null;
		ResultSet rset = null;
		String sql = prop.getProperty("selectNoRefund");
		
		try {
			pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1, userNo);
			rset = pstmt.executeQuery();
			
			if(rset.next()) {
				noRefund = rset.getInt("refund");
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			close(rset);
			close(pstmt);
		}
		return noRefund;
		
		
	}
}














