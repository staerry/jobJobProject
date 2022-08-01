package com.jj.member.controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.jj.member.model.service.MemberService;
import com.jj.member.model.vo.Member;

/**
 * Servlet implementation class MemberUpdateInfoController
 */
@WebServlet("/update.me")
public class MemberUpdateInfoController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public MemberUpdateInfoController() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		request.getRequestDispatcher("views/member/memberUpdateInfo.jsp").forward(request, response);
		
		/*
		// 1) 인코딩 설정 (post방식)
		request.setCharacterEncoding("UTF-8");
		
		// 2) 요청 시 전달값 뽑기 => 변수 및 객체 담기
		String userId = request.getParameter("userId");
		String userName = request.getParameter("userName");
		String phone = request.getParameter("phone");
		String email = request.getParameter("email");
		String address = request.getParameter("address");
		String[] interestArr= request.getParameterValues("interest");
		
		String interest = "";
		if(interestArr != null) {
			interest = String.join(",", interestArr);
		}
		
		Member m = new Member(userId, userName, phone, email, address, interest);
		
		// 3) 요청처리 (db에 sql문 실행)
		Member updateMem = new MemberService().updateMember(m);
		
		// 4) 응답뷰
		if(updateMem == null) { // 실패
			// 에러문구 담아서 에러페이지 포워딩
			request.setAttribute("errorMsg", "회원정보 수정에 실패했습니다");
			// RequestDispatcher view = request.getRequestDispatcher("views/common/errorPage.jsp");
			// view.forward(request, response);
			request.getRequestDispatcher("views/common/errorPage.jsp").forward(request, response);
			
		}else { // 성공
			
			// session에 담겨있는 loginUser를 바꿔치기
			HttpSession session = request.getSession();
			session.setAttribute("loginUser", updateMem);
			session.setAttribute("alertMsg", "성공적으로 회원정보를 수정했습니다.");
			
			// 응답페이지 (myPage.jsp) => /myPage.me url 재요청 => 마이페이지 응답
			response.sendRedirect(request.getContextPath() + "/myPage.me");
			
		}
		*/
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
