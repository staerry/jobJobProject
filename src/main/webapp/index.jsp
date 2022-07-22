<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<link rel="stylesheet" href="resources/css/setting.css">
<link rel="stylesheet" href="resources/css/main.css">

<script src="https://kit.fontawesome.com/ea8287c514.js" crossorigin="anonymous"></script>
<title>Insert title here</title>
</head>
<body>

	<%@ include file="views/common/menubar.jsp" %>
	
	<div class="main-banner-wrap">
		<div class="main-slide-area"></div>
		<div class="main-login-area">
			<% if(true){ %>
				<a href="" class="main-login-btn">로그인</a>
				<p class="main-regist">
					처음이신가요? <a href=""><b>회원가입</b></a><br>
					<a href=""><b>멘토가입</b></a>
				</p>
			<% } else { %>
				<p class="main-logout"><b><a href="">로그아웃</a></b></p>
				<div class="main-profile-img"></div>
				<p class="main-mypage-menu">
					<b>xxx</b>님<br><br>
					<b><a href="">수강중인강의 3</a></b><br><br>
					<b><a href="">마이페이지</a></b>
				</p>
			<% } %>
		</div>
	</div>

	<!--검색 부분-->
	<div class="main-content-wrap">
		<div class="search-bar">
			<form action="">
				<input type="search">
				<button type="submit">
					<i class="fas fa-search"></i>
				</button>
			</form>
		</div>

		<!--vod 부분-->
		<div class="main-vod-title">
			<h2>강의목록</h2>
			<p><b><a href="">더보기</a></b></p>
		</div>
		<div class="main-vod-list">
			<div class="vod-slide-btn">
				<i class="fas fa-angle-left"></i>
			</div>
			<div class="vod">
				<h4>클래스명이 들어갈 자리</h4>
				<p>멘토명&nbsp&nbsp&nbsp&nbsp멘토소속</p>
				<div class="class-thumbnail"></div>
				<span>
					<i class="fas fa-heart"></i>
				</span>
			</div>
			<div class="vod">
				<h4>클래스명이 들어갈 자리</h4>
				<p>멘토명&nbsp&nbsp&nbsp&nbsp멘토소속</p>
				<div class="class-thumbnail"></div>
				<span>
					<i class="fas fa-heart"></i>
				</span>
			</div>
			<div class="vod">
				<h4>클래스명이 들어갈 자리</h4>
				<p>멘토명&nbsp&nbsp&nbsp&nbsp멘토소속</p>
				<div class="class-thumbnail"></div>
				<span>
					<i class="fas fa-heart"></i>
				</span>
			</div>
			<div class="vod">
				<h4>클래스명이 들어갈 자리</h4>
				<p>멘토명&nbsp&nbsp&nbsp&nbsp멘토소속</p>
				<div class="class-thumbnail"></div>
				<span>
					<i class="fas fa-heart"></i>
				</span>
			</div>
			<div class="vod-slide-btn">
				<i class="fas fa-angle-right"></i>
			</div>
		</div>

		<!--멘토 부분-->
		<div class="main-mentor-title">
			<h2>멘토목록</h2>
			<p><b><a href="">더보기</a></b></p>
		</div>
		<div class="main-mentor-list">
			<div class="mentor-slide-btn">
				<i class="fas fa-angle-left"></i>
			</div>
			<div class="mentor">
				<div class="mentor-profile-img"></div>
				<div class="mentor-info">
					<span>멘토명</span>
					<span>멘토 소속</span>
				</div>
				<a href="">방문하기</a>
			</div>
			<div class="mentor">
				<div class="mentor-profile-img"></div>
				<div class="mentor-info">
					<span>멘토명</span>
					<span>멘토 소속</span>
				</div>
				<a href="">방문하기</a>
			</div>
			<div class="mentor">
				<div class="mentor-profile-img"></div>
				<div class="mentor-info">
					<span>멘토명</span>
					<span>멘토 소속</span>
				</div>
				<a href="">방문하기</a>
			</div>
			<div class="mentor">
				<div class="mentor-profile-img"></div>
				<div class="mentor-info">
					<span>멘토명</span>
					<span>멘토 소속</span>
				</div>
				<a href="">방문하기</a>
			</div>
			<div class="mentor">
				<div class="mentor-profile-img"></div>
				<div class="mentor-info">
					<span>멘토명</span>
					<span>멘토 소속</span>
				</div>
				<a href="">방문하기</a>
			</div>
			<div class="mentor">
				<div class="mentor-profile-img"></div>
				<div class="mentor-info">
					<span>멘토명</span>
					<span>멘토 소속</span>
				</div>
				<a href="">방문하기</a>
			</div>
			<div class="mentor-slide-btn">
				<i class="fas fa-angle-right"></i>
			</div>
		</div>

		<!--커뮤니티 부분-->
		<div class="main-community-title">
			<h2>커뮤니티</h2>
			<p><b><a href="">더보기</a></b></p>
		</div>
		<div class="main-community-list">
			<div class="community-slide-btn">
				<i class="fas fa-angle-left"></i>
			</div>
			<div class="community">
				<div class="text-area">
					<span>게시글 제목이 들어갈 자리 입니다.</span>
					<div class="text">
						게시글 내용이 들어갈 자리입니다.
					</div>
					<span>작성자</span>
				</div>
				<div class="reply-area">
					<span>0</span><br>
					<span>댓글</span>
				</div>
			</div>
			<div class="community">
				<div class="text-area">
					<span>게시글 제목이 들어갈 자리 입니다.</span>
					<div class="text">
						게시글 내용이 들어갈 자리입니다.
					</div>
					<span>작성자</span>
				</div>
				<div class="reply-area">
					<span>0</span><br>
					<span>댓글</span>
				</div>
			</div>
			<div class="community-slide-btn">
				<i class="fas fa-angle-right"></i>
			</div>
		</div>
	</div>
	<%@ include file="views/common/footer.jsp" %>
	
</body>
</html>