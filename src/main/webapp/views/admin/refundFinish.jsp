<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<link rel="stylesheet" href="resources/css/admin/refundFinish.css">
<title>Insert title here</title>
</head>
<body>
	<%@ include file="common/topbar.jsp" %>
	<div class="content-wrap">
	    
	    <div class="left">
			<%@ include file="common/menubar.jsp" %>
		</div>
	
	    
	    <div class="right">
	    	<h3>환불요청처리</h3>
		    <select name="selectNo" id="selectNo">
		        <option value="1">처리대기중인내역</option>
		        <option value="2" selected>처리완료내역</option>
		    </select>
		    <br><br>
		    <script>
		        $(function(){
		            $("#selectNo").on('change',function(){
		                if($(this).val()==1){
		                    location.href="<%=request.getContextPath()%>/refundRequest.li";
		                }
		                 
		            })
		        })
		    </script>
		    <div class="checks">
		        <div id="formwraping">
		            <form action="" style="">
		                &nbsp;
		                <input type="checkbox" id="check1" checked> 
		                <label for="check1">승인목록</label>
		                &nbsp;
		                <input type="checkbox" id="check2" checked> 
		                <label for="check2">거절목록</label> 
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
		                        <th width="20">번호</th>
		                        <th width="80">결제번호<br>(회원고유번호)</th>
		                        <th width="50">이름</th>
		                        <th width="100">아이디</th>
		                        <th width="100">환불강의</th>
		                        <th width="120">환불사유</th>
		                        <th width="100">요청처리일</th>
		                        <th width="100">처리결과</th>
		                       
		                    </tr>
		                </thead>
		                <tbody>
		                    <tr>
		                        <td>1</td>
		                        <td>45(50)</td>
		                        <td>서주원</td>
		                        <td>aaaa@naver.com</td>
		                        <td>c++...</td>
		                        <td>생각한내용이랑다름</td>
		                        <td>22.01.20</td>
		                        <td style="color:#6363ff;font-weight: bold;">승인</td>
		                    </tr>
		                    <tr>
		                        <td>1</td>
		                        <td>45(50)</td>
		                        <td>서주원</td>
		                        <td>aaaa@naver.com</td>
		                        <td>c++...</td>
		                        <td>생각한내용이랑다름</td>
		                        <td>22.01.20</td>
		                        <td style="color:#ff0000;font-weight: bold;">거절</td>
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
</body>
</html>