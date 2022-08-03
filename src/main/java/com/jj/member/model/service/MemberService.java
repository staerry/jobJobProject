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
	
	public int insertMentorTo_UserInfo_Mentor(Member m, Mentor mt){
		Connection conn = getConnection();
		
		int result1 = new MemberDao().insertMtoUserInfo(conn, m);
		int result2 = 0;
		
		if(mt != null) {
			result2 = new MemberDao().insertMtoMentor(conn, m, mt);
		}
		
		if(result1 > 0 && result2 > 0) {// 성공
			commit(conn);
		}else { // 실패
			rollback(conn);
		}
		 close(conn);
		
		return result1 * result2;
	}
	

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
	
	
	public Member updateInfo(String userId, String userPwd, String userNewPwd, String userEmail, String userPhone) {
		Connection conn = getConnection();
		int result = new MemberDao().updateInfo(conn, userId, userPwd, userNewPwd, userEmail, userPhone);
		
		Member updateMem = null;
		
		if(result > 0) {
			commit(conn);
			
			updateMem = new MemberDao().loginMember(conn, userId , userNewPwd);
			
		}else {
			rollback(conn);
		}
		
		close(conn);
		
		return updateMem;

	}
	
	/**
	 * 수강중인 강의 수 조회 요청을 처리해주는 메소드
	 * @param name : 조회할 멤버 명
	 * @return 수강중인 강의 수
	 * @author youngheonchoi
	 */
	public int selectClassIng(String name) {
		Connection conn = getConnection();
		int classIngCount = new MemberDao().selectClassIng(conn, name);
		close(conn);
		return classIngCount;
	}
	
}
