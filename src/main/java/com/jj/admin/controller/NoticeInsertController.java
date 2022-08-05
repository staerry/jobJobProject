package com.jj.admin.controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.jj.admin.model.service.AdminService;
import com.jj.admin.model.vo.UserInfoAd;

/**
 * Servlet implementation class NoticeInsertController
 */
@WebServlet("/noticeInsertCotroller.ad")
public class NoticeInsertController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public NoticeInsertController() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");
		
		String noticeTitle = request.getParameter("noticeTitle");
		String noticeContent = request.getParameter("noticeContent");
		int userId = ((UserInfoAd)request.getSession().getAttribute("UserInfoAd")).getUserNo();
		
		int result = new AdminService().insertNotice(noticeTitle, noticeContent, userId);
		
		if(result > 0) {
			request.getSession().setAttribute("alertMsg", "작성을 완료 했습니다.");
			response.sendRedirect(request.getContextPath() + "/noticeListView.ad?cpage=1");
		}else {
			request.getSession().setAttribute("alertMsg", "작성을 실패 했습니다.");
			response.sendRedirect(request.getContextPath() + "/noticeListView.ad?cpage=1");
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