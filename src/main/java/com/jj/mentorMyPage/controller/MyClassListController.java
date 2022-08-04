package com.jj.mentorMyPage.controller;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.jj.member.model.vo.Member;
import com.jj.mentorMyPage.model.service.MentorMyService;
import com.jj.mentorMyPage.model.vo.CreateClass;

/**
 * Servlet implementation class MyClassListController
 */
@WebServlet("/classList.my")
public class MyClassListController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public MyClassListController() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		HttpSession session = request.getSession();
		Member m = ((Member)session.getAttribute("loginUser"));
		System.out.println(m);
		
		int userNo = m.getUserNo();
		
		ArrayList<CreateClass> list = new ArrayList<>();
		
		list = new MentorMyService().selectClass(userNo);
		
		request.setAttribute("list", list);
		System.out.println("list: " + list);
	
		request.getRequestDispatcher("views/mentorMyPage/mentorClassManage.jsp").forward(request, response);
//		response.sendRedirect(request.getContextPath() + "/myPage.my");
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
