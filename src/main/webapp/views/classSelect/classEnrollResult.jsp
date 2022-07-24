<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<!-- css -->
<link rel="stylesheet" href="../../resources/css/setting.css">
<link rel="stylesheet" href="../../resources/css/classSelect/classEnrollResult.css">

<!-- 부트스트랩 아이콘 -->
<link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap-icons@1.7.1/font/bootstrap-icons.css">

<!-- 부트스트랩 -->
<link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap@4.6.1/dist/css/bootstrap.min.css">
<script src="https://cdn.jsdelivr.net/npm/jquery@3.6.0/dist/jquery.slim.min.js"></script>
<script src="https://cdn.jsdelivr.net/npm/popper.js@1.16.1/dist/umd/popper.min.js"></script>
<script src="https://cdn.jsdelivr.net/npm/bootstrap@4.6.1/dist/js/bootstrap.bundle.min.js"></script>

</head>
<body>

	<%-- <%@ include file="../common/menubar.jsp" %> --%>

    <div class="container">
        <div class="result-area">
                <i class="bi bi-check2-circle bi" id="check-icon"></i>
            
            <h1>수강신청이 완료되었습니다.</h1>
            <br>
            <h2>지금부터 모든 강의 콘텐츠를 이용하실 수 있습니다.</h2>
            <br>
            <br>
            <div class="button-area">
                <button id="return-main"><a href="">메인 페이지로</a></button>
                <button id="go-mypage"><a href="">내 강의 보러가기</a></button>
            </div>            
        </div>
    </div>


<%-- 	<%@ include file="../common/footer.jsp" %> --%>
</body>
</html>