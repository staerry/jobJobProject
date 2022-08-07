<%@page import="com.jj.mentorMyPage.model.vo.Vod"%>
<%@page import="java.util.List"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<% List<Vod> list = (List<Vod>) request.getAttribute("list"); %>
<% String classTitle = list.get(0).getCls().getClTitle(); %>
<% int classNo = list.get(0).getCls().getClNo(); %>
<% String classSubTitle = list.get(0).getCls().getClSubtitle(); %>

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
width: 90%;
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
.vod-list > ul > li{
    margin-bottom: 20px;
}
#pbtn{
    font-size:30px;
    margin-bottom: 50px;
}
.right-title{
    display: flex;
}
.right-title-content{
    width: 70%;
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
            <button class="btn btn-primary" style="background-color: #6363FF; border-color: #6363FF;" onclick="location.href='<%= contextPath %>/reviewEnroll.my?clNo=<%=classNo%>';">후기쓰러가기</button>
            <hr>
            <!--여기에 컨텐츠-->
            <div class="right-title">
                <div class="right-title-content">
                    <h2><%= classTitle %></h2>
                </div>

            </div>
            
            <h3><%= classSubTitle %></h3>
            
            <div id="vod-list"> 
                
                <ul>
                    <% for(Vod vod : list) {%>
                        <li>
                            <a href="${pageContext.request.contextPath}/userVodDetail.my?vodNo=<%= vod.getVodNo() %>">
                                <i id="pbtn" class="fa-regular fa-circle-play fa xs"></i> 
                                <span><%= vod.getVodTitle() %></span> 
                            </a>
                        </li>
                    <% } %>
                </ul>
                    
			            
            
					            
				            
				            
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