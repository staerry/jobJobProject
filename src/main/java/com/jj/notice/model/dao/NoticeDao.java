package com.jj.notice.model.dao;

import static com.jj.common.JDBCTemplate.close;

import java.io.FileInputStream;
import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Properties;

import com.jj.faq.model.dao.FaqDao;
import com.jj.notice.model.vo.Notice;
import com.jj.faq.model.vo.Faq;
import com.jj.faq.model.vo.PageInfoFaq;

public class NoticeDao {
	
	private Properties prop = new Properties();
	
	public NoticeDao() {
		try {
			prop.loadFromXML(new FileInputStream(FaqDao.class.getResource("/db/sql/notice-mapper.xml").getPath()));
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	public int selectListCount(Connection conn, String keyWord) {
		// select문 => ResultSet 한행 조회
		int listCount = 0;
		PreparedStatement pstmt = null;
		ResultSet rset = null;
		String sql = prop.getProperty("selectListCount");
		
		try {
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, '%' + keyWord + '%');
			pstmt.setString(2, '%' + keyWord + '%');
			rset = pstmt.executeQuery();
			
			if(rset.next()) {
				listCount = rset.getInt("COUNT");
			}
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally {
			close(rset);
			close(pstmt);
		}
		return listCount;
	}
	
	public ArrayList<Notice> selectNoticeList(Connection conn, PageInfoFaq pi, String keyWord){
		// select문 => result set에 담김 (여러행조회) => ArrayList<Faq>에 담음
		ArrayList<Notice> list = new ArrayList<>();
		PreparedStatement pstmt = null;
		ResultSet rset = null;
		String sql = prop.getProperty("selectNoticeList");
		
		try {
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, '%'+ keyWord + '%');
			pstmt.setString(2, '%'+ keyWord + '%');
			
			int startRow = (pi.getCurrentPage() - 1) * pi.getFaqLimit() + 1;
			int endRow = startRow + pi.getFaqLimit() - 1;
			pstmt.setInt(3, startRow);
			pstmt.setInt(4, endRow);
			
			rset = pstmt.executeQuery();
			
			while(rset.next()) {
				list.add(new Notice(rset.getInt("notice_no"),
								    rset.getString("user_id"),
								    rset.getString("notice_title"),
								    rset.getString("notice_content"),
								    rset.getInt("notice_count")
						));
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally {
			close(rset);
			close(pstmt);
		}
		return list;
	}
	
	public ArrayList<Notice> selectCountNoticeList(Connection conn, PageInfoFaq pi, String keyWord){
		// select문 => result set에 담김 (여러행조회) => ArrayList<Faq>에 담음
		ArrayList<Notice> list = new ArrayList<>();
		PreparedStatement pstmt = null;
		ResultSet rset = null;
		String sql = prop.getProperty("selectCountNoticeList");
		
		try {
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, '%' + keyWord + '%');
			pstmt.setString(2, '%' + keyWord + '%');
			
			int startRow = (pi.getCurrentPage() - 1) * pi.getFaqLimit() + 1;
			int endRow = startRow + pi.getFaqLimit() - 1;
			pstmt.setInt(3, startRow);
			pstmt.setInt(4, endRow);
			
			rset = pstmt.executeQuery();
			
			while(rset.next()) {
				list.add(new Notice(rset.getInt("notice_no"),
								 rset.getString("notice_title"),
								 rset.getInt("notice_count")
						));
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally {
			close(rset);
			close(pstmt);
		}
		return list;
	}
	
	public int increaseNoticeCount(Connection conn, int noticeNo) {
		// Update문 => 처리된 행수
		int result = 0;
		PreparedStatement pstmt = null;
		String sql = prop.getProperty("increaseNoticeCount");
		
		try {
			pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1, noticeNo);
			
			result = pstmt.executeUpdate();
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally {
			close(pstmt);
		}
		return result;
		}
	
	public Notice selectNotice(Connection conn, int noticeNo) {
		// select문 => ResultSet(한행) => Faq담음
		Notice n = null;
		PreparedStatement pstmt = null;
		ResultSet rset = null;
		String sql = prop.getProperty("selectNotice");
		
		try {
			pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1, noticeNo);
			
			rset = pstmt.executeQuery();
			
			if(rset.next()) {
				
				n = new Notice(rset.getInt("notice_no"),
						     rset.getString("notice_title"),
						     rset.getString("notice_content"),
							 rset.getString("user_id"),
							 rset.getDate("notice_enrolldate")
						);
			}
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally {
			close(rset);
			close(pstmt);
		}
		return n;
	}
	
}

