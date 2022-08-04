package com.jj.admin.controller;

import static com.jj.common.JDBCTemplate.commit;
import static com.jj.common.JDBCTemplate.rollback;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.jj.admin.model.service.AdminService2;

/**
 * Servlet implementation class RefundAccessController
 */
@WebServlet("/refundAccess.up")
public class RefundAccessController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public RefundAccessController() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		int payNo = Integer.parseInt(request.getParameter("payNo"));
		int isucpNo = Integer.parseInt(request.getParameter("isucpNo"));
		int userNo = Integer.parseInt(request.getParameter("userNo"));
		int clNo = Integer.parseInt(request.getParameter("clNo"));
		
		int result = new AdminService2().refundAccess(payNo,userNo,clNo);
		if(result>0) {
			if(isucpNo == 0) {
			request.getSession().setAttribute("alertMsg", "환불승인에 성공했습니다.");
			response.sendRedirect(request.getContextPath()+"/refundRequest.li?p=1");
			}else {
				int result2 = new AdminService2().refundCoupon(isucpNo);
				if(result2>0) {
					request.getSession().setAttribute("alertMsg", "환불승인과 쿠폰환불에 성공했습니다.");
					response.sendRedirect(request.getContextPath()+"/refundRequest.li?p=1");
				}else {
					request.getSession().setAttribute("alertMsg", "환불승인성공, 쿠폰환불실패.");
					response.sendRedirect(request.getContextPath()+"/refundRequest.li?p=1");
				}
			}
			
		}else {
			request.getSession().setAttribute("alertMsg", "환불승인에 실패했습니다.");
			response.sendRedirect(request.getContextPath()+"/refundRequest.li?p=1");
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
