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
import com.jj.community.model.vo.Community;

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
	

}
