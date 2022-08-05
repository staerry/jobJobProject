package com.jj.notice.model.service;

import java.sql.Connection;
import java.util.ArrayList;

import static com.jj.common.JDBCTemplate.*;

import com.jj.faq.model.dao.FaqDao;
import com.jj.faq.model.vo.Faq;
import com.jj.faq.model.vo.PageInfoFaq;
import com.jj.notice.model.dao.NoticeDao;
import com.jj.notice.model.vo.Notice;

public class NoticeService {
	
	public int selectListCount(String keyWord) {
		Connection conn = getConnection();
		int listCount = new NoticeDao().selectListCount(conn, keyWord);
		close(conn);
		return listCount;
	}
	
	public ArrayList<Notice> selectNoticeList(PageInfoFaq pi, String keyWord){
		Connection conn = getConnection();
		ArrayList<Notice> list = new NoticeDao().selectNoticeList(conn, pi, keyWord);
		close(conn);
		return list;
	}
	
	public ArrayList<Notice> selectCountNoticeList(PageInfoFaq pi, String keyWord){
		Connection conn = getConnection();
		ArrayList<Notice> list = new NoticeDao().selectCountNoticeList(conn, pi, keyWord);
		close(conn);
		return list;
	}
	
	public int increaseNoticeCount(int noticeNo) {
		Connection conn = getConnection();
		int result = new NoticeDao().increaseNoticeCount(conn, noticeNo);
		
		if(result > 0) {
			commit(conn);
		}else {
			rollback(conn);
		}
		close(conn);
		return result;
		
	}
	
	public Notice selectNotice(int noticeNo) {
		Connection conn = getConnection();
		Notice n = new NoticeDao().selectNotice(conn, noticeNo);
		close(conn);
		return n;
	}

}
