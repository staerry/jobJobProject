<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<link rel="stylesheet" href="resources/css/admin/studentInfo.css">
<title>Insert title here</title>
</head>
<body>
	<%@ include file="common/topbar.jsp" %>
	<div class="content-wrap">
	    
	    <div class="left">
			<%@ include file="common/menubar.jsp" %>
		</div>
	   
	    <div class="right">
	        <h3>수강생 정보</h3>
			<h5>수강생 리스트</h5>

			<div class="checks">
				<div id="formwraping">
					<form action="" style="">
						&nbsp;
						<input type="checkbox" id="check1"> 
						<label for="check1">전체회원</label>
						&nbsp;
						<input type="checkbox" id="check2"> 
						<label for="check2">탈퇴한회원</label> &nbsp;
						<input type="text" style="line-height: 30px; width: 200px;" id="searchclick" placeholder="   이름또는 회원번호로 검색">
						<label for="searchclick"><button id="searchbtn" style="line-height: 30px;" class="btnpurple">검색</button></label>
					</form>
				</div>
			</div>
					
			<table class="table table-bordered table-hover stutable">
				<thead>
					<tr>
						<th width="100">번호(회원고유번호)</th>
						<th width="100">이름</th>
						<th width="150">아이디</th>
						<th width="150">이메일</th>
						<th width="100">전화번호</th>
						<th width="50">가입일/탈퇴일</th>
						<th width="80">강제탈퇴</th>
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
						<td><button class="outbutton">탈퇴</button></button></td>
					</tr>
					<tr>
						<td>45(50)</td>
						<td>서주원</td>
						<td>aaaa@naver.com</td>
						<td>--</td>
						<td>010-1111-2222</td>
						<td>22.02.01/--</td>
						<td><button class="outbutton">탈퇴</button></button></td>
					</tr>
					<tr>
						<td>45(50)</td>
						<td>서주원</td>
						<td>aaaa@naver.com</td>
						<td>--</td>
						<td>010-1111-2222</td>
						<td>22.02.01/--</td>
						<td><button class="outbutton">탈퇴</button></button></td>
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
</body>
</html>