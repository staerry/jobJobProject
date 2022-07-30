package com.jj.community.controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.jj.community.model.service.CommunityService;

/**
 * Servlet implementation class CommunityDeleteController
 */
@WebServlet("/delete.co")
public class CommunityDeleteController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public CommunityDeleteController() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		int contentNo = Integer.parseInt(request.getParameter("contentNo"));
		
		// contentNo가 일치하는 행 찾아서 삭제
		int result = new CommunityService().deleteCommunity(contentNo);
		
		if(result > 0) {
			request.getSession().setAttribute("alertMsg", "작성하신 글이 삭제되었습니다.");
			response.sendRedirect(request.getContextPath() + "/list.co?category=1&cpage=1");
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
