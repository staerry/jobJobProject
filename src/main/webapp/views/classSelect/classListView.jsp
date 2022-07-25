<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<!-- css -->
<link rel="stylesheet" href="${pageContext.request.contextPath}/resources/css/setting.css">
<link rel="stylesheet" href="${pageContext.request.contextPath}/resources/css/classSelect/classListView.css">

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

	<%-- <%@ include file="../common/menubar.jsp" %> --%>
 
    <!-- 전체를 감싸는 div -->
    <div class="container">
        <!-- 왼쪽 메뉴바 -->
        <div class="class-category-area">
            <ul class="category-navi">
                <li id="select-all"><a href="">전체</a></li>
                <li><a href="">IT 개발</a></li>
                <li><a href="">마케팅•MD•영업</a></li>
                <li><a href="">회계•재무•금융</a></li>
                <li><a href="">전략•기획</a></li>
                <li><a href="">유통•무역•구매</a></li>
                <li><a href="">공사•공기업•공무원</a></li>
                <li><a href="">전문•특수</a></li>
            </ul>
        </div>

        <!-- 오른쪽 클래스 목록 영역-->
        <div class="class-list-area">
            <h2>분야명(조회된 클래스 수)</h2>

            <!-- 클래스 정렬 버튼 & 박스 영역 -->
            <div class="class-sorting">
                <!-- 클래스 필터 버튼 -->
                <button class="class-sort">
                    <i class="bi bi-funnel"></i>
                    <span id="filter">필터</span>
                    <span>유료 | 무료
                </button>

                <!-- 클래스 정렬 셀렉트 박스 -->
                <span>
                    <select name="classOrder" id="class-order">
                        <option value="recent">최신 순</option>
                        <option value="rating">평점 순</option>
                        <option value="famous">수강생 순</option>
                    </select>
                </span>
            </div>

            <!-- 클래스 목록 -->
            <div class="class-list">
                <div class="class-cover" onclick="">
                    <h4> 클래스명</h4>
                    <span>회원명(강의자)</span><br>
                    <span>소속회사</span><br>
                    <img src="썸네일이미지경로" width="200" height="120"><br>
                    <span id="zzim-count"><i class="bi bi-suit-heart-fill"></i> 찜 횟수</span>
                    <span>₩ 수강료</span>
                </div>

                <div class="class-cover" onclick="">
                    <h4> 클래스명</h4>
                    <span>회원명(강의자)</span><br>
                    <span>소속회사</span><br>
                    <img src="썸네일이미지경로" width="200" height="120"><br>
                    <span id="zzim-count"><i class="bi bi-suit-heart-fill"></i> 찜 횟수</span>
                    <span>₩ 수강료</span>
                </div>

                <div class="class-cover" onclick="">
                    <h4> 클래스명</h4>
                    <span>회원명(강의자)</span><br>
                    <span>소속회사</span><br>
                    <img src="썸네일이미지경로" width="200" height="120"><br>
                    <span id="zzim-count"><i class="bi bi-suit-heart-fill"></i> 찜 횟수</span>
                    <span>₩ 수강료</span>
                </div>

                <div class="class-cover" onclick="">
                    <h4> 클래스명</h4>
                    <span>회원명(강의자)</span><br>
                    <span>소속회사</span><br>
                    <img src="썸네일이미지경로" width="200" height="120"><br>
                    <span id="zzim-count"><i class="bi bi-suit-heart-fill"></i> 찜 횟수</span>
                    <span>₩ 수강료</span>
                </div>

                <div class="class-cover" onclick="">
                    <h4> 클래스명</h4>
                    <span>회원명(강의자)</span><br>
                    <span>소속회사</span><br>
                    <img src="썸네일이미지경로" width="200" height="120"><br>
                    <span id="zzim-count"><i class="bi bi-suit-heart-fill"></i> 찜 횟수</span>
                    <span>₩ 수강료</span>
                </div>

                <div class="class-cover" onclick="">
                    <h4> 클래스명</h4>
                    <span>회원명(강의자)</span><br>
                    <span>소속회사</span><br>
                    <img src="썸네일이미지경로" width="200" height="120"><br>
                    <span id="zzim-count"><i class="bi bi-suit-heart-fill"></i> 찜 횟수</span>
                    <span>₩ 수강료</span>
                </div>

                <div class="class-cover" onclick="">
                    <h4> 클래스명</h4>
                    <span>회원명(강의자)</span><br>
                    <span>소속회사</span><br>
                    <img src="썸네일이미지경로" width="200" height="120"><br>
                    <span id="zzim-count"><i class="bi bi-suit-heart-fill"></i> 찜 횟수</span>
                    <span>₩ 수강료</span>
                </div>

                <div class="class-cover" onclick="">
                    <h4> 클래스명</h4>
                    <span>회원명(강의자)</span><br>
                    <span>소속회사</span><br>
                    <img src="썸네일이미지경로" width="200" height="120"><br>
                    <span id="zzim-count"><i class="bi bi-suit-heart-fill"></i> 찜 횟수</span>
                    <span>₩ 수강료</span>
                </div>


                <h3>////// 무한스크롤 처리가 목표 + top 버튼 ///////</h3>

            </div>
        </div>

    </div>

<%-- 	<%@ include file="../common/footer.jsp" %> --%>
	
</body>
</html>