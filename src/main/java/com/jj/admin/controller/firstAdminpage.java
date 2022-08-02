package com.jj.admin.controller;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.jj.admin.model.service.AdminService;
import com.jj.common.model.vo.PageInfo;
import com.jj.mtm.model.vo.Mtm;
import com.jj.notice.model.vo.Notice;

/**
 * Servlet implementation class loginAdmin
 */
@WebServlet("/login.ad")
public class firstAdminpage extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public firstAdminpage() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		PageInfo pageInfo = new PageInfo(); //빈 객체
		
		// 총 회원수(주원)
		// 총 멤버수(주원)
		
		// 총 멘토수(주원)
		// 일일 접속자 수(이걸 어케해)
		
		// 1대1 문의 번호, 제목, 날짜
		ArrayList<Mtm> mtmList = new AdminService().selectMtmList(pageInfo);
		
		// 공지사항 번호, 제목, 날짜
		ArrayList<Notice> noticeList = new AdminService().selectNoticeList(pageInfo);
		
		// 멘토 가입 승인 대기 수
		int mentorApprovalCount = new AdminService().selectMentorCount();
		
		// 강의 등록 승인 대기 수
		int vodApprovalCount = new AdminService().selectVodCount();
		
		// 결제 수(주원)
		// 환불 요청 수(주원)
		
		request.setAttribute("Mtm", mtmList);
		request.setAttribute("Notice", noticeList);
		request.setAttribute("mentorApprovalCount", mentorApprovalCount);
		request.setAttribute("vodApprovalCount", vodApprovalCount);
		request.getRequestDispatcher("views/admin/login.jsp").forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
