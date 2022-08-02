package com.jj.member.controller;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.jj.member.model.vo.Member;
import com.jj.userMyPage.model.service.CouponListService;
import com.jj.userMyPage.model.vo.UCoupon;

/**
 * Servlet implementation class myPageMainController
 */
@WebServlet("/myPage.my")
public class myPageMainController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public myPageMainController() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	
		
		//		request.getRequestDispatcher("views/userMyPage/userMyPageMain.jsp").forward(request, response);;
		HttpSession session = request.getSession();
		
		
		
		Member m =(Member) session.getAttribute("loginUser");
		int userDivision = m.getUserDivision();
		
		int mtGrade = m.getMtGrade();
		
//		
//		if(loginUser == null) {// 로그인 실패
//			
//			session.setAttribute("alertMsg", "회원 로그인 실패");
//			response.sendRedirect(request.getContextPath() + "/userlogin.me");
//			
//		}else {// 로그인 성공
//			session.setAttribute("loginUser", loginUser);
//			
//			if (loginUser.getMtGrade() == 1) { // mtgrade = 1 >> 현직자
//
//				session.setAttribute("alertMsg", "현직자 로그인 성공");
//				response.sendRedirect(request.getContextPath() + "/userlogin.me");
//
//			} else if (loginUser.getMtGrade() == 0) { // mtgrade = 0 >> 사용자
//				
//				session.setAttribute("alertMsg", "사용자 로그인 성공");
//				response.sendRedirect(request.getContextPath() + "/userlogin.me");
//				
//			} else { // mtgrade = 2 >> 강의자
//
//				session.setAttribute("alertMsg", "강의자 로그인 성공");
//				response.sendRedirect(request.getContextPath() + "/userlogin.me");
//			}
//			
//			System.out.println("mtgrade= " + loginUser.getMtGrade());
//			System.out.println(loginUser);
		
	 if(userDivision ==1){ //일반회원
//		
			request.getRequestDispatcher("views/userMyPage/userMyPageMain2.jsp").forward(request, response);
			
			
		
		}else if(userDivision ==2) {//멘토회원
			
			if(mtGrade==1) {	//  mtgrade = 1 >> 현직자
				request.getRequestDispatcher("views/mentorMyPage/mentorClassManage.jsp").forward(request, response);
				
			}else {
				 // mtgrade = 2 >> 강의자
				request.getRequestDispatcher("views/mentorMyPage/mentorClassManage.jsp").forward(request, response);
			}
			
		}else {
			
			session.setAttribute("alertMsg", "로그인 후 이용 가능한 서비스 입니다.");
			response.sendRedirect(request.getContextPath()+"/userlogin.me");
			
			
		}
//			 int userNo = (Member)(request.getSession().getAttribute("loginUser").getUserNo());
		
//			 HttpSession session = request.getSession();
//			 int userNo = ((Member)session.getAttribute("loginUser")).getUserNo();
//			int userNo = ((Member)(request.getSession().getAttribute("userNo"));
//			현직자인지 강의자인지 찾을 서비스이고 userNo을 들고
//			return 값은 int (1번 현직자 )
//					userNo을 가진사람이 1번인지2번인지
					
					
////			if(조회해온 멘토 값이 현직자이면) {
//				request.getRequestDispatcher("views/mentorMyPage/mentorMyPageMain.jsp").forward(request, response);
//			}else { //강의자이면
			
		
//		 userDivision은 number값인데 int로 가져오면 null이 0? 안되면 select시 NVL함수 써서 바꾸기
	
			
	


	
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
