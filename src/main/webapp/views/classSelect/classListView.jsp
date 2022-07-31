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
        		case "1": categoryName = "IT • 개발"; break;
        		case "2": categoryName = "마케팅 • MD • 영업"; break;
        		case "3": categoryName = "회계 • 재무 • 금융"; break;
        		case "4": categoryName = "전략 • 기획"; break;
        		case "5": categoryName = "유통 • 무역 • 구매"; break;
        		case "6": categoryName = "공사 • 공기업 • 공무원"; break;
        		case "7": categoryName = "전문 • 특수"; break;
        		
        		}
        	%>
            <h3><%= categoryName %> (<%= listCount %>)</h3>

            <!-- 클래스 정렬 버튼 & 박스 영역 -->
            <div class="class-sorting">
                <!-- 클래스 필터 버튼 -->
                <button class="class-sort-btn">
                    <i class="bi bi-funnel"></i>
                    <span id="filter">필터</span>
                    <span>유료 | 무료
                </button>

                <!-- 클래스 정렬 셀렉트 박스 -->
                <span>
                    <select name="classOrder" id="class-order">
                        <option value="recent">최신 순</option>
                        <option value="rating">평점 순</option>
                        <option value="famous">수강생 순</option>
                    </select>
                </span>
            </div>

            <!-- 클래스 목록 -->
            <div class="class-list">
            
            	<% if(!list.isEmpty()) { %>
            	<% for(Class c : list) { %>
                <div class="class-cover" onclick="">
                    <h6><%= c.getClTitle() %></h6>
                    <span><%= c.getUserNo() %></span><br>
                    <span><%= c.getMtCompany() %></span><br>
                    <img src="<%= contextPath %>/<%= c.getClThumbnailPath() %>" width="200" height="120"><br>
                    <span id="zzim-count"><i class="bi bi-suit-heart-fill"></i> %= 찜 횟수 %</span>
                    <span><i class="fas fa-won-sign"></i> <%= c.getClPrice() %></span>
                </div>
                <% } %>
                <% } %>
                
                <h3>///// 시간이 된다면.. 무한스크롤 ///////</h3>

            </div>
        </div>

    </div>

 	<%@ include file="../common/footer.jsp" %>
	
</body>
</html>