package com.jj.admin.controller;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.jj.admin.model.service.AdminService;
import com.jj.common.model.vo.PageInfo;
import com.jj.member.model.vo.Member;

/**
 * Servlet implementation class StudentInfoSearchController
 */
@WebServlet("/stuInfoSearch.sr")
public class StudentInfoSearchController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public StudentInfoSearchController() {
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
		int lpage;
		
		int p = Integer.parseInt(request.getParameter("p"));
		
		String[] arr = request.getParameterValues("check");
		
		String search= request.getParameter("search");
		
		ArrayList<Member> list = new ArrayList<>();
		
		if(arr.length==2) {
			listCount = new AdminService().stuListCountSearch(search);
			currentPage = p;
			pageLimit = 5;
			boardLimit = 10;
			maxPage =  (int)Math.ceil( (double)listCount / boardLimit );
			startPage = (currentPage-1) / pageLimit * pageLimit + 1;
			endPage = startPage + pageLimit - 1;
			if(endPage>maxPage) {
				endPage = maxPage;
			}
			lpage = listCount-boardLimit*(currentPage-1);
			PageInfo pi = new PageInfo(listCount,currentPage,pageLimit,boardLimit,maxPage,startPage,endPage);
			
			list = new AdminService().stuInfoAll(pi,search);
	
			request.setAttribute("lpage", lpage);
			request.setAttribute("pi", pi);
			request.setAttribute("list", list);
			request.getRequestDispatcher("views/admin/studentInfoSearch.jsp").forward(request, response);
			
		}else if(arr[0].equals("2")) {
			listCount = new AdminService().stuInfoOutCount(search);
			currentPage = p;
			pageLimit = 5;
			boardLimit = 10;
			maxPage =  (int)Math.ceil( (double)listCount / boardLimit );
			startPage = (currentPage-1) / pageLimit * pageLimit + 1;
			endPage = startPage + pageLimit - 1;
			if(endPage>maxPage) {
				endPage = maxPage;
			}
			lpage = listCount-boardLimit*(currentPage-1);
			PageInfo pi = new PageInfo(listCount,currentPage,pageLimit,boardLimit,maxPage,startPage,endPage);
			
			list = new AdminService().stuInfoOutSearch(pi,search);
			request.setAttribute("lpage", lpage);
			request.setAttribute("pi", pi);
			request.setAttribute("list", list);
		}else if(arr[0].equals("1")) {
			response.sendRedirect(request.getContextPath()+"/stuInfo.li?p=1");
		}else {
			response.sendRedirect(request.getContextPath()+"/stuInfo.li?p=1");
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
