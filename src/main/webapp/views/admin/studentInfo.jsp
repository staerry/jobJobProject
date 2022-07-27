<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import="com.jj.common.model.vo.PageInfo, com.jj.member.model.vo.Member, java.util.ArrayList"%>
<%
	PageInfo pi = (PageInfo)request.getAttribute("pi");
	ArrayList<Member> list = (ArrayList<Member>)request.getAttribute("list");
	
	int lpage = (int)request.getAttribute("lpage");
	int currentPage = pi.getCurrentPage();
	int startPage = pi.getStartPage();
	int endPage = pi.getEndPage();
	int maxPage = pi.getMaxPage();
%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<link rel="stylesheet" href="${pageContext.request.contextPath}/resources/css/admin/studentInfo.css">
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
	        <h3>수강생 정보</h3>
			<h5>수강생 리스트</h5>

			<div class="checks">
				<div id="formwraping">
					<form action="" style="">
						&nbsp;
						<input type="checkbox" id="check1"> 
						<label for="check1">전체회원</label>
						&nbsp;
						<input type="checkbox" id="check2"> 
						<label for="check2">탈퇴한회원</label> &nbsp;
						<input type="text" style="line-height: 30px; width: 200px;" id="searchclick" placeholder="   이름또는 회원번호로 검색">
						<label for="searchclick"><button id="searchbtn" style="line-height: 30px;" class="btnpurple">검색</button></label>
					</form>
				</div>
			</div>
					
			<table class="table table-bordered table-hover stutable">
				<thead>
					<tr>
						<th width="100">번호(회원고유번호)</th>
						<th width="100">이름</th>
						<th width="150">아이디</th>
						<th width="150">이메일</th>
						<th width="100">전화번호</th>
						<th width="50">가입일/탈퇴일</th>
						<th width="80">강제탈퇴</th>
					</tr>
				</thead>
				<tbody>
					<%if(list.isEmpty()){ %>
					<script>
					alert("조회된 회원이없습니다.")
					location.href= "javascript:history.back()";
					</script>
				<%}else{ %>
					<%for(int i=0;i<list.size();i++){ %>
						<tr>
							<td><%=lpage-i %>(<%=list.get(i).getUserNo() %>)</td>
							<td><%=list.get(i).getUserName() %></td>
							<td><%=list.get(i).getUserId() %></td>
							<td><%=list.get(i).getUserEmail() %></td>
							<td><%=list.get(i).getUserPhone() %></td>
							<td><%=list.get(i).getEnrollDate() %></td>
							<td><button class="outbutton">탈퇴</button></button></td>
						</tr>
					<%} %>
				<%} %>	
				</tbody>
			</table>

			<span class="totalpage">
				<%=currentPage %> 페이지 / <%=maxPage %> 페이지 
			</span>

			<div class="paging-area">
			 <%if(currentPage != 1){ %>
				<a href="<%=request.getContextPath()%>/stuInfo.li?p=<%=currentPage-1%>">&lt</a>
				<%} %>
				<%for(int i=startPage;i<=endPage;i++){ %>
	            	<%if(i==currentPage){ %>
	            		<a href="<%=request.getContextPath()%>/stuInfo.li?p=<%=i%>"><%=i %></a>
	            	<%}else{ %>
	            		<a href="<%=request.getContextPath()%>/stuInfo.li?p=<%=i%>"><%=i %></a>
	            	<%} %>
            	<%} %>
            	<%if(currentPage != maxPage){ %>
					<a href="<%=request.getContextPath()%>/stuInfo.li?p=<%=currentPage+1%>">&gt</a>
				<%} %>
				<a href="">&gt&gt</a>
			</div>
		</div>
		<script>
			
		</script>
	    
	</div>
	<%} %>
</body>
</html>