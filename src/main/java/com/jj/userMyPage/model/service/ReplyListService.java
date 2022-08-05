package com.jj.userMyPage.model.service;

import java.sql.Connection;
import java.util.ArrayList;

import com.jj.userMyPage.model.dao.PostListDao;
import com.jj.userMyPage.model.dao.ReplyListDao;
import com.jj.userMyPage.model.vo.Reply;

import static com.jj.common.JDBCTemplate.*;

public class ReplyListService {
	
	public ArrayList<Reply> selectMyReply(int userNo){
		
		Connection conn = getConnection();
		ArrayList<Reply> list = new ReplyListDao().selectMyReply(conn, userNo);
		close(conn);
		return list;
		
	}
	
	public int deleteMyReply(int userNo, String replyNo) {
		
		Connection conn = getConnection();
		int result = new ReplyListDao().deleteMyReply(conn, userNo, replyNo);
		close(conn);
		return result;
	}
}
