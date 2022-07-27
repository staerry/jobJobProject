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
</head>
<body>
    <%@ include file="../common/menubar.jsp" %>
    <br><br>
    <div class="container">
        <h2>결제내역</h2>
        <br>
        <h4>강의리스트로 조회</h4>
        <br>
        <form action="/myPostSearch.do">
          <div class="form-check-inline">
            <label class="form-check-label" for="all">
              <input type="radio" class="form-check-input" name="searchKeyword" value="all" checked>전체
            </label>
          </div>
          <div class="form-check-inline">
            <label class="form-check-label" for="QnA">
              <input type="radio" class="form-check-input" name="searchKeyword" value="className">강의명
            </label>
          </div>
          <div class="form-check-inline">
            <label class="form-check-label" for="study">
              <input type="radio" class="form-check-input" name="searchKeyword" value="tutorName">강사명
            </label>
          </div>
          <br>
          <input type="text" placeholder="이름으로 검색">&nbsp;
          <button type="submit" class="btn" style="background-color: #6363FF; color: white;">검색</button>
          <br>

          <!--검색결과 조회 시 -->
          <br>
          <span>검색결과 조회</span>
          <br><br>
          <table class="table table-hover">
            <thead align="center">
              <tr>
                <th>번호</th>
                <th>강의명</th>
                <th>강사명</th>
                <th>결제일자</th>
                <th>결제내역</th>
              </tr>
            </thead>
            <tbody align="center">
              <tr>
                <td>10</td>
                <td>남궁성의 java A-Z까지</td>
                <td>남궁성</td>
                <td>xxxx-xx-xx</td>
                <td>
                  <button class="btn" style="background-color: #6363FF; color: white;">결제상세내역</button>
                  <button class="btn btn-danger">환불신청</button>
                
                </td>
              </tr>
              <tr>
                <td>10</td>
                <td>남궁성의 java A-Z까지</td>
                <td>남궁성</td>
                <td>xxxx-xx-xx</td>
                <td>
                  <button class="btn" style="background-color: #6363FF; color: white;">결제상세내역</button>
                  <button class="btn btn-danger">환불신청</button>
                </td>
              </tr>
              <tr>
                <td>10</td>
                <td>남궁성의 java A-Z까지</td>
                <td>남궁성</td>
                <td>xxxx-xx-xx</td>
                <td>
                  <button class="btn" style="background-color: #6363FF; color: white;">결제상세내역</button>
                  <button class="btn btn-danger">환불신청</button>
                </td>
              </tr>
    
            </tbody>
          </table>
 
        <div class="paging-area" style="margin:auto;">
            <ul class="pagination justify-content-center" style="margin:20px 0">
                <li class="page-item disabled"><a class="page-link" href="#">Previous</a></li>
                <li class="page-item"><a class="page-link" href="#">1</a></li>
                <li class="page-item"><a class="page-link" href="#">2</a></li>
                <li class="page-item"><a class="page-link" href="#">3</a></li>
                <li class="page-item"><a class="page-link" href="#">4</a></li>
                <li class="page-item"><a class="page-link" href="#">5</a></li>
                <li class="page-item"><a class="page-link" href="#">Next</a></li>
              </ul>
        </div>

    </form>
</div>

 <%@ include file="../common/footer.jsp" %>
</body>
</html>