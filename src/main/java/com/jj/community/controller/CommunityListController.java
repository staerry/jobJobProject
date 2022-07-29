package com.jj.community.controller;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.jj.common.model.vo.PageInfo;
import com.jj.community.model.service.CommunityService;
import com.jj.community.model.vo.Community;

/**
 * Servlet implementation class CommunityListController
 */
@WebServlet("/list.co")
public class CommunityListController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public CommunityListController() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		// 페이징 처리
		int listCount;	// 현재 총 게시글 수
		int currentPage;	// 사용자가 보게 될 페이지 번호
		int pageLimit;	// 페이징바의 페이지 번호 최대 개수
		int boardLimit;	// 한 페이지당 게시물 수
		
		int maxPage;	// 가장 마지막 페이지
		int startPage;	// 페이징바 시작 번호
		int endPage;	// 페이징바 마지막 번호
		
		int category = Integer.parseInt(request.getParameter("category"));
		
		listCount = new CommunityService().selectListCount(category);	
		
		currentPage = Integer.parseInt(request.getParameter("cpage"));
		
		pageLimit = 5;
		boardLimit = 5;
		
		maxPage = (int)Math.ceil((double)listCount/boardLimit);
		startPage = (currentPage - 1) / pageLimit * pageLimit + 1;
		endPage = startPage + pageLimit - 1;
				
		if(endPage > maxPage) {
			endPage = maxPage;
		}
		
		PageInfo pi = new PageInfo(listCount, currentPage, pageLimit, boardLimit, maxPage, startPage, endPage);
		
		// 현재 요청한 페이지(currentPage)에 보여질 게시글 리스트 조회
		ArrayList<Community> list = new CommunityService().selectList(pi, category);
		
		request.setAttribute("pi", pi);
		request.setAttribute("list", list);
		request.setAttribute("categoryNo", category);
		
		request.getRequestDispatcher("views/community/communityListView.jsp").forward(request, response);
				
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}