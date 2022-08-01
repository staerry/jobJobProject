package com.jj.admin.controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.jj.admin.model.service.AdminService;

/**
 * Servlet implementation class MentorQueDeleteController
 */
@WebServlet("/deleteQue.ad")
public class MentorQueDeleteController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public MentorQueDeleteController() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		int queNo = Integer.parseInt(request.getParameter("no"));
		
		int result = new AdminService().deleteQue(queNo);
		
		if(result > 0) {
			request.getSession().setAttribute("alertMsg", "삭제를 완료 했습니다.");
		}else {
			request.getSession().setAttribute("alertMsg", "삭제에 실패 했습니다.");
		}
		
		response.sendRedirect(request.getContextPath() + "/mentorQueListView.ad?cpage=1");
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
