package com.jj.admin.model.service;

import static com.jj.common.JDBCTemplate.close;
import static com.jj.common.JDBCTemplate.commit;
import static com.jj.common.JDBCTemplate.getConnection;
import static com.jj.common.JDBCTemplate.rollback;

import java.sql.Connection;
import java.util.ArrayList;

import com.jj.admin.model.dao.AdminDao;
import com.jj.admin.model.vo.UserInfoAd;
import com.jj.common.model.vo.PageInfo;
import com.jj.community.model.vo.Reply;
import com.jj.faq.model.vo.Faq;
import com.jj.member.model.vo.Member;
import com.jj.mtm.model.vo.Mtm;
import com.jj.notice.model.vo.Notice;

/**
 * @author PC
 *
 */
public class AdminService {
	
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
	 * 활동중인 수강생수를 찾는 메소드
	 * @return 활동중인 수강생수
	 * @author SJW
	 */
	public int selectStudentListCount() {
		Connection conn = getConnection();
		int listCount = new AdminDao().selectStudentListCount(conn);
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
		int listCount = new AdminDao().stuListCountSearch(conn,search);
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
		int listCount = new AdminDao().stuInfoOutCount(conn,search);
		close(conn);
		
		return listCount;
	}
	
	/**
	 * 활동중인 수강생리스트를 페이지에 맞춰서 찾는메소드
	 * @param pi 페이지정보를 담고있는 객체
	 * @return 페이지에 맞는 활동중인 수강생 리스트
	 * @author SJW
	 */
	public ArrayList<Member> studentInfo(PageInfo pi){
		Connection conn = getConnection();
		ArrayList<Member> list = new AdminDao().studentInfo(conn,pi);
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
		ArrayList<Member> list = new AdminDao().stuInfoAll(conn,pi,search);
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
		ArrayList<Member> list = new AdminDao().stuInfoOutSearch(conn,pi,search);
		close(conn);
		return list;
	}
	
	/**
	 * Notice게시물 리스트 조회 요청을 처리해주는 메소드
	 * @param pageInfo : 페이징버튼 객체
	 * @return Notice게시글 리스트
	 * @author younheonchoi 
	 */
	public ArrayList<Notice> selectNoticeList(PageInfo pageInfo){
		Connection conn = getConnection();
		
		ArrayList<Notice> list = new AdminDao().selectNoticeList(conn, pageInfo);
		
		close(conn);
		
		return list;
	}
	
	/**
	 * 공지사항 수정 페이지에 공지사항 정보 출력 요청을 처리해주는 메소드
	 * @param noticeNo : 수정할 공지사항 번호
	 * @return 해당 번호의 공지사항 게시글
	 * @author younheonchoi 
	 */
	public Notice selectNotice(int noticeNo) {
		Connection conn = getConnection();
		
		Notice notice = new AdminDao().selectNotice(conn, noticeNo);
		
		close(conn);
		
		return notice;
	}
	
	/**
	 * 공지사항 수정 요청을 처리해주는 메소드
	 * @param noticeNo : 수정할 공지사항 번호
	 * @param noticeTitle : 수정한 공지사항 제목
	 * @param noticeContent : 수정한 공지사항 내용
	 * @return 업데이트된 행 갯수
	 * @author younheonchoi 
	 */
	public int updateNotice(int noticeNo, String noticeTitle, String noticeContent) {
		Connection conn = getConnection();
		
		int result = new AdminDao().updateNotice(conn, noticeNo, noticeTitle, noticeContent);
	
		if(result > 0) {
			commit(conn);
		}else {
			rollback(conn);
		}
		
		close(conn);
		
		return result;
	}
	
	/**
	 * 공지사항 삭제 요청을 처리해주는 메소드
	 * @param noticeNo : 삭제할 공지사항 번호
	 * @return 업데이트된 행 갯수
	 * @author younheonchoi 
	 */
	public int deleteNotice(int noticeNo) {
		Connection conn = getConnection();
		
		int result = new AdminDao().deleteNotice(conn, noticeNo);
		
		if(result > 0) {
			commit(conn);
		}else {
			rollback(conn);
		}
		
		close(conn);
		
		return result;
	}
	
	/**
	 * 총 댓글 갯수 확인 요청을 처리해주는 메소드
	 * @return 총 댓글 갯수
	 * @author younheonchoi 
	 */
	public int selectReplyCount() {
		Connection conn = getConnection();
		
		int listCount = new AdminDao().selectReplyCount(conn);
		
		close(conn);
		
		return listCount;
	}
	
	/**
	 * 댓글 리스트 조회 요청을 처리해주는 메소드
	 * @param pageInfo : 페이징 버튼 객체
	 * @return 조회된 댓글 리스트
	 * @author younheonchoi 
	 */
	public ArrayList<Reply> selectReplyList(PageInfo pageInfo) {
		Connection conn = getConnection();
		
		ArrayList<Reply> list = new AdminDao().selectReplyList(conn, pageInfo);
		
		close(conn);
		
		return list;
	}
	
	/**
	 * 댓글 삭제 요청을 처리해주는 메소드
	 * @param replyNo : 삭제할 댓글 번호
	 * @return 업데이트된 행 갯수
	 * @author younheonchoi 
	 */
	public int deleteReply(int replyNo) {
		Connection conn = getConnection();
		
		int result = new AdminDao().deleteReply(conn, replyNo);
		
		if(result > 0) {
			commit(conn);
		}else {
			rollback(conn);
		}
		
		close(conn);
		
		return result;
	}
	
	/**
	 * 1대1문의 글의 총 갯수 확인 요청을 처리해주는 메소드
	 * @return 1대1문의 총 갯수
	 * @author younheonchoi 
	 */
	public int selectMtmCount() {
		Connection conn = getConnection();
		
		int listCount = new AdminDao().selectMtmCount(conn);
		
		close(conn);
		
		return listCount;
	}
	
	/**
	 * 1대1 문의 리스트 조회 요청을 처리해주는 메소드
	 * @param pageInfo : 페이징 버튼 객체
	 * @return 1대1문의 리스트
	 * @author younheonchoi 
	 */
	public ArrayList<Mtm> selectMtmList(PageInfo pageInfo){
		Connection conn = getConnection();
		
		ArrayList<Mtm> list = new AdminDao().selectMtmList(conn, pageInfo);
		
		close(conn);
		
		return list;
		
	}
	
	/**
	 * 문의 답변 페이지에 문의 정보 출력 요청을 처리해주는 메소드
	 * @param mtmNo : 답변을 보낼 문의 게시글 번호
	 * @return 해당 번호의 문의 게시글
	 * @author younheonchoi 
	 */
	public Mtm selectMtm(int mtmNo) {
		Connection conn = getConnection();
		
		Mtm mtm = new AdminDao().selectMtm(conn, mtmNo);
		
		close(conn);
		
		return mtm;
	}
	
	/**
	 * 답변내용 업데이트 요청을 처리해주는 메소드
	 * @param mtmNo : 답변한 문의글 번호
	 * @param mtmAnswer : 답변 내용
	 * @return 업데이트된 행 갯수
	 * @author younheonchoi 
	 */
	public int updateAnswer(int mtmNo, String mtmAnswer) {
		Connection conn = getConnection();
		
		int result = new AdminDao().updateAnswer(conn, mtmNo, mtmAnswer);
		
		if(result > 0) {
			commit(conn);
		}else {
			rollback(conn);
		}
		
		close(conn);
		
		return result;
	}
	
	/**
	 * 사용자 이메일 조회 요청 처리를 해주는 메소드
	 * @param mtmNo : 사용자가 작성한 문의 글 번호
	 * @return 사용자 이메일
	 */
	public Mtm selectUserEmail(int mtmNo) {
		Connection conn = getConnection();
		
		Mtm userEmail = new AdminDao().selectUserEmail(conn, mtmNo);
		
		close(conn);
		
		return userEmail;
		
	}
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
}
