<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8" import="com.jj.member.model.vo.SlideAttachment" %>
    
<%
	SlideAttachment slide = (SlideAttachment)request.getAttribute("SlideAttachment");
%>
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
			    <h3>슬라이드 이미지 수정</h3>
			    
				<form action="modifySlide.ad" method="post" class="notice-insert-area" enctype="multipart/form-data">
					<span>기존 업로드 파일</span><br>
					<% if(slide != null){ %>
						<a download="<%= slide.getFileName() %>" href="<%= slide.getFilePath() %><%= slide.getFileName() %>"><%= slide.getFileName() %></a>
					<% } else { %>
						첨부파일이 없습니다.
					<% } %>
					<br>
					<br>
					<span>새로운 업로드 파일</span><br>
					<input type="hidden" value="<%= slide.getFileNo() %>" name="fileNo">
					<input type="file" name="fileName" class="form-control" id="title-input">
					<br>
					<div class="notice-btn">
						<button type="button" onclick="history.back();">돌아가기</button>
						<button type="submit">수정하기</button>
					</div>
				</form>
			</div>
		</div>
	<%} %>
</body>
</html>