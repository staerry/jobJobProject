package com.jj.member.controller;

import java.io.File;
import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.apache.tomcat.util.http.fileupload.servlet.ServletFileUpload;

import com.jj.common.MyFileRenamePolicy;
import com.jj.member.model.service.MemberService;
import com.jj.member.model.vo.Member;
import com.jj.member.model.vo.Mentor;
import com.jj.member.model.vo.SlideAttachment;
import com.oreilly.servlet.MultipartRequest;

/**
 * Servlet implementation class MentorInsertController
 */
@WebServlet("/insertMentor.me")
public class MentorInsertController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public MentorInsertController() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		request.setCharacterEncoding("UTF-8");
		
		HttpSession session = request.getSession();
		
		// 일반요청방식이 아닌 multipart/form-data로 요청방식은 request로부터 바로 값 뽑기 불가능
		
		// enctype이 multipart/form-data로 잘 전송되었을 경우 => 전반적인 내용 수행
		if(ServletFileUpload.isMultipartContent(request)) {
			
			// 1. 첨부파일 내가 지정한 resources 폴더 안에 저장하고
			
			// 1_1) 전달되는 파일의 용량 제한
			int maxSize = 10 * 1024 * 1024;
			
			// 1_2) 전달된 파일을 저장시킬 폴더의 경로 알아내기
			
				// 멘토 사원증 저장할 폴더 : mentorEmpCardFiles
				// 멘토 신분증 저장할 폴더 : mentorIdCardFIles
			String savePath = session.getServletContext().getRealPath("/resources/image/mentorEmpIdCardFiles/");
			
			// 1_3) 전달된 파일의 파일명 수정 및 서버에 업로드 작업
			MultipartRequest multiRequest = new MultipartRequest(request, savePath, maxSize, "UTF-8", new MyFileRenamePolicy());
			
			// 2. 파일 저장 후 DB에 insert
			//  > 아이디, 비번, 이름, 이메일, 핸드폰 번호 => Member테이블에 insert 
			String userId = multiRequest.getParameter("mtId");
			String userPwd = multiRequest.getParameter("mtPwd");
			String userName = multiRequest.getParameter("mtName");
			String userEmail = multiRequest.getParameter("mtId");
			String userPhone = multiRequest.getParameter("mtPhone");
			
			Member m = new Member(userId, userPwd, userName, userEmail, userPhone);
			
			//  > 멘토 (소속회사, 현재직급)  => Mentor테이블에 insert
			int field = Integer.parseInt(multiRequest.getParameter("field"));
			String mtCompany = multiRequest.getParameter("mtCompany");
			String mtPosition = multiRequest.getParameter("mtPosition");
			
			// 사원증 사진, 신분증 사진 => Mentor테이블에 insert, SlideAttachment에 insert
			// 사원증 사진 ( 원본명,  수정명, 저장경로 알아야함) = EmpCard
			// multiRequest.getOriginalFileName("사원증 사진의 name값 = mtEmpCard") : 원본파일명 알아내는 메소드
			Mentor mt = null;
			
			mt = new Mentor();
			
			mt.setClcgNo(field);
			mt.setEmpCardPath("resources/image/mentorEmpIdCardFiles/" + multiRequest.getFilesystemName("mtEmpCard")); // 파일경로 + 수정명
			mt.setEmpCardOriginName(multiRequest.getOriginalFileName("mtEmpCard")); // 원본명
			mt.setIdCardPath("resources/image/mentorEmpIdCardFiles/" + multiRequest.getFilesystemName("mtIdCard"));
			mt.setIdCardOriginName(multiRequest.getOriginalFileName("mtIdCard")); // 원본명
			mt.setMtCompany(mtCompany);
			mt.setMtJob(mtPosition);
			
					
			int result = new MemberService().insertMentorTo_UserInfo_Mentor(m, mt);
			
			if(result > 0) { // USERINFO & MENTOR에 제대로 insert됨 => 대기중 화면으로 이동
				
				session.setAttribute("alertMsg", "성공적으로 가입되었습니다!");
				response.sendRedirect(request.getContextPath() + "/mentorWaiting.me");
				
			}else { // 실패 가입에 실패했습니다. 이 페이지 머무르기 가능? & 파일 삭제
				
				if(mt != null) {
					new File(savePath + multiRequest.getFilesystemName("mtEmpCard")).delete();
					new File(savePath + multiRequest.getFilesystemName("mtIdCard")).delete();
				}
				
				session.setAttribute("alertMsg", "멘토가입에 실패했습니다.");
				response.sendRedirect(request.getContextPath());
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
