<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<link rel="stylesheet" href="${pageContext.request.contextPath}/resources/css/admin/paymentSelects.css">
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
	        <h3>결제내역조회</h3>
		    <select name="selectNo" id="selectNo">
		        <option value="1">회원리스트로 조회</option>
		        <option value="2" selected>결제내역순으로 조회</option>
		    </select>
		     <script>
		    	$(function(){
		    		$("#selectNo").on('change',function(){
		    			location.href="<%=request.getContextPath()%>/paymentselect.bo"; 
		    		})
		    	})
		    </script>
		    <br><br>
			
		    <div class="checks" id="formwraping2">
		        <div id="formwraping">
		            <form action="" style="">
		                &nbsp;
		                <input type="checkbox" id="check1"> 
		                <label for="check1">구매</label>
		                &nbsp;
		                <input type="checkbox" id="check2"> 
		                <label for="check2">환불</label> 
		                &nbsp;&nbsp;
		                <input type="text" style="line-height: 30px; width: 200px;" id="searchclick" placeholder="   이름또는 회원번호로 검색">
		                <label for="searchclick"><button id="searchbtn" style="line-height: 30px;" class="btnpurple">검색</button></label>
		            </form>
		        </div>
		    </div>
			
		    <div style="position:relative ;">
		       
		    
		        <div>
		            <table class="table table-bordered table-hover stutable">
		                <thead>
		                    <tr>
		                        <th width="70">결제번호<br>(회원고유번호)</th>
		                        <th width="50">결제종류</th>
		                        <th width="150">결제강의</th>
		                        <th width="50">이름</th>
		                        <th width="120">아이디</th>
		                        <th width="100">결제/환불일시</th>
		                        <th width="100">결제금액</th>
		                       
		                    </tr>
		                </thead>
		                <tbody>
		                    <tr>
		                        <td>2 (5)</td>
		                        <td>환불</td>
		                        <td>c++</td>
		                        <td>서주원</td>
		                        <td>aaaa@naver.com</td>
		                        <td>22.01.10</td>
		                        <td>100000원</td>
		                    </tr>
		                    <tr>
		                        <td>1 (5)</td>
		                        <td>구매</td>
		                        <td>c++</td>
		                        <td>서주원</td>
		                        <td>aaaa@naver.com</td>
		                        <td>22.01.01</td>
		                        <td>100000원</td>
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