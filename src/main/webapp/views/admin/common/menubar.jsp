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
        <div  id="dash" onclick="linkbutton(1);">대시보드</div>
        <br><br>
        <div class="menu">승인<span class="menu2">></span></div>
        <ul class="list">
            <li onclick="linkbutton(2);">멘토가입승인</li>
            <li onclick="linkbutton(3);">멘토클래스등록승인</li>
            <li onclick="linkbutton(4);">멘토강의등록승인</li>
        </ul>
        <br><br>

        <div class="menu">관리<span class="menu2">></span></div>
        <ul class="list">
            <li onclick="linkbutton(5);">강의관리</li>
            <li onclick="linkbutton(6);">게시글관리</li>
            <li onclick="linkbutton(7);">공지사항관리</li>
            <li onclick="linkbutton(8);">FAQ관리</li>
            <li onclick="linkbutton(9);">1대1문의관리</li>
            <li onclick="linkbutton(10);">쿠폰관리</li>
        </ul>
        <br><br>

        <div class="menu">정보<span class="menu2">></span></div>
        <ul class="list">
            <li onclick="linkbutton(11);">멘토정보</li>
            <li onclick="linkbutton(12);">수강생정보</li>
        </ul>
        <br><br>
        
        <div class="menu">결제<span class="menu2">></span></div>
        <ul class="list">
            <li onclick="linkbutton(13);">결제내역조회</li>
            <li onclick="linkbutton(14);">환불요청처리</li>
        </ul>
        <br><br>
    </div>

    <script>
        $(function(){
            $(".menu").click(function(){
              const $li = $(this).next();

              if( $li.css("display") == "none" ){
                   
                    $(this).siblings(".list").slideUp();
                    $(".menu").children().text('>') 
                    $li.slideDown();
                    $(this).children().text('v')
                }else{
                    $li.slideUp(); 
                    $(".menu").children().text('>') 
                }
            })
        })

        function linkbutton(num){
            switch(num){
                case 1: location.href=""; break;
                case 2: location.href=""; break;
                case 3: location.href=""; break;
                case 4: location.href=""; break;
                case 5: location.href=""; break;
                case 6: location.href=""; break;
                case 7: location.href=""; break;
                case 8: location.href=""; break;
                case 9: location.href=""; break;
                case 10: location.href=""; break;
                case 11: location.href=""; break;
                case 12: location.href=""; break;
                case 13: location.href=""; break;
                case 14: location.href=""; break;
            }
        }
    </script>
</body>
</html>