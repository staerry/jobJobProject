package com.jj.admin.controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.jj.admin.model.service.AdminService;

/**
 * Servlet implementation class NoticeDeleteController
 */
@WebServlet("/noticeDelete.ad")
public class NoticeDeleteController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public NoticeDeleteController() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		int noticeNo = Integer.parseInt(request.getParameter("no"));
		
		int result = new AdminService().deleteNotice(noticeNo);
		
		if(result > 0) {
			request.getSession().setAttribute("alertMsg", "공지사항 삭제를 성공 했습니다.");
		}else {
			request.getSession().setAttribute("alertMsg", "공지사항 삭제에 실패 했습니다.");
		}
		
		response.sendRedirect(request.getContextPath() + "/noticeListView.ad?cpage=1");
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
