<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">

<link rel="stylesheet" href="resources/css/admin/admin-login.css">

<title>Insert title here</title>
</head>
<body>

	<% if(false){ %>
		<div style="display : none;">
			<%@ include file="common/topbar.jsp" %>
		</div>
	    <div class="admin-login-area">
	        <img src="resources/image/logo.png" alt="logo" width="150">
	        <p>관리자로그인</p>
	        <form action="" method="post" class="login-area">
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
		        <h3 style="color : #6363ff">멘토 가입 정보</h3>
		    </div>
	    </div>
	<% } %>


		
</body>
</html>