package com.jj.admin.controller;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.jj.admin.model.service.AdminService2;
import com.jj.common.model.vo.PageInfo;
import com.jj.member.model.vo.Member;
import com.jj.pay.model.vo.Pay;

/**
 * Servlet implementation class RefundFinishCotroller
 */
@WebServlet("/refundFinish.li")
public class RefundFinishCotroller extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public RefundFinishCotroller() {
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
		
		String[] check = request.getParameterValues("check");

		if(check==null) {
			check=new String[]{"1","2"};
		}
		
		String search = "";
		if(request.getParameter("search")!=null) {
			search= request.getParameter("search");
		}
		
		ArrayList<Pay> list = new ArrayList<>();
		HttpSession session = request.getSession();
		
		//-------------------------------------------------------------------------
		
		if(check.length==2) {
			listCount = new AdminService2().paymentRefundFinishCount(search);
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
			
			
			list = new AdminService2().paymentRefundFinish(pi,search);
			
			request.setAttribute("check", check);
			request.setAttribute("search", search);
			request.setAttribute("lpage", lpage);
			request.setAttribute("pi", pi);
			request.setAttribute("list", list);
			request.getRequestDispatcher("views/admin/refundFinish.jsp").forward(request, response);
		}
		//--------------------------------------------------------------------------------
		else if(check[0].equals("1")) {
			listCount = new AdminService2().paymentRefundListCount(search);
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
			
			
			list = new AdminService2().paymentRefundList(pi,search);
			
			request.setAttribute("check", check);
			request.setAttribute("search", search);
			request.setAttribute("lpage", lpage);
			request.setAttribute("pi", pi);
			request.setAttribute("list", list);
			request.getRequestDispatcher("views/admin/refundFinish.jsp").forward(request, response);
		}
		//-------------------------------------------------------------------------------------
		else if(check[0].equals("2")){
			listCount = new AdminService2().paymentRefundDenyCount(search);
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
			
			
			list = new AdminService2().paymentRefundDeny(pi,search);
			
			request.setAttribute("check", check);
			request.setAttribute("search", search);
			request.setAttribute("lpage", lpage);
			request.setAttribute("pi", pi);
			request.setAttribute("list", list);
			request.getRequestDispatcher("views/admin/refundFinish.jsp").forward(request, response);
		}
		//--------------------------------------------------------------------------------------
		else {
			request.getSession().setAttribute("alertMsg", "오류");
			request.getRequestDispatcher("views/admin/refundFinish.jsp").forward(request, response);
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
