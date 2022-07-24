<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">

<!-- css -->
<link rel="stylesheet" href="../../resources/css/setting.css">
<link rel="stylesheet" href="../../resources/css/classSelect/classDetailView.css">

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

        <!-- 왼쪽 강의 세부 정보 영역 -->
        <div class="class-detail-area">

            <!-- 클래스 제목 -->
            <div class="class-title">
                <h2>%= 클래스제목 %</h2>
                <p>%= 클래스소제목 %</p>
            </div>

            <hr>

            <!-- 클래스 썸네일 -->
            <div class="class-thumbnail">
                %= 강의 썸네일이미지 (760*430) % <br>
                <img src="썸네일이미지경로" id="thumbnail-img">
            </div>

            <!-- 클래스 소개 -->
            <div class="class-intro">
                <h3>강의 소개</h3>
                <p>
                    %= 클래스소개 %
                </p>
            </div>

            <!-- 멘토 소개 -->
            <div class="lecturer-intro">
                <h3>멘토 소개</h3>
                <div class="lecturer-set">
                    <div class="lecturer-photo">
                        %= 프로필이미지경로 (180*220) %
                        <img src="프로필이미지경로">
                    </div>

                    <div class="lecturer-profile">
                        <p>
                            %= 강의자경력소개 %
                        </p>
                    </div>
                </div>
            </div>

            <!-- 커리큘럼 -->
            <div class="curriculum-intro">
                <h2>커리큘럼</h2>
                <p>
                    %= 커리큘럼 %
                </p>
            </div>

            <hr>

            <!-- 수강후기 -->
            <div class="class-review">
                <div class="review-header">
                    <h2>수강후기</h2>
                    <span class="review-sorting">
                        <ul class="sorting-standard">
                            <li><a href="">최신 순</a></li>
                            <li><a href="">좋아요 순</a></li>
                            <li><a href="">높은 평점 순</a></li>
                            <li><a href="">낮은 평점 순</a></li>
                        </ul>
                    </span>
                </div>
                <br>

                <div class="review-detail">
                    <table class="user-review">
                        <tr>
                            <td>별점자리 ⭐️⭐️⭐️⭐️⭐️</td>
                        </tr>
                        <tr>
                            <td>%= 회원명 %</td>
                        </tr>
                        <tr>
                            <td>%= 작성일 xxxx-xx-xx %</td>
                        </tr>
                        <tr>
                            <td>%= 수강후기내용 %</td>
                        </tr>
                    </table>
                    <br>

                    <table class="user-review">
                        <tr>
                            <td>별점자리 ⭐️⭐️⭐️⭐️⭐️</td>
                        </tr>
                        <tr>
                            <td>%= 회원명 %</td>
                        </tr>
                        <tr>
                            <td>%= 작성일 xxxx-xx-xx %</td>
                        </tr>
                        <tr>
                            <td>%= 수강후기내용 %</td>
                        </tr>
                    </table>
                    <br>

                    <table class="user-review">
                        <tr>
                            <td>별점자리 ⭐️⭐️⭐️⭐️⭐️</td>
                        </tr>
                        <tr>
                            <td>%= 회원명 %</td>
                        </tr>
                        <tr>
                            <td>%= 작성일 xxxx-xx-xx %</td>
                        </tr>
                        <tr>
                            <td>%= 수강후기내용 %</td>
                        </tr>
                    </table>
                    <br>

                    <table class="user-review">
                        <tr>
                            <td>별점자리 ⭐️⭐️⭐️⭐️⭐️</td>
                        </tr>
                        <tr>
                            <td>%= 회원명 %</td>
                        </tr>
                        <tr>
                            <td>%= 작성일 xxxx-xx-xx %</td>
                        </tr>
                        <tr>
                            <td>%= 수강후기내용 %</td>
                        </tr>
                    </table>
                </div>
            </div>
        </div>

        <!-- 오른쪽 수강신청 메뉴 영역 -->
        <div class="floating-area">
            <div class="class-order">
                
                <!-- 수강료 표시 영역 -->
                <div class="class-price">
                    <h3>₩ %= 수강료 %</h3>
                </div>

                <div class="order-btn">
                    <br>
                    <button id="class-buy" onclick="">수강신청 하기</button><br><br>
                    <button id="class-zzim" onclick="">❤️ 강의 찜하기</button>
                    <br><br>
                </div>

                <div class="class-info">
                    <table class="class-type">
                        <tr>
                            <td width="100px">수강기한</td>
                            <td><b>무제한</b></td>
                        </tr>
                        <tr>
                            <td>멘토</td>
                            <td>%= 회원명 %</td>
                        </tr>
                        <tr>
                            <td>수강생 수</td>
                            <td>%= 수강생 수%</td>
                        </tr>
                        <tr>
                            <td colspan="2" align="center"><i class="bi bi-suit-heart-fill" id="heart"></i><span>%= 찜 수 %</span></td>
                        </tr>

                    </table>
                    
                </div>
            </div>
        </div>

    </div>
    
    <h2>/// 무한 스크롤 + top 버튼 ///</h2>
    
    <%-- <%@ include file="../common/footer.jsp" %> --%>
</body>
</html>