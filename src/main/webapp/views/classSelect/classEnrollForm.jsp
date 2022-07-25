<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<!-- css -->
<link rel="stylesheet" href="${pageContext.request.contextPath}/resources/css/setting.css">
<link rel="stylesheet" href="${pageContext.request.contextPath}/resources/css/classSelect/classEnrollForm.css">

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

        <!-- 수강신청 대상 클래스 -->
        <div class="class-info">
            <h2>수강신청</h2>
            <hr>
            <table class="thumbnail-info">
                <tr>
                    <td rowspan="3" width="200" height="150"><img src="썸네일이미지경로" width="200" height="150"></td>
                    <td width="500">
                        <h4>%= 강의명 %</h4>
                    </td>
                </tr>
                <tr>
                    <td>VOD(무제한 수강)</td>
                </tr>
                <tr>
                    <td>%= 회원명(강의자) %</td>
                </tr>
            </table>
        </div>

        <form action="" method="get" id="order-form">
            <!-- 왼쪽 주문 정보 -->
            <div class="user-area">
                <div class="user-header">
                    <h3>구매자 정보</h3>
                    <span>
                        <input type="checkbox" name="infoCopy" id="check-copy">
                        <label for="check-copy">회원정보와 동일</label>
                    </span>
                </div>
                <br>

                <table class="user-info">
                    <tr>
                        <td>이름 <font color="red">*</font>
                        </td>
                    </tr>
                    <tr>
                        <td><input type="text" name="userName" required placeholder="이름을 입력해주세요."></td>
                    </tr>
                    <tr>
                        <td>휴대전화 번호 <font color="red">*</font>
                        </td>
                    </tr>
                    <tr>
                        <td><input type="phone" name="phone" required placeholder="휴대전화 번호(- 포함)"></td>
                    </tr>
                    <tr>
                        <td>이메일 <font color="red">*</font>
                        </td>
                    </tr>
                    <tr>
                        <td><input type="email" name="email" required placeholder="goodee@njnj.com"></td>
                    </tr>
                    <tr>
                        <td></td>
                    </tr>
                </table>
            </div>

            <!-- 오른쪽 상세 결제 정보 -->
            <div class="payment-area">
                <table class="coupon-info" width="100%">
                    <tr>
                        <td colspan="2">
                            <h5>쿠폰</h5>
                        </td>
                    </tr>
                    <tr>
                        <td width="30%">쿠폰 선택</td>
                        <td>
                            <select name="coupon" id="coupon" style="width:350px">
                                <option value="coupon1">%= 쿠폰명1 %</option>
                                <option value="coupon2">%= 쿠폰명2 %</option>
                                <option value="coupon3">%= 쿠폰명3 %</option>
                            </select>
                        </td>
                    </tr>
                </table>
                <br>

                <table class="payment-info">
                    <tr>
                        <td colspan="2">
                            <h5>결제 수단 선택</h5>
                        </td>
                    </tr>
                    <tr>
                        <td width="50%">
                            <input type="radio" id="radio-card" name="payment" value="card">
                            <label for="radio-card">신용카드 결제</label>
                        </td>
                        <td>
                            <input type="radio" id="radio-cash" name="payment" value="cash">
                            <label for="radio-cash">무통장 입금</label>
                        </td>
                    </tr>
                </table>
                <br>

                <table class="payment-total">
                    <tr>
                        <td colspan="2">
                            <h4>총 결제금액</h4>
                        </td>
                    </tr>
                    <tr>
                        <td width="30%">수강료</td>
                        <td align="right">%= 수강료%</td>
                    </tr>
                    <tr>
                        <td width>쿠폰 할인</td>
                        <td align="right">(-) %= 할인금액 %</td>
                    </tr>
                    <tr>
                        <td></td>
                        <td align="right">
                            <h3> %= 수강료 - 할인금액 %원</h3>
                        </td>
                    </tr>
                </table>
                <br>

                <table class="privacy-policy">
                    <tr>
                        <td width="90%">
                            <h5>개인정보 수집 제공</h5>
                        </td>
                        <td>
                            <!-- 개인정보 정책 모달창 -->
                            <button type="button" data-toggle="modal" data-target="#privacyPolicy">
                                보기
                            </button>

                            <div class="modal" id="privacyPolicy">
                                <div class="modal-dialog">
                                    <div class="modal-content">

                                        <!-- Modal body -->
                                        <div class="modal-body">
                                            개인정보 취급방침 ~~~~~~
                                        </div>

                                        <!-- Modal footer -->
                                        <div class="modal-footer">
                                            <button type="button" data-dismiss="modal">Close</button>
                                        </div>

                                    </div>
                                </div>
                            </div>
                        </td>
                    </tr>
                    <tr>
                        <td colspan="2">위 개인 정보 제공 안내 내용을 확인하였으며, 결제에 동의합니다.</td>
                    </tr>
                </table>
                <br>

                <div class="button-area">
                    <button type="submit" id="go-payment">%= 수강료 - 할인금액 %원 결제하기</button>
                </div>                
            </div>
        </form>
    </div>

<%-- 	<%@ include file="../common/footer.jsp" %> --%>

</body>
</html>