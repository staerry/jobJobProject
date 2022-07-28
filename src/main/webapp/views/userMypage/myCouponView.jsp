 <%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
      <meta name="viewport" content="width=device-width, initial-scale=1">
      
  <link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap@4.6.1/dist/css/bootstrap.min.css">
  <script src="https://cdn.jsdelivr.net/npm/jquery@3.6.0/dist/jquery.slim.min.js"></script>
  <script src="https://cdn.jsdelivr.net/npm/popper.js@1.16.1/dist/umd/popper.min.js"></script>
  <script src="https://cdn.jsdelivr.net/npm/bootstrap@4.6.1/dist/js/bootstrap.bundle.min.js"></script>
    
    <!-- css -->
<link rel="stylesheet" href="${pageContext.request.contextPath}/resources/css/userMypage/myCouponView.css">
    
    <title>Document</title>
   


</head>
<body>

    <%@ include file="../common/menubar.jsp" %> 
 
 
 
<div class="container-all">  

    <div class="coupon-head"> <h2>내 쿠폰</h2>
 <br><hr>
        
        <div class="coupon-head-bottom"><h3>사용 가능한 쿠폰</h3>  </div>
        <!-- 현재 로그인한 사용자의 USER_NO과 일치하는 ISUCPNO TABLE 정보 가져오기 ( 조건: CP_STATUS가 'Y'인 쿠폰만 조회해올 것 ) -->
        <div class="coupon-head-bottom" id="coupon-quantity"><p style= "color:grey">x개</p></div> 
       
    </div>   

<div class="coupon-body" >
            <div class="coupon-body-left">

                <div class="coupon1"> <p id="cpNo">[이벤트] 일주일만에 자바 정복하기 클래스 할인권</p></div> <br>
                <!-- COUPON TABLE의 CP_NO, ISUCPNO TABLE의 CP_NO 둘중 아무거나 조회 -->
                
                
                    <div class="coupon1" id="discount"> <p>20,000원 할인</p></div>   
                    
                    <div class="coupon1" id="expire-date"><p>기한 : 2022.8.10.11:59 까지</p></div>
                    <!-- style="margin-left:auto;" -->
                    <!-- 할인 : COUPON TABLE의 DISCOUNT 조회  -->
                    <!-- 기한 : ISUCPNO TABLE 의 CP_ENDDATE -->
               
            </div>

            <!--     <div class="coupon-body-right" style="float:right;"><button id="use-btn" type="submit">사용하러 가기</button> </div> -->
                    <button type="button" class="btn btn-primary btn-lg" button id="use-btn" >사용하기</button>
</div>

<div class="coupon-body" >
    <div class="coupon-body-left">

        <div class="coupon1"> <p p id="cpNo">[이벤트] 일주일만에 자바 정복하기 클래스 할인권</p></div> <br>
        <!-- COUPON TABLE의 CP_NO, ISUCPNO TABLE의 CP_NO 둘중 아무거나 조회 -->
        
        <div class="coupon1" id="discount"> <p>20,000원 할인</p></div>   
        
        <div class="coupon1" id="expire-date"><p>기한 : 2022.8.10.11:59 까지</p></div>
        <!-- style="margin-left:auto;" -->
        <!-- 할인 : COUPON TABLE의 DISCOUNT 조회  -->
        <!-- 기한 : ISUCPNO TABLE 의 CP_ENDDATE -->
    
    </div>

    <!--     <div class="coupon-body-right" style="float:right;"><button id="use-btn" type="submit">사용하러 가기</button> </div> -->
            <button type="button" class="btn btn-primary btn-lg" button id="use-btn" >사용하기</button>
</div>

<div class="coupon-body" >
<div class="coupon-body-left">

    <div class="coupon1"> <p p id="cpNo">[이벤트] 일주일만에 자바 정복하기 클래스 할인권</p></div> <br>
    <!-- COUPON TABLE의 CP_NO, ISUCPNO TABLE의 CP_NO 둘중 아무거나 조회 -->
    
    <div class="coupon1" id="discount"> <p>20,000원 할인</p></div>   
    
    <div class="coupon1" id="expire-date"><p>기한 : 2022.8.10.11:59 까지</p></div>
    <!-- style="margin-left:auto;" -->
    <!-- 할인 : COUPON TABLE의 DISCOUNT 조회  -->
    <!-- 기한 : ISUCPNO TABLE 의 CP_ENDDATE -->

</div>

<!--     <div class="coupon-body-right" style="float:right;"><button id="use-btn" type="submit">사용하러 가기</button> </div> -->
        <button type="button" class="btn btn-primary btn-lg" button id="use-btn" >사용하기</button>
</div>



</div>




    
        <!-- <h2>만료된 쿠폰</h2>    -->
     
     
     <br> 
     <br>
     <br>
     <br>
     <br> 
<%@ include file="../common/footer.jsp" %>
    
</body>
</html>