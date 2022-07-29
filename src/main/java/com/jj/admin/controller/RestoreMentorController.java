package com.jj.admin.controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.jj.admin.model.service.AdminService2;

/**
 * Servlet implementation class WithdrawalMentorController
 */
@WebServlet("/restoreMen.up")
public class RestoreMentorController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public RestoreMentorController() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String prevNo = request.getParameter("no");
		int startNo = prevNo.indexOf("(");
		int endNo = prevNo.lastIndexOf(")");
		int no = Integer.parseInt(prevNo.substring(startNo+1, endNo));
		
		int result = new AdminService2().restoreMen(no);

		if(result>0) {
			request.getSession().setAttribute("alertMsg", "회원복구에 성공했습니다.");
			response.sendRedirect(request.getContextPath()+"/mentorInfo.li?p=1");
		}else {
			request.getSession().setAttribute("alertMsg", "회원복구에 실패했습니다.");
			response.sendRedirect(request.getContextPath()+"/mentorInfo.li?p=1");
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
