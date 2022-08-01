<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
        <!-- 왼쪽 메뉴바 -->
        <div class="class-category-area">
            <ul class="category-navi">
                <li id="select-all"><a href="<%= request.getContextPath() %>/list.cl?category=all">전체</a></li>
                <li><a href="<%= request.getContextPath() %>/list.cl?category=1">IT • 개발</a></li>
                <li><a href="<%= request.getContextPath() %>/list.cl?category=2">마케팅 • MD • 영업</a></li>
                <li><a href="<%= request.getContextPath() %>/list.cl?category=3">회계 • 재무 • 금융</a></li>
                <li><a href="<%= request.getContextPath() %>/list.cl?category=4">전략 • 기획</a></li>
                <li><a href="<%= request.getContextPath() %>/list.cl?category=5">유통 • 무역 • 구매</a></li>
                <li><a href="<%= request.getContextPath() %>/list.cl?category=6">공사 • 공기업 • 공무원</a></li>
                <li><a href="<%= request.getContextPath() %>/list.cl?category=7">전문 • 특수</a></li>
            </ul>
        </div>
        
        <script>
        
        function goCategory(no){
        	$.ajax({
        		url:"<%= request.getContextPath() %>/list.cl?category=no";
        		
        	})
        }
        </script>
        
</body>
</html>