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
import com.jj.faq.model.vo.Faq;

/**
 * Servlet implementation class FAQManagementPage
 */
@WebServlet("/faqListView.ad")
public class FAQManagementPage extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public FAQManagementPage() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		int listCount; // 총 게시물 갯수
		int currentPage; // 사용자가 요청한 페이지
		int pageLimit; // 페이징바 최대 갯수
		int boardLimit; // 한 페이지에 보여질 게시물 수
		int maxPage; // 가장 마지막 페이지
		int startPage; // 페이징바 시작 수
		int endPage; // 페이징바 끝 수
		
		listCount = new AdminService().selectFaq();
		currentPage = Integer.parseInt(request.getParameter("cpage"));
		pageLimit = 5;
		boardLimit = 10;
		maxPage = (int)Math.ceil((double)listCount / boardLimit);
		startPage = (currentPage - 1) / pageLimit * pageLimit + 1;
		endPage = startPage + pageLimit - 1;
		
		if(endPage > maxPage) {
			endPage = maxPage;
		}
		
		PageInfo pageInfo = new PageInfo(listCount, currentPage, pageLimit, boardLimit, maxPage, startPage, endPage);
		
		ArrayList<Faq> list = new AdminService().selectFaqList(pageInfo);
		
		request.setAttribute("pageInfo", pageInfo);
		request.setAttribute("faqList", list);
		request.getRequestDispatcher("views/admin/faqManagement.jsp").forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
