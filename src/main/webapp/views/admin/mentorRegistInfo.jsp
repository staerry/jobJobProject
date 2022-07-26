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
	        <h3>멘토 가입 정보</h3>

			<table class="admin-table">
					<tr>
						<th width="80">이름</th>
						<td>김개똥깨</td>
					</tr>
					<tr>
						<th>전화번호</th>
						<td>000-0000-0000</td>
					</tr>
					<tr>
						<th>소속회사</th>
						<td>구디아카데미</td>
					</tr>
					<tr>
						<th>직급</th>
						<td>사장님</td>
					</tr>
					<tr>
						<th>이메일</th>
						<td>gdgdgd@gmail.com</td>
					</tr>
					<tr>
						<th>분야</th>
						<td>IT개발</td>
					</tr>
					<tr>
						<th>신분증</th>
						<td>
							<img src="" alt="신분증 이미지" height="200">
						</td>
					</tr>
					<tr>
						<th>사원증</th>
						<td>
							<img src="" alt="사원증 이미지" height="200">
						</td>
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