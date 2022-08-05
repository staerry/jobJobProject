package com.jj.admin.controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import com.jj.classSelect.model.vo.Class;
import com.jj.admin.model.service.AdminService;

/**
 * Servlet implementation class MentorClassApprovalInfoPage
 */
@WebServlet("/mentorClassApprovalInfoView.ad")
public class MentorClassApprovalInfoPage extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public MentorClassApprovalInfoPage() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		int classNo = Integer.parseInt(request.getParameter("no"));
		int userNo = Integer.parseInt(request.getParameter("userno"));
		
		Class classInfo = new AdminService().selectClassApproval(classNo);
		
		request.setAttribute("class", classInfo);
		request.setAttribute("userno", userNo);
		request.getRequestDispatcher("views/admin/mentorClassInsertInfo.jsp").forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
