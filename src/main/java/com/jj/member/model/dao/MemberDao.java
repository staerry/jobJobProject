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
							   rset.getInt("user_division"),
							   rset.getInt("clcg_no"),
							   rset.getString("mt_company"),
							   rset.getString("mt_job"),
							   rset.getInt("mt_grade"),
							   rset.getString("mt_grant"),
							   rset.getDate("mt_enrolldate"),
							   rset.getString("empcard_path"),
							   rset.getString("empcard_originname"),
							   rset.getString("idcard_path"),
							   rset.getString("idcard_originname")
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
	
	public int insertMtoUserInfo(Connection conn, Member m) {
		// insert문 => DML문 => 처리된 행수
		int result = 0;
		PreparedStatement pstmt = null;
		String sql = prop.getProperty("insertMtoUserInfo");
		
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
	
	public int insertMtoMentor(Connection conn, Member m, Mentor mt) {
		// Mentor에 insert => 처리된 행수
		int result = 0;
		PreparedStatement pstmt = null;
		String sql = prop.getProperty("insertMtoMentor");
		
		try {
			pstmt = conn.prepareStatement(sql);
			
			pstmt.setInt(1, mt.getClcgNo());
			pstmt.setString(2, mt.getMtCompany());
			pstmt.setString(3, mt.getMtJob());
			pstmt.setString(4, mt.getEmpCardPath());
			pstmt.setString(5, mt.getEmpCardOriginName());
			pstmt.setString(6, mt.getIdCardPath());
			pstmt.setString(7, mt.getIdCardOriginName());
			
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

	
	public int updateInfo(Connection conn, String userId, String userPwd, String userNewPwd, String userEmail, String userPhone) {
		   int result = 0;
		   PreparedStatement pstmt = null;
		   String sql = prop.getProperty("updateInfo");
		   
		   try {
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, userNewPwd);
			pstmt.setString(2, userPhone);
			pstmt.setString(3, userEmail);
			pstmt.setString(4, userId);
		
 			
			result = pstmt.executeUpdate();
			
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			close(pstmt);
		}
		   return result;
	}
	
	public int selectClassIng(Connection conn, String name) {
		int classIngCount = 0;
		
		PreparedStatement pstmt = null;
		ResultSet rset = null;
		
		String sql = prop.getProperty("selectClassIng");
		
		try {
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, name);
			
			rset = pstmt.executeQuery();
			
			if(rset.next()) {
				classIngCount = rset.getInt("count");
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}finally {
			close(rset);
			close(pstmt);
		}
		
		return classIngCount;
	}
	
	public int accessDate(Connection conn, int userNo) {
		int result = 0;
		PreparedStatement pstmt = null;
		String sql = prop.getProperty("accessDate");

		try {
			pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1, userNo);

			result = pstmt.executeUpdate();

		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			close(pstmt);
		}
		return result;
	}
	
	
}
