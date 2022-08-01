<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8" import="com.jj.faq.model.vo.Faq" %>
    
<%
	Faq faq = (Faq)request.getAttribute("faq");
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
			    <h3>FAQ</h3>
			    
				<form action="faqModify.ad" method="post" class="notice-insert-area">
					<span>FAQ 제목</span><br>
					
					<input type="hidden" name="faqNo" value="<%= faq.getFaqNo() %>">
					<input type="text" name="faqTitle" class="form-control" id="title-input" value="<%= faq.getFaqTitle() %>">
					
					<br>
					
					<span>FAQ 내용</span>
					
					<br>
					
					<textarea name="faqAnswer" cols="60" rows="10" style="resize : none" class="form-control"><%= faq.getFaqAnswer() %></textarea>
					
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