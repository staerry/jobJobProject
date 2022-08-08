<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<!-- css -->
<link rel="stylesheet" href="${pageContext.request.contextPath}/resources/css/setting.css">
<link rel="stylesheet" href="${pageContext.request.contextPath}/resources/css/classSelect/classFirstEnrollResult.css">

<!-- 부트스트랩 아이콘 -->
<link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap-icons@1.7.1/font/bootstrap-icons.css">

<!-- 부트스트랩 -->
<link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap@4.6.1/dist/css/bootstrap.min.css">
<script src="https://cdn.jsdelivr.net/npm/jquery@3.6.0/dist/jquery.slim.min.js"></script>
<script src="https://cdn.jsdelivr.net/npm/popper.js@1.16.1/dist/umd/popper.min.js"></script>
<script src="https://cdn.jsdelivr.net/npm/bootstrap@4.6.1/dist/js/bootstrap.bundle.min.js"></script>

</head>
<body>

	<%@ include file="../common/menubar.jsp" %>

    <div class="container">
        <div class="result-area">
            <i class="fas fa-gift" id="gift-icon"></i>
            <div><h2>✨ 깜짝 선물이 도착했습니다! 🎉 </h2></div>
            <br>
            <div class="coupon-gift">
                <div class="coupon-inner">
                    <div id="gift-title"><h3>첫 강의 구매 기념 할인쿠폰</h3></div>
                    <div id="gift-won"><h3><i class="fas fa-won-sign"></i> 20,000</h3></div>
                    <div id="gift-won"><h5>(유효기간 : 발급일로부터 한 달)</h5></div>
                </div>
            </div>
            <br>
            <br>
            <div class="button-area">
                <button id="return-main"><a href="<%= contextPath %>">메인 페이지로</a></button>
                <button id="go-mypage"><a href="<%= contextPath %>/myClassIng.my">내 강의 보러가기</a></button>
            </div>            
        </div>
        
        <br>
        <br>
        <br>
        <br>
        
    </div>


 	<%@ include file="../common/footer.jsp" %>
</body>
</html>