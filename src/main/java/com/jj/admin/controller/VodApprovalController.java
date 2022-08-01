package com.jj.admin.controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.jj.admin.model.service.AdminService;

/**
 * Servlet implementation class VodApprovalController
 */
@WebServlet("/vodApproval.ad")
public class VodApprovalController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public VodApprovalController() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		int vodNo = Integer.parseInt(request.getParameter("no"));
		int answer = Integer.parseInt(request.getParameter("answer"));
		
		int result = new AdminService().vodApproval(vodNo, answer);
		
		if(result > 0) {
			if(answer == 1) {				
				request.getSession().setAttribute("alertMsg", "승인 했습니다.");
			}else {
				request.getSession().setAttribute("alertMsg", "거절 했습니다.");
			}
		}else {
			if(answer == 1) {				
				request.getSession().setAttribute("alertMsg", "승인을 실패 했습니다.");
			}else {
				request.getSession().setAttribute("alertMsg", "거절을 실패 했습니다.");
			}
		}
		
		response.sendRedirect(request.getContextPath() + "/mentorVodApprovalListView.ad?cpage=1");
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
