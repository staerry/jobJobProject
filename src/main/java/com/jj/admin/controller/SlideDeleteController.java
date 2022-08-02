package com.jj.admin.controller;

import java.io.File;
import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.jj.admin.model.service.AdminService;
import com.jj.member.model.vo.SlideAttachment;

/**
 * Servlet implementation class SlideDeleteController
 */
@WebServlet("/deleteSlide.ad")
public class SlideDeleteController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public SlideDeleteController() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		int slideNo = Integer.parseInt(request.getParameter("no"));
		
//		삭제할 이미지 경로를 가져옴
		String savePath = request.getSession().getServletContext().getRealPath("/resources/image/");
		
//		삭제할 이미지 이름을 가져옴
		SlideAttachment slide = new AdminService().selectSlide(slideNo);
		
//		이미지 삭제 후 db삭제
		new File(savePath + slide.getFileName()).delete();

		int result = new AdminService().deleteSlide(slideNo);
		
		if(result > 0) {
			request.getSession().setAttribute("alertMsg", "삭제했습니다.");
		}else {
			request.getSession().setAttribute("alertMsg", "삭제를 실패했습니다.");
		}
		
		response.sendRedirect(request.getContextPath() + "/slideListView.ad?no=1");
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
