package com.jj.admin.controller;

import java.io.File;
import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.apache.tomcat.util.http.fileupload.servlet.ServletFileUpload;

import com.jj.admin.model.service.AdminService;
import com.jj.member.model.vo.SlideAttachment;
import com.oreilly.servlet.MultipartRequest;

/**
 * Servlet implementation class SlideInsertController
 */
@WebServlet("/insertSlide.ad")
public class SlideInsertController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public SlideInsertController() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");
		
		HttpSession session = request.getSession();

		if(ServletFileUpload.isMultipartContent(request)) {
			int maxSize = 1024 * 1024 * 10;
			String savePath = session.getServletContext().getRealPath("/resources/image/");
			MultipartRequest multiRequest = new MultipartRequest(request, savePath, maxSize, "UTF-8", null);
			
			SlideAttachment slide = null;
			if(multiRequest.getOriginalFileName("fileName") != null) {
				slide = new SlideAttachment();
				
				slide.setFileName(multiRequest.getOriginalFileName("fileName"));
				slide.setFilePath(request.getContextPath() + "/resources/image/");
				
				int result = new AdminService().insertSlide(slide);
				if(result > 0) {
					session.setAttribute("alertMsg", "업로드 했습니다.");
				}else {
					if(slide != null) {
						new File(slide.getFilePath() + slide.getFileName()).delete();
					}
					session.setAttribute("alertMsg","업로드를 실패 했습니다.");
				}
				
				response.sendRedirect(request.getContextPath() + "/slideListView.ad");
			}
			
		}
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
