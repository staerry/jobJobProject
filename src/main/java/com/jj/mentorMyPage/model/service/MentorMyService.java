package com.jj.mentorMyPage.model.service;

import static com.jj.common.JDBCTemplate.close;
import static com.jj.common.JDBCTemplate.commit;
import static com.jj.common.JDBCTemplate.getConnection;
import static com.jj.common.JDBCTemplate.rollback;

import java.sql.Connection;
import java.util.ArrayList;
import java.util.List;

import com.jj.member.model.dao.MemberDao;
import com.jj.member.model.vo.Member;
import com.jj.mentorMyPage.model.dao.MentorMyDao;
import com.jj.mentorMyPage.model.vo.CreateClass;
import com.jj.mentorMyPage.model.vo.MtQuestion;
import com.jj.mentorMyPage.model.vo.Vod;
import com.jj.userMyPage.model.dao.ReplyListDao;
import com.jj.userMyPage.model.vo.Class;

public class MentorMyService {

	
	
	
	
	public int createClass(CreateClass cc,int userNo) {
		Connection conn = getConnection();
		int result = new MentorMyDao().CreateClass(conn, cc,userNo);

		if(result > 0) { 
			commit(conn);
		}else {
			rollback(conn);
		}
		
		close(conn);
		return result;
	}

	public ArrayList<CreateClass> selectClass(int userNo) {
		Connection conn = getConnection();
		ArrayList<CreateClass> list = new MentorMyDao().selectClass(conn, userNo);
		close(conn);
		
		return list;
	}

	public ArrayList<MtQuestion> selectAllQuestion(int userNo) {
		Connection conn = getConnection();
		ArrayList<MtQuestion> list = new MentorMyDao().selectAllQuestion(conn, userNo);
		return list;
	}

	public int insertVod(Vod vod) {
		Connection conn = getConnection();
		int result = new MentorMyDao().insertVod(conn, vod);
		
		close(conn);
		return result;
	}

	public int selectVodNo(int clNo) {
		Connection conn = getConnection();
		int vodNo = new MentorMyDao().selectVodNo(conn, clNo);
		return vodNo;
	}
	
	
	
//	멘토 마이클래스에서 하나의 강의만을 골라 회차업로드 
	public Class selectOneClass(int clNo) {
		Connection conn = getConnection();
		Class cls = new MentorMyDao().selectOneClass(conn, clNo);
		return cls;
	}

	public List<Vod> selectVodList(int clNo) {
		Connection conn = getConnection();
		List<Vod> list = new MentorMyDao().selectVodList(conn, clNo);
		
		return list;
	}
//	멘토 답변들 삭제
	public int deleteMyAns(int userNo, String replyNo) {
	
			
			Connection conn = getConnection();
			int result = new MentorMyDao().deleteMyAns(conn, userNo, replyNo);
			close(conn);
			return result;
		}

	
	}
 
