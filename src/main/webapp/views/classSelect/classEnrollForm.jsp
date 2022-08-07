<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"
    import="com.jj.classSelect.model.vo.Class, java.util.ArrayList, com.jj.coupon.vo.IssuanceCoupon"
%>
    
<%
	Class c = (Class)request.getAttribute("c");
	ArrayList<IssuanceCoupon> cpList = (ArrayList<IssuanceCoupon>)request.getAttribute("list");
	
	String userName = (String)((Member)request.getSession().getAttribute("loginUser")).getUserName();
	String userPhone = (String)((Member)request.getSession().getAttribute("loginUser")).getUserPhone();
	String userEmail = (String)((Member)request.getSession().getAttribute("loginUser")).getUserEmail();
	
	
%>    
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

	<%@ include file="../common/menubar.jsp" %>

	<div class="container">
	
		<div class="class-enroll">

			<div class="class-info">
				<h3>수강신청</h3>
				<hr>

				<table class="class-summary">
					<tr>
						<td rowspan="3" width"200" height="150"><img src="<%= contextPath %>/<%= c.getClThumbnailPath() %>" width="200" height="150"></td>
						<td width="500"><h5><%= c.getClTitle() %></h5></td>
					</tr>
					<tr><td><%= c.getClPriceWon() %>&nbsp;&nbsp;|&nbsp;&nbsp;VOD (무제한 수강)</td></tr>
					<tr><td><%= c.getUserNo() %></td>
				</table>

			<hr>
			</div>

			<script>
				function getDc(event) {
					document.getElementById('coupon-discount').value = event.target.value;
					document.getElementById('total-price').value = <%= c.getClPrice() %> - event.target.value;
				}
			</script>
			
			<form action="<%= contextPath %>/enroll.cl" method="post" id="order-form">
				<input type="hidden" name="clNo" value="<%= c.getClNo() %>">
				<div class="order-info-area">
					<div class="user-info">
						<h4>구매자 정보</h4>
						<p>회원 정보와 구매자 정보가 다른 경우 직접 입력해 주세요.<br><br></p>
						
						<table id="order-info-table">
						<tr>
							<td><h5>이름 <font color="red">*</font></h5></td>
							<td><input type="text" name="orderName" id="userName" value="<%= userName %>" required ></td>
						</tr>
						<tr>
							
						</tr>
						<tr>
							<td><h5>휴대전화 번호 <font color="red">*</font> (- 포함)</h5></td>
							<td><input type="phone" name="orderPhone" id="userPhone" value="<%= userPhone %>" required></td>
						</tr>
						<tr>
							
						</tr>
						<tr>
							<td><h5>이메일 <font color="red">*</font></h5></td>
							<td><input type="email" name="orderEmail" id="userEmail" value="<%= userEmail %>" required placeholder="goodee@njnj.com"></td>
						</tr>
						<tr>
							
						</tr>
						<tr>
							<td><h5>결제수단</h5></td>
							<td>
								<input type="radio" id="radio-card" name="payment" value="신용카드" required>
								<label for="radio-card">신용카드 결제</label><br>
								<input type="radio" id="radio-cash" name="payment" value="무통장 입금" required>
								<label for="radio-cash">무통장 입금</label>
							</td>
						</tr>
						<tr>
							
						</tr>
						<tr>
							<td colspan="2"><h5>쿠폰</h5></td>
						</tr>
						<tr>
							<td colspan="2"><% if(!cpList.isEmpty()) { %>
								<% for(IssuanceCoupon cp : cpList) { %>
								<input type="radio" name="coupon" value="<%= cp.getDiscount() %>" id="dc-coupon" onclick="getDc(event)" required>
								<input type="hidden" name="isuCpNo" value="<%= cp.getIsuCpNo() %>">
								<label for="dc-coupon">&nbsp;<%= cp.getCpName() %> ----- <%=cp.getDiscountWon() %> 할인</label><br>		
								<% } %>
								<input type="radio" name="coupon" value="0" id="no-coupon" onclick="getDc(event)" required> 
								<label for="no-coupon">&nbsp;사용 안 함</label>
								<% }else { %>
								<input type="radio" name="coupon" value="0" id="no-coupon" onclick="getDc(event)" required>
								<label for="no-coupon">&nbsp;보유 중인 쿠폰이 없습니다.</label>
								<% } %></td>
						</tr>
						<tr>
							<td colspan=><h5>개인정보 취급방침</h5>
							<td>	
								<!-- Button to Open the Modal -->
								<button type="button" class="btn btn-outline-dark" data-toggle="modal" data-target="#myModal">
									자세히 보기
								</button>
								
								<!-- The Modal -->
								<div class="modal fade" id="myModal">
									<div class="modal-dialog modal-lg">
									<div class="modal-content">
									
										<!-- Modal Header -->
										<div class="modal-header">
										<h4>구매조건 및 개인정보취급방침</h4>
										<button type="button" class="close" data-dismiss="modal">&times;</button>
										</div>
										
										<!-- Modal body -->
										<div class="modal-body">
											<p>
											제 3장. 유료 서비스 <br>
											제 19조. 유료서비스의 제공<br>
											
											“회원”은 “회사”가 제공하는 절차에 의하여 유료서비스 이용계약(이하 “청약”을 신청합니다. “회사”는 원칙적으로 “회원”의 청약 신청을 승낙합니다. 다만, 다음 각 호에 해당하는 경우에는 승낙하지 않거나 승낙을 유보할 수 있습니다.<br>
											실명이 아니거나 타인의 명의를 이용한 경우<br>
											허위의 정보를 기재하거나, "회사”가 제시하는 내용을 기재하지 않은 경우<br>
											미성년자가 청소년보호법 등 관련법에 의해서 이용이 금지되는 유료 서비스를 이용하고자 하는 경우<br>
											"서비스"의 위상이나 명예에 부정적인 영향을 줄 수 있는 경우<br>
											“유료서비스"에서 제공하는 서비스의 공급량의 제한의 이유로 "서비스"를 제공할 수 없는 경우<br>
											이 약관에 위배되는 내용을 “회사”에 요구한 이력이 있는 “회원”일 경우<br>
											질문에 대한 권리는 “유료서비스”에 포함되지 않습니다.<br>
											청약의 성립시기는 결제가 완료된 시점으로 합니다.<br>
											“회사”는 계약 체결 전에 “회원”이 청약의 내용을 확인하고, 정정 또는 취소할 수 있도록 적절한 절차를 갖추어야 합니다.<br>
											“회원”는 계약 전에 이 약관 및 개별 안내 페이지에서 “회사”가 안내하는 사항을 숙지하여 착오 없이 거래할 수 있도록 하여야 합니다.<br>
											</p>
										</div>
									</div>
									</div>
								</div>
								</div></td>
							</td>
						</tr>
						<tr>
							<td><h4>총 결제 금액</h4></td>
						</tr>
						<tr>
							<td colspan="2" align="center"><input type="text" id="origin-price" value="<%=c.getClPrice() %>" readonly required>
								<span>&nbsp; - &nbsp;</span>
								<input type="text" id="coupon-discount" value="" readonly required>
								<span>&nbsp; = &nbsp;</span>
								<input type="text" name="totalPrice" id="total-price" value="" readonly required><span> 원</span>
							</td>
						</tr>
						<tr>
							<td colspan="2" align="center">회원 본인은 주문 내용을 확인했으며, 구매조건 및 개인정보 취급방침과 결제에 동의합니다.</td>
						</tr>
						<tr>
							<td colspan="2" align="center"><button type="submit" id="class-enroll-btn" onclick="return payConfirm();">결제하기</button></td>
						</tr>
						</table>
						
						<script>
                           	function payConfirm() {
                           		if(confirm('결제를 진행하시겠습니까?')) {
                           			return true;
                           		}else {
                           			return false;
                           		}
                           	}
                        </script>
	                            
					</div>
				</div>
			</form>
		</div>
	</div>

	<%@ include file="../common/footer.jsp" %>

</body>
</html>