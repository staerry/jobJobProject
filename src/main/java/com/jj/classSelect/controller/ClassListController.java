package com.jj.classSelect.controller;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.google.gson.Gson;
import com.jj.classSelect.model.service.ClassService;
import com.jj.classSelect.model.vo.Class;

/**
 * Servlet implementation class ClassListController
 */
@WebServlet("/list.cl")
public class ClassListController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ClassListController() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		String category = request.getParameter("category");
		// 값이 없을 때
		// 값이 all일 때
		// 값이 그냥 카테고리 숫자일 때 
//		System.out.println(category);
		
		String sort = request.getParameter("sort");

		// 전체 조회
		// 전체 + sort
		// 카테고리 조회
		// 카테고리 + sort
		
		int listCount;
		ArrayList<Class> list = new ArrayList<>();
		
		System.out.println(category);
		System.out.println(sort);
		
		
		if(category == null || category.equals("all") || category.equals("") || Integer.parseInt(category) == 0) {	// 상단 메뉴바-강의조회(null) | 왼쪽 메뉴바 전체(all)를 선택한 경우
						
			if(sort == null || sort.equals("no") || sort.equals("")) {
				list = new ClassService().selectListAll(); 
			}else if (sort.equals("score")) {
				list = new ClassService().selectListAllByScore(); 
			}else if (sort.equals("price")){
				list = new ClassService().selectListAllByPrice();
			}
			
			listCount = new ClassService().selectListCountAll();
			
		}else {	// 카테고리 선택한 경우
			
			if(sort == null || sort.equals("") || sort.equals("no")) {
				list = new ClassService().selectList(category);
			}else if (sort.equals("score")) {
				list = new ClassService().selectListByScore(category);
			}else if (sort.equals("price")){
				list = new ClassService().selectListByPrice(category);
			}
			
			listCount = new ClassService().selectListCount(category);
		}
		
		request.setAttribute("category", category);
		request.setAttribute("listCount", listCount);
		request.setAttribute("list", list);
		request.getRequestDispatcher("views/classSelect/classListView.jsp").forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
