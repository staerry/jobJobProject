package com.jj.userMyPage.controller;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;


import com.jj.member.model.vo.Member;
import com.jj.userMyPage.model.service.ReplyListService;
import com.jj.userMyPage.model.vo.Reply;


/**
 * Servlet implementation class SelectMyReplyController
 */
@WebServlet("/myReply.my")
public class SelectMyReplyController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public SelectMyReplyController() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		HttpSession session = request.getSession();
		
		int userNo = ((Member)session.getAttribute("loginUser")).getUserNo();
		
		
		ArrayList <Reply> list = new ReplyListService().selectMyReply(userNo);
		 
		
		
		request.setAttribute("list", list);

		request.getRequestDispatcher("views/userMyPage/selectMyReply.jsp").forward(request, response);
		
		System.out.println(list);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
