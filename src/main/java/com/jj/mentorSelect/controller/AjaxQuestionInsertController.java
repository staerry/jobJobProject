package com.jj.mentorSelect.controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.jj.member.model.vo.Member;
import com.jj.mentorSelect.model.service.LecturerService;
import com.jj.mentorSelect.model.vo.MtQuestion;

/**
 * Servlet implementation class AjaxQuestionInsertController
 */
@WebServlet("/qinsert.lt")
public class AjaxQuestionInsertController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public AjaxQuestionInsertController() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		
		
		// MT_QUE 테이블 필요 값 : USER_NO(작성자 번호), QUE_TITLE, QUE_CONTENT, ANS_NO
		String queTitle = request.getParameter("queTitle");
		String queContent = request.getParameter("queContent");
		int ansNo = Integer.parseInt(request.getParameter("ansNo"));
		
		// 세션 객체에서 뽑아온 작성자 번호
		int userNo = (int)((Member)request.getSession().getAttribute("loginUser")).getUserNo();
		
		MtQuestion mq = new MtQuestion();
		mq.setQueWriterNo(userNo);
		mq.setQueTitle(queTitle);
		mq.setQueContent(queContent);
		mq.setAnsWriterNo(ansNo);
		
		int result = new LecturerService().insertQuestion(mq);

		response.getWriter().print(result);
	}
	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
