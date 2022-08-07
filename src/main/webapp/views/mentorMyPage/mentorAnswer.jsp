<%@page import="com.jj.mentorMyPage.model.vo.MtQuestion"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<% MtQuestion mtQuestion = (MtQuestion) request.getAttribute("mtQuestion"); %>    
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>

<link rel="stylesheet" href="${pageContext.request.contextPath}/resources/css/admin/admin-setting.css">
<link rel="stylesheet" href="${pageContext.request.contextPath}/resources/css/setting.css">
<link rel="stylesheet" href="${pageContext.request.contextPath}/resources/css/mentorMypage.mentorQnA.css">
<script src="https://kit.fontawesome.com/d9c0959348.js" crossorigin="anonymous"></script>


  <style>
      
        .head{
            display:flex;
            width: 90%;
            margin-top: 30px;
            margin-left: 30px;
        }
        .head>h4{
            font-weight:500;
            margin-left:auto;
            color:grey;
        }
        .head-content{
            margin-left: 30px;
            height: 90px;
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
       
        /* .body>input{
            width:600px;
            height:50px;
        } */

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
        button{
            text-align:center; 
            margin:20px; 
            color:white; 
            border:none; 
            width:80px; 
            height:35px; 
            border-radius: 4px; 
            background-color: #6363FF;
        }

        hr{
            margin-top: 30px;
            margin-bottom: 30px;
            color: grey;
            width: 90%;
            text-align: center;
            margin-left: 30px;
        }
        textarea{
            width: 90%;
            height: 200px;
            resize: none;
        }
    /* #6363FF */
    .content-wrap{
        height: 900px;
    }
    .subBtn{
        margin: 0;
        margin-top: 20px;
    }



    </style> 

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
        <div class="mycontent">

            <div class="wrap">
                <button type="submit">목록으로</button>
                <div class="head">
                    <h3 class="head-line">Q. <%= mtQuestion.getQueTitle() %></h3>
                    <h4 class="head-line" id=""><%= mtQuestion.getQueEnrolldate() %></h4>
                </div>
                <hr>
                <div class="head-content">
                    <%= mtQuestion.getQueContent() %>
                </div>
                <% if(mtQuestion.getAnsContent() == null){ %>
                    <form action="${pageContext.request.contextPath}/myAnsEnroll.my"
                        method="post">
                        <div class="head">
                            <h3 class="head-line">A. 답변을 등록해주세요.</h3>
                        </div>
                        <hr>
                        <div class="head-content">
                            <!-- <textarea name="ansContent" id="reply-content-form" cols="150" rows="10" placeholder="답변을 입력하세요."></textarea> -->
                            <textarea name="ansContent" id="reply-content-form" placeholder="답변을 입력하세요."></textarea>
                            <div>
                                <button type="submit" class="subBtn">답변하기</button>             
                            </div>
                        </div>
    
                        <input type="hidden" name="queNo" value="<%= mtQuestion.getMtQueNo() %>">
                    </form>                     

                <% } else { %>
                    <div class="head">
                        <h3 class="head-line">A. 등록한 답변입니다.</h3>
                        <h4 class="head-line" id=""><%= mtQuestion.getAnsDate() %></h4>
                    </div>
                    <hr>
                    <div class="head-content">
            
                        <%= mtQuestion.getAnsContent() %>

                    </div>
                <% }  %>
            </div>


        </div>
    </div>


</div>






	<%@ include file="../common/footer.jsp" %>

</body>
</html>