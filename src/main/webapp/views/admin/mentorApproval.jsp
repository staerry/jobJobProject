<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8" import="java.util.ArrayList, com.jj.common.model.vo.PageInfo, com.jj.member.model.vo.MentorApproval"%>
    
<%
	PageInfo pageInfo = (PageInfo)request.getAttribute("pageInfo");
	ArrayList<MentorApproval> list = (ArrayList<MentorApproval>)request.getAttribute("mentorApproval");
%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<link rel="stylesheet" href="${pageContext.request.contextPath}/resources/css/admin/admin-table-paging.css">
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
			    <h3>멘토 가입 승인</h3>
			    
			    <table class="table table-bordered table-hover admin-table">
	                <thead>
	                    <tr>
	                        <th width="60">번호</th>
	                        <th width="100">이름</th>
	                        <th width="150">전화번호</th>
	                        <th width="200">소속회사</th>
	                        <th width="100">직급</th>
	                        <th width="150">이메일</th>
	                    </tr>
	                </thead>
	                <tbody>
	                	<% for(MentorApproval i : list){ %>
		                    <tr>
		                        <td><%= i.getUserNo() %></td>
		                        <td><%= i.getUserName() %></td>
		                        <td><%= i.getUserPhone() %></td>
		                        <td><%= i.getMtCompany() %></td>
		                        <td><%= i.getMtJob() %></td>
		                        <td><%= i.getUserEmail() %></td>
		                    </tr>
	                     <% } %>
	                </tbody>
	            </table>
	            
	            <script>
	            	$(function(){
	            		$(".admin-table > tbody > tr").click(function(){
	            			location.href='<%= contextPath %>/mentorRegistInfoView.ad?no=' + $(this).children().eq(0).text();
	            		})
	            	})
	            </script>
	
	            <div class="paging-area">
	            	<% if(pageInfo.getCurrentPage() != 1){ %>
	                	<a href="<%= contextPath %>/mentorApprovalListView.ad?cpage=<%= pageInfo.getCurrentPage() - 1 %>">&lt</a>
	                <% } %>
	                <% for(int i = pageInfo.getStartPage(); i <= pageInfo.getEndPage(); i++){ %>
	                	<% if(pageInfo.getCurrentPage() == i){ %>
	                		<a href="<%= contextPath %>/mentorApprovalListView.ad?cpage=<%= i %>" style="background-color : gray;"><%= i %></a>
	                	<% } else { %>
	                		<a href="<%= contextPath %>/mentorApprovalListView.ad?cpage=<%= i %>"><%= i %></a>
	                	<% } %>
	                <% } %>
	                <% if(pageInfo.getCurrentPage() != pageInfo.getMaxPage()){ %>
	                	<a href="<%= contextPath %>/mentorApprovalListView.ad?cpage=<%= pageInfo.getCurrentPage() + 1 %>">&gt</a>
	                <% } %>
	            </div>
			</div>
		</div>
	<%} %>
</body>
</html>