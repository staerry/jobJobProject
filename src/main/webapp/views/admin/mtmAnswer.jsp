<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<link rel="stylesheet" href="${pageContext.request.contextPath}/resources/css/admin/mentor-regist-info.css">
<link rel="stylesheet" href="${pageContext.request.contextPath}/resources/css/admin/mtmAnswer.css">
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
	    	<!--이 부분에 좌측메뉴 넣으세요-->
	    <div class="left">
			<%@ include file="common/menubar.jsp" %>
		</div>
	
		<!--이 부분은 우측 컨텐츠 입니다.-->
		<div class="right">
	        <h3>1대1 문의 답변</h3>

			<table class="admin-table">
					<tr>
						<th width="150">1대1 문의 내용</th>
					</tr>
					<tr>
						<td><textarea id="user-mtm-content" readonly>사용자 문의 내용</textarea></td>
					</tr>
					<tr>
						<th>답변 작성</th>
					</tr>
					<tr>
						<td><textarea></textarea></td>
					</tr>
			</table>

			<div class="mtm-controller-btn">
					<button type="button">돌아가기</button>
					<button type="button">답변전송</button>
			</div>
	    </div>
	</div>
	<%} %>
</body>
</html>