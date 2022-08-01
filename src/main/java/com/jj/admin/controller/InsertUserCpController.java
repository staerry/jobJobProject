package com.jj.admin.controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.jj.admin.model.service.AdminService2;

/**
 * Servlet implementation class InsertUserCpController
 */
@WebServlet("/insertUserCp.up")
public class InsertUserCpController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public InsertUserCpController() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		int userNo = Integer.parseInt(request.getParameter("userNo"));
		int cpNo = Integer.parseInt(request.getParameter("cpNo"));
		int result = new AdminService2().insertUserCp(userNo,cpNo);
		
		if(result>0) {
			request.getSession().setAttribute("alertMsg", "재지급에 성공했습니다.");
			response.sendRedirect(request.getContextPath()+"/selectCoupon.li?p=1");
		}else {
			request.getSession().setAttribute("alertMsg", "재지급에 실패했습니다.");
			response.sendRedirect(request.getContextPath()+"/selectCoupon.li?p=1");
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
