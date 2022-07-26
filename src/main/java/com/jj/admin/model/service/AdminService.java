package com.jj.admin.model.service;

import static com.jj.common.JDBCTemplate.*;

import java.sql.Connection;

import com.jj.admin.model.dao.AdminDao;
import com.jj.admin.model.vo.UserInfoAd;

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
}
