<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8" import="java.util.ArrayList, com.jj.classSelect.model.vo.Class, com.jj.common.model.vo.PageInfo"%>
    
<%
	PageInfo pageInfo = (PageInfo)request.getAttribute("pageInfo");
	ArrayList<Class> list = (ArrayList<Class>)request.getAttribute("Class");
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
		    <h3>클래스 관리</h3>
		    
		    <table class="table table-bordered table-hover admin-table">
                <thead>
                    <tr>
                        <th width="30">번호</th>
                        <th width="400">클래스명</th>
                        <th width="100">카테고리</th>
                        <th width="60">강사명</th>
                        <th width="30">삭제</th>
                    </tr>
                </thead>
                <tbody>
                	<% if(list.isEmpty()){ %>
	                	<tr>
		                    <td colspan="5">조회된 클래스가 없습니다.</td>
		                </tr>
                	<% } else { %>          	
	                	<% for(Class i : list){ %>
		                    <tr>
		                        <td><%= i.getClNo() %></td>
		                        <td onclick="selectClass(<%= i.getClNo() %>);"><%= i.getClTitle() %></td>
		                        <td><%= i.getClCategory() %></td>
		                        <td><%= i.getUserNo() %></td>
		                        <td>
		                        	<button class="btn btn-sm btn-danger" onclick="deleteContent(<%= i.getClNo() %>);">삭제</button>
			                        <script>
									    function deleteContent(num){
									        if(confirm("정말 삭제 하시겠습니끼?")){
									            location.href='<%= contextPath %>/deleteClass.ad?no=' + num;
									        }
									    }
									    
									    function selectClass(num){
									    	location.href="<%= contextPath %>/detail.cl?class=" + num;
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
                	<a href="<%= contextPath %>/mentorClassListView.ad?cpage=<%= pageInfo.getCurrentPage() - 1 %>">&lt</a>
                <% } %>
                <% for(int i = pageInfo.getStartPage(); i <= pageInfo.getEndPage(); i++){ %>
                	<% if(i == pageInfo.getCurrentPage()){ %>
                		<a href="<%= contextPath %>/mentorClassListView.ad?cpage=<%= i %>" style="background-color : gray;"><%= i %></a>
                	<% } else { %>
                		<a href="<%= contextPath %>/mentorClassListView.ad?cpage=<%= i %>"><%= i %></a>
                	<% } %>
                <% } %>
                <% if(pageInfo.getCurrentPage() != pageInfo.getMaxPage()){ %>
                	<a href="<%= contextPath %>/mentorClassListView.ad?cpage=<%= pageInfo.getCurrentPage() + 1 %>">&gt</a>
                <% } %>
            </div>
		</div>
	</div>
	<%} %>
</body>
</html>