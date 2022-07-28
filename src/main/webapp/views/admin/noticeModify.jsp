<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8" import="com.jj.notice.model.vo.Notice" %>
    
<%
	Notice notice = (Notice)request.getAttribute("notice");
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
		    <h3>공지사항 수정</h3>
		    
			<form action="noticeModify.ad" method="post" class="notice-insert-area">
				<span>공지사항 제목</span><br>
				<input type="hidden" name="noticeNo" value="<%= notice.getNoticeNo() %>">
				<input type="text" name="noticeTitle" class="form-control" id="title-input" value="<%= notice.getNoticeTitle() %>">
				<br>
				<span>공지사항 내용</span><br>
				<textarea name="noticeContent" cols="60" rows="10" style="resize : none" class="form-control"><%= notice.getNoticeContent() %></textarea>
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