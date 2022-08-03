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
        
        p{
        	margin : 0;
        }
        
        h2{
        	margin : 0;
        	font-weight : bold;
        	font-size : 24px;
        }
        
        h4{
        	margin : 0;
        	font-weight : bold;
        	font-size : 16px;
        }
        </style>
</head>
<body>
	<%@ include file="views/common/menubar.jsp" %>
	
	<div class="main-banner-wrap">
	
		<!-- 슬라이드 이미지 부분 -->
	    <div id="demo" class="carousel slide" data-ride="carousel">
	      
	        <div class="carousel-inner">
				<!-- ajax로 데이터 조회 중 -->
	        </div>
	      
	        <a class="carousel-control-prev" href="#demo" data-slide="prev">
	          <span class="carousel-control-prev-icon"></span>
	        </a>
	        <a class="carousel-control-next" href="#demo" data-slide="next">
	          <span class="carousel-control-next-icon"></span>
	        </a>
	        
	        <!-- 슬라이드 데이터 출력 ajax -->
	        <script>
		        $(document).ready(function(){
		        	$.ajax({
		        		url : "ajaxSlideImgList.me",
		        		date : {},
		        		success : function(result){
		        			
		        			let value = "";
		        			for(let i = 0; i < result.length; i++){
		        				if(i == 1){
									value += '<div class="carousel-item active">'
									      +  	'<img src="' + result[i].filePath + result[i].fileName + '" alt="slide-img-' + i + '">'
									      +  '</div>'
		        				}else{
									value += '<div class="carousel-item">'
									      +  	'<img src="' + result[i].filePath + result[i].fileName + '" alt="slide-img-' + i + '">'
									      +  '</div>'
		        				}
		        			}
		        			
		        			$(".carousel-inner").html(value);
		        		},
		        		error : function(){
		        			console.log("슬라이드 이미지 부분 ajax 통신 실패");
		        		}
		        	})
		        });
	        </script>
	    </div><!-- 슬라이드 이미지 부분 끝 -->
	    
	    <!-- 로그인 전 보여질 부분 -->
		<div class="main-login-area">
			<% if(loginUser == null){ %>
				<a href="<%= contextPath %>/firstlogin.me" class="main-login-btn">로그인</a>
				<p class="main-regist">
					처음이신가요? <a href="<%= contextPath %>/loginEnrollForm.me"><b>회원가입</b></a><br>
					<a href="<%=contextPath%>/mentorEnroll.me"><b>멘토가입</b></a>
				</p><!-- 로그인 전 보여질 부분 끝 -->
			<!-- 로그인 후 보여질 부분 -->
			<% } else { %>
				<p class="main-logout"><b><a href="<%=contextPath%>/userlogout.me">로그아웃</a></b></p>
				<div class="main-profile-img"></div>
				<p class="main-mypage-menu">
					<b id="userName"><%= loginUser.getUserName() %></b>님<br><br>
					<b id="classIng"><a href="">수강중인강의 3</a></b><br><br>
					<b><a href="<%=contextPath%>/myPage.my">마이페이지</a></b>
				</p><!-- 로그인 후 보여질 부분 끝 -->
			<% } %>
			
			<script>
				$(document).ready(function(){
					$.ajax({
						url : "ajaxSelectClassIng.me",
						data : {name : $("#userName").text()},
						success : function(result){
							$("#classIng").text("수강중인강의 " + result);
						},
						error : function(){
							console.log("로그인 부분 ajax통신 실패");
						}
					})
				})
			</script>
		</div>
	</div>

	<div class="main-content-wrap">

		<!--검색 부분-->	
		<div class="search-bar">
			<form action="searchResultView.me">
				<input type="search" name="keyword" placeholder="클래스, 멘토, 게시글 검색">
				<button type="submit">
					<i class="fas fa-search"></i>
				</button>
			</form>
		</div><!-- 검색 부분 끝 -->

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
					<!-- ajax로 데이터 조회중 -->
                </div>
            </div>

			<div class="vod-slide-btn-right">
				<i class="fas fa-angle-right"></i>
			</div>
			
			<!-- vod부분 ajax -->
			<script>
				$(document).ready(function(){
					$.ajax({
						url : "ajaxClassList.me",
						data : {},
						success : function(result){
							
							let value = "";
							for(let i = 0; i < 9; i++){
								value += '<div class="vod" onclick="location.href=\'<%= contextPath %>\/detail.cl?class=' + result[i].clNo +'\'">'
								      +  	'<h4>' + result[i].clTitle + '</h4>'
								      +     '<p>' + result[i].userNo + '&nbsp&nbsp&nbsp&nbsp' + result[i].mtCompany + '<p>'
								      +     '<img class="class-thumbnail" src="' + result[i].clThumbnailPath + '" alt="thumbnail' + i + '" width="200">'
								      +  '</div>'
							}
							
							$(".main-container").html(value);
						},
						error : function(){
							console.log("클래스 조회 부분 ajax통신 실패");
						}
					})
				})
			</script>
		</div><!-- vod부분 끝 -->

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
					<!-- ajax 조회 중 -->
                </div>
            </div>

			<div class="mentor-slide-btn-right">
				<i class="fas fa-angle-right"></i>
			</div>
			
			<!-- 멘토부분 ajax -->
			<script>
				$(document).ready(function(){
					$.ajax({
						url : "ajaxMentorList.me",
						data : {},
						success : function(result){
							
							let value = "";
							for(let i = 0; i < 12; i ++){
								value += '<div class="mentor">'
								      +  	'<div class="mentor-profile-img">'
								      +     	'<img src="' + result[0].ltrProfilePath + '" alt="profile-image">'
								      +     '</div>'
				                      +  	'<div class="mentor-info">'
	                            	  +	 		'<span>' + result[i].userName + '</span>'
	                           		  +	    	'<span>' + result[i].ltrCompany + '</span>'
	                        		  +	    '</div>'
	                        		  + 	'<a href="<%= contextPath %>\/detail.lt?lecNo=' + result[i].userNo + '">방문하기</a>'
	                        		  +  '</div>'
							}
							
							$(".mentor-container").html(value);
						},
						error : function(){
							console.log("멘토 조회 부분 ajsx통신 실패");
						}
					})
				})
			</script>
			
		</div><!-- 멘토 부분 끝 -->

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
					<!-- ajax 조회중 -->
                </div>
            </div>

			<div class="community-slide-btn-right">
				<i class="fas fa-angle-right"></i>
			</div>
			
			<!-- 커뮤니티 ajax -->
			<script>
				$(document).ready(function(){
					$.ajax({
						url : "ajaxPostList.me",
						data : {},
						success : function(result){
							console.log(result);
							
							let value = "";
							for(let i = 0; i < 6; i++){
								value += '<div class="community" onclick="location.href=\'<%= contextPath %>\/detail.co?contentNo=' + result[i].commNo + '\'">'
							          +  	'<div class="text-area">'
						              +  		'<span>' + result[i].commTitle + '</span><br>'
						              +  		'<pre class="text">' + result[i].commContent + '</pre>'
						              +  		'<span>' + result[i].commWriter + '</span>'
						              +  	'</div>'
						              +  	'<div class="reply-area">'
						              +  		'<span>' + result[i].count + '</span><br>'
						              +  		'<span>조회수</span>'
						              +  	'</div>'
						              +  '</div>'
							}
							
							$(".community-container").html(value);
						},
						error : function(){
							console.log("커뮤니티 부분 ajax통신 실패");
						}
					})
				})
			</script>
			
		</div><!-- 커뮤니티 부분 끝 -->
	</div>
	
	<%@ include file="views/common/footer.jsp" %>
	
	<!--vod슬라이드 부분-->
    <script>
        let vodPosition = 0;

        $(".main-vod-list>.vod-slide-btn-right").click(function(){
            vodPosition += 245;
            $(".main-container").css('transform', 'translateX(-'+ vodPosition +'px)');
            if(vodPosition >= 1000){
                vodPosition = -245;
            }
        })

        $(".main-vod-list>.vod-slide-btn-left").click(function(){
            vodPosition -= 245;
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
            mentorPosition += 190;
            $(".mentor-container").css('transform', 'translateX(-'+ mentorPosition +'px)');
            if(mentorPosition >= 825){
                mentorPosition = -190;
            }
        })

        $(".main-mentor-list>.mentor-slide-btn-left").click(function(){
            mentorPosition -= 190;
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