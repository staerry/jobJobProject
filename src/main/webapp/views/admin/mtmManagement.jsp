<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import="java.util.ArrayList, com.jj.common.model.vo.PageInfo, com.jj.mtm.model.vo.Mtm" %>
    
<%
	PageInfo pageInfo = (PageInfo)request.getAttribute("pageInfo");
	ArrayList<Mtm> list = (ArrayList<Mtm>)request.getAttribute("Mtm");
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
			    <h3>1대1 문의 관리</h3>
			    
			    <table class="table table-bordered table-hover admin-table">
	                <thead>
	                    <tr>
	                        <th width="60">번호</th>
	                        <th width="300">1대1문의 제목</th>
	                        <th width="100">작성자</th>
	                        <th width="100">등록일</th>
	                    </tr>
	                </thead>
	                <tbody>
	                	<% for(Mtm i : list){ %>
		                    <tr>
		                        <td><%= i.getMtmNo() %></td>
		                        <td><%= i.getMtmTitle() %></td>
		                        <td><%= i.getUserNo() %></td>
		                        <td><%= i.getMtmEnrolldate() %></td>
		                    </tr>
	                    <% } %>
	                </tbody>
	            </table>
	
				<script>
					$(function(){
						$(".admin-table tr").click(function(){
							location.href='<%= contextPath %>/mtmAnswerForm.ad?no=' + $(this).children().eq(0).text();
						})
					})
				</script>
	
	            <div class="paging-area">
	            	<% if(pageInfo.getCurrentPage() != 1){ %>
	                	<a href="<%= contextPath %>/mtmListView.ad?cpage=<%= pageInfo.getCurrentPage() - 1 %>">&lt</a>
	                <% } %>
					<% for(int i = pageInfo.getStartPage(); i <= pageInfo.getEndPage(); i++){ %>
						<% if(i == pageInfo.getCurrentPage()){ %>
	                		<a href="<%= contextPath %>/mtmListView.ad?cpage=<%= i %>" style="background-color : gray;"><%= i %></a>
						<% } else { %>
							<a href="<%= contextPath %>/mtmListView.ad?cpage=<%= i %>"><%= i %></a>
						<% } %>
					<% } %>
					<% if(pageInfo.getCurrentPage() != pageInfo.getMaxPage()){ %>
	                	<a href="<%= contextPath %>/mtmListView.ad?cpage=<%= pageInfo.getCurrentPage() + 1 %>">&gt</a>
	                <% } %>
	            </div>
			</div>
		</div>
	<%} %>
</body>
</html>