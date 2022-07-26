<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap@4.6.1/dist/css/bootstrap.min.css">
<script src="https://cdn.jsdelivr.net/npm/jquery@3.6.0/dist/jquery.slim.min.js"></script>
<script src="https://cdn.jsdelivr.net/npm/popper.js@1.16.1/dist/umd/popper.min.js"></script>
<script src="https://cdn.jsdelivr.net/npm/bootstrap@4.6.1/dist/js/bootstrap.bundle.min.js"></script>
<style>
    button{background-color: anti;}
</style>
</head>
<body>
    <%@ include file="../common/menubar.jsp" %>
    <br><br>
    <div align="center" style="padding-top: 130px; padding-bottom: 130px;">
        <table>
            <tr>
                <th><h1><span style="color:#6363FF;">회원탈퇴</span>가 완료되었습니다.</h1></th>
            </tr>

            <tr>
                <td><hr></td>
            </tr>
            <tr>
                <th><h3>그동안 니JOB내JOB 서비스를 이용해 주셔서 감사합니다.
                    <br>
                    보다 나은 서비스로 다시 찾아 뵙겠습니다.</h3>
                </th>
            </tr>

            <tr align="center">
            	<!-- 메인페이지로 이동 -->
                <th><br><br><button class="btn btn-lg" style="background-color:#6363FF; color:white;">니JOB내JOB첫 화면</button></th>
            </tr>
        </table>
    </div>
    <br><br>
    <%@ include file="../common/footer.jsp" %>

</body>
</html>