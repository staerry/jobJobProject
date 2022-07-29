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
	 * @SJW
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
	 * @SJW
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
	 * @SJW
	 */
	public int outMentorCount(String search) {
		Connection conn = getConnection();
		int listCount = new AdminDao2().outMentorCount(conn,search);
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
	 * @SJW
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
	 * @SJW
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
	 * @SJW
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
	 * @SJW
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
	 * @SJW
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
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
}
