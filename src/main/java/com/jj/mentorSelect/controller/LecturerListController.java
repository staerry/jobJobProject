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

		// 넘어오는 category value 배열에 받기
		String[] category = request.getParameterValues("category");
		
		// 전체 선택한 경우 
		// 1) 전체 버튼 하나만 클릭 ==> category == null
		// 2) 모든 버튼 클릭 ==> category.length == 7
		
		int cLength = 0;	// 배열 category 길이 담을 변수 선언
		
		if (category != null) {	// null일 경우 0
			cLength =  category.length;	
		}	
		
		int listCount = 0;
		ArrayList<Lecturer> list = new ArrayList<>();
		
		if(cLength == 0 || cLength == 7) {	// 전체 선택 ==> 전체 조회			
			listCount = new LecturerService().selectListCount();
			list = new LecturerService().selectList();
			
		}else if(cLength >= 1 && cLength <= 6) {
			switch(cLength) {
			case 1:
				listCount = new LecturerService().selectListCountOne(category);
				list = new LecturerService().selectListOne(category);
				break;
			case 2: 
				listCount = new LecturerService().selectListCountTwo(category);
				list = new LecturerService().selectListTwo(category);
				break;
			case 3: 
				listCount = new LecturerService().selectListCountThree(category);
				list = new LecturerService().selectListThree(category);
				break;
			case 4: 
				listCount = new LecturerService().selectListCountFour(category);
				list = new LecturerService().selectListFour(category);
				break;
			case 5: 
				listCount = new LecturerService().selectListCountFive(category);
				list = new LecturerService().selectListFive(category);
				break;
			case 6: 
				listCount = new LecturerService().selectListCountSix(category);
				list = new LecturerService().selectListSix(category);
				break;
				
			}
		}
				
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
