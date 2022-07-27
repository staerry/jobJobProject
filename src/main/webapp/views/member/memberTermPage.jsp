<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    
<%
	// request.getAttribute로 다시 뽑기 
%>
<% 
	String contextPath = request.getContextPath(); 
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

        <div class="checkbox-group" align="left">

            <input type="checkbox" id="checkAll">
            <label for="agreeAll">전체동의</label><br><br>

            <input type="checkbox" id="check1" class="normal">
            <label for="event">이벤트 정보 수신 동의(선택)</label><br>
            <span>시들어 가는 노년에게서 구하지 못할 바이며 <br>
                오직 우리 청춘에서만 구할 수 있는 것이다<br>
                청춘은 인생의 황금시대다 </span><br><br>

            <input type="checkbox" id="check2" class="normal">
            <label for="event">서비스 이용약관(필수)</label><br>
            <span>시들어 가는 노년에게서 구하지 못할 바이며 <br>
                    오직 우리 청춘에서만 구할 수 있는 것이다<br>
                    청춘은 인생의 황금시대다 </span><br><br>

            <input type="checkbox" id="check3" class="normal">
            <label for="event">개인정보처리방침(필수)</label><br>
            <p>시들어 가는 노년에게서 구하지 못할 바이며 <br>
                오직 우리 청춘에서만 구할 수 있는 것이다<br>
                청춘은 인생의 황금시대다 </p><br>

        </div>
        
        <span style="font-size: 10px;">서비스 이용약관과 개인정보처리방침에 모두 동의해주세요</span><br><br>
        
        <button onclick="enrollSuccess();" disabled>시작하기</button><br><br>

    </div>
    
    
    <form action="insert시키는 servleturl매핑값" method="post" id="ttt">
    	<!-- input type="hidden" name="" value="이전페이지에서넘어온값" -->
    </form>
    
    <script>
    	function enrollSuccess(){
    		// 전체동의 or check2랑 check3 동의 되면 
    		// => 가입완료 alert 뜨고 메인페이지로 이동
    		
    		// check2랑 check3 동의안되면 가입 실패
    		// =>  alert뜨고 약관 동의 페이지 그대로
    		
    		let check1 = $("#check1");
    		
    		
    		
    		// 체크박스가 다 제대로 체크되었을 경우 
    		$("#ttt").submit();
    		
    		
    		
    		
    		
    	}

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

    </script>
    
    <br><br>
    
    <%@ include file="../common/footer.jsp" %>

</body>
</html>