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
import com.jj.community.model.vo.Review;

/**
 * Servlet implementation class AjaxReviewSelect
 */
@WebServlet("/review.cl")
public class AjaxReviewSelect extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public AjaxReviewSelect() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		int clNo = Integer.parseInt(request.getParameter("clNo"));
		String standard = request.getParameter("standard");
	
		ArrayList<Review> sortedList = new ArrayList<>();
		
		switch(standard) {
		case "date" : sortedList = new ClassService().selectReviewByDate(clNo); break;
		case "highScore" : sortedList = new ClassService().selectReviewByScoreDesc(clNo); break;
		case "lowScore" : sortedList = new ClassService().selectReviewByScoreAsc(clNo); break;
		}
				
		System.out.println(clNo);
		System.out.println(standard);
		
		System.out.println("list : " + sortedList);
		
		response.setContentType("application/json; charset=UTF-8");
		new Gson().toJson(sortedList, response.getWriter());
				
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
