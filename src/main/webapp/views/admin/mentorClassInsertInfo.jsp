<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8" import="com.jj.classSelect.model.vo.Class" %>
    
<%
	Class classInfo = (Class)request.getAttribute("class");
    int userNo = (int)request.getAttribute("userno");
%>
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
	        <h3>클래스 승인 정보</h3>

			<table class="admin-table">
					<tr>
						<th width="100">카테고리</th>
						<td><%= classInfo.getClCategory() %></td>
					</tr>
					<tr>
						<th>클래스 제목</th>
						<td><%= classInfo.getClTitle() %></td>
					</tr>
					<tr>
						<th>커버 이미지</th>
						<td><img src="<%= contextPath %>/<%= classInfo.getClThumbnailPath() %>" alt="썸네일 이미지" height="200"></td>
					</tr>
					<tr>
						<th>클래스 소개</th>
						<td><%= classInfo.getClInfo() %></td>
					</tr>
					<tr>
						<th>커리큘럼</th>
						<td><%= classInfo.getClCurri() %></td>
					</tr>
					<tr>
						<th>수강료</th>
						<td><%= classInfo.getClPrice() %>원</td>
					</tr>
			</table>

			<div class="mentoRegistInfo-controller-btn">
				<div class="left-controller">
					<button type="button" onclick="approval(1)">승인</button>
					<button type="button" onclick="approval(2)">거절</button>
				</div>

				<script>
					function approval(answer){
						if(answer == 1){
							if(confirm("승인 하시겠습니까?")){
								location.href='<%= contextPath %>/classApproval.ad?userno=<%= userNo %>&no=<%= classInfo.getClNo() %>';
							}
						}else{
							if(confirm("거절 하시겠습니까?")){
								location.href='<%= contextPath %>/classApprovalFusal.ad?no=<%= classInfo.getClNo() %>';
							}
						}
					}
				</script>
				
				<div class="right-controller">
					<button type="button" onclick="history.back();">돌아가기</button>
				</div>
			</div>
	    </div>
	</div>
	<%} %>
</body>
</html>