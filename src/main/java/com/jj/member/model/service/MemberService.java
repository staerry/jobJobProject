package com.jj.member.model.service;

import static com.jj.common.JDBCTemplate.*;

import java.sql.Connection;

import com.jj.member.model.dao.MemberDao;
import com.jj.member.model.vo.Member;

public class MemberService {
	
	public Member loginMember(String userId, String userPwd) {
		Connection conn = getConnection();
		Member m = new MemberDao().loginMember(conn, userId, userPwd);
		close(conn);
		return m;
	}

	public int insertMember(Member m) {
		Connection conn = getConnection();
		int result = new MemberDao().insertMember(conn, m);
		
		if(result > 0) { // result가 0보다 클 경우 뭔가가 삽입 insert된 것
			commit(conn);
		}else {
			rollback(conn);
		}
		
		close(conn);
		return result;	
	}

}
