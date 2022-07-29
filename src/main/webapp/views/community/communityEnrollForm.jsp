<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8" import="java.util.ArrayList, com.jj.community.model.vo.Category"%>
    
<%
	ArrayList<Category> list = (ArrayList<Category>)request.getAttribute("list");


%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">

<!-- css -->
<link rel="stylesheet" href="${pageContext.request.contextPath}/resources/css/setting.css">
<link rel="stylesheet" href="${pageContext.request.contextPath}/resources/css/community/communityEnrollForm.css">

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
    
        <!-- 게시글 작성 테이블 -->
        <form action="<%= request.getContextPath() %>/insert.co" id="community-enroll-form" method="post">
        <!-- 카테고리 번호, 제목, 내용, 로그인한회원번호 받아야 함 -->
            <div class="communtiy-enroll-area">

                <!-- 게시물 작성 영역 테이블 -->
                <table class="community-enroll-tb">
                    <tr>
                        <td id="community-mark">커뮤니티</td>
                    </tr>
                    <tr>
                        <td id="community-category-select">
                            <select name="categorySelect" id="category-community-btn">
                            	<% for(Category c: list) { %>
                            	<option value="<%= c.getCategoryNo() %>"><%= c.getCategoryName() %></option>
								<% } %>
                            </select>
                        </td>
                    </tr>
                    <tr>
                        <td id="community-title-mark">제목</td>
                    </tr>
                    <tr>
                        <td><input type="text" id="community-content-title" name="contentTitle" placeholder="제목을 입력해 주세요."
                                required></td>
                    </tr>
                    <tr>
                        <td id="community-content-mark">내용</td>
                    </tr>
                    <tr>
                        <td><textarea name="contentBody" id="community-content-body" cols="100" rows="10" placeholder="- 서로 예의를 지키며 존중하는 문화를 만들어 가요.&#13;&#10;- 잠깐! 니JOB내JOB 서비스 운영 관련 문의는 1:1 문의하기를 이용해 주세요." required></textarea></td>
                    </tr>
                </table>

                <!-- 게시글 등록 버튼 영역 -->
                <div class="community-enroll-button">
                		<!-- 취소버튼 클릭 시 리셋하고 목록으로 돌아감 -->
                        <button type="reset" id="community-content-reset" onclick="history.back();">취소</button>
                        <button type="submit" id="community-content-enroll">등록</button>
                </div>
            </div>
        </form>
    </div>
	
	
	<%@ include file="../common/footer.jsp" %>


</body>
</html>