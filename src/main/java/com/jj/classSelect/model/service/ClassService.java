package com.jj.classSelect.model.service;

import static com.jj.common.JDBCTemplate.close;
import static com.jj.common.JDBCTemplate.commit;
import static com.jj.common.JDBCTemplate.getConnection;
import static com.jj.common.JDBCTemplate.rollback;

import java.sql.Connection;
import java.util.ArrayList;

import com.jj.classSelect.model.dao.ClassDao;
import com.jj.classSelect.model.vo.Class;
import com.jj.community.model.vo.Review;
import com.jj.coupon.vo.IssuanceCoupon;
import com.jj.member.model.vo.Member;

public class ClassService {
	
	public int selectListCountAll() {
		Connection conn = getConnection();
		int listCount = new ClassDao().selectListCountAll(conn);
		close(conn);
		return listCount;
	}
	
	public int selectListCount(String category) {
		Connection conn = getConnection();
		int listCount = new ClassDao().selectListCount(conn, category);
		close(conn);
		return listCount;
	}
	
	public ArrayList<Class> selectListAll() {
		Connection conn = getConnection();
		ArrayList<Class> list = new ClassDao().selectListAll(conn);
		close(conn);
		return list;
	}

	public ArrayList<Class> selectList(String category) {
		Connection conn = getConnection();
		ArrayList<Class> list = new ClassDao().selectList(conn, category);
		close(conn);
		return list;
	}
	
	public Class selectClass(int clNo) {
		Connection conn = getConnection();
		Class c = new ClassDao().selectClass(conn, clNo);
		close(conn);
		return c;
	}
	
	public int selectStudentCount(int clNo) {
		Connection conn = getConnection();
		int studentCount = new ClassDao().selectStudentCount(conn, clNo);
		close(conn);
		return studentCount;
	}
	
	public int selectBookmarkCount(int clNo) {
		Connection conn = getConnection();
		int bookmarkCount = new ClassDao().selectBookmarkCount(conn, clNo);
		close(conn);
		return bookmarkCount;
	}
	
	public ArrayList<Review> selectReview(int clNo) {
		Connection conn = getConnection();
		ArrayList<Review> list = new ClassDao().selectReview(conn, clNo);
		close(conn);
		return list;
	}
	
	public ArrayList<Class> selectListAllByPrice(){
		Connection conn = getConnection();
		ArrayList<Class> list = new ClassDao().selectListAllByPrice(conn);
		close(conn);
		return list;
	}
	
	public ArrayList<Class> selectListByPrice(String category){
		Connection conn = getConnection();
		ArrayList<Class> list = new ClassDao().selectListByPrice(conn, category);
		close(conn);
		return list;
	}
	
	public ArrayList<Class> selectListAllByScore() {
		Connection conn = getConnection();
		ArrayList<Class> list = new ClassDao().selectListAllByScore(conn);
		close(conn);
		return list;
		
	}
	
	public ArrayList<Class> selectListByScore(String category) {
		Connection conn = getConnection();
		ArrayList<Class> list = new ClassDao().selectListByScore(conn, category);
		close(conn);
		return list;
	}
	
	public Class selectClassEnroll(int clNo) {
		Connection conn = getConnection();
		Class c = new ClassDao().selectClassEnroll(conn, clNo);
		close(conn);
		return c;
	}
	
	public ArrayList<IssuanceCoupon> selectCouponList(int userNo) {
		Connection conn = getConnection();
		ArrayList<IssuanceCoupon> list = new ClassDao().selectCouponList(conn, userNo);
		close(conn);
		return list;
	}
	
	public int classEnrollCheck(int userNo, int clNo) {
		Connection conn = getConnection();
		int listCount = new ClassDao().classEnrollCheck(conn, userNo, clNo);
		close(conn);
		return listCount;
	}
	
	public int selectBuyFirst(int userNo) {
		Connection conn = getConnection();
		int firstCheck = new ClassDao().selectBuyFirst(conn, userNo);
		close(conn);
		return firstCheck;
		
	}
	
	// orderName, orderPhone, orderEmail, payment, finalPayment, isuCpNo
	public int enrollClass(int userNo, int clNo, String orderName, String orderPhone, String orderEmail, String payment, int finalPayment, String isuCpNo, int firstBuy) {
		
		// 1) PAY 테이블에 INSERT
		// 2) ISSUANCECOUPON 테이블에 UPDATE
		// 3) CLASS_ING 테이블에 INSERT
		// 4) 수강신청 이력이 없는 경우, 즉 firstCheck == 0 일 때는 ISSUANCECOUPON 테이블에 INSERT
		
		Connection conn = getConnection();
		
		int result = 0;	// 1) ~ 3) 전체 작업 수행 결과를 담음 ==> 1 == 성공 | 0 == 실패
		
		int payResult = 0;
		int couponResult = 1;
		
		if(isuCpNo != null) {	// 쿠폰을 사용한 경우 ==> pay 테이블에 넣고, issuancecoupon 테이블도 update
			payResult = new ClassDao().insertPayWithCoupon(conn, userNo, clNo, isuCpNo, payment, finalPayment, orderName, orderPhone, orderEmail);
			couponResult = new ClassDao().updateIssuanceCoupon(conn, isuCpNo, userNo);
		
		}else {	// 쿠폰을 사용하지 않은 경우 ==> pay 테이블에 isuCpNo 안 넣어도 되고, i.c 테이블도 not update
			payResult = new ClassDao().insertPayNoCoupon(conn, userNo, clNo, payment, finalPayment, orderName, orderPhone, orderEmail);
			// 쿠폰이 없으므로 i.s 쿠폰 UPDATE X
		}
		
		// 쿠폰과 상관 없이 class_ing 테이블은 항상 update
		int ingResult = new ClassDao().insertClassIng(conn, userNo, clNo);
		
		// 수강 이력이 없는 첫 구매인 경우 첫 구매 쿠폰 발급
		if(firstBuy == 0) {
			int issueFirstCpResult = new ClassDao().insertIssuanceFirstCoupon(conn, userNo);
			
			if(payResult > 0 && couponResult > 0  && ingResult > 0 && issueFirstCpResult > 0) {
				result = 1;
			}
			
		} else { 
			if(payResult > 0 && couponResult > 0  && ingResult > 0) {
			result = 1;
			}
		}
		
		if(result > 0) {
			commit(conn);
		}else {
			rollback(conn);
		}
		
		System.out.println("pay: " + payResult);
		System.out.println("coupon : " + couponResult);
		System.out.println("ing : " + ingResult);
		
		return result;
				
	}
	
	public int selectBookmark(int clNo, int userNo) {
		Connection conn = getConnection();
		int likeCheck = new ClassDao().selectBookmark(conn, clNo, userNo);
		close(conn);
		return likeCheck;
	}
	
	public int insertBookmark(int clNo, int userNo) {
		Connection conn = getConnection();
		int result = new ClassDao().insertBookmark(conn, clNo, userNo);
		if(result > 0) {
			commit(conn);
		}else {
			rollback(conn);
		}
		return result;
		
	}
	
	public int deleteBookmark(int clNo, int userNo) {
		Connection conn = getConnection();
		int result = new ClassDao().deleteBookmark(conn, clNo, userNo);
		if(result > 0) {
			commit(conn);
		}else {
			rollback(conn);
		}
		return result;
		
	}
	
	public ArrayList<Review> selectReviewByDate(int clNo) {
		Connection conn = getConnection();
		ArrayList<Review> sortedList = new ClassDao().selectReviewByDate(conn, clNo);
		close(conn);
		return sortedList;
	}
	
	public ArrayList<Review> selectReviewByScoreDesc(int clNo){
		Connection conn = getConnection();
		ArrayList<Review> sortedList = new ClassDao().selectReviewByScoreDesc(conn, clNo);
		close(conn);
		return sortedList;
			
	}
	
	public ArrayList<Review> selectReviewByScoreAsc(int clNo){
		Connection conn = getConnection();
		ArrayList<Review> sortedList = new ClassDao().selectReviewByScoreAsc(conn, clNo);
		close(conn);
		return sortedList;
	}
	
	public int selectNoRefund(int clNo) {
		Connection conn = getConnection();
		int noRefund = new ClassDao().selectNoRefund(conn, clNo);
		close(conn);
		return noRefund;
	}

	//작성자 이지원 
	public int selectIsClassing(Member member, int clNo) {
		Connection conn = getConnection();
		int result = new ClassDao().selectIsClassing(conn, member, clNo);
		close(conn);
		return result;
	}

}
