package com.jj.member.controller;

import java.io.IOException;

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
			
				// 멘토 프로필 사진 저장할 폴더 : mentorSelect
			String savePath = session.getServletContext().getRealPath("/resources/image/mentorSelect/");
			
			// 1_3) 전달된 파일의 파일명 수정 및 서버에 업로드 작업
			MultipartRequest multiRequest = new MultipartRequest(request, savePath, maxSize, "UTF-8", new MyFileRenamePolicy());
			
			
			// 2. 파일 저장 후 DB에 insert
			//  > 멘토 (이름, 이메일= 아이디, 비밀번호, 핸드폰번호, 소속회사, 현재직급)  => Mentor테이블에 insert
			//  > => Member테이블에 insert
			String userId = multiRequest.getParameter("mtId");
			String userPwd = multiRequest.getParameter("mtPwd");
			String userName = multiRequest.getParameter("mtName");
			String userEmail = multiRequest.getParameter("mtId");
			String userPhone = multiRequest.getParameter("mtPhone");
			
			Member m = new Member(userId, userPwd, userName, userEmail, userPhone);
			
			int result1 = new MemberService().insertMentorToUserInfo(m);
			
			if(result1 > 0) { // USERINFO 테이블에 멘토 정보 입력 완료
				session.setAttribute("alertMsg", "성공적으로 가입되었습니다!");
				response.sendRedirect(request.getContextPath());
			}else { // 실패
				session.setAttribute("alertMsg", "가입에 실패하였습니다.");
				response.sendRedirect(request.getContextPath());
				
			}
			
//			String mtName = multiRequest.getParameter("mtName");
//			String mtId = multiRequest.getParameter("mtId");
//			String mtPwd = multiRequest.getParameter("mtPwd");
//			String mtPhone = multiRequest.getParameter("mtPhone");
//	
//			String mtCompany = multiRequest.getParameter("mtCompany");
//			String mtPosition = multiRequest.getParameter("mtPosition");
//			
//			Mentor mt = new Mentor();
//			
//			
//			int boardWriter = ((Member)session.getAttribute("loginUser")).getUserNo();
//			
//			Board b = new Board();
//			b.setCategory(category);
//			b.setBoardTitle(boardTitle);
//			b.setBoardContent(boardContent);
//			b.setBoardWriter(String.valueOf(boardWriter));
		}
		
//		// 이름, 이메일, 비밀번호, 핸드폰번호, 소속회사, 현재직급, 
//		String mtName = request.getParameter("mtName");
//		String mtId = request.getParameter("mtId");
//		String mtPwd = request.getParameter("mtPwd");
//		String mtPhone = request.getParameter("mtPhone");
//		
//		String mtCompany = request.getParameter("mtCompany");
//		String mtPosition = request.getParameter("mtPosition");
//	
//		// 프로필사진, 사원증 사진, 신분증 사진
//		
//		Mentor mt = new Mentor();
//	
	
	
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
