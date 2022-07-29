<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8" import="com.jj.mtm.model.vo.Mtm"%>
    
<%
	Mtm mtm = (Mtm)request.getAttribute("mtm");
%>
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
		    <div class="left">
				<%@ include file="common/menubar.jsp" %>
			</div>
		
			<div class="right">
		        <h3>1대1 문의 답변</h3>
		        
				<form action="mtmAnswer.ad" method="post">
					<input type="hidden" value="<%= mtm.getMtmNo() %>" name="mtmNo">
					
					<table class="admin-table">
						<tr>
							<th width="150">문의 제목</th>
						</tr>
						<tr>
							<td><input type="text" style="width : 480px;" id="user-mtm-content" class="form-control" value="<%= mtm.getMtmTitle() %>" readonly></td>
						</tr>
						<tr>
							<th width="150">문의 내용</th>
						</tr>
						<tr>
							<td><textarea id="user-mtm-content" class="form-control" rows="7" readonly><%= mtm.getMtmContent() %></textarea></td>
						</tr>
						<tr>
							<th>답변 작성</th>
						</tr>
						<tr>
							<td><textarea class="form-control" rows="7" name="mtmAnswer"></textarea></td>
						</tr>
					</table>
		
					<div class="mtm-controller-btn">
						<button type="button" onclick="history.back();">돌아가기</button>
						<button type="submit">답변전송</button>
					</div>
				</form>
		    </div>
		</div>
	<%} %>
</body>
</html>