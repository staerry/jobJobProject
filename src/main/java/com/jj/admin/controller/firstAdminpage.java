package com.jj.admin.controller;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.jj.admin.model.service.AdminService;
import com.jj.admin.model.service.AdminService2;
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
		int totalMember = new AdminService2().totalMember();
		request.setAttribute("totalMember", totalMember);
		
		// 총 멤버수(주원)
		int totalStu = new AdminService2().totalStu();
		request.setAttribute("totalStu", totalStu);
		
		// 총 멘토수(주원)
		int totalMentor = new AdminService2().totalMentor();
		request.setAttribute("totalMentor", totalMentor);
		
		// 일일 접속자 수 ==> 유저테이블에 USER_RECENTDATE 컬럼 추가하면 주석풀기 ==> <%=request.getAttribute("todayConnect") %> login.jsp에 넣기
		int todayConnect = new AdminService2().todayConnect();
		request.setAttribute("todayConnect", todayConnect);
		
		// 1대1 문의 번호, 제목, 날짜
		ArrayList<Mtm> mtmList = new AdminService().selectMtmList();
		
		// 공지사항 번호, 제목, 날짜
		ArrayList<Notice> noticeList = new AdminService().selectNoticeList();
		
		// 멘토 가입 승인 대기 수
		int mentorApprovalCount = new AdminService().selectMentorCount();
		
		// 강의 등록 승인 대기 수
		int vodApprovalCount = new AdminService().selectVodCount();
		
		// 결제 수(주원)
		int todayPay = new AdminService2().todayPay();
		request.setAttribute("todayPay", todayPay);
		
		// 환불 요청 수(주원)
		int rqRefundCount = new AdminService2().rqRefundCount();
		request.setAttribute("rqRefundCount", rqRefundCount);
		
		
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
