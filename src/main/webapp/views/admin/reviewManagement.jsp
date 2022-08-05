<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import="com.jj.community.model.vo.Review, com.jj.common.model.vo.PageInfo, java.util.ArrayList" %>
    
<%
	PageInfo pageInfo = (PageInfo)request.getAttribute("pageInfo");
	ArrayList<Review> list = (ArrayList<Review>)request.getAttribute("Review");
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
			    <h3>수강후기 관리</h3>
			    
			    <ul class="mentor-post-category">
					<li>
						<input type="radio" name="category" id="reply" value="reply">
			    		<label for="reply">댓글</label>
					</li>
					<li>
						<input type="radio" name="category" id="review" value="review" checked>
			    		<label for="review">수강후기</label>
					</li>
				</ul>
				
				<script>
					$(function(){
						$("#reply").click(function(){
							location.href='<%= contextPath %>/replyListView.ad?cpage=1';
						})
						
						$("#review").click(function(){
							location.href='<%= contextPath %>/reviewListView.ad?cpage=1';
						})
					})
				</script>
			    
			    <table class="table table-bordered table-hover admin-table">
	                <thead>
	                    <tr>
	                        <th width="60">번호</th>
	                        <th>수강후기</th>
	                        <th width="300">수강후기가 달린 게시글</th>
	                        <th width="60">평점</th>
	                        <th width="100">작성자</th>
	                        <th width="100">등록일</th>
	                        <th width="100">삭제</th>
	                    </tr>
	                </thead>
	                <tbody>
	                	<% if(list.isEmpty()){ %>
		                	<tr>
			                    <td colspan="7">조회된 리뷰가 없습니다.</td>
			                </tr>
	                	<% } else { %>
		                	<% for(Review i : list){ %>
		                    <tr>
		                        <td><%= i.getReviewNo() %></td>
		                        <td><%= i.getReviewContent() %></td>
		                        <td><%= i.getClNo() %></td>
		                        <td><%= i.getReviewScore() %></td>
		                        <td><%= i.getUserNo() %></td>
		                        <td><%= i.getReviewEnrolldate() %></td>
		                        <td>
		                        	<button class="btn btn-sm btn-danger" onclick="deleteContent(<%= i.getReviewNo() %>);">삭제</button>
		                        
		                        	<script>
								        function deleteContent(num){
								            if(confirm("정말 삭제 하시겠습니끼?")){
								            	location.href='<%= contextPath %>/deleteReview.ad?no=' + num;
								            }
								        }
			                    	</script>              
		                        </td>
		                    </tr>
		                    <% } %>	
	                	<% } %>
	                </tbody>
	            </table>
	
	            <div class="paging-area">
	            	<% if(pageInfo.getCurrentPage() != 1){ %>
	                	<a href="<%= contextPath %>/reviewListView.ad?cpage=<%= pageInfo.getCurrentPage()-1 %>">&lt</a>
	                <% } %>
	                <% if(pageInfo.getCurrentPage() > 5){ %>
	                	<a href="<%= contextPath %>/reviewListView.ad?cpage=1">1</a><span>&nbsp;···&nbsp;</span>
	                <% } %>
	                <% for(int i = pageInfo.getStartPage(); i <= pageInfo.getEndPage(); i++){ %>
	                	<% if(i == pageInfo.getCurrentPage()){ %>
	                		<a href="<%= contextPath %>/reviewListView.ad?cpage=<%= i %>" style="background-color : gray;"><%= i %></a>
	                	<% } else { %>
	                		<a href="<%= contextPath %>/reviewListView.ad?cpage=<%= i %>"><%= i %></a>
	                	<% } %>
					<% } %>
					<% if(pageInfo.getCurrentPage() != pageInfo.getMaxPage()){ %>
		                <% if(pageInfo.getMaxPage() > 5){ %>
			                <span>&nbsp;···&nbsp;</span><a href="<%= contextPath %>/reviewListView.ad?cpage=<%= pageInfo.getMaxPage() %>"><%= pageInfo.getMaxPage() %></a>                
		                <% } %>
	                	<a href="<%= contextPath %>/reviewListView.ad?cpage=<%= pageInfo.getCurrentPage()+1 %>">&gt</a>
	                <% } %>
	            </div>
			</div>
		</div>
	<%} %>
</body>
</html>