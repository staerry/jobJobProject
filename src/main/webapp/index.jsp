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
		<ul class="main-slide-area">
			<li class="prev">
				<i class="fas fa-angle-left"></i>
			</li>
			<li class="img1">슬라이드이미지1</li>
			<li class="img2" style="display : none">슬라이드이미지2</li>
			<li class="img3" style="display : none">슬라이드이미지3</li>
			<li class="next">
				<i class="fas fa-angle-right"></i>
			</li>
		</ul>
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
	
	<!-- main-slide-area부분 -->
	<script>
		let result = 1; // 이미지 순서를 나타내는 숫자

		$(".main-slide-area>.next").click(function(){
			result += 1; // next클릭시 result 1씩 증가

			switch(result){
				case 1 : // result가 1일 때 img1제외 나머지 요소 display : none
					$(".img1").css('display', '');
					$(".img2").css('display', 'none');
					$(".img3").css('display', 'none');
					break;
				case 2 : // result가 2일 때 img2제외 나머지 요소 display : none 
					$(".img1").css('display', 'none');
					$(".img2").css('display', '');
					$(".img3").css('display', 'none');
					break;
				case 3 : // result가 3일 때 img3제외 나머지 요소 display : none 
					$(".img1").css('display', 'none');
					$(".img2").css('display', 'none');
					$(".img3").css('display', '');
					break;
				default : 

				// result가 3을 초과할 때  result값 1로 초기화 후 스타일 적용
				if(result > 3){
					result = 1;
					$(".img1").css('display', '');
					$(".img2").css('display', 'none');
					$(".img3").css('display', 'none');
				}
			}
		})

		$(".main-slide-area>.prev").click(function(){
			result -= 1; // prev클릭시 result 1씩 감소

			switch(result){
				case 1 : // result가 1일 때 img1제외 나머지 요소 display : none
					$(".img1").css('display', '');
					$(".img2").css('display', 'none');
					$(".img3").css('display', 'none');
					result = 4;
					break;
				case 2 : // result가 2일 때 img2제외 나머지 요소 display : none 
					$(".img1").css('display', 'none');
					$(".img2").css('display', '');
					$(".img3").css('display', 'none');
					break;
				case 3 : // result가 3일 때 img3제외 나머지 요소 display : none 
					$(".img1").css('display', 'none');
					$(".img2").css('display', 'none');
					$(".img3").css('display', '');
					break;
				default : 

				// result가 1미만일 때  result값 3으로 초기화 후 스타일 적용
				if(result < 1){
					result = 3;
					$(".img1").css('display', 'none');
					$(".img2").css('display', 'none');
					$(".img3").css('display', '');
				}
			}
			console.log(result);
		})
	</script>
</body>
</html>