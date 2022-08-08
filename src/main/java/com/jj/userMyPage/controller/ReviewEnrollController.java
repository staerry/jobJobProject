package com.jj.userMyPage.controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.jj.classSelect.model.service.ClassService;
import com.jj.member.model.vo.Member;
import com.jj.mentorMyPage.model.service.MentorMyService;
import com.jj.userMyPage.model.service.UserClassService;
import com.jj.userMyPage.model.vo.Class;
import com.jj.userMyPage.model.vo.Review;

/**
 * Servlet implementation class ReviewEnrollController
 */
@WebServlet("/reviewEnroll.my")
public class ReviewEnrollController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ReviewEnrollController() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		
		HttpSession session = request.getSession();
		Member member = (Member) session.getAttribute("loginUser");
		
		int clNo = Integer.parseInt(request.getParameter("clNo"));
		
		if(member != null) {
			Class cls = new UserClassService().selectClassInfo(clNo);
			boolean hasReview = (new UserClassService().selectReviewCount(clNo) > 0 ? true : false);
			System.out.println(cls);
			request.setAttribute("cls", cls);
			request.setAttribute("hasReview", hasReview);
			request.getRequestDispatcher("views/userMyPage/classReviewEnroll.jsp").forward(request, response);
		}else {
			request.setAttribute("alertMsg", "로그인이 필요합니다.");
			request.getRequestDispatcher("views/member/memberLoginSecond.jsp").forward(request, response);
		}

	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		HttpSession session = request.getSession();
//		System.out.println(session);
		
		int clNo = Integer.parseInt(request.getParameter("clNo"));
		int rating = Integer.parseInt(request.getParameter("rating"));
		String reviewContent = request.getParameter("reviewContent");
		Member member = (Member) session.getAttribute("loginUser");
		
		
		if(member != null) {
			Review review = new Review();
			review.setClNo(clNo);
			review.setUserNo(member.getUserNo());
			review.setReviewScore(rating);
			review.setReviewContent(reviewContent);
			int result = new UserClassService().insertReview(review);

			if(result > 0) {
				response.sendRedirect(request.getContextPath() + "/userVodList.my?class=" + clNo);
			}else {
				request.setAttribute("alertMsg", "등록에 실패했습니다.");
				request.getRequestDispatcher("views/userMyPage/classReviewEnroll.jsp").forward(request, response);
			}
			

		}else {
			request.setAttribute("alertMsg", "로그인이 필요합니다.");
			request.getRequestDispatcher("views/member/memberLoginSecond.jsp").forward(request, response);
		}
		
		
		
	}

}
