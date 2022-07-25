<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>

	<%@ include file="../common/menubar.jsp" %>
	<br><br>
	<div align="center" style="padding-top: 191px; padding-bottom: 191px;">
		<table>

			<tr>
				<th colspan="2"><h1>안전한 회원탈퇴를 위해, 
				<span style="color: #6363FF;">비밀번호를확인해 주세요.</span></h1>
				<br>
				</th>
			</tr>
			<tr>
				<th><h2>아이디</h2></th>
				<td><h2>user01</h2></td>
			</tr>

			<tr>
				<th><h2>비밀번호</h2></th>
				<td><input type="text" placeholder="비밀번호 입력"><br></td>
			</tr>

			<tr align="center">
				<td colspan="2">
					<button type="reset" >탈퇴 취소</button>
					<button>확인</button>

				</td>

			</tr>
		</table>
	</div>
	<br><br>	
	<%@ include file="../common/footer.jsp" %>
</body>
</html>