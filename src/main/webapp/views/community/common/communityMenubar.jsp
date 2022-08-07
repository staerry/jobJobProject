<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

<!DOCTYPE html>
<html lang="en">
<head>
<meta charset="UTF-8">
<meta http-equiv="X-UA-Compatible" content="IE=edge">
<meta name="viewport" content="width=device-width, initial-scale=1.0">
<title>Document</title>

<link rel="stylesheet" href="${pageContext.request.contextPath}/resources/css/setting.css">

<!-- 폰트어썸 --> 
<script src="https://kit.fontawesome.com/ea8287c514.js" crossorigin="anonymous"></script>

<!-- 부트스트랩 -->
<link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap@4.6.1/dist/css/bootstrap.min.css">
<script src="https://cdn.jsdelivr.net/npm/jquery@3.6.0/dist/jquery.slim.min.js"></script>
<script src="https://cdn.jsdelivr.net/npm/popper.js@1.16.1/dist/umd/popper.min.js"></script>
<script src="https://cdn.jsdelivr.net/npm/bootstrap@4.6.1/dist/js/bootstrap.bundle.min.js"></script>
</head>

<body>

    <div class="container">
        <!-- 게시판 카테고리 영역 -->
        <div class="community-category-area">
            <ul class="community-categroy-navi">
                <li id="community-head">커뮤니티</li>
                <li><a href="<%= request.getContextPath() %>/list.co?category=1&cpage=1">직무질문</a></li>
                <li><a href="<%= request.getContextPath() %>/list.co?category=2&cpage=1">고민상담</a></li>
                <li><a href="<%= request.getContextPath() %>/list.co?category=3&cpage=1">스터디</a></li>
            </ul>
        </div>
	</div>
	
</body>

</html>