<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<style>
	input{
		border-style: none;
        text-decoration-line: underline;
        text-decoration-color: rgb(190, 190, 190);
        text-decoration-thickness: 3px;
     }
     
    button{
        width: 200px;
        height: 30px;
        border-style: none;
        border-radius: 5px;
        background: #6363FF;
        color: white;
     }
        
    .outer{
         border: 3px solid rgb(190, 190, 190); 
         margin: auto;
         box-sizing: border-box;
         width: 600px;
     }
     .outer a{
        text-decoration: none;
        color: #6363FF;
        font-size: 12px;
     }
</style>
</head>
<body>

	<%@ include file="../common/menubar.jsp" %>
	
	<br><br>

    <div class="outer" align="center">
    
    	<% if(loginUser == null){ %>
		<!-- 로그인 전 -->    
    	<form action="<%= contextPath %>/secondLogin.do" method="post">
    	<h2>로그인</h2><br>

        <input type="text" name="userId" placeholder="이메일 주소 입력" required><br><br>
        
        <input type="password" name="userPwd" placeholder="비밀번호 입력" required><br><br>
        <button type="submit">로그인</button><br><br>
        </form>
        <% }else{ %>
        <!-- 로그인 후 -->
        <div>
            <br>
        	<b><%= loginUser.getUserName() %></b>님의 방문을 환영합니다. <br><br>

            <div align="center">
                <a href="">마이페이지</a>&nbsp;&nbsp;
                <a href="<%=contextPath%>/userlogout.me">로그아웃</a>
            </div>
            <br>
        </div>
        <% } %>
    </div>
    
    <br><br>
		    
    <%@ include file="../common/footer.jsp" %>

</body>
</html>