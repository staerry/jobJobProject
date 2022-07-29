<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">

<link rel="stylesheet" href="${pageContext.request.contextPath}/resources/css/admin/menubar.css">

<title>Insert title here</title>
</head>
<body>
    <div class="wrap">
        <div id="photo">
			<img src="${pageContext.request.contextPath}/resources/image/logo.png" alt="logo" width="100">
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
            <li onclick="linkbutton(5);">클래스관리</li>
            <li onclick="linkbutton(6);">게시글관리</li>
            <li onclick="linkbutton(15);">댓글관리</li>
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
        		// request.getContextPath();가 변수에 안담겨서 직접 사용합니다
                case 1: 
                	location.href="<%= request.getContextPath() %>/login.ad";
                	break;
                case 2:
                	// 페이지 이동용도 포워딩 서블릿만 작성 했습니다.
                	location.href="<%= request.getContextPath() %>/mentorApprovalListView.ad";
                	break;
                case 3:
                	location.href="<%= request.getContextPath() %>/mentorClassApprovalListView.ad";
                	break;
                case 4: 
                	location.href="<%= request.getContextPath() %>/mentorVodApprovalListView.ad";
                	break;
                case 5:
                	location.href="<%= request.getContextPath() %>/mentorClassListView.ad?cpage=1";
                	break;
                case 6:
                	location.href="<%= request.getContextPath() %>/postListView.ad?cpage=1";
                	break;
                case 7: 
                	location.href="<%= request.getContextPath() %>/noticeListView.ad?cpage=1";
                	break;
                case 8: 
                	location.href="<%= request.getContextPath() %>/faqListView.ad?cpage=1";
                	break;
                case 9:
                	location.href="<%= request.getContextPath() %>/mtmListView.ad?cpage=1";
                	break;
                case 10: 
                	location.href="<%= request.getContextPath() %>/couponManage.ad"; 
                	break;
                case 11: 
                	location.href="<%= request.getContextPath() %>/mentorInfo.li?p=1"; 
                	break;
                case 12: 
                	location.href="<%= request.getContextPath() %>/stuInfo.li?p=1"; 
                	break;
                case 13: 
                	location.href="<%= request.getContextPath() %>/paymentselect.bo"; 
                	break;
                case 14: 
                	location.href="<%= request.getContextPath() %>/refundRequest.li"; 
                	break;
                case 15: 
                	location.href="<%= request.getContextPath() %>/replyListView.ad?cpage=1"; 
                	break;
            }
        }
    </script>
</body>
</html>