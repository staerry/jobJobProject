<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">

<link rel="stylesheet" href="resources/css/admin/menubar.css">

<title>Insert title here</title>
</head>
<body>
    <div class="wrap">
        <div id="photo">
            
        </div>
        <a class="menu" id="dash">대시보드</a>
        <br><br><br>
        <div class="menu">승인<span class="menu2">></span></div>
        <ul class="list">
            <li>멘토가입승인</li>
            <li>멘토클래스등록승인</li>
            <li>멘토강의등록승인</li>
        </ul>
        <br><br>

        <div class="menu">관리<span class="menu2">></span></div>
        <ul class="list">
            <li >강의관리</li>
            <li>게시글관리</li>
            <li>공지사항관리</li>
            <li>FAQ관리</li>
            <li>1대1문의관리</li>
            <li>쿠폰관리</li>
        </ul>
        <br><br>

        <div class="menu">정보<span class="menu2">></span></div>
        <ul class="list">
            <li>멘토정보</li>
            <li>수강생정보</li>
        </ul>
        <br><br>
        
        <div class="menu">결제<span class="menu2">></span></div>
        <ul class="list">
            <li>결제내역조회</li>
            <li>환불요청처리</li>
        </ul>
        <br><br>
    </div>

    <script>
        $(function(){
            $(".menu").click(function(){
              const $li = $(this).next();

              if( $li.css("display") == "none" ){
                   
                    $(this).siblings("ul").slideUp();
                    $(".menu").children().text('>') 
                    $li.slideDown();
                    $(this).children().text('v')
                }else{
                    $li.slideUp(); 
                    $(".menu").children().text('>') 
                }
            })
        })
    </script>
</body>
</html>