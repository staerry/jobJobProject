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
	<%@ include file="common/topbar.jsp" %>
	
	<div class="content-wrap">
	    	<!--이 부분에 좌측메뉴 넣으세요-->
	    <div class="left">
			<%@ include file="common/menubar.jsp" %>
		</div>
	
		<!--이 부분은 우측 컨텐츠 입니다.-->
		<div class="right">
	        <h3>클래스 승인 정보</h3>

			<table class="admin-table">
					<tr>
						<th width="100">카테고리</th>
						<td>IT개발</td>
					</tr>
					<tr>
						<th>클래스 제목</th>
						<td>클래스 제목이 들어갈 자리</td>
					</tr>
					<tr>
						<th>커버 이미지</th>
						<td><img src="" alt="썸네일 이미지" height="200"></td>
					</tr>
					<tr>
						<th>클래스 소개</th>
						<td>클래스 소개가 들어갈 자리</td>
					</tr>
					<tr>
						<th>커리큘럼</th>
						<td>커리큘럼이 들어갈 자리</td>
					</tr>
					<tr>
						<th>수강료</th>
						<td>10000</td>
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
</body>
</html>