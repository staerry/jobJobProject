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
                            location.href="<%=request.getContextPath()%>/sendCoupon.ad?p=1";
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
							location.href= "javascript:history.back()";
							</script>
						<%}else{ %>
                        <tbody>
	                        <%for(int i=0;i<list.size();i++){ %>
	                            <tr>
	                                <td><%=lpage-i %></td>
	                                <td><%=list.get(i).getCpNo() %></td>
	                                <td><%=list.get(i).getCpName() %></td>
	                                <td><%=list.get(i).getDiscount() %>원</td>
	                                <td><%=(list.get(i).getCpStatus()).equals("Y") ? "발급가능" : "발급불가" %></td>
	                                <td><%=list.get(i).getCpAddDate() %></td>
	                                <td>
	                                	<%if((list.get(i).getCpStatus()).equals("Y")){ %>
	                                		<button class="button2">발급중단</button>
	                                	<%}else{ %>
	                                		<button class="button1">발급재개</button>
	                                	<%} %>
	                                </td>
	                            
	                            </tr>
	                       <%} %>
					   </tbody>
					   <%} %>
                    </table>
                    
                    <span class="totalpage">
                        <%=currentPage %> 페이지 / <%=maxPage %> 페이지  
                    </span>

                    <div class="paging-area">
                        <%if(currentPage > pageLimit ){ %>
						 <a href="<%=request.getContextPath()%>/paymentselect2.bo?p=<%=doublePrev%>">&lt&lt</a>
						 <%} %>
						 <%if(currentPage != 1){ %>
						<a href="<%=request.getContextPath()%>/paymentselect2.bo?p=<%=currentPage-1%>">&lt</a>
						<%} %>
						<%for(int i=startPage;i<=endPage;i++){ %>
			            	<%if(i==currentPage){ %>
			            		<a href="<%=request.getContextPath()%>/paymentselect2.bo?p=<%=i%>"><%=i %></a>
			            	<%}else{ %>
			            		<a href="<%=request.getContextPath()%>/paymentselect2.bo?p=<%=i%>"><%=i %></a>
			            	<%} %>
		            	<%} %>
		            	<%if(currentPage != maxPage){ %>
							<a href="<%=request.getContextPath()%>/paymentselect2.bo?p=<%=currentPage+1%>">&gt</a>
						<%} %>
						<%if(currentPage < maxPage - pageLimit ){ %>
							<a href="<%=request.getContextPath()%>/paymentselect2.bo?p=<%=doubleNext%>">&gt&gt</a>
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
                    	<form action="">
                        <table class="table table-bordered " style="text-align:left ;">
                            
                                <tr>
                                    <th width="50px" style="text-align:center ;">쿠폰이름</th>
                                    <td width="100px"><input type="text" name="cpName"></td>
                                </tr>
                                <tr>
                                    <th width="50px" style="text-align:center ;">할인금액</th>
                                    <td width="100px"><input type="text" size="5" name="cpDis"> 원</td>
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
                        </form>
                    </div>      
                   
            

                
                </div>
                </div>
	    </div>
	    <%} %>
</body>
</html>