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
  <script src="https://kit.fontawesome.com/046431a501.js" crossorigin="anonymous"></script>
</head>
<style>
  .page-link {
    color: #6363FF; 
    background-color: #fff;
    border: 1.5px solid #6363FF; 
  }
  
  .page-item.active .page-link {
   z-index: 1;
   color: #555;
   font-weight:bold;
   background-color: #f1f1f1;
   border-color: #ccc;
   
  }
  
  .page-link:focus, .page-link:hover {
    color: white;
    background-color: #6363FF; 
    border-color: #ccc;
  }
  </style>
<body>

  <%@ include file="../common/menubar.jsp" %>

    <br><br>
    <h2 style="margin-left: 5%;">도움이 필요하신가요?</h2><br>

    <table style="margin-left:10%;">
      <tr>
        <td>
          <div class="container">                      
              <div class="dropdown">
                <button type="button" class="btn btn-primary dropdown-toggle" style="background: #6363FF; border: none;" data-toggle="dropdown">
                  최신순
                </button>
                <div class="dropdown-menu">
                  <a class="dropdown-item" href="#">조회수</a>
                </div>
              </div>
          </div>
        </td>

      <td>
          <div class="container">
            <!-- 모달 여는 버튼 -->
            <button type="button" class="btn" data-toggle="modal" data-target="#myModal" style="float: right; background: lightgray; color: black;">
              1:1 문의하기 
            </button>
          
            <!-- 모달 -->
            <div class="modal" id="myModal">
              <div class="modal-dialog">
                <div class="modal-content">

                  <!-- 모달 Header -->
                  <div class="modalHeader" style="margin-top: 3%; margin-right: 3%; margin-left: 3%;">
                    <button type="button" class="close" data-dismiss="modal">&times;</button>
                    <h4 class=>1:1 문의하기</h4>
                    <div style="font-size: 10px;">문제가 해결되지 않으셨다면 1:1 로 문의하세요.<br>
                    문의 주신 내용은 48시간 내로 최대한 빠르게 답변드리도록 하겠습니다. 
                    남겨주신 이메일을 확인해주세요.</div>
                  </div>

                  <hr>
                  
                  <!-- Modal body -->
                  <div class="modal-body" style="padding: 3%;">
                    <input type="text" placeholder="제목" style="width: 100%;"><br><br>
                    <textarea style="width:100%;" cols="30" rows="10">내용</textarea><br><br>

                  
                    <input type="text" placeholder="답변받을 이메일 주소" style="width: 100%;">
                    <br>
                    
                    <div>
                    <input type="checkbox">
                    <span style="font-size: 10px;">개인정보 수집 및 이용에 동의합니다. 1:1 문의를 위한 최소한의 개인정보만을 수집하고 있습니다. 개인정보는 ‘개인정보 처리방침’에 근거하여 관리됩니다.</span>
                    </div>


                  </div>
                  
                  <!-- Modal footer -->
                  <div class="modal-footer">
                    <button type="button" class="btn" data-dismiss="modal" style="background: #6363FF; color: white;">문의하기</button>
                  </div>
                  
                </div>
              </div>
            </div>
          </div>
        </td>
      </tr>
    </table>

    <br>

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
        <ul class="pagination justify-content-center" style="margin:20px 0" >
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

    <div class="search-area" align="center">

      <input type="checkbox" id="total"><label for="total">전체</label>&nbsp;&nbsp;
      <input type="checkbox" id="mentor"><label for="mentor">멘토</label>&nbsp;&nbsp;
      <input type="checkbox" id="user"><label for="user">사용자</label>&nbsp;&nbsp;

      <input type="search" class="form-control-sm mr-3" style="border-color: #6363FF;" placeholder="검색어 입력"><i class="fa-solid fa-magnifying-glass"></i> 

    </div>

    <br><br><br>

  
      


      <br><br><br><br>
</body>
</html>