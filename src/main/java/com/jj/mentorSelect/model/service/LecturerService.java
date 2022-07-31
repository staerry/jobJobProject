package com.jj.mentorSelect.model.service;

import static com.jj.common.JDBCTemplate.close;
import static com.jj.common.JDBCTemplate.getConnection;

import java.sql.Connection;
import java.util.ArrayList;

import com.jj.mentorSelect.model.dao.LecturerDao;
import com.jj.mentorSelect.model.vo.Lecturer;

public class LecturerService {

	public int selectListCount() {
		Connection conn = getConnection();
		int listCount = new LecturerDao().selectListCount(conn);
		close(conn);
		return listCount;
		
	}
	
	public ArrayList<Lecturer> selectList() {
		Connection conn = getConnection();
		ArrayList<Lecturer> list = new LecturerDao().selectList(conn);
		close(conn);
		return list;
	}
}
