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
import com.jj.common.model.vo.PageInfo;
import com.jj.faq.model.vo.Faq;
import com.jj.member.model.vo.Member;
import com.jj.notice.model.vo.Notice;

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
	
	public int selectMentorListCount(Connection conn,String search) {
		int listCount = 0;
		PreparedStatement pstmt = null;
		ResultSet rset = null;
		String sql = prop.getProperty("selectMentorListCount");
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
	
	public int currentCount(Connection conn,String search) {
		int listCount = 0;
		PreparedStatement pstmt = null;
		ResultSet rset = null;
		String sql = prop.getProperty("currentCount");
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
	
	public int lecturerCount(Connection conn,String search) {
		int listCount = 0;
		PreparedStatement pstmt = null;
		ResultSet rset = null;
		String sql = prop.getProperty("lecturerCount");
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
	
	public int outMentorCount(Connection conn,String search) {
		int listCount = 0;
		PreparedStatement pstmt = null;
		ResultSet rset = null;
		String sql = prop.getProperty("outMentorCount");
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


	
	
	
	
	
	
	
}
