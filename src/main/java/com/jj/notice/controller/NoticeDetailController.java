package com.jj.notice.controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.jj.notice.model.service.NoticeService;
import com.jj.notice.model.vo.Notice;

/**
 * Servlet implementation class NoticeDetailController
 */
@WebServlet("/detail.no")
public class NoticeDetailController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public NoticeDetailController() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		// Notice 상세조회 요청
		int noticeNo = Integer.parseInt(request.getParameter("Nno")); 
		
		// 1) 조회수 증가 (update)
		int result = new NoticeService().increaseNoticeCount(noticeNo);
		
		if(result > 0) { // 조회수 증가 성공 => 조회가능한 공지사항 맞다
			
			// 2) 데이터 조회 (select)
			Notice n = new NoticeService().selectNotice(noticeNo);
			
			request.setAttribute("notice", n);
			request.getRequestDispatcher("views/member/noticeDetailPage.jsp").forward(request, response);
			
			
		}else { // 조회수 증가 실패 => 유효한 글 번호가 아니거나 삭제된 글번호
			// 에러문구
			request.setAttribute("alert", "조회수증가실패");
			
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
