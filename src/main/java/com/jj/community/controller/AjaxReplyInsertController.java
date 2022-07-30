package com.jj.community.controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.jj.community.model.service.CommunityService;
import com.jj.community.model.vo.Reply;
import com.jj.member.model.vo.Member;

/**
 * Servlet implementation class AjaxReplyInsertController
 */
@WebServlet("/rinsert.co")
public class AjaxReplyInsertController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public AjaxReplyInsertController() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String contentNo = request.getParameter("contentNo");
		String content = request.getParameter("content");
		
		// 세션으로부터 USER_NO 가져와야 함
		int userNo = ((Member)request.getSession().getAttribute("loginUser")).getUserNo();		
		
		Reply r = new Reply();
		r.setCmNo(contentNo);
		r.setUserNo(String.valueOf(userNo));
		r.setReplyContent(content);		
		
		int result = new CommunityService().insertReply(r);
		
		// AJAX는 페이지를 돌려주면 안됨
		response.getWriter().print(result);	// 숫자만 돌려주므로 데이터 타입 필요 없음
			
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
