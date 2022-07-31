package com.jj.classSelect.model.service;

import static com.jj.common.JDBCTemplate.*;

import java.sql.Connection;
import java.util.ArrayList;

import com.jj.classSelect.model.dao.ClassDao;
import com.jj.classSelect.model.vo.Class;

public class ClassService {
	
	public int selectListCountAll() {
		Connection conn = getConnection();
		int listCount = new ClassDao().selectListCountAll(conn);
		close(conn);
		return listCount;
	}
	
	public int selectListCount(String category) {
		Connection conn = getConnection();
		int listCount = new ClassDao().selectListCount(conn, category);
		close(conn);
		return listCount;
	}
	
	public ArrayList<Class> selectListAll() {
		Connection conn = getConnection();
		ArrayList<Class> list = new ClassDao().selectListAll(conn);
		close(conn);
		return list;
	}

	public ArrayList<Class> selectList(String category) {
		Connection conn = getConnection();
		ArrayList<Class> list = new ClassDao().selectList(conn, category);
		close(conn);
		return list;
	}
}
