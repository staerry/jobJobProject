<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<link rel="stylesheet" href="${pageContext.request.contextPath}/resources/css/admin/mentorInfo.css">
<title>Insert title here</title>
</head>
<body>
	<%if(session.getAttribute("UserInfoAd") == null){ %>
	<script>
		alert("유효하지않은 접근입니다.");
		location.href="<%= request.getContextPath() %>/login.ad";
	</script>
	<%}else{ %>
	<%@ include file="common/topbar.jsp" %>
	<div class="content-wrap">
	    
	    <div class="left">
			<%@ include file="common/menubar.jsp" %>
		</div>
	
	    
	    <div class="right">
	        <h3>멘토 정보</h3>
			<h5>멘토 리스트</h5>

			<div class="checks">
				<div id="formwraping">
					<form action="" style="">
						&nbsp;
						<input type="checkbox" id="check1"> 
						<label for="check1">현직자</label>
						&nbsp;
						<input type="checkbox" id="check2"> 
						<label for="check2">강의자</label>
						<input type="checkbox" id="check3"> 
						<label for="check3">탈퇴한회원</label> &nbsp;&nbsp;
						<input type="text" style="line-height: 30px; width: 200px;" id="searchclick" placeholder="   이름또는 회원번호로 검색">
						<label for="searchclick"><button id="searchbtn" style="line-height: 30px;" class="btnpurple">검색</button></label>
					</form>
				</div>
			</div>
			
			<div style="position:relative ;">
				<div class="detailInfo positionab">
					<h3>멘토정보수정</h3>
					<form>
						<table class="table table-bordered table-hover stutable">
							<tr>
								<th>이름</th>
								<td width="10px"><input type="text" style="margin-right:100px ;" disabled></td>
							</tr>
							<tr>
								<th>멘토분류</th>
								<td width="10px">
									<div class="checks2">
										<input type="radio" id="radio1" name="grade"> 
										<label for="radio1">현직자</label>
										&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
										<input type="radio" id="radio2" name="grade"> 
										<label for="radio2">강의자</label> 
									</div>
								</td>
							</tr>
							<tr>
								<th height="300px"><br><br><br><br><br>멘토분야</th>
								<td>
									<div class="checks2">
										<br>
										<input type="radio" id="radio3" name="cate"> 
										<label for="radio3">카테고리</label>
										&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
										<input type="radio" id="radio4" name="cate"> 
										<label for="radio4">카테고리</label> 
										<br><br>
										<input type="radio" id="radio5" name="cate"> 
										<label for="radio5">카테고리</label>
										&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
										<input type="radio" id="radio6" name="cate"> 
										<label for="radio6">카테고리</label> 
										<br><br>
										<input type="radio" id="radio7" name="cate"> 
										<label for="radio7">카테고리</label>
										&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
										<input type="radio" id="radio8" name="cate"> 
										<label for="radio8">카테고리</label> 
										<br><br>
										<input type="radio" id="radio9" name="cate"> 
										<label for="radio9">카테고리</label>
										&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
										<input type="radio" id="radio10" name="cate"> 
										<label for="radio10">카테고리</label> 
									</div>
								</td>
							</tr>
						</table>
						<br><br>
						<div align="center">
							<button class="button2">취소</button>  &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp; <button class="button3">수정</button>
						</div>
					</form>
				</div>
				<div>
					<table class="table table-bordered table-hover stutable">
						<thead>
							<tr>
								<th width="100">번호(회원고유번호)</th>
								<th width="100">이름</th>
								<th width="130">아이디</th>
								<th width="120">이메일</th>
								<th width="100">전화번호</th>
								<th width="50">가입일/탈퇴일</th>
								<th width="130">상세보기</th>
							</tr>
						</thead>
						<tbody>
							<tr>
								<td>45(50)</td>
								<td>서주원</td>
								<td>aaaa@naver.com</td>
								<td>--</td>
								<td>010-1111-2222</td>
								<td>22.02.01/--</td>
								<td><button class="button1">수정</button>&nbsp;&nbsp;<button class="outbutton">탈퇴</button></td>
							</tr>
							<tr>
								<td>45(50)</td>
								<td>서주원</td>
								<td>aaaa@naver.com</td>
								<td>--</td>
								<td>010-1111-2222</td>
								<td>22.02.01/--</td>
								<td><button class="button1">수정</button>&nbsp;&nbsp;<button class="outbutton">탈퇴</button></td>
							</tr>
							<tr>
								<td>45(50)</td>
								<td>서주원</td>
								<td>aaaa@naver.com</td>
								<td>--</td>
								<td>010-1111-2222</td>
								<td>22.02.01/--</td>
								<td><button class="button1">수정</button>&nbsp;&nbsp;<button class="outbutton">탈퇴</button></td>
							</tr>
						</tbody>
					</table>
					
					<span class="totalpage">
						x 페이지 / y 페이지 
					</span>

					<div class="paging-area">
						<a href="">&lt&lt</a>
						<a href="">&lt</a>
						<a href="">1</a>
						<a href="">2</a>
						<a href="">3</a>
						<a href="">4</a>
						<a href="">5</a>
						<a href="">&gt</a>
						<a href="">&gt&gt</a>
					</div>
				</div>
			</div>  
		</div>
	</div>
	<%} %>
</body>
</html>