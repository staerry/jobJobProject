package com.jj.member.model.service;

import static com.jj.common.JDBCTemplate.close;
import static com.jj.common.JDBCTemplate.commit;
import static com.jj.common.JDBCTemplate.getConnection;
import static com.jj.common.JDBCTemplate.rollback;

import java.sql.Connection;

import com.jj.member.model.dao.MemberDao;
import com.jj.member.model.vo.Member;
import com.jj.member.model.vo.Mentor;

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
		
		if(result > 0) { 
			commit(conn);
		}else {
			rollback(conn);
		}
		
		close(conn);
		return result;	
	}
	
	public int idCheck(String checkId) {
		Connection conn = getConnection();
		int count = new MemberDao().idCheck(conn, checkId);
		close(conn);
		return count;		
	}
	

	public int insertMentorToUserInfo(Member m) {
		Connection conn = getConnection();
		int result = new MemberDao().insertMentorToUserInfo(conn, m);
		
		if(result > 0) {
			commit(conn);
		}else {
			rollback(conn);
		}
		close(conn);
		return result;
	}
	
	public int insertMentor(Member m, Mentor mt) {
		
		Connection conn = getConnection();
		
		int result1 = new MemberDao().insertMentor(conn, m, mt); 
		
		int result2 = 1;
		int result3 = 1;
		if(mt != null) { // 첨부파일이 있을 경우 // 근데 required로 항상 첨부파이 받아오는데 if문 필요한가?
			result2 = new MemberDao().insertEmpCardAttachment(conn, m, mt);
			result3 = new MemberDao().insertIdCardAttachment(conn, m, mt);
		}
		
		if(result1 > 0 && result2 > 0 && result3 > 0) {// 성공
			commit(conn);
		}else {// 실패
			rollback(conn);
		}
		close(conn);
		
		return result1 * result2 * result3;
	}
	
	/*
	public int deleteMember(String userId, String userPwd) {
		Connection conn = getConnection();
		int result = new MemberDao().deleteMember(conn, userId, userPwd);
		
		if(result > 0) {
			commit(conn);
		}else {
			rollback(conn);
		}
		
		close(conn);
		
		return result;
		
	}
	
	public int updateInfo(String userId, String userPwd, String userNewPwd, String userCheckPwd, String email, String phone) {
		Connection conn = getConnection();
		int result = new MemberDao().deleteMember(conn, userId, userPwd);
		
		if(result > 0) {
			commit(conn);
		}else {
			rollback(conn);
		}
		
		close(conn);
		
		return result;
	}*/
	
}
