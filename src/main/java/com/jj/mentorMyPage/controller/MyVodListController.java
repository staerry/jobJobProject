package com.jj.mentorMyPage.controller;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.jj.mentorMyPage.model.service.MentorMyService;
import com.jj.mentorMyPage.model.vo.Vod;

/**
 * Servlet implementation class MyVodListController
 */
@WebServlet("/myVodList.my")
public class MyVodListController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public MyVodListController() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		request.setCharacterEncoding("utf-8");
		int clNo = Integer.parseInt(request.getParameter("clNo"));
		String clTitle = request.getParameter("clTitle");
		List<Vod> list = new MentorMyService().selectVodList(clNo);
		
		request.setAttribute("list", list);
		request.setAttribute("clNo", clNo);
		request.setAttribute("clTitle", clTitle);
		request.getRequestDispatcher("views/mentorMyPage/uploadVodList.jsp").forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
