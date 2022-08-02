package com.jj.admin.controller;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.google.gson.Gson;
import com.jj.admin.model.service.AdminService2;
import com.jj.member.model.vo.Member;

/**
 * Servlet implementation class RButtonClickController
 */
@WebServlet("/rbutton.cl")
public class RButtonClickController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public RButtonClickController() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String No = request.getParameter("rNo");
		System.out.println(No);
		String[] rNo = No.split(",");
		String a="";
		for(int i=0;i<rNo.length;i++) {
			a += "USER_NO = "+rNo[i];
			if(i != rNo.length-1) {
				a += " OR ";
			}
		}
		
		String sql = "SELECT USER_NO, USER_NAME, USER_ID  FROM USERINFO  WHERE "+a;
		System.out.println(sql);
		
		ArrayList<Member> list = new AdminService2().rbutton(sql);
		
		
		response.setContentType("applycation/json; charset=UTF-8");
		new Gson().toJson(list,response.getWriter());
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
