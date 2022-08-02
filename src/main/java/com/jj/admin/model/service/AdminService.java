package com.jj.admin.model.service;

import static com.jj.common.JDBCTemplate.close;
import static com.jj.common.JDBCTemplate.commit;
import static com.jj.common.JDBCTemplate.getConnection;
import static com.jj.common.JDBCTemplate.rollback;

import java.sql.Connection;
import java.util.ArrayList;

import com.jj.admin.model.dao.AdminDao;
import com.jj.admin.model.vo.UserInfoAd;
import com.jj.classSelect.model.vo.Class;
import com.jj.classSelect.model.vo.Vod;
import com.jj.common.model.vo.PageInfo;
import com.jj.community.model.vo.Community;
import com.jj.community.model.vo.Reply;
import com.jj.community.model.vo.Review;
import com.jj.faq.model.vo.Faq;
import com.jj.member.model.vo.Member;
import com.jj.member.model.vo.MentorApproval;
import com.jj.member.model.vo.SlideAttachment;
import com.jj.mentorSelect.model.vo.MtQuestion;
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
	 * @author youngheonchoi 
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
	 * @author youngheonchoi 
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
	 * @author youngheonchoi 
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
	 * @author youngheonchoi 
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
	 * @author youngheonchoi 
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
	 * @author youngheonchoi 
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
	 * @author youngheonchoi 
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
	 * @author youngheonchoi 
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
	 * @author youngheonchoi 
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
	 * @author youngheonchoi 
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
	 * @author youngheonchoi 
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
	 * @author youngheonchoi 
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
	 * @author youngheonchoi 
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
	 * @author youngheonchoi 
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
	 * @author youngheonchoi 
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
	 * @author youngheonchoi 
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
	 * @author youngheonchoi 
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
	 * @author youngheonchoi 
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
	 * @author youngheonchoi 
	 */
	public Mtm selectUserEmail(int mtmNo) {
		Connection conn = getConnection();
		
		Mtm userEmail = new AdminDao().selectUserEmail(conn, mtmNo);
		
		close(conn);
		
		return userEmail;
	}
	
	/**
	 * 개설된 클래스 총 갯수 확인 요청을 처리해주는 메소드
	 * @return 개설된 클래스 총 갯수
	 * @author youngheonchoi 
	 */
	public int selectClassCount() {
		Connection conn = getConnection();
		
		int listCount = new AdminDao().selectClassCount(conn);
		
		close(conn);
		
		return listCount;
	}
	
	/**
	 * 개설된 클래스 리스트 조회 요청을 처리해주는 메소드
	 * @param pageInfo : 페이징 버튼 객체
	 * @return 개설된 클래스 리스트
	 * @author youngheonchoi 
	 */
	public ArrayList<Class> selectClassList(PageInfo pageInfo){
		Connection conn = getConnection();
		
		ArrayList<Class> list = new AdminDao().selectClassList(conn, pageInfo);
		
		close(conn);
		
		return list;
	}
	
	/**
	 * 클래스 삭제 요청을 처리해주는 메소드
	 * @param clNo : 삭제할 클래스 번호
	 * @return 업데이트된 행 갯수
	 * @author youngheonchoi 
	 */
	public int deleteClass(int clNo) {
		Connection conn = getConnection();
		
		int result = new AdminDao().deleteClass(conn, clNo);
		
		if(result > 0) {
			commit(conn);
		}else {
			rollback(conn);
		}
		
		close(conn);
		
		return result;
	}
	
	/**
	 * 수강후기 총 갯수 확인 요청 처리를 해주는 메소드
	 * @return 수강후기 총 갯수
	 * @author youngheonchoi 
	 */
	public int selectReviewCount() {
		Connection conn = getConnection();
		
		int listCount = new AdminDao().selectReviewCount(conn);
		
		close(conn);
		
		return listCount;
	}
	
	/**
	 * 수강후기 리스트 조회 요청 처리를 해주는 메소드
	 * @param pageInfo : 페이징 버튼 객체
	 * @return 수강후기 리스트
	 * @author youngheonchoi 
	 */
	public ArrayList<Review> selectReviewList(PageInfo pageInfo){
		Connection conn = getConnection();
		
		ArrayList<Review> list = new AdminDao().selectReviewList(conn, pageInfo);
		
		close(conn);
		
		return list;
	}
	
	/**
	 * 수강후기 삭제 요청을 처리해주는 메소드
	 * @param reviewNo : 삭제할 수강후기 번호
	 * @return 업데이트된 행 갯수
	 * @author youngheonchoi 
	 */
	public int deleteReview(int reviewNo) {
		Connection conn = getConnection();
		
		int result = new AdminDao().deleteReview(conn, reviewNo);
		
		if(result > 0) {
			commit(conn);
		}else {
			rollback(conn);
		}
		
		close(conn);
		
		return result;
	}
	
	/**
	 * 직무질문 카테고리 게시글 총 갯수 확인요청을 처리해주는 메소드
	 * @return 게시글 총 갯수
	 * @author youngheonchoi 
	 */
	public int selectCommunityWorkCount() {
		Connection conn = getConnection();
		
		int listCount = new AdminDao().selectCommunityWorkCount(conn);
		
		close(conn);
		
		return listCount;
	}
	
	/**
	 * 스터디 카테고리 게시글 총 갯수 확인요청을 처리해주는 메소드
	 * @return 게시글 총 갯수
	 * @author youngheonchoi 
	 */
	public int selectCommunityStudyCount() {
		Connection conn = getConnection();
		
		int listCount = new AdminDao().selectCommunityStudyCount(conn);
		
		close(conn);
		
		return listCount;
	}
	
	/**
	 * 고민상담 카테고리 게시글 총 갯수 확인요청을 처리해주는 메소드
	 * @return 게시글 총 갯수
	 * @author youngheonchoi 
	 */
	public int selectCommunityWorryCount() {
		Connection conn = getConnection();
		
		int listCount = new AdminDao().selectCommunityWorryCount(conn);
		
		close(conn);
		
		return listCount;
	}
	
	/**
	 * 직무질문 게시글 리스트 조회 요청을 처리해주는 메소드
	 * @param pageInfo : 페이징 버튼 객체
	 * @return 직무질문 게시글 리스트
	 * @author youngheonchoi 
	 */
	public ArrayList<Community> selectCommunityWorkList(PageInfo pageInfo){
		Connection conn = getConnection();
		
		ArrayList<Community> list = new AdminDao().selectCommunityWorkList(conn, pageInfo);
		
		close(conn);
		
		return list;
	}
	
	/**
	 * 스터디 게시글 리스트 조회 요청을 처리해주는 메소드
	 * @param pageInfo : 페이징 버튼 객체
	 * @return 스터디 게시글 리스트
	 * @author youngheonchoi 
	 */
	public ArrayList<Community> selectCommunityStudyList(PageInfo pageInfo){
		Connection conn = getConnection();
		
		ArrayList<Community> list = new AdminDao().selectCommunityStudyList(conn, pageInfo);
		
		close(conn);
		
		return list;
	}
	
	/**
	 * 고민상담 게시글 리스트 조회 요청을 처리해주는 메소드
	 * @param pageInfo : 페이징 버튼 객체
	 * @return 고민상담 게시글 리스트
	 * @author youngheonchoi 
	 */
	public ArrayList<Community> selectCommunityWorryList(PageInfo pageInfo){
		Connection conn = getConnection();
		
		ArrayList<Community> list = new AdminDao().selectCommunityWorryList(conn, pageInfo);
		
		close(conn);
		
		return list;
	}

	/**
	 * 게시물 삭제 요청을 처리해주는 메소드
	 * @param postNo : 삭제할 게시글 번호
	 * @param postCategory : 삭제할 게시글 카테고리 번호
	 * @return 업데이트된 행 갯수
	 * @author youngheonchoi 
	 */
	public int deletePost(int postNo, int postCategory) {
		Connection conn = getConnection();
		
		int result = new AdminDao().deletePost(conn, postNo, postCategory);
		
		if(result > 0) {
			commit(conn);
		}else {
			rollback(conn);
		}
		
		close(conn);
		
		return result;
	}
	
	/**
	 * 가입신청한 멘토의 수 조회 요청을 처리해주는 메소드
	 * @return 가입신청한 멘토의 수
	 * @author youngheonchoi 
	 */
	public int selectMentorCount() {
		Connection conn = getConnection();
		
		int listCount = new AdminDao().selectMentorCount(conn);
		
		close(conn);
		
		return listCount;
	}
	
	/**
	 * 가입신청한 멘토 리스트 조회 요청을 처리해주는 메소드
	 * @param pageInfo : 페이징 버튼 객체
	 * @return 가입신청한 멘토 리스트
	 * @author youngheonchoi 
	 */
	public ArrayList<MentorApproval> selectMentorList(PageInfo pageInfo){
		Connection conn = getConnection();
		
		ArrayList<MentorApproval> list = new AdminDao().selectMentorList(conn, pageInfo);
		
		close(conn);
		
		return list;
	}
	
	/**
	 * 해당 번호의 멘토 정보 조회 요청을 처리해주는 메소드
	 * @param mentorNo : 정보를 조회할 멘토 번호
	 * @return 멘토 정보
	 * @author youngheonchoi 
	 */
	public MentorApproval selectMentor(int mentorNo) {
		Connection conn = getConnection();
		
		MentorApproval mentorApproval = new AdminDao().selectMentor(conn, mentorNo);
		
		close(conn);
		
		return mentorApproval;
	}
	
	/**
	 * 멘토 가입 승인 요청을 처리해주는 메소드
	 * @param mentorNo : 승인할 멘토 번호
	 * @return 업데이트된 행 갯수
	 * @author youngheonchoi 
	 */
	public int mentorApproval(int mentorNo) {
		Connection conn = getConnection();
		
		int result = new AdminDao().mentorApproval(conn, mentorNo);
		
		if(result > 0) {
			commit(conn);
		}else {
			rollback(conn);
		}
		
		close(conn);
		
		return result;
	}
	
	/**
	 * 멘토 가입 승인 거절 요청을 처리해주는 메소드
	 * @param mentorNo : 승인 거절할 멘토 번호
	 * @return 업데이트된 행 갯수
	 * @author youngheonchoi 
	 */
	public int mentorApprovalFusal(int mentorNo) {
		Connection conn = getConnection();
		
		int result = new AdminDao().mentorApprovalFusal(conn, mentorNo);
		
		if(result > 0) {
			commit(conn);
		}else {
			rollback(conn);
		}
		
		close(conn);
		
		return result;
	}
	
	/**
	 * 승인 대기중인 클래스 갯수 조회 요청을 처리해주는 메소드
	 * @return 승인 대기중인 클래스 갯수
	 * @author youngheonchoi 
	 */
	public int selectApprovalClassCount() {
		Connection conn = getConnection();
		
		int listCount = new AdminDao().selectApprovalClassCount(conn);
		
		close(conn);
		
		return listCount;
	}
	
	/**
	 * 승인 대기중인 클래스 리스트 조회 요청을 처리해주는 메소드
	 * @param pageInfo : 페이징버튼 객체
	 * @return 승인 대기중인 클래스 리스트
	 * @author youngheonchoi 
	 */
	public ArrayList<Class> selectApprovalClassList(PageInfo pageInfo){
		Connection conn = getConnection();
		
		ArrayList<Class> list = new AdminDao().selectApprovalClassList(conn, pageInfo);
		
		close(conn);
		
		return list;
	}
	
	/**
	 * 해당 번호의 클래스 정보 조회 요청을 처리해주는 메소드
	 * @param classNo : 정보를 조회할 클래스 번호
	 * @return 클래스 정보
	 * @author youngheonchoi 
	 */
	public Class selectClassApproval(int classNo) {
		Connection conn = getConnection();
		
		Class classInfo = new AdminDao().selectClassApproval(conn, classNo);
		
		close(conn);
		
		return classInfo;
	}
	
	/**
	 * 클래스 등록 승인 요청 처리를 해주는 메소드
	 * @param classNo : 승인 처리할 클래스
	 * @return 업데이트된 행 갯수
	 * @author youngheonchoi 
	 */
	public int classApproval(int classNo) {
		Connection conn = getConnection();
		
		int result = new AdminDao().classApproval(conn, classNo);
		
		if(result > 0) {
			commit(conn);
		}else {
			rollback(conn);
		}
		
		close(conn);
		
		return result;
	}
	
	/**
	 * 클래스 등록 승인 거절 요청 처리를 해주는 메소드
	 * @param classNo : 승인 거철 처리할 클래스
	 * @return 업데이트된 행 갯수
	 * @author youngheonchoi 
	 */
	public int classApprovalFusal(int classNo) {
		Connection conn = getConnection();
		
		int result = new AdminDao().classApprovalFusal(conn, classNo);
		
		if(result > 0) {
			commit(conn);
		}else {
			rollback(conn);
		}
		
		close(conn);
		
		return result;
	}
	
	/**
	 * 승인 대기중인 vod 갯수 조회 요청을 처리해주는 메소드
	 * @return 승인 대기중인 vod 갯수
	 * @author youngheonchoi 
	 */
	public int selectVodCount() {
		Connection conn = getConnection();
		
		int listCount = new AdminDao().selectVodCount(conn);
		
		close(conn);
		
		return listCount;
	}
	
	/**
	 * 승인 대기중인 vod리스트 조회 요청 처리를 해주는 메소드
	 * @param pageInfo : 페이징 버튼 객체
	 * @return 승인 대기중인 vod 리스트
	 * @author youngheonchoi 
	 */
	public ArrayList<Vod> selectVodList(PageInfo pageInfo){
		Connection conn = getConnection();
		
		ArrayList<Vod> list = new AdminDao().selectVodList(conn, pageInfo);
		
		close(conn);
		
		return list;
	}
	
	/**
	 * 해당 번호의 vod정보 조회 요청 처리를 해주는 메소드
	 * @param vodNo : 정보를 조회할 vod번호
	 * @return vod 정보
	 * @author youngheonchoi
	 */
	public Vod selectVod(int vodNo) {
		Connection conn = getConnection();
		
		Vod vod = new AdminDao().selectVod(conn, vodNo);
		
		close(conn);
		
		return vod;
	}
	
	/**
	 * vod업로드 승인/거절 요청을 처리해주는 메소드
	 * @param vodNo : 승인/거절할 vod 번호
	 * @param answer : 1(승인), 2(거절)
	 * @return 업데이트된 행 갯수
	 * @author youngheonchoi
	 */
	public int vodApproval(int vodNo, int answer) {
		Connection conn = getConnection();
		
		int result = new AdminDao().vodApproval(conn, vodNo, answer);
		
		if(result > 0) {
			commit(conn);
		}else {
			rollback(conn);
		}
		
		close(conn);
		
		return result;
	}
	
	/**
	 * 멘토질문 총 갯수 조회 요청 처리를 해주는 메소드
	 * @return 멘토질문 총 갯수
	 * @author youngheonchoi
	 */
	public int selectQueCount() {
		Connection conn = getConnection();
		
		int listCount = new AdminDao().selectQueCount(conn);
		
		close(conn);
		
		return listCount;
	}
	
	
	public ArrayList<MtQuestion> selectQueList(PageInfo pageInfo){
		Connection conn = getConnection();
		
		ArrayList<MtQuestion> list = new AdminDao().selectQueList(conn, pageInfo);
		
		close(conn);
		
		return list;
	}
	
	/**
	 * 멘토질문 삭제 요청을 처리해주는 메소드
	 * @param queNo : 삭제할 멘토질문 번호
	 * @return 업데이트된 행 갯수
	 * @author youngheonchoi
	 */
	public int deleteQue(int queNo) {
		Connection conn = getConnection();
		
		int result = new AdminDao().deleteQue(conn, queNo);
		
		if(result > 0) {
			commit(conn);
		}else {
			rollback(conn);
		}
		
		close(conn);
		
		return result;
	}
	
	/**
	 * 슬라이드 이미지 리스트 조회 요청을 처리해주는 메소드
	 * @return 슬라이드 이미지 리스트
	 * @author youngheonchoi
	 */
	public ArrayList<SlideAttachment> selectSlideList(){
		Connection conn = getConnection();
		
		ArrayList<SlideAttachment> list = new AdminDao().selectSlideList(conn);
		
		close(conn);
		
		return list;
	}
	
	/**
	 * 슬라이디 이미지 삭제 요청을 처리해주는 메소드
	 * @param slideNo : 삭제할 슬라이드 이미지 번호
	 * @return 업데이트된 행 갯수
	 * @author youngheonchoi
	 */
	public int deleteSlide(int slideNo) {
		Connection conn = getConnection();
		
		int result = new AdminDao().deleteSlide(conn, slideNo);
		
		if(result > 0) {
			commit(conn);
		}else {
			rollback(conn);
		}
		
		close(conn);
		
		return result;
	}
	
	/**
	 * 슬라이드 이미지 파일 업로드 요청 처리를 해주는 메소드
	 * @param slide : 업로드할 슬라이드 이미지 객체
	 * @return 업데이트된 행 갯수
	 * @author youngheonchoi
	 */
	public int insertSlide(SlideAttachment slide) {
		Connection conn = getConnection();
		
		int result = new AdminDao().insertSlide(conn, slide);
		
		if(result > 0) {
			commit(conn);
		}else {
			rollback(conn);
		}
		
		close(conn);
		
		return result;
	}
	
	/**
	 * 삭제할 슬라이드 이미지 객체 조회 요청을 처리해주는 메소드
	 * @param slideNo : 조회할 슬라이드 이미지 번호
	 * @return 삭제할 슬라이드 이미지 객체
	 */
	public SlideAttachment selectSlide(int slideNo) {
		Connection conn = getConnection();
		
		SlideAttachment slide = new AdminDao().selectSlide(conn, slideNo);
		
		close(conn);
		
		return slide;
	}
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
}
