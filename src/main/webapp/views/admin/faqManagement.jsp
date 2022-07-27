<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import="com.jj.faq.model.vo.Faq, java.util.ArrayList, com.jj.common.model.vo.PageInfo" %>
    
<%
	PageInfo pageInfo = (PageInfo)request.getAttribute("pageInfo");
	ArrayList<Faq> list = (ArrayList<Faq>)request.getAttribute("faqList");
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
		    <h3>FAQ 관리</h3>
		    
		    <table class="table table-bordered table-hover admin-table">
                <thead>
                    <tr>
                        <th width="60">번호</th>
                        <th width="300">FAQ제목</th>
                        <th width="100">등록일</th>
                    </tr>
                </thead>
                <tbody>
                	<% if(list.isEmpty()){ %>
                		<tr>
	                        <td colspan="3">조회된 Faq가 없습니다.</td>
	                    </tr>
                	<% } else { %>
	                    <% for(Faq i : list){ %>
	                    <tr>
	                        <td><%= i.getFaqNo() %></td>
	                        <td><%= i.getFaqTitle() %></td>
	                        <td><%= i.getFaqEnrolldate() %></td>
	                    </tr>
	                    <% } %>
                	<% } %>
                </tbody>
            </table>
            
            <script>
            	$(function(){
            		$(".admin-table tr").click(function(){
            			location.href='sdsdsd';
            		})
            	})
            </script>

            <div class="paging-area">
            	<% if(pageInfo.getCurrentPage() != 1){ %>
                	<a href="<%= contextPath %>/faqListView.ad?cpage=<%= pageInfo.getCurrentPage()-1 %>">&lt</a>
                <% } %>
                
                <% for (int i = pageInfo.getStartPage(); i <= pageInfo.getEndPage(); i++){ %>
                	<a href="<%= contextPath %>/faqListView.ad?cpage=<%= i %>"><%= i %></a>
                <% } %>
                
                <% if(pageInfo.getCurrentPage() != pageInfo.getMaxPage()){ %>
                <a href="<%= contextPath %>/faqListView.ad?cpage=<%= pageInfo.getCurrentPage()+1 %>">&gt</a>
            	<% } %>
            </div>
            
            <div class="table-bottom-btn" style="float : right">
            	<button type="button" onclick="location.href='<%= contextPath %>/faqInsert.ad'">작성하기</button>
            </div>

		</div>
		
	</div>
	
	<%} %>
</body>
</html>