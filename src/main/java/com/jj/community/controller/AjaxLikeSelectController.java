package com.jj.community.controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.json.simple.JSONObject;

import com.jj.classSelect.model.service.ClassService;
import com.jj.community.model.service.CommunityService;
import com.jj.member.model.vo.Member;

/**
 * Servlet implementation class AjaxLikeSelectController
 */
@WebServlet("/checkLk.cm")
public class AjaxLikeSelectController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public AjaxLikeSelectController() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		int userNo = ((Member)request.getSession().getAttribute("loginUser")).getUserNo();
		int commNo = Integer.parseInt(request.getParameter("cmNo"));
		
		System.out.println(userNo);
		System.out.println(commNo);
		
		// 이전에 게시물에 좋아요를 한 이력이 있는지 먼저 확인
		int likeCheck = new CommunityService().selectLike(userNo, commNo);
		
		// 좋아요 수
		int likeCount = new CommunityService().selectLikeCount(commNo);
		
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
