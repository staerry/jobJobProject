package com.jj.userMyPage.model.service;

import java.sql.Connection;
import java.util.ArrayList;

import com.jj.userMyPage.model.dao.PostListDao;
import com.jj.userMyPage.model.vo.Post;

import static com.jj.common.JDBCTemplate.*;

public class PostListService {
	
	public ArrayList<Post> selectMyPost(int userNo){
		
		Connection conn = getConnection();
		ArrayList<Post> list = new PostListDao().selectMyPost(conn, userNo);
		close(conn);
		return list;
		
	}
	

	public int deleteMyPost(int userNo, String cmNo) {
		
		Connection conn = getConnection();
		int result = new PostListDao().deleteMyPost(conn, userNo, cmNo);
		close(conn);
		return result;
	}
}
