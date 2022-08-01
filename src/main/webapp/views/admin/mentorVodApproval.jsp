<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8" import="java.util.ArrayList, com.jj.common.model.vo.PageInfo, com.jj.classSelect.model.vo.Vod" %>
    
<%
	PageInfo pageInfo = (PageInfo)request.getAttribute("pageInfo");
	ArrayList<Vod> list = (ArrayList<Vod>)request.getAttribute("vod");
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
		    <h3>멘토 강의 등록 승인</h3>
		    
		    <table class="table table-bordered table-hover admin-table">
                <thead>
                    <tr>
                        <th width="60">번호</th>
                        <th width="200">클래스명</th>
                        <th width="200">강의명</th>
                        <th width="60">강사명</th>
                    </tr>
                </thead>
                <tbody>
                	<% if(list.isEmpty()){ %>
	                	<tr>
		                    <td colspan="4">조회된 요청이 없습니다.</td>
		                </tr>
                	<% } else { %>            	
	                	<% for(Vod i : list){ %>
		                    <tr>
		                        <td><%= i.getVodNo() %></td>
		                        <td><%= i.getClNo() %></td>
		                        <td><%= i.getVodTitle() %></td>
		                        <td><%= i.getMentorName() %></td>
		                    </tr>
	                    <% } %>
                	<% } %>
                </tbody>
            </table>

			<script>
				$(function(){
					$(".admin-table > tbody > tr").click(function(){
						location.href='<%= contextPath %>/mentorVodApprovalInfoView.ad?no=' + $(this).children().eq(0).text();
					})
				})
			</script>
			
            <div class="paging-area">
            	<% if(pageInfo.getCurrentPage() != 1){ %>
                	<a href="<%= contextPath %>/<%= contextPath %>/mentorVodApprovalListView.ad?cpage=<%= pageInfo.getCurrentPage() - 1 %>">&lt</a>
                <% } %>
                
                <% for(int i = pageInfo.getStartPage(); i <= pageInfo.getEndPage(); i++){ %>
               		<% if(pageInfo.getCurrentPage() == i){ %> 	
                		<a href="<%= contextPath %>/mentorVodApprovalListView.ad?cpage=<%= i %>" style="background-color : gray;"><%= i %></a>
               		<% } else { %>
                		<a href="<%= contextPath %>/mentorVodApprovalListView.ad?cpage=<%= i %>"><%= i %></a>
                	<% } %>
                <% } %>
                
                <% if(pageInfo.getCurrentPage() != pageInfo.getMaxPage()){ %>
                	<a href="<%= contextPath %>/<%= contextPath %>/mentorVodApprovalListView.ad?cpage=<%= pageInfo.getCurrentPage() - 1 %>">&gt</a>
                <% } %>
            </div>
		</div>
	</div>
	<% } %>
</body>
</html>