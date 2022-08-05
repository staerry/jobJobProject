package com.jj.member.controller;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.jj.member.model.vo.Member;
import com.jj.mentorMyPage.model.service.MentorMyService;
import com.jj.mentorMyPage.model.vo.CreateClass;
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
		System.out.println(session);
		
		Member member =(Member) session.getAttribute("loginUser");
		System.out.println("loginUser: " + member);
//		int userDivision = m.getUserDivision();

		

	 if(member.getUserDivision() == 1){ //일반회원
//		
			request.getRequestDispatcher("views/userMyPage/userMyPageMain2.jsp").forward(request, response);
			
			
		
		}else if(member.getUserDivision() == 2) {//멘토회원
			
				//  mtgrade = 1 >> 현직자
				 // mtgrade = 2 >> 강의자
			List<CreateClass> list = new MentorMyService().selectClass(member.getUserNo());
			System.out.println(list);
			request.setAttribute("list", list);
			request.getRequestDispatcher("views/mentorMyPage/mentorClassManage.jsp").forward(request, response);
				
		}else {
			
			session.setAttribute("alertMsg", "로그인 후 이용 가능한 서비스 입니다.");
			response.sendRedirect(request.getContextPath()+"/userlogin.me");
			
			
		}

}			
					
////			if(조회해온 멘토 값이 현직자이면) {
//				request.getRequestDispatcher("views/mentorMyPage/mentorMyPageMain.jsp").forward(request, response);
//			}else { //강의자이면
			
		
//		 userDivision은 number값인데 int로 가져오면 null이 0? 안되면 select시 NVL함수 써서 바꾸기
	
			
	


	

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
