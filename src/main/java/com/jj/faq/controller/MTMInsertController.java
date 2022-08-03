package com.jj.faq.controller;

import java.io.IOException;

import javax.mail.Session;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.jj.faq.model.service.FaqService;
import com.jj.faq.model.vo.MTM;
import com.jj.member.model.vo.Member;

/**
 * Servlet implementation class FaqInsertController
 */
@WebServlet("/insert.mtm")
public class MTMInsertController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public MTMInsertController() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		request.setCharacterEncoding("UTF-8");
		
		HttpSession session = request.getSession();
		
		int userNo = ((Member)session.getAttribute("loginUser")).getUserNo();
		String mtmTitle = request.getParameter("mtmTitle");
		String mtmContent = request.getParameter("mtmContent");
		
		MTM m = new MTM();
		m.setUserNo(userNo);
		m.setMtmTitle(mtmTitle);
		m.setMtmContent(mtmContent);
		
		int result = new FaqService().insertMTM(m);
		
		if(result > 0) { // 1:1문의 insert성공
			session.setAttribute("alertMsg", "1:1문의가 정상적으로 처리되었습니다.");
			response.sendRedirect(request.getContextPath() + "/list.faq");
		}else { // 1:1문의 insert실패
			session.setAttribute("alertMsg", "1:1문의에 실패했습니다.");
			response.sendRedirect(request.getContextPath() + "/list.faq");
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
