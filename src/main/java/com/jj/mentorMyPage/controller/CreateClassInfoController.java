package com.jj.mentorMyPage.controller;

import java.io.File;
import java.io.IOException;
import java.sql.Date;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.apache.tomcat.util.http.fileupload.servlet.ServletFileUpload;

import com.jj.common.MyFileRenamePolicy;
import com.jj.member.model.vo.Member;
import com.jj.mentorMyPage.model.service.MentorMyService;
import com.jj.mentorMyPage.model.vo.CreateClass;
import com.oreilly.servlet.MultipartRequest;

/**
 * Servlet implementation class CreateClassInfoController
 */
@WebServlet("/createClassInfo.my")
public class CreateClassInfoController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public CreateClassInfoController() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
	request.setCharacterEncoding("UTF-8");
		
		HttpSession session = request.getSession();
		
		Member m =(Member) session.getAttribute("loginUser");
		int userNo = m.getUserNo();
		
		
		// enctype이 multipart/form-data로 잘 전송되었을 경우 => 전반적인 내용 수행
				if(ServletFileUpload.isMultipartContent(request)) {
					
					// 1. 첨부파일 내가 지정한 resources 폴더 안에 저장하고
					
					// 1_1) 전달되는 파일의 용량 제한
					int maxSize = 10 * 1024 * 1024;
					
					// 1_2) 전달된 파일을 저장시킬 폴더의 경로 알아내기
//					폴더 : classCreateImgFiles
					//
					String savePath = session.getServletContext().getRealPath("/resources/image/classCreateImgFiles/");
					
					// 1_3) 전달된 파일의 파일명 수정 및 서버에 업로드 작업
					MultipartRequest multiRequest = new MultipartRequest(request, savePath, maxSize, "UTF-8", new MyFileRenamePolicy());
					
					// 2. 파일 저장 후 DB에 insert
					int clCategory = Integer.parseInt(multiRequest.getParameter("clCategory"));
					String clTitle = multiRequest.getParameter("className");
					String clsubTitle = multiRequest.getParameter("classSubName");
					
					String clInfo= multiRequest.getParameter("classDetail");
					String clCurri= multiRequest.getParameter("classDetail");
					int clPrice = Integer.parseInt(multiRequest.getParameter("clPrice"));
					
					
					
					CreateClass cc = null;
					
//					mt = new Mentor();
					cc = new CreateClass();
					
					cc.setClCategory(clCategory);
					cc.setClTitle(clTitle);
					cc.setClSubTitle(clsubTitle);
					cc.setClInfo(clInfo);
					cc.setClCurri(clCurri);
					cc.setClPrice(clPrice);
					cc.setClImg("resources/image/classCreateImgFiles/" + multiRequest.getFilesystemName("clImg")); // 파일경로 + 수정명
					
					
					
				
					
							
					int result = new MentorMyService().createClass(cc,userNo);
					
					if(result > 0) { // Class에 insert됨 => 대기중 화면으로 이동
						
						
						response.sendRedirect(request.getContextPath() + "/views/mentorMyPage/mentorClassManage");
						
					}else { // 실패 등록에 실패했습니다. 이 페이지 머무르기 가능? & 파일 삭제
						
						if(cc != null) {
							new File(savePath + multiRequest.getFilesystemName("clImg")).delete();
							
						}
						
						session.setAttribute("alertMsg", "클래스 등록에 싫패했습니다.");
//						response.sendRedirect(request.getContextPath()+ "/classWating.my");
						response.sendRedirect(request.getContextPath()+ "/myPage.my");
//						//마이페이지 메인 = 클래스관리 페이지로 가고싶은데..??모르겠어요
					}
					
				
					
					/*if(multiRequest.getOriginalFileName("mtEmpCard") != null) { // not null 이니까 첨부파일이 넘어온 것 // 근데 우리는 무조건 사원증 받으니까 if문 안써도 되는지??
						mt = new Mentor();
						
						mt.setEmpCardOriginName(multiRequest.getFilesystemName("mtEmpCard")); // 수정명을 원본명에 덮어씀
						mt.setEmpCardPath("resources/image/mentorEmpCardFiles/");
						
					}*/	

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
