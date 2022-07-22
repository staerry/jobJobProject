<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">

<!--css-->
<link rel="stylesheet" href="resources/css/member/topmenu.css">
<link rel="stylesheet" href="resources/css/setting.css">

<!--font-->
<link rel="preconnect" href="https://fonts.googleapis.com">
<link rel="preconnect" href="https://fonts.gstatic.com" crossorigin>
<link href="https://fonts.googleapis.com/css2?family=Noto+Sans+KR:wght@100;400;700&display=swap" rel="stylesheet">

<!--jQuery-->
<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.6.0/jquery.min.js"></script>

<!-- Font Awesome -->
<script src="https://kit.fontawesome.com/ea8287c514.js" crossorigin="anonymous"></script>

<title>Insert title here</title>
</head>
<body>

    <div class="top-menu-wrap">
        <div class="top-menu-area">
            <div class="mini-menu-area">
            	<% if(true){ %>
                <!--로그인전-->
                <span><a href="">로그인</a></span>
                <% } else { %>
                <!--로그인후-->
                <span><a href="">마이페이지</a></span>
                <span><a href="">로그아웃</a></span>
                <span><b>xxx</b>님</span>
                <% } %>
            </div>
            <div class="logo-area">
                <img src="resources/image/logo.png" alt="logo" width="130">
            </div>
            <ul class="main-menu-area">
                <li><a href="">강의조회</a></li>
                <li><a href="">멘토조회</a></li>
                <li><a href="">커뮤니티</a></li>
            </ul>
        </div>
    </div>

</body>
</html>