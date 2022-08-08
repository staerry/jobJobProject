package com.jj.admin.controller;

import java.io.IOException;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Calendar;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.google.gson.Gson;
import com.jj.admin.model.service.AdminService2;
import com.jj.admin.model.vo.BoardData;

/**
 * Servlet implementation class BoardController
 */
@WebServlet("/boardDetail.de")
public class BoardController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public BoardController() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		LocalDate d;
		if(request.getParameter("day")==null || request.getParameter("day").equals("")) {
			d = LocalDate.now();
		}else {
			String day3 = request.getParameter("day");
			String day2 = day3.replace("-", "");
			int year = Integer.parseInt(day2.substring(0, 4));
			int month = Integer.parseInt(day2.substring(4, 6));
			int day = Integer.parseInt(day2.substring(6, 8));
			d = LocalDate.of(year,month,day);
		}
		String date = d.toString();
		System.out.println(date);
		ArrayList<BoardData> list = new ArrayList<>();
		list.add(new BoardData(date));
		for(int i=1;i<=6;i++) {
			String a = d.minusDays(i).toString();
			System.out.println(a);
			list.add(new BoardData(a));
		}
		list = new AdminService2().boardDetail(list);
		response.setContentType("applycation/json; charset=UTF-8");
		new Gson().toJson(list,response.getWriter());
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
