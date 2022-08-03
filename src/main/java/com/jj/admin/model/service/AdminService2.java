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
import com.jj.classSelect.model.vo.ClassIng;
import com.jj.common.model.vo.PageInfo;
import com.jj.coupon.vo.Coupon;
import com.jj.coupon.vo.IssuanceCoupon;
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
	 * 검색결과에맞는 결제내역(구매관련)의 수를세는 메소드
	 * @param search 입력한검색정보
	 * @return 구매결제내역수
	 * @author SJW
	 */
	public int paymentBuyListCount(String search) {
		Connection conn = getConnection();
		int listCount = new AdminDao2().paymentBuyListCount(conn,search);
		close(conn);
		
		return listCount;
	}
	
	/**
	 * 검색결과에맞는 환불내역의 수를세는 메소드
	 * @param search 입력한검색정보
	 * @return 환불내역수
	 * @author SJW
	 */
	public int paymentRefundListCount(String search) {
		Connection conn = getConnection();
		int listCount = new AdminDao2().paymentRefundListCount(conn,search);
		close(conn);
		
		return listCount;
	}
	
	/**
	 * 검색결과에맞는 환불처리완료내역의 수를세는 메소드
	 * @param search 입력한검색정보
	 * @return 환불내역수
	 * @author SJW
	 */
	public int paymentRefundFinishCount(String search) {
		Connection conn = getConnection();
		int listCount = new AdminDao2().paymentRefundFinishCount(conn,search);
		close(conn);
		
		return listCount;
	}
	
	/**
	 * 검색결과에맞는 환불처리거절내역의 수를세는 메소드
	 * @param search 입력한검색정보
	 * @return 환불거절내역수
	 * @author SJW
	 */
	public int paymentRefundDenyCount(String search) {
		Connection conn = getConnection();
		int listCount = new AdminDao2().paymentRefundDenyCount(conn,search);
		close(conn);
		
		return listCount;
	}
	
	/**
	 * 쿠폰전체수를 세는 메소드
	 * @return 쿠폰수
	 * @author SJW
	 */
	public int couponListCount() {
		Connection conn = getConnection();
		int listCount = new AdminDao2().couponListCount(conn);
		close(conn);
		
		return listCount;
	}
	
	/**
	 * 쿠폰전체수를 세는 메소드
	 * @return 쿠폰수
	 * @author SJW
	 */
	public int couponListCountA() {
		Connection conn = getConnection();
		int listCount = new AdminDao2().couponListCountA(conn);
		close(conn);
		
		return listCount;
	}
	
	/**
	 * 키워드에맞는 회원이 보유중인쿠폰수를 세는 메소드
	 * @param search 키워드
	 * @return 조회수
	 */
	public int MemberCouponBeforCount(String search) {
		Connection conn = getConnection();
		int listCount = new AdminDao2().MemberCouponBeforCount(conn,search);
		close(conn);
		
		return listCount;
	}
	
	/**
	 * 키워드에맞는 회원이 사용한쿠폰수 세는 메소드
	 * @param search 키워드
	 * @return 조회수
	 */
	public int MemberCouponAfterCount(String search) {
		Connection conn = getConnection();
		int listCount = new AdminDao2().MemberCouponAfterCount(conn,search);
		close(conn);
		
		return listCount;
	}
	
	public int refundRequestCount(String search) {
		Connection conn = getConnection();
		int listCount = new AdminDao2().refundRequestCount(conn,search);
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
	 * @param search 검색정보
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
	 * @param search 검색정보
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
	 * @param pi 페이지정보
	 * @param no 세부내역 조회하려는 유저번호
	 * @return 결제세부내역리스트
	 */
	public ArrayList<Pay> payDetailInfo(PageInfo pi,int no){
		Connection conn = getConnection();
		ArrayList<Pay> list = new AdminDao2().payDetailInfo(conn,pi,no);
		close(conn);
		return list;
	}
	
	/**
	 * 검색정보를가지고 페이지에 맞는 구매내역 리스트조회 메소드
	 * @param pi 페이지정보
	 * @param search 검색정보
	 * @return 구매내역리스트
	 */
	public ArrayList<Pay> paymentBuyList(PageInfo pi,String search){
		Connection conn = getConnection();
		ArrayList<Pay> list = new AdminDao2().paymentBuyList(conn,pi,search);
		close(conn);
		return list;
	}
	
	/**
	 * 검색정보를가지고 페이지에 맞는 환불내역 리스트조회 메소드
	 * @param pi 페이지정보
	 * @param search 검색정보
	 * @return 환불내역리스트
	 */
	public ArrayList<Pay> paymentRefundList(PageInfo pi,String search){
		Connection conn = getConnection();
		ArrayList<Pay> list = new AdminDao2().paymentRefundList(conn,pi,search);
		close(conn);
		return list;
	}
	
	/**
	 * 검색정보를가지고 페이지에 맞는 환불요청처리내역 리스트조회 메소드
	 * @param pi 페이지정보
	 * @param search 검색정보
	 * @return 환불요청처리내역
	 */
	public ArrayList<Pay> paymentRefundFinish(PageInfo pi,String search){
		Connection conn = getConnection();
		ArrayList<Pay> list = new AdminDao2().paymentRefundFinish(conn,pi,search);
		close(conn);
		return list;
	}
	
	/**
	 * 검색정보를가지고 페이지에 맞는 환불거절내역 리스트조회 메소드
	 * @param pi 페이지정보
	 * @param search 검색정보
	 * @return 환불거절내역
	 */
	public ArrayList<Pay> paymentRefundDeny(PageInfo pi,String search){
		Connection conn = getConnection();
		ArrayList<Pay> list = new AdminDao2().paymentRefundDeny(conn,pi,search);
		close(conn);
		return list;
	}
	
	/**
	 * 쿠폰리스트를 페이지에 맞게 조회하는 메소드
	 * @param pi 페이지정보객체
	 * @return 쿠폰리스트
	 */
	public ArrayList<Coupon> couponList(PageInfo pi){
		Connection conn = getConnection();
		ArrayList<Coupon> list = new AdminDao2().couponList(conn,pi);
		close(conn);
		return list;
	}
	
	/**
	 * 쿠폰리스트를 페이지에 맞게 조회하는 메소드
	 * @param pi 페이지정보객체
	 * @return 쿠폰리스트
	 */
	public ArrayList<Coupon> couponListA(PageInfo pi){
		Connection conn = getConnection();
		ArrayList<Coupon> list = new AdminDao2().couponListA(conn,pi);
		close(conn);
		return list;
	}
	
	/**
	 * 강의를 수강하는학생번호를 알아오는 메소드
	 * @return 수강학생번호객체
	 */
	public ArrayList<ClassIng> classStu(){
		Connection conn = getConnection();
		ArrayList<ClassIng> list = new AdminDao2().classStu(conn);
		close(conn);
		return list;
	}
	
	/**
	 * 키워드와 페이지에맞는 회원쿠폰보유현황리스트를 가져오는 메소드
	 * @param pi 페이지정보
	 * @param search 키워드
	 * @return 리스트
	 */
	public ArrayList<IssuanceCoupon> MemberCouponBeforList(PageInfo pi,String search){
		Connection conn = getConnection();
		ArrayList<IssuanceCoupon> list = new AdminDao2().MemberCouponBeforList(conn,pi,search);
		close(conn);
		return list;
	}
	
	/**
	 * 키워드와 페이지에맞는 회원이사용한쿠폰리스트를 가져오는 메소드
	 * @param pi 페이지정보
	 * @param search 키워드
	 * @return 리스트
	 */
	public ArrayList<IssuanceCoupon> MemberCouponAfterList(PageInfo pi,String search){
		Connection conn = getConnection();
		ArrayList<IssuanceCoupon> list = new AdminDao2().MemberCouponAfterList(conn,pi,search);
		close(conn);
		return list;
	}
	
	/**
	 * 키워드와 페이지에맞는 환불대기중인리스트를 가져오는 메소드
	 * @param pi 페이지정보
	 * @param search 키워드
	 * @return 리스트
	 */
	public ArrayList<Pay> refundRequestList(PageInfo pi,String search){
		Connection conn = getConnection();
		ArrayList<Pay> list = new AdminDao2().refundRequestList(conn,pi,search);
		close(conn);
		return list;
	}
	
	/**
	 * 쿠폰등록을하는메소드
	 * @param cpName 등록할쿠폰명
	 * @param discount 등록할쿠폰할인가격
	 * @return 쿠폰등록결과
	 */
	public int insertCoupon(String cpName,int discount) {
		Connection conn = getConnection();
		int result = new AdminDao2().insertCoupon(conn,cpName,discount);
		if(result>0) {
			commit(conn);
		}else {
			rollback(conn);
		}
		close(conn);
		return result;
	}
	
	/**
	 * 최근등록한 쿠폰번호 알아내는 메소드
	 * @return 쿠폰번호
	 */
	public int CouponNo() {
		Connection conn = getConnection();
		int no = new AdminDao2().CouponNo(conn);
		close(conn);
		return no;
	}
	
	/**
	 * 강의수강중인학생한테 쿠폰을수는 메소드
	 * @param list 강의수강중인 학생번호리스트
	 * @param no 줄쿠폰번호
	 * @return 쿠폰등록결과값
	 */
	public int sendCouponClStu(ArrayList<ClassIng>list, int no) {
		Connection conn = getConnection();
		int result2 = new AdminDao2().sendCouponClStu(conn,list,no);
		if(result2>0) {
			commit(conn);
		}else {
			rollback(conn);
		}
		close(conn);
		return result2;
	}
	
	/**
	 * 모든수강생번호를 가져오는 메소드
	 * @return 모든수강생번호
	 */
	public ArrayList<Integer> allStuNo(){
		Connection conn = getConnection();
		ArrayList<Integer> list = new AdminDao2().allStuNo(conn);
		close(conn);
		return list;
	}
	
	/**
	 * 모든회원번호를 가져오는 메소드
	 * @return 모든회원번호
	 */
	public ArrayList<Integer> allMemNo(){
		Connection conn = getConnection();
		ArrayList<Integer> list = new AdminDao2().allMemNo(conn);
		close(conn);
		return list;
	}
	
	/**
	 * 회원번호와쿠폰번호를 가지고 쿠폰을주는 메소드
	 * @param list 수강생 학생번호리스트
	 * @param no 줄쿠폰번호
	 * @return 쿠폰등록결과값
	 */
	public int sendCoupon(ArrayList<Integer>list, int no) {
		Connection conn = getConnection();
		int result2 = new AdminDao2().sendCoupon(conn,list,no);
		if(result2>0) {
			commit(conn);
		}else {
			rollback(conn);
		}
		close(conn);
		return result2;
	}
	
	/**
	 * 쿠폰번호로 쿠폰발급중단하는 메소드
	 * @param no 중단할 쿠폰번호
	 * @return 결과값
	 */
	public int couponStop(int no) {
		Connection conn = getConnection();
		int result = new AdminDao2().couponStop(conn,no);
		if(result>0) {
			commit(conn);
		}else {
			rollback(conn);
		}
		close(conn);
		return result;
	}
	
	/**
	 * 쿠폰번호로 쿠폰발급을 재개하는 메소드
	 * @param no 재개할 쿠폰번호
	 * @return 결과값
	 */
	public int couponRestore(int no) {
		Connection conn = getConnection();
		int result = new AdminDao2().couponRestore(conn,no);
		if(result>0) {
			commit(conn);
		}else {
			rollback(conn);
		}
		close(conn);
		return result;
	}
	
	/**
	 * 쿠폰번호로 쿠폰을 삭제하는 메소드
	 * @param no 삭제할 쿠폰번호
	 * @return 결과값
	 */
	public int couponDelete(int no) {
		Connection conn = getConnection();
		int result = new AdminDao2().couponDelete(conn,no);
		if(result>0) {
			commit(conn);
		}else {
			rollback(conn);
		}
		close(conn);
		return result;
	}
	
	/**
	 * 회원쿠폰고유번호로 쿠폰보유내역 삭제하는 메소드
	 * @param no 회원쿠폰고유번호
	 * @return 결과값
	 */
	public int deleteUserCp(int no) {
		Connection conn = getConnection();
		int result = new AdminDao2().deleteUserCp(conn,no);
		if(result>0) {
			commit(conn);
		}else {
			rollback(conn);
		}
		close(conn);
		return result;
	}
	
	/**
	 * 회원번호와쿠폰번호로 유저에게 쿠폰전달하는메소드
	 * @param userNo 회원쿠폰고유번호
	 * @param cpNO 쿠폰번호
	 * @return 결과값
	 */
	public int insertUserCp(int userNo,int cpNo) {
		Connection conn = getConnection();
		int result = new AdminDao2().insertUserCp(conn,userNo,cpNo);
		if(result>0) {
			commit(conn);
		}else {
			rollback(conn);
		}
		close(conn);
		return result;
	}
	
	/**
	 * 결제내역고유번호로 환불승인하는 메소드
	 * @param payNo 결제내역고유번호
	 * @return 결과값
	 */
	public int refundAccess(int payNo) {
		Connection conn = getConnection();
		int result = new AdminDao2().refundAccess(conn,payNo);
		if(result>0) {
			commit(conn);
		}else {
			rollback(conn);
		}
		close(conn);
		return result;
	}
	
	/**
	 * 결제내역고유번호로 환불거절하는 메소드
	 * @param payNo 결제내역고유번호
	 * @return 결과값
	 */
	public int refundDeny(int payNo) {
		Connection conn = getConnection();
		int result = new AdminDao2().refundDeny(conn,payNo);
		if(result>0) {
			commit(conn);
		}else {
			rollback(conn);
		}
		close(conn);
		return result;
	}
	
	public ArrayList<Member> memberSimpleInfo() {
		Connection conn = getConnection();
		ArrayList<Member> list = new AdminDao2().memberSimpleInfo(conn);
		close(conn);
		return list;
	}
	
	public ArrayList<Member> rbutton(String sql){
		Connection conn = getConnection();
		ArrayList<Member> list = new AdminDao2().rbutton(conn,sql);
		close(conn);
		return list;
	}
	
	public ArrayList<Integer> sbutton(String search){
		Connection conn = getConnection();
		ArrayList<Integer> list = new AdminDao2().sbutton(conn,search);
		close(conn);
		return list;
	}
	
	public int cpSendButton(int cpNo,int userNo) {
		Connection conn = getConnection();
		int result = new AdminDao2().cpSendButton(conn,cpNo,userNo);
		if(result>0) {
			commit(conn);
		}else {
			rollback(conn);
		}
		close(conn);
		return result;
	}
	
	public int totalMember() {
		Connection conn = getConnection();
		int totalMember = new AdminDao2().totalMember(conn);
		close(conn);
		return totalMember;
	}
	
	public int totalStu() {
		Connection conn = getConnection();
		int totalStu = new AdminDao2().totalStu(conn);
		close(conn);
		return totalStu;
	}
	
	public int totalMentor() {
		Connection conn = getConnection();
		int totalMentor = new AdminDao2().totalMentor(conn);
		close(conn);
		return totalMentor;
	}
	
	public int todayConnect() {
		Connection conn = getConnection();
		int todayConnect = new AdminDao2().todayConnect(conn);
		close(conn);
		return todayConnect;
	}
	
	public int todayPay() {
		Connection conn = getConnection();
		int todayPay = new AdminDao2().todayPay(conn);
		close(conn);
		return todayPay;
	}

	public int rqRefundCount() {
		Connection conn = getConnection();
		int rqRefundCount = new AdminDao2().rqRefundCount(conn);
		close(conn);
		return rqRefundCount;
	}
}
