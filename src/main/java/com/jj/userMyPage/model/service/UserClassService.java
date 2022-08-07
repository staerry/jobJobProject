package com.jj.userMyPage.model.service;

import static com.jj.common.JDBCTemplate.*;

import java.sql.Connection;
import java.util.ArrayList;
import java.util.List;

import com.jj.member.model.vo.Member;
import com.jj.mentorMyPage.model.vo.Vod;
import com.jj.userMyPage.model.dao.UserClassDao;
import com.jj.userMyPage.model.vo.Bookmark;
import com.jj.userMyPage.model.vo.Class;
import com.jj.userMyPage.model.vo.ClassIng;
import com.jj.userMyPage.model.vo.Review;

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
	public List<Vod> selectVodListByClNo(int clNo) {
		Connection conn = getConnection();
		List<Vod> list = new UserClassDao().selectVodListByClNo(conn, clNo);
		close(conn);
		
		return list;
	}
	public Vod selectOneVod(int vodNo) {
		Connection conn = getConnection();
		Vod vod = new UserClassDao().selectOneVod(conn, vodNo); 
		close(conn);
		
		return vod;
	}

	public Class selectClassInfo(int clNo) {
		Connection conn = getConnection();
		Class cls = new UserClassDao().selectClassInfo(conn, clNo); 
		close(conn);
		
		return cls;
	}
	public int insertReview(Review review) {
		Connection conn = getConnection();
		int result = new UserClassDao().insertReview(conn, review); 
		close(conn);
		return result;
	}
	public int selectReviewCount(int clNo) {
		Connection conn = getConnection();
		int count = new UserClassDao().selectReviewCount(conn, clNo); 
		close(conn);
		
		return count;
	}

}
