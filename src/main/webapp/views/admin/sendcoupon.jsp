<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<link rel="stylesheet" href="${pageContext.request.contextPath}/resources/css/admin/sendcoupon.css">
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
            <h3>쿠폰등록</h3>
            <select name="selectNo" id="selectNo">
                <option value="1">쿠폰등록및관리</option>
                <option value="2" selected>쿠폰발송</option>
            </select>
            <br><br>
            <script>
                $(function(){
                    $("#selectNo").on('change',function(){
                        if($(this).val()==1){
                            location.href="<%=request.getContextPath()%>/couponManage.ad?p=1";
                        }
                         
                    })
                })
            </script>
            <br>
            <div class="checks">
                <div style="font-size:25px ; font-weight: bolder; margin-left: 3%; color: #6363ff;">
                    ▶  쿠폰발송하기
                </div>
            </div>
        
            <br>
            
            <div style="margin-bottom:-25px ;">
            <span style="font-size:25px ; font-weight: bolder; margin-left: 3%; color: #6363ff;">
                ━ 
            </span> &nbsp;
            <span style="font-size:25px ; font-weight: bolder;">1. 발송쿠폰선택</span>
            </div>
            
            <div>
                <table class="table table-bordered table-hover stutable">
                    <thead>
                        <tr>
                            <th width="20">선택</th>
                            <th width="20">번호</th>
                            <th width="50">쿠폰번호</th>
                            <th width="100">쿠폰명</th>
                            <th width="80">할인금액</th>
                            <th width="50">상태</th>
                            <th width="25">등록일</th>
                            
                           
                        </tr>
                    </thead>
                    <tbody>
                        <tr>
                            <td>
                                <div class="checks2">
                                    <input type="radio" id="radio1" name="grade"> 
                                    <label for="radio1"></label>
                                </div>
                            </td>
                            <td>1</td>
                            <td>100</td>
                            <td>회원가입축하쿠폰</td>
                            <td>10000원</td>
                            <td>발급가능</td>
                            <td>22-01-01</td>
                           
                        </tr>
                        <tr>
                            <td>
                                <div class="checks2">
                                    <input type="radio" id="radio2" name="grade"> 
                                    <label for="radio2"></label>
                                </div>
                            </td>
                            <td>1</td>
                            <td>100</td>
                            <td>생일축하쿠폰</td>
                            <td>10000원</td>
                            <td>발급불가</td>
                            <td>22-01-01</td>
                            
                           
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
            <br><br>
            <div>
                <span style="font-size:25px ; font-weight: bolder; margin-left: 3%; color: #6363ff;">
                    ━ 
                </span> &nbsp;
                <span style="font-size:25px ; font-weight: bolder;">2. 회원선택</span>
            </div>
            <br>
            <div class="Wbox" style="margin-left:20px ;">
                <div class="search1">
                    <div class="search2">
                    <input type="text" style="line-height: 30px; width: 200px;" id="searchclick" placeholder="   이름또는 회원번호로 검색">
                    <button id="searchbtn" style="line-height: 30px;" class="btnpurple">검색</button>
                    </div>
                </div>
                
                <span class="sall">
                    <div class="checks1">
                        <input type="checkbox" id="check1"> 
                        <label for="check1">전체선택</label>
                        
                        <input type="checkbox" id="check2"> 
                        <label for="check2" style="padding-left: 290px;">전체선택</label>
                    </div>
                </span>
                
                <div class="lbox">
                   <ul>
                        <li>
                            <div class="checks11">
                                <input type="checkbox" id="check8">     
                                <label for="check8">서주원(aaaa@naver.com)</label>
                            </div>  
                        </li>
                        <li>
                            <div class="checks11">
                                <input type="checkbox" id="check3"> 
                                <label for="check3">서주원(aaaa@naver.com)</label>
                            </div>  
                        </li>
                        <li>
                            <div class="checks11">
                                <input type="checkbox" id="check4"> 
                                <label for="check4">서주원(aaaa@naver.com)</label>
                            </div>  
                        </li>
                   </ul>
                </div>
                <div class="cbox">
                    <div align="center" style="margin-top:70px ; font-size:70px;">
                        <div><button class="btns">›</button></div>
                        
                        <div><button class="btns">‹</button></div>
                    </div>
                </div>
                <div class="rbox">
                    <ul>
                        <li>
                            <div class="checks11">
                                <input type="checkbox" id="check5">     
                                <label for="check5">서주원(aaaa@naver.com)</label>
                            </div>  
                        </li>
                        <li>
                            <div class="checks11">
                                <input type="checkbox" id="check6"> 
                                <label for="check6">서주원(aaaa@naver.com)</label>
                            </div>  
                        </li>
                        <li>
                            <div class="checks11">
                                <input type="checkbox" id="check7"> 
                                <label for="check7">서주원(aaaa@naver.com)</label>
                            </div>  
                        </li>
                   </ul>
                </div>
                
                <div class="sendbtn">
                    <br><br>    
                    <button class="button1">쿠폰발송</button>
                </div>
            </div>
	    </div>
	</div>
	<%} %>
</body>
</html>