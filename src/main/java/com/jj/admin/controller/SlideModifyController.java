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
 * Servlet implementation class SlideModifyController
 */
@WebServlet("/modifySlide.ad")
public class SlideModifyController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public SlideModifyController() {
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
			
//			디렉토리에 수정할 이미지 보관 후
			MultipartRequest multiRequest = new MultipartRequest(request, savePath, maxSize, "UTF-8", null);
			
			int fileNo = Integer.parseInt(multiRequest.getParameter("fileNo"));
			
//			db에서 기존 이미지 정보를 조회해 삭제(db에 입력하기 전이라 불러오기 가능)
			SlideAttachment slideImg = new AdminService().selectSlide(fileNo);
			new File(savePath + slideImg.getFileName()).delete();

			SlideAttachment slide = null;
			if(multiRequest.getOriginalFileName("fileName") != null) {
				slide = new SlideAttachment();

				slide.setFileName(multiRequest.getOriginalFileName("fileName"));
				slide.setFilePath("resources/image/");
				slide.setFileNo(fileNo);
				
				int result = new AdminService().updateSlide(slide);
				
				if(result > 0) {
					session.setAttribute("alertMsg", "수정 했습니다.");
				}else {
					session.setAttribute("alertMsg", "수정에 실패 했습니다.");
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
