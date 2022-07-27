package com.jj.admin.controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.jj.admin.model.service.AdminService;
import com.jj.faq.model.vo.Faq;

/**
 * Servlet implementation class FAQModifyController
 */
@WebServlet("/faqModify.ad")
public class FAQModifyController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public FAQModifyController() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");
		
		int faqNo = Integer.parseInt(request.getParameter("faqNo"));
		String faqTitle = request.getParameter("faqTitle");
		String faqAnswer = request.getParameter("faqAnswer");
		
		Faq faq = new Faq();
		faq.setFaqNo(faqNo);
		faq.setFaqTitle(faqTitle);
		faq.setFaqAnswer(faqAnswer);
		
		int result = new AdminService().updateFaq(faq);
		
		if(result > 0) {
			request.getSession().setAttribute("alertMsg", "수정을 완료 했습니다.");
		}else {
			request.getSession().setAttribute("alertMsg", "수정을 실패 했습니다.");
		}
		
		response.sendRedirect(request.getContextPath() + "/faqListView.ad?cpage=1");
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
