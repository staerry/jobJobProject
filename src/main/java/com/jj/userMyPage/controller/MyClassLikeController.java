package com.jj.userMyPage.controller;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.jj.member.model.vo.Member;
import com.jj.userMyPage.model.service.UserClassService;
import com.jj.userMyPage.model.vo.Bookmark;

/**
 * Servlet implementation class MyClassLike
 */
@WebServlet("/classLike.my")
public class MyClassLikeController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public MyClassLikeController() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
//		WISH 서비스,DAO , BOOKMARK VO
		HttpSession session = request.getSession();
		
		Member member = (Member) session.getAttribute("loginUser");
		if(member != null) {
			List<Bookmark> list = new UserClassService().selectWishAllList(member);
			System.out.println(list);
			
			request.setAttribute("list", list);
			request.getRequestDispatcher("views/userMyPage/myClassLike.jsp").forward(request, response);
		}else {
			request.setAttribute("alertMsg", "로그인이 필요합니다");
			request.getRequestDispatcher("views/member/memberLoginSecond.jsp").forward(request, response);
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
