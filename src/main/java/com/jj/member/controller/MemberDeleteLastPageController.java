package com.jj.member.controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.jj.member.model.service.MemberService;

/**
 * Servlet implementation class MemberDeleteLastPageController
 */
@WebServlet("/deleteLast.me")
public class MemberDeleteLastPageController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public MemberDeleteLastPageController() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		String userId = request.getParameter("userId");
		String userPwd = request.getParameter("userPwd");
		
		int result = new MemberService().deleteMember(userId, userPwd);
		
		HttpSession session = request.getSession();
		
		if(result > 0) {
			
			session.setAttribute("alertMsg", "회원탈퇴 성공");
			session.removeAttribute("loginUser");
			request.getRequestDispatcher("views/member/memberDeleteLastPage.jsp").forward(request, response);
			
			
		}else {
			
			session.setAttribute("alertMsg", "회원탈퇴 실패");
			response.sendRedirect(request.getContextPath());
			
			
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
