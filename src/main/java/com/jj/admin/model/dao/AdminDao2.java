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
import com.jj.classSelect.model.vo.ClassIng;
import com.jj.common.model.vo.PageInfo;
import com.jj.coupon.vo.Coupon;
import com.jj.coupon.vo.IssuanceCoupon;
import com.jj.faq.model.vo.Faq;
import com.jj.member.model.vo.Member;
import com.jj.member.model.vo.Mentor;
import com.jj.notice.model.vo.Notice;
import com.jj.pay.model.vo.Pay;

public class AdminDao2 {
	
	private Properties prop = new Properties();
	
	public AdminDao2() {
		String filePath = AdminDao.class.getResource("/db/sql/admin-mapper2.xml").getPath();
		
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
	
	/**
	 * @param conn
	 * @return
	 */
	public int selectStudentListCount(Connection conn, String search) {
		int listCount = 0;
		PreparedStatement pstmt = null;
		ResultSet rset = null;
		String sql = prop.getProperty("selectStudentListCount");
		String a = '%'+search+'%';
		
		try {
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, search);
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
	
	public int stuListCountSearch(Connection conn,String search) {
		int listCount = 0;
		PreparedStatement pstmt = null;
		ResultSet rset = null;
		String sql = prop.getProperty("stuListCountSearch");
		String a = '%'+search+'%';
		
		try {
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, search);
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
			pstmt.setString(1, search);
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
	
	public int selectMentorListCount(Connection conn,String search) {
		int listCount = 0;
		PreparedStatement pstmt = null;
		ResultSet rset = null;
		String sql = prop.getProperty("selectMentorListCount");
		String a = '%'+search+'%';
		
		try {
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, search);
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
	
	public int currentCount(Connection conn,String search) {
		int listCount = 0;
		PreparedStatement pstmt = null;
		ResultSet rset = null;
		String sql = prop.getProperty("currentCount");
		String a = '%'+search+'%';
		
		try {
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, search);
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
	
	public int lecturerCount(Connection conn,String search) {
		int listCount = 0;
		PreparedStatement pstmt = null;
		ResultSet rset = null;
		String sql = prop.getProperty("lecturerCount");
		String a = '%'+search+'%';
		
		try {
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, search);
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
	
	public int outMentorCount(Connection conn,String search) {
		int listCount = 0;
		PreparedStatement pstmt = null;
		ResultSet rset = null;
		String sql = prop.getProperty("outMentorCount");
		String a = '%'+search+'%';
		
		try {
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, search);
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
	
	public int selectAllUserCount(Connection conn,String search) {
		int listCount = 0;
		PreparedStatement pstmt = null;
		ResultSet rset = null;
		String sql = prop.getProperty("selectAllUserCount");
		String a = '%'+search+'%';
		
		try {
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, search);
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
	
	public int outAllUserCount(Connection conn,String search) {
		int listCount = 0;
		PreparedStatement pstmt = null;
		ResultSet rset = null;
		String sql = prop.getProperty("outAllUserCount");
		String a = '%'+search+'%';
		
		try {
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, search);
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
	
	public int selectPayDetailCount(Connection conn,int no) {
		int listCount = 0;
		PreparedStatement pstmt = null;
		ResultSet rset = null;
		String sql = prop.getProperty("selectPayDetailCount");
		
		try {
			pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1, no);
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
	
	public int paymentBuyListCount(Connection conn,String search) {
		int listCount = 0;
		PreparedStatement pstmt = null;
		ResultSet rset = null;
		String sql = prop.getProperty("paymentBuyListCount");
		String a = '%'+search+'%';
		
		try {
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, search);
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
	
	public int paymentRefundListCount(Connection conn,String search) {
		int listCount = 0;
		PreparedStatement pstmt = null;
		ResultSet rset = null;
		String sql = prop.getProperty("paymentRefundListCount");
		String a = '%'+search+'%';
		
		try {
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, search);
			pstmt.setString(2, search);
			pstmt.setString(3, a);
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
	
	public int paymentRefundFinishCount(Connection conn,String search) {
		int listCount = 0;
		PreparedStatement pstmt = null;
		ResultSet rset = null;
		String sql = prop.getProperty("paymentRefundFinishCount");
		String a = '%'+search+'%';
		
		try {
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, search);
			pstmt.setString(2, search);
			pstmt.setString(3, a);
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
	
	public int paymentRefundDenyCount(Connection conn,String search) {
		int listCount = 0;
		PreparedStatement pstmt = null;
		ResultSet rset = null;
		String sql = prop.getProperty("paymentRefundDenyCount");
		String a = '%'+search+'%';
		
		try {
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, search);
			pstmt.setString(2, search);
			pstmt.setString(3, a);
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
	
	public int couponListCount(Connection conn) {
		int listCount = 0;
		PreparedStatement pstmt = null;
		ResultSet rset = null;
		String sql = prop.getProperty("couponListCount");
		
		
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
	
	public int couponListCountA(Connection conn) {
		int listCount = 0;
		PreparedStatement pstmt = null;
		ResultSet rset = null;
		String sql = prop.getProperty("couponListCountA");
		
		
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
	
	public int MemberCouponBeforCount(Connection conn,String search) {
		int listCount = 0;
		PreparedStatement pstmt = null;
		ResultSet rset = null;
		String sql = prop.getProperty("MemberCouponBeforCount");
		String a = '%'+search+'%';
		
		try {
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, search);
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
	
	public int MemberCouponAfterCount(Connection conn,String search) {
		int listCount = 0;
		PreparedStatement pstmt = null;
		ResultSet rset = null;
		String sql = prop.getProperty("MemberCouponAfterCount");
		String a = '%'+search+'%';
		
		try {
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, search);
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
	
	public int refundRequestCount(Connection conn,String search) {
		int listCount = 0;
		PreparedStatement pstmt = null;
		ResultSet rset = null;
		String sql = prop.getProperty("refundRequestCount");
		String a = '%'+search+'%';
		
		try {
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, search);
			pstmt.setString(2, search);
			pstmt.setString(3, a);
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
	
	
	
	public ArrayList<Member> studentInfo(Connection conn,PageInfo pi,String search){
		ArrayList<Member> list = new ArrayList<>();
		PreparedStatement pstmt = null;
		ResultSet rset = null;
		String sql = prop.getProperty("studentInfo");
		String a = '%'+search+'%';
		
		try {
			pstmt = conn.prepareStatement(sql);
			int startRow = (pi.getCurrentPage()-1)*pi.getBoardLimit()+1;
			int endRow = startRow + pi.getBoardLimit()-1;
			
			pstmt.setString(1, search);
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
			
			pstmt.setString(1, search);
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
			
			pstmt.setString(1, search);
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
	
	public ArrayList<Member> mentorInfo(Connection conn,PageInfo pi,String search){
		ArrayList<Member> list = new ArrayList<>();
		PreparedStatement pstmt = null;
		ResultSet rset = null;
		String sql = prop.getProperty("mentorInfo");
		String a = '%'+search+'%';
		
		try {
			pstmt = conn.prepareStatement(sql);
			int startRow = (pi.getCurrentPage()-1)*pi.getBoardLimit()+1;
			int endRow = startRow + pi.getBoardLimit()-1;
			
			pstmt.setString(1, search);
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

	public ArrayList<Member> currentInfo(Connection conn,PageInfo pi,String search){
		ArrayList<Member> list = new ArrayList<>();
		PreparedStatement pstmt = null;
		ResultSet rset = null;
		String sql = prop.getProperty("currentInfo");
		String a = '%'+search+'%';
		
		try {
			pstmt = conn.prepareStatement(sql);
			int startRow = (pi.getCurrentPage()-1)*pi.getBoardLimit()+1;
			int endRow = startRow + pi.getBoardLimit()-1;
			
			pstmt.setString(1, search);
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
	
	public ArrayList<Member> lecturerList(Connection conn,PageInfo pi,String search){
		ArrayList<Member> list = new ArrayList<>();
		PreparedStatement pstmt = null;
		ResultSet rset = null;
		String sql = prop.getProperty("lecturerList");
		String a = '%'+search+'%';
		
		try {
			pstmt = conn.prepareStatement(sql);
			int startRow = (pi.getCurrentPage()-1)*pi.getBoardLimit()+1;
			int endRow = startRow + pi.getBoardLimit()-1;
			
			pstmt.setString(1, search);
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
	
	public ArrayList<Member> outMentorList(Connection conn,PageInfo pi,String search){
		ArrayList<Member> list = new ArrayList<>();
		PreparedStatement pstmt = null;
		ResultSet rset = null;
		String sql = prop.getProperty("outMentorList");
		String a = '%'+search+'%';
		
		try {
			pstmt = conn.prepareStatement(sql);
			int startRow = (pi.getCurrentPage()-1)*pi.getBoardLimit()+1;
			int endRow = startRow + pi.getBoardLimit()-1;
			
			pstmt.setString(1, search);
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
	
	public int withdrawalStu(Connection conn,String name,String id) {
		int result = 0;
		PreparedStatement pstmt = null;
		String sql = prop.getProperty("withdrawalStu");
		
		try {
			pstmt=conn.prepareStatement(sql);
			pstmt.setString(1, name);
			pstmt.setString(2, id);
			result = pstmt.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			close(pstmt);
		}
		
		return result;
	}
	
	public int restoreStu(Connection conn,String name,String id) {
		int result = 0;
		PreparedStatement pstmt = null;
		String sql = prop.getProperty("restoreStu");
		
		try {
			pstmt=conn.prepareStatement(sql);
			pstmt.setString(1, name);
			pstmt.setString(2, id);
			result = pstmt.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			close(pstmt);
		}
		
		return result;
	}
	
	public Mentor mentorDetailInfo(Connection conn, int no) {
		Mentor m = null;
		PreparedStatement pstmt = null;
		ResultSet rset = null;
		String sql = prop.getProperty("mentorDetailInfo");
		
		try {
			pstmt=conn.prepareStatement(sql);
			pstmt.setInt(1, no);
			rset=pstmt.executeQuery();
			if(rset.next()) {
				m = new Mentor(rset.getInt("user_no"),
							   rset.getInt("clcg_no"),
							   rset.getString("mt_company"),
							   rset.getString("mt_job"),
							   rset.getInt("mt_grade"),
							   rset.getString("mt_grant"),
							   rset.getDate("mt_enrolldate"),
							   rset.getString("empcard_path"),
							   rset.getString("empcard_originname"),
							   rset.getString("idcard_path"),
							   rset.getString("idcard_originname"));
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			close(rset);
			close(pstmt);
		}
		return m;
		
	}
	
	public int upMenCate(Connection conn,int no,int grade,int cate) {
		int result = 0;
		PreparedStatement pstmt = null;
		String sql = prop.getProperty("upMenCate");
		
		try {
			pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1, cate);
			pstmt.setInt(2, grade);
			pstmt.setInt(3, no);
			result = pstmt.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			close(pstmt);
		}
		return result;
	}
	
	public int withdrawalMen(Connection conn,int no) {
		int result = 0;
		PreparedStatement pstmt = null;
		String sql = prop.getProperty("withdrawalMen");
		
		try {
			pstmt=conn.prepareStatement(sql);
			pstmt.setInt(1, no);
			result = pstmt.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			close(pstmt);
		}
		
		return result;
	}
	
	public int restoreMen1(Connection conn,int no) {
		int result1 = 0;
		PreparedStatement pstmt = null;
		String sql1 = prop.getProperty("restoreMen1");
		
		try {
			pstmt=conn.prepareStatement(sql1);
			pstmt.setInt(1, no);
			result1 = pstmt.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			close(pstmt);
		}
		
		return result1;
	}

	public int restoreMen2(Connection conn,int no) {
		int result1 = 0;
		PreparedStatement pstmt = null;
		String sql1 = prop.getProperty("restoreMen2");
		
		try {
			pstmt=conn.prepareStatement(sql1);
			pstmt.setInt(1, no);
			result1 = pstmt.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			close(pstmt);
		}
		
		return result1;
	}
	
	public ArrayList<Member> selectAllUserList(Connection conn,PageInfo pi,String search){
		ArrayList<Member> list = new ArrayList<>();
		PreparedStatement pstmt = null;
		ResultSet rset = null;
		String sql = prop.getProperty("selectAllUserList");
		String a = '%'+search+'%';
		
		try {
			pstmt = conn.prepareStatement(sql);
			int startRow = (pi.getCurrentPage()-1)*pi.getBoardLimit()+1;
			int endRow = startRow + pi.getBoardLimit()-1;
			
			pstmt.setString(1, search);
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
	
	public ArrayList<Member> outAllUserList(Connection conn,PageInfo pi,String search){
		ArrayList<Member> list = new ArrayList<>();
		PreparedStatement pstmt = null;
		ResultSet rset = null;
		String sql = prop.getProperty("outAllUserList");
		String a = '%'+search+'%';
		
		try {
			pstmt = conn.prepareStatement(sql);
			int startRow = (pi.getCurrentPage()-1)*pi.getBoardLimit()+1;
			int endRow = startRow + pi.getBoardLimit()-1;
			
			pstmt.setString(1, search);
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
	
	public ArrayList<Pay> payDetailInfo(Connection conn, PageInfo pi, int no){
		ArrayList<Pay> list = new ArrayList<>();
		PreparedStatement pstmt = null;
		ResultSet rset = null;
		String sql = prop.getProperty("payDetailInfo");
		
		try {
			pstmt = conn.prepareStatement(sql);
			int startRow = (pi.getCurrentPage()-1)*pi.getBoardLimit()+1;
			int endRow = startRow + pi.getBoardLimit()-1;
			
			pstmt.setInt(1, no);
			pstmt.setInt(2,startRow);
			pstmt.setInt(3,endRow);
			rset = pstmt.executeQuery();
			while(rset.next()) {
				list.add(new Pay(rset.getInt("pay_no"),
									rset.getString("user_no"),
									rset.getString("cl_title"),
									rset.getString("cp_name"),
									rset.getString("payment"),
									rset.getString("refund"),
									rset.getInt("final_payment"),
									rset.getString("order_name"),
									rset.getString("order_phone"),
									rset.getString("order_email"),
									rset.getDate("pay_date"),
									rset.getDate("refund_date"),
									pi));

			}
			
			
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			close(rset);
			close(pstmt);
		}
		return list;
	}
	
	public ArrayList<Pay> paymentBuyList(Connection conn,PageInfo pi,String search){
		ArrayList<Pay> list = new ArrayList<>();
		PreparedStatement pstmt = null;
		ResultSet rset = null;
		String sql = prop.getProperty("paymentBuyList");
		String a = '%'+search+'%';
		
		try {
			pstmt = conn.prepareStatement(sql);
			int startRow = (pi.getCurrentPage()-1)*pi.getBoardLimit()+1;
			int endRow = startRow + pi.getBoardLimit()-1;
			
			pstmt.setString(1, search);
			pstmt.setString(2, a);
			pstmt.setInt(3,startRow);
			pstmt.setInt(4,endRow);
			rset = pstmt.executeQuery();
			
			while(rset.next()) {
				list.add(new Pay(rset.getInt("pay_no"),
									rset.getString("user_no"),
									rset.getString("cl_title"),
									rset.getString("cp_name"),
									rset.getString("payment"),
									rset.getString("refund"),
									rset.getInt("final_payment"),
									rset.getString("order_name"),
									rset.getString("order_phone"),
									rset.getString("order_email"),
									rset.getDate("pay_date"),
									rset.getDate("refund_date"),
									rset.getString("user_name"),
									rset.getString("user_id")));
			}
			
			
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			close(rset);
			close(pstmt);
		}
		return list;
	}
	
	public ArrayList<Pay> refundRequestList(Connection conn,PageInfo pi,String search){
		ArrayList<Pay> list = new ArrayList<>();
		PreparedStatement pstmt = null;
		ResultSet rset = null;
		String sql = prop.getProperty("refundRequestList");
		String a = '%'+search+'%';
		
		try {
			pstmt = conn.prepareStatement(sql);
			int startRow = (pi.getCurrentPage()-1)*pi.getBoardLimit()+1;
			int endRow = startRow + pi.getBoardLimit()-1;
			
			pstmt.setString(1, search);
			pstmt.setString(2, search);
			pstmt.setString(3, a);
			pstmt.setInt(4,startRow);
			pstmt.setInt(5,endRow);
			rset = pstmt.executeQuery();
			
			while(rset.next()) {
				list.add(new Pay(rset.getInt("pay_no"),
									rset.getString("user_no"),
									rset.getString("cl_no"),
									rset.getString("cp_name"),
									rset.getString("payment"),
									rset.getString("refund"),
									rset.getInt("final_payment"),
									rset.getString("order_name"),
									rset.getString("order_phone"),
									rset.getString("order_email"),
									rset.getDate("pay_date"),
									rset.getDate("refund_date"),
									rset.getString("user_name"),
									rset.getString("user_id"),
									rset.getString("cl_title")));
			}
			
			
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			close(rset);
			close(pstmt);
		}
		return list;
	}
	
	public ArrayList<Pay> paymentRefundList(Connection conn,PageInfo pi,String search){
		ArrayList<Pay> list = new ArrayList<>();
		PreparedStatement pstmt = null;
		ResultSet rset = null;
		String sql = prop.getProperty("paymentRefundList");
		String a = '%'+search+'%';
		
		try {
			pstmt = conn.prepareStatement(sql);
			int startRow = (pi.getCurrentPage()-1)*pi.getBoardLimit()+1;
			int endRow = startRow + pi.getBoardLimit()-1;
			
			pstmt.setString(1, search);
			pstmt.setString(2, search);
			pstmt.setString(3, a);
			pstmt.setInt(4,startRow);
			pstmt.setInt(5,endRow);
			rset = pstmt.executeQuery();
			
			while(rset.next()) {
				list.add(new Pay(rset.getInt("pay_no"),
									rset.getString("user_no"),
									rset.getString("cl_title"),
									rset.getString("cp_name"),
									rset.getString("payment"),
									rset.getString("refund"),
									rset.getInt("final_payment"),
									rset.getString("order_name"),
									rset.getString("order_phone"),
									rset.getString("order_email"),
									rset.getDate("pay_date"),
									rset.getDate("refund_date"),
									rset.getString("user_name"),
									rset.getString("user_id")));
			}
			
			
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			close(rset);
			close(pstmt);
		}
		return list;
	}
	
	public ArrayList<Pay> paymentRefundFinish(Connection conn,PageInfo pi,String search){
		ArrayList<Pay> list = new ArrayList<>();
		PreparedStatement pstmt = null;
		ResultSet rset = null;
		String sql = prop.getProperty("paymentRefundFinish");
		String a = '%'+search+'%';
		
		try {
			pstmt = conn.prepareStatement(sql);
			int startRow = (pi.getCurrentPage()-1)*pi.getBoardLimit()+1;
			int endRow = startRow + pi.getBoardLimit()-1;
			
			pstmt.setString(1, search);
			pstmt.setString(2, search);
			pstmt.setString(3, a);
			pstmt.setInt(4,startRow);
			pstmt.setInt(5,endRow);
			rset = pstmt.executeQuery();
			
			while(rset.next()) {
				list.add(new Pay(rset.getInt("pay_no"),
									rset.getString("user_no"),
									rset.getString("cl_title"),
									rset.getString("cp_name"),
									rset.getString("payment"),
									rset.getString("refund"),
									rset.getInt("final_payment"),
									rset.getString("order_name"),
									rset.getString("order_phone"),
									rset.getString("order_email"),
									rset.getDate("pay_date"),
									rset.getDate("refund_date"),
									rset.getString("user_name"),
									rset.getString("user_id")));
			}
			
			
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			close(rset);
			close(pstmt);
		}
		return list;
	}
	
	public ArrayList<Pay> paymentRefundDeny(Connection conn,PageInfo pi,String search){
		ArrayList<Pay> list = new ArrayList<>();
		PreparedStatement pstmt = null;
		ResultSet rset = null;
		String sql = prop.getProperty("paymentRefundDeny");
		String a = '%'+search+'%';
		
		try {
			pstmt = conn.prepareStatement(sql);
			int startRow = (pi.getCurrentPage()-1)*pi.getBoardLimit()+1;
			int endRow = startRow + pi.getBoardLimit()-1;
			
			pstmt.setString(1, search);
			pstmt.setString(2, search);
			pstmt.setString(3, a);
			pstmt.setInt(4,startRow);
			pstmt.setInt(5,endRow);
			rset = pstmt.executeQuery();
			
			while(rset.next()) {
				list.add(new Pay(rset.getInt("pay_no"),
									rset.getString("user_no"),
									rset.getString("cl_title"),
									rset.getString("cp_name"),
									rset.getString("payment"),
									rset.getString("refund"),
									rset.getInt("final_payment"),
									rset.getString("order_name"),
									rset.getString("order_phone"),
									rset.getString("order_email"),
									rset.getDate("pay_date"),
									rset.getDate("refund_date"),
									rset.getString("user_name"),
									rset.getString("user_id")));
			}
			
			
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			close(rset);
			close(pstmt);
		}
		return list;
	}
	
	public ArrayList<IssuanceCoupon> MemberCouponBeforList(Connection conn, PageInfo pi,String search){
		ArrayList<IssuanceCoupon> list = new ArrayList<>();
		PreparedStatement pstmt = null;
		ResultSet rset = null;
		String sql = prop.getProperty("MemberCouponBeforList");
		String a = '%'+search+'%';
		
		try {
			pstmt = conn.prepareStatement(sql);
			int startRow = (pi.getCurrentPage()-1)*pi.getBoardLimit()+1;
			int endRow = startRow + pi.getBoardLimit()-1;
			
			pstmt.setString(1, search);
			pstmt.setString(2, a);
			pstmt.setInt(3,startRow);
			pstmt.setInt(4,endRow);
			rset = pstmt.executeQuery();
			
			while(rset.next()) {
				list.add(new IssuanceCoupon(rset.getInt("isucp_no"),
										    rset.getString("user_no"),
										    rset.getString("cp_no"),
										    rset.getString("cp_status"),
										    rset.getDate("cp_issuedate"),
										    rset.getDate("cp_enddate"),
										    rset.getString("user_name"),
										    rset.getString("cp_name")));
			}
			
			
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			close(rset);
			close(pstmt);
		}
		return list;
	}
	
	public ArrayList<IssuanceCoupon> MemberCouponAfterList(Connection conn, PageInfo pi,String search){
		ArrayList<IssuanceCoupon> list = new ArrayList<>();
		PreparedStatement pstmt = null;
		ResultSet rset = null;
		String sql = prop.getProperty("MemberCouponAfterList");
		String a = '%'+search+'%';
		
		try {
			pstmt = conn.prepareStatement(sql);
			int startRow = (pi.getCurrentPage()-1)*pi.getBoardLimit()+1;
			int endRow = startRow + pi.getBoardLimit()-1;
			
			pstmt.setString(1, search);
			pstmt.setString(2, a);
			pstmt.setInt(3,startRow);
			pstmt.setInt(4,endRow);
			rset = pstmt.executeQuery();
			
			while(rset.next()) {
				list.add(new IssuanceCoupon(rset.getInt("isucp_no"),
										    rset.getString("user_no"),
										    rset.getString("cp_no"),
										    rset.getString("cp_status"),
										    rset.getDate("cp_issuedate"),
										    rset.getDate("cp_enddate"),
										    rset.getString("user_name"),
										    rset.getString("cp_name")));
			}
			
			
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			close(rset);
			close(pstmt);
		}
		return list;
	}
	
	public ArrayList<Coupon> couponList(Connection conn,PageInfo pi){
		ArrayList<Coupon> list = new ArrayList<>();
		PreparedStatement pstmt = null;
		ResultSet rset = null;
		String sql = prop.getProperty("couponList");
		
		try {
			pstmt = conn.prepareStatement(sql);
			int startRow = (pi.getCurrentPage()-1)*pi.getBoardLimit()+1;
			int endRow = startRow + pi.getBoardLimit()-1;
			
			pstmt.setInt(1,startRow);
			pstmt.setInt(2,endRow);
			rset = pstmt.executeQuery();
			
			while(rset.next()) {
				list.add(new Coupon(rset.getInt("cp_no"),
						            rset.getString("cp_name"),
						            rset.getInt("discount"),
						            rset.getDate("cp_adddate"),
						            rset.getString("cp_status")));
			}
			
		} catch (SQLException e) {
			e.printStackTrace();
		}finally {
			close(rset);
			close(pstmt);
		}
		return list;
	}
	
	public ArrayList<Coupon> couponListA(Connection conn,PageInfo pi){
		ArrayList<Coupon> list = new ArrayList<>();
		PreparedStatement pstmt = null;
		ResultSet rset = null;
		String sql = prop.getProperty("couponListA");
		
		try {
			pstmt = conn.prepareStatement(sql);
			int startRow = (pi.getCurrentPage()-1)*pi.getBoardLimit()+1;
			int endRow = startRow + pi.getBoardLimit()-1;
			
			pstmt.setInt(1,startRow);
			pstmt.setInt(2,endRow);
			rset = pstmt.executeQuery();
			
			while(rset.next()) {
				list.add(new Coupon(rset.getInt("cp_no"),
						            rset.getString("cp_name"),
						            rset.getInt("discount"),
						            rset.getDate("cp_adddate"),
						            rset.getString("cp_status")));
			}
			
		} catch (SQLException e) {
			e.printStackTrace();
		}finally {
			close(rset);
			close(pstmt);
		}
		return list;
	}
	
	public ArrayList<ClassIng> classStu(Connection conn){
		ArrayList<ClassIng> list = new ArrayList<>();
		PreparedStatement pstmt = null;
		ResultSet rset = null;
		String sql = prop.getProperty("classStu");
		
		try {
			pstmt = conn.prepareStatement(sql);
			rset = pstmt.executeQuery();
			
			while(rset.next()) {
				list.add(new ClassIng(rset.getInt("user_no")));
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}finally {
			close(rset);
			close(pstmt);
		}
		return list;
	}
	
	public int insertCoupon(Connection conn,String cpName,int discount) {
		int result = 0;
		PreparedStatement pstmt = null;
		String sql = prop.getProperty("insertCoupon");
		
		try {
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, cpName);
			pstmt.setInt(2, discount);
			result = pstmt.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			close(pstmt);
		}
		return result;
	}
	
	public int CouponNo(Connection conn) {
		int no = 0;
		PreparedStatement pstmt = null;
		ResultSet rset = null;
		String sql = prop.getProperty("CouponNo");
		
		try {
			pstmt = conn.prepareStatement(sql);
			rset = pstmt.executeQuery();
			if(rset.next()) {
				no = rset.getInt("cp_no");
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			close(rset);
			close(pstmt);
		}
		return no;
	}
	
	public int sendCouponClStu(Connection conn, ArrayList<ClassIng>list,int no) {
		int result2 = 1;
		String sql = prop.getProperty("sendCoupon");
		
		for(ClassIng c : list) {
			int a = 0;
			PreparedStatement pstmt = null;
			try {
				pstmt = conn.prepareStatement(sql);
				pstmt.setInt(1, c.getUserNo());
				pstmt.setInt(2, no);
				a = pstmt.executeUpdate();
				System.out.println(a);
				result2 = result2*a;
			} catch (SQLException e) {
				e.printStackTrace();
			} finally {
				close(pstmt);
			}
		}
		
		return result2;
	}

	public ArrayList<Integer> allStuNo(Connection conn){
		ArrayList<Integer> list = new ArrayList<>();
		PreparedStatement pstmt = null;
		ResultSet rset = null;
		String sql = prop.getProperty("allStuNo");
		
		try {
			pstmt = conn.prepareStatement(sql);
			rset = pstmt.executeQuery();
			while(rset.next()) {
				list.add(rset.getInt("user_no"));
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			close(rset);
			close(pstmt);
		}
		return list;
	}
	
	public ArrayList<Integer> allMemNo(Connection conn){
		ArrayList<Integer> list = new ArrayList<>();
		PreparedStatement pstmt = null;
		ResultSet rset = null;
		String sql = prop.getProperty("allMemNo");
		
		try {
			pstmt = conn.prepareStatement(sql);
			rset = pstmt.executeQuery();
			while(rset.next()) {
				list.add(rset.getInt("user_no"));
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			close(rset);
			close(pstmt);
		}
		return list;
	}
	
	public int sendCoupon(Connection conn, ArrayList<Integer>list,int no) {
		int result2 = 1;
		String sql = prop.getProperty("sendCoupon");
		
		for(int i=0;i<list.size();i++) {
			int a = 0;
			PreparedStatement pstmt = null;
			try {
				pstmt = conn.prepareStatement(sql);
				pstmt.setInt(1, list.get(i));
				pstmt.setInt(2, no);
				a = pstmt.executeUpdate();
				
				result2 = result2*a;
			} catch (SQLException e) {
				e.printStackTrace();
			} finally {
				close(pstmt);
			}
		}
		
		return result2;
	}
	
	public int couponStop(Connection conn, int no) {
		int result = 0;
		PreparedStatement pstmt = null;
		String sql = prop.getProperty("couponStop");
		
		try {
			pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1, no);
			result = pstmt.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			close(pstmt);
		}
		return result;
	}
	
	public int couponRestore(Connection conn, int no) {
		int result = 0;
		PreparedStatement pstmt = null;
		String sql = prop.getProperty("couponRestore");
		
		try {
			pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1, no);
			result = pstmt.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			close(pstmt);
		}
		return result;
	}
	
	public int couponDelete(Connection conn, int no) {
		int result = 0;
		PreparedStatement pstmt = null;
		String sql = prop.getProperty("couponDelete");
		
		try {
			pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1, no);
			result = pstmt.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			close(pstmt);
		}
		return result;
	}
	
	public int deleteUserCp(Connection conn, int no) {
		int result = 0;
		PreparedStatement pstmt = null;
		String sql = prop.getProperty("deleteUserCp");
		
		try {
			pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1, no);
			result = pstmt.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			close(pstmt);
		}
		return result;
	}
	
	public int insertUserCp(Connection conn,int userNo,int cpNo) {
		int result = 0;
		PreparedStatement pstmt = null;
		String sql = prop.getProperty("insertUserCp");
		
		try {
			pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1, userNo);
			pstmt.setInt(2, cpNo);
			result = pstmt.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			close(pstmt);
		}
		return result;
	}
	
	public int refundAccess(Connection conn,int payNo) {
		int result = 0;
		PreparedStatement pstmt = null;
		String sql = prop.getProperty("refundAccess");
		
		try {
			pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1, payNo);
			result = pstmt.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			close(pstmt);
		}
		return result;
	}
	
	public int refundDeny(Connection conn,int payNo) {
		int result = 0;
		PreparedStatement pstmt = null;
		String sql = prop.getProperty("refundDeny");
		
		try {
			pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1, payNo);
			result = pstmt.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			close(pstmt);
		}
		return result;
	}
	
	public ArrayList<Member> memberSimpleInfo(Connection conn){
		ArrayList<Member> list = new ArrayList<>();
		PreparedStatement pstmt = null;
		ResultSet rset = null;
		String sql = prop.getProperty("memberSimpleInfo");
		
		try {
			pstmt = conn.prepareStatement(sql);
			rset = pstmt.executeQuery();
			
			while(rset.next()) {
				Member m = new Member();
				m.setUserNo(rset.getInt("user_no"));
				m.setUserId(rset.getString("user_id"));
				m.setUserName(rset.getString("user_name"));
				list.add(m);
			}
			
		} catch (SQLException e) {
			e.printStackTrace();
		}finally {
			close(rset);
			close(pstmt);
		}
		return list;
	}
	
	public ArrayList<Member> rbutton(Connection conn,String sql){
		ArrayList<Member> list = new ArrayList<>();
		PreparedStatement pstmt = null;
		ResultSet rset = null;
		
		
		try {
			pstmt = conn.prepareStatement(sql);
			rset = pstmt.executeQuery();
			
			while(rset.next()) {
				Member m = new Member();
				m.setUserNo(rset.getInt("user_no"));
				m.setUserId(rset.getString("user_id"));
				m.setUserName(rset.getString("user_name"));
				list.add(m);
			}
			
		} catch (SQLException e) {
			e.printStackTrace();
		}finally {
			close(rset);
			close(pstmt);
		}
		return list;
	}
	
	public ArrayList<Integer> sbutton(Connection conn,String search){
		ArrayList<Integer> list = new ArrayList<>();
		PreparedStatement pstmt = null;
		ResultSet rset = null;
		String a = '%'+search+'%';
		String sql = prop.getProperty("sbutton");
		
		try {
		Integer.parseInt(search);
		}catch(NumberFormatException e){
			search="0";
		}
		
		try {
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, search);
			pstmt.setString(2, a);
			rset = pstmt.executeQuery();
			
			while(rset.next()) {
				list.add(rset.getInt("user_no"));
			}
			
		} catch (SQLException e) {
			e.printStackTrace();
		}finally {
			close(rset);
			close(pstmt);
		}
		return list;
	}
	
	public int cpSendButton(Connection conn, int cpNo,int userNo) {
		PreparedStatement pstmt = null;
		int result = 0;
		String sql = prop.getProperty("cpSendButton");
		
		try {
			pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1, userNo);
			pstmt.setInt(2, cpNo);
			result = pstmt.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			close(pstmt);
		}
		return result;
	}
}
