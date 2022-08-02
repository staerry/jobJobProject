<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<link rel="stylesheet" href="${pageContext.request.contextPath}/resources/css/setting.css">
<link rel="stylesheet" href="${pageContext.request.contextPath}/resources/css/main.css">

<link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap@4.6.1/dist/css/bootstrap.min.css">
<script src="https://cdn.jsdelivr.net/npm/jquery@3.6.0/dist/jquery.slim.min.js"></script>
<script src="https://cdn.jsdelivr.net/npm/popper.js@1.16.1/dist/umd/popper.min.js"></script>
<script src="https://cdn.jsdelivr.net/npm/bootstrap@4.6.1/dist/js/bootstrap.bundle.min.js"></script>

<title>Insert title here</title>
    <style>
        /* Make the image fully responsive */
        .carousel-inner img {
          width: 870px;
          height: 200px;
        }
        
        .carousel slide{
        	width : 870px;
        	overflow : hidden;
        }
        
        .carousel-inner {
        	width : 870px;
        }
        </style>
</head>
<body>
	<%@ include file="views/common/menubar.jsp" %>
	
	<div class="main-banner-wrap">
	    <div id="demo" class="carousel slide" data-ride="carousel">
	
	        <!-- Indicators -->
	        <ul class="carousel-indicators">
	          <li data-target="#demo" data-slide-to="0" class="active"></li>
	          <li data-target="#demo" data-slide-to="1"></li>
	          <li data-target="#demo" data-slide-to="2"></li>
	        </ul>
	      
	        <!-- The slideshow -->
	        <div class="carousel-inner">
	          <div class="carousel-item active">
	            <img src="https://svrforum.com/files/attach/images/2020/12/26/ac5610f38af46e7c135a9065561734e0.jpg" alt="Los Angeles">
	          </div>
	          <div class="carousel-item">
	            <img src="https://svrforum.com/files/attach/images/2020/12/26/ac5610f38af46e7c135a9065561734e0.jpg" alt="Chicago">
	          </div>
	          <div class="carousel-item">
	            <img src="https://svrforum.com/files/attach/images/2020/12/26/ac5610f38af46e7c135a9065561734e0.jpg" alt="New York">
	          </div>
	        </div>
	      
	        <!-- Left and right controls -->
	        <a class="carousel-control-prev" href="#demo" data-slide="prev">
	          <span class="carousel-control-prev-icon"></span>
	        </a>
	        <a class="carousel-control-next" href="#demo" data-slide="next">
	          <span class="carousel-control-next-icon"></span>
	        </a>
	      
	      </div>
		<div class="main-login-area">
			<% if(loginUser == null){ %>
				<a href="<%= contextPath %>/firstlogin.me" class="main-login-btn">로그인</a>
				<p class="main-regist">
					처음이신가요? <a href="<%= contextPath %>/loginEnrollForm.me"><b>회원가입</b></a><br>
					<a href="<%=contextPath%>/mentorEnroll.me"><b>멘토가입</b></a>
				</p>
			<% } else { %>
				<p class="main-logout"><b><a href="<%=contextPath%>/userlogout.me">로그아웃</a></b></p>
				<div class="main-profile-img"></div>
				<p class="main-mypage-menu">
					<b><%= loginUser.getUserName() %></b>님<br><br>
					<b><a href="">수강중인강의 3</a></b><br><br>
					<b><a href="<%=contextPath%>/myPage.my">마이페이지</a></b>
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
			<div class="vod-slide-btn-left">
				<i class="fas fa-angle-left"></i>
			</div>

            <div class="main-window">
                <div class="main-container">
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
                </div>
            </div>

			<div class="vod-slide-btn-right">
				<i class="fas fa-angle-right"></i>
			</div>
		</div>

		<!--멘토 부분-->
		<div class="main-mentor-title">
			<h2>멘토목록</h2>
			<p><b><a href="">더보기</a></b></p>
		</div>
		<div class="main-mentor-list">
			<div class="mentor-slide-btn-left">
				<i class="fas fa-angle-left"></i>
			</div>

            <div class="mentor-window">
                <div class="mentor-container">
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
                </div>
            </div>

			<div class="mentor-slide-btn-right">
				<i class="fas fa-angle-right"></i>
			</div>
		</div>

		<!--커뮤니티 부분-->
		<div class="main-community-title">
			<h2>커뮤니티</h2>
			<p><b><a href="<%= contextPath %>/list.co?category=1&cpage=1">더보기</a></b></p>
		</div>
		<div class="main-community-list">
			<div class="community-slide-btn-left">
				<i class="fas fa-angle-left"></i>
			</div>

            <div class="community-window">
                <div class="community-container">
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
                </div>
            </div>

			<div class="community-slide-btn-right">
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
	
	    <!--vod슬라이드 부분-->
    <script>
        let vodPosition = 0;

        $(".main-vod-list>.vod-slide-btn-right").click(function(){
            vodPosition += 250;
            $(".main-container").css('transform', 'translateX(-'+ vodPosition +'px)');
            if(vodPosition >= 1000){
                vodPosition = -250;
            }
        })

        $(".main-vod-list>.vod-slide-btn-left").click(function(){
            vodPosition -= 250;
            if(vodPosition <= 0){
                vodPosition = 1000;
            }
            $(".main-container").css('transform', 'translateX(-'+ vodPosition +'px)');
        })
    </script>

    <!--mentor슬라이드 부분-->
    <script>
        let mentorPosition = 0;

        $(".main-mentor-list>.mentor-slide-btn-right").click(function(){
            mentorPosition += 165;
            $(".mentor-container").css('transform', 'translateX(-'+ mentorPosition +'px)');
            if(mentorPosition >= 825){
                mentorPosition = -165;
            }
        })

        $(".main-mentor-list>.mentor-slide-btn-left").click(function(){
            mentorPosition -= 165;
            if(mentorPosition <= 0){
                mentorPosition = 825;
            }
            $(".mentor-container").css('transform', 'translateX(-'+ mentorPosition +'px)');
        })
    </script>

    <!--community슬라이드 부분-->
    <script>
        let commPosition = 0;

        $(".main-community-list>.community-slide-btn-right").click(function(){
            commPosition += 496;
            $(".community-container").css('transform', 'translateX(-'+ commPosition +'px)');
            if(commPosition >= 1984){
                commPosition = -496;
            }
        })

        $(".main-community-list>.community-slide-btn-left").click(function(){
            commPosition -= 496;
            if(commPosition <= 0){
                commPosition = 1984;
            }
            $(".community-container").css('transform', 'translateX(-'+ commPosition +'px)');
        })
    </script>
</body>
</html>