package com.jj.userMyPage.model.service;

import static com.jj.common.JDBCTemplate.*;

import java.sql.Connection;
import java.util.ArrayList;
import java.util.List;

import com.jj.member.model.vo.Member;
import com.jj.userMyPage.model.dao.UserClassDao;
import com.jj.userMyPage.model.vo.Bookmark;
import com.jj.userMyPage.model.vo.ClassIng;

public class UserClassService {

	//4개만 검색
	public List<Bookmark> selectWishList(Member member) {
		Connection conn = getConnection();
		List<Bookmark> list = new UserClassDao().selectWishList(conn, member);
		close(conn);
		
		return list;
	}
	public List<Bookmark> selectWishAllList(Member member) {
		Connection conn = getConnection();
		List<Bookmark> list = new UserClassDao().selectWishAllList(conn, member);
		close(conn);
		
		return list;
	}

	//4개만 검색
	public List<ClassIng> selectClassingList(Member member) {
		Connection conn = getConnection();
		List<ClassIng> list = new UserClassDao().selectClassingList(conn, member);
		close(conn);
		
		return list;
	}

	public List<ClassIng> selectClassIngAllList(Member member) {
		Connection conn = getConnection();
		List<ClassIng> list = new UserClassDao().selectClassIngAllList(conn, member);
		close(conn);
		
		return list;
	}

}
