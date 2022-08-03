<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ page import="com.jj.common.model.vo.PageInfo, java.util.ArrayList, com.jj.community.model.vo.Community" %>

<% 
	int categoryNo = (int)request.getAttribute("categoryNo"); 
	int searchListCount = (int)request.getAttribute("searchListCount"); 
	ArrayList<Community> searchList = (ArrayList<Community>)request.getAttribute("searchList");

%>
<!DOCTYPE html>
<html>

<head>
    <meta charset="UTF-8">
    <link rel="stylesheet" href="${pageContext.request.contextPath}/resources/common/css/setting.css">
    <link rel="stylesheet"
        href="${pageContext.request.contextPath}/resources/css/community/communityListSearchView.css">


    <!-- 폰트어썸 -->
    <script src="https://kit.fontawesome.com/ea8287c514.js" crossorigin="anonymous"></script>

    <!-- 부트스트랩 -->
    <link rel="stylesheet"
        href="https://cdn.jsdelivr.net/npm/bootstrap@4.6.1/dist/css/bootstrap.min.css">
    <script src="https://cdn.jsdelivr.net/npm/jquery@3.6.0/dist/jquery.slim.min.js"></script>
    <script src="https://cdn.jsdelivr.net/npm/popper.js@1.16.1/dist/umd/popper.min.js"></script>
    <script src="https://cdn.jsdelivr.net/npm/bootstrap@4.6.1/dist/js/bootstrap.bundle.min.js"></script>

    <title>Insert title here</title>
</head>

<body>

    <%@ include file="../common/menubar.jsp" %>

        <!-- 전체를 감싸는 div -->
        <div class="container">

            <!-- 왼쪽 메뉴바  -->
            <%@ include file="common/communityMenubar.jsp" %>

                <!-- 오른쪽 게시판 목록 영역 -->
                <div class="community-list-area">
                    <!-- 게시판 소개 -->
                    <div class="community-list-header">
                        <% String categoryName="" ; switch(categoryNo) { case 1: categoryName="직무질문" ;
                            break; case 2: categoryName="고민상담" ; break; case 3: categoryName="스터디" ;
                            break;} %>
                            <h3>
                                <%= categoryName %>
                            </h3>
                            <form action="<%= contextPath %>/search.co">
                                <input type="hidden" name="category" value="<%= categoryNo %>">
                                <div class="community-search-bar">
                                    <input type="search" name="keyword" id="search-keyword" placeholder="니JOB내JOB에서 답을 찾아보세요! (제목 / 내용 / 작성자로 검색 가능)" required>
                                    <button type=submit><i class="far fa-search"></i>&nbsp;검색</button>
                                </div>
                            </form>
                    </div>

                    <!-- 로그인한 회원들에게만 글쓰기 버튼 노출 -->
                    <div class="community-sorting" align="right">
                        <p id="search-result">총 <span id="search-result-count"><%= searchListCount %></span>건의 글이 조회되었습니다.</p>
                    <% if(loginUser != null) { %>
                        <span class="community-write">
                            <button id="community-write-btn" onclick="location.href='<%= request.getContextPath() %>/enrollForm.co';">
                            <i class="far fa-pen"></i>&nbsp;&nbsp;글쓰기</a></button>
                        </span>
                        <% } %>
                    </div>

                    <hr>

                <!-- 게시물 목록 -->
                <div class="search-area">

                    <!-- 게시글이 있을 경우만 테이블 생성 -->
                    <% if(!searchList.isEmpty() ) { %>
                    <table class="community-content">
                        <tr id="result-head" align="center">
                            <td width="70" >no.</td>
                            <td width="300">제목</td>
                            <td width="100">작성자</td>
                            <td width="50">조회수</td>
                            <td width="100">작성일</td>
                        </tr>
                        <% for(Community c : searchList) { %> 
                        <tr id="result-body">
                                <td align="center" style="font-size: 13px;"><%= c.getCommNo() %></td>
                                <td id="result-title" onclick="location.href='<%= contextPath%>/detail.co?contentNo=<%=c.getCommNo()%>'"><%= c.getCommTitle() %></td>
                                <td align="center"><%= c.getCommWriter() %></td>
                                <td align="center"><%= c.getCount() %></td>
                                <td align="center"><%= c.getCreateDate() %></td>
                        </tr>
                        <% } %>
                    <% } %>
                    </table> 
                </div>

            </div>
                <br>
                <br>
                <br>
        </div>
        <%@ include file="../common/footer.jsp" %>
</body>

</html>