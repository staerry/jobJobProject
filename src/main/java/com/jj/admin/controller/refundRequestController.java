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
import com.jj.pay.model.vo.Pay;

/**
 * Servlet implementation class refundRequestController
 */
@WebServlet("/refundRequest.li")
public class refundRequestController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public refundRequestController() {
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
		
		int p = Integer.parseInt(request.getParameter("p"));
		
		String search = "";
		if(request.getParameter("search")!=null) {
			search= request.getParameter("search");
		}
		
		ArrayList<Pay> list = new ArrayList<>();
		
		listCount = new AdminService2().refundRequestCount(search);
		currentPage = Integer.parseInt(request.getParameter("p"));
		pageLimit = 5;
		boardLimit = 10;
		maxPage =  (int)Math.ceil( (double)listCount / boardLimit );
		startPage = (currentPage-1) / pageLimit * pageLimit + 1;
		endPage = startPage + pageLimit - 1;
		
		if(endPage>maxPage) {
			endPage = maxPage;
		}
		int lpage = listCount-boardLimit*(currentPage-1);
		PageInfo pi = new PageInfo(listCount,currentPage,pageLimit,boardLimit,maxPage,startPage,endPage);
		
		
		list = new AdminService2().refundRequestList(pi,search);
		
		request.setAttribute("search", search);
		request.setAttribute("lpage", lpage);
		request.setAttribute("pi", pi);
		request.setAttribute("list", list);
		
		
		
		
		request.getRequestDispatcher("views/admin/refundRequest.jsp").forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
