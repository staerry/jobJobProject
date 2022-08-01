package com.jj.admin.controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.jj.admin.model.service.AdminService;

/**
 * Servlet implementation class PostDeleteController
 */
@WebServlet("/deletePost.ad")
public class PostDeleteController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public PostDeleteController() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		int postNo = Integer.parseInt(request.getParameter("no"));
		int postCategory = Integer.parseInt(request.getParameter("category"));
		
		int result = new AdminService().deletePost(postNo, postCategory);
		
		HttpSession session = request.getSession();
		
		if(result > 0) {
			session.setAttribute("alertMsg", "삭제를 완료 했습니다.");
			
			if(postCategory == 1) {
				response.sendRedirect(request.getContextPath() + "/postWorkListView.ad?cpage=1");
			}else if(postCategory == 2) {
				response.sendRedirect(request.getContextPath() + "/postWorryListView.ad?cpage=1");
			}else if(postCategory == 3) {
				response.sendRedirect(request.getContextPath() + "/postStudyListView.ad?cpage=1");
			}
		}else {
			session.setAttribute("alertMsg", "삭제에 실패 했습니다.");
			
			if(postCategory == 1) {
				response.sendRedirect(request.getContextPath() + "/postWorkListView.ad?cpage=1");
			}else if(postCategory == 2) {
				response.sendRedirect(request.getContextPath() + "/postWorryListView.ad?cpage=1");
			}else if(postCategory == 3) {
				response.sendRedirect(request.getContextPath() + "/postStudyListView.ad?cpage=1");
			}
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
