<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">

<link rel="stylesheet" href="${pageContext.request.contextPath}/resources/css/member/footer.css">
<link rel="stylesheet" href="${pageContext.request.contextPath}/resources/css/setting.css">

<title>Insert title here</title>
</head>
<body>

<div class="footer-wrap">
        <div class="footer-area">
            <div class="left-footer">
                <p>
                    <a href="">공지사항</a>
                    &nbsp&nbsp&nbsp&nbsp|&nbsp&nbsp&nbsp&nbsp
                    <a href="<%=request.getContextPath()%>/list.faq?cpage=1&sort=1">고객센터</a>
                    &nbsp&nbsp&nbsp&nbsp|&nbsp&nbsp&nbsp&nbsp
                    <a href="">이용약관</a>
                    &nbsp&nbsp&nbsp&nbsp|&nbsp&nbsp&nbsp&nbsp
                    <a href="">개인정보처리방침</a>
                </p>
                <p>
                    통신판매신고 번호 : 제2022-구디-0001호<br>
                    대표자명 : JOB을JAVA조 &nbsp&nbsp&nbsp&nbsp 사업자정보확인상호 : 니잡내잡 &nbsp&nbsp&nbsp&nbsp 소재지 : 서울 유선번호 : 1111-1111<br>
                    고객센터 : gdsemiproject@gmail.com
                </p>
                <p>
                    ⓒ 니JOB내JOB Connect All Right Reserved Powered by 니JOB내JOB
                </p>
            </div>
            <div class="right-footer">
                <button id="top-btn" onclick="topBtn();">TOP</button>
            </div>
        </div>
    </div>
    
    <script>
        //top버튼 클릭시 최상단으로 부드럽게 이동
        $(function(){
            $("#top-btn").click(function(){
                window.scrollTo({top : 0, behavior: 'smooth'}); 
            })
        })
    </script>

</body>
</html>