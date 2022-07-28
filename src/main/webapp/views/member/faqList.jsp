<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<script src="https://kit.fontawesome.com/ea8287c514.js" crossorigin="anonymous"></script>
<meta name="viewport" content="width=device-width, initial-scale=1">
  <link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap@4.6.1/dist/css/bootstrap.min.css">
  <script src="https://cdn.jsdelivr.net/npm/jquery@3.6.0/dist/jquery.slim.min.js"></script>
  <script src="https://cdn.jsdelivr.net/npm/popper.js@1.16.1/dist/umd/popper.min.js"></script>
  <script src="https://cdn.jsdelivr.net/npm/bootstrap@4.6.1/dist/js/bootstrap.bundle.min.js"></script>
</head>
<body>

    <br>
    <h2>도움이 필요하신가요?</h2><br>

    <div class="btn" style="float: right;">
        <button>1:1문의</button>
    </div>

    <div class="container">                      
        <div class="dropdown">
          <button type="button" class="btn btn-primary dropdown-toggle" data-toggle="dropdown">
            최신순
          </button>
          <div class="dropdown-menu">
            <a class="dropdown-item" href="#">조회수</a>
          </div>
        </div>
    </div>

    <div class="container">
                   
        <table class="table table-hover">
          <thead align="center">
            <tr>
              <th>NO</th>
              <th>내용</th>
            </tr>
          </thead>
          <tbody align="center">
            <tr>
              <td>1</td>
              <td>결제방법은 뭐가있나요?</td>
            </tr>
            <tr>
              <td>2</td>
              <td>현직자에서 강의자가 되려면?</td>
             
            </tr>
            <tr>
              <td>3</td>
              <td>질문내용</td>
            </tr>
            <tr>
               <td>4</td>
               <td>질문내용</td>
            </tr>
            <tr>
               <td>5</td>
               <td>질문내용</td>
            </tr>
            <tr>
                <td>6</td>
                <td>질문내용</td>
            </tr>
            <tr>
                <td>7</td>
                <td>질문내용</td>
            </tr>
            <tr>
                <td>8</td>
                <td>질문내용</td>
            </tr>
            <tr>
                <td>9</td>
                <td>질문내용</td>
            </tr>
            <tr>
                <td>10</td>
                <td>질문내용</td>
            </tr>
          </tbody>
        </table>
    </div>

    <div class="paging-area">
        <ul class="pagination">
            <li class="page-item"><a class="page-link" href="#"><<</a></li>
            <li class="page-item"><a class="page-link" href="#">1</a></li>
            <li class="page-item"><a class="page-link" href="#">2</a></li>
            <li class="page-item"><a class="page-link" href="#">3</a></li>
            <li class="page-item"><a class="page-link" href="#">4</a></li>
            <li class="page-item"><a class="page-link" href="#">5</a></li>
            <li class="page-item"><a class="page-link" href="#">>></a></li>
        </ul>
    </div>
    <br>

    <div class="community-list-header">
        <div class="community-search-bar">
            <input type="search" name="searchKeyword" id="search-keyword" placeholder="검색어를 입력하세요.">
            <button onclick=""><i class="far fa-search"></i>&nbsp;검색</button>
        </div>
    </div>

    <div class="community-sorting">
        <span class="community-sorting-order">
            <ul class="community-sorting-standard"> 
                <li onclick="">최신 순</li>
                <li onclick="">좋아요 순</li>
                <li onclick="">조회수 순</li>
            </ul>                
        </span>


</body>
</html>