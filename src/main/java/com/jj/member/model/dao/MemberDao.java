package com.jj.member.model.dao;

import static com.jj.common.JDBCTemplate.*;

import java.io.FileInputStream;
import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Properties;

import com.jj.member.model.vo.Member;
import com.jj.member.model.vo.Mentor;

public class MemberDao {
	
	private Properties prop = new Properties();
	
	public MemberDao() {
		
		// 읽어들일 파일 : member-mapper.xml 
		String filePath = MemberDao.class.getResource("/db/sql/member-mapper.xml").getPath();
	
		try {
			prop.loadFromXML(new FileInputStream(filePath));
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	public Member loginMember(Connection conn, String userId, String userPwd) {
		// select문 => ResultSet객체 (한행) => Member객체로 옮겨담음
		Member m = null;
		
		PreparedStatement pstmt = null;
		ResultSet rset = null;
		
		String sql = prop.getProperty("loginMember");
		
		try {
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, userId);
			pstmt.setString(2, userPwd);
			
			rset = pstmt.executeQuery(); // 조회결과가 없거나 한행
			
			if(rset.next()) { // 조회된게 있으면 true, 없으면 false
				// 조회 성공
				m = new Member(rset.getInt("user_no"),
							   rset.getString("user_id"),
							   rset.getString("user_pwd"),
							   rset.getString("user_name"),
							   rset.getString("user_email"),
							   rset.getString("user_phone"),
							   rset.getDate("user_enrolldate"),
							   rset.getString("user_status"),
							   rset.getString("admin_status"),
							   rset.getInt("user_division")
							   ); // Member객체에 한줄의 정보를 담음
			}

		} catch (SQLException e) {
			e.printStackTrace();
		}finally {
			close(rset);
			close(pstmt);
		}
		return m;
	
	}
	
	
	public int insertMember(Connection conn, Member m) {
		// insert문 => DML문 => 처리된 행수
		int result = 0;
		PreparedStatement pstmt = null;
		String sql = prop.getProperty("insertMember");
		
		try {
			pstmt = conn.prepareStatement(sql);
			
			pstmt.setString(1, m.getUserId());
			pstmt.setString(2, m.getUserPwd());
			pstmt.setString(3, m.getUserName());
			pstmt.setString(4, m.getUserEmail());
			pstmt.setString(5, m.getUserPhone());
			
			result = pstmt.executeUpdate();
			
		} catch (SQLException e) {
			e.printStackTrace();
		}finally {
			close(pstmt);
		}
		return result;
	}
	
	public int idCheck(Connection conn, String checkId) {
		// select문 => ResultSet에 담김(한개 0또는 1) => int에 담아서 반환
		int count = 0;
		PreparedStatement pstmt = null;
		ResultSet rset = null;
		String sql = prop.getProperty("idCheck");
		
		try {
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, checkId);
			
			rset = pstmt.executeQuery();
			
			if(rset.next()) {
				count = rset.getInt("count");
			}
			
		} catch (SQLException e) {
			e.printStackTrace();
		}finally {
			close(rset);
			close(pstmt);
		}
		return count;
	}
	
	public int insertMentorToUserInfo(Connection conn, Member m) {
		// insert문 => DML문 => 처리된 행수
		int result = 0;
		PreparedStatement pstmt = null;
		String sql = prop.getProperty("insertMentorToUserInfo");
		
		try {
			pstmt = conn.prepareStatement(sql);
			
			pstmt.setString(1, m.getUserId());
			pstmt.setString(2, m.getUserPwd());
			pstmt.setString(3, m.getUserName());
			pstmt.setString(4, m.getUserEmail());
			pstmt.setString(5, m.getUserPhone());
			
			result = pstmt.executeUpdate();
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally {
			close(pstmt);
		}
		return result;
	}


	public int insertMentor(Connection conn, Member m, Mentor mt) {
		// Mentor에 insert => 처리된 행수
		int result = 0;
		PreparedStatement pstmt = null;
		String sql = prop.getProperty("insertMentor");
		
		try {
			pstmt = conn.prepareStatement(sql);
			
			pstmt.setInt(1, m.getUserNo()); // Member에 먼저 들어간 멘토회원의 USER_NO를 이렇게 불러와도되나요??
			pstmt.setInt(2, mt.getClcgNo());
			pstmt.setString(3, mt.getMtCompany());
			pstmt.setString(4, mt.getMtJob());
			pstmt.setString(5, mt.getEmpCardPath());
			pstmt.setString(6, mt.getEmpCardOriginName());
			pstmt.setString(7, mt.getIdCardPath());
			pstmt.setString(8, mt.getIdCardOriginName());
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally {
			close(pstmt);
		}
		return result;
	}
	
	public int insertEmpCardAttachment(Connection conn, Member m, Mentor mt) {
		// slide_attachment에 insert => 처리된 행수
		int result = 0;
		PreparedStatement pstmt = null;
		String sql = prop.getProperty("insertAttachment");
		
		try {
			pstmt = conn.prepareStatement(sql);
			
			pstmt.setString(1, mt.getEmpCardOriginName());
			pstmt.setString(2, mt.getEmpCardPath());
			
			result = pstmt.executeUpdate();
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally {
			close(pstmt);
		}
		return result;
	}
	
	public int insertIdCardAttachment(Connection conn, Member m, Mentor mt) {
		// slide_attachment에 insert => 처리된 행수
		int result = 0;
		PreparedStatement pstmt = null;
		String sql = prop.getProperty("insertAttachment");
		
		try {
			pstmt = conn.prepareStatement(sql);
			
			pstmt.setString(1, mt.getIdCardOriginName());
			pstmt.setString(2, mt.getIdCardPath());
			
			result = pstmt.executeUpdate();
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally {
			close(pstmt);
		}
		return result;
	}
	

	
	public int deleteMember(Connection conn, String userId, String userPwd) {
		
		   int result = 0;
		   PreparedStatement pstmt = null;
		   String sql = prop.getProperty("deleteMember");
		   
		   try {
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, userId);
			pstmt.setString(2, userPwd);
			
			result = pstmt.executeUpdate();
			
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			close(pstmt);
		}
		   return result;
		
	}

	public int updateInfo(Connection conn, String userId, String userPwd, String userNewPwd, String userCheckPwd, String phone) {
		   int result = 0;
		   PreparedStatement pstmt = null;
		   String sql = prop.getProperty("updateInfo");
		   
		   try {
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, userId);
			pstmt.setString(2, userPwd);
			pstmt.setString(3, userPwd);
			pstmt.setString(4, userNewPwd);
			pstmt.setString(5, userCheckPwd);
			pstmt.setString(6, phone);
			
			result = pstmt.executeUpdate();
			
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			close(pstmt);
		}
		   return result;
	}
}
