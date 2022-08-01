<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8" import="java.util.ArrayList, com.jj.classSelect.model.vo.Class, com.jj.community.model.vo.Review"%>
<%
	Class c = (Class)request.getAttribute("c");
	ArrayList<Review> list = (ArrayList<Review>)request.getAttribute("list");
	int studentCount = (int)request.getAttribute("studentCount");
	int bookmarkCount = (int)request.getAttribute("bookmarkCount");
	
%>    
    
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">

<!-- css -->
<link rel="stylesheet" href="${pageContext.request.contextPath}/resources/css/setting.css">
<link rel="stylesheet" href="${pageContext.request.contextPath}/resources/css/classSelect/classDetailView.css">

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

        <div class="container-all">
        <!-- 왼쪽 강의 세부 정보 영역 -->
        <div class="class-detail-area">

            <!-- 클래스 제목 -->
            <div class="class-title">
                <h3><%= c.getClTitle() %></h3>
                <p><%= c.getClSubtitle() %></p>
            </div>

            <hr>

            <!-- 클래스 썸네일 -->
            <div class="class-thumbnail">
                <br>
                <img src="<%= c.getClThumbnailPath() %>" id="thumbnail-img">
            </div>

            <!-- 클래스 소개 -->
            <div class="class-intro">
                <h4>강의 소개</h4>
                <p>
                    <%= c.getClInfo() %>
                </p>
            </div>

            <!-- 멘토 소개 -->
            <div class="lecturer-intro">
                <h4>멘토 소개</h4>
                <div class="lecturer-set">
                    <div class="lecturer-photo">
                        <%= c.getLtrProfilePath() %>
                        <img src="프로필이미지경로" id="ltr-profile">
                    </div>

                    <div class="lecturer-profile">
                        <p>
                            <%= c.getLtrCareer() %>
                        </p>
                    </div>
                </div>
            </div>

            <!-- 커리큘럼 -->
            <div class="curriculum-intro">
                <h4>커리큘럼</h4>
                <p>
                    <%= c.getClCurri() %>
                </p>
            </div>

            <hr>

            <!-- 수강후기 -->
            <div class="class-review">
                <div class="review-header">
                    <h4>수강후기</h4>
                    <span class="review-sorting">
                        <ul class="sorting-standard">
                            <li><a href="">최신 순</a></li>
                            <li><a href="">좋아요 순</a></li>
                            <li><a href="">높은 평점 순</a></li>
                            <li><a href="">낮은 평점 순</a></li>
                        </ul>
                    </span>
                </div>

                <div class="review-detail">
                <% if(list.isEmpty()) { %>
                	<p id="no-reivew"> 아직 등록된 수강후기가 없습니다. </p>
                <% }else { %>
                	<% for(Review r : list) { %>
                    <table class="user-review">
                        <tr>
                            <td>평점 : <%= r.getReviewScore() %> 점 (⭐️⭐️⭐️⭐️⭐️로 수정 필요)</td>
                        </tr>
                        <tr>
                            <td id="review-user"><%= r.getUserNo() %></td>
                        </tr>
                        <tr>
                            <td id="review-date"><%= r.getReviewEnrolldate() %></td>
                        </tr>
                        <tr>
                            <td><p id="review-content"><%= r.getReviewContent() %></p></td>
                        </tr>
                    </table>
				<% } %>
				<% } %>
                </div>
            </div>
        </div>

        <!-- 오른쪽 수강신청 메뉴 영역 -->
        <div class="floating-area">
            <div class="class-order">
                
                <!-- 수강료 표시 영역 -->
                <div class="class-price">
                    <h4><%= c.getClPriceWon() %></h4>
                </div>

                <div class="order-btn">
                    <br>
                    <!-- 로그인한 사용자에게만 다음 페이지 이동 허용 -->
                    <!-- 로그인 될 때까지 안되는 상태로 일단 테스트 -->
                    <%-- <% if(loginUser == null) { %> --%>
                    <!-- <button id="class-buy" onclick="pleaseLogin();">수강신청 하기</button><br><br>
                    <button id="class-zzim" onclick="">❤️ 강의 찜하기</button> -->
                    <%-- <% } else { %> --%>
                    <button id="class-buy" onclick="location.href='<%= contextPath %>/enroll.cl?class=<%=c.getClNo()%>';">수강신청 하기</button><br><br>
                    <button id="class-zzim" onclick="">❤️ 강의 찜하기</button>
                    
                    <br><br>
                </div>
                
                <script>
                	function pleaseLogin(){
                	}
                </script>

                <div class="class-info">
                    <table class="class-type">
                        <tr>
                            <td width="100px">수강기한</td>
                            <td><b>무제한</b></td>
                        </tr>
                        <tr>
                            <td>멘토</td>
                            <td><%= c.getUserNo() %></td>
                        </tr>
                        <tr>
                            <td>수강생 수</td>
                            <td><%= studentCount %>명</td>
                        </tr>
                    </table>
                    <div class="heart-icon">
                        <span><i class="bi bi-suit-heart-fill" id="heart"></i></span>
                        <span><%= bookmarkCount %></span></td>
                    </div>

                </div>
            </div>
        </div>
        </div>

    </div>
       
    <%@ include file="../common/footer.jsp" %>
</body>
</html>