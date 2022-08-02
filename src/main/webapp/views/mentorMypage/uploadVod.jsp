 <%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
     <meta http-equiv="X-UA-Compatible" content="IE=edge">
      <meta name="viewport" content="width=device-width, initial-scale=1">
      
  <link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap@4.6.1/dist/css/bootstrap.min.css">
  <script src="https://cdn.jsdelivr.net/npm/jquery@3.6.0/dist/jquery.slim.min.js"></script>
  <script src="https://cdn.jsdelivr.net/npm/popper.js@1.16.1/dist/umd/popper.min.js"></script>
  <script src="https://cdn.jsdelivr.net/npm/bootstrap@4.6.1/dist/js/bootstrap.bundle.min.js"></script>
    
    <!-- css -->

<link rel="stylesheet" href="${pageContext.request.contextPath}/resources/css/setting.css">
<link rel="stylesheet" href="${pageContext.request.contextPath}/resources/css/mentorMyPage/uploadVod.css">
 <link rel="stylesheet" href="${pageContext.request.contextPath}/resources/css/userMyPage/mainTemplate.css">   
    <title>Document</title>
   
   <style>
   .right-content{
   margin-left:20px;}
   
   h3{
   font-size:20px;
   font-weight:bold;
   margin-bottom:20px;
   }
   #upload-file{
    margin-bottom:20px;
   }
   #cl-number{
   margin-bottom:20px;
   }
   
   #vod-name{
    margin-bottom:10px;
   }
   </style>


</head>
<body>

    <%@ include file="../common/menubar.jsp" %> 
    
    
    <div class="main-web-wrap">
	        <div class="left-content">
	            <!--여기에 좌측 메뉴-->
	            <%@ include file="common/mypageSidebarMentor.jsp" %>
	        </div>
        <div class="right-content">
         <!--여기에 컨텐츠-->
    		<div class=wrapper>
           <h2 style="color : #6363ff; margin-bottom:20px;"><b>강의 업로드</b></h2>

            <div class="class-body" id="cl-name"><h3>클래스명</h3>
            <p>일주일만에 자바 끝내기</p>
            </div>
            
            <div class="class-body" id="cl-number"><div><h3>강의회차</h3></div>
            <div>
                <input type="text" name="cl-number" disabled>
            </div>

            </div>
            <!-- 조회해서 뿌리기 -->

             <form>
            <div class="class-body" id="vod-name" style="display:flex; flex-direction:column"><div class="vodName"><h3>강의제목</h3> </div>
                <div class="vodName"><input type="text" name="videoname" id="videoname" placeholder="내용을 입력해주세요"></div>
       
            </div>

              <!--   <div class="class-body" id="upload-file" >  --> <h3>강의 영상 첨부</h3>
               
                      <!--   <div style="display:inline-flex; flex-direction:column;"> -->
                            <!-- 나란히 두려면 인라인 블록 div 밖 100%, 안 20% 80% -->
                            <div class="upload"><img src="썸네일이미지경로" width="200" height="150"></div>

                            <div class="upload"> <button type="button" class="btn btn-light" id="attach-file-btn" style="margin-top:10px" >첨부파일 선택</button></div>
                            <br>
                            
                            
                            <button type="button" class="btn btn-info" id="upload-btn" style="background-color:#6363FF; color:white">업로드</button>
                            </form>
                        </div>
                </div>
        </div>
      


<br><br><br>
 


    
        <!-- <h2>만료된 쿠폰</h2>    -->
     
     <br>
     <br> 
     <br>
     <br>
     <br>
     <br> 
<%@ include file="../common/footer.jsp" %>


    
</body>
</html>