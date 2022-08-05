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

	public List<Bookmark> selectAllWishList(Member member) {
		Connection conn = getConnection();
		List<Bookmark> list = new UserClassDao().selectAllWishList(conn, member);
		close(conn);
		
		return list;
	}

	public ArrayList<ClassIng> selectClassIng(Member member) {
		return null;
	}

}
