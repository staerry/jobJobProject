<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<link rel="stylesheet" href="${pageContext.request.contextPath}/resources/css/setting.css">
<link rel="stylesheet" href="${pageContext.request.contextPath}/resources/css/userMypage/mainTemplate.css">


<link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap@4.6.1/dist/css/bootstrap.min.css">
<script src="https://cdn.jsdelivr.net/npm/jquery@3.6.0/dist/jquery.slim.min.js"></script>
<script src="https://cdn.jsdelivr.net/npm/popper.js@1.16.1/dist/umd/popper.min.js"></script>
<script src="https://cdn.jsdelivr.net/npm/bootstrap@4.6.1/dist/js/bootstrap.bundle.min.js"></script>
<title>Insert title here</title>
</head>
<style>

.content{

display:inline-flex;
padding:20px;

}
</style>
<body>
	<%@ include file="../common/menubar.jsp" %>
	
    <div class="main-web-wrap">
		        <div class="content">
		            <!--여기에 좌측 메뉴-->
		            <%@ include file="common/mypageSidebarMentor.jsp" %>
		      
        
		        <div class="content">
		            <!--여기에 컨텐츠-->
		   					
						 <div align="center" style="padding-top: 130px; padding-bottom: 130px; margin-left:40px;">
		        <table>
		            <tr>
		                <th><h3><span style="color:#6363FF;">클래스 등록</span>이 완료되었습니다.</h3></th>
		            </tr>
		
		            <tr>
		                <td><hr></td>
		            </tr>
		            <tr>
		                <th><h4>승인 여부는 마이페이지 나의클래스에서 확인 가능합니다.</h4>
		                </th>
		            </tr>
		
		            <tr align="center">
		            	<!-- 메인페이지로 이동 -->
		                <th><br><br><button class="btn btn-lg" onclick="location.href='<%= contextPath %>/views/mentorMyPage/mentorClassManage.jsp'" style="background-color:#6363FF; color:white;">나의 클래스로 가기</button></th>
		            </tr>
		        </table>
		    </div>
	     
   </div>
    
    	
</div>
     <br>
     <br> 
     <br>
     <br>
     <br>
     <br> 
<%@ include file="../common/footer.jsp" %>
</div>
</body>
</html>
