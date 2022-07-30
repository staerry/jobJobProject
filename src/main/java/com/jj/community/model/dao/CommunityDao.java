package com.jj.community.model.dao;

import static com.jj.common.JDBCTemplate.close;

import java.io.FileInputStream;
import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Properties;

import com.jj.common.model.vo.PageInfo;
import com.jj.community.model.vo.Category;
import com.jj.community.model.vo.Community;
import com.jj.community.model.vo.Reply;

public class CommunityDao {
	
	Properties prop = new Properties();

	public CommunityDao() {
		try {
			prop.loadFromXML(new FileInputStream( CommunityDao.class.getResource("/db/sql/community-mapper.xml").getPath()));
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	public int selectListCount(Connection conn, int category) {
		// SELECT문 ==> ResultSet ==> int형 변수에 담아서 반환
		int listCount = 0;
		PreparedStatement pstmt = null;
		ResultSet rset = null;
		String sql = prop.getProperty("selectListCount");
		
		try {
			pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1, category);
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
	
	public ArrayList<Community> selectList(Connection conn, PageInfo pi, int category) {
		// SELECT ==> ResultSet ==> ArrayList
		ArrayList<Community> list = new ArrayList<>();
		PreparedStatement pstmt = null;
		ResultSet rset = null;
		String sql = prop.getProperty("selectList");	// 미완성된 sql
			
		int startRow = (pi.getCurrentPage() - 1) * pi.getBoardLimit() + 1;
		int endRow = startRow + pi.getBoardLimit() - 1;
		try {
			pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1, category);
			pstmt.setInt(2, startRow);
			pstmt.setInt(3, endRow);
			
			rset = pstmt.executeQuery();
			
			while(rset.next()) {
				list.add(new Community(rset.getInt("cm_no"),
									   rset.getString("user_name"),
									   rset.getString("cmcg_name"),
									   rset.getString("cm_title"),
									   rset.getString("cm_content"),
									   rset.getDate("cm_enrolldate"),
									   rset.getInt("cm_count"),
									   rset.getInt("cm_like_count"),
									   rset.getInt("replycount")
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
	
	public ArrayList<Category> selectCategoryList(Connection conn) {
		ArrayList<Category> list = new ArrayList<>();
		PreparedStatement pstmt = null;
		ResultSet rset = null;
		String sql = prop.getProperty("selectCategoryList");	// 완성
		
		try {
			pstmt = conn.prepareStatement(sql);
			rset = pstmt.executeQuery();
			
			while(rset.next()) {
				list.add(new Category(rset.getInt("cmcg_no"),
						 			  rset.getString("cmcg_name")
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
	
	public int insertCommunity(Connection conn, Community c) {
		int result = 0;
		PreparedStatement pstmt = null;
		String sql = prop.getProperty("insertCommunity");	// 미완성
		
		try {
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, c.getCommWriter());
			pstmt.setString(2, c.getCommCategory());
			pstmt.setString(3, c.getCommTitle());
			pstmt.setString(4, c.getCommContent());
			
			result = pstmt.executeUpdate();
			
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			close(pstmt);
		}
			
		return result;
	}
	
	public int increaseCount(Connection conn, int contentNo) {
		int result = 0;
		PreparedStatement pstmt = null;
		String sql = prop.getProperty("increaseCount");
		
		try {
			pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1, contentNo);
			result = pstmt.executeUpdate();
						
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			close(pstmt);
		}
				
		return result;
	}

	public Community selectCommunity(Connection conn, int contentNo) {
		Community c = null;
		PreparedStatement pstmt = null;
		ResultSet rset = null;
		String sql = prop.getProperty("selectCommunity");
		
		try {
			pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1, contentNo);
			rset = pstmt.executeQuery();
			if(rset.next()) {
				c = new Community(rset.getInt("cm_no"),
								  rset.getString("user_name"),
								  rset.getString("user_id"),
								  rset.getString("cmcg_name"),
								  rset.getString("cm_title"),
								  rset.getString("cm_content"),
								  rset.getDate("cm_enrolldate"),
								  rset.getInt("cm_count"),
								  rset.getInt("cm_like_count")
						);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			close(rset);
			close(pstmt);
		}
		
		return c;			
		
	}
	
	public int updateCommunity(Connection conn, Community c) {
		int result = 0;
		PreparedStatement pstmt = null;
		String sql = prop.getProperty("updateCommunity");
		
		try {
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, c.getCommTitle());
			pstmt.setString(2, c.getCommContent());
			pstmt.setInt(3, c.getCommNo());
			
			result = pstmt.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			close(pstmt);
		}
		
		System.out.println(result);
		return result;
	}
	
	public int deleteCommunity(Connection conn, int contentNo) {
		int result = 0;
		PreparedStatement pstmt = null;
		String sql = prop.getProperty("deleteCommunity");
		
		try {
			pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1, contentNo);
			
			result = pstmt.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		return result;
		
	}
	
	public ArrayList<Reply> selectReplyList(Connection conn, int contentNo) {
		ArrayList<Reply> list = new ArrayList<>();
		PreparedStatement pstmt = null;
		ResultSet rset = null;
		String sql = prop.getProperty("selectReplyList");
		
		try {
			pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1, contentNo);
			
			rset = pstmt.executeQuery();
			
			while(rset.next()) { 
				list.add(new Reply(rset.getInt("reply_no"),
								   rset.getString("cm_no"),
								   rset.getString("user_name"),
								   rset.getString("reply_content"),
								   rset.getString("reply_createdate")
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
}
