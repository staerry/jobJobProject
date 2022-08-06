<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import="com.jj.common.model.vo.PageInfo, com.jj.coupon.vo.Coupon, java.util.ArrayList"%>
<%
	PageInfo pi = (PageInfo)request.getAttribute("pi");
	ArrayList<Coupon> list = (ArrayList<Coupon>)request.getAttribute("list");
	String check = (String)request.getAttribute("check");
	String search = (String)request.getAttribute("search");
	
	int lpage = (int)request.getAttribute("lpage");
	int currentPage = pi.getCurrentPage();
	int startPage = pi.getStartPage();
	int endPage = pi.getEndPage();
	int maxPage = pi.getMaxPage();
	int pageLimit = pi.getPageLimit();
	
	int doublePrev = pageLimit*(currentPage/pageLimit);
	int doubleNext = pageLimit*(currentPage/pageLimit+1)+1;
%>
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
            <h3>쿠폰관리</h3>
            <select name="selectNo" id="selectNo">
                <option value="1">쿠폰등록및관리</option>
                <option value="2">쿠폰발송</option>
                <option value="3">회원쿠폰조회</option>
            </select>
            <br><br>
            <script>
                $(function(){
                    $("#selectNo").on('change',function(){
                        if($(this).val()==2){
                            location.href="<%=request.getContextPath()%>/sendCoupon.ad?p=1";
                        }  
                    })
                    
                    $("#selectNo").on('change',function(){
                        if($(this).val()==3){
                            location.href="<%=request.getContextPath()%>/selectCoupon.li?p=1";
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
                                <th width="20">--</th>
                                <th width="30">쿠폰번호</th>
                                <th width="100">쿠폰명</th>
                                <th width="80">할인금액</th>
                                <th width="50">상태</th>
                                <th width="25">등록일</th>
                                <th width="70">요청처리</th>
                            
                            </tr>
                        </thead>
                        <%if(list.isEmpty()){ %>
							<script>
							alert("조회된 쿠폰이 없습니다.")
							</script>
						<%}else{ %>
                        <tbody>
	                        <%for(int i=0;i<list.size();i++){ %>
	                            <tr>
	                                <td><%=lpage-i %></td>
	                                <td  class="cpNo"><%=list.get(i).getCpNo() %></td>
	                                <td class="cpName"><%=list.get(i).getCpName() %></td>
	                                <td><%=list.get(i).getDiscount() %>원</td>
	                                <td><%=(list.get(i).getCpStatus()).equals("Y") ? "발급가능" : "발급불가" %></td>
	                                <td><%=list.get(i).getCpAddDate() %></td>
	                                <td>
	                                	<%if((list.get(i).getCpStatus()).equals("Y")){ %>
	                                		<button class="button2 cpStop">발급중단</button>
	                                	<%}else{ %>
	                                		<button class="button1 cpRe">발급재개</button>&nbsp;<button class="outbutton cpDe">쿠폰삭제</button>
	                                	<%} %>
	                                </td>
	                            
	                            </tr>
	                       <%} %>
					   </tbody>
					   <%} %>
                    </table>
                    
                    <script>
                    
                    	$(".cpStop").click(function(){
                    		if(confirm($(this).parent().siblings('.cpName').text()+'을(를) 발급중단 하시겠습니까?')){
                    			location.href = '<%=request.getContextPath()%>/couponStop.up?no='+$(this).parent().siblings('.cpNo').text()
                    		}
                    	})
                    	
                    	$(".cpRe").click(function(){
                    		if(confirm($(this).parent().siblings('.cpName').text()+'을(를) 발급재개 하시겠습니까?')){
                    			location.href = '<%=request.getContextPath()%>/couponRestore.up?no='+$(this).parent().siblings('.cpNo').text()
                    		}
                    	})
                    	
                    	$(".cpDe").click(function(){
                    		if(confirm($(this).parent().siblings('.cpName').text()+'을(를) 삭제하시면 이쿠폰을 보유한 \n모든회원의 쿠폰이 삭제됩니다. 정말로삭제하시겠습니까?')){
                    			location.href = '<%=request.getContextPath()%>/couponDelete.de?no='+$(this).parent().siblings('.cpNo').text()
                    		}
                    	})
                    
                    </script>
                    
                    <span class="totalpage">
                        <%=currentPage %> 페이지 / <%=maxPage %> 페이지  
                    </span>

                    <div class="paging-area">
                        <%if(currentPage > pageLimit ){ %>
						 <a href="<%=request.getContextPath()%>/couponManage.ad?p=<%=doublePrev%>">&lt&lt</a>
						 <%} %>
						 <%if(currentPage != 1){ %>
						<a href="<%=request.getContextPath()%>/couponManage.ad?p=<%=currentPage-1%>">&lt</a>
						<%} %>
						<%for(int i=startPage;i<=endPage;i++){ %>
			            	<%if(i==currentPage){ %>
			            		<a href="<%=request.getContextPath()%>/couponManage.ad?p=<%=i%>" style="background:#6363ff; color:white;"><%=i %></a>
			            	<%}else{ %>
			            		<a href="<%=request.getContextPath()%>/couponManage.ad?p=<%=i%>"><%=i %></a>
			            	<%} %>
		            	<%} %>
		            	<%if(currentPage != maxPage){ %>
							<a href="<%=request.getContextPath()%>/couponManage.ad?p=<%=currentPage+1%>">&gt</a>
						<%} %>
						<%if(currentPage <= maxPage - pageLimit ){ %>
							<a href="<%=request.getContextPath()%>/couponManage.ad?p=<%=doubleNext%>">&gt&gt</a>
						<%} %>
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
                    	<form action="<%=request.getContextPath()%>/cpadd.up">
                        <table class="table table-bordered " style="text-align:left ;">
                            
                                <tr>
                                    <th width="50px" style="text-align:center ;" >쿠폰이름</th>
                                    <td width="100px"><input type="text" id="cpName" name="cpName" required></td>
                                </tr>
                                <tr>
                                    <th width="50px" style="text-align:center ;">할인금액</th>
                                    <td width="100px"><input type="number" step="1000" size="5" id="cpDis" name="cpDis" placeholder="1000단위로입력" required> 원</td>
                                </tr>
                                <tr>
                                    <th width="50px" style="text-align:center ;">쿠폰발급받을회원</th>
                                    <td width="100px">
                                        <div class="checks2">
                                            <input type="radio" id="radio1" name="grade" value="1"> 
                                            <label for="radio1">전체회원</label>
                                            &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
                                            <input type="radio" id="radio2" name="grade" value="2"> 
                                            <label for="radio2">수강생만</label> 
                                            &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
                                            <input type="radio" id="radio3" name="grade" value="3"> 
                                            <label for="radio3">강의수강중인 수강생만</label> 
                                            &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
                                            <input type="radio" id="radio4" name="grade" value="4" checked> 
                                            <label for="radio4">선택안함</label> 
                                        </div>
                                    </td>
                                </tr>
                        </table>
                        
                        <div align="center">
                        <button type="submit" class="button3" onclick="return cpadd();">쿠폰등록하기</button>
                        </div> 
                        </form>
                    </div>      
                  
                   <script>

                   </script>
            

                
                </div>
                </div>
	    </div>
	    <%} %>
</body>
</html>