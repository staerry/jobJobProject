<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
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
        <form action="" id="community-enroll-form" method="post">
            <div class="communtiy-enroll-area">

                <!-- 게시물 작성 영역 테이블 -->
                <table class="community-enroll-tb">
                    <tr>
                        <td id="community-mark">커뮤니티</td>
                    </tr>
                    <tr>
                        <td id="community-category-select">
                            <select name="categorySelect" id="category-community-btn">
                                <option value="qna">질문&답변</option>
                                <option value="counsel">고민상담</option>
                                <option value="study">스터디</option>
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
                        <button type="reset" id="community-content-reset">취소</button>
                        <button type="submit" id="community-content-enroll">등록</button>
                </div>
            </div>
        </form>
    </div>
	
	
	<%@ include file="../common/footer.jsp" %>


</body>
</html>