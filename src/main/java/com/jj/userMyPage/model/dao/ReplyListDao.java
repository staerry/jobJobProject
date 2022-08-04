package com.jj.userMyPage.model.dao;

import java.io.FileInputStream;
import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Properties;
import static com.jj.common.JDBCTemplate.*;

import com.jj.userMyPage.model.vo.Reply;

public class ReplyListDao {
	
	Properties prop = new Properties();
	
	public ReplyListDao() {
		try {
			prop.loadFromXML(new FileInputStream(ReplyListDao.class.getResource("/db/sql/userMyPage-mapper.xml").getPath()));
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	public ArrayList<Reply> selectMyReply(Connection conn, int userNo){
		
		ArrayList <Reply> list = new ArrayList<>();
		PreparedStatement pstmt = null;
		ResultSet rset =null;
		
		String sql = prop.getProperty("selectMyReply");
		
		try {
			pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1, userNo);
			rset = pstmt.executeQuery();
			
			while(rset.next()) {
						
				list.add(new Reply(rset.getInt("REPLY_NO")
								 , rset.getInt("CM_NO")
								 , rset.getString("REPLY_CONTENT")
								 , rset.getDate("REPLY_ENROLLDATE")
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
	
	public int deleteMyPost(Connection conn, int userNo, String replyNo) {
		
		System.out.println(userNo);
		System.out.println(replyNo);
		
		int result = 0;
		PreparedStatement pstmt = null;
		String sql = prop.getProperty("deleteMyReply");
		
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
	}
	
	
	
	
	
	
	
	
	


