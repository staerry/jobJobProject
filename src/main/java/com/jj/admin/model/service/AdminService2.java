package com.jj.admin.model.service;

import static com.jj.common.JDBCTemplate.close;
import static com.jj.common.JDBCTemplate.commit;
import static com.jj.common.JDBCTemplate.getConnection;
import static com.jj.common.JDBCTemplate.rollback;

import java.sql.Connection;
import java.util.ArrayList;

import com.jj.admin.model.dao.AdminDao;
import com.jj.admin.model.dao.AdminDao2;
import com.jj.admin.model.vo.UserInfoAd;
import com.jj.common.model.vo.PageInfo;
import com.jj.faq.model.vo.Faq;
import com.jj.member.model.vo.Member;
import com.jj.notice.model.vo.Notice;

/**
 * @author PC
 *
 */
public class AdminService2 {
	
	public UserInfoAd loginAdmin(String adminId,String adminPwd) {
		Connection conn = getConnection();
		UserInfoAd u = new AdminDao().loginAdmin(conn,adminId,adminPwd);
		close(conn);
		return u;
	}
	
	/**
	 * FAQ작성 요청을 처리해주는 메소드
	 * @param faqTitle : 추가할 FAQ제목
	 * @param faqContent : 추가할 FAQ내용
	 * @param userId : 작성자 
	 * @return 업데이트된 행 갯수 반환
	 * @author younheonchoi 
	 */
	public int insertFaq(String faqTitle, String faqContent, int userId) {
		Connection conn = getConnection();
		
		int result = new AdminDao().insertFaq(conn, faqTitle, faqContent, userId);
		
		if(result > 0) {
			commit(conn);
		}else {
			rollback(conn);
		}
		
		close(conn);
		
		return result;
	}
	
	/**
	 * FAQ목록 갯수 확인 요청을 처리해주는 메소드
	 * @return FAQ게시물 총 갯수 반환
	 * @author younheonchoi 
	 */
	public int selectFaqCount() {
		Connection conn = getConnection();
		
		int listCount = new AdminDao().selectFaqCount(conn);
		
		close(conn);
		
		return listCount;
	}
	
	/**
	 * FAQ게시물 리스트 조회 요청을 처리해주는 메소드
	 * @param pageInfo : 페이징버튼 객체
	 * @return FAQ게시글 리스트
	 * @author younheonchoi 
	 */
	public ArrayList<Faq> selectFaqList(PageInfo pageInfo){
		Connection conn = getConnection();
		
		ArrayList<Faq> list = new AdminDao().selectFaqList(conn, pageInfo);
		
		close(conn);
		
		return list;
	}
	
	/**
	 * FAQ게시글 삭제 요청을 처리해주는 메소드
	 * @param faqNo : 삭제할 대상 게시글 번호
	 * @return 업데이트된 행 갯수 반환
	 * @author younheonchoi 
	 */
	public int deleteFaq(int faqNo) {
		Connection conn = getConnection();
		
		int result = new AdminDao().deleteFaq(conn, faqNo);
		
		if(result > 0) {
			commit(conn);
		}else {
			rollback(conn);
		}
		
		close(conn);
		
		return result;
	}
	
	/**
	 * FAQ수정 페이지에 출력할 게시물 조회 요청을 처리해주는 메소드
	 * @param faqNo : 수정할 대상 게시글 번호
	 * @return FAQ게시글
	 * @author younheonchoi 
	 */
	public Faq selectFaq(int faqNo) {
		Connection conn = getConnection();
		
		Faq faq = new AdminDao().selectFaq(conn, faqNo);
		
		close(conn);
		
		return faq;
	}
	
	/**
	 * FAQ수정 요청을 처리해주는 메소드
	 * @param faq : 수정한 게시글 정보
	 * @return 업데이트된 행 갯수 반환
	 * @author younheonchoi 
	 */
	public int updateFaq(Faq faq) {
		Connection conn = getConnection();
		
		int result = new AdminDao().updateFaq(conn, faq);
		
		if(result > 0) {
			commit(conn);
		}else {
			rollback(conn);
		}
		
		close(conn);
		
		return result;
	}
	
	/**
	 * 공지사항 총 게시물 갯수 조회 요청을 처리해주는 메소드
	 * @return 공지사항 게시물 총 갯수
	 * @author younheonchoi 
	 */
	public int selectNoticeCount() {
		Connection conn = getConnection();
		
		int listCount = new AdminDao().selectNoticeCount(conn);
		
		close(conn);
		
		return listCount;
	}
	
	/**
	 * 사용자가 입력한 키워드에맞는 활동중인 수강생수를 찾는 메소드
	 * @return 활동중인 수강생수
	 * @author SJW
	 */
	public int selectStudentListCount(String search) {
		Connection conn = getConnection();
		int listCount = new AdminDao2().selectStudentListCount(conn,search);
		close(conn);
		
		return listCount;
	}
	
	
	/**
	 * 사용자가 입력한 키워드에맞는 모든 수강생수를 찾는메소드
	 * @param search 사용자가 입력한 키워드
	 * @return 사용자가 입력한 키워드에맞는 모든 수강생수
	 * @SJW
	 */
	public int stuListCountSearch(String search) {
		Connection conn = getConnection();
		int listCount = new AdminDao2().stuListCountSearch(conn,search);
		close(conn);
		
		return listCount;
	}
	
	/**
	 * 사용자가 입력한 키워드에맞는 탈퇴한 수강생수를 찾는메소드
	 * @param search 사용자가 입력한 키워드
	 * @return 사용자가 입력한 키워드에맞는 탈퇴한 수강생수
	 * @author SJW
	 */
	public int stuInfoOutCount(String search) {
		Connection conn = getConnection();
		int listCount = new AdminDao2().stuInfoOutCount(conn,search);
		close(conn);
		
		return listCount;
	}
	
	/**
	 * 활동중인 수강생리스트를 페이지에 맞춰서 찾는메소드
	 * @param pi 페이지정보를 담고있는 객체
	 * @return 페이지에 맞는 활동중인 수강생 리스트
	 * @author SJW
	 */
	public ArrayList<Member> studentInfo(PageInfo pi,String search){
		Connection conn = getConnection();
		ArrayList<Member> list = new AdminDao2().studentInfo(conn,pi,search);
		close(conn);
		return list;
	}
	
	/**
	 * 사용자가 입력한 키워드에맞는 모든 수강생리스트를 페이지에 맞춰서 찾는메소드
	 * @param pi 페이지정보를 담고있는 객체
	 * @param search 사용자가 입력한 키워드
	 * @return 페이지에 맞는 활동중인 수강생 리스트
	 * @author SJW
	 */
	public ArrayList<Member> stuInfoAll(PageInfo pi,String search){
		Connection conn = getConnection();
		ArrayList<Member> list = new AdminDao2().stuInfoAll(conn,pi,search);
		close(conn);
		return list;
	}
	
	/**
	 * 사용자가 입력한 키워드에맞는 모든 수강생리스트를 페이지에 맞춰서 찾는메소드
	 * @param pi 페이지정보를 담고있는 객체
	 * @param search 사용자가 입력한 키워드
	 * @return 페이지에 맞는 활동중인 수강생 리스트
	 * @SJW
	 */
	public ArrayList<Member> stuInfoOutSearch(PageInfo pi,String search){
		Connection conn = getConnection();
		ArrayList<Member> list = new AdminDao2().stuInfoOutSearch(conn,pi,search);
		close(conn);
		return list;
	}
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
}
