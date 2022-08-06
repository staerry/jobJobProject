<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@page import="com.jj.userMyPage.model.vo.ClassIng"%>
<%@page import="java.util.List"%>
<% List<ClassIng> list = (List<ClassIng>) request.getAttribute("list"); %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<link rel="stylesheet" href="${pageContext.request.contextPath}/resources/css/userMyPage/mainTemplate.css">
<link rel="stylesheet" href="${pageContext.request.contextPath}/resources/css/setting.css">
<link rel="stylesheet" href="${pageContext.request.contextPath}/resources/css/userMyPage/userMyClassIng.css">

<script src="https://kit.fontawesome.com/ea8287c514.js" crossorigin="anonymous"></script>
<title>Insert title here</title>
</head>
<body>
	<%@ include file="../common/menubar.jsp" %>
	
	<div class="main-web-wrap">
			        <div class="left-content">
			            <!--여기에 좌측 메뉴-->
			            
			 <%@ include file="common/myPageSidebarUser.jsp" %>
			          
			        </div>
			        
         <!--여기에 우측 메뉴-->
		<div class="right-content">
			<!-- 전체감싸는부분 -->
			
				
		
					<!--vod 부분-->
					<div class="main-vod-title">
						<h2>수강중인 클래스</h2>
					</div>
					<div class="main-vod-list">
						
			
			            <div class="main-window">
			                <div class="main-container">
								<% for(ClassIng cing : list){%>
									<div class="vod">
										<a href="${pageContext.request.contextPath}/detail.cl?class=<%= cing.getCls().getClNo() %>">
											<h4><%= cing.getCls().getClTitle() %></h4>
											<p><%= cing.getMember().getUserName() %>&nbsp&nbsp&nbsp&nbsp<%= cing.getMember().getMtCompany() %></p>
											<div class="class-thumbnail">
												<img src="<%= cing.getCls().getClThumbnailPath() %>" alt="">
											</div>
										</a>
									</div>
								<% }%> 

			                </div>
			                
			              
			            </div>
			
					
					</div>
					
					
					
			                
			              
			            </div>
			
						
					</div>
					
				
		
				
		
		           
					
			
					
			
		
			<%@ include file="../common/footer.jsp" %>
			
	
	

    

  
</body>
</html>