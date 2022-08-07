<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import="java.util.ArrayList, com.jj.notice.model.vo.Notice, com.jj.common.model.vo.PageInfo" %>
<%
	ArrayList<Notice> list = (ArrayList<Notice>)request.getAttribute("notice");
	PageInfo pageInfo = (PageInfo)request.getAttribute("pageInfo");
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
			    <h3>공지사항 관리</h3>
			    
			    <table class="table table-bordered table-hover admin-table">
	                <thead>
		                <tr>
		                    <th width="60">번호</th>
		                    <th width="300">공지사항제목</th>
		                    <th width="100">등록일</th>
		                    <th width="30">삭제/수정</th>
		                </tr> 
	                </thead>
	                <tbody>
	                	<% if(list.isEmpty()){ %>
		                	<tr>
			                    <td colspan="4">조회된 공지사항이 없습니다.</td>
			                </tr>
	                	<% } else { %>
		                	<% for(Notice i : list){ %>
			                    <tr>
			                        <td><%= i.getNoticeNo() %></td>
			                        <td class="notice-title"><%= i.getNoticeTitle() %></td>
			                        <td><%= i.getNoticeEnrolldate() %></td>
			                        <td>
			                        	<button class="btn btn-sm btn-warning" onclick="location.href='<%= contextPath %>/noticeModifyView.ad?no=<%= i.getNoticeNo() %>'">수정</button>            	
			                        	<button class="btn btn-sm btn-danger" onclick="deleteContent(<%= i.getNoticeNo() %>);">삭제</button>
			                        
			                        	<script>
									        function deleteContent(num){
									            if(confirm("정말 삭제 하시겠습니까?")){
									            	location.href='<%= contextPath %>/noticeDelete.ad?no=' + num;
									            }
									        }
				                    	</script> 
			                        </td>
			                    </tr>
			                    <tr style="display : none; background-color : rgb(244, 244, 244);" class="notice-content">
			                    	<td colspan="4">
			                    		<%= i.getNoticeContent() %>
			                    	</td>
			                    </tr>
		                    <% } %> 	
	                	<% } %>
	                </tbody>
	            </table>
	            
	            <script>
		            $(function(){
		                $(".notice-title").click(function(){
		                	if($(this).parent().next().css("display") == "none"){
		                		$(this).parent().next().css('display', '');
		                	}else{
		                		$(this).parent().next().css('display', 'none');
		                	}
		                })
		            })
	            </script>
	
	            <div class="paging-area">
	            	<% if(pageInfo.getCurrentPage() != 1){ %>
	                	<a href="<%= contextPath %>/noticeListView.ad?cpage=<%= pageInfo.getCurrentPage()-1 %>">&lt</a>
	                <% } %>
	                <% for(int i = pageInfo.getStartPage(); i <= pageInfo.getEndPage(); i++){ %>
	                	<% if(i == pageInfo.getCurrentPage()){ %>
	                		<a href="<%= contextPath %>/noticeListView.ad?cpage=<%= i %>" style="background-color : gray;"><%= i %></a>
	                	<% }else{ %>
	                		<a href="<%= contextPath %>/noticeListView.ad?cpage=<%= i %>"><%= i %></a>
	                	<% } %>
	                <% } %>
	                <% if(pageInfo.getCurrentPage() != pageInfo.getMaxPage()){ %>
	                <a href="<%= contextPath %>/noticeListView.ad?cpage=<%= pageInfo.getCurrentPage()+1 %>">&gt</a>
	 				<% } %>
	            </div>
	            
	            <div class="table-bottom-btn" style="float : right">
	            	<button type="button" onclick="location.href='<%= contextPath %>/noticeInsert.ad'">작성하기</button>
	            </div>
			</div>
		</div>
	<%} %>
</body>
</html>