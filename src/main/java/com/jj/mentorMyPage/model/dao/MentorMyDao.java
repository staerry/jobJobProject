package com.jj.mentorMyPage.model.dao;

import java.io.FileInputStream;
import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Properties;
import static com.jj.common.JDBCTemplate.close;
import com.jj.member.model.vo.Member;
import com.jj.member.model.vo.Mentor;
import com.jj.mentorMyPage.model.vo.CreateClass;
import com.jj.mentorMyPage.model.vo.MtQuestion;
import com.jj.mentorMyPage.model.vo.Vod;
import com.jj.mentorSelect.model.vo.ClCategory;
import com.jj.userMyPage.model.vo.Class;
import com.jj.userMyPage.model.vo.Lecturer;


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
	
		String sql = prop.getProperty("createClass");
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
			
			result = pstmt.executeUpdate();
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

//	1개의 클래스 상세조회  
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


	

	public ArrayList<MtQuestion> selectAllQuestion(Connection conn, int userNo) {
		ArrayList<MtQuestion> list = new ArrayList<>();
		PreparedStatement pstmt = null;
		ResultSet rset = null;
		
		String sql = prop.getProperty("selectAllQuestion");
		
		try {
			pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1, userNo);
			rset = pstmt.executeQuery();
			
			while(rset.next()) {
				list.add(new MtQuestion(rset.getInt("mt_que_no")
			              , rset.getString("que_title")
			              , rset.getString("que_content")
			              , rset.getDate("que_enrolldate")
			              , rset.getString("ans_content")
			              , rset.getDate("ans_date")
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


	public List<Vod> selectVodList(Connection conn, int clNo) {
		List<Vod> list = new ArrayList<>();
		PreparedStatement pstmt = null;
		ResultSet rset = null;
		
		String sql = prop.getProperty("selectVodList");
		
		try {
			pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1, clNo);
			rset = pstmt.executeQuery();
			
			while(rset.next()) {
				Vod vod = new Vod();
				vod.setVodNo(rset.getInt("vod_no"));
//				Class cls = new Class();
//				cls.setClNo(clNo);
//				vod.setCls(cls);
				vod.setVodTitle(rset.getString("vod_title"));
				vod.setVodStatus(rset.getString("vod_status"));
					
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

//	멘토의 나의답변 리스트에서 답변을 삭제하는 기능
	public int deleteMyAns(Connection conn, int userNo, String replyNo) {
		System.out.println(userNo);
		System.out.println(replyNo);
		
		int result = 0;
		PreparedStatement pstmt = null;
		String sql = prop.getProperty("deleteMyAns");
		
		sql += "AND REPLY_NO IN (" + replyNo + ")";
		
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


	public Lecturer selectLecturerByUserNo(Connection conn, Member member) {
		Lecturer lecturer = new Lecturer();
		PreparedStatement pstmt = null;
		ResultSet rset = null;
		
		String sql = prop.getProperty("selectLecturerByUserNo");
		
		try {
			pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1, member.getUserNo());
			rset = pstmt.executeQuery();
			
			while(rset.next()) {
				Member lectMember = new Member();
				lectMember.setUserNo(rset.getInt("USER_NO"));
				lectMember.setUserName(rset.getString("user_name"));
				
				lecturer.setMember(lectMember);
				lecturer.setLtrInfo(rset.getString("LTR_INFO"));
				lecturer.setLtrCareer(rset.getString("LTR_CAREER"));
				lecturer.setProfilePath(rset.getString("PROFILE_PATH"));
				
				Mentor mentor = new Mentor();
				mentor.setMtCompany(rset.getString("mt_company"));
				lecturer.setMentor(mentor);
				
				ClCategory category = new ClCategory();
				category.setClcgName(rset.getString("clcg_name"));
				lecturer.setClCategory(category);
				
			}
			
			} catch (SQLException e) {
			e.printStackTrace();
		}finally {
			close(rset);
			close(pstmt);
		}
		
		
		return lecturer;
	}
		
		
}
	
	
	
	
	
	
