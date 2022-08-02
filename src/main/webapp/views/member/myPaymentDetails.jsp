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
  body {
    margin: 0;
    font-family: "Lato", sans-serif;
  }
  
  .sidebar {
    margin: 0;
    padding: 0;
    width: 200px;
    background-color: #f1f1f1;
    position: fixed;
    height: 100%;
    overflow: auto;
  }
  
  .sidebar a {
    display: block;
    color: black;
    padding: 16px;
    text-decoration: none;
  }
   
  .sidebar a.active {
    /* background-color: #6363FF; */
    /* color: white; */
  }
  
  .sidebar a:hover:not(.active) {
    background-color: #6363FF;;
    color: white;
  }
  
  div.content {
    margin-left: 200px;
    padding: 1px 16px;
    height: 1000px;
  }
  div a {
  text-decoration: none;
  color: white;
  font-size: 20px;
  padding: 15px;
  display:inline-block;
}
ul {
  display: inline;
  margin: 0;
  padding: 0;
}
ul li {display: inline-block;}
ul li:hover {background: #6363FF;;}
ul li:hover ul {display: block;}
ul li ul {
  position: absolute;
  width: 200px;
  display: none;
}
ul li ul li { 
  background:  #6363FF;; 
  display: block; 
}
ul li ul li a {display:block !important;} 
ul li ul li:hover {background:  #6363FF;;}
  
  @media screen and (max-width: 700px) {
    .sidebar {
      width: 100%;
      height: auto;
      position: relative;
    }
    .sidebar a {float: left;}
    div.content {margin-left: 0;}
  }
  
  @media screen and (max-width: 400px) {
    .sidebar a {
      text-align: center;
      float: none;
    }
  }
</style>
</head>
<body>
    <%@ include file="../common/menubar.jsp" %>
    <div class="sidebar">
      <ul>
        <li>
          <a class="active" href="#home">마이페이지</a>
          <ul>
            <li><a href="">개인정보수정</a></li>
            <li><a href="">탈퇴하기</a></li>
          </ul>
        </li>

      </ul>
      <a href="#news">강의</a>
      <a href="#contact">커뮤니티</a>
      <ul>
        <li>
          <a href="">결제</a>
          <ul>
            <li><a href="">결제내역</a></li>
            <li><a href="">내 쿠폰</a></li>
          </ul>
  
        </li>
      </ul>
  
    </div>
    
    <div class="container">
      <br><br><br>
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
                  <th colspan="2">결제방식</th>
                  <th colspan="2">승인일시</th>
                  <th colspan="2">결제금액</th>
                </tr>
              </thead>
              <tbody align="center">
                <tr>
                  <td colspan="2">카드</td>
                  <td colspan="2">xxxx-xx-xx</td>
                  <td colspan="2">23000원</td>
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