<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>

<link rel="stylesheet" href="${pageContext.request.contextPath}/resources/css/admin/admin-setting.css">
<link rel="stylesheet" href="${pageContext.request.contextPath}/resources/css/setting.css">
<link rel="stylesheet" href="${pageContext.request.contextPath}/resources/css/mentorMypage.mentorQnA.css">



 <!--  <style>
        .wrap{
            width:1000px;
            margin-left:20px;
        }

        .head{
            display:flex;
            width:600px;
        }
        .head>h4{
            font-weight:500;
            margin-left:auto;
            color:grey;
        }

        #text-body{
        width:600px;
        height:350px;
        resize:none;
        /* border:solid 0.5px grey; */
        border: 1px solid #ba68c8;
        
        border-radius: 5px;
        
        padding:20px;


        }

        #text-body:focus {
    border: 1px solid #ba68c8;
    box-shadow: 0 0 0 0.2rem rgba(186, 96, 202, 0.25);
}
        .answer-wrapper{
         display:inline-block; height:300px; margin-top:10px; box-sizing:border-box"
        }

        #num{
            color:grey;
            margin-left:10px;
        }
        .body>input{
            width:600px;
            /* height:50px; */
        }

        #mentor-profile-photo-container{
      display:flex; width:500px; height:150px; margin:40px 0px 40px 20px; box-sizing:border-box; margin-right:auto;
        
        }

        #mentor-profile-photo{
            width:30%;
            height:auto;
        }
        #name-company-container{

        display:flex; flex-direction:column; 
        }

        #nameandcompany{
             display:flex; flex-direction:row;height:15%;
        }


        #nameandcompany, #answer-bottom{
            color:grey;
            margin: auto 0 0;
        }


        /* 음 */
       
    /* #6363FF */




    </style> -->
    
    </head>
    
		<body>
		
		    <%@ include file="../common/menubar.jsp" %>
		    <div class="content-wrap">
			    <!--이 부분에 좌측메뉴 넣으세요-->
			    <div class="left">
			     <%@ include file="common/mypageSidebarMentor.jsp" %>
		
				</div>
				
		
		
		
	
	    <!--이 부분은 우측 컨텐츠 입니다.-->
	    <div class="right">
	        <h3 style="color : #6363ff">넌모야</h3>
	        
	  
	
  <div class="wrap">
            <div class="head">
            <h3 class="head-line">프론트 엔드와 백엔드의 차이점이 무엇인가요?</h3>
            <h4 class="head-line" id="">QUE_ENROLLDATE(작성일)</h4>
            </div>

    
      
       <input type="text" class="body" id="text-body" value="content">
       
        <br><br><br>     <br><br><br>    
        <div class=answer-wrapper>
                            <div class="body" id="answerNum" style="display:flex;">
                                    <div class="num" ><h3>답변</h3></div>
                                    <div class="num" id="num"><h4>2개</h4></div>
                                </div> 

                                <div class="body"><input type="text" id="reply-content-form" style="height:30px" placeholder="답변을 입력하세요."></div>

                                <!-- 답변페이지 -->

                              
                                <div class="body"id="mentor-profile-photo-container">
                                    <div  class="1" id="mentor-profile-photo"><img src="멘토 프로필 사진 경로" style="width:20%";></div>
                                
                                                <div class="1" id=name-company-container>
                                                                    <div class="mentor-info-right" id="nameandcompany" style="margin-bottom:auto;">
                                                                            <div class="name-company" id="mentor-name" style="margin-right:10px;"><label>멘토이름</label></div>
                                                                            <div class="name-company" id="company"><label>소속</label></div>
                                                                            <br><br>
                                                                    </div>

                                                                   
                                                                            <div class="6" id="replied-content"style="border:none; height:auto%;"><p>답변내용</p></div>
                                                                     
                                                                 

                                                                    <div class="mentor-info-right" id="answer-bottom" style="display:inline-flex; flex-direction:row;">
                                                                                <div class="5-reply-right-bottom"><p>xxx 시간전(작성시간)</p></div>
                                                                                
                                                                                <div class="5-reply-right-bottom"><i class="fa-regular fa-heart" style="margin-top:20px; padding:0 10px; resize: none;"></i></div>
                                                                            
                                                                                <div class="5-reply-right-bottom"> <p>답글</p></div>
                                                                    
                                                                
                                                                    </div>
                                                            </div>
                                                </div>
                                        </div>
                                       
                                        <button type="submit" style="margin:auto;display:block; margin-top:40px; margin-left:550px;color:white; border:none; width:80px; height:35px; border-radius: 4px; background-color: #6363FF;">목록으로</button>
                                    </div>
                                </div>
                                
                            </div>
  
  



	

	<%@ include file="../common/footer.jsp" %>

</body>
</html>