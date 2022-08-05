package com.jj.classSelect.controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.jj.classSelect.model.service.ClassService;
import com.jj.member.model.vo.Member;

/**
 * Servlet implementation class AjaxBookmarkSelectController
 */
@WebServlet("/checkBm.cl")
public class AjaxBookmarkSelectController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public AjaxBookmarkSelectController() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		int clNo = Integer.parseInt(request.getParameter("clNo"));
		int userNo = (int)((Member)request.getSession().getAttribute("loginUser")).getUserNo();
		
		// 이전에 찜 한 이력이 있는지 먼저 확인한 후 버튼에 출력할 html 결정
		int likeCheck = new ClassService().selectBookmark(clNo, userNo);
		
		response.getWriter().print(likeCheck);
		
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
