package com.jj.member.controller;

import static com.jj.common.JDBCTemplate.close;
import static com.jj.common.JDBCTemplate.getConnection;

import java.io.IOException;
import java.sql.Connection;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.jj.classSelect.model.dao.ClassDao;
import com.jj.classSelect.model.vo.Class;
import com.jj.community.model.dao.CommunityDao;
import com.jj.community.model.vo.Community;
import com.jj.member.model.dao.SearchDao;
import com.jj.mentorSelect.model.dao.LecturerDao;
import com.jj.mentorSelect.model.vo.Lecturer;

/**
 * Servlet implementation class SearchClassListView
 */
@WebServlet("/searchResultView.me")
public class SearchListView extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public SearchListView() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");
		
		String keyword = request.getParameter("keyword");
		
		Connection conn = getConnection();
		
//		검색결과 갯수
		int classCount = new SearchDao().searchCount(conn, keyword, "class");
		int lecturerCount = new SearchDao().searchCount(conn, keyword, "lecturer");
		int communityCount = new SearchDao().searchCount(conn, keyword, "community");
		
//		검색결과
		ArrayList<Class> classList = new ClassDao().selectClassList(conn, keyword);
		ArrayList<Lecturer> lecturerList = new LecturerDao().selectMainMentorList(conn, keyword); 
		ArrayList<Community> communityList = new CommunityDao().selectCommunityList(conn, keyword);
		
		close(conn);
		
		request.setAttribute("keyword", keyword);
		request.setAttribute("classCount",  classCount);
		request.setAttribute("lecturerCount", lecturerCount);
		request.setAttribute("communityCount", communityCount);
		request.setAttribute("classList", classList);
		request.setAttribute("lecturerList", lecturerList);
		request.setAttribute("communityList", communityList);
		request.getRequestDispatcher("views/search/searchListView.jsp").forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
