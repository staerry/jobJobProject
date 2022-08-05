<%@page import="com.jj.mentorMyPage.model.vo.Vod"%>
<%@page import="java.util.List"%>
<%@page import="com.jj.userMyPage.model.vo.Class"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8" %>
    
<% 
List<Vod> list = (List<Vod>) request.getAttribute("list"); 
  
  %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<meta name="viewport" content="width=device-width, initial-scale=1">

<<link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap@4.6.1/dist/css/bootstrap.min.css"> 
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
		
								    <h3 style="color : #6363ff;">클래스 Vod 업로드</h3>
								  
								  <div style="display:inline-flex; margin-top: auto;">
								<!--   <div class="category" style="margin-right:10px;margin-top:auto;"><h5>카테고리</h5></div> -->
								
								<!-- <div style="margin-top:auto"><h4 style="margin-top:auto">클래스 제목</h4></div>
								<h5 style="margin-top:auto">클래스 소제목</h5> -->
								</div> 
								<div class="checkbox-group">
          <table class="table table-hover">
            <thead>
                <h3>${clTitle}</h3>
                <tr style="background-color:whitesmoke">
                  <th colspan="6">&nbsp;&nbsp;&nbsp;&nbsp;
                    <input type="checkbox" name="check" id="checkAll">
                    <label for="checkAll">전체선택</label>&nbsp;&nbsp;&nbsp;&nbsp;
                    <button class="btn btn-sm btn-danger" onclick="deleteChecked();">삭제</button></th>
                  </tr>
                </thead>
                <thead align="center">
                  <tr>
                    <th></th>
                    <th>강의 번호</th>
                    <th>제목</th>
                    <th>승인 상태</th>
                  </tr>
                </thead>
                <tbody align="center">
                 <% if(list == null) { %> 
                    <tr>
                      <td colspan="6">조회된 강의가 없습니다.</td>
                    </tr>
                    <%} else{ %>
                       <%for(Vod v : list){ %> 
                        <tr>
                          <td><input type="checkbox" class="selectedCheck" name="check" value="<%= v.getVodNo()%>"></td>
                          <td><p><%= v.getVodNo()%></p></td>
                          <td><p><%= v.getVodTitle() %></p></td>
                          <td><p><%= v.getVodStatus()%></p></td>
                        </tr>
                        <% } %> 
                      <% } %> 
                      </tbody>
                    </table>
                  </div>
							
						 <button onclick="location.href='<%=contextPath %>/uploadVod.my?clNo=${clNo}&clTitle=${clTitle}';" id=btn-upload class="btn btn-primary btn-lg" style="background-color:#6363FF; float:right; margin:10px;color:white">
							새로운 vod 업로드
						</button>
							
			
					
								
			<!-- 					<div class="paging-area" style="margin:auto;">
            <ul class="pagination justify-content-center" style="margin:20px 0">
                <li class="page-item"><a class="page-link" href="#">Previous</a></li>
                <li class="page-item"><a class="page-link" href="#">1</a></li>
                <li class="page-item"><a class="page-link" href="#">2</a></li>
                <li class="page-item"><a class="page-link" href="#">3</a></li>
                <li class="page-item"><a class="page-link" href="#">4</a></li>
                <li class="page-item"><a class="page-link" href="#">5</a></li>
                <li class="page-item"><a class="page-link" href="#">Next</a></li>
              </ul>
        </div> -->
						
								
				
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