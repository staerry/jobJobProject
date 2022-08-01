package com.jj.classSelect.model.service;

import static com.jj.common.JDBCTemplate.close;
import static com.jj.common.JDBCTemplate.getConnection;

import java.sql.Connection;
import java.util.ArrayList;

import com.jj.classSelect.model.dao.ClassDao;
import com.jj.classSelect.model.vo.Class;
import com.jj.community.model.vo.Review;

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
	
	public Class selectClass(int clNo) {
		Connection conn = getConnection();
		Class c = new ClassDao().selectClass(conn, clNo);
		close(conn);
		return c;
	}
	
	public int selectStudentCount(int clNo) {
		Connection conn = getConnection();
		int studentCount = new ClassDao().selectStudentCount(conn, clNo);
		close(conn);
		return studentCount;
	}
	
	public int selectBookmarkCount(int clNo) {
		Connection conn = getConnection();
		int bookmarkCount = new ClassDao().selectBookmarkCount(conn, clNo);
		close(conn);
		return bookmarkCount;
	}
	
	public ArrayList<Review> selectReview(int clNo) {
		Connection conn = getConnection();
		ArrayList<Review> list = new ClassDao().selectReview(conn, clNo);
		close(conn);
		return list;
	}
	
	public ArrayList<Class> selectListAllByPrice(){
		Connection conn = getConnection();
		ArrayList<Class> list = new ClassDao().selectListAllByPrice(conn);
		close(conn);
		return list;
	}
	
	public ArrayList<Class> selectListByPrice(String category){
		Connection conn = getConnection();
		ArrayList<Class> list = new ClassDao().selectListByPrice(conn, category);
		close(conn);
		return list;
	}
	
	public ArrayList<Class> selectListAllByScore() {
		Connection conn = getConnection();
		ArrayList<Class> list = new ClassDao().selectListAllByScore(conn);
		close(conn);
		return list;
		
	}
	
	public ArrayList<Class> selectListByScore(String category) {
		Connection conn = getConnection();
		ArrayList<Class> list = new ClassDao().selectListByScore(conn, category);
		close(conn);
		return list;
	}
}
