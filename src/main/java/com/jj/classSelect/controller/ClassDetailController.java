package com.jj.classSelect.controller;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.jj.classSelect.model.service.ClassService;
import com.jj.classSelect.model.vo.Class;
import com.jj.community.model.vo.Review;
import com.jj.member.model.vo.Member;

/**
 * Servlet implementation class ClassDetailController
 */
@WebServlet("/detail.cl")
public class ClassDetailController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ClassDetailController() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		int clNo = Integer.parseInt(request.getParameter("class"));
		
		// 강의 정보 조회
		Class c = new ClassService().selectClass(clNo);
				
		// 수강생 수 조회
		int studentCount = new ClassService().selectStudentCount(clNo);
		
		// 찜 수 조회
		int bookmarkCount = new ClassService().selectBookmarkCount(clNo);
		
		// 수강 후기 조회
		ArrayList<Review> list = new ClassService().selectReview(clNo);
		
		
		//작성자 : 이지원 (일부 추가)
		//수강 중인 여부 조회를 위한 로그인객체 선언
		HttpSession session = request.getSession();
		Member member =(Member) session.getAttribute("loginUser");
		
		
		//사용자가 수강중인 강의일 경우 나의클래스로 이동하도록
		boolean isClassing = false;
		if(member != null) {
			//수강중인 강의가 존재할 경우 true반환, 없을경우 false반환
			isClassing = (new ClassService().selectIsClassing(member, clNo) > 0 ? true : false);
			
		}
		
		request.setAttribute("c", c);
		request.setAttribute("studentCount", studentCount);
		request.setAttribute("bookmarkCount", bookmarkCount);
		request.setAttribute("list", list);
		request.setAttribute("isClassing", isClassing);
		
		System.out.println(c);
		System.out.println(studentCount);
		System.out.println(bookmarkCount);
		System.out.println(list);
		
		
		request.getRequestDispatcher("views/classSelect/classDetailView.jsp").forward(request, response);
		
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
