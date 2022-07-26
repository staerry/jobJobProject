<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<link rel="stylesheet" href="${pageContext.request.contextPath}/resources/css/admin/noticeInsertPage.css">
<title>Insert title here</title>
</head>
<body>
	<%if(session.getAttribute("UserInfoAd") == null){ %>
	<script>
		alert("유효하지않은 접근입니다.");
		location.href="<%= request.getContextPath() %>/login.ad";
	</script>
	<%}else{ %>
	<%@ include file="common/topbar.jsp" %>
	
	<div class="content-wrap">
	
		<div class="left">
			<%@ include file="common/menubar.jsp" %>
		</div>
	
		<div class="right">
		    <h3>공지사항 작성</h3>
		    
			<form action="" method="post" class="notice-insert-area">
				<span>공지사항 제목</span><br>
				<input type="text" name="noticeTitle" placeholder="제목을 입력하세요" class="form-control" id="title-input">
				<br>
				<span>공지사항 내용</span><br>
				<textarea name="noticeContent" cols="60" rows="10" placeholder="내용을 입력해주세요" style="resize : none" class="form-control"></textarea>
				<br>
				<div class="notice-btn">
					<button type="button">돌아가기</button>
					<button tyle="submit">작성하기</button>
				</div>

			</form>

		</div>
		
	</div>
	<%} %>
</body>
</html>