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
import com.jj.member.model.vo.Member;

/**
 * Servlet implementation class MentorInfoController
 */
@WebServlet("/mentorInfo.li")
public class MentorInfoController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public MentorInfoController() {
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
		
		String[] arr = request.getParameterValues("check");
		
		String check="";
		if(arr==null || arr[0].equals("none")) {
			check="none";
		}else if(arr[0].equals("1") && arr.length == 1) {
			check = "1";
		}else if(arr[0].equals("2") && arr.length == 1) {
			check = "2";
		}else if(arr[0].equals("3") && arr.length == 1) {
			check = "3";
		}else {
			check = "all";
		}
		
		String search = "";
		if(request.getParameter("search")!=null) {
			search= request.getParameter("search");
		}
		
		ArrayList<Member> list = new ArrayList<>();
		
		//-----------------------------------------------------------------------------------
		
		if(check.equals("none") || check.equals("all")) {
			listCount = new AdminService2().selectMentorListCount(search);
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
			request.getRequestDispatcher("views/admin/mentorInfo.jsp").forward(request, response);
			
		//----------------------------------------------------------------------------
			
		}else if(check.equals("1")) {
			listCount = new AdminService2().currentCount(search);
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
			
			
			list = new AdminService2().currentInfo(pi,search);
			
			request.setAttribute("check", check);
			request.setAttribute("search", search);
			request.setAttribute("lpage", lpage);
			request.setAttribute("pi", pi);
			request.setAttribute("list", list);
			request.getRequestDispatcher("views/admin/mentorInfo.jsp").forward(request, response);
			
		//---------------------------------------------------------------------------
			
		}else if(check.equals("2")) {
			listCount = new AdminService2().lecturerCount(search);
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
			
			
			list = new AdminService2().lecturerList(pi,search);
			
			request.setAttribute("check", check);
			request.setAttribute("search", search);
			request.setAttribute("lpage", lpage);
			request.setAttribute("pi", pi);
			request.setAttribute("list", list);
			request.getRequestDispatcher("views/admin/mentorInfo.jsp").forward(request, response);
		//------------------------------------------------------------------------------
		}else {
			listCount = new AdminService2().outMentorCount(search);
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
			
			
			list = new AdminService2().outMentorList(pi,search);
			
			
			request.setAttribute("check", check);
			request.setAttribute("search", search);
			request.setAttribute("lpage", lpage);
			request.setAttribute("pi", pi);
			request.setAttribute("list", list);
			request.getRequestDispatcher("views/admin/mentorInfo.jsp").forward(request, response);
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
