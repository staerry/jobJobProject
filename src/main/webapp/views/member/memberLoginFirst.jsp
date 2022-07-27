<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%
	String contextPath = request.getContextPath(); // /job
	
	String alertMsg = (String)session.getAttribute("alertMsg");
%>
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
    }
    
 </style>
</head>

<body>

	<%@ include file="../common/menubar.jsp" %>
	
	<br><br>

	<h2 align="center">로그인</h2><br>

    <div id="area" align="center">
        <button type="submit" style="background: rgb(247, 230, 0); color:rgb(24, 22, 0)">카카오로 시작하기</button><br><br>
        <button type="submit" style="background: rgb(4, 207, 92); color: white;">네이버로 시작하기</button><br><br>
        <button type="submit" style="background: rgb(34, 34, 34); color: white">애플로 시작하기</button><br><br>
        <button type="submit" style="background: rgb(220, 78, 65); color: white;">구글로 시작하기</button><br><br>
        <button type="submit" style="background: rgb(224, 224, 224); color: rgb(24, 22, 0); cursor: pointer;" onclick="loginPage();">이메일로 로그인하기</button><br><br>
    </div>

    <div align="center">
        <span style="font-size: 8px;">이용약관 및 개인정보 처리방침 확인 후 동의합니다.</span><br>
        <span style="font-size: 10px; cursor:pointer;" onclick="enrollPage();">회원가입 하러가기!</span><br>
        <span style="font-size: 9px;">비밀번호 찾기</span><br><br>
    </div> 
    
    <script>
    	function loginPage(){
    		location.href = "<%= contextPath %>/userlogin.me";
    	}
    
    
    	function enrollPage(){
    		location.href = "<%= contextPath %>/loginEnrollForm.me";
    	}
    </script>
    
    <%@ include file="../common/footer.jsp" %>

</body>
</html>