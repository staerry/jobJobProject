package com.jj.admin.controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.jj.admin.model.service.AdminService;

/**
 * Servlet implementation class MentorClassApprovalFusalController
 */
@WebServlet("/classApprovalFusal.ad")
public class MentorClassApprovalFusalController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public MentorClassApprovalFusalController() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		int classNo = Integer.parseInt(request.getParameter("no"));
		
		int result = new AdminService().classApprovalFusal(classNo);
		
		if(result > 0) {
			request.getSession().setAttribute("alertMsg", "승인을 거절 했습니다.");
		}else {
			request.getSession().setAttribute("alertMsg", "승인거절을 실패했습니다.");
		}
		
		response.sendRedirect(request.getContextPath() + "/mentorClassApprovalListView.ad?cpage=1");
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
