package com.jj.community.model.service;

import static com.jj.common.JDBCTemplate.*;
import static com.jj.common.JDBCTemplate.getConnection;

import java.sql.Connection;
import java.util.ArrayList;

import com.jj.common.model.vo.PageInfo;
import com.jj.community.model.dao.CommunityDao;
import com.jj.community.model.vo.Category;
import com.jj.community.model.vo.Community;

public class CommunityService {
	
	public int selectListCount(int category) {
		Connection conn = getConnection();
		int listCount = new CommunityDao().selectListCount(conn, category);
		close(conn);
		return listCount;
	}

	public ArrayList<Community> selectList(PageInfo pi, int category) {
		Connection conn = getConnection();
		ArrayList<Community> list = new CommunityDao().selectList(conn, pi, category);
		close(conn);
		return list;
	}
	
	public ArrayList<Category> selectCategoryList() {
		Connection conn = getConnection();
		ArrayList<Category> list = new CommunityDao().selectCategoryList(conn);
		close(conn);
		return list;
	}
	
	public int insertCommunity(Community c) {
		Connection conn = getConnection();
		int result = new CommunityDao().insertCommunity(conn, c);

		if(result > 0) {
			commit(conn);
		}else {
			rollback(conn);
		}
		
		return result;
	}
}
