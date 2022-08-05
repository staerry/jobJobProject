package com.jj.userMyPage.controller;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.jj.member.model.vo.Member;
import com.jj.userMyPage.model.service.MyPaymentService;
import com.jj.userMyPage.model.vo.Payment;

/**
 * Servlet implementation class MyPaymentDetailsController
 */
@WebServlet("/paymentDetails.my")
public class MyPaymentDetailsController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public MyPaymentDetailsController() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	
		//HttpSession session = request.getSession();
		
		//int userNo = ((Member)session.getAttribute("loginUser")).getUserNo();
		
		int payNo = Integer.parseInt(request.getParameter("payNo"));
		
		
		Payment p = new MyPaymentService().myPaymentDetails(payNo);
		 
		
		
		request.setAttribute("p", p);

		request.getRequestDispatcher("views/userMyPage/myPaymentDetails.jsp").forward(request, response);
		
		System.out.println(p);
		
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
