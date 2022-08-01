package com.jj.admin.model.dao;

import static com.jj.common.JDBCTemplate.close;

import java.io.FileInputStream;
import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Properties;

import com.jj.admin.model.vo.UserInfoAd;
import com.jj.classSelect.model.vo.Class;
import com.jj.common.model.vo.PageInfo;
import com.jj.community.model.vo.Community;
import com.jj.community.model.vo.Reply;
import com.jj.community.model.vo.Review;
import com.jj.faq.model.vo.Faq;
import com.jj.member.model.vo.Member;
import com.jj.member.model.vo.MentorApproval;
import com.jj.mtm.model.vo.Mtm;
import com.jj.notice.model.vo.Notice;

public class AdminDao {
	
	private Properties prop = new Properties();
	
	public AdminDao() {
		String filePath = AdminDao.class.getResource("/db/sql/admin-mapper.xml").getPath();
		
		try {
			prop.loadFromXML(new FileInputStream(filePath));
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	public UserInfoAd loginAdmin(Connection conn,String adminId,String adminPwd) {
		UserInfoAd u = null;
		PreparedStatement pstmt = null;
		ResultSet rset = null;
		String sql = prop.getProperty("loginAdmin");
		
		try {
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, adminId);
			pstmt.setString(2, adminPwd);
			rset = pstmt.executeQuery();
			
			if(rset.next()) {
				u = new UserInfoAd();
				u.setUserNo(rset.getInt("user_no"));
				u.setUserId(rset.getString("user_id"));
				u.setUserPwd(rset.getString("user_pwd"));
				u.setUserName(rset.getString("user_name"));
				u.setAdminStatus(rset.getString("admin_status"));
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			close(rset);
			close(pstmt);
		}
		return u;
	}
	
	public int insertFaq(Connection conn, String faqTitle, String faqContent, int userId) {
		int result = 0;
		
		PreparedStatement pstmt = null;
		
		String sql = prop.getProperty("insertFaq");
		
		try {
			pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1, userId);
			pstmt.setString(2, faqTitle);
			pstmt.setString(3, faqContent);
			
			result = pstmt.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		}finally {
			close(pstmt);
		}
		
		return result;
	}
	
	public int selectFaqCount(Connection conn) {
		int listCount = 0;
		
		PreparedStatement pstmt = null;
		ResultSet rset = null;
		
		String sql = prop.getProperty("selectFaqCount");
		
		try {
			pstmt = conn.prepareStatement(sql);
			
			rset = pstmt.executeQuery();
			
			if(rset.next()) {
				listCount = rset.getInt("LIST_COUNT");
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}finally {
			close(rset);
			close(pstmt);
		}
		
		return listCount;
	}
	
	public ArrayList<Faq> selectFaqList(Connection conn, PageInfo pageInfo){
		ArrayList<Faq> list = new ArrayList<>();
		
		PreparedStatement pstmt = null;
		ResultSet rset = null;
		
		String sql = prop.getProperty("selectFaqList");
		
		try {
			pstmt = conn.prepareStatement(sql);
			
			int startRow = (pageInfo.getCurrentPage() - 1) * pageInfo.getBoardLimit() + 1;
			int endRow = startRow + pageInfo.getBoardLimit() - 1;
			
			pstmt.setInt(1, startRow);
			pstmt.setInt(2, endRow);
			
			rset = pstmt.executeQuery();
			
			while(rset.next()) {
				list.add(new Faq(rset.getInt("faq_no")
						       , rset.getString("user_no")
						       , rset.getString("faq_title")
						       , rset.getString("faq_answer")
						       , rset.getDate("faq_enrolldate")
						       , rset.getInt("faq_count")));
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}finally {
			close(rset);
			close(pstmt);
		}
		
		return list;
	}
	
	public int deleteFaq(Connection conn, int faqNo) {
		int result = 0;
		
		PreparedStatement pstmt = null;
		
		String sql = prop.getProperty("deleteFaq");
		
		try {
			pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1, faqNo);
			
			result = pstmt.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		}finally {
			close(pstmt);
		}
		
		return result;
	}
	
	public Faq selectFaq(Connection conn, int faqNo) {
		Faq faq = null;
		
		PreparedStatement pstmt = null;
		ResultSet rset = null;
		
		String sql = prop.getProperty("selectFaq");
		
		try {
			pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1, faqNo);
			
			rset = pstmt.executeQuery();
			
			if(rset.next()) {
				faq = new Faq(rset.getInt("faq_no")
						    , rset.getString("user_no")
						    , rset.getString("faq_title")
						    , rset.getString("faq_answer")
						    , rset.getDate("faq_enrolldate")
						    , rset.getInt("faq_count"));
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}finally {
			close(rset);
			close(pstmt);
		}
		
		return faq;
	}
	
	public int updateFaq(Connection conn, Faq faq) {
		int result = 0;
		
		PreparedStatement pstmt = null;
		
		String sql = prop.getProperty("updateFaq");
		
		try {
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, faq.getFaqTitle());
			pstmt.setString(2, faq.getFaqAnswer());
			pstmt.setInt(3, faq.getFaqNo());
			
			result = pstmt.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		}finally {
			close(pstmt);
		}
		
		return result;
	}
	
	public int selectNoticeCount(Connection conn) {
		int listCount = 0;
		
		PreparedStatement pstmt = null;
		ResultSet rset = null;
		
		String sql = prop.getProperty("selectNoticeCount");
		
		try {
			pstmt = conn.prepareStatement(sql);
			
			rset = pstmt.executeQuery();
			
			if(rset.next()) {
				listCount = rset.getInt("count");
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}finally {
			close(rset);
			close(pstmt);
		}
		
		return listCount;
	}
	
	/**
	 * @param conn
	 * @return
	 */
	public int selectStudentListCount(Connection conn) {
		int listCount = 0;
		PreparedStatement pstmt = null;
		ResultSet rset = null;
		String sql = prop.getProperty("selectStudentListCount");
		
		try {
			pstmt = conn.prepareStatement(sql);
			
			rset = pstmt.executeQuery();
			
			if(rset.next()) {
				listCount = rset.getInt("LISTCOUNT");
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}finally {
			close(rset);
			close(pstmt);
		}
		
		return listCount;
	}
	
	public int stuListCountSearch(Connection conn,String search) {
		int listCount = 0;
		PreparedStatement pstmt = null;
		ResultSet rset = null;
		String sql = prop.getProperty("stuListCountSearch");
		String a = '%'+search+'%';
		
		try {
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, a);
			pstmt.setString(2, a);
			rset = pstmt.executeQuery();
			
			if(rset.next()) {
				listCount = rset.getInt("LISTCOUNT");
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}finally {
			close(rset);
			close(pstmt);
		}
		
		return listCount;
	}
	
	public int stuInfoOutCount(Connection conn,String search) {
		int listCount = 0;
		PreparedStatement pstmt = null;
		ResultSet rset = null;
		String sql = prop.getProperty("stuInfoOutCount");
		String a = '%'+search+'%';
		
		try {
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, a);
			pstmt.setString(2, a);
			rset = pstmt.executeQuery();
			
			if(rset.next()) {
				listCount = rset.getInt("LISTCOUNT");
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}finally {
			close(rset);
			close(pstmt);
		}
		
		return listCount;
	}
	
	public ArrayList<Member> studentInfo(Connection conn,PageInfo pi){
		ArrayList<Member> list = new ArrayList<>();
		PreparedStatement pstmt = null;
		ResultSet rset = null;
		String sql = prop.getProperty("studentInfo");
		
		try {
			pstmt = conn.prepareStatement(sql);
			int startRow = (pi.getCurrentPage()-1)*pi.getBoardLimit()+1;
			int endRow = startRow + pi.getBoardLimit()-1;
			
			pstmt.setInt(1,startRow);
			pstmt.setInt(2,endRow);
			rset = pstmt.executeQuery();
			
			while(rset.next()) {
				list.add(new Member(rset.getInt("user_no"),
									rset.getString("user_id"),
									rset.getString("user_pwd"),
									rset.getString("user_name"),
									rset.getString("user_email"),
									rset.getString("user_phone"),
									rset.getDate("user_enrolldate"),
									rset.getString("user_status"),
									rset.getString("admin_status"),
									rset.getInt("user_division")));
			}
			
			
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			close(rset);
			close(pstmt);
		}
		return list;
	}
	
	public ArrayList<Member> stuInfoAll(Connection conn,PageInfo pi,String search){
		ArrayList<Member> list = new ArrayList<>();
		PreparedStatement pstmt = null;
		ResultSet rset = null;
		String sql = prop.getProperty("stuInfoAll");
		String a = '%'+search+'%';
		
		try {
			pstmt = conn.prepareStatement(sql);
			int startRow = (pi.getCurrentPage()-1)*pi.getBoardLimit()+1;
			int endRow = startRow + pi.getBoardLimit()-1;
			
			pstmt.setString(1, a);
			pstmt.setString(2, a);
			pstmt.setInt(3,startRow);
			pstmt.setInt(4,endRow);
			rset = pstmt.executeQuery();
			
			while(rset.next()) {
				list.add(new Member(rset.getInt("user_no"),
									rset.getString("user_id"),
									rset.getString("user_pwd"),
									rset.getString("user_name"),
									rset.getString("user_email"),
									rset.getString("user_phone"),
									rset.getDate("user_enrolldate"),
									rset.getString("user_status"),
									rset.getString("admin_status"),
									rset.getInt("user_division")));
			}
			
			
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			close(rset);
			close(pstmt);
		}
		return list;
	}
	
	public ArrayList<Member> stuInfoOutSearch(Connection conn,PageInfo pi,String search){
		ArrayList<Member> list = new ArrayList<>();
		PreparedStatement pstmt = null;
		ResultSet rset = null;
		String sql = prop.getProperty("stuInfoOutSearch");
		String a = '%'+search+'%';
		
		try {
			pstmt = conn.prepareStatement(sql);
			int startRow = (pi.getCurrentPage()-1)*pi.getBoardLimit()+1;
			int endRow = startRow + pi.getBoardLimit()-1;
			
			pstmt.setString(1, a);
			pstmt.setString(2, a);
			pstmt.setInt(3,startRow);
			pstmt.setInt(4,endRow);
			rset = pstmt.executeQuery();
			
			while(rset.next()) {
				list.add(new Member(rset.getInt("user_no"),
									rset.getString("user_id"),
									rset.getString("user_pwd"),
									rset.getString("user_name"),
									rset.getString("user_email"),
									rset.getString("user_phone"),
									rset.getDate("user_enrolldate"),
									rset.getString("user_status"),
									rset.getString("admin_status"),
									rset.getInt("user_division")));
			}
			
			
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			close(rset);
			close(pstmt);
		}
		return list;
	}

	public ArrayList<Notice> selectNoticeList(Connection conn, PageInfo pageInfo){
		ArrayList<Notice> list = new ArrayList<>();
		
		PreparedStatement pstmt = null;
		
		ResultSet rset = null;
		
		String sql = prop.getProperty("selectNoticeList");
		
		try {
			pstmt = conn.prepareStatement(sql);
			
			int startRow = (pageInfo.getCurrentPage() - 1) * pageInfo.getBoardLimit() + 1;
			int endRow = startRow + pageInfo.getBoardLimit() - 1;
			
			pstmt.setInt(1, startRow);
			pstmt.setInt(2, endRow);
			
			rset = pstmt.executeQuery();
			
			while(rset.next()) {
				list.add(new Notice(rset.getInt("notice_no")
							      , rset.getString("user_no")
						          , rset.getString("notice_title")
						          , rset.getString("notice_content")
						          , rset.getDate("notice_enrolldate")
						          , rset.getDate("notice_modifydate")
						          , rset.getInt("notice_count")));
			}
			
		} catch (SQLException e) {
			e.printStackTrace();
		}finally {
			close(rset);
			close(pstmt);
		}
		
		return list;
	}
	
	public Notice selectNotice(Connection conn, int noticeNo) {
		Notice notice = null;
		
		PreparedStatement pstmt = null;
		ResultSet rset = null;
		
		String sql = prop.getProperty("selectNotice");
		
		try {
			pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1, noticeNo);
			
			rset = pstmt.executeQuery();
			
			if(rset.next()) {
				notice = new Notice(rset.getInt("notice_no")
						          , rset.getString("user_no")
						          , rset.getString("notice_title")
						          , rset.getString("notice_content")
						          , rset.getDate("notice_enrolldate")
						          , rset.getDate("notice_modifyDate")
						          , rset.getInt("notice_count"));
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}finally {
			close(rset);
			close(pstmt);
		}
		
		return notice;
	}
	
	public int updateNotice(Connection conn, int noticeNo, String noticeTitle, String noticeContent) {
		int result = 0;
		
		PreparedStatement pstmt = null;
		
		String sql = prop.getProperty("updateNotice");
		
		try {
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, noticeTitle);
			pstmt.setString(2, noticeContent);
			pstmt.setInt(3, noticeNo);
			
			result = pstmt.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		}finally {
			close(pstmt);
		}
		
		return result;
	}
	
	public int deleteNotice(Connection conn, int noticeNo) {
		int result = 0;
		
		PreparedStatement pstmt = null;
		
		String sql = prop.getProperty("deleteNotice");
		
		try {
			pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1, noticeNo);
			
			result = pstmt.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		}finally {
			close(pstmt);
		}
		
		return result;
	}
	
	public int selectReplyCount(Connection conn) {
		int listCount = 0;
		
		PreparedStatement pstmt = null;
		ResultSet rset = null;
		
		String sql = prop.getProperty("selectReplyCount");
		
		try {
			pstmt = conn.prepareStatement(sql);
			
			rset = pstmt.executeQuery();
			
			if(rset.next()) {
				listCount = rset.getInt("count");
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}finally {
			close(rset);
			close(pstmt);
		}
		
		return listCount;
	}
	
	public ArrayList<Reply> selectReplyList(Connection conn, PageInfo pageInfo){
		ArrayList<Reply> list = new ArrayList<>();
		
		PreparedStatement pstmt = null;
		
		ResultSet rset = null;
		
		String sql = prop.getProperty("selectReplyList");
		
		try {
			pstmt = conn.prepareStatement(sql);
			
			int startRow = (pageInfo.getCurrentPage() - 1) * pageInfo.getBoardLimit() + 1;
			int endRow = startRow + pageInfo.getBoardLimit() - 1;
			
			pstmt.setInt(1, startRow);
			pstmt.setInt(2, endRow);
			
			rset = pstmt.executeQuery();
			
			while(rset.next()) {
				list.add(new Reply(rset.getInt("reply_no")
						         , rset.getString("cm_title")
						         , rset.getString("user_name")
						         , rset.getString("reply_content")
						         , rset.getDate("reply_enrolldate")));
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}finally{
			close(rset);
			close(pstmt);
		}
		
		return list;
	}
	
	public int deleteReply(Connection conn, int replyNo) {
		int result = 0;
		
		PreparedStatement pstmt = null;
		
		String sql = prop.getProperty("deleteReply");
		
		try {
			pstmt = conn.prepareStatement(sql);
			
			pstmt.setInt(1, replyNo);
			
			result = pstmt.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		}finally {
			close(pstmt);
		}
		
		return result;
	}
	
	public int selectMtmCount(Connection conn) {
		int listCount = 0;
		
		PreparedStatement pstmt = null;
		ResultSet rset = null;
		
		String sql = prop.getProperty("selectMtmCount");
		
		try {
			pstmt = conn.prepareStatement(sql);
			
			rset = pstmt.executeQuery();
			
			if(rset.next()) {
				listCount = rset.getInt("count");
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}finally {
			close(rset);
			close(pstmt);
		}
		
		return listCount;
	}
	
	public ArrayList<Mtm> selectMtmList(Connection conn, PageInfo pageInfo){
		ArrayList<Mtm> list = new ArrayList<>();
		
		PreparedStatement pstmt = null;
		ResultSet rset = null;
		
		String sql = prop.getProperty("selectMtmList");
		
		try {
			pstmt = conn.prepareStatement(sql);
			
			int startRow = (pageInfo.getCurrentPage() - 1) * pageInfo.getBoardLimit() + 1;
			int endRow = startRow + pageInfo.getBoardLimit() - 1;
			
			pstmt.setInt(1, startRow);
			pstmt.setInt(2, endRow);
			
			rset = pstmt.executeQuery();
			
			while(rset.next()) {
				list.add(new Mtm(rset.getInt("mtm_no")
						       , rset.getString("user_name")
						       , rset.getString("mtm_title")
						       , rset.getString("mtm_content")
						       , rset.getDate("mtm_enrolldate")
						       , rset.getString("mtm_answer")
						       , rset.getDate("mtm_answer_date")
						       , rset.getString("admin_no")));
			}
			
		} catch (SQLException e) {
			e.printStackTrace();
		}finally {
			close(rset);
			close(pstmt);
		}
		
		return list;
	}
	
	public Mtm selectMtm(Connection conn, int mtmNo) {
		Mtm mtm = new Mtm();
		
		PreparedStatement pstmt = null;
		ResultSet rset = null;
		
		String sql = prop.getProperty("selectMtm");
		
		try {
			pstmt = conn.prepareStatement(sql);
			
			pstmt.setInt(1, mtmNo);
			
			rset = pstmt.executeQuery();
			
			if(rset.next()) {
				mtm = new Mtm(rset.getInt("mtm_no")
						    , rset.getString("user_no")
						    , rset.getString("mtm_title")
						    , rset.getString("mtm_content")
						    , rset.getDate("mtm_enrolldate")
						    , rset.getString("mtm_answer")
						    , rset.getDate("mtm_answer_date")
						    , rset.getString("admin_no"));
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}finally {
			close(rset);
			close(pstmt);
		}
		
		return mtm;
	}
	
	public int updateAnswer(Connection conn, int mtmNo, String mtmAnswer) {
		int result = 0;
		
		PreparedStatement pstmt = null;
		
		String sql = prop.getProperty("updateAnswer");
		
		try {
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, mtmAnswer);
			pstmt.setInt(2, mtmNo);
			
			result = pstmt.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		}finally {
			close(pstmt);
		}
		
		return result;
	}
	
	public Mtm selectUserEmail(Connection conn, int mtmNo) {
		Mtm userEmail = new Mtm();
		
		PreparedStatement pstmt = null;
		ResultSet rset = null;
		
		String sql = prop.getProperty("selectUserEmail");
		
		try {
			pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1, mtmNo);
			
			rset = pstmt.executeQuery();
			
			if(rset.next()) {
				userEmail = new Mtm(rset.getInt("mtm_no")
					    , rset.getString("user_email")
					    , rset.getString("mtm_title")
					    , rset.getString("mtm_content")
					    , rset.getDate("mtm_enrolldate")
					    , rset.getString("mtm_answer")
					    , rset.getDate("mtm_answer_date")
					    , rset.getString("admin_no"));
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}finally {
			close(rset);
			close(pstmt);
		}
		
		return userEmail;
	}
	
	public int selectClassCount(Connection conn) {
		int listCount = 0;
		
		PreparedStatement pstmt = null;
		ResultSet rset = null;
		
		String sql = prop.getProperty("selectClassCount");
		
		try {
			pstmt = conn.prepareStatement(sql);
			
			rset = pstmt.executeQuery();
			
			if(rset.next()) {
				listCount = rset.getInt("count");
			}
			
		} catch (SQLException e) {
			e.printStackTrace();
		}finally {
			close(rset);
			close(pstmt);
		}
		
		return listCount;
	}
	
	public ArrayList<Class> selectClassList(Connection conn, PageInfo pageInfo){
		ArrayList<Class> list = new ArrayList<>();
		
		PreparedStatement pstmt = null;
		ResultSet rset = null;
		
		String sql = prop.getProperty("selectClassList");
		
		try {
			pstmt = conn.prepareStatement(sql);
			
			int startRow = (pageInfo.getCurrentPage() - 1) * pageInfo.getBoardLimit() + 1;
			int endRow = startRow + pageInfo.getBoardLimit() - 1;
			
			pstmt.setInt(1, startRow);
			pstmt.setInt(2, endRow);
			
			rset = pstmt.executeQuery();
			
			while(rset.next()) {
				list.add(new Class(rset.getInt("cl_no")
						         , rset.getString("user_name")
						         , rset.getString("clcg_name")
						         , rset.getString("cl_title")
						         , rset.getString("cl_subtitle")
						         , rset.getString("cl_info")
						         , rset.getString("cl_curri")
						         , rset.getInt("cl_price")
						         , rset.getDate("cl_enrolldate")
						         , rset.getString("cl_grant")
						         , rset.getString("cl_thumbnailpath")));
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}finally {
			close(rset);
			close(pstmt);
		}
		
		return list;
	}
	
	public int deleteClass(Connection conn, int clNo) {
		int result = 0;
		
		PreparedStatement pstmt = null;
		
		String sql = prop.getProperty("deleteClass");
		
		try {
			pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1, clNo);
			
			result = pstmt.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		}finally {
			close(pstmt);
		}
		
		return result;
	}
	
	public int selectReviewCount(Connection conn) {
		int listCount = 0;
		
		PreparedStatement pstmt = null;
		ResultSet rset = null;
		
		String sql = prop.getProperty("selectReviewCount");
		
		try {
			pstmt = conn.prepareStatement(sql);
			
			rset = pstmt.executeQuery();
			
			if(rset.next()) {
				listCount = rset.getInt("count");
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}finally {
			close(rset);
			close(pstmt);
		}
		
		return listCount;
	}
	
	public ArrayList<Review> selectReviewList(Connection conn, PageInfo pageInfo){
		ArrayList<Review> list = new ArrayList<>();
		
		PreparedStatement pstmt = null;
		ResultSet rset = null;
		
		String sql = prop.getProperty("selectReviewList");
		
		try {
			pstmt = conn.prepareStatement(sql);
			
			int startRow = (pageInfo.getCurrentPage() - 1) * pageInfo.getBoardLimit() + 1;
			int endRow = startRow + pageInfo.getBoardLimit() - 1;
			
			pstmt.setInt(1, startRow);
			pstmt.setInt(2, endRow);
			
			rset = pstmt.executeQuery();
			
			while(rset.next()) {
				list.add(new Review(rset.getInt("review_no")
						          , rset.getString("cl_title")
						          , rset.getString("user_name")
						          , rset.getInt("review_score")
						          , rset.getString("review_content")
						          , rset.getDate("review_enrolldate")));
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}finally {
			close(rset);
			close(pstmt);
		}
		
		return list;
	}
	
	public int deleteReview(Connection conn, int reviewNo) {
		int result = 0;
		
		PreparedStatement pstmt = null;
		
		String sql = prop.getProperty("deleteReview");
		
		try {
			pstmt = conn.prepareStatement(sql);
			
			pstmt.setInt(1, reviewNo);
			
			result = pstmt.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		}finally {
			close(pstmt);
		}
		
		return result;
	}
	
	public int selectCommunityWorkCount(Connection conn) {
		int listCount = 0;
		
		PreparedStatement pstmt = null;
		ResultSet rset = null;
		
		String sql = prop.getProperty("selectCommunityWorkCount");
		
		try {
			pstmt = conn.prepareStatement(sql);
			
			rset = pstmt.executeQuery();
			
			if(rset.next()) {
				listCount = rset.getInt("count");
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}finally {
			close(rset);
			close(pstmt);
		}
		
		return listCount;
	}
	
	public int selectCommunityStudyCount(Connection conn) {
		int listCount = 0;
		
		PreparedStatement pstmt = null;
		ResultSet rset = null;
		
		String sql = prop.getProperty("selectCommunityStudyCount");
		
		try {
			pstmt = conn.prepareStatement(sql);
			
			rset = pstmt.executeQuery();
			
			if(rset.next()) {
				listCount = rset.getInt("count");
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}finally {
			close(rset);
			close(pstmt);
		}
		
		return listCount;
	}
	
	public int selectCommunityWorryCount(Connection conn) {
		int listCount = 0;
		
		PreparedStatement pstmt = null;
		ResultSet rset = null;
		
		String sql = prop.getProperty("selectCommunityWorryCount");
		
		try {
			pstmt = conn.prepareStatement(sql);
			
			rset = pstmt.executeQuery();
			
			if(rset.next()) {
				listCount = rset.getInt("count");
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}finally {
			close(rset);
			close(pstmt);
		}
		
		return listCount;
	}
	
	public ArrayList<Community> selectCommunityWorkList(Connection conn, PageInfo pageInfo){
		ArrayList<Community> list = new ArrayList<>();
		
		PreparedStatement pstmt = null;
		ResultSet rset = null;
		
		String sql = prop.getProperty("selectCommunityWorkList");
		
		try {
			pstmt = conn.prepareStatement(sql);
			
			int startRow = (pageInfo.getCurrentPage() - 1) * pageInfo.getBoardLimit() + 1;
			int endRow = startRow + pageInfo.getBoardLimit() - 1;
			
			pstmt.setInt(1, startRow);
			pstmt.setInt(2, endRow);
			
			rset = pstmt.executeQuery();
			
			while(rset.next()) {
				list.add(new Community(rset.getInt("cm_no")
									 , rset.getString("user_name")
									 , rset.getString("cmcg_name")
									 , rset.getString("cm_title")
									 , rset.getString("cm_content")
									 , rset.getDate("cm_enrolldate")
									 , rset.getInt("cm_count")
									 , rset.getInt("cm_like_count")));
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}finally {
			close(rset);
			close(pstmt);
		}
		
		return list;
	}
	
	public ArrayList<Community> selectCommunityStudyList(Connection conn, PageInfo pageInfo){
		ArrayList<Community> list = new ArrayList<>();
		
		PreparedStatement pstmt = null;
		ResultSet rset = null;
		
		String sql = prop.getProperty("selectCommunityStudyList");
		
		try {
			pstmt = conn.prepareStatement(sql);
			
			int startRow = (pageInfo.getCurrentPage() - 1) * pageInfo.getBoardLimit() + 1;
			int endRow = startRow + pageInfo.getBoardLimit() - 1;
			
			pstmt.setInt(1, startRow);
			pstmt.setInt(2, endRow);
			
			rset = pstmt.executeQuery();
			
			while(rset.next()) {
				list.add(new Community(rset.getInt("cm_no")
									 , rset.getString("user_name")
									 , rset.getString("cmcg_name")
									 , rset.getString("cm_title")
									 , rset.getString("cm_content")
									 , rset.getDate("cm_enrolldate")
									 , rset.getInt("cm_count")
									 , rset.getInt("cm_like_count")));
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}finally {
			close(rset);
			close(pstmt);
		}
		
		return list;
	}
	
	public ArrayList<Community> selectCommunityWorryList(Connection conn, PageInfo pageInfo){
		ArrayList<Community> list = new ArrayList<>();
		
		PreparedStatement pstmt = null;
		ResultSet rset = null;
		
		String sql = prop.getProperty("selectCommunityWorryList");
		
		try {
			pstmt = conn.prepareStatement(sql);
			
			int startRow = (pageInfo.getCurrentPage() - 1) * pageInfo.getBoardLimit() + 1;
			int endRow = startRow + pageInfo.getBoardLimit() - 1;
			
			pstmt.setInt(1, startRow);
			pstmt.setInt(2, endRow);
			
			rset = pstmt.executeQuery();
			
			while(rset.next()) {
				list.add(new Community(rset.getInt("cm_no")
									 , rset.getString("user_name")
									 , rset.getString("cmcg_name")
									 , rset.getString("cm_title")
									 , rset.getString("cm_content")
									 , rset.getDate("cm_enrolldate")
									 , rset.getInt("cm_count")
									 , rset.getInt("cm_like_count")));
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}finally {
			close(rset);
			close(pstmt);
		}
		
		return list;
	}
	
	public int deletePost(Connection conn, int postNo, int postCategory) {
		int result = 0;
		
		PreparedStatement pstmt = null;
		
		String sql = prop.getProperty("deletePost");
		
		try {
			pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1, postNo);
			pstmt.setInt(2, postCategory);
			
			result = pstmt.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		}finally {
			close(pstmt);
		}
		
		return result;
	}
	
	public int selectMentorCount(Connection conn) {
		int listCount = 0;
		
		PreparedStatement pstmt = null;
		ResultSet rset = null;
		
		String sql = prop.getProperty("selectMentorCount");
		
		try {
			pstmt = conn.prepareStatement(sql);
			
			rset = pstmt.executeQuery();
			
			if(rset.next()) {
				listCount = rset.getInt("count");
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}finally {
			close(rset);
			close(pstmt);
		}
		
		return listCount;
	}
	
	public ArrayList<MentorApproval> selectMentorList(Connection conn, PageInfo pageInfo){
		ArrayList<MentorApproval> list = new ArrayList<>();
		
		PreparedStatement pstmt = null;
		ResultSet rset = null;
		
		String sql = prop.getProperty("selectMentorList");
		
		try {
			pstmt = conn.prepareStatement(sql);
			
			int startRow = (pageInfo.getCurrentPage() - 1) * pageInfo.getBoardLimit() + 1;
			int endRow = startRow + pageInfo.getBoardLimit() - 1;
			
			pstmt.setInt(1, startRow);
			pstmt.setInt(2,  endRow);
			
			rset = pstmt.executeQuery();
			
			while(rset.next()) {
				list.add(new MentorApproval(rset.getString("user_no")
						          , rset.getString("user_name")
						          , rset.getString("user_email")
						          , rset.getString("user_phone")
						          , rset.getString("mt_company")
						          ,rset.getString("mt_job")));
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}finally {
			close(rset);
			close(pstmt);
		}
		
		return list;
	}
	
	public MentorApproval selectMentor(Connection conn, int mentorNo) {
		MentorApproval mentorApproval = new MentorApproval();
		
		PreparedStatement pstmt = null;
		ResultSet rset = null;
		
		String sql = prop.getProperty("selectMentor");
		
		try {
			pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1, mentorNo);
			
			rset = pstmt.executeQuery();
			
			if(rset.next()) {
				mentorApproval = new MentorApproval(rset.getString("user_no")
						                          , rset.getString("user_name")
						                          , rset.getString("user_phone")
						                          , rset.getString("mt_company")
						                          , rset.getString("mt_job")
						                          , rset.getString("user_email")
						                          , rset.getString("clcg_name")
						                          , rset.getString("empcard_path")
						                          , rset.getString("idcard_path"));
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}finally {
			close(rset);
			close(pstmt);
		}
		
		return mentorApproval;
	}
	
	public int mentorApproval(Connection conn, int mentorNo) {
		int result = 0;
		
		PreparedStatement pstmt = null;
		
		String sql = prop.getProperty("mentorApproval");
		
		try {
			pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1, mentorNo);
			
			result = pstmt.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		}finally {
			close(pstmt);
		}
		
		return result;
	}
	
	public int mentorApprovalFusal(Connection conn, int mentorNo) {
		int result = 0;
		
		PreparedStatement pstmt = null;
		
		String sql = prop.getProperty("mentorApprovalFusal");
		
		try {
			pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1, mentorNo);
			
			result = pstmt.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		}finally {
			close(pstmt);
		}
		
		return result;
	}
	
	public int selectApprovalClassCount(Connection conn) {
		int listCount = 0;
		
		PreparedStatement pstmt = null;
		ResultSet rset = null;
		
		String sql = prop.getProperty("selectApprovalClassCount");
		
		try {
			pstmt = conn.prepareStatement(sql);
			
			rset = pstmt.executeQuery();
			
			if(rset.next()) {
				listCount = rset.getInt("count");
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}finally {
			close(rset);
			close(pstmt);
		}
		
		return listCount;
	}
	
	public ArrayList<Class> selectApprovalClassList(Connection conn, PageInfo pageInfo){
		ArrayList<Class> list = new ArrayList<>();
		
		PreparedStatement pstmt = null;
		ResultSet rset = null;
		
		String sql = prop.getProperty("selectApprovalClassList");
		
		try {
			pstmt = conn.prepareStatement(sql);
			
			int startRow = (pageInfo.getCurrentPage() - 1) * pageInfo.getBoardLimit() + 1;
			int endRow = startRow + pageInfo.getBoardLimit() - 1;
			
			pstmt.setInt(1, startRow);
			pstmt.setInt(2, endRow);
			
			rset = pstmt.executeQuery();
			
			while(rset.next()) {
				list.add(new Class(rset.getInt("cl_no")
						         , rset.getString("user_name")
						         , rset.getString("clcg_name")
						         , rset.getString("cl_title")));
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}finally {
			close(rset);
			close(pstmt);
		}
		
		return list;
	}
	
	public Class selectClassApproval(Connection conn, int classNo) {
		Class classInfo = new Class();
		
		PreparedStatement pstmt = null;
		ResultSet rset = null;
		
		String sql = prop.getProperty("selectClassApproval");
		
		try {
			pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1, classNo);
			
			rset = pstmt.executeQuery();
			
			if(rset.next()) {
				classInfo = new Class(rset.getInt("cl_no")
						            , rset.getString("clcg_name")
						            , rset.getString("cl_title")
						            , rset.getString("cl_info")
						            , rset.getString("cl_curri")
						            , rset.getInt("cl_price")
						            , rset.getString("cl_thumbnailpath"));
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}finally {
			close(rset);
			close(pstmt);
		}
		
		return classInfo;
	}
	
	public int classApproval(Connection conn, int classNo) {
		int result = 0;
		
		PreparedStatement pstmt = null;
		
		String sql = prop.getProperty("classApproval");
		
		try {
			pstmt = conn.prepareStatement(sql);
			
			pstmt.setInt(1, classNo);
			
			result = pstmt.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		}finally {
			close(pstmt);
		}
		
		return result;
	}
	
	public int classApprovalFusal(Connection conn, int classNo) {
		int result = 0;
		
		PreparedStatement pstmt = null;
		
		String sql = prop.getProperty("classApproval");
		
		try {
			pstmt = conn.prepareStatement(sql);
			
			pstmt.setInt(1, classNo);
			
			result = pstmt.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		}finally {
			close(pstmt);
		}
		
		return result;
	}
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
}
