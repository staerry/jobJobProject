package com.jj.mentorMyPage.model.service;

import static com.jj.common.JDBCTemplate.close;
import static com.jj.common.JDBCTemplate.commit;
import static com.jj.common.JDBCTemplate.getConnection;
import static com.jj.common.JDBCTemplate.rollback;

import java.sql.Connection;

import com.jj.member.model.dao.MemberDao;
import com.jj.member.model.vo.Member;
import com.jj.mentorMyPage.model.dao.MentorMyDao;
import com.jj.mentorMyPage.model.vo.CreateClass;

public class MentorMyService {

	
	
	
	
	public int createClass(CreateClass cc,int userNo) {
		Connection conn = getConnection();
		int result = new MentorMyDao().CreateClass(conn, cc,userNo);

		if(result > 0) { 
			commit(conn);
		}else {
			rollback(conn);
		}
		
		close(conn);
		return result;
	}

	
}
