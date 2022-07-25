<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<style>
    .outer{
        margin: auto;
        margin-top: 50px;
    }
     button{
        width: 200px;
        height: 30px;
        border-style: none;
        border-radius: 5px;
        background: #6363FF;
        color: white;
    }
</style>
</head>
<body>

	<%@ include file="../common/menubar.jsp" %>

    <div class="outer" align="center">

        <h2>비밀번호 재설정</h2>
        <span style="font-size: 10px; text-align: center;">계정으로 사용하는 이메일을 입력하면, 비밀번호 재설정 링크를 전송해 드립니다.</span><br><br>

        <input type="text" placeholder="이메일 주소 입력"><br><br>

        <button>비밀번호 재설정 이메일 발송</button>

    </div>
    
    <br><br>
    
    <%@ include file="../common/footer.jsp" %>

</body>
</html>