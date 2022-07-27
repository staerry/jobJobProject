package com.jj.admin.model.service;

import static com.jj.common.JDBCTemplate.close;
import static com.jj.common.JDBCTemplate.commit;
import static com.jj.common.JDBCTemplate.getConnection;
import static com.jj.common.JDBCTemplate.rollback;

import java.sql.Connection;
import java.util.ArrayList;

import com.jj.admin.model.dao.AdminDao;
import com.jj.admin.model.vo.UserInfoAd;
import com.jj.common.model.vo.PageInfo;
import com.jj.faq.model.vo.Faq;
import com.jj.member.model.vo.Member;

public class AdminService {
	
	public UserInfoAd loginAdmin(String adminId,String adminPwd) {
		Connection conn = getConnection();
		UserInfoAd u = new AdminDao().loginAdmin(conn,adminId,adminPwd);
		close(conn);
		return u;
	}
	
	public int insertFaq(String faqTitle, String faqContent, int userId) {
		Connection conn = getConnection();
		
		int result = new AdminDao().insertFaq(conn, faqTitle, faqContent, userId);
		
		if(result > 0) {
			commit(conn);
		}else {
			rollback(conn);
		}
		
		close(conn);
		
		return result;
	}
	
	public int selectFaqCount() {
		Connection conn = getConnection();
		
		int listCount = new AdminDao().selectFaqCount(conn);
		
		close(conn);
		
		return listCount;
		
	}
	
	public ArrayList<Faq> selectFaqList(PageInfo pageInfo){
		Connection conn = getConnection();
		
		ArrayList<Faq> list = new AdminDao().selectFaqList(conn, pageInfo);
		
		close(conn);
		
		return list;
	}
	
	public int deleteFaq(int faqNo) {
		Connection conn = getConnection();
		
		int result = new AdminDao().deleteFaq(conn, faqNo);
		
		if(result > 0) {
			commit(conn);
		}else {
			rollback(conn);
		}
		
		close(conn);
		
		return result;
	}
	
	public Faq selectFaq(int faqNo) {
		Connection conn = getConnection();
		
		Faq faq = new AdminDao().selectFaq(conn, faqNo);
		
		close(conn);
		
		return faq;
	}
	
	public int updateFaq(Faq faq) {
		Connection conn = getConnection();
		
		int result = new AdminDao().updateFaq(conn, faq);
		
		if(result > 0) {
			commit(conn);
		}else {
			rollback(conn);
		}
		
		close(conn);
		
		return result;
	}
	
	public int selectNoticeCount() {
		Connection conn = getConnection();
		
		int listCount = new AdminDao().selectNoticeCount(conn);
		
		close(conn);
		
		return listCount;
	}
	
	/**
	 * 활동중인 수강생수를 찾는 메소드
	 * @return 활동중인 수강생수
	 * @author SJW
	 */
	public int selectStudentListCount() {
		Connection conn = getConnection();
		int listCount = new AdminDao().selectStudentListCount(conn);
		close(conn);
		
		return listCount;
	}
	
	/**
	 * 활동중인 수강생리스트를 페이지에 맞춰서 찾는메소드
	 * @param pi 페이지정보를 담고있는 객체
	 * @return 페이지에 맞는 활동중인 수강생 리스트
	 * @author SJW
	 */
	public ArrayList<Member> studentInfo(PageInfo pi){
		Connection conn = getConnection();
		ArrayList<Member> list = new AdminDao().studentInfo(conn,pi);
		close(conn);
		return list;
	}
	

	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
}
