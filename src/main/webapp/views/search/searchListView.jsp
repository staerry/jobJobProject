<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import="java.util.ArrayList, com.jj.classSelect.model.vo.Class, com.jj.community.model.vo.Community, com.jj.mentorSelect.model.vo.Lecturer" %>
    
<%
	String keyword = (String)request.getAttribute("keyword");
	int classCount = (int)request.getAttribute("classCount");
	int lecturerCount = (int)request.getAttribute("lecturerCount");
	int communityCount = (int)request.getAttribute("communityCount");
	ArrayList<Class> classList = (ArrayList<Class>)request.getAttribute("classList");
	ArrayList<Lecturer> lecturerList = (ArrayList<Lecturer>)request.getAttribute("lecturerList");
	ArrayList<Community> communityList = (ArrayList<Community>)request.getAttribute("communityList");

	int searchAllCount = classCount + lecturerCount + communityCount;
%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<link rel="stylesheet" href="${pageContext.request.contextPath}/resources/css/member/searchListView.css">
<title>Insert title here</title>
</head>
<body>
	<%@ include file="../common/menubar.jsp" %>
	
	<div class="search-area-wrap">

		<!--카테고리부분-->
		<ul class="category-area">
			<li>총 <%= searchAllCount %>건&nbsp;&nbsp;|&nbsp;&nbsp;</li>
			<li><a href="#a">클래스 <%= classCount %></a>&nbsp;&nbsp;|&nbsp;&nbsp;</li>
			<li><a href="#b">멘토 <%= lecturerCount %></a>&nbsp;&nbsp;|&nbsp;&nbsp;</li>
			<li><a href="#c"> 게시글 <%= communityCount %></a></li>
		</ul><!--카테고리부분 끝-->

		<!--검색어 결과, 검색폼 부분-->
		<div class="search-area">
			<h2>"<%= keyword %>"의 결과</h2><br>
			<form action="" method="post">
				<input type="search" name="search" placeholder="검색">
				<button type="submit">검색</button>
			</form>
		</div><!--검색어 결과, 검색폼 부분 끝-->

		<!--클래스 부분-->
		<div class="class-wrap">
			<h2 id="a">클래스</h2>
			<br>
			<% for(Class i : classList){ %>
				<div class="class-item">
					<div class="class-info">
						<h4><a href=""><%= i.getClTitle() %></a></h4>
						<pre><%= i.getClSubtitle() %></pre>
						<br>
						<span><%= i.getUserNo() %></span>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;<span><%= i.getClCategory() %></span>
					</div>
					<div class="class-img">
						<img src="<%= i.getClThumbnailPath() %>" alt="썸네일" height="100">
					</div>
				</div>
			<% } %>
		</div><!--클래스 부분 끝-->

		<hr>

		<!--멘토 부분-->
		<h2 id="b">멘토</h2>
		<div class="mentor-wrap">
			<% for(Lecturer i : lecturerList){ %>
				<div class="mentor-info">
					<div class="profile-box">
						<img src="<%= i.getLtrProfilePath() %>" alt="프로필">
					</div>
					<h4><%= i.getUserName() %></h4>
					<span><%= i.getLtrCompany() %></span><br>
					<button type="button">방문하기</button>
				</div>
			<% } %>
		</div><!--멘토 부분 끝-->

		<hr>

		<!--게시글 부분-->
		<div class="post-wrap">
			<h2 id="c">게시글</h2>
			<% for(Community i : communityList){ %>
				<div class="post-item">
					<div class="post-info">
						<h4><a href=""><%= i.getCommTitle() %></a></h4>
						<pre><%= i.getCommContent() %></pre>
						<br>
						<span><%= i.getCommWriter() %></span>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;<span><%= i.getCreateDate() %></span>
					</div>
					<div class="post-content">
						<i class="fas fa-eye"></i>&nbsp;&nbsp;<%= i.getCount() %><br>
						<i class="fas fa-heart"></i>&nbsp;&nbsp;<%= i.getLikeCount() %><br>
					</div>
				</div>
			<% } %>
		</div><!--게시글 부분 끝-->
	</div>
	
	<%@ include file="../common/footer.jsp" %>
</body>
</html>