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

import com.jj.userMyPage.model.vo.Post;

public class PostListDao {
	
	Properties prop = new Properties();
	
	public PostListDao() {
		try {
			prop.loadFromXML(new FileInputStream(PostListDao.class.getResource("/db/sql/userMyPage-mapper.xml").getPath()));
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	public ArrayList<Post> selectMyPost(Connection conn, int userNo){
		
		ArrayList <Post> list = new ArrayList<>();
		PreparedStatement pstmt = null;
		ResultSet rset =null;
		
		String sql = prop.getProperty("selectMyPost");
		
		try {
			pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1, userNo);
			rset = pstmt.executeQuery();
			
			while(rset.next()) {
						
				list.add(new Post(rset.getInt("CM_NO")
						 , rset.getInt("CMCG_NO")
						 , rset.getString("CM_TITLE")
						 , rset.getString("CM_CONTENT")
						 , rset.getDate("CM_ENROLLDATE")
						 , rset.getInt("CM_COUNT")
						 , rset.getString("USER_NAME")
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
	
	
	}
	
	
	
	
	
	
	
	
	


