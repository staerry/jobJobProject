<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8" import="java.util.ArrayList, com.jj.community.model.vo.Community, com.jj.common.model.vo.PageInfo" %>
<%
	ArrayList<Community> list = (ArrayList<Community>)request.getAttribute("Community");
	PageInfo pageInfo = (PageInfo)request.getAttribute("pageInfo");
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
		    <h3>게시글 관리</h3>
		    
			<ul class="mentor-post-category">
				<li>
					<input type="radio" name="category" id="work" value="1">
		    		<label for="work">직무질문</label>
				</li>
				<li>
					<input type="radio" name="category" id="study" value="3">
		    		<label for="study">스터디</label>
				</li>
				<li>
					<input type="radio" name="category" id="worry" value="2">
		    		<label for="worry">고민상담</label>
				</li>
			</ul>
		    
		    <script>
		    	$(function(){
		    		$("#work").click(function(){
		    			$("#work").attr('checked', true);
		    			<% category = "1"; %>
		    			location.href='<%= contextPath %>/postListView.ad?cpage=1&no=<%= category %>';
		    		})
		    		
		    		$("#study").click(function(){
		    			$("#study").attr('checked', true);
		    			<% category = "3"; %>
		    			location.href='<%= contextPath %>/postListView.ad?cpage=1&no=<%= category %>';
		    		})
		    		
		    		$("#worry").click(function(){
		    			$("#worry").attr('checked', true);
		    			<% category = "2"; %>
		    			location.href='<%= contextPath %>/postListView.ad?cpage=1&no=<%= category %>';
		    		})
		    	})
		    </script>
		    
		    <table class="table table-bordered table-hover admin-table">
                <thead>
                    <tr>
                        <th width="60">번호</th>
                        <th>게시글 제목</th>
                        <th width="70">조회수</th>
                        <th width="100">작성자</th>
                        <th width="100">등록일</th>
                        <th width="100">삭제</th>
                    </tr>
                </thead>
                <tbody>
                	<% for(Community i : list){ %>
                    <tr>
                        <td><%= i.getCommNo() %></td>
                        <td><%= i.getCommTitle() %></td>
                        <td><%= i.getCount() %></td>
                        <td><%= i.getCommWriter() %></td>
                        <td><%= i.getCreateDate() %></td>
                        <td><button class="btn btn-sm btn-danger">삭제</button></td>
                    </tr>
                    <tr>
                    	<td colspan="6"><%= i.getCommContent() %></td>
                    </tr>
                    <% } %>
                </tbody>
            </table>

            <div class="paging-area">
            	<% if(pageInfo.getCurrentPage() != 1){ %>
                	<a href="<%= contextPath %>/postListView.ad?cpage=<%= pageInfo.getCurrentPage() - 1 %>&no=<%= category %>">&lt</a>
                <% } %>
                <% for(int i = pageInfo.getStartPage(); i <= pageInfo.getEndPage(); i++){ %>
                	<% if(pageInfo.getCurrentPage() == i){ %>
                		<a href="<%= contextPath %>/postListView.ad?cpage=<%= i %>&no=<%= category %>" style="background-color : gray;"><%= i %></a>
                	<% } else { %>
                		<a href="<%= contextPath %>/postListView.ad?cpage=<%= i %>&no=<%= category %>"><%= i %></a>
                	<% } %>
                <% } %>
                <% if(pageInfo.getCurrentPage() != pageInfo.getMaxPage()){ %>
                	<a href="<%= contextPath %>/postListView.ad?cpage=<%= pageInfo.getCurrentPage() + 1 %>&no=<%= category %>">&gt</a>
            	<% } %>
            </div>
		</div>
		
	</div>
	<%} %>
</body>
</html>