<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<style>
     button{
        width: 200px;
        height: 30px;
        border-style: none;
        border-radius: 5px;
        background: #6363FF;
        color: white;
    }
    .container {
    width:1190px;
    height:auto;
    /*border:1px solid blue;*/
    padding:28px 16px 100px 34px;
    display:flex;
    justify-content: center;
    margin: auto;
    margin-top: 50px;
}
</style>
</head>
<body>

	<%@ include file="../common/menubar.jsp" %>

    <div class="container" align="center">

        <form action="<%= contextPath %>" method="post" id="pwd-area">

            <h2>비밀번호 재설정</h2>
            <span style="font-size: 10px; text-align: center;">계정으로 사용하는 이메일을 입력하면, 비밀번호 재설정 링크를 전송해 드립니다.</span><br><br>

            <input type="text" name="pwdEmail" placeholder="이메일 주소 입력"><br><br>

            <button type="submit" onclick="checkEmail();">비밀번호 재설정 이메일 발송</button>
        
            <script>

                function checkEmail(){
                    const $emailInput = $("#pwd-area input[name=pwdEmail]");

                    let regExp = /^[a-z0-9A-Z]+[!#$%&*+-=?^_`/(){|}~]*[a-zA-Z0-9]*@[\w]+\.[a-zA-Z0-9-]+[.]*[a-zA-Z0-9]+$/i;
               
                    if(regExp.test($emailInput.val())){
                        // 이메일 형식이 맞을 때는 alert 기다려라 화면 띄우기 => 메인화면으로 이동
                        alert("발송완료!");
                        location.href = "<%= contextPath %>";
                    }else{
                        // 이메일 다시 입력해주세요 alert => 이메일 칸 번쩍이도록
                        alert("이메일 다시 입력해주세요!");
                        return false;
                        $emailInput.focus();
                        
                    }
               
                }

            </script>

        </form>
    </div>
    
    <br><br>
    
    <%@ include file="../common/footer.jsp" %>

</body>
</html>