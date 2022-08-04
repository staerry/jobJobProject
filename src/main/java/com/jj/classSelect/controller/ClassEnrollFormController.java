package com.jj.classSelect.controller;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.jj.classSelect.model.service.ClassService;
import com.jj.classSelect.model.vo.Class;
import com.jj.coupon.vo.IssuanceCoupon;
import com.jj.member.model.vo.Member;

/**
 * Servlet implementation class ClassEnrollFormController
 */
@WebServlet("/enrollForm.cl")
public class ClassEnrollFormController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ClassEnrollFormController() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		int clNo = Integer.parseInt(request.getParameter("class"));
		int userNo = (int)((Member)request.getSession().getAttribute("loginUser")).getUserNo();
		
		// 1) CLASS_ING에 값이 있는지 먼저 조회해야 함 
		// ==> count == 0인 경우 아직 수강 전인 강의
		// ==> 다음 단계 진행
		int listCount = new ClassService().classEnrollCheck(userNo, clNo);
		
		Class c = null;
		ArrayList<IssuanceCoupon> list = new ArrayList<>();
		
		if(listCount == 0) {	// 이전에 수강신청 한 적이 없는 경우
			c = new ClassService().selectClassEnroll(clNo);
			list = new ClassService().selectCouponList(userNo);
			
			request.setAttribute("c", c);
			request.setAttribute("list", list);
			
			request.getRequestDispatcher("views/classSelect/classEnrollForm.jsp").forward(request, response);
		
		// 2) count > 0 인 경우 수강 중인 강의
		// ==> alertMsg	
		}else {	// 이미 수강신청 된 강의인 경우
			request.getSession().setAttribute("alertMsg", "이미 수강 중인 강의입니다.");
			response.sendRedirect(request.getContextPath()+"/list.cl");
		}
		
		System.out.println(listCount);
		
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
