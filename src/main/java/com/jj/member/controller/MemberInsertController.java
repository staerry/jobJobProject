package com.jj.member.controller;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.jj.member.model.service.MemberService;
import com.jj.member.model.vo.Member;

/**
 * Servlet implementation class MemberInsertController
 */
@WebServlet("/insert.me")
public class MemberInsertController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public MemberInsertController() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		// 1) 인코딩 작업 (post방식이고 한글값 넘어올때만 하면됨!)
				request.setCharacterEncoding("UTF-8");
			
				// 2) 요청시 전달값 뽑아서 변수 및 객체에 기록하기
				String userName = request.getParameter("userName");
				String userId = request.getParameter("userId");
				String userPwd = request.getParameter("userPwd");
				String phone = request.getParameter("phone");
				String[] interestArr = request.getParameterValues("interest");
				
				String interest = "";
				if(interestArr != null) {
					interest = String.join(",", interestArr);
				}
				
				Member m = new Member(userName, userId, userPwd, phone, interest);
				
				// 3) 요청처리 (db에 sql문 실행)
				int result = new MemberService().insertMember(m);
				
				// 4) 돌려받은 처리결과 가지고 사용자가 보게될 응답화면 지정
				if(result > 0) {// 성공 => 메인페이지
					
					HttpSession session = request.getSession();
					session.setAttribute("alertMsg", "성공적으로 회원가입했습니다.");
					
					response.sendRedirect(request.getContextPath());
					
				}else { // 실패 => 에러페이지
					
					RequestDispatcher view = request.getRequestDispatcher("views/common/errorPage.jsp");
					request.setAttribute("errorMsg", "회원가입에 실패했습니다");
					view.forward(request, response);
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
