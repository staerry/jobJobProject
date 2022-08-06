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
<title>Insert title here</title>
<style>
	input{
		border-style: none;
        text-decoration-thickness: 3px; 
     }
     
    button{
        width: 300px;
        height: 30px;
        border-style: none;
        border-radius: 5px;
        background: #6363FF;
        color: white;
     }
        
    .outer{
         /* border: 3px solid rgb(190, 190, 190);  */
         margin: auto;
         box-sizing: border-box;
         width: 600px;
     }
     .outer a{
        text-decoration: none;
        color: #6363FF;
        font-size: 12px;
     }
     .container{
    /*border:1px solid blue;*/ 
    width:1190px;
    height:auto;
    display:flex;
    flex-direction:row;
    justify-content: space-between;
    padding:28px 16px 100px 34px;
}
</style>
</head>
<body>

	<%@ include file="../common/menubar.jsp" %>
	
	<br><br>

    <div class="container">

        <div class="outer col" align="center">
        
            <% if(loginUser == null){ %>
            <!-- 로그인 전 -->    
            <form action="<%= contextPath %>/secondLogin.do" method="post">
            <h2>회원 로그인</h2><br>

            <input type="text" name="userId" class="form-control" placeholder="이메일 주소 입력" style="width: 300px;" required><br>
            
            <input type="password" name="userPwd" class="form-control" placeholder="비밀번호 입력" style="width: 300px;" required><br>
            <button type="submit">로그인</button><br><br>
            </form>
            <% }else{ %>
            <!-- 로그인 후 -->
            <div>
                <br>
                <b><%= loginUser.getUserName() %></b>님의 방문을 환영합니다. <br><br>

                <div align="center">
                    <a href="<%=contextPath%>/myPage.my">마이페이지</a>&nbsp;&nbsp;
                    <a href="<%=contextPath%>/userlogout.me">로그아웃</a>
                </div>
                <br>
            </div>
            <% } %>
        </div>

    </div>
    
    <br><br>
		    
    <%@ include file="../common/footer.jsp" %>

</body>
</html>