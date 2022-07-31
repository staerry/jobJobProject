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
</head>
<body>

	<%@ include file="../common/menubar.jsp" %>
	<br><br>
	<div align="center" style="padding-top: 120px; padding-bottom: 120px;">
		<form action="<%= contextPath %>/deleteLast.me" method="post" id="delete-form">

		<table>

			<tr>
				<th colspan="2"><h1>안전한 회원탈퇴를 위해, 
				<span style="color: #6363FF;">비밀번호를 확인해 주세요.</span></h1>
				<br>
				</th>
			</tr>
			<tr>
				<th><h2>아이디</h2></th>
				<td><h2><%=loginUser.getUserId() %></h2></td>
			</tr>

			<tr>
				<th><h2>비밀번호</h2></th>
				<td><input type="password" placeholder="비밀번호를 입력해주세요" name="pwd"><br></td>
			</tr>

			<tr align="center">
				<td colspan="2">
					<br><br>
					<button type="reset" class="btn btn-primary" id="returnBtn" onclick="location.href='<%=contextPath%>/deleteFirst.me'">이전 단계</button>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
					<button class="btn btn-danger" id="nextBtn" onclick="return validatePwd();">확인</button>

				</td>

			</tr>
		</table>
		</form>
		
		
		<script>
       	function validatePwd(){
     		if( "<%=loginUser.getUserPwd()%>" != $("input[name=pwd]").val() ){
     			alert("비밀번호가 일치하지 않습니다.");
     			return false;
    		}
       	}
		
		</script>
		
		
	</div>

	<script>
		
	</script>

	<br><br>	
	<%@ include file="../common/footer.jsp" %>

</body>
</html>