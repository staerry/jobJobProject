<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
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
        <div class="mentor-category-area">
            <div class="category-navi">
                <ul class="category-select">
                    <li id="select-all">
                        <input type="checkbox" name="mtCategory" value="all" checked>
                        <label for="all">전체</label>
                        <!-- 전체 선택하면 나머지 체크박스에 모두 체크되게 가능? -->
                    </li>
                    <li>
                        <input type="checkbox" id="it" name="mtCategory" value="it">
                        <label for="it">IT 개발</label>
                    </li>
                    <li>
                        <input type="checkbox" id="marketing" name="mtCategory" value="marketing">
                        <label for="marketing">마케팅•MD•영업</label>
                    </li>
                    <li>
                        <input type="checkbox" id="accounting" name="mtCategory" id="accounting">
                        <label for="accounting">회계•재무•금융</label>
                    </li>
                    <li>
                        <input type="checkbox" id="strategy" name="mtCategory" id="strategy">
                        <label for="strategy">전략•기획</label>
                    </li>
                    <li>
                        <input type="checkbox" id="distribution" name="mtCategory" id="distribution">
                        <label for="distribution">유통•무역•구매</label>
                    </li>
                    <li>
                        <input type="checkbox" id="public" name="mtCategory" id="public">
                        <label for="public">공사•공기업•공무원</label>
                    </li>
                    <li>
                        <input type="checkbox" id="special" name="mtCategory" id="special">
                        <label for="special">전문•특수</label>
                    </li>
                </ul>  
                
                <div class="search-btn-area">
                    <button id="mentor-search">멘토 찾기</button>  
                </div>
            </div>
        </div>

        <!-- 오른쪽 멘토 목록 영역 -->
        <div class="mentor-list-area">
            <!-- 멘토 목록 헤더 -->
            <div class="mentor-list-header">
                <h2>멘토링</h2>
                <p>업계 선배들 혹은 동료들에게서 인사이트를 얻어보세요.</p>
            </div>

            <!-- 멘토 목록 -->
            <div class="mentor-list">
                
                <!-- 멘토 개별 카드 -->
                <div class="mentor-card">
                    <!-- 멘토 프로필 -->
                    <table id="profile-tb">
                        <tr>
                            <td align="center">
                                <div class="mentor-photo-wrap">
                                    <img src="../../resources/image/mentorSelect/sampleProfile.jpeg" id="mentor-image">
                                </div>
                            </td>
                        </tr>
                        <tr>
                            <td>%= 회원명 %</td>
                        </tr>
                        <tr>
                            <td>%= 소속회사 %</td>
                        </tr>
                        <tr>
                            <td id="button-cell" align="center">
                                <button onclick="" id="mentor-visit">방문하기</button>
                            </td>
                        </tr>
                    </table>
                </div>

                <div class="mentor-card">
                    <!-- 멘토 프로필 -->
                    <table id="profile-tb">
                        <tr>
                            <td align="center">
                                <div class="mentor-photo-wrap">
                                    <img src="../../resources/image/mentorSelect/sampleProfile.jpeg" id="mentor-image">
                                </div>
                            </td>
                        </tr>
                        <tr>
                            <td>%= 회원명 %</td>
                        </tr>
                        <tr>
                            <td>%= 소속회사 %</td>
                        </tr>
                        <tr>
                            <td id="button-cell" align="center">
                                <button onclick="" id="mentor-visit">방문하기</button>
                            </td>
                        </tr>
                    </table>
                </div>

                <div class="mentor-card">
                    <!-- 멘토 프로필 -->
                    <table id="profile-tb">
                        <tr>
                            <td align="center">
                                <div class="mentor-photo-wrap">
                                    <img src="../../resources/image/mentorSelect/sampleProfile.jpeg" id="mentor-image">
                                </div>
                            </td>
                        </tr>
                        <tr>
                            <td>%= 회원명 %</td>
                        </tr>
                        <tr>
                            <td>%= 소속회사 %</td>
                        </tr>
                        <tr>
                            <td id="button-cell" align="center">
                                <button onclick="" id="mentor-visit">방문하기</button>
                            </td>
                        </tr>
                    </table>
                </div>

                <div class="mentor-card">
                    <!-- 멘토 프로필 -->
                    <table id="profile-tb">
                        <tr>
                            <td align="center">
                                <div class="mentor-photo-wrap">
                                    <img src="../../resources/image/mentorSelect/sampleProfile.jpeg" id="mentor-image">
                                </div>
                            </td>
                        </tr>
                        <tr>
                            <td>%= 회원명 %</td>
                        </tr>
                        <tr>
                            <td>%= 소속회사 %</td>
                        </tr>
                        <tr>
                            <td id="button-cell" align="center">
                                <button onclick="" id="mentor-visit">방문하기</button>
                            </td>
                        </tr>
                    </table>
                </div>

                <div class="mentor-card">
                    <!-- 멘토 프로필 -->
                    <table id="profile-tb">
                        <tr>
                            <td align="center">
                                <div class="mentor-photo-wrap">
                                    <img src="../../resources/image/mentorSelect/sampleProfile.jpeg" id="mentor-image">
                                </div>
                            </td>
                        </tr>
                        <tr>
                            <td>%= 회원명 %</td>
                        </tr>
                        <tr>
                            <td>%= 소속회사 %</td>
                        </tr>
                        <tr>
                            <td id="button-cell" align="center">
                                <button onclick="" id="mentor-visit">방문하기</button>
                            </td>
                        </tr>
                    </table>
                </div>

                <div class="mentor-card">
                    <!-- 멘토 프로필 -->
                    <table id="profile-tb">
                        <tr>
                            <td align="center">
                                <div class="mentor-photo-wrap">
                                    <img src="../../resources/image/mentorSelect/sampleProfile.jpeg" id="mentor-image">
                                </div>
                            </td>
                        </tr>
                        <tr>
                            <td>%= 회원명 %</td>
                        </tr>
                        <tr>
                            <td>%= 소속회사 %</td>
                        </tr>
                        <tr>
                            <td id="button-cell" align="center">
                                <button onclick="" id="mentor-visit">방문하기</button>
                            </td>
                        </tr>
                    </table>
                </div>

                <div class="mentor-card">
                    <!-- 멘토 프로필 -->
                    <table id="profile-tb">
                        <tr>
                            <td align="center">
                                <div class="mentor-photo-wrap">
                                    <img src="../../resources/image/mentorSelect/sampleProfile.jpeg" id="mentor-image">
                                </div>
                            </td>
                        </tr>
                        <tr>
                            <td>%= 회원명 %</td>
                        </tr>
                        <tr>
                            <td>%= 소속회사 %</td>
                        </tr>
                        <tr>
                            <td id="button-cell" align="center">
                                <button onclick="" id="mentor-visit">방문하기</button>
                            </td>
                        </tr>
                    </table>
                </div>

                <div class="mentor-card">
                    <!-- 멘토 프로필 -->
                    <table id="profile-tb">
                        <tr>
                            <td align="center">
                                <div class="mentor-photo-wrap">
                                    <img src="../../resources/image/mentorSelect/sampleProfile.jpeg" id="mentor-image">
                                </div>
                            </td>
                        </tr>
                        <tr>
                            <td>%= 회원명 %</td>
                        </tr>
                        <tr>
                            <td>%= 소속회사 %</td>
                        </tr>
                        <tr>
                            <td id="button-cell" align="center">
                                <button onclick="" id="mentor-visit">방문하기</button>
                            </td>
                        </tr>
                    </table>
                </div>
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