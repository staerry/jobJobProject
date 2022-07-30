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
 * Servlet implementation class paymentSelectController
 */
@WebServlet("/paymentselect.bo")
public class paymentSelectController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public paymentSelectController() {
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
		
		//-----------------------------------------------------------------------------------
		
		if(check.length==2) {
			
			listCount = new AdminService2().selectAllUserCount(search);
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
			
			
			list = new AdminService2().mentorInfo(pi,search);
			
			request.setAttribute("check", check);
			request.setAttribute("search", search);
			request.setAttribute("lpage", lpage);
			request.setAttribute("pi", pi);
			request.setAttribute("list", list);
			
			request.getRequestDispatcher("views/admin/paymentSelect.jsp").forward(request, response);
		}else {
			System.out.println("error");
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
