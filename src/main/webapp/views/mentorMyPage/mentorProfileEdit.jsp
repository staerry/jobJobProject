<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@page import="com.jj.userMyPage.model.vo.Lecturer"%>
<% Lecturer lecturer = (Lecturer)request.getAttribute("lecturer"); %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">

<!-- css -->
<link rel="stylesheet" href="${pageContext.request.contextPath}/resources/css/userMypage/mainTemplate.css">
<link rel="stylesheet" href="${pageContext.request.contextPath}/resources/css/setting.css">
<link rel="stylesheet" href="${pageContext.request.contextPath}/resources/css/mentorMyPage/mentorProfileEdit.css">




<!-- 부트스트랩 아이콘 -->
<link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap-icons@1.7.1/font/bootstrap-icons.css">

<!-- 부트스트랩 -->
<link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap@4.6.1/dist/css/bootstrap.min.css">
<script src="https://cdn.jsdelivr.net/npm/jquery@3.6.0/dist/jquery.slim.min.js"></script>
<script src="https://cdn.jsdelivr.net/npm/popper.js@1.16.1/dist/umd/popper.min.js"></script>
<script src="https://cdn.jsdelivr.net/npm/bootstrap@4.6.1/dist/js/bootstrap.bundle.min.js"></script>


<title>Insert title here</title>
<style>
.main-web-wrap{
display:inline-flex;
padding-left:100px;}
h3{
margin-left:40px;
margin-bottom:10px;
margin-top:30px;
font-size:28px;
font-weight:bolder;

}

.introduce-area{
width:80%;

}
</style>

</head>
<body>

	<%@ include file="../common/menubar.jsp" %>
	
    <form action="${pageContext.request.contextPath}/mtProEdit.my" method="post" enctype="multipart/form-data">
	<div class="main-web-wrap">
	
		<div class="left-content" class="a">
            <!--여기에 좌측 메뉴-->
            <%@ include file="common/mypageSidebarMentor.jsp" %>
        </div>
        
        <div class="right-content" class="a">
            <!--여기에 컨텐츠-->
            <div class="container">
                <div class= "mentor-detail-main">
                    <h3 style="color : #6363ff">나의 프로필 관리</h3>
                </div>
                <div class="mentor-detail-main">
         
                    <!-- 왼쪽 멘토 프로필 카드 -->
                    <div class="card-area">
                        <!-- 멘토 사진 감싸는 부분 -->
                        <div class="image-wrap">
                            <div class="image-inner">
                                <img src="<%= lecturer.getProfilePath() %>" id="mentor-image">
                                <input type="file" name="imgFile" accept="image/*">
                            </div>
                        </div>
                        
                        <div class="profile-wrap">
                            <table id="mentor-profile">
                                <tr id="mentor-field">
                                    <td><%= lecturer.getClCategory().getClcgName() %></td>
                                </tr>
                                <tr id="mentor-name">
                                    <td><%= lecturer.getMember().getUserName() %><span>&nbsp;멘토</span></td>
                                </tr>
                                <tr id="mentor-job">
                                    <td><%= lecturer.getMentor().getMtCompany() %></td>
                                </tr>
                                <!-- <tr id="mentor-stat">
                                    <td>%= 직무 %</td>
                                </tr> -->
                            </table>
                            <button type="submit" style="border:none; background-color:#6363ff; color:white; width:130px; height:50px; margin:60px; border-radius:4px">수정하기</button> 
                        </div>
                    </div>

                    <!-- 오른쪽 멘토 소개 -->
                    <div class="introduce-area">
                        <div class="mentor-info">
                            <table>
                                <tr>
                                <td><h4 class="flex1">멘토 소개</h4></td>
                                    <!-- <td><button type="submit" class="flex1" id="editbtn" style="margin-left:0; border:none;">수정하기</button></td> -->
                                </tr>
                            </table>
                            <textarea  class="te" cols="100" rows="5" name="ltrInfo"><%= lecturer.getLtrInfo() %></textarea>
                            
                            <br>  <br>

                            <table>
                                <tr>
                                    <td><h4 class="flex1">주요 경력</h4></td>
                            <!-- <td><button type="submit" class="flex1" id="editbtn" style="margin-left:auto; border:none">수정하기</button></td> -->
                                </tr>
                            </table>
                    
                            <textarea  class="te" cols="100" rows="5" style="resize:none;" name="ltrCareer">&nbsp;&nbsp;<%= lecturer.getLtrCareer() %>  </textarea>

                        
                        </div>
                    </div>

                <!-- 강의, 질문 영역 이동 버튼 
                <div class="menu-area">
                    <button onclick="" style="margin-right:50px;">나의 클래스 관리</button>
                    <button onclick="">마이 페이지 홈으로</button>
                </div>

            -->
   

            </div>
        </div>
    </div>  
</div>
</form>
   
	<%@ include file="../common/footer.jsp" %>

</body>
</html>