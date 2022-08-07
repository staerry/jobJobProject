package com.jj.mentorMyPage.controller;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.apache.tomcat.util.http.fileupload.servlet.ServletFileUpload;

import com.jj.common.MyFileRenamePolicy;
import com.jj.common.ProfileFileRenamePolicy;
import com.jj.member.model.vo.Member;
import com.jj.mentorMyPage.model.service.MentorMyService;
import com.jj.mentorMyPage.model.vo.Vod;
import com.jj.userMyPage.model.service.UserClassService;
import com.jj.userMyPage.model.vo.Bookmark;
import com.jj.userMyPage.model.vo.Class;
import com.jj.userMyPage.model.vo.Lecturer;
import com.oreilly.servlet.MultipartRequest;
import com.oreilly.servlet.multipart.DefaultFileRenamePolicy;


/**
 * Servlet implementation class MentorProfileEditController
 */
@WebServlet("/mtProEdit.my")
public class MentorProfileEditController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public MentorProfileEditController() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	
		// 멘토 프로필 수정  - 정보 담아서 보내야함
		HttpSession session = request.getSession();
		
		Member member = (Member) session.getAttribute("loginUser");
		if(member != null) {
			Lecturer lecturer = new MentorMyService().selectLecturerByUserNo(member);	
			
			request.setAttribute("lecturer", lecturer);
			request.getRequestDispatcher("views/mentorMyPage/mentorProfileEdit.jsp").forward(request, response);
		}else {
			request.setAttribute("alertMsg", "로그인이 필요합니다");
			request.getRequestDispatcher("views/member/memberLoginSecond.jsp").forward(request, response);
		}
				
				
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		request.setCharacterEncoding("UTF-8");
		response.setCharacterEncoding("UTF-8"); 
		response.setContentType("text/html;charset=UTF-8");
		HttpSession session = request.getSession();
		
		Member member =(Member) session.getAttribute("loginUser");
//		int userNo = member.getUserNo();
		
		if(member != null) {
			// enctype이 multipart/form-data로 잘 전송되었을 경우 => 전반적인 내용 수행
			if(ServletFileUpload.isMultipartContent(request)) {
				
				// 1. 첨부파일 내가 지정한 resources 폴더 안에 저장하고
				
				// 1_1) 전달되는 파일의 용량 제한
				int maxSize = 10 * 1024 * 1024; //10mb
				
				// 1_2) 전달된 파일을 저장시킬 폴더의 경로 알아내기
				
					// 멘토 사원증 저장할 폴더 : mentorEmpCardFiles
					// 멘토 신분증 저장할 폴더 : mentorIdCardFIles
				//
				String savePath = session.getServletContext().getRealPath("/resources/image/mentorProfileImg/");
				
				// 1_3) 전달된 파일의 파일명 수정 및 서버에 업로드 작업
				MultipartRequest multiRequest = new MultipartRequest(request, savePath, maxSize, "UTF-8", new ProfileFileRenamePolicy());
				

				Lecturer lecturer = new Lecturer();
				lecturer.setLtrInfo(multiRequest.getParameter("ltrInfo"));
				lecturer.setLtrCareer(multiRequest.getParameter("ltrCareer"));
				String profile = new MentorMyService().selectProfile(member);
				
				if(multiRequest.getFilesystemName("imgFile") != null) {
					//이미지 업로드가 이루어질 경우 
					lecturer.setProfilePath("resources/image/mentorProfileImg/" + multiRequest.getFilesystemName("imgFile"));
					
				}else {
					//이미지 업로드를 안했을 경우 기존 이미지 경로 재지정
					lecturer.setProfilePath(profile);
				}
//				vod.setVodFile("resources/video/" + multiRequest.getFilesystemName("vodFile"));
//				cc.setClImg("resources/image/classCreateImgFiles/" + multiRequest.getFilesystemName("clImg")); // 파일경로 + 수정명
				System.out.println(lecturer);
				
				int result = new MentorMyService().updateLecturer(member, lecturer);
				
				if(result > 0) { // Class에 insert됨 => 대기중 화면으로 이동
					session.setAttribute("alertMsg", "프로필 수정을 완료했습니다.");
					
				}else { // 실패 가입에 실패했습니다. 이 페이지 머무르기 가능? & 파일 삭제
					
//					if(cc != null) {
//						new File(savePath + multiRequest.getFilesystemName("clImg")).delete();
//						
//					}
//					
					session.setAttribute("alertMsg", "프로필 수정 실패했습니다.");
//							//마이페이지 메인 = 클래스관리 페이지로 가고싶은데..??모르겠어요
				}
				response.sendRedirect(request.getContextPath()+ "/mtProEdit.my");
				
			
				
				/*if(multiRequest.getOriginalFileName("mtEmpCard") != null) { // not null 이니까 첨부파일이 넘어온 것 // 근데 우리는 무조건 사원증 받으니까 if문 안써도 되는지??
					mt = new Mentor();
					
					mt.setEmpCardOriginName(multiRequest.getFilesystemName("mtEmpCard")); // 수정명을 원본명에 덮어씀
					mt.setEmpCardPath("resources/image/mentorEmpCardFiles/");
					
				}*/	

			}
		}else {
			request.getRequestDispatcher("views/member/memberLoginSecond.jsp").forward(request, response);
		}
		

	}

}
