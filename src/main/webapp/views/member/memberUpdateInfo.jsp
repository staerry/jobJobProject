<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    
    
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
    

    <br><br>
    <div class="container">
    <form action="<%=contextPath%>/update.me">
        <div class="form-group">
        <label for="userId"><h5>아이디 : </h5></label>
        <input type="email" id="userId" class="form-control" readonly value="<%= loginUser.getUserId() %>" name="userId" >
        </div>
        <!--현재 비밀번호와 일치하는지 확인-->
        <div class="form-group">
        <label for="userPwd"><h5>현재 비밀번호 : </h5></label>
        <input type="password" id="userPwd" class="form-control" placeholder="비밀번호를 입력해주세요" name="userPwd" required>
        </div>
        <div class="form-group">
            <label for="userNewPwd"><h5>변경할 비밀번호 : </h5></label>
            <input type="password" id="userNewPwd" class="form-control" placeholder="비밀번호를 입력해주세요" name="userNewPwd" required onchange="check_pw()">
        </div>
        <div class="form-group">
            <label for="userCheckPwd"><h5>변경할 비밀번호 확인 : </h5></label>
            <input type="password" id="userCheckPwd" class="form-control" placeholder="비밀번호를 입력해주세요" name="userCheckPwd" required onchange="check_pw()">&nbsp;<span id="check"></span>
        </div>
        <div class="form-group">
            <label for="userEmail"><h5>이메일 : </h5></label>
            <input type="email" id="userEmail" class="form-control" value="<%= loginUser.getUserEmail() %>" name="userEmail">
        </div>
        <div class="form-group">
            <label for="userPhone"><h5>연락처 : </h5></label>
            <input type="tel" id="userPhone" class="form-control" value="<%= loginUser.getUserPhone() %>" name="userPhone">
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
                if(document.getElementById('userNewPwd').value != "&& document.getElementById('userCheckPwd').value!="){
                    if(document.getElementById('userNewPwd').value== document.getElementById('userCheckPwd').value){
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
         		if( "<%=loginUser.getUserPwd()%>" != $("input[name=userPwd]").val() ){
         			alert("현재 비밀번호가 일치하지 않습니다.");
         			return false;
         			
         	// 변경할 비밀번호와 변경할 비밀번호 재확인이 일치하지 않았을 경우 		
        		} if ( $("input[name=userNewPwd]").val() != $("input[name=userCheckPwd]").val() ){
             			alert("변경할 비밀번호가 일치하지 않습니다.");
             			return false;
        		}

           	}
            
            
            
    		
        </script>
    </div>
    <br><br>
    <%@ include file="../common/footer.jsp" %>
</body>
</html>