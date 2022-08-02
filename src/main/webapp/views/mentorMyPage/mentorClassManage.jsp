<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<meta name="viewport" content="width=device-width, initial-scale=1">

  
< <link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap@4.6.1/dist/css/bootstrap.min.css"> 
 <script src="https://cdn.jsdelivr.net/npm/popper.js@1.16.1/dist/umd/popper.min.js"></script> 
 <script src="https://cdn.jsdelivr.net/npm/bootstrap@4.6.1/dist/js/bootstrap.bundle.min.js"></script> 
<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.6.0/jquery.min.js"></script>
<!-- css -->
<link rel="stylesheet" href="${pageContext.request.contextPath}/resources/css/setting.css">

<link rel="stylesheet" href="${pageContext.request.contextPath}/resources/css/userMyPage/mainTemplate.css">
<title>Insert title here</title>
<style>

.container h3, h4{
margin:18px 15px; 
font-weight:bolder;

}
.container h5{
margin:18px 10px; 
margin-left:30px;
margin-top:auto;
color:grey;
}
table>*{
width:auto;
}
.container button{
margin-left:160px;
margin-top:30px;
background-color:#6363FF; 
color:white;


}
.boxbox{
width:200px;
 height:150px;
}

.page-link {
    color: #6363FF; 
    background-color: #fff;
    border: 1.5px solid #6363FF; 
  }
  
  .page-item.active .page-link {
   z-index: 1;
   color: #555;
   font-weight:bold;
   background-color: #f1f1f1;
   border-color: #ccc;
   
  }
  
  .page-link:focus, .page-link:hover {
    color: white;
    background-color: #6363FF; 
    border-color: #ccc;
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
			             <div class="container">
		
								    <h3 style="color : #6363ff; margin-bottom:40px;">나의 클래스 관리</h3>
								  
								  <div style="display:inline-flex; margin-top: auto;">
								  <div class="category" style="margin-right:10px;margin-top:auto;"><h5>카테고리</h5></div>
								
								<div style="margin-top:auto"><h4 style="margin-top:auto">클래스 제목</h4></div>
								<h5 style="margin-top:auto">클래스 소제목</h5>
								</div> 
								
								
						  <% if(loginUser.getMtGrade() == 1) {   // 현직자 상태%>
										
										<div class="boxbox">클래스를 등록하고 강의자가 되어보세요</div>
			
								<% }else { // 강의자상태  %>
								
							
			
						<div class="container">
								<table class="table table-hover">
								  <thead>
								    <tr>
								      <th width="50px">클래스고유번호(CL_NO)</th>
								      <th width="180px">해당 회차 강의 제목(CL_TITLE)</th>
								      <th width="80px">수강회원 수</th>
								      <th width="120px">강의 시작일</th>
								      <th width="80px">승인 상태</th>
								    </tr>
								  </thead>
								
								
								  <tbody>
								    <tr>
								      <td>2</td>
								      <td>한번에 끝내는 자바</td>
								      <td>n명</td>
								      <td>2022-08-12</td>
								      <td class="btn btn-primary btn-sm">대기중</td>
								    </tr>
								
								    <tr>
								      <td>1</td>
								      <td>Moe</td>
								      <td>n명</td>
								      <td>2022-08-12</td>
								      <td class="btn btn-primary">대기중</td>
								    </tr>
								
								    <tr>
								      <td>0</td>
								      <td>Dooley</td>
								      <td>n명</td>
								      <td>2022-08-12</td>
								      <td class="btn btn-primary">대기중</td>
								    </tr>
								  </tbody>
								
								
								</table>
								
								<div class="paging-area" style="margin:auto;">
            <ul class="pagination justify-content-center" style="margin:20px 0">
                <li class="page-item"><a class="page-link" href="#">Previous</a></li>
                <li class="page-item"><a class="page-link" href="#">1</a></li>
                <li class="page-item"><a class="page-link" href="#">2</a></li>
                <li class="page-item"><a class="page-link" href="#">3</a></li>
                <li class="page-item"><a class="page-link" href="#">4</a></li>
                <li class="page-item"><a class="page-link" href="#">5</a></li>
                <li class="page-item"><a class="page-link" href="#">Next</a></li>
              </ul>
        </div>
		    <%} %>						
						
								<button onclick="location.href='<%= contextPath %>/createClass.my';" id=btn-upload class="btn btn-primary btn-lg" style="background-color:#6363FF; color:white"
								
								 >새로운 클래스 등록</button>
				
								</div>	
						</div>
				</div>
			</div>
					
	 

     
     <br>
     <br> 
     <br>
     <br>
     <br> 

<%@ include file="../common/footer.jsp" %>
</body>
</html>