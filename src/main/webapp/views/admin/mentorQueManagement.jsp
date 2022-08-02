<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8" import="java.util.ArrayList, com.jj.mentorSelect.model.vo.MtQuestion, com.jj.common.model.vo.PageInfo" %>
<%
	PageInfo pageInfo = (PageInfo)request.getAttribute("pageInfo");
	ArrayList<MtQuestion> list = (ArrayList<MtQuestion>)request.getAttribute("MtQuestion");
%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<link rel="stylesheet" href="${pageContext.request.contextPath}/resources/css/admin/admin-table-paging.css">
<title>Insert title here</title>
<style>
	*{
		padding : 0;
		margin : 0;
		boxsizing : border-box;
	}
	.que-content{
		width : 1000px;
		margin : auto;
		text-align : left;
		padding : 10px 50px 10px 50px;
		border : 1px solid lightgray;
		background-color : #ececec;
	}
	
	.que-content span {
		font-weight : bold;
		color : #666;
		font-size : 14px;
	}
	
	.que-content .date {
		font-weight : bold;
		color : #666;
		font-size : 12px;
	}
	
	.que-content pre {
		font-size : 14px;
	}
</style>
</head>

<body>
	<%if(session.getAttribute("UserInfoAd") == null){ %>
		<script>
			alert("유효하지않은 접근입니다.");
			location.href="<%= request.getContextPath() %>/login.ad";
		</script>
	<% }else{ %>
	
	<%@ include file="common/topbar.jsp" %>
	
	<div class="content-wrap">
		<div class="left">
			<%@ include file="common/menubar.jsp" %>
		</div>
	
		<div class="right">
		    <h3>멘토 질문/답변 관리</h3>
		    
		    <table class="table table-bordered table-hover admin-table">
                <thead>
                    <tr>
                        <th width="30">번호</th>
                        <th width="400">질문제목</th>
                        <th width="100">작성자</th>
                        <th width="100">멘토명</th>
                        <th width="60">좋아요</th>
                        <th width="100">작성일</th>
                        <th width="60">삭제</th>
                    </tr>
                </thead>
                <tbody>
                	<% if(list.isEmpty()){ %>
						<tr>
							<td>조회된 질문이 없습니다.</td>
						</tr>
                	<%} else { %>
                		<% for(MtQuestion i : list){ %>
							<tr>
								<td><%= i.getMtQueNo() %></td>
								<td><%= i.getQueTitle() %></td>
								<td><%= i.getQueWriterName() %></td>
								<td><%= i.getAnsWriterName() %></td>
								<td><%= i.getQueLike() %></td>
								<td><%= i.getQueEnrolldate() %></td>
								<td>
									<button class="btn btn-sm btn-danger" onclick="deleteQue(<%= i.getMtQueNo() %>);">삭제</button>
									
									<script>
										function deleteQue(num){
											if(confirm("정말 삭제 하시겠습니까?")){
												location.href="<%= contextPath %>/deleteQue.ad?no=" + num;
											}
										}
									</script>
								</td>
							</tr>
							<tr class="answer" style="display : none">
								<td colspan="7">
									<div class="que-content">
										<span>질문 내용</span>
										<br>
										<pre><%= i.getQueContent() %></pre>
										<br>
										<span>답변 내용</span>
										<% if(i.getAnsContent() == null){ %>
											<pre>아직 답변이 없습니다.</pre>
										<% } else { %>
											<pre><%= i.getAnsContent() %></pre>
											<span class="date"><%= i.getAnsEnrollDate() %></span>
										<% } %>
									</div>
								</td>
							</tr>
						<% } %>
					<% } %>
                </tbody>
            </table>
            
            <script>
            	$(function(){
            		$(".admin-table > tbody > tr").click(function(){
            			if($(this).next().css("display") == "none"){
            				$(this).next().css("display", "");
            			}else{
            				$(this).next().css("display", "none");
            			}	
            		})
            	})
            </script>

            <div class="paging-area">
                
                <% if(pageInfo.getCurrentPage() != 1){ %>
                	<a href="<%= contextPath %>/mentorQueListView.ad?cpage=<%= pageInfo.getCurrentPage() - 1 %>">&lt</a>
                <% } %>
                
                <% for(int i = pageInfo.getStartPage(); i <= pageInfo.getEndPage(); i++){ %>
                	<% if(pageInfo.getCurrentPage() == i){ %>
                		<a href="<%= contextPath %>/mentorQueListView.ad?cpage=<%= i %>" style="background-color : gray;"><%= i %></a>
                	<% } else { %>
						<a href="<%= contextPath %>/mentorQueListView.ad?cpage=<%= i %>"><%= i %></a>
                	<% } %>
                <% } %>
                
                <% if(pageInfo.getCurrentPage() != pageInfo.getMaxPage()){ %>
                	<a href="<%= contextPath %>/mentorQueListView.ad?cpage=<%= pageInfo.getCurrentPage() + 1 %>">&gt</a>
            	<% } %>
            </div>
		</div>
	</div>
	<% } %>
</body>
</html>