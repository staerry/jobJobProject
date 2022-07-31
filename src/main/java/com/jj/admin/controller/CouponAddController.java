package com.jj.admin.controller;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.jj.admin.model.service.AdminService2;
import com.jj.classSelect.model.vo.ClassIng;
import com.jj.member.model.vo.Member;

/**
 * Servlet implementation class CouponAddController
 */
@WebServlet("/cpadd.up")
public class CouponAddController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public CouponAddController() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		String cpName = request.getParameter("cpName");
		int discount = Integer.parseInt(request.getParameter("cpDis"));
		int grade = Integer.parseInt(request.getParameter("grade"));
		HttpSession session = request.getSession();
		String cp = request.getContextPath();
		
//------------------------------------------------------------------------------------		
		
		if(grade == 4) {
			int result = new AdminService2().insertCoupon(cpName,discount);
			if(result>0) {
				session.setAttribute("alertMsg", "쿠폰등록에 성공했습니다.");
				response.sendRedirect(cp+"/couponManage.ad?p=1");
			}else {
				session.setAttribute("alertMsg", "쿠폰등록에 실패했습니다.");
				response.sendRedirect(cp+"/couponManage.ad?p=1");
			}
		}
		
		//---------------------------------------------------------------------------
		
		else if(grade == 3) {
			ArrayList<ClassIng> list = new ArrayList<>();
			list = new AdminService2().classStu();
			if(list.isEmpty()) {
				session.setAttribute("alertMsg", "조건에맞는 조회된회원이 없습니다.");
				response.sendRedirect(cp+"/couponManage.ad?p=1");
			}else {
				int result = new AdminService2().insertCoupon(cpName,discount);
				if(result>0) {
					int no = new AdminService2().CouponNo();
					int result2 = new AdminService2().sendCouponClStu(list,no);
					if(result2>0) {
						session.setAttribute("alertMsg", "쿠폰등록과전달에 성공했습니다.");
						response.sendRedirect(cp+"/couponManage.ad?p=1");
					}else {
						session.setAttribute("alertMsg", "쿠폰전달에 실패했습니다.");
						response.sendRedirect(cp+"/couponManage.ad?p=1");
					}
				}else {
					session.setAttribute("alertMsg", "쿠폰등록에 실패했습니다.");
					response.sendRedirect(cp+"/couponManage.ad?p=1");
				}
			}
		}
		
		//---------------------------------------------------------------------------
		
		else if(grade == 2) {
			ArrayList<Integer> list = new ArrayList<>();
			list = new AdminService2().allStuNo();
			if(list.isEmpty()) {
				session.setAttribute("alertMsg", "조건에맞는 조회된회원이 없습니다.");
				response.sendRedirect(cp+"/couponManage.ad?p=1");
			}else {
				int result = new AdminService2().insertCoupon(cpName,discount);
				if(result>0) {
					int no = new AdminService2().CouponNo();
					int result2 = new AdminService2().sendCoupon(list,no);
					if(result2>0) {
						session.setAttribute("alertMsg", "쿠폰등록과전달에 성공했습니다.");
						response.sendRedirect(cp+"/couponManage.ad?p=1");
					}else {
						session.setAttribute("alertMsg", "쿠폰전달에 실패했습니다.");
						response.sendRedirect(cp+"/couponManage.ad?p=1");
					}
				}else {
					session.setAttribute("alertMsg", "쿠폰등록에 실패했습니다.");
					response.sendRedirect(cp+"/couponManage.ad?p=1");
				}
			}
		}
		
		//----------------------------------------------------------------------------
		
		else if(grade == 1) {
			ArrayList<Integer> list = new ArrayList<>();
			list = new AdminService2().allMemNo();
			if(list.isEmpty()) {
				session.setAttribute("alertMsg", "조건에맞는 조회된회원이 없습니다.");
				response.sendRedirect(cp+"/couponManage.ad?p=1");
			}else {
				int result = new AdminService2().insertCoupon(cpName,discount);
				if(result>0) {
					int no = new AdminService2().CouponNo();
					int result2 = new AdminService2().sendCoupon(list,no);
					if(result2>0) {
						session.setAttribute("alertMsg", "쿠폰등록과전달에 성공했습니다.");
						response.sendRedirect(cp+"/couponManage.ad?p=1");
					}else {
						session.setAttribute("alertMsg", "쿠폰전달에 실패했습니다.");
						response.sendRedirect(cp+"/couponManage.ad?p=1");
					}
				}else {
					session.setAttribute("alertMsg", "쿠폰등록에 실패했습니다.");
					response.sendRedirect(cp+"/couponManage.ad?p=1");
				}
			}
		}
		
		//--------------------------------------------------------------------------
		
		else {
			session.setAttribute("alertMsg", "잘못된 회원선택입니다.");
			response.sendRedirect(cp+"/couponManage.ad?p=1");
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
