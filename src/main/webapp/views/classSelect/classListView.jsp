<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8" import="java.util.ArrayList, com.jj.classSelect.model.vo.Class"%>

<%
	String category = (String)request.getAttribute("category");
	int listCount = (int)request.getAttribute("listCount");
	ArrayList<Class> list = (ArrayList<Class>)request.getAttribute("list");
%>    
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<!-- css -->
<link rel="stylesheet" href="${pageContext.request.contextPath}/resources/css/setting.css">
<link rel="stylesheet" href="${pageContext.request.contextPath}/resources/css/classSelect/classListView.css">
<!-- 부트스트랩 아이콘 -->
<link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap-icons@1.7.1/font/bootstrap-icons.css">
<!-- 부트스트랩 -->
<link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap@4.6.1/dist/css/bootstrap.min.css">
<script src="https://cdn.jsdelivr.net/npm/jquery@3.6.0/dist/jquery.slim.min.js"></script>
<script src="https://cdn.jsdelivr.net/npm/popper.js@1.16.1/dist/umd/popper.min.js"></script>
<script src="https://cdn.jsdelivr.net/npm/bootstrap@4.6.1/dist/js/bootstrap.bundle.min.js"></script>
<title>Insert title here</title>
</head>
<body>
	<%@ include file="../common/menubar.jsp" %>
 
    <!-- 전체를 감싸는 div -->
    <div class="container">
    
        <!-- 왼쪽 메뉴바 -->
        <%@include file="common/classMenubar.jsp" %>

        <!-- 오른쪽 클래스 목록 영역-->
        <div class="class-list-area">
        	<%
        		if(category == null || category.equals("all")) {
        			category = "0";
        		}
        	
        		String categoryName = "";
        		switch(category) {
        		case "0": categoryName = "전체"; break;
        		case "1": categoryName = "IT · 개발"; break;
        		case "2": categoryName = "마케팅 · MD · 영업"; break;
        		case "3": categoryName = "회계 · 재무 · 금융"; break;
        		case "4": categoryName = "전략 · 기획"; break;
        		case "5": categoryName = "유통 · 무역 · 구매"; break;
        		case "6": categoryName = "공사 · 공기업 · 공무원"; break;
        		case "7": categoryName = "전문 · 특수"; break;
        		
        		}
        	%>
            <h3><%= categoryName %> (<%= listCount %>)</h3>

            <!-- 클래스 정렬 버튼 & 박스 영역 -->
            <div class="class-sorting">
	            <div class="class-sort-btn">
						<span id="filter" align="center"><i class="fas fa-sort-alpha-down"></i>&nbsp;필터</span>
						<button id="date" align="center" onclick="location.href='<%=contextPath%>/list.cl?category=<%= category %>&sort=no'">최신순</button>
						<button id="score" align="center" onclick="location.href='<%=contextPath%>/list.cl?category=<%= category %>&sort=score'">평점순</button>
						<button id="price" align="center" onclick="location.href='<%=contextPath%>/list.cl?category=<%= category %>&sort=price'">수강료순</button>
				</div>
            </div>
            
            <!-- 클래스 목록 -->
            <div class="class-list">
            
            	<% if(!list.isEmpty()) { %>
            	<% for(Class c : list) { %>
                <div class="class-cover" onclick="location.href='<%= contextPath %>/detail.cl?class=<%=c.getClNo()%>';">
                    <h6><%= c.getClTitle() %></h6>
                    <span><%= c.getUserNo() %>&nbsp;&nbsp;|&nbsp;&nbsp;<%= c.getMtCompany() %></span><br>
                    <span><br></span>
                    <span id="class-cover-img"><img src="<%= contextPath %>/<%= c.getClThumbnailPath() %>" width="200" height="120"></span>
                    <span id="zzim-count"><i id="score-star" class="fas fa-star"></i> <%= c.getClScore() %></span>
                    <span><%= c.getClPriceWon() %></span>
                </div>
                <% } %>
                <% } %>
                
            </div>
        </div>
    </div>
 	<%@ include file="../common/footer.jsp" %>
	
</body>
</html>