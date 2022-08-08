package com.jj.userMyPage.controller;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.jj.mentorMyPage.model.vo.Vod;
import com.jj.userMyPage.model.service.UserClassService;

/**
 * Servlet implementation class UserVodListController
 */
@WebServlet("/userVodList.my")
public class UserVodListController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public UserVodListController() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		int clNo = Integer.parseInt(request.getParameter("class"));
		List<Vod> list = new UserClassService().selectVodListByClNo(clNo);
		System.out.println(list);
		
		request.setAttribute("list", list);
		request.getRequestDispatcher("views/userMyPage/userMyClassIngVideoList.jsp").forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
