<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8" import="com.jj.community.model.vo.Community"%>
    
<%
	Community c = (Community)request.getAttribute("community");
%>    
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">

<!-- css -->
<link rel="stylesheet" href="${pageContext.request.contextPath}/resources/css/setting.css">
<link rel="stylesheet" href="${pageContext.request.contextPath}/resources/css/community/communityUpdateForm.css">

<!-- 폰트어썸 --> 
<script src="https://kit.fontawesome.com/ea8287c514.js" crossorigin="anonymous"></script>

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
    
        <!-- 게시글 수정 테이블 -->
        <form action="<%= contextPath %>/update.co" id="community-update-form" method="post">
        	<input type="hidden" name="contentNo" value="<%=c.getCommNo() %>">
            <div class="communtiy-update-area">

                <!-- 게시물 수정 영역 테이블 -->
                <table class="community-update-tb">
                    <tr>
                        <td id="community-mark">커뮤니티</td>
                    </tr>
                    <tr>
                        <td id="community-category-select">
                            <select name="categorySelect" id="category-community-btn" disabled>
                            	<option><%= c.getCommCategory() %></option>
                            </select>
                        </td>
                    </tr>
                    <tr>
                        <td id="community-title-mark">제목</td>
                    </tr>
                    <tr>
                        <td><input type="text" id="community-content-title" name="contentTitle" value="<%= c.getCommTitle() %>" required></td>
                    </tr>
                    <tr>
                        <td id="community-content-mark">내용</td>
                    </tr>
                    <tr>
                        <td><textarea name="contentBody" id="community-content-body" cols="100" rows="10" required><%= c.getCommContent() %></textarea></td>
                    </tr>
                </table>

                <!-- 게시글 등록 버튼 영역 -->
                <div class="community-update-button">
                        <button id="community-content-reset" onclick="history.back();">취소</button>
                        <button type="submit" id="community-content-update">수정</button>
                </div>
            </div>
        </form>
    </div>
    
    	<%@ include file="../common/footer.jsp" %>

</body>
</html>