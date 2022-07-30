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
 * Servlet implementation class CommunityUpdateController
 */
@WebServlet("/update.co")
public class CommunityUpdateController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public CommunityUpdateController() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		request.setCharacterEncoding("UTF-8");
		
		int contentNo = Integer.parseInt(request.getParameter("contentNo"));
		String title = request.getParameter("contentTitle");
		String content = request.getParameter("contentBody");
		
		Community c = new Community();
		c.setCommNo(contentNo);
		c.setCommTitle(title);
		c.setCommContent(content);
		
		// UPDATE ==> RESULT
		int result = new CommunityService().updateCommunity(c);
		
		// 성공 | 실패
		if(result > 0) {
			request.getSession().setAttribute("alertMsg", "게시물이 수정되었습니다.");
			response.sendRedirect(request.getContextPath() + "/detail.co?contentNo=" + contentNo);
		}else {
			request.setAttribute("errorMsg", "문제가 발생했습니다. 잠시 후에 다시 시도해 주세요.");
			request.getRequestDispatcher("views/common/errorPage.jsp").forward(request, response);
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
