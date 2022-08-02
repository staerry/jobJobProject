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
		
		if(session.getAttribute("loginUser")== null) {
			
			session.setAttribute("alertMsg", "로그인 후 이용 가능한 서비스 입니다.");
			response.sendRedirect(request.getContextPath()+"/userlogin.me");
		
		}else if(userDivision ==1){ //일반회원
//			response 객체에 아무값도 안담아도 된다.세션객체에 로그인정보이미 담겨있으니..? (질문)
			request.getRequestDispatcher("views/userMyPage/userMyPageMain.jsp").forward(request, response);
		
		}else if(userDivision ==2) {//멘토회원
			
			request.getRequestDispatcher("views/mentorMyPage/mentorMyPageMain.jsp").forward(request, response);
			;
			session.setAttribute("alertMsg", "관리자입니다.");
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
	
			
		}else {//관리자
		
			
		}


	
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
