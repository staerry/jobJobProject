package com.jj.userMyPage.controller;

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
import com.jj.userMyPage.model.service.UserClassService;
import com.jj.userMyPage.model.vo.ClassIng;

/**
 * Servlet implementation class MyClassIng
 */
@WebServlet("/myClassIng.my")
public class MyClassIng extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public MyClassIng() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
//수강중인 강의 요청
		HttpSession session = request.getSession();

		Member member = (Member) session.getAttribute("loginUser");
		if(member != null) {
			List<ClassIng> list = new UserClassService().selectClassIngAllList(member);
			System.out.println(list);
			
			request.setAttribute("list", list);
			request.getRequestDispatcher("views/userMyPage/userMyClassIng.jsp").forward(request, response);
		}else {
			request.setAttribute("alertMsg", "로그인이 필요합니다");
			request.getRequestDispatcher("views/member/memberLoginSecond.jsp").forward(request, response);
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
