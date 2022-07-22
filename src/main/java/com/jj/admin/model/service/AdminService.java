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
}
