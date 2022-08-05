<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8" import="com.jj.member.model.vo.MentorApproval"%>
    
<%
	MentorApproval mentorApproval = (MentorApproval)request.getAttribute("mentorApproval");
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
	    <div class="left">
			<%@ include file="common/menubar.jsp" %>
		</div>
	
		<div class="right">
	        <h3>멘토 가입 정보</h3>

			<table class="admin-table">
					<tr>
						<th width="80">이름</th>
						<td><%= mentorApproval.getUserName() %></td>
					</tr>
					<tr>
						<th>전화번호</th>
						<td><%= mentorApproval.getUserPhone() %></td>
					</tr>
					<tr>
						<th>소속회사</th>
						<td><%= mentorApproval.getMtCompany() %></td>
					</tr>
					<tr>
						<th>직무</th>
						<td><%= mentorApproval.getMtJob() %></td>
					</tr>
					<tr>
						<th>이메일</th>
						<td><%= mentorApproval.getUserEmail() %></td>
					</tr>
					<tr>
						<th>분야</th>
						<td><%= mentorApproval.getClcgNo() %></td>
					</tr>
					<tr>
						<th>신분증</th>
						<td>
							<img src="<%= contextPath %>/<%= mentorApproval.getIdCardPath() %>" alt="신분증 이미지" width="200">
						</td>
					</tr>
					<tr>
						<th>&nbsp</th>
					</tr>	
					<tr>
						<th>사원증</th>
						<td>
							<img src="<%= contextPath %>/<%= mentorApproval.getEmpCardPath() %>" alt="사원증 이미지" width="200">
						</td>
					</tr>
			</table>

			<div class="mentoRegistInfo-controller-btn">
				<div class="left-controller">
					<button type="button" onclick="approval(1);">승인</button>
					<button type="button" onclick="approval(2)">거절</button>
				</div>
				
				<div class="right-controller">
					<button type="button" onclick="history.back();">돌아가기</button>
				</div>
			</div>
			
			<script>
				function approval(answer){
					if(answer == 1){
						if(confirm("승인 하시겠습니까?")){
							location.href='<%= contextPath %>/mentorApproval.ad?no=<%= mentorApproval.getUserNo() %>';
						}
					}else {
						if(confirm("거절 하시겠습니까?")){
							location.href='<%= contextPath %>/mentorApprovalFusal.ad?no=<%= mentorApproval.getUserNo() %>';
						}
					}
				}
			</script>
			
	    </div>
	</div>
	<%} %>
</body>
</html>