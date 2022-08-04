package com.jj.classSelect.controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.jj.classSelect.model.service.ClassService;
import com.jj.member.model.vo.Member;

/**
 * Servlet implementation class ClassEnrollController
 */
@WebServlet("/enroll.cl")
public class ClassEnrollController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ClassEnrollController() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		request.setCharacterEncoding("UTF-8");

		HttpSession session = request.getSession();
		
		int userNo = (int)((Member)request.getSession().getAttribute("loginUser")).getUserNo();
		
		String orderName = request.getParameter("orderName");
		String orderPhone = request.getParameter("orderPhone");
		String orderEmail = request.getParameter("orderEmail");
		
		int clNo = Integer.parseInt(request.getParameter("clNo"));
		
		// isuCpNo ==> Null(쿠폰을 사용하지 않은 경우) | "숫자"
		String isuCpNo = request.getParameter("isuCpNo");
		// null일 경우는 Service에서 IssuanceCoupon 테이블에 대한 처리 하도록 하지 않음
		
		String payment = request.getParameter("payment");
		int finalPayment = Integer.parseInt(request.getParameter("totalPrice"));
				
		System.out.println("userNo : " + userNo);
		System.out.println("orderName : " + orderName);
		System.out.println("orderPhone : " + orderPhone);
		System.out.println("orderEmail : " + orderEmail);
		System.out.println("clNo : "+ clNo);
		System.out.println("payment : " + payment);
		System.out.println("finalPayment : " + finalPayment);
		System.out.println("isuCpNo : " + isuCpNo);
		
		int result = new ClassService().enrollClass(userNo, clNo, orderName, orderPhone, orderEmail, payment, finalPayment, isuCpNo);
		
		if(result > 0) {
			request.getRequestDispatcher("views/classSelect/classEnrollResult.jsp").forward(request, response);
		}else {
			session.setAttribute("alertMsg", "문제가 발생했습니다. 잠시 후에 다시 시도해 주세요.");
			response.sendRedirect(request.getContextPath() + "/list.cl");
		}
		
		System.out.println(result);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
