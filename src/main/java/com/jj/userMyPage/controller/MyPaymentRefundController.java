package com.jj.userMyPage.controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.jj.userMyPage.model.service.MyPaymentService;

/**
 * Servlet implementation class MyPaymentRefund
 */
@WebServlet("/paymentRefund.my")
public class MyPaymentRefundController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public MyPaymentRefundController() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		int payNo = Integer.parseInt(request.getParameter("payNo"));
		
		int result = new MyPaymentService().myPaymentRefund(payNo);
	
		request.setAttribute("payNo", payNo);
		
		System.out.println(result);
		
		if(result > 0) {
			
			request.getRequestDispatcher("views/userMyPage/myPaymentRefund.jsp").forward(request, response);
			
		}else {
			
			response.sendRedirect(request.getContextPath());
			
			
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
