<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<style>
	.search-area-wrap{
		width : 1190px;
		margin : 80px auto 0 auto;
	}

	/*카테고리부분*/
	.search-area-wrap>.category-area{
		width : 100%;
		height : 30px;
		font-size : 12px;
		font-weight: bold;;
		display : flex;
	}

	.search-area-wrap>.category-area>li>a{
		color : black;
	}

	.search-area-wrap>.category-area>li>a:hover{
		text-decoration: underline;
	}
	
	/*검색어 결과, 검색폼 부분*/
	.search-area-wrap>.search-area{
		width : 100%;
		height : 80px;
	}

	.search-area-wrap>.search-area input{
		width : 90%;
		height : 40px;
		padding-left : 7px;
		border: 2px solid #6363ff;
	}

	.search-area-wrap>.search-area button{
		width : 9%;
		height : 40px;
		background-color : #6363ff;
		color : white;
		border-style: none;
		cursor: pointer;
	}
	
	/*클래스 부분*/
	.search-area-wrap>.class-wrap{
		width : 100%;
		margin : 50px 0 80px 0;
	}

	.search-area-wrap>.class-wrap>.class-item{
		width : 100%;
		height : 120px;
		padding : 0 20px 0 20px;
		margin-bottom : 20px;
		border-radius: 5px;
		display: flex;
		flex-direction: row;
		justify-content: space-between;
		align-items: center;
		box-shadow: 3px 3px 5px rgb(192, 192, 192);
	}

	.search-area-wrap>.class-wrap>.class-item a{
		color : black;
	}

	.search-area-wrap>.class-wrap>.class-item a:hover{
		text-decoration: underline;
	}

	/*멘토 부분*/
	.search-area-wrap>h2{
		margin-top : 50px;
	}

	.search-area-wrap>.mentor-wrap{
		width : 100%;
		margin : 30px 0 30px 0;
		display: flex;
		flex-wrap : wrap;
		}

	.search-area-wrap>.mentor-wrap>.mentor-info{
		width : 150px;
		height : 200px;
		box-shadow: 3px 3px 5px rgb(192, 192, 192);
		border-radius: 5px;
		display: flex;
		flex-direction: column;
		justify-content: space-between;
		align-items: center;
		padding : 20px 10px 10px 10px;
		margin : 0 30px 50px 0;
	}

	.search-area-wrap>.mentor-wrap>.mentor-info>.profile-box{
		width : 60px;
		height : 60px;
		border-radius: 70%;
		overflow: hidden;
	}

	.search-area-wrap>.mentor-wrap>.mentor-info>.profile-box>img{
		width : 100%;
		height : 100%;
		object-fit: cover;
	}

	.search-area-wrap>.mentor-wrap>.mentor-info>span{
		font-size: 12px;
	}

	.search-area-wrap>.mentor-wrap>.mentor-info>button{
		width : 100%;
		height : 40px;
		background-color: #6363ff;
		color : white;
		border-style: none;
		border-radius: 5px;
		cursor: pointer;
	}

	/*게시글 부분*/
	#c{
		margin-bottom: 20px;
	}

	.search-area-wrap>.post-wrap{
		width : 100%;
		margin : 50px 0 80px 0;
	}

	.search-area-wrap>.post-wrap>.post-item{
		width : 100%;
		height : 120px;
		padding : 0 20px 0 20px;
		margin-bottom : 20px;
		border-radius: 5px;
		display: flex;
		flex-direction: row;
		justify-content: space-between;
		align-items: center;
		box-shadow: 3px 3px 5px rgb(192, 192, 192);
	}

	.search-area-wrap>.post-wrap>.post-item a{
		color : black;
	}

	.search-area-wrap>.post-wrap>.post-item a:hover{
		text-decoration: underline;
	}

	.search-area-wrap>.post-wrap>.post-item>.post-content{
		color : #666;
		line-height: 25px;
	}
</style>
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