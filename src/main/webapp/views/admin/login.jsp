<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8" import="com.jj.admin.model.vo.UserInfoAd"%>
<%
	UserInfoAd u = (UserInfoAd)session.getAttribute("UserInfoAd");
	String alertMsg = (String)session.getAttribute("alertMsg");
%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">

<link rel="stylesheet" href="${pageContext.request.contextPath}/resources/css/admin/admin-login.css">
<title>Insert title here</title>
</head>
<body>
	<% if(alertMsg != null) { %>
		<script>
			alert("<%=alertMsg%>");
		</script>
		<% session.removeAttribute("alertMsg");%>
	<% } %>

	<% if(u == null){ %>
		<div style="display : none;">
			<%@ include file="common/topbar.jsp" %>
		</div>
	    <div class="admin-login-area">
	        <img src="${pageContext.request.contextPath}/resources/image/logo.png" alt="logo" width="150">
	        <p>관리자로그인</p>
	        <form action="adLogin.do" method="post" class="login-area">
	            <input type="text" name="adminId" class="form-control" placeholder="아이디" required><br>
	            <input type="password" name="adminPwd" class="form-control" placeholder="비밀번호" required><br>
	            <button type="submit">로그인</button>
	        </form>
	    </div>
	<% } else { %>
		<%@ include file="common/topbar.jsp" %>
	
		<div class="content-wrap">
	    	<!--이 부분에 좌측메뉴 넣으세요-->
	    	<div class="left">
				<%@ include file="common/menubar.jsp" %>
			</div>
	
		    <!--이 부분은 우측 컨텐츠 입니다.-->
		    <div class="right">
		        <h3 style="color : #6363ff">대시보드</h3>
		        <div class="statistics-area">
					<div class="item1">
						<div class="text">
							<span>총 회원수</span><br>
							<span>12321</span>
						</div>
						<div class="img">
							<i class="fas fa-user-friends"></i>
						</div>
					</div>
					<div class="item2">
						<div class="text">
							<span>수강생수</span><br>
							<span>12321</span>
						</div>
						<div class="img">
							<i class="fas fa-user-alt"></i>
						</div>
					</div>
					<div class="item3">
						<div class="text">
							<span>멘토수</span><br>
							<span>12321</span>
						</div>
						<div class="img">
							<i class="fas fa-user-alt"></i>
						</div>
					</div>
					<div class="item4">
						<div class="text">
							<span>일일 접속자</span><br>
							<span>12321</span>
						</div>
						<div class="img">
							<i class="fas fa-user-friends"></i>
						</div>
					</div>
		        </div>

		        <div class="post-area">
						<ul class="item1">
							<li class="item-title">
								<span>1대1 문의관리</span>
								<span><a href="">더보기</a></span>
							</li>
							<li class="item-content">
								<span><a href="">문의드립니다.</a></span>
								<span>2022-12-12</span>
							</li>
							<li class="item-content">
								<span><a href="">문의드립니다.</a></span>
								<span>2022-12-12</span>
							</li>
							<li class="item-content">
								<span><a href="">문의드립니다.</a></span>
								<span>2022-12-12</span>
							</li>
							<li class="item-content">
								<span><a href="">문의드립니다.</a></span>
								<span>2022-12-12</span>
							</li>
							<li class="item-content">
								<span><a href="">문의드립니다.</a></span>
								<span>2022-12-12</span>
							</li>
							<li class="item-content">
								<span><a href="">문의드립니다.</a></span>
								<span>2022-12-12</span>
							</li>
						</ul>
						<ul class="item2">
							<li class="item-title">
								<span>공지사항 관리</span>
								<span><a href="">더보기</a></span>
							</li>
							<li class="item-content">
								<span><a href="">문의드립니다.</a></span>
								<span>2022-12-12</span>
							</li>
							<li class="item-content">
								<span><a href="">문의드립니다.</a></span>
								<span>2022-12-12</span>
							</li>
							<li class="item-content">
								<span><a href="">문의드립니다.</a></span>
								<span>2022-12-12</span>
							</li>
							<li class="item-content">
								<span><a href="">문의드립니다.</a></span>
								<span>2022-12-12</span>
							</li>
							<li class="item-content">
								<span><a href="">문의드립니다.</a></span>
								<span>2022-12-12</span>
							</li>
							<li class="item-content">
								<span><a href="">문의드립니다.</a></span>
								<span>2022-12-12</span>
							</li>
						</ul>
				</div>

		        <div class="notification-area">
					<div class="item1">
						<div class="text">
							<span>멘토 가입 신청</span><br>
							<span>2</span>
						</div>
						<div class="img">
							<a href="">
								<i class="fas fa-angle-right"></i>
							</a>
						</div>
					</div>
					<div class="item2">
						<div class="text">
							<span>강의 등록 신청</span><br>
							<span>2</span>
						</div>
						<div class="img">
							<a href="">
								<i class="fas fa-angle-right"></i>
							</a>
						</div>
					</div>
					<div class="item3">
						<div class="text">
							<span>결제</span><br>
							<span>2</span>
						</div>
						<div class="img">
							<a href="">
								<i class="fas fa-angle-right"></i>
							</a>
						</div>
					</div>
					<div class="item4">
						<div class="text">
							<span>환불 요청</span><br>
							<span>2</span>
						</div>
						<div class="img">
							<a href="">
								<i class="fas fa-angle-right"></i>
							</a>
						</div>
					</div>
				</div>
		    </div>
	    </div>
	<% } %>


		
</body>
</html>