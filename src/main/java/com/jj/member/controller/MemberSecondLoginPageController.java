package com.jj.member.controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.jj.member.model.service.MemberService;
import com.jj.member.model.vo.Member;

/**
 * Servlet implementation class MemberSecondLoginPageController
 */
@WebServlet("/secondLogin.do")
public class MemberSecondLoginPageController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public MemberSecondLoginPageController() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		request.setCharacterEncoding("UTF-8");
		
		String userId = request.getParameter("userId");
		String userPwd = request.getParameter("userPwd");
		
		Member loginUser = new MemberService().loginMember(userId, userPwd);
		
		HttpSession session = request.getSession();
		if(loginUser == null) {// 로그인 실패
			
			session.setAttribute("alertMsg", "회원 로그인 실패");
			response.sendRedirect(request.getContextPath() + "/userlogin.me");
			
		}else {// 로그인 성공
			session.setAttribute("loginUser", loginUser);
			
			if (loginUser.getMtGrade() == 1) { // mtgrade = 1 >> 현직자

				session.setAttribute("alertMsg", "현직자 로그인 성공");
				response.sendRedirect(request.getContextPath() + "/userlogin.me");

			} else if (loginUser.getMtGrade() == 0) { // mtgrade = 0 >> 사용자
				
				session.setAttribute("alertMsg", "사용자 로그인 성공");
				response.sendRedirect(request.getContextPath() + "/userlogin.me");
				
			} else { // mtgrade = 2 >> 강의자

				session.setAttribute("alertMsg", "강의자 로그인 성공");
				response.sendRedirect(request.getContextPath() + "/userlogin.me");
			}
			
			System.out.println("mtgrade= " + loginUser.getMtGrade());
			System.out.println(loginUser);
		
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
