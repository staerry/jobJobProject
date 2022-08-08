package com.jj.mentorMyPage.controller;

import java.io.IOException;
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
 * Servlet implementation class MentorMyAnsEnrollController
 */
@WebServlet("/myAnsEnroll.my")
public class MentorMyAnsEnrollController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public MentorMyAnsEnrollController() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		int queNo = Integer.parseInt(request.getParameter("queNo"));
		MtQuestion mtQuestion = new MentorMyService().selectOneMtQuestion(queNo);
		System.out.println(mtQuestion);
		request.setAttribute("mtQuestion", mtQuestion);
		request.getRequestDispatcher("views/mentorMyPage/mentorAnswer.jsp").forward(request, response);
			
	
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		HttpSession session = request.getSession();
//		System.out.println(session);
		int queNo = Integer.parseInt(request.getParameter("queNo"));
		String ansContent = request.getParameter("ansContent");
		Member member = (Member) session.getAttribute("loginUser");
		if(member != null) {
			int result = new MentorMyService().insertMtAnswer(queNo,ansContent);

			if(result > 0) {
//				request.setAttribute("alertMsg", "답변을 등록했습니다.");
				response.sendRedirect(request.getContextPath() + "/myAnsList.my");
			}else {
				request.setAttribute("alertMsg", "등록에 실패했습니다.");
				request.getRequestDispatcher("views/mentorMyPage/mentorAnswer.jsp").forward(request, response);
			}
			

		}else {
			request.setAttribute("alertMsg", "로그인이 필요합니다.");
			request.getRequestDispatcher("views/member/memberLoginSecond.jsp").forward(request, response);
		}
	}

}
