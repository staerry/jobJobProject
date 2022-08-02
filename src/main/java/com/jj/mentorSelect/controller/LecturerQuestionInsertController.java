package com.jj.mentorSelect.controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.jj.mentorSelect.model.service.LecturerService;
import com.jj.mentorSelect.model.vo.MtQuestion;

/**
 * Servlet implementation class LecturerQuestionInsertController
 */
@WebServlet("/qqinsert.lt")
public class LecturerQuestionInsertController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public LecturerQuestionInsertController() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		int userNo = Integer.parseInt(request.getParameter("userNo"));
		int lecNo = Integer.parseInt(request.getParameter("lecNo"));
		String title = request.getParameter("title");
		String content = request.getParameter("content");
		
		MtQuestion mq = new MtQuestion();
		mq.setQueWriterNo(userNo);
		mq.setAnsWriterNo(lecNo);
		mq.setQueTitle(title);
		mq.setQueContent(content);
		
		int result = new LecturerService().insertQuestion(mq);
		
		request.setAttribute("result", result);
		request.getRequestDispatcher("views/mentorSelect/lecturereDetailView.jsp").forward(request, response);
		
		
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
