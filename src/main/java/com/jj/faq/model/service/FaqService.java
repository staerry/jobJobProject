package com.jj.faq.model.service;

import static com.jj.common.JDBCTemplate.*;

import java.sql.Connection;
import java.util.ArrayList;

import com.jj.faq.model.vo.PageInfoFaq;
import com.jj.faq.model.dao.FaqDao;
import com.jj.faq.model.vo.Faq;
import com.jj.faq.model.vo.MTM;

public class FaqService {
	
	public ArrayList<Faq> selectFaqList(PageInfoFaq pi, String searchWord){
		Connection conn = getConnection();
		ArrayList<Faq> list = new FaqDao().selectFaqList(conn, pi, searchWord);
		close(conn);
		return list;
	}
	
	public int insertMTM(MTM m) {
		Connection conn = getConnection();
		int result = new FaqDao().insertMTM(conn, m);
		
		if(result > 0) {
			commit(conn);
		}else {
			rollback(conn);
		}
		close(conn);
		return result;
	}
	
	public int increaseCount(int faqNo) {
		Connection conn = getConnection();
		int result = new FaqDao().increaseCount(conn, faqNo);
		
		if(result > 0) {
			commit(conn);
		}else {
			rollback(conn);
		}
		close(conn);
		return result;
	}
	 
	public Faq selectFaq(int faqNo) {
		Connection conn = getConnection();
		Faq fq = new FaqDao().selectFaq(conn, faqNo);
		close(conn);
		return fq;
	}
	
	public ArrayList<Faq> selectCountFaqList(PageInfoFaq pi, String searchWord){
		Connection conn = getConnection();
		ArrayList<Faq> list = new FaqDao().selectCountFaqList(conn, pi, searchWord);
		close(conn);
		return list;
	}
	
	public int selectListCount(String searchWord) {
		Connection conn = getConnection();
		int listCount = new FaqDao().selectListCount(conn, searchWord);
		close(conn);
		return listCount;
	}
	
}
