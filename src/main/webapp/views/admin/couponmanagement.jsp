<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<link rel="stylesheet" href="${pageContext.request.contextPath}/resources/css/admin/couponmanagement.css">
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
                <option value="2">쿠폰발송</option>
            </select>
            <br><br>
            <script>
                $(function(){
                    $("#selectNo").on('change',function(){
                        if($(this).val()==2){
                            location.href="<%=request.getContextPath()%>/sendCoupon.ad";
                        }
                        
                    })
                })
            </script>
            <br>
            <div class="checks">
                <div style="font-size:25px ; font-weight: bolder; margin-left: 3%; color: #6363ff;">
                    ▶ 발행쿠폰 관리하기
                </div>
            </div>

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
            <br><br>
            <div style="margin-bottom:-25px ;">
            <span style="font-size:25px ; font-weight: bolder; margin-left: 3%; color: #6363ff;">
                ━ 
            </span> &nbsp;
            <span style="font-size:25px ; font-weight: bolder;">쿠폰등록</span>
            
            </div>
            
                <div>
                    <div>
                        <table class="table table-bordered " style="text-align:left ;">
                            
                                <tr>
                                    <th width="50px" style="text-align:center ;">쿠폰이름</th>
                                    <td width="100px"><input type="text"></td>
                                </tr>
                                <tr>
                                    <th width="50px" style="text-align:center ;">할인금액</th>
                                    <td width="100px"><input type="text" size="5"> 원</td>
                                </tr>
                                <tr>
                                    <th width="50px" style="text-align:center ;">쿠폰발급받을회원</th>
                                    <td width="100px">
                                        <div class="checks2">
                                            <input type="radio" id="radio1" name="grade"> 
                                            <label for="radio1">전체회원</label>
                                            &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
                                            <input type="radio" id="radio2" name="grade"> 
                                            <label for="radio2">수강생만</label> 
                                            &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
                                            <input type="radio" id="radio3" name="grade"> 
                                            <label for="radio3">강의수강중인 수강생만</label> 
                                            &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
                                            <input type="radio" id="radio4" name="grade" checked> 
                                            <label for="radio4">선택안함</label> 
                                        </div>
                                    </td>
                                </tr>
                        </table>
                        <div align="center">
                        <button type="submit" class="button3">쿠폰등록하기</button>
                        </div> 
                    </div>      
                    </form>
            

                
                </div>
                </div>
	    </div>
	    <%} %>
</body>
</html>