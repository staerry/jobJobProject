<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Document</title>
    <link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap@4.6.1/dist/css/bootstrap.min.css">
<script src="https://cdn.jsdelivr.net/npm/jquery@3.6.0/dist/jquery.slim.min.js"></script>
<script src="https://cdn.jsdelivr.net/npm/popper.js@1.16.1/dist/umd/popper.min.js"></script>
<script src="https://cdn.jsdelivr.net/npm/bootstrap@4.6.1/dist/js/bootstrap.bundle.min.js"></script>
<style>
  thead{
    background-color: whitesmoke;
  }
</style>
</head>
<body>
    <%@ include file="../common/menubar.jsp" %>
    <br><br>
    <div class="container">
        <h2>결제내역 > <span style=" color:#6363FF;">결제 상세내역</span></h2>
        <br>
        <h4>주문정보</h4>
          <table class="table table-hover table-bordered">
            <thead align="center">
              <tr>
                <th>주문번호</th>
                <th>주문상품</th>
                <th>결제금액</th>
                <th>상태</th>
              </tr>
            </thead>
            <tbody align="center">
              <tr>
                <td>xxxxxx</td>
                <td>
                  <img src="../../resources/image/mentorSelect/sampleProfile.jpeg" class="img-thumbnail" alt="Cinque Terre" width="100" height="100"> 
                  <span>&nbsp;&nbsp;&nbsp;남궁성의 누구나 쉽게 따라할 수 있는 A-Z까지 JAVA의 모든 것</span>
                </td>
                <td>
                  <p>판매가 : 25000원</p>
                  <p>쿠폰할인 : -2000원</p>
                  <hr>
                  <p>결제금액 : 23000원</p>
                </td>
                <td>
                  <span>결제완료</span>
                </td>
              </tr>
          </table>

          <br>
          <h4>결제정보</h4>
            <table class="table table-hover table-bordered">
              <thead align="center">
                <tr>
                  <th>결제방식</th>
                  <th>카드명</th>
                  <th>카드번호</th>
                  <th>할부</th>
                  <th>승인일시</th>
                  <th>결제금액</th>
                </tr>
              </thead>
              <tbody align="center">
                <tr>
                  <td>카드</td>
                  <td>현대카드</td>
                  <td>512345******6571</td>
                  <td>일시불</td>
                  <td>xxxx-xx-xx</td>
                  <td>23000원</td>
                </tr>
            </table>

            <br>
            <h4>주문자정보</h4>
              <table class="table table-hover table-bordered">
                  <tr>
                    <th style="background-color:whitesmoke; width: 80px;">이름</th>
                    <td>xxx</td>
                  </tr>
                  <tr>
                    <th style="background-color:whitesmoke">연락처</th>
                    <td>010-xxxx-xxxx</td>
                  </tr>
                  <tr>
                    <th style="background-color:whitesmoke">이메일</th>
                    <td>user01@naver.com</td>
                  </tr>
              </table>

  </div>

 <%@ include file="../common/footer.jsp" %>
</body>
</html>