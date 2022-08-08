<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    
<%
	// request.getAttribute로 다시 뽑기
	String userName = (String)request.getAttribute("userName");
	String userId = (String)request.getAttribute("userId");
	String userPwd = (String)request.getAttribute("userPwd");
	String userPhone = (String)request.getAttribute("userPhone");
%>
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
    width: 300px;
    height: 30px;
    border-style: none;
    border-radius: 5px;
    background: #6363FF;
    color: white;
    }
    
    .outer{
        /*border: 3px solid rgb(190, 190, 190);*/
        margin: auto;
        box-sizing: border-box;
        width: 450px;
    }

    .checkbox-group{
        box-sizing: border-box;
        margin: auto;
        width: 300px;
    }

    .inside-area>*{
        font-size: 13px;
    }
</style>
</head>
<body>

	<%@ include file="../common/menubar.jsp" %>
	
	<br><br>

    <div class="outer" align="center">
        <h2>Welcome!</h2>
        <h3>원활한 서비스 이용을 위해<br>약관에 동의해주세요.</h3><br>

        <form action="<%= contextPath %>/insert.me" method="post" id="userInfo">

            <input type="hidden" name="userName" value="<%=userName%>">
            <input type="hidden" name="userId" value="<%=userId%>">
            <input type="hidden" name="userPwd" value="<%=userPwd%>">
            <input type="hidden" name="userPhone" value="<%=userPhone%>">

            <div class="checkbox-group" align="left" style="font-size: 12px;">

                <input type="checkbox" id="checkAll">
                <label for="agreeAll">전체동의</label><br><br>

                <input type="checkbox" id="check1" class="normal">
                <label for="event">이벤트 정보 수신 동의(선택)</label><br>
                <span>맞춤 서비스 제공, 서비스 안내 및 이용권유, 
                 서비스 개선 및 신규 서비스 개발을 위한 통계 및 접속빈도 파악,
                 통계학적 특성에 따른 광고 게재, 이벤트 정보 및 참여기회 제공</span><br><br>

                <input type="checkbox" id="check2" class="normal requiredCheck">
                <label for="event">서비스 이용약관(필수)</label><br>
                <span>서비스에서 얻은 정보를 사이트의 사전승낙 없이 회원의 이용 
                이외의 목적으로 복제하거나 이를 변경, 출판 및 방송 등에 
                사용하거나 타인에게 제공하는 행위</span><br><br>

                <input type="checkbox" id="check3" class="normal requiredCheck">
                <label for="event">개인정보처리방침(필수)</label><br>
                <p>고객 가입의사 확인, 고객에 대한 서비스 제공에 따른 본인 식별.인증, 
                회원자격 유지.관리, 물품 또는 서비스 공급에 따른 금액 결제, 
                물품 또는 서비스의 공급.배송</p><br>

            </div>
            
            <span style="font-size: 10px;">서비스 이용약관과 개인정보처리방침에 모두 동의해주세요</span><br><br>
            
            <button type="submit" disabled>시작하기</button><br><br>

        </div>
    </form>
    
    <script>
    
    
	    $(".checkbox-group").on("click", "#checkAll", function(){
	        $(this).parents(".checkbox-group").find("input").prop("checked", $(this).is(":checked"));
	    });
	
	    $(".checkbox-group").on("click", ".normal", function(){
	        var isChecked = true;
	
	        $(".checkbox-group .normal").each(function(){
	            isChecked = isChecked && $(this).is(":checked");
	        });
	
	        $("#checkAll").prop("checked", isChecked);
	
	    });
    
    	
   		$(function(){
   			$("#userInfo :checkbox").change(function(){
   				let flag = true;

                   $(".requiredCheck").each(function(){
                       if(!$(this).prop("checked")){
                           flag = false;
                       }
                   })
                   if(flag == false){ // 체크 안됨 => 가입 안됨, disablaed 유지
                       $('button').attr('disabled', 'disabled');
                   }else{ // 체크 됨 => 가입 성공, disabled 풀기
                        $('button').removeAttr("disabled");
                   }
   			})
   		})
    	


    </script>
    
    <br><br>
    
    <%@ include file="../common/footer.jsp" %>

</body>
</html>