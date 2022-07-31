<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    
<%
	//request.getAttribute로 다시 뽑기
	//String userName = (String)request.getAttribute("userName");
	String userId = (String)request.getAttribute("userId");
	String userPwd = (String)request.getAttribute("userPwd");
	//String userPhone = (String)request.getAttribute("userPhone");
%>
    
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
	<%
	
		//String userId = loginUser.getUserId();
		//String userName = loginUser.getUserName();
		//String phone = (loginUser.getPhone() == null) ? "" : loginUser.getPhone();
		//String email = (loginUser.getEmail() == null) ? "" : loginUser.getEmail();
		//String address = (loginUser.getAddress() == null) ? "" : loginUser.getAddress();
		//String interest = (loginUser.getInterest() == null) ? "" : loginUser.getInterest();
	%>

    
    <br><br>
    <div class="container">
    <form action="<%=contextPath%>">
        <div class="form-group">
        <label for="id"><h5>아이디 : </h5></label>
        <input type="email" class="form-control" placeholder="<%= loginUser.getUserId() %>" name="id" disabled>
        </div>
        <!--현재 비밀번호와 일치하는지 확인-->
        <div class="form-group">
        <label for="pwd"><h5>현재 비밀번호 : </h5></label>
        <input type="password" id="pwd" class="form-control" placeholder="비밀번호를 입력해주세요" name="pwd">
        </div>
        <div class="form-group">
            <label for="newPwd"><h5>변경할 비밀번호 : </h5></label>
            <input type="password" id="newPwd" class="form-control" placeholder="비밀번호를 입력해주세요" name="newPwd">
        </div>
        <div class="form-group">
            <label for="checkPwd"><h5>변경할 비밀번호 확인 : </h5></label>
            <input type="password" id="checkPwd" class="form-control" placeholder="비밀번호를 입력해주세요" name="checkPwd" onchange="check_pw()">&nbsp;<span id="check"></span>
        </div>
        <div class="form-group">
            <label for="email"><h5>이메일 : </h5></label>
            <input type="email" id="email" class="form-control" placeholder="이메일을 입력해주세요" name="email">
        </div>
        <div class="form-group">
            <label for="phone"><h5>연락처 : </h5></label>
            <input type="tel" id="phone" class="form-control" placeholder="연락처를 입력해주세요" name="phone">
        </div>
        <div class="notice">
            <span>* 현직자의 소속 회사 / 직급 변경에 관한 문의는 1:1 게시판을 이용해주시기 바랍니다.</span>
        </div>
        <br><br>
        <div class="submit" align="center">
            <button type="submit" class="btn btn-lg" style="background-color: #6363FF; color: white;" onclick="return validatePwd()">수정하기</button>
        </div>
    </form>

        <script>
            function check_pw(){
                if(document.getElementById('newPwd').value != "&& document.getElementById('checkPwd').value!="){
                    if(document.getElementById('newPwd').value== document.getElementById('checkPwd').value){
                        document.getElementById('check').innerHTML='비밀번호가 일치합니다.';
                        document.getElementById('check').style.color='blue';
                    }else{
                        document.getElementById('check').innerHTML='비밀번호가 일치하지 않습니다.';
                        document.getElementById('check').style.color='red';
                    }
                }
            }
            
            // 현재 비밀번호가 틀렸을 경우
         	function validatePwd(){
         		if( "<%=loginUser.getUserPwd()%>" != $("input[name=pwd]").val() ){
         			alert("현재 비밀번호가 일치하지 않습니다.");
         			return false;
         			
         	// 변경할 비밀번호와 변경할 비밀번호 재확인이 일치하지 않았을 경우 		
        		} if ( $("input[name=newPwd]").val() != $("input[name=checkPwd]").val() ){
             			alert("변경할 비밀번호가 일치하지 않습니다.");
             			return false;
        		}else{
                    alert("회원정보가 성공적으로 수정되었습니다.");
                }

           	}
            
            
            
    		
        </script>
    </div>
    <br><br>
    <%@ include file="../common/footer.jsp" %>
</body>
</html>