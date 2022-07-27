<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="en">
<head>
  <title>Bootstrap Example</title>
  <meta charset="utf-8">
  <meta name="viewport" content="width=device-width, initial-scale=1">
  <link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap@4.6.1/dist/css/bootstrap.min.css">
  <script src="https://cdn.jsdelivr.net/npm/jquery@3.6.0/dist/jquery.slim.min.js"></script>
  <script src="https://cdn.jsdelivr.net/npm/popper.js@1.16.1/dist/umd/popper.min.js"></script>
  <script src="https://cdn.jsdelivr.net/npm/bootstrap@4.6.1/dist/js/bootstrap.bundle.min.js"></script>
</head>
<body>
    <%@ include file="../common/menubar.jsp" %>
    <br><br>
    <div class="container">
    <form action="/action_page.php">
        <div class="form-group">
        <label for="id"><h5>아이디 : </h5></label>
        <input type="email" class="form-control" placeholder="user01@naver.com" name="email" disabled>
        </div>
        <div class="form-group">
        <label for="pwd"><h5>현재 비밀번호 : </h5></label>
        <input type="password" id="pwd" class="form-control" placeholder="비밀번호를 입력해주세요" name="pwd">
        </div>
        <div class="form-group">
            <label for="newPwd"><h5>변경할 비밀번호 : </h5></label>
            <input type="password" id="newPwd" class="form-control" placeholder="비밀번호를 입력해주세요" name="newPwd">
        </div>
        <!--변경할 비밀번호 일치여부 차후 수정 예정-->
        <div class="form-group">
            <label for="checkPwd"><h5>변경할 비밀번호 확인 : </h5></label>
            <input type="password" id="checkPwd" class="form-control" placeholder="비밀번호를 입력해주세요" name="checkPwd">
        </div>
        <div class="form-group">
            <label for="email"><h5>이메일 : </h5></label>
            <input type="password" id="email" class="form-control" placeholder="이메일을 입력해주세요" name="email">
        </div>
        <div class="form-group">
            <label for="email"><h5>연락처 : </h5></label>
            <input type="tel" id="phone" class="form-control" placeholder="연락처를 입력해주세요" name="phone">
        </div>
        <div class="notice">
            <span>* 현직자의 소속 회사 / 직급 변경에 관한 문의는 1:1 게시판을 이용해주시기 바랍니다.</span>
        </div>
        <br><br>
        <div class="submit" align="center">
            <button type="submit" class="btn btn-lg" style="background-color: #6363FF; color: white;">수정하기</button>
        </div>
    </form>
    </div>
    <br><br>
    <%@ include file="../common/footer.jsp" %>
</body>
</html>