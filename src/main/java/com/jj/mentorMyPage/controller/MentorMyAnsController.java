package com.jj.mentorMyPage.controller;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.jj.member.model.vo.Member;
import com.jj.mentorMyPage.model.service.MentorMyService;
import com.jj.mentorMyPage.model.vo.MtQuestion;

/**
 * Servlet implementation class MentorMyAnsController
 */
@WebServlet("/myAnsList.my")
public class MentorMyAnsController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public MentorMyAnsController() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
//	 멘토 나의 답변 조회해오는 컨트롤러임
		HttpSession session = request.getSession();
		System.out.println(session);
		
		Member member = (Member) session.getAttribute("loginUser");
		if(member != null) {
			ArrayList<MtQuestion> list = new MentorMyService().selectAllQuestion(member.getUserNo());
			session.setAttribute("list", list);
			System.out.println("list");
		}else {
			request.setAttribute("alertMsg", "로그인이 필요합니다.");
			request.getRequestDispatcher("views/member/memberLoginSecond.jsp").forward(request, response);
		}
//	서비스 더 써야함
	
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
