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
     .outer{
            border: 3px solid rgb(190, 190, 190); 
            background: white;
            color: black;
            width: 600px;
            margin: auto;
            margin-top: 50px;
        }
    
        input{
                /* border-style: none; */
                text-decoration-line: underline;
                text-decoration-color: rgb(190, 190, 190);
                text-decoration-thickness: 3px;
            }
    
        button{
            width: 100px;
            height: 25px;
            border-style: none;
            border-radius: 5px;
            background: #6363FF;
            color: white;
        }
    
        #enroll-form table{margin: auto;}
        #enroll-form input{margin: 5px;}

</style>
</head>
<body>

	<%@ include file="../common/menubar.jsp" %>

     <div class="outer">
    
            <br>
    
            <h2 align="center">니JOB 내JOB에서<br>꿈을 이뤄보세요.</h2>
            <br>
    
            <form action="<%= contextPath %>/insert.me" method="post" id="enroll-form">
    
                <table>
    
                    <tr>
                        <td></td>
                        <td><input type="text" name="userName" placeholder="이름(실명)입력" required></td>
                        <td></td>
                    </tr>
    
                    <tr>
                        <td></td>
                        <td><input type="text" name="userId" maxlength="20" placeholder="이메일 주소 입력" required></td>
                        <td><button type="button">중복확인</button></td>
                    </tr>
    
                    <tr>
                        <td></td>
                        <td><input type="password" name="userPwd" maxlength="15" placeholder="비밀번호 입력" required></td>
                        <td></td>
                    </tr>
    
                    <tr>
                        <td></td>
                        <td><input type="password" maxlength="15" placeholder="비밀번호 재입력" required></td>
                        <td></td>
                    </tr>
    
                    <tr>
                        <td></td>
                        <td><input type="text" name="phone" placeholder="핸드폰번호 입력(-포함해서 입력)" required></td>
                        <td></td>
                    </tr>
                 
                </table>
    
                <br>
    
                <div align="center">
                    <button type="submit">다음</button>
                    <button type="reset">초기화</button>
                </div>
    
                <br><br>
    
            </form>
    
    
        </div>
    
    <br><br>
    
    <%@ include file="../common/footer.jsp" %>

</body>
</html>