<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import="com.jj.common.model.vo.PageInfo, java.util.ArrayList, com.jj.community.model.vo.Community"%> 
    
<% 
	PageInfo pi = (PageInfo)request.getAttribute("pi");
	ArrayList<Community> list = (ArrayList<Community>)request.getAttribute("list");
	
	int categoryNo = (int)request.getAttribute("categoryNo");
	
	int currentPage = pi.getCurrentPage();
	int startPage = pi.getStartPage();
	int endPage = pi.getEndPage();
	int maxPage = pi.getMaxPage();
	
%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<link rel="stylesheet" href="${pageContext.request.contextPath}/resources/common/css/setting.css">
<link rel="stylesheet" href="${pageContext.request.contextPath}/resources/css/community/communityListView.css">


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

	<!-- 왼쪽 메뉴바  -->
	<%@ include file="common/communityMenubar.jsp" %>
	
        <!-- 오른쪽 게시판 목록 영역 -->
        <div class="community-list-area">
            <!-- 게시판 소개 -->
            <div class="community-list-header">
                <h3><%= list.get(0).getCommCategory() %></h3>
                <div class="community-search-bar">
                    <input type="search" name="searchKeyword" id="search-keyword" placeholder="궁금한 질문을 검색해 보세요!">
                    <button onclick=""><i class="far fa-search"></i>&nbsp;검색</button>
                </div>
            </div>

            <!-- 게시물 정렬 및 글쓰기 버튼-->
            <div class="community-sorting">
                <span class="community-sorting-order">
                    <ul class="community-sorting-standard"> 
                        <li onclick="">• 최신 순</li>
                        <li onclick="">• 좋아요 순</li>
                        <li onclick="">• 조회수 순</li>
                    </ul>                
                </span>

            <!-- 로그인한 회원들에게만 글쓰기 버튼 노출 -->
                <span class="community-write">
                     <button id="community-write-btn"><i class="far fa-pen"></i>&nbsp;&nbsp;글쓰기</button>
                </span>
                
            </div>

            <!-- 게시물 목록 -->
            <!-- case1. 게시글이 하나도 없을 경우 -->
             <table class="community-content" onclick="">

                <% if(list.isEmpty()) { %>
                <tr id="content-none"> 조회된 게시글이 없습니다.</tr>
				<% }else { %>
				<!-- case2.게시글이 있을 경우 -->
					<% for(Community c : list) { %>
	                <tr>
	                    <td id="community-title"><h5><%= c.getCommTitle() %></h5></td>
	                    <td id="reply-count" rowspan="3">
	                        <div class="reply-zzim-count">
	                            <div class="reply-count-circle">
	                                <span id="reply-count-no"><%= c.getReplyCount() %></span>
	                                <span id="reply-mark">댓글</span>
	                            </div>
	                            <div class="zzim-count-heart">
	                                <span id="zzim-heart"><i class="fas fa-heart"></i></span>
	                                <span id="zzim-count"><%= c.getLikeCount() %></span>
	                            </div>
	                        </div>
	                    </td>
	                </tr>
	                <tr>
	                    <td id="community-body"><p><%= c.getCommContent() %></p></td>
	                    <td  rowspan="2">
	                    </td>
	                </tr>
	                <tr>
	                    <td id="writer-info"><%= c.getCommWriter() %>&nbsp;&nbsp;&nbsp;<%= c.getCreateDate() %></td>
	                </tr>
					<% } %>
                </table>   
                <% } %>
          
      
            <br>
            <br>
            <br>
            
            <!-- 페이징바 영역 -->
            <div class="paging-area">
                <ul class="pagination">
                	<% if(currentPage != 1) { %>	<!-- 보고 있는 페이지가 1번 페이지일 때 이전 버튼선택 X -->
                    	<li class="page-item"><a class="page-link" href="<%= request.getContextPath() %>/list.co?category=<%= categoryNo %>&cpage=<%= currentPage-1 %>">&lt;</a></li>
	                <% } %>
	                
	                <% for(int p=startPage; p<=endPage; p++) { %>
	                    <li class="page-item"><a class="page-link" href="<%= request.getContextPath() %>/list.co?category=<%= categoryNo %>&cpage=<%= p %>"><%= p %></a></li>
	                <% } %>
	                
	                <% if(currentPage != maxPage) { %>    
	                    <li class="page-item"><a class="page-link" href="<%= request.getContextPath() %>/list.co?category=<%= categoryNo %>&cpage=<%= currentPage+1 %>">&gt;</a></li>
	                <% } %>    
                  </ul>
            </div>

        </div>

    </div>


 	<%@ include file="../common/footer.jsp" %>
</body>
</html>