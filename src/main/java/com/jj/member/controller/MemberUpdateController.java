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
 * Servlet implementation class MemberUpdateController
 */
@WebServlet("/update.me")
public class MemberUpdateController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public MemberUpdateController() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// 1) 인코딩 설정 (post방식) 
		request.setCharacterEncoding("UTF-8");
		
		// 2) 요청 시 전달값 뽑기 => 변수 및 객체 담기
		String userId = request.getParameter("userId");
		String userPwd = request.getParameter("userPwd");
		String userNewPwd = request.getParameter("userNewPwd");
		String userEmail = request.getParameter("userEmail");
		String userPhone = request.getParameter("userPhone");
		
		System.out.println(userId);
		System.out.println(userPwd);
		System.out.println(userNewPwd);
		System.out.println(userEmail);
		System.out.println(userPhone);
			
		// 3) 요청처리 (db에 sql문 실행)
		Member updateMem = new MemberService().updateInfo(userId, userPwd, userNewPwd, userEmail, userPhone);
		
		
		
		// 4) 응답뷰
		if(updateMem == null) { // 실패
			
			request.setAttribute("alertMsg", "회원정보 수정에 실패했습니다");
			response.sendRedirect(request.getContextPath());
			
		}else { // 성공
			
			// session에 담겨있는 loginUser를 바꿔치기
			System.out.println("성공");
			HttpSession session = request.getSession();
			session.setAttribute("loginUser", updateMem);
			session.setAttribute("alertMsg", "성공적으로 회원정보를 수정했습니다.");
			
			
			response.sendRedirect(request.getContextPath());
			
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
