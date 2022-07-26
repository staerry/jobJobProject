<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<link rel="stylesheet" href="${pageContext.request.contextPath}/resources/css/admin/mentor-regist-info.css">
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
	        <h3>강의 등록 정보</h3>

			<table class="admin-table">
					<tr>
						<th width="150">강의 제목</th>
						<td>강의 영상 제목 입니다.</td>
					</tr>
					<tr>
						<th>강의 영상 첨부파일</th>
						<td>영상 첨부파일이 들어갈 자리</td>
					</tr>
			</table>

			<div class="mentoRegistInfo-controller-btn">
				<div class="left-controller">
					<button type="button">승인</button>
					<button type="button">거절</button>
				</div>
				<div class="right-controller">
					<button type="button">돌아가기</button>
				</div>
			</div>
	    </div>
	</div>
	<%} %>
</body>
</html>