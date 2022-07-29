package com.jj.admin.controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.google.gson.Gson;
import com.jj.admin.model.service.AdminService2;
import com.jj.member.model.vo.Mentor;

/**
 * Servlet implementation class MtDetailInfoController
 */
@WebServlet("/mtDetail.bo")
public class MtDetailInfoController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public MtDetailInfoController() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String prevNo = request.getParameter("prevNo");
		int startNo = prevNo.indexOf("(");
		int endNo = prevNo.indexOf(")");
		int no = Integer.parseInt(prevNo.substring(startNo+1, endNo));
		Mentor m = new AdminService2().mentorDetailInfo(no);
		response.setContentType("applycation/json; charset=UTF-8");
		new Gson().toJson(m,response.getWriter());
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
