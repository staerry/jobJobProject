package com.jj.mentorMyPage.controller;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.jj.member.model.vo.Member;
import com.jj.mentorMyPage.model.service.MentorMyService;
import com.jj.userMyPage.model.service.UserClassService;
import com.jj.userMyPage.model.vo.Bookmark;
import com.jj.userMyPage.model.vo.Lecturer;


/**
 * Servlet implementation class MentorProfileEditController
 */
@WebServlet("/mtProEdit.my")
public class MentorProfileEditController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public MentorProfileEditController() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	
		// 멘토 프로필 수정  - 정보 담아서 보내야함
		HttpSession session = request.getSession();
		
		Member member = (Member) session.getAttribute("loginUser");
		if(member != null) {
			Lecturer lecturer = new MentorMyService().selectLecturerByUserNo(member);	
			
			request.setAttribute("lecturer", lecturer);
			request.getRequestDispatcher("views/mentorMyPage/mentorProfileEdit.jsp").forward(request, response);
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
