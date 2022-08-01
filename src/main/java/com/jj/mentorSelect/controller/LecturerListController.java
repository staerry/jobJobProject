package com.jj.mentorSelect.controller;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.jj.mentorSelect.model.service.LecturerService;
import com.jj.mentorSelect.model.vo.Lecturer;

/**
 * Servlet implementation class LecturerListController
 */
@WebServlet("/list.lt")
public class LecturerListController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public LecturerListController() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// 전체 강의자 수
		int listCount = new LecturerService().selectListCount();
		
		// 전체 멘토 정보 담긴 ArrayList
		ArrayList<Lecturer> list = new LecturerService().selectList();
		
		request.setAttribute("listCount", listCount);
		request.setAttribute("list", list);
		request.getRequestDispatcher("views/mentorSelect/lecturerListView.jsp").forward(request, response);
	
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
