package com.jj.admin.controller;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.jj.admin.model.service.AdminService2;
import com.jj.common.model.vo.PageInfo;
import com.jj.coupon.vo.Coupon;
import com.jj.member.model.vo.Member;

/**
 * Servlet implementation class SendCouponController
 */
@WebServlet("/sendCoupon.ad")
public class SendCouponController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public SendCouponController() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		int listCount;
		int currentPage;
		int pageLimit;
		int boardLimit;
		int maxPage;
		int startPage;
		int endPage;
		
		int p = 1;
		if(request.getParameter("p")!=null) {
			p = Integer.parseInt(request.getParameter("p"));
		}
		
		listCount = new AdminService2().couponListCountA();
		currentPage = p;
		pageLimit = 3;
		boardLimit = 5;
		maxPage =  (int)Math.ceil( (double)listCount / boardLimit );
		startPage = (currentPage-1) / pageLimit * pageLimit + 1;
		endPage = startPage + pageLimit - 1;
		
		if(endPage>maxPage) {
			endPage = maxPage;
		}
		int lpage = listCount-boardLimit*(currentPage-1);
		PageInfo pi = new PageInfo(listCount,currentPage,pageLimit,boardLimit,maxPage,startPage,endPage);
		
		ArrayList<Coupon> list = new ArrayList<>();
		list = new AdminService2().couponListA(pi);
		
		request.setAttribute("lpage", lpage);
		request.setAttribute("pi", pi);
		request.setAttribute("list", list);

		//----------------------------------------------------------------------------------------------------------
		
		ArrayList<Member> list2 = new ArrayList<>();
		list2 = new AdminService2().memberSimpleInfo();
		request.setAttribute("list2", list2);
		
		request.getRequestDispatcher("views/admin/sendcoupon.jsp").forward(request, response);
		
		
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
