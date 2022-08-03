package com.jj.mentorSelect.model.dao;

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
import com.jj.community.model.dao.CommunityDao;
import com.jj.mentorSelect.model.vo.Lecturer;
import com.jj.mentorSelect.model.vo.MtQuestion;
public class LecturerDao {

Properties prop = new Properties();
	
	public LecturerDao() {
		try {
			prop.loadFromXML(new FileInputStream( CommunityDao.class.getResource("/db/sql/mentorSelect-mapper.xml").getPath()));
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	public int selectListCount(Connection conn) {
		int listCount = 0;
		PreparedStatement pstmt = null;
		ResultSet rset = null;
		String sql = prop.getProperty("selectListCount");
		
		try {
			pstmt = conn.prepareStatement(sql);
			rset = pstmt.executeQuery();
			
			if(rset.next()) {
				listCount = rset.getInt("lt_count");
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			close(rset);
			close(pstmt);
		}
		
		return listCount;
	}
	
	public ArrayList<Lecturer> selectList(Connection conn) {
		ArrayList<Lecturer> list = new ArrayList<>();
		PreparedStatement pstmt = null;
		ResultSet rset = null;
		String sql = prop.getProperty("selectList");
		
		try {
			pstmt = conn.prepareStatement(sql);
			rset = pstmt.executeQuery();
			
			while(rset.next()) {
				list.add(new Lecturer(rset.getInt("user_no"),
									  rset.getString("user_name"),
									  rset.getString("mt_company"),
									  rset.getString("mt_job"),
									  rset.getString("clcg_name"),
									  rset.getString("ltr_info"),
									  rset.getString("ltr_career"),
									  rset.getString("profile_path")
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
	
	public Lecturer selectLecturer(Connection conn, int lecNo) {
		Lecturer l = null;
		PreparedStatement pstmt = null;
		ResultSet rset = null;
		String sql = prop.getProperty("selectLecturer");
	
		try {
			pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1, lecNo);
			
			rset = pstmt.executeQuery();
			
			if(rset.next()) {
				l = new Lecturer(rset.getInt("user_no"),
								 rset.getString("user_name"),
								 rset.getString("mt_company"),
								 rset.getString("mt_job"),
								 rset.getString("clcg_name"),
								 rset.getString("ltr_info"),
								 rset.getString("ltr_career"),
								 rset.getString("profile_path")
								);
			}
			
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			close(rset);
			close(pstmt);
		}
		
		return l;
		
	}
	
	public ArrayList<Class> selectClass(Connection conn, int lecNo) {
		ArrayList<Class> classList = new ArrayList<>();
		PreparedStatement pstmt = null;
		ResultSet rset = null;
		String sql = prop.getProperty("selectClass");
		
		try {
			pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1, lecNo);
			rset = pstmt.executeQuery();
			
			while(rset.next()) {
				classList.add(new Class(rset.getInt("cl_no"),
										rset.getString("cl_title"),
										rset.getString("user_name"),
										rset.getDate("cl_enrolldate"),
										rset.getString("cl_thumbnailpath")
							 ));
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			close(rset);
			close(pstmt);
		}
				
		return classList;
		
	}
		
	public int selectListCountOne(Connection conn, String[] category) {
		int listCount = 0;
		PreparedStatement pstmt = null;
		ResultSet rset = null;
		String sql = prop.getProperty("selectListCountOne");
		
		try {
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, category[0]);
			
			rset = pstmt.executeQuery();
			
			if(rset.next()) {
				listCount = rset.getInt("lt_count");
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}finally{
			close(rset);
			close(pstmt);
		}
		return listCount;
	}
	
	public int selectListCountTwo(Connection conn, String[] category) {
		int listCount = 0;
		PreparedStatement pstmt = null;
		ResultSet rset = null;
		String sql = prop.getProperty("selectListCountTwo");
		
		try {
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, category[0]);
			pstmt.setString(2, category[1]);
			
			rset = pstmt.executeQuery();
			
			if(rset.next()) {
				listCount = rset.getInt("lt_count");
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}finally{
			close(rset);
			close(pstmt);
		}
		return listCount;
	}
	
	public int selectListCountThree(Connection conn, String[] category) {
		int listCount = 0;
		PreparedStatement pstmt = null;
		ResultSet rset = null;
		String sql = prop.getProperty("selectListCountThree");
		
		try {
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, category[0]);
			pstmt.setString(2, category[1]);
			pstmt.setString(3, category[2]);
			
			rset = pstmt.executeQuery();
			
			if(rset.next()) {
				listCount = rset.getInt("lt_count");
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}finally{
			close(rset);
			close(pstmt);
		}
		return listCount;
	}
	
	public int selectListCountFour(Connection conn, String[] category) {
		int listCount = 0;
		PreparedStatement pstmt = null;
		ResultSet rset = null;
		String sql = prop.getProperty("selectListCountFour");
		
		try {
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, category[0]);
			pstmt.setString(2, category[1]);
			pstmt.setString(3, category[2]);
			pstmt.setString(4, category[3]);
			
			rset = pstmt.executeQuery();
			
			if(rset.next()) {
				listCount = rset.getInt("lt_count");
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}finally{
			close(rset);
			close(pstmt);
		}
		return listCount;
	}
	
	public int selectListCountFive(Connection conn, String[] category) {
		int listCount = 0;
		PreparedStatement pstmt = null;
		ResultSet rset = null;
		String sql = prop.getProperty("selectListCountFive");
		
		try {
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, category[0]);
			pstmt.setString(2, category[1]);
			pstmt.setString(3, category[2]);
			pstmt.setString(4, category[3]);
			pstmt.setString(5, category[4]);
			
			rset = pstmt.executeQuery();
			
			if(rset.next()) {
				listCount = rset.getInt("lt_count");
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}finally{
			close(rset);
			close(pstmt);
		}
		return listCount;
	}
	
	public int selectListCountSix(Connection conn, String[] category) {
		int listCount = 0;
		PreparedStatement pstmt = null;
		ResultSet rset = null;
		String sql = prop.getProperty("selectListCountSix");
		
		try {
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, category[0]);
			pstmt.setString(2, category[1]);
			pstmt.setString(3, category[2]);
			pstmt.setString(4, category[3]);
			pstmt.setString(5, category[4]);
			pstmt.setString(6, category[5]);
			
			rset = pstmt.executeQuery();
			
			if(rset.next()) {
				listCount = rset.getInt("lt_count");
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}finally{
			close(rset);
			close(pstmt);
		}
		return listCount;
	}
	
	public ArrayList<Lecturer> selectListOne(Connection conn, String[] category) {
		ArrayList<Lecturer> list = new ArrayList<>();
		PreparedStatement pstmt = null;
		ResultSet rset = null;
		String sql = prop.getProperty("selectListOne");
		
		try {
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, category[0]);
			
			rset = pstmt.executeQuery();
			
			while(rset.next()) {
				list.add(new Lecturer(rset.getInt("user_no"),
									  rset.getString("user_name"),
									  rset.getString("mt_company"),
									  rset.getString("clcg_name"),
									  rset.getString("profile_path")						
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
	
	public ArrayList<Lecturer> selectListTwo(Connection conn, String[] category) {
		ArrayList<Lecturer> list = new ArrayList<>();
		PreparedStatement pstmt = null;
		ResultSet rset = null;
		String sql = prop.getProperty("selectListTwo");
		
		try {
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, category[0]);
			pstmt.setString(2, category[1]);
			
			rset = pstmt.executeQuery();
			
			while(rset.next()) {
				list.add(new Lecturer(rset.getInt("user_no"),
									  rset.getString("user_name"),
									  rset.getString("mt_company"),
									  rset.getString("clcg_name"),
									  rset.getString("profile_path")						
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
	
	public ArrayList<Lecturer> selectListThree(Connection conn, String[] category) {
		ArrayList<Lecturer> list = new ArrayList<>();
		PreparedStatement pstmt = null;
		ResultSet rset = null;
		String sql = prop.getProperty("selectListThree");
		
		try {
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, category[0]);
			pstmt.setString(2, category[1]);
			pstmt.setString(3, category[2]);
			
			rset = pstmt.executeQuery();
			
			while(rset.next()) {
				list.add(new Lecturer(rset.getInt("user_no"),
									  rset.getString("user_name"),
									  rset.getString("mt_company"),
									  rset.getString("clcg_name"),
									  rset.getString("profile_path")						
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
	
	public ArrayList<Lecturer> selectListFour(Connection conn, String[] category) {
		ArrayList<Lecturer> list = new ArrayList<>();
		PreparedStatement pstmt = null;
		ResultSet rset = null;
		String sql = prop.getProperty("selectListFour");
		
		try {
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, category[0]);
			pstmt.setString(2, category[1]);
			pstmt.setString(3, category[2]);
			pstmt.setString(4, category[3]);
			
			rset = pstmt.executeQuery();
			
			while(rset.next()) {
				list.add(new Lecturer(rset.getInt("user_no"),
									  rset.getString("user_name"),
									  rset.getString("mt_company"),
									  rset.getString("clcg_name"),
									  rset.getString("profile_path")						
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
	
	public ArrayList<Lecturer> selectListFive(Connection conn, String[] category) {
		ArrayList<Lecturer> list = new ArrayList<>();
		PreparedStatement pstmt = null;
		ResultSet rset = null;
		String sql = prop.getProperty("selectListFive");
		
		try {
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, category[0]);
			pstmt.setString(2, category[1]);
			pstmt.setString(3, category[2]);
			pstmt.setString(4, category[3]);
			pstmt.setString(5, category[4]);
			
			rset = pstmt.executeQuery();
			
			while(rset.next()) {
				list.add(new Lecturer(rset.getInt("user_no"),
									  rset.getString("user_name"),
									  rset.getString("mt_company"),
									  rset.getString("clcg_name"),
									  rset.getString("profile_path")						
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
	
	public ArrayList<Lecturer> selectListSix(Connection conn, String[] category) {
		ArrayList<Lecturer> list = new ArrayList<>();
		PreparedStatement pstmt = null;
		ResultSet rset = null;
		String sql = prop.getProperty("selectListSix");
		
		try {
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, category[0]);
			pstmt.setString(2, category[1]);
			pstmt.setString(3, category[2]);
			pstmt.setString(4, category[3]);
			pstmt.setString(5, category[4]);
			pstmt.setString(6, category[5]);
			
			rset = pstmt.executeQuery();
			
			while(rset.next()) {
				list.add(new Lecturer(rset.getInt("user_no"),
									  rset.getString("user_name"),
									  rset.getString("mt_company"),
									  rset.getString("clcg_name"),
									  rset.getString("profile_path")						
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
	
	public ArrayList<MtQuestion> selectQna(Connection conn, int ltrNo) {
		ArrayList<MtQuestion> list = new ArrayList<>();
		PreparedStatement pstmt = null;
		ResultSet rset = null;
		String sql = prop.getProperty("selectQna");
		
		try {
			pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1, ltrNo);
			
			rset = pstmt.executeQuery();
			
			while(rset.next()) {
				list.add(new MtQuestion(rset.getInt("mt_que_no"),
										rset.getInt("que_user_no"),
										rset.getString("que_user_name"),
										rset.getString("que_date"),
										rset.getString("que_title"),
										rset.getString("que_content"),
										rset.getInt("ans_user_no"),
										rset.getString("ans_user_name"),
										rset.getString("ans_date"),
										rset.getString("ans_content")
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
	
	public int insertQuestion(Connection conn, MtQuestion mq) {
		int result = 0;
		PreparedStatement pstmt = null;
		String sql = prop.getProperty("insertQuestion");
		
		try {
			pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1, mq.getQueWriterNo());
			pstmt.setString(2, mq.getQueTitle());
			pstmt.setString(3, mq.getQueContent());
			pstmt.setInt(4, mq.getAnsWriterNo());
			
			result = pstmt.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			close(pstmt);
		}
		
		return result;
		
		
		
		
	}
	
	public ArrayList<Lecturer> selectMainMentorList(Connection conn){
		ArrayList<Lecturer> list = new ArrayList<>();
		
		PreparedStatement pstmt = null;
		ResultSet rset = null;
		
		String sql = prop.getProperty("selectMainMentorList");
		
		try {
			pstmt = conn.prepareStatement(sql);
			
			rset = pstmt.executeQuery();
			
			while(rset.next()) {
				list.add(new Lecturer(rset.getInt("user_no")
						            , rset.getString("user_name")
						            , rset.getString("mt_company")
						            , rset.getString("clcg_name")
						            , rset.getString("profile_path")));
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}finally {
			close(rset);
			close(pstmt);
		}
		
		return list;
	}
	public ArrayList<Lecturer> selectMainMentorList(Connection conn, String keyword){
		ArrayList<Lecturer> list = new ArrayList<>();
		
		PreparedStatement pstmt = null;
		ResultSet rset = null;
		
		String sql = prop.getProperty("selectMentorList");
		
		try {
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, "%" + keyword + "%");
			pstmt.setString(2, "%" + keyword + "%");
			pstmt.setString(3, "%" + keyword + "%");
			rset = pstmt.executeQuery();
			
			while(rset.next()) {
				list.add(new Lecturer(rset.getInt("user_no")
									, rset.getString("user_name")
						            , rset.getString("mt_company")
						            , rset.getString("profile_path")));
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}finally {
			close(rset);
			close(pstmt);
		}
		System.out.println(list);
		return list;
	}
}
