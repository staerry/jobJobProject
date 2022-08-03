package com.jj.community.controller;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.jj.community.model.service.CommunityService;
import com.jj.community.model.vo.Community;

/**
 * Servlet implementation class CommunityListSearchController
 */
@WebServlet("/search.co")
public class CommunityListSearchController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public CommunityListSearchController() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
				
		int category = Integer.parseInt(request.getParameter("category"));
		String keyword = request.getParameter("keyword");
		
		if(category == 1 || category == 2 || category == 3) {
			if((keyword != null) && !keyword.equals("")) {
				int searchListCount = new CommunityService().searchListCount(category, keyword);
				ArrayList<Community> searchList = new CommunityService().searchList(category, keyword);
				
				request.setAttribute("categoryNo", category);
				request.setAttribute("searchListCount", searchListCount);
				request.setAttribute("searchList", searchList);
				
				System.out.println(searchList);
				
				request.getRequestDispatcher("views/community/communityListSearchView.jsp").forward(request, response);
			}
		}	// 에러 처리 필요
		
		
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
