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
import com.jj.member.model.vo.Mentor;
import com.jj.notice.model.vo.Notice;
import com.jj.pay.model.vo.Pay;

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
	 * @author SJW
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
	 *  모든 멘토들중 사용자가 입력한 키워드에맞는멘토수를 찾는메소드
	 * @param search 사용자가 입력한 키워드
	 * @return 멘토수
	 * @author SJW
	 */
	public int selectMentorListCount(String search) {
		Connection conn = getConnection();
		int listCount = new AdminDao2().selectMentorListCount(conn,search);
		close(conn);
		
		return listCount;
	}
	
	/**
	 *  현직자중 사용자가 입력한 키워드에맞는멘토수를 찾는메소드
	 * @param search 사용자가 입력한 키워드
	 * @return 멘토수
	 * @author SJW
	 */
	public int currentCount(String search) {
		Connection conn = getConnection();
		int listCount = new AdminDao2().currentCount(conn,search);
		close(conn);
		
		return listCount;
	}
	
	/**
	 *  강의자중 사용자가 입력한 키워드에맞는멘토수를 찾는메소드
	 * @param search 사용자가 입력한 키워드
	 * @return 멘토수
	 * @author SJW
	 */
	public int lecturerCount(String search) {
		Connection conn = getConnection();
		int listCount = new AdminDao2().lecturerCount(conn,search);
		close(conn);
		
		return listCount;
	}
	
	/**
	 *  강의자중 사용자가 입력한 키워드에맞는멘토수를 찾는메소드
	 * @param search 사용자가 입력한 키워드
	 * @return 멘토수
	 * @author SJW
	 */
	public int outMentorCount(String search) {
		Connection conn = getConnection();
		int listCount = new AdminDao2().outMentorCount(conn,search);
		close(conn);
		
		return listCount;
	}
	
	/**
	 * 활동중인 모든회원의 수를세는 메소드
	 * @param search 사용자가 입력한 키워드
	 * @return 멘토수
	 * @author SJW
	 */
	public int selectAllUserCount(String search) {
		Connection conn = getConnection();
		int listCount = new AdminDao2().selectAllUserCount(conn,search);
		close(conn);
		
		return listCount;
	}
	
	/**
	 * 탈퇴한 모든회원의 수를세는 메소드
	 * @param search 사용자가 입력한 키워드
	 * @return 멘토수
	 * @author SJW
	 */
	public int outAllUserCount(String search) {
		Connection conn = getConnection();
		int listCount = new AdminDao2().outAllUserCount(conn,search);
		close(conn);
		
		return listCount;
	}
	
	/**
	 * 회원번호를 가지고 결제내역수를 찾는 메소드
	 * @param no 회원번호
	 * @return 결제내역수
	 * @author SJW
	 */
	public int selectPayDetailCount(int no) {
		Connection conn = getConnection();
		int listCount = new AdminDao2().selectPayDetailCount(conn,no);
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
	 * 사용자가 입력한 키워드에맞는 탈퇴한 수강생리스트를 페이지에 맞춰서 찾는메소드
	 * @param pi 페이지정보를 담고있는 객체
	 * @param search 사용자가 입력한 키워드
	 * @return 탈퇴한 수강생리스트
	 * @author SJW
	 */
	public ArrayList<Member> stuInfoOutSearch(PageInfo pi,String search){
		Connection conn = getConnection();
		ArrayList<Member> list = new AdminDao2().stuInfoOutSearch(conn,pi,search);
		close(conn);
		return list;
	}
	
	/**
	 * 사용자가 입력한 키워드에맞는 모든멘토리스트를 페이지에 맞춰서 찾는메소드
	 * @param pi 페이지정보를 담고있는 객체
	 * @param search 사용자가 입력한 키워드
	 * @return 멘토리스트
	 * @author SJW
	 */
	public ArrayList<Member> mentorInfo(PageInfo pi,String search){
		Connection conn = getConnection();
		ArrayList<Member> list = new AdminDao2().mentorInfo(conn,pi,search);
		close(conn);
		return list;
	}
	
	/**
	 * 현직자들중에서 사용자가 입력한 키워드에맞는 리스트를 찾는메소드
	 * @param pi 페이지정보를 담고있는 객체
	 * @param search 사용자가 입력한 키워드
	 * @return 현직자 리스트
	 * @author SJW
	 */
	public ArrayList<Member> currentInfo(PageInfo pi,String search){
		Connection conn = getConnection();
		ArrayList<Member> list = new AdminDao2().currentInfo(conn,pi,search);
		close(conn);
		return list;
	}
	
	/**
	 * 강의자들중에서 사용자가 입력한 키워드에맞는 리스트를 찾는메소드
	 * @param pi 페이지정보를 담고있는 객체
	 * @param search 사용자가 입력한 키워드
	 * @return 강의자 리스트
	 * @author SJW
	 */
	public ArrayList<Member> lecturerList(PageInfo pi,String search){
		Connection conn = getConnection();
		ArrayList<Member> list = new AdminDao2().lecturerList(conn,pi,search);
		close(conn);
		return list;
	}
	
	/**
	 * 탈퇴한메토들중에서 사용자가 입력한 키워드에맞는 리스트를 찾는메소드
	 * @param pi 페이지정보를 담고있는 객체
	 * @param search 사용자가 입력한 키워드
	 * @return 탈퇴한멘토 리스트
	 * @author SJW
	 */
	public ArrayList<Member> outMentorList(PageInfo pi,String search){
		Connection conn = getConnection();
		ArrayList<Member> list = new AdminDao2().outMentorList(conn,pi,search);
		close(conn);
		return list;
	}
	
	/**
	 * 수강생을 회원탈퇴처리하는 메소드
	 * @param name 탈퇴처리할 회원명
	 * @param id 탈퇴처리할 회원아이디
	 * @return 탈퇴결과값
	 * @author SJW
	 */
	public int withdrawalStu(String name, String id) {
		Connection conn = getConnection();
		int result = new AdminDao2().withdrawalStu(conn,name,id);
		
		if(result>0) {
			commit(conn);
		}else {
			rollback(conn);
		}
		close(conn);
		return result;
	}
	
	/**
	 * 탈퇴한 수강생을 다시 복구하는 메소드
	 * @param name 복구처리할 회원명
	 * @param id 복구처리할 회원아이디
	 * @return 복구결과값
	 * @author SJW
	 */
	public int restoreStu(String name, String id) {
		Connection conn = getConnection();
		int result = new AdminDao2().restoreStu(conn,name,id);
		
		if(result>0) {
			commit(conn);
		}else {
			rollback(conn);
		}
		close(conn);
		return result;
	}
	
	/**
	 * 멘토의 상세정보를 번호를통해 가져오는메소드
	 * @param No 정보를 가져올 멘토고유번호
	 * @return 멘토정보담은객체
	 * @author SJW
	 */
	public Mentor mentorDetailInfo(int no) {
		Connection conn = getConnection();
		Mentor m = new AdminDao2().mentorDetailInfo(conn,no);
		close(conn);
		return m;
	}
	
	/**
	 * 멘토의 등급과 카테고리를 바꿔주는 메소드
	 * @param no 바꿀멘토번호
	 * @param grade 변경할등급
	 * @param cate 변경할 카테고리
	 * @return 결과값
	 * @author SJW
	 */
	public int upMenCate(int no,int grade,int cate) {
		Connection conn = getConnection();
		int result = new AdminDao2().upMenCate(conn,no,grade,cate);
		if(result>0) {
			commit(conn);
		}else {
			rollback(conn);
		}
		close(conn);
		return result;
	}
	
	/**
	 * 멘토를 회원탈퇴처리하는 메소드
	 * @param no 회원탈퇴처리할 멤버번호
	 * @return 탈퇴결과값
	 * @author SJW
	 */
	public int withdrawalMen(int no) {
		Connection conn = getConnection();
		int result = new AdminDao2().withdrawalMen(conn,no);
		
		if(result>0) {
			commit(conn);
		}else {
			rollback(conn);
		}
		close(conn);
		return result;
	}
	
	/**
	 * 탈퇴한 수강생을 다시 복구하는 메소드
	 * @param name 복구처리할 회원명
	 * @param id 복구처리할 회원아이디
	 * @return 복구결과값
	 * @author SJW
	 */
	public int restoreMen(int no) {
		Connection conn = getConnection();
		int result1 = new AdminDao2().restoreMen1(conn,no);
		int result2 = new AdminDao2().restoreMen2(conn,no);
		
		if(result1*result2>0) {
			commit(conn);
		}else {
			rollback(conn);
		}
		close(conn);
		return result1*result2;
	}
	
	/**
	 * 활동중인 모든유저 리스트를 페이지에 맞춰서 찾는메소드
	 * @param pi 페이지정보를 담고있는 객체
	 * @return 페이지에 맞는 활동중인 수강생 리스트
	 * @author SJW
	 */
	public ArrayList<Member> selectAllUserList(PageInfo pi,String search){
		Connection conn = getConnection();
		ArrayList<Member> list = new AdminDao2().selectAllUserList(conn,pi,search);
		close(conn);
		return list;
	}
	
	/**
	 * 탈퇴한 모든유저 리스트를 페이지에 맞춰서 찾는메소드
	 * @param pi 페이지정보를 담고있는 객체
	 * @return 페이지에 맞는 활동중인 수강생 리스트
	 * @author SJW
	 */
	public ArrayList<Member> outAllUserList(PageInfo pi,String search){
		Connection conn = getConnection();
		ArrayList<Member> list = new AdminDao2().outAllUserList(conn,pi,search);
		close(conn);
		return list;
	}
	
	/**
	 * 회원번호를 가지고 페이지에 맞는 결제세부내역을 조회하는메소드
	 * @param pi
	 * @param no
	 * @return
	 */
	public ArrayList<Pay> payDetailInfo(PageInfo pi,int no){
		Connection conn = getConnection();
		ArrayList<Pay> list = new AdminDao2().payDetailInfo(conn,pi,no);
		close(conn);
		return list;
	}
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
}
