package com.jj.notice.controller;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.jj.faq.model.service.FaqService;
import com.jj.notice.model.service.NoticeService;
import com.jj.notice.model.vo.Notice;
import com.jj.faq.model.vo.Faq;
import com.jj.faq.model.vo.PageInfoFaq;

/**
 * Servlet implementation class NoticeListController
 */
@WebServlet("/list.no")
public class NoticeListController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public NoticeListController() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		// Notice 목록 조회
		
		int listCount; // 게시글 총 갯수
		int currentPage; // 현재 사용자가 요청한 페이지의 no
		int pageLimit; // 페이징바 몇개 단위씩 할건지 (쪽수)
		int faqLimit; // 한 페이지당 보여질 게시글의 최대갯수
		
		int maxPage; // 가장 마지막 페이지 (총 페이지수)
		int startPage; // 페이징바의 시작수 
		int endPage; // 페이징바의 끝수
		
		int nsort = Integer.parseInt(request.getParameter("nsort"));
		
		String keyWord = "";
		if(request.getParameter("keyWord") != null) {
			keyWord = request.getParameter("keyWord");
		}
		
		if(nsort == 1) {// 최신순일 때
			listCount = new NoticeService().selectListCount(keyWord);
			
			currentPage = Integer.parseInt(request.getParameter("npage"));
			
			pageLimit = 5;
			
			faqLimit = 10; // 한페이지에 10개씩 보여짐
			
			maxPage = (int)(Math.ceil( (double)listCount / faqLimit ));
			
			startPage = (currentPage - 1) / pageLimit * pageLimit + 1;
			
			endPage = startPage + pageLimit -1;
			
			if(endPage > maxPage) {
				endPage = maxPage;
			}
			
			PageInfoFaq pi = new PageInfoFaq(listCount, currentPage, pageLimit, faqLimit, maxPage, startPage, endPage);
		
			ArrayList<Notice> list = new NoticeService().selectNoticeList(pi, keyWord);
			
			request.setAttribute("nsort", nsort);
			request.setAttribute("pi", pi);
			request.setAttribute("list", list);
			request.getRequestDispatcher("views/member/noticeList.jsp").forward(request, response);
			
		}else {// 조회순일때
			listCount = new NoticeService().selectListCount(keyWord);
			
			currentPage = Integer.parseInt(request.getParameter("npage"));
			
			pageLimit = 5;
			
			faqLimit = 10; 
			
		
			maxPage = (int)(Math.ceil( (double)listCount / faqLimit ));
			
			
			startPage = (currentPage - 1) / pageLimit * pageLimit + 1;
			
			
			endPage = startPage + pageLimit -1;
			
			if(endPage > maxPage) {
				endPage = maxPage;
			}
			
			PageInfoFaq pi = new PageInfoFaq(listCount, currentPage, pageLimit, faqLimit, maxPage, startPage, endPage);
			
			ArrayList<Notice> list = new NoticeService().selectCountNoticeList(pi, keyWord);
			
			request.setAttribute("nsort", nsort);
			request.setAttribute("pi", pi);
			request.setAttribute("list", list);
			request.getRequestDispatcher("views/member/noticeList.jsp").forward(request, response);
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