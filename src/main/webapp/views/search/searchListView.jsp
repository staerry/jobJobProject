<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
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
			<li>총 11건&nbsp;&nbsp;|&nbsp;&nbsp;</li>
			<li><a href="#a">클래스 11</a>&nbsp;&nbsp;|&nbsp;&nbsp;</li>
			<li><a href="#b">멘토 55</a>&nbsp;&nbsp;|&nbsp;&nbsp;</li>
			<li><a href="#c"> 게시글 11</a></li>
		</ul><!--카테고리부분 끝-->

		<!--검색어 결과, 검색폼 부분-->
		<div class="search-area">
			<h2>"검색어"의 결과</h2><br>
			<form action="" method="post">
				<input type="search" name="search" placeholder="검색">
				<button type="submit">검색</button>
			</form>
		</div><!--검색어 결과, 검색폼 부분 끝-->

		<!--클래스 부분-->
		<div class="class-wrap">
			<h2 id="a">클래스</h2>
			<br>
			<div class="class-item">
				<div class="class-info">
					<h4><a href="">쉽게 배우는 자바</a></h4>
					<pre>가진 거라곤 오직 대학 졸업장 달랑 한 장뿐입니다. 저도 마케터가 될 수 있을까요</pre>
					<br>
					<span>박새돌</span>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;<span>IT개발</span>
				</div>
				<div class="class-img">
					<img src="https://grm-project-template-bucket.s3.ap-northeast-2.amazonaws.com/lecture/lec_iccuC_1654424781238/coverImage.png?_=1656050420140" alt="썸네일" height="100">
				</div>
			</div>
		</div><!--클래스 부분 끝-->

		<hr>

		<!--멘토 부분-->
		<h2 id="b">멘토</h2>
		<div class="mentor-wrap">
			<div class="mentor-info">
				<div class="profile-box">
					<img src="https://img1.daumcdn.net/thumb/R1280x0/?scode=mtistory2&fname=https%3A%2F%2Fblog.kakaocdn.net%2Fdn%2Fdi0GrI%2FbtqyyWdEYM8%2FLbDOJG6QuYVXzFI9AlMq60%2Fimg.png" alt="프로필">
				</div>
				<h4>홍길동</h4>
				<span>멘토 소속</span><br>
				<button type="button">방문하기</button>
			</div>
		</div><!--멘토 부분 끝-->

		<hr>

		<!--게시글 부분-->
		<div class="post-wrap">
			<h2 id="c">게시글</h2>
			<div class="post-item">
				<div class="post-info">
					<h4><a href="">쉽게 배우는 자바</a></h4>
					<pre>가진 거라곤 오직 대학 졸업장 달랑 한 장뿐입니다. 저도 마케터가 될 수 있을까요</pre>
					<br>
					<span>박새돌</span>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;<span>2022-12-12</span>
				</div>
				<div class="post-content">
					<i class="fas fa-eye"></i>&nbsp;&nbsp;111<br>
					<i class="fas fa-comment-dots"></i>&nbsp;&nbsp;212<br>
					<i class="fas fa-heart"></i>&nbsp;&nbsp;311<br>
				</div>
			</div>
		</div><!--게시글 부분 끝-->
	</div>
	
	<%@ include file="../common/footer.jsp" %>
</body>
</html>