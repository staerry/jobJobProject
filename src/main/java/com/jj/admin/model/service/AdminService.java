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
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
}
