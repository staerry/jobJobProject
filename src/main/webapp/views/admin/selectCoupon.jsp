<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<link rel="stylesheet" href="${pageContext.request.contextPath}/resources/css/admin/selectCoupon.css">
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
	        <h3>쿠폰관리</h3>
	    <select name="selectNo" id="selectNo">
                <option value="1">쿠폰등록및관리</option>
                <option value="2">쿠폰발송</option>
                <option value="3" selected>회원쿠폰조회</option>
            </select>
	    <br><br>
	    <script>
	    $(function(){
            $("#selectNo").on('change',function(){
                if($(this).val()==1){
                    location.href="<%=request.getContextPath()%>/couponManage.ad?p=1";
                }
                 
            })
            
             $("#selectNo").on('change',function(){
                if($(this).val()==2){
                	location.href="<%=request.getContextPath()%>/sendCoupon.ad?p=1";
                }  
            })
        })
	    </script>
	    <br>
	    <div class="checks">
	        <span style="font-size:25px ; font-weight: bolder; margin-left: 3%; color: #6363ff; float: left;">
	            ▶ 회원쿠폰 조회하기
	        </span>
	        <div id="formwraping">
	            <form action="<%=request.getContextPath() %>/paymentselect2.bo" style="">
	                &nbsp;
	                <input type="checkbox" id="check1" name="check" value="1" checked> 
	                <label for="check1">사용전</label>
	                &nbsp;
	                <input type="checkbox" id="check2" name="check" value="2"> 
	                <label for="check2">사용완료</label> 
	                &nbsp;&nbsp;
	                <input type="text" style="line-height: 30px; width: 200px; text-align:center;" id="searchclick" name="search" placeholder="이름또는 회원번호로 검색">
	                <label for="searchclick"><button id="searchbtn" style="line-height: 30px;" class="btnpurple">검색</button></label>
	            </form>
	        </div>
	    </div>
	    
	     <script>
		    	
		
		    	
			    $('#check2').on('click',function(){
					if($(this).prop('checked')){
						$('#check1').prop('checked',false)
					}
				})
				
				$('#check1').on('click',function(){
					if($(this).prop('checked')){
						$('#check2').prop('checked',false)
					}
				})
				
			
		    </script>
	
	    <br>
		<div style="margin-bottom:-25px ;">
	    <span style="font-size:25px ; font-weight: bolder; margin-left: 3%; color: #6363ff;">
	        ━ 
	    </span> &nbsp;
	    <span style="font-size:25px ; font-weight: bolder;">발행쿠폰목록</span>
	    
	    
	    </div>
	    <div style="position:relative ;">
	        <div>
	            <table class="table table-bordered table-hover stutable">
	                <thead>
	                    <tr>
	                        <th width="20">번호</th>
	                        <th width="50">쿠폰번호</th>
	                        <th width="100">쿠폰명</th>
	                        <th width="80">할인금액</th>
	                        <th width="50">상태</th>
	                        <th width="25">등록일</th>
	                        <th width="130">요청처리</th>
	                       
	                    </tr>
	                </thead>
	                <tbody>
	                    <tr>
	                        <td>1</td>
	                        <td>100</td>
	                        <td>회원가입축하쿠폰</td>
	                        <td>10000원</td>
	                        <td>발급가능</td>
	                        <td>22-01-01</td>
	                        <td><button class="button2">발급중단</button>&nbsp;<button class="outbutton">쿠폰삭제</button></td>
	                       
	                    </tr>
	                    <tr>
	                        <td>1</td>
	                        <td>100</td>
	                        <td>생일축하쿠폰</td>
	                        <td>10000원</td>
	                        <td>발급불가</td>
	                        <td>22-01-01</td>
	                        <td><button class="button1">발급재개</button>&nbsp;<button class="outbutton">쿠폰삭제</button></td>
	                       
	                    </tr>
	                
	                </tbody>
	            </table>
	            
	            <span class="totalpage">
	                x 페이지 / y 페이지 
	            </span>
	
	            <div class="paging-area">
	                <a href="">&lt&lt</a>
	                <a href="">&lt</a>
	                
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