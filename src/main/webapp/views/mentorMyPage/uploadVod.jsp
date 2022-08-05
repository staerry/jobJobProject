<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<link rel="stylesheet" href="${pageContext.request.contextPath}/resources/css/setting.css">
<link rel="stylesheet" href="${pageContext.request.contextPath}/resources/css/userMypage/mainTemplate.css">
<script src="https://kit.fontawesome.com/d9c0959348.js" crossorigin="anonymous"></script>
<title>Insert title here</title>
</head>
<style>
.content{
display:inline-flex;
margin-left:60px;}
#hi{
margin-left:60px;
width:500px;}
#hi > div{
margin-bottom:30px;}
</style>
<body>
	<%@ include file="../common/menubar.jsp" %>
	
    <div class="main-web-wrap">
        <div class="content">
            <!--여기에 좌측 메뉴-->
            <%@ include file="common/mypageSidebarMentor.jsp" %>
        </div>
        <div class="content">
            <!--여기에 컨텐츠-->
          <div class=wrapper id="hi">
           <h2 style="color : #6363ff; margin-bottom:20px;"><b>강의 업로드</b></h2>

            <div class="class-body" id="cl-name"><h3>클래스명</h3>
            <p>${clTitle}</p>
            </div>
            <form action="<%=contextPath%>/uploadVod.my"
                method="post"
                enctype="multipart/form-data"
                accept-charset="UTF-8">
            <div class="class-body" id="cl-number"><div><h3>${vodNo}회차 강의 등록</h3></div>
            
                
        

            </div>
            <!-- 조회해서 뿌리기 -->

            
            <div class="class-body" id="vod-name" style="display:flex; flex-direction:column"><div class="vodName"><h3>이번 강의의 제목</h3> </div>
                <div class="vodName">
                    <!-- <input type="text" name="videoname" id="videoname" placeholder="내용을 입력해주세요"> -->
                    <input type="text" name="vodTitle" value="testSubject" placeholder="제목을 입력하세요.">
                </div>
       
            </div>
               
            		 <h3 style="margin-top:30px;">강의 영상 첨부</h3>
                    
                      <!--   <div style="display:inline-flex; flex-direction:column;"> -->
                            <!-- 나란히 두려면 인라인 블록 div 밖 100%, 안 20% 80% -->
                            <!-- <div class="upload"><img src="썸네일이미지경로" width="200" height="150"></div> -->

                            <div class="upload"> 
                                <input type="file" name="vodFile" style="cursor:pointer;">
                                <!-- <button type="button" class="btn btn-light" id="attach-file-btn" style="margin-top:10px" >첨부파일 선택</button> -->
                            </div>
                            <br>
                            
                            <input type="hidden" name="clNo" value="${clNo}">
                            <input type="hidden" name="clTitle" value="${clTitle}">
                            <button type="submit" onclick="alert('성공적으로 등록되었습니다. 승인을 기다려 주세요')" class="btn btn-info" id="upload-btn" style="background-color:#6363FF; color:white">업로드</button>
                
                        <!-- </div> -->
            </div>
            </form>
        </div>
     
    
   
	
	<br>
    
    
    
     
    
     
     <br>
     <br> 
     <br>
     <br>
     <br>
     <br> 
<%@ include file="../common/footer.jsp" %>
</body>
</html>