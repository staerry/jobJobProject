<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8" import="java.util.List, com.jj.userMyPage.model.vo.Bookmark"%>
    
<% List<Bookmark> bookmark = (List<Bookmark>)request.getAttribute("list");  %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<link rel="stylesheet" href="${pageContext.request.contextPath}/resources/css/userMyPage/mainTemplate.css">
<link rel="stylesheet" href="${pageContext.request.contextPath}/resources/css/setting.css">
<link rel="stylesheet" href="${pageContext.request.contextPath}/resources/css/userMyPage/userMyClassLike.css">

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
						<h2>찜한 클래스</h2>
						
					</div>
					<div class="main-vod-list">
						
			
			            <div class="main-window">
			                <div class="main-container">
			                <% for(Bookmark b : bookmark) {%>
			                    <div class="vod">
			                        <h4><%=b.getCls().getClTitle() %></h4>
			                        <p><%=b.getCls().getMember().getUserName() %>&nbsp&nbsp&nbsp&nbsp <%=b.getCls().getMember().getMtCompany() %>/p>
			                        
			                        <!--  -->
			                        <div class="class-thumbnail">< <%=b.getCls().getClThumbnailPath() %> </div>
			                        <span>
			                            <i class="fas fa-heart"></i>
			                        </span>
			                    </div>
			                    <%} %>
								
			                    
			                </div>
			                
			              
			            </div>
			
					
					</div>
					
					
					
			                
			         
				
		
		           
					
		</div>
		
	</div>
   	
			
					
			
		
			<%@ include file="../common/footer.jsp" %>
			
	
	

    

  
</body>
</html>