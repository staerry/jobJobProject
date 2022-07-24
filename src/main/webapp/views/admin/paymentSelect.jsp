<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<link rel="stylesheet" href="resources/css/admin/paymentSelect.css">
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
		        <option value="2">결제내역순으로 조회</option>
		    </select>
		    <script>
		    	$(function(){
		    		$("#selectNo").on('change',function(){
		    			if($(this).val()==2){
		    				location.href="<%=request.getContextPath()%>/paymentselect2.bo";
		    			}
		    			 
		    		})
		    	})
		    </script>
			<br><br>
		    <div class="checks">
		        <div id="formwraping">
		            <form action="" style="">
		                &nbsp;
		                <input type="checkbox" id="check1"> 
		                <label for="check1">수강생</label>
		                &nbsp;
		                <input type="checkbox" id="check2"> 
		                <label for="check2">현직자/강의자</label> 
		                &nbsp;&nbsp;
		                <input type="text" style="line-height: 30px; width: 200px;" id="searchclick" placeholder="   이름또는 회원번호로 검색">
		                <label for="searchclick"><button id="searchbtn" style="line-height: 30px;" class="btnpurple">검색</button></label>
		            </form>
		        </div>
		    </div>
			
		    <div style="position:relative ;">
		        <div class="detailInfo positionab">
		        	<div class="close close2"></div>
            		<br><br>
		            &nbsp;&nbsp;&nbsp;&nbsp;<h3 style="text-align:center;">xxx님의 결제내역</h3>
		            <form>
		                <table class="table table-bordered table-hover stutable">
		                    <tr>
		                        <th>결제종류</th>
		                        <th>결제강의</th>
		                        <th>결제(환불)일시</th>
		                        <th>최종결제금액</th>
		                        <th>사용한쿠폰</th>
		                        <th>결제상태</th>
		
		                    </tr>
		                    <tr>
		                        <td>구매</td>
		                        <td>c++.....</td>
		                        <td>22.01.01</td>
		                        <td>100000원</td>
		                        <td>회원가입축하쿠폰</td>
		                        <td>완료</td>
		                    </tr>
		                    <tr>
		                        <td>환불</td>
		                        <td>c++.....</td>
		                        <td>22.01.01</td>
		                        <td>100000원</td>
		                        <td>회원가입축하쿠폰</td>
		                        <td>대기</td>
		                    </tr>
		                    <tr>
		                        <td>환불</td>
		                        <td>c++.....</td>
		                        <td>22.01.01</td>
		                        <td>100000원</td>
		                        <td>회원가입축하쿠폰</td>
		                        <td>완료</td>
		                    </tr>
		                   
		                </table>
		                <br><br>
		                <div align="center">
		                    <span class="arrowL" style="margin-right:100px ;"></span>
		                    <span class="arrowR"></span>
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
		                        <th width="80">회원등급</th>
		                        <th width="120">상세보기</th>
		                       
		                    </tr>
		                </thead>
		                <tbody>
		                    <tr>
		                        <td>45(50)</td>
		                        <td>서주원</td>
		                        <td>aaaa@naver.com</td>
		                        <td>강의자</td>
		                        
		                        <td><button class="button1">결제내역 상세보기</button></td>
		                    </tr>
		                    <tr>
		                        <td>45(50)</td>
		                        <td>서주원</td>
		                        <td>aaaa@naver.com</td>
		                        <td>수강생</td>
		                       
		                        <td><button class="button1">결제내역 상세보기</button></td>
		                    </tr>
		                    <tr>
		                        <td>45(50)</td>
		                        <td>서주원</td>
		                        <td>aaaa@naver.com</td>
		                        <td>현직자</td>
		                        
		                        <td><button class="button1">결제내역 상세보기</button></td>
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