<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">

<!-- css -->
<link rel="stylesheet" href="../../resources/css/setting.css">
<link rel="stylesheet" href="../../resources/css/mentorSelect/mentorDetailView.css">
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

	<%-- <%@ include file="../common/menubar.jsp" %> --%>
	
    <!-- 전체를 감싸는 div -->
    <div class="container">
        <div class="mentor-detail-main">
        <!-- 왼쪽 멘토 프로필 카드 -->
            <div class="card-area">
                <!-- 멘토 사진 감싸는 부분 -->
                <div class="image-wrap">
                    <div class="image-inner">
                        <img src="../../resources/image/mentorSelect/sampleProfile.jpeg" id="mentor-image">
                    </div>
                </div>
                
                <div class="profile-wrap">
                    <table id="mentor-profile">
                        <tr id="mentor-field">
                            <td>%= 분야명 %</td>
                        </tr>
                        <tr id="mentor-name">
                            <td> %= 회원 이름 %<span>&nbsp;멘토</span></td>
                        </tr>
                        <tr id="mentor-job">
                            <td>%= 소속회사 %</td>
                        </tr>
                        <tr id="mentor-stat">
                            <td>%= 직무 %</td>
                        </tr>
                    </table>
                </div>
            </div>

            <!-- 오른쪽 멘토 소개 -->
            <div class="introduce-area">
                <div class="mentor-info">
                    <h3>대표 멘토링 분야</h3>
                    <p>
                        %= 분야명 %
                    </p>
                    <br>

                    <h3>멘토 소개</h3>
                    <p>
                        %= 강의자 자기소개 %
                    </p>
                    <br>

                    <h3>주요 경력</h3>
                    <p>
                        %= 강의자 경력소개 %
                    </p>
                </div>
            </div>
        </div>

        <!-- 강의, 질문 영역 이동 버튼 -->
        <div class="menu-area">
            <button onclick="" style="margin-right:50px;">멘토 강의보기</button>
            <button onclick="">멘토에게 질문하기</button>
        </div>

        <hr>

        <!-- 강의 리스트 -->
        <div class="class-area">
            <h2>강의</h2>
            <!-- 등록된 클래스가 있을 경우 -->
            <div class="mentor-class-list">
                <div class="class-thumbnail">
                    <img src="썸네일이미지경로" width="200" height="150" style="margin:10px">
                    <p style="margin:10px">
                        %= 클래스 제목 % <br>
                        %= 회원명(강의자) %
                    </p>
                </div>

                <div class="class-thumbnail">
                    <img src="썸네일이미지경로" width="200" height="150" style="margin:10px">
                    <p style="margin:10px">
                        %= 클래스 제목 % <br>
                        %= 회원명(강의자) %
                    </p>
                </div>

                <div class="class-thumbnail">
                    <img src="썸네일이미지경로" width="200" height="150" style="margin:10px">
                    <p style="margin:10px">
                        %= 클래스 제목 % <br>
                        %= 회원명(강의자) %
                    </p>
                </div>
            </div>

            <!-- 등록된 클래스가 없을 경우 -->
            <p>등록된 콘텐츠가 없습니다.</p>
            
        </div>

        <hr>

        <div class="question-area">
            <div class="question-header">
                <h2>멘토에게 질문하기</h2>
                <ul class="question-sorting">
                    <li onclick="">최신 순</li>
                    <li onclick="">좋아요 순</li>
                    <li onclick="">높은 평점 순</li>
                    <li onclick="">낮은 평점 순</li>
                </ul>
            </div>

            <!-- 멘토에게 질문 작성 -->
            <div class="question-insert">
                <table class="question-write">
                    <tr>
                        <td><input type="text" name="title" id="questionTitle" required placeholder="멘토에게 질문해 보세요." size="101"></td>
                    </tr>
                    <tr>
                        <td><textarea cols="100" rows="5" style="resize:none">내용은 최소 50자 이상 작성해 주세요.</textarea></td>
                    </tr>
                    <tr align="right">
                        <td><button id="question-enroll">등록</button></td>
                    </tr>
                    <tr>
                        <td></td>
                    </tr>
                </table>
            </div>

            <!-- 멘토의 답변이 완료된 질문+답변 -->
            <div class="question-reply-select">
                <table class="user-question">
                    <tr>
                        <td style="width:760px">%= 회원명 %</td>
                    </tr>
                    <tr>
                        <td>%= 작성일 % xxxx-xx-xx xx:xx:xx</td>
                    </tr>
                    <tr>
                        <td>%= 질문제목 %</td>
                    </tr>
                    <tr>
                        <td>%= 질문내용 %</td>
                    </tr>
                </table>
                <br>

                <table class="mentor-reply">
                    <tr>
                        <td style="width:200px" rowspan="3">
                            <img src="멘토프로필사진"><br>
                            멘토프로필사진
                        </td>
                        <td style="width:610px">%= 회원명 % <span>멘토표시</span></td>
                    </tr>
                    <tr>
                        <td>%= 답변일 % xxxx-xx-xx</td>
                    </tr>
                    <tr>
                        <td>%= 답변내용 %</td>
                    </tr>
                </table>
                <br>
            </div>

            <div class="question-reply-select">
                <table class="user-question">
                    <tr>
                        <td style="width:760px">%= 회원명 %</td>
                    </tr>
                    <tr>
                        <td>%= 작성일 % xxxx-xx-xx xx:xx:xx</td>
                    </tr>
                    <tr>
                        <td>%= 질문제목 %</td>
                    </tr>
                    <tr>
                        <td>%= 질문내용 %</td>
                    </tr>
                </table>
                <br>

                <table class="mentor-reply">
                    <tr>
                        <td style="width:200px" rowspan="3">
                            <img src="멘토프로필사진"><br>
                            멘토프로필사진
                        </td>
                        <td style="width:610px">%= 회원명 % <span>멘토표시</span></td>
                    </tr>
                    <tr>
                        <td>%= 답변일 % xxxx-xx-xx</td>
                    </tr>
                    <tr>
                        <td>%= 답변내용 %</td>
                    </tr>
                </table>
                <br>
            </div>

            <div class="question-reply-select">
                <table class="user-question">
                    <tr>
                        <td style="width:760px">%= 회원명 %</td>
                    </tr>
                    <tr>
                        <td>%= 작성일 % xxxx-xx-xx xx:xx:xx</td>
                    </tr>
                    <tr>
                        <td>%= 질문제목 %</td>
                    </tr>
                    <tr>
                        <td>%= 질문내용 %</td>
                    </tr>
                </table>
                <br>

                <table class="mentor-reply">
                    <tr>
                        <td style="width:200px" rowspan="3">
                            <img src="멘토프로필사진"><br>
                            멘토프로필사진
                        </td>
                        <td style="width:610px">%= 회원명 % <span>멘토표시</span></td>
                    </tr>
                    <tr>
                        <td>%= 답변일 % xxxx-xx-xx</td>
                    </tr>
                    <tr>
                        <td>%= 답변내용 %</td>
                    </tr>
                </table>
                <br>
            </div>
        </div>

        /// 무한 스크롤 + top 버튼 ///

        


    </div>

	
	<%-- 	<%@ include file="../common/footer.jsp" %> --%>

</body>
</html>