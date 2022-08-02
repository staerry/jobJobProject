package com.jj.mentorSelect.model.service;

import static com.jj.common.JDBCTemplate.*;
import static com.jj.common.JDBCTemplate.getConnection;

import java.sql.Connection;
import java.util.ArrayList;

import com.jj.classSelect.model.vo.Class;
import com.jj.mentorSelect.model.dao.LecturerDao;
import com.jj.mentorSelect.model.vo.Lecturer;
import com.jj.mentorSelect.model.vo.MtQuestion;

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
	
	public Lecturer selectLecturer(int lecNo) {
		Connection conn = getConnection();
		Lecturer l = new LecturerDao().selectLecturer(conn, lecNo);
		close(conn);
		return l;
	}
	
	public ArrayList<Class> selectClass(int lecNo) {
		Connection conn = getConnection();
		ArrayList<Class> classList = new LecturerDao().selectClass(conn, lecNo);
		close(conn);
		return classList;
	}
			
	public int selectListCountOne(String[] category) {
		Connection conn = getConnection();
		int listCount = new LecturerDao().selectListCountOne(conn, category);
		close(conn);
		return listCount;
	}
	
	public int selectListCountTwo(String[] category) {
		Connection conn = getConnection();
		int listCount = new LecturerDao().selectListCountTwo(conn, category);
		close(conn);
		return listCount;
	}
	
	public int selectListCountThree(String[] category) {
		Connection conn = getConnection();
		int listCount = new LecturerDao().selectListCountThree(conn, category);
		close(conn);
		return listCount;
	}
	
	public int selectListCountFour(String[] category) {
		Connection conn = getConnection();
		int listCount = new LecturerDao().selectListCountFour(conn, category);
		close(conn);
		return listCount;
	}
	
	public int selectListCountFive(String[] category) {
		Connection conn = getConnection();
		int listCount = new LecturerDao().selectListCountFive(conn, category);
		close(conn);
		return listCount;
	}
	
	public int selectListCountSix(String[] category) {
		Connection conn = getConnection();
		int listCount = new LecturerDao().selectListCountSix(conn, category);
		close(conn);
		return listCount;
	}
	
	public ArrayList<Lecturer> selectListOne(String[] category) {
		Connection conn = getConnection();
		ArrayList<Lecturer> list = new LecturerDao().selectListOne(conn, category);
		close(conn);
		return list;
	}
	
	public ArrayList<Lecturer> selectListTwo(String[] category) {
		Connection conn = getConnection();
		ArrayList<Lecturer> list = new LecturerDao().selectListTwo(conn, category);
		close(conn);
		return list;
	}
	
	public ArrayList<Lecturer> selectListThree(String[] category) {
		Connection conn = getConnection();
		ArrayList<Lecturer> list = new LecturerDao().selectListThree(conn, category);
		close(conn);
		return list;
	}
	
	public ArrayList<Lecturer> selectListFour(String[] category) {
		Connection conn = getConnection();
		ArrayList<Lecturer> list = new LecturerDao().selectListFour(conn, category);
		close(conn);
		return list;
	}
	
	public ArrayList<Lecturer> selectListFive(String[] category) {
		Connection conn = getConnection();
		ArrayList<Lecturer> list = new LecturerDao().selectListFive(conn, category);
		close(conn);
		return list;
	}
	
	public ArrayList<Lecturer> selectListSix(String[] category) {
		Connection conn = getConnection();
		ArrayList<Lecturer> list = new LecturerDao().selectListSix(conn, category);
		close(conn);
		return list;
	}
	
	public ArrayList<MtQuestion> selectQna(int ltrNo) {
		Connection conn = getConnection();
		ArrayList<MtQuestion> list = new LecturerDao().selectQna(conn, ltrNo);
		close(conn);
		return list;
	}
	
	public int insertQuestion(MtQuestion mq) {
		Connection conn = getConnection();
		int result = new LecturerDao().insertQuestion(conn, mq);
		if(result > 0) {
			commit(conn);
		}else {
			rollback(conn);
		}
		close(conn);
		return result;
	}
}
