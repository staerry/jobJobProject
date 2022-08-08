<%@page import="com.jj.userMyPage.model.vo.Class"%>
<%@page import="com.jj.mentorMyPage.model.vo.MtQuestion"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<% Class cls = (Class) request.getAttribute("cls"); %>
<% boolean hasReview = (boolean) request.getAttribute("hasReview"); %>
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
            /* height: 90px; */
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
        width: 100px;
        height: 50px;
        font-size: large;
    }




    /* star  */
    .star-rating {
        display: flex;
        flex-direction: row-reverse;
        font-size: 2.25rem;
        line-height: 2.5rem;
        justify-content: space-around;
        padding: 0 0.2em;
        text-align: center;
        width: 5em;
        margin-bottom: 30px;
    }
    
    .star-rating input {
    display: none;
    }
    
    .star-rating label {
    -webkit-text-fill-color: transparent; /* Will override color (regardless of order) */
    -webkit-text-stroke-width: 2.3px;
    -webkit-text-stroke-color: #2b2a29;
    cursor: pointer;
    }
    
    .star-rating :checked ~ label {
    -webkit-text-fill-color: gold;
    }
    
    .star-rating label:hover,
    .star-rating label:hover ~ label {
    -webkit-text-fill-color: #fff58c;
    }
    .head-msg{
        margin-left: 40%;
        margin-top: 100px;
    }
    .head-btn{
        margin-left: 50px;
    }

    </style> 

</head>
    
<body>

<%@ include file="../common/menubar.jsp" %>
<div class="content-wrap">
<!--이 부분에 좌측메뉴 넣으세요-->
    <div class="left">
    <%@ include file="common/myPageSidebarUser.jsp" %> 
    </div>
    <!--이 부분은 우측 컨텐츠 입니다.-->
    <div class="right">
        <div class="mycontent">

            <div class="wrap">
                    <% if(hasReview){ %>
                        <div class="head-msg">
                            <h3>이미 수강 후기를 등록하셨습니다!</h3>
                            <div class="head-btn">
                                <button onclick="prevPage();">돌아가기</button>
                            </div>
                        </div>
                    <% } else{ %>
                        <div class="head">
                            <h3 class="head-line">[<%= cls.getClTitle() %>] 강의의 수강 후기를 작성해주세요. </h3>
                        </div>
                        <hr>
                        <form action="${pageContext.request.contextPath}/reviewEnroll.my"
                            method="post">
                            <div class="head-content">
                                <div class="star-rating space-x-4 mx-auto">
                                    <input type="radio" id="5-stars" name="rating" value="5" v-model="ratings"/>
                                    <label for="5-stars" class="star pr-4">★</label>
                                    <input type="radio" id="4-stars" name="rating" value="4" v-model="ratings"/>
                                    <label for="4-stars" class="star">★</label>
                                    <input type="radio" id="3-stars" name="rating" value="3" v-model="ratings"/>
                                    <label for="3-stars" class="star">★</label>
                                    <input type="radio" id="2-stars" name="rating" value="2" v-model="ratings"/>
                                    <label for="2-stars" class="star">★</label>
                                    <input type="radio" id="1-star" name="rating" value="1" v-model="ratings" />
                                    <label for="1-star" class="star">★</label>
                                </div>
    
    
    
                                <!-- <textarea name="ansContent" id="reply-content-form" cols="150" rows="10" placeholder="답변을 입력하세요."></textarea> -->
                                <textarea name="reviewContent" id="reply-content-form" placeholder="내용을 입력하세요."></textarea>
                                <div>
                                    <button type="submit" class="subBtn">작성완료</button>             
                                </div>
                            </div>
                            <input type="hidden" name="clNo" value="<%= cls.getClNo() %>">
        
                        </form>                     
                    <% } %>

                    
            </div>


        </div>
    </div>


</div>






	<%@ include file="../common/footer.jsp" %>

</body>
<script>
function prevPage(){
    history.back();
}

</script>
</html>