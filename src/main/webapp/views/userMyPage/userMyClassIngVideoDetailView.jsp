<%@page import="com.jj.mentorMyPage.model.vo.Vod"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%  Vod vod = (Vod) request.getAttribute("vod"); %>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<!-- <script src="https://kit.fontawesome.com/d9c0959348.js" crossorigin="anonymous"></script> -->
<link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap@4.6.1/dist/css/bootstrap.min.css"> 
 <script src="https://cdn.jsdelivr.net/npm/popper.js@1.16.1/dist/umd/popper.min.js"></script> 
 <script src="https://cdn.jsdelivr.net/npm/bootstrap@4.6.1/dist/js/bootstrap.bundle.min.js"></script> 
<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.6.0/jquery.min.js"></script>



<link rel="stylesheet" href="${pageContext.request.contextPath}/resources/css/setting.css">
<link rel="stylesheet" href="${pageContext.request.contextPath}/resources/css/userMyPage/mainTemplate.css">
<title>Insert title here</title>
</head>

<style>
.main-web-wrap{
display:flex;
margin:80px;
margin-right:80px;
}
.right-content{
margin: 0px 20px 80px 100px;
}
h2{
font-weight:40px;
color : #6363ff;
font-weight:bolder;
margin-bottom:20px;

}

h3{
font-weight:bolder;
margin-bottom:40px;
}

#play-btn{
color:#6363FF; 
color:white;
margin:20px 0px;
}

#pbtn{
    font-size:30px;
    margin-bottom: 50px;
}

</style>
<body>
	<%@ include file="../common/menubar.jsp" %>
	
    <div class="main-web-wrap">
        <div class="left-content">
            <!--여기에 좌측 메뉴-->
            <%@ include file="common/myPageSidebarUser.jsp" %>
        </div>
        
        
        <div class="right-content">
            <!--여기에 컨텐츠-->
            
            
            <h2><%= vod.getCls().getClTitle() %></h2>
            
            <h3><%= vod.getVodTitle() %></h3>
            
             <div id="vod-view"> 
                <video width="960" height="480" controls>
                    <source src="<%= vod.getVodFile() %>" type="video/mp4">
                </video>
		           
            </div> 
            
        </div>
    </div>

    
    
    <script>
    /* 바디오 불펌 방지...? */

$(document).ready(function(){

   $('비디오선택자').bind('contextmenu',function() { return false; });

});

</script>
    
    
     
     <br>
     <br> 
     <br>
     <br>
     <br>
     <br> 
<%@ include file="../common/footer.jsp" %>
</body>
</html>