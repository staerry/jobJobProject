package com.jj.userMyPage.controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.jj.mentorMyPage.model.vo.Vod;
import com.jj.userMyPage.model.service.UserClassService;

/**
 * Servlet implementation class UserVodDetailViewController
 */
@WebServlet("/userVodDetail.my")
public class UserVodDetailViewController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public UserVodDetailViewController() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		int vodNo = Integer.parseInt(request.getParameter("vodNo"));
		Vod vod = new UserClassService().selectOneVod(vodNo);
		System.out.println(vod);
		request.setAttribute("vod", vod);
		request.getRequestDispatcher("views/userMyPage/userMyClassIngVideoDetailView.jsp").forward(request, response);

	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
