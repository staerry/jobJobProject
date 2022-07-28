<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import="com.jj.community.model.vo.Reply, com.jj.common.model.vo.PageInfo, java.util.ArrayList" %>
    
<%
	PageInfo pageInfo = (PageInfo)request.getAttribute("pageInfo");
	ArrayList<Reply> list = (ArrayList<Reply>)request.getAttribute("Reply");
%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<link rel="stylesheet" href="${pageContext.request.contextPath}/resources/css/admin/admin-table-paging.css">
<link rel="stylesheet" href="${pageContext.request.contextPath}/resources/css/admin/mentor-post-management.css">
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
		    <h3>댓글 관리</h3>
		    
		    <table class="table table-bordered table-hover admin-table">
                <thead>
                    <tr>
                        <th width="60">번호</th>
                        <th>댓글</th>
                        <th width="300">댓글이 달린 게시글</th>
                        <th width="100">작성자</th>
                        <th width="100">등록일</th>
                        <th width="100">삭제</th>
                    </tr>
                </thead>
                <tbody>
                	<% for(Reply i : list){ %>
                    <tr>
                        <td><%= i.getReplyNo() %></td>
                        <td><%= i.getReplyContent() %></td>
                        <td><%= i.getCmNo() %></td>
                        <td><%= i.getUserNo() %></td>
                        <td><%= i.getReplyEnrolldate() %></td>
                        <td><button class="btn btn-sm btn-danger" onclick="location.href='<%= contextPath %>/deleteReply.ad?no=<%= i.getReplyNo() %>'">삭제</button></td>
                    </tr>
                    <% } %>
                </tbody>
            </table>

            <div class="paging-area">
            	<% if(pageInfo.getCurrentPage() != 1){ %>
                	<a href="<%= contextPath %>/replyListView.ad?cpage=<%= pageInfo.getCurrentPage()-1 %>">&lt</a>
                <% } %>
                <% for(int i = pageInfo.getStartPage(); i <= pageInfo.getEndPage(); i++){ %>
                	<% if(i == pageInfo.getCurrentPage()){ %>
                		<a href="<%= contextPath %>/replyListView.ad?cpage=<%= i %>" style="background-color : gray;"><%= i %></a>
                	<% } else { %>
                		<a href="<%= contextPath %>/replyListView.ad?cpage=<%= i %>"><%= i %></a>
                	<% } %>
				<% } %>
				<% if(pageInfo.getCurrentPage() != pageInfo.getMaxPage()){ %>
                	<a href="<%= contextPath %>/replyListView.ad?cpage=<%= pageInfo.getCurrentPage()+1 %>">&gt</a>
                <% } %>
            </div>
		</div>
		
	</div>
	<%} %>
</body>
</html>