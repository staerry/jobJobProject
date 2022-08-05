package com.jj.classSelect.controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.json.simple.JSONObject;

import com.jj.classSelect.model.service.ClassService;
import com.jj.member.model.vo.Member;

/**
 * Servlet implementation class AjaxBookmarkInsertController
 */
@WebServlet("/insertBm.cl")
public class AjaxBookmarkInsertController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public AjaxBookmarkInsertController() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		int clNo = Integer.parseInt(request.getParameter("clNo"));
		int userNo = (int)((Member)request.getSession().getAttribute("loginUser")).getUserNo();
		
		// 이전에 찜 한 이력이 있는지 먼저 확인한 후 insert / delete 결정
		int likeCheck = new ClassService().selectBookmark(clNo, userNo);
		
		// likeCheck == 0 : 이전에 찜한 적 없음 ==> insert
		// likeCheck == 1 : 이미 찜한 적 있음 ==> delete
				
		switch(likeCheck) {
		case 1: new ClassService().deleteBookmark(clNo, userNo); break;
		case 0: new ClassService().insertBookmark(clNo, userNo); break;
		}
		
		int likeCount = new ClassService().selectBookmarkCount(clNo);
		
		JSONObject jObj = new JSONObject();
		jObj.put("likeCheck", likeCheck);
		jObj.put("likeCount", likeCount);
		
		response.setContentType("application/json; charset=UTF-8");
		response.getWriter().print(jObj);
		
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
