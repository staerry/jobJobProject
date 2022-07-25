<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
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
        <!-- 게시판 카테고리 영역 -->
        <div class="community-category-area">
            <ul class="community-categroy-navi">
                <li id="community-head">커뮤니티</li>
                <li><a href="">직무질문</a></li>
                <li><a href="">고민상담</a></li>
                <li><a href="">스터디</a></li>
                <li><a href="">수강후기</a></li>
            </ul>
        </div>

        <!-- 게시판 목록 영역 -->
        <div class="community-list-area">
            <!-- 게시판 소개 -->
            <div class="community-list-header">
                <h3>%= 카테고리명 %</h3>
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
            <table class="community-content" onclick="">
                <tr>
                    <td id="community-title"><h5>제목이 들어갈 자리입니다.</h5></td>
                    <td id="reply-count" rowspan="3">
                        <div class="reply-zzim-count">
                            <div class="reply-count-circle">
                                <span id="reply-count-no">댓글 수</span>
                                <span id="reply-mark">답변</span>
                            </div>
                            <div class="zzim-count-heart">
                                <span id="zzim-heart"><i class="fas fa-heart"></i></span>
                                <span id="zzim-count">찜수</span>
                            </div>
                        </div>
                    </td>
                </tr>
                <tr>
                    <td id="community-body"><p>내용이 들어갈 자리입니다. 

                        개인적인 사정때문에 취업이 급해 퍼블리셔로 일하고 있습니다. 
                        
                        마음 한켠으로는 프론트로 이직하고 싶은 마음을 가지며 일하고 있는데 ux엔지니어라는게 있더라고요.</p></td>
                    <td  rowspan="2">
                    </td>
                </tr>
                <tr>
                    <td id="writer-info">%= 회원명 % %= 작성일 %</td>
                </tr>
            </table>            

            <table class="community-content" onclick="">
                <tr>
                    <td id="community-title"><h5>%= 게시글 제목 %</h5></td>
                    <td id="reply-count" rowspan="3">
                        <div class="reply-zzim-count">
                            <div class="reply-count-circle">
                                <span id="reply-count-no">댓글 수</span>
                                <span id="reply-mark">답변</span>
                            </div>
                            <div class="zzim-count-heart">
                                <span id="zzim-heart"><i class="fas fa-heart"></i></span>
                                <span id="zzim-count">찜수</span>
                            </div>
                        </div>
                    </td>
                </tr>
                <tr>
                    <td id="community-body"><p>%= 게시글 내용 %<br>안녕하세요. 

                        개인적인 사정때문에 취업이 급해 퍼블리셔로 일하고 있습니다. 
                        
                        마음 한켠으로는 프론트로 이직하고 싶은 마음을 가지며 일하고 있는데 ux엔지니어라는게 있더라고요.</p></td>
                    <td  rowspan="2">
                    </td>
                </tr>
                <tr>
                    <td id="writer-info">%= 회원명 % %= 작성일 %</td>
                </tr>
            </table>            

            <table class="community-content" onclick="">
                <tr>
                    <td id="community-title"><h5>%= 게시글 제목 %</h5></td>
                    <td id="reply-count" rowspan="3">
                        <div class="reply-zzim-count">
                            <div class="reply-count-circle">
                                <span id="reply-count-no">댓글 수</span>
                                <span id="reply-mark">답변</span>
                            </div>
                            <div class="zzim-count-heart">
                                <span id="zzim-heart"><i class="fas fa-heart"></i></span>
                                <span id="zzim-count">찜수</span>
                            </div>
                        </div>
                    </td>
                </tr>
                <tr>
                    <td id="community-body"><p>%= 게시글 내용 %<br>안녕하세요. 

                        개인적인 사정때문에 취업이 급해 퍼블리셔로 일하고 있습니다. 
                        
                        마음 한켠으로는 프론트로 이직하고 싶은 마음을 가지며 일하고 있는데 ux엔지니어라는게 있더라고요.</p></td>
                    <td  rowspan="2">
                    </td>
                </tr>
                <tr>
                    <td id="writer-info">%= 회원명 % %= 작성일 %</td>
                </tr>
            </table>            

            <table class="community-content" onclick="">
                <tr>
                    <td id="community-title"><h5>%= 게시글 제목 %</h5></td>
                    <td id="reply-count" rowspan="3">
                        <div class="reply-zzim-count">
                            <div class="reply-count-circle">
                                <span id="reply-count-no">댓글 수</span>
                                <span id="reply-mark">답변</span>
                            </div>
                            <div class="zzim-count-heart">
                                <span id="zzim-heart"><i class="fas fa-heart"></i></span>
                                <span id="zzim-count">찜수</span>
                            </div>
                        </div>
                    </td>
                </tr>
                <tr>
                    <td id="community-body"><p>%= 게시글 내용 %<br>안녕하세요. 

                        개인적인 사정때문에 취업이 급해 퍼블리셔로 일하고 있습니다. 
                        
                        마음 한켠으로는 프론트로 이직하고 싶은 마음을 가지며 일하고 있는데 ux엔지니어라는게 있더라고요.</p></td>
                    <td  rowspan="2">
                    </td>
                </tr>
                <tr>
                    <td id="writer-info">%= 회원명 % %= 작성일 %</td>
                </tr>
            </table>            

            <table class="community-content" onclick="">
                <tr>
                    <td id="community-title"><h5>%= 게시글 제목 %</h5></td>
                    <td id="reply-count" rowspan="3">
                        <div class="reply-zzim-count">
                            <div class="reply-count-circle">
                                <span id="reply-count-no">댓글 수</span>
                                <span id="reply-mark">답변</span>
                            </div>
                            <div class="zzim-count-heart">
                                <span id="zzim-heart"><i class="fas fa-heart"></i></span>
                                <span id="zzim-count">찜수</span>
                            </div>
                        </div>
                    </td>
                </tr>
                <tr>
                    <td id="community-body"><p>%= 게시글 내용 %<br>안녕하세요. 

                        개인적인 사정때문에 취업이 급해 퍼블리셔로 일하고 있습니다. 
                        
                        마음 한켠으로는 프론트로 이직하고 싶은 마음을 가지며 일하고 있는데 ux엔지니어라는게 있더라고요.</p></td>
                    <td  rowspan="2">
                    </td>
                </tr>
                <tr>
                    <td id="writer-info">%= 회원명 % %= 작성일 %</td>
                </tr>
            </table>       
            <br>
            <br>
            <br>
            

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