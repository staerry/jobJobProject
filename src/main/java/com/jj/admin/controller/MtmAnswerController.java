package com.jj.admin.controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.jj.admin.model.service.AdminService;
import com.jj.admin.model.service.MailSender;
import com.jj.mtm.model.vo.Mtm;

/**
 * Servlet implementation class MtmAnswerController
 */
@WebServlet("/mtmAnswer.ad")
public class MtmAnswerController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public MtmAnswerController() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");
		
		int mtmNo = Integer.parseInt(request.getParameter("mtmNo"));
		String mtmAnswer = request.getParameter("mtmAnswer");
		
		int result = new AdminService().updateAnswer(mtmNo, mtmAnswer);
		
		if(result > 0) {
//			답변내용이 db에 성공적으로 수정 되면 사용자의 이메일로 발송 시킴
//			사용자 이메일과 답변 내용을 조회해서 메일전송에 필요한 데이터를 가져옴
			Mtm userEmail = new AdminService().selectUserEmail(mtmNo);
			
//			메일 전송용 클래스 호출 => 답변내용, 유저 이메일 매개변수 작성
			new MailSender().sendMail(mtmAnswer, userEmail);
			
			request.getSession().setAttribute("alertMsg", "답변을 전송 했습니다.");
		}else {
			request.getSession().setAttribute("alertMsg", "답변 전송을 실패 했습니다.");
		}
		
		response.sendRedirect(request.getContextPath() + "/mtmListView.ad?cpage=1");
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
