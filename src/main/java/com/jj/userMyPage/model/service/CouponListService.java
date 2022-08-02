package com.jj.userMyPage.model.service;

import java.sql.Connection;
import java.util.ArrayList;

import com.jj.userMyPage.model.dao.CouponListDao;
import com.jj.userMyPage.model.vo.UCoupon;
import static com.jj.common.JDBCTemplate.*;

public class CouponListService {
	
	public ArrayList<UCoupon> selectListCp(int userNo){
		
		Connection conn = getConnection();
		ArrayList<UCoupon> list = new CouponListDao().selectListCp(conn, userNo);
		close(conn);
		return list;
		
	}
	
	public int countCp(int userNo) {
		
		 Connection conn = getConnection();
		int result = new CouponListDao().countCp(conn, userNo);
		close(conn);
		 
		 
		 return result;
		
	}

}
