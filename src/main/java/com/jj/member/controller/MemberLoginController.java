package com.jj.member.controller;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.jj.member.model.service.MemberService;
import com.jj.member.model.vo.Member;

/**
 * Servlet implementation class userLoginController
 */
@WebServlet("/login.me")
public class MemberLoginController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public MemberLoginController() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		request.getRequestDispatcher("views/member/memberLoginSecond.jsp").forward(request, response);
		
		
		/*
		request.setCharacterEncoding("UTF-8");
			
			String userId = request.getParameter("userId");
			String userPwd = request.getParameter("userPwd");
				
			Member loginUser = new MemberService().loginMember(userId, userPwd);			
				
			if(loginUser == null) { // 조회결과 없음 == 로그인 실패 => 에러페이지 뜨도록
					
				/*
				RequestDispatcher view = request.getRequestDispatcher("views/common/errorPage.jsp");
					
				request.setAttribute("errorMsg", "로그인 실패했습니다.");
					
				view.forward(request, response); // * 포워딩방식 (forward) : 해당 경로로 선택된 뷰가 보여질 뿐 url은 변경되지 않음
				*/
			
		/*
				HttpSession session = request.getSession();
				session.setAttribute("alertMsg", "회원로그인에 실패했습니다.");
				response.sendRedirect(request.getContextPath() + "/secondLogin.me");
				
			}else { // 로그인 성공 => 조회결과 있음 => 메인페이지(index.jsp)응답
					
				HttpSession session = request.getSession();
				session.setAttribute("loginUser", loginUser);
				response.sendRedirect(request.getContextPath());// * url재요청 방식 (redirect) : 기존에 저 페이지를 응답하는 url이 존재할 경우
			}
			*/
	
		
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
