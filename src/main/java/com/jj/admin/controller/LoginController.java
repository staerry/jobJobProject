package com.jj.admin.controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.jj.admin.model.service.AdminService;
import com.jj.admin.model.vo.UserInfoAd;


/**
 * Servlet implementation class LoginController
 */
@WebServlet("/adLogin.do")
public class LoginController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public LoginController() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");
		String adminId = request.getParameter("adminId");
		String adminPwd = request.getParameter("adminPwd");
		
		UserInfoAd u = new AdminService().loginAdmin(adminId,adminPwd);
		
		if(u == null) { 
			HttpSession session = request.getSession();
			session.setAttribute("alertMsg", "로그인에 실패했습니다.");
			response.sendRedirect(request.getContextPath()+"/login.ad");
			
		}else { 
			HttpSession session = request.getSession();
			session.setAttribute("UserInfoAd", u);
			response.sendRedirect(request.getContextPath()+"/login.ad"); 
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
