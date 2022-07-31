<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8" import="java.util.ArrayList, com.jj.mentorSelect.model.vo.Lecturer"%>
<% 
	int listCount = (int)request.getAttribute("listCount");
	ArrayList<Lecturer> list = (ArrayList<Lecturer>)request.getAttribute("list");
%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<!-- css -->
<link rel="stylesheet" href="${pageContext.request.contextPath}/resources/css/setting.css">
<link rel="stylesheet" href="${pageContext.request.contextPath}/resources/css/mentorSelect/mentorListView.css">
<meta charset="UTF-8">

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
		<%@ include file="common/mentorMenubar.jsp" %>
	
        <!-- 오른쪽 멘토 목록 영역 -->
        <div class="mentor-list-area">
            <!-- 멘토 목록 헤더 -->
            <div class="mentor-list-header">
                <h2>멘토링</h2>
                <p>업계 선배들 혹은 동료들에게서 인사이트를 얻어보세요.</p>
            </div>

            <!-- 멘토 목록 -->
            <div class="mentor-list">
                
                <% if(list.isEmpty()) { %>
                <p> 활동 중인 멘토가 없습니다. </p>
                <% }else { %>
                <% for(Lecturer l : list) { %>
                <!-- 멘토 개별 카드 -->
                <div class="mentor-card">
                    <!-- 멘토 프로필 -->
                    <table id="profile-tb">
                        <tr>
                            <td align="center">
                                <div class="mentor-photo-wrap">
                                    <img src="<%= l.getLtrProfilePath() %>" id="mentor-image">
                                </div>
                            </td>
                        </tr>
                        <tr>
                            <td><%= l.getUserName() %></td>
                        </tr>
                        <tr>
                            <td><%= l.getLtrCompany() %></td>
                        </tr>
                        <tr>
                            <td id="button-cell" align="center">
                                <button onclick="location.href='<%= contextPath %>/detail.lt';" id="mentor-visit">방문하기</button>
                            </td>
                        </tr>
                    </table>
                </div>
                <% } %>
                <% } %>
            </div>
            
            <div class="paging-area">
                <ul class="pagination">
                    <li class="page-item disabled"><a class="page-link" href="#">Previous</a></li>
                    <li class="page-item"><a class="page-link" href="#">1</a></li>
                    <li class="page-item"><a class="page-link" href="#">2</a></li>
                    <li class="page-item"><a class="page-link" href="#">3</a></li>
                    <li class="page-item"><a class="page-link" href="#">4</a></li>
                    <li class="page-item"><a class="page-link" href="#">5</a></li>
                    <li class="page-item"><a class="page-link" href="#">Next</a></li>
                  </ul>
            </div>

        </div>

    </div> 
	
	
	<%@ include file="../common/footer.jsp" %>
</body>
</html>