<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8" import="java.util.ArrayList, com.jj.community.model.vo.Community, com.jj.common.model.vo.PageInfo" %>
<%
	ArrayList<Community> list = (ArrayList<Community>)request.getAttribute("worry");
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
					<input type="radio" name="category" id="worry" value="2" checked>
		    		<label for="worry">고민상담</label>
				</li>
			</ul>
		    
		    <script>
				$(function(){
					$("#work").click(function(){
						location.href='<%= contextPath %>/postWorkListView.ad?cpage=1';
					})
					
					$("#study").click(function(){
						location.href='<%= contextPath %>/postStudyListView.ad?cpage=1';
					})
					
					$("#worry").click(function(){
						location.href='<%= contextPath %>/postWorryListView.ad?cpage=1';
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
                	<% if(list.isEmpty()){ %>
	                	<tr>
		                    <td colspan="6">조회된 게시글이 없습니다.</td>
		                </tr>
                	<% } else { %>
	                	<% for(Community i : list){ %>
	                    <tr>
	                        <td><%= i.getCommNo() %></td>
	                        <td class="title"><%= i.getCommTitle() %></td>
	                        <td><%= i.getCount() %></td>
	                        <td><%= i.getCommWriter() %></td>
	                        <td><%= i.getCreateDate() %></td>
	                        <td>
		                        <button class="btn btn-sm btn-danger" onclick="deleteContent(<%= i.getCommNo() %>);">삭제</button>
		                        
		                        <script>
								    function deleteContent(num){
								        if(confirm("정말 삭제 하시겠습니끼?")){
								            location.href='<%= contextPath %>/deletePost.ad?no=' + num + '&category=2';
								        }
								    }
			                    </script>
	                        </td>
	                    </tr>
	                    <tr style="display : none; background-color : rgb(244, 244, 244);">
	                    	<td colspan="6"><%= i.getCommContent() %></td>
	                    </tr>
	                    <% } %>         	
                	<% } %>
                </tbody>
            </table>
            
            <script>
            	$(function(){
            		$(".title").click(function(){
            			if($(this).parent().next().css("display") == "none"){
            				$(this).parent().next().css("display", "");
            			}else{
            				$(this).parent().next().css("display", "none");
            			}
            		})
            	})
            </script>

            <div class="paging-area">
            	<% if(pageInfo.getCurrentPage() != 1){ %>
                	<a href="<%= contextPath %>/postWorryListView.ad?cpage=<%= pageInfo.getCurrentPage() - 1 %>">&lt</a>
                <% } %>
                <% for(int i = pageInfo.getStartPage(); i <= pageInfo.getEndPage(); i++){ %>
                	<% if(pageInfo.getCurrentPage() == i){ %>
                		<a href="<%= contextPath %>/postWorryListView.ad?cpage=<%= i %>" style="background-color : gray;"><%= i %></a>
                	<% } else { %>
                		<a href="<%= contextPath %>/postWorryListView.ad?cpage=<%= i %>"><%= i %></a>
                	<% } %>
                <% } %>
                <% if(pageInfo.getCurrentPage() != pageInfo.getMaxPage()){ %>
                	<a href="<%= contextPath %>/postWorryListView.ad?cpage=<%= pageInfo.getCurrentPage() + 1 %>">&gt</a>
            	<% } %>
            </div>
		</div>
	</div>
	<%} %>
</body>
</html>