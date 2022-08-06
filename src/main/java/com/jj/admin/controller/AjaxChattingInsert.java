package com.jj.admin.controller;

import static com.jj.common.JDBCTemplate.getConnection;

import java.io.IOException;
import java.sql.Connection;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.jj.admin.model.dao.AdminDao;

/**
 * Servlet implementation class ChattingSelect
 */
@WebServlet("/chatting.ad")
public class AjaxChattingInsert extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public AjaxChattingInsert() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");
		
		int userNo = Integer.parseInt(request.getParameter("userno"));
		String message = request.getParameter("message");
		
		Connection conn = getConnection();
		
		int result = new AdminDao().insertChat2(conn, userNo, message);
		
		if(result > 0) {
			response.setContentType("text/html; charset=UTF-8");
			response.getWriter().print(message);
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
