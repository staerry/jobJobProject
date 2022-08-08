package com.jj.admin.controller;

import java.io.IOException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.Duration;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.google.gson.Gson;
import com.jj.admin.model.service.AdminService2;
import com.jj.admin.model.vo.GraphDate;

/**
 * Servlet implementation class GraphDetailController
 */
@WebServlet("/graphDetail.de")
public class GraphDetailController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public GraphDetailController() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	//------------------------------------------------------------------------------ 선택한 두날짜의차이수를 선택한 x값수로 나누기
		String a = request.getParameter("lastdate");
		String b = request.getParameter("currentdate");
		int s = Integer.parseInt(request.getParameter("s"));
		//System.out.println(a+" "+b+" "+s);
		LocalDate c; 
		LocalDate d;
		c = LocalDate.parse(a, DateTimeFormatter.ISO_LOCAL_DATE);
		d= LocalDate.parse(b, DateTimeFormatter.ISO_LOCAL_DATE);
		
		Duration diff = Duration.between(c.atStartOfDay(), d.atStartOfDay());
		long diffDays = diff.toDays();
		int aaa = (int) Math.ceil((double)diffDays/(s-1));
		//System.out.println(aaa);
	//-------------------------------------------------------------------------------- 
		SimpleDateFormat sdfYMD = new SimpleDateFormat("yyyy-MM-dd");
		Date last = null;
		Date cur;
		try {
			last = sdfYMD.parse(a);
		} catch (ParseException e) {
			e.printStackTrace();
		} 
		
		Calendar cal = Calendar.getInstance();
		cal.setTime(last);
		
		ArrayList<GraphDate> list = new ArrayList<>();
		
			list.add(new GraphDate(a));
			for(int i=0;i<s-2;i++) {
				cal.add(Calendar.DATE, aaa);
				list.add(new GraphDate(sdfYMD.format(cal.getTime())));
			}
			list.add(new GraphDate(b));
			
			list = new AdminService2().graph(list);
			
			for(int i=0;i<s;i++) {
				list.add(new GraphDate());
			}
			list = new AdminService2().graph2(list,s);
			
			for(int i=0;i<s;i++) {
				list.add(new GraphDate(list.get(i).getY()+list.get(i+s).getY()));
			}
			
			
			response.setContentType("application/json; charset=UTF-8");
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
