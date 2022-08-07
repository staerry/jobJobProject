package com.jj.community.controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.jj.community.model.service.CommunityService;
import com.jj.community.model.vo.Community;

/**
 * Servlet implementation class CommunityDetailController
 */
@WebServlet("/detail.co")
public class CommunityDetailController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public CommunityDetailController() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		// 글 번호, 카테고리명, 카테고리번호, 글 제목, 작성자, 작성일, 조회수, 게시글내용
		int contentNo = Integer.parseInt(request.getParameter("contentNo"));
				
		// 1) 조회수 증가
		int result = new CommunityService().increaseCount(contentNo);

		if(result > 0) {	// 유효한 게시글이 맞음 ==> 상세 조회페이지로 이동
			// 2) 상세 페이지로 넘길 게시글, 첨부파일 조회
			Community c = new CommunityService().selectCommunity(contentNo);
			
			request.setAttribute("c", c);
			request.getRequestDispatcher("views/community/communityDetailView.jsp").forward(request, response);
		}else {
			request.getSession().setAttribute("alertMsg", "문제가 발생했습니다. 잠시 후에 다시 시도해 주세요.");
			response.sendRedirect(request.getContextPath()+"/list.cm");
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
