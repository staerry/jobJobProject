package com.jj.faq.model.service;

import static com.jj.common.JDBCTemplate.close;
import static com.jj.common.JDBCTemplate.commit;
import static com.jj.common.JDBCTemplate.getConnection;
import static com.jj.common.JDBCTemplate.rollback;

import java.sql.Connection;
import java.util.ArrayList;

import com.jj.faq.model.dao.FaqDao;
import com.jj.faq.model.vo.Faq;
import com.jj.faq.model.vo.MTM;

public class FaqService {
	
	public ArrayList<Faq> selectFaqList(){
		Connection conn = getConnection();
		ArrayList<Faq> list = new FaqDao().selectFaqList(conn);
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
	
	public ArrayList<Faq> selectNewFaqList(){
		Connection conn = getConnection();
		ArrayList<Faq> list = new FaqDao().selectNewFaqList(conn);
		close(conn);
		return list;
	}
	
	public ArrayList<Faq> selectCountFaqList(){
		Connection conn = getConnection();
		ArrayList<Faq> list = new FaqDao().selectCountFaqList(conn);
		close(conn);
		return list;
	}
	
}
