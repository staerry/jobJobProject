<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import="com.jj.common.model.vo.PageInfo, com.jj.pay.model.vo.Pay, java.util.ArrayList"%>
<%
	PageInfo pi = (PageInfo)request.getAttribute("pi");
	ArrayList<Pay> list = (ArrayList<Pay>)request.getAttribute("list");
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
		    			location.href="<%=request.getContextPath()%>/paymentselect.bo?p=1"; 
		    		})
		    	})
		    </script>
		    <br><br>
			
		    <div class="checks" id="formwraping2">
	
		        <div id="formwraping">
		            <form action="<%=request.getContextPath() %>/paymentselect2.bo" style="">
		                &nbsp;
		                <input type="checkbox" id="check1" name="check" value="1" checked> 
		                <label for="check1">구매내역</label>
		                &nbsp;
		                <input type="checkbox" id="check2" name="check" value="2"> 
		                <label for="check2">환불내역</label> 
		                &nbsp;&nbsp;
		                <input type="text" style="line-height: 30px; width: 200px; text-align:center;" id="searchclick" name="search" placeholder="이름,회원번호,결제번호">
		                <label for="searchclick"><button id="searchbtn" style="line-height: 30px;" class="btnpurple">검색</button></label>
		            </form>
		        </div>
		    </div>
		    
		    <script>
		    	
			    $(function(){
					if(<%=check.equals("2")%>){
						$('#check1').prop('checked',false)
						$('#check2').prop('checked',true)
					}
				})
		    	
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
				
				$('#searchclick').val('<%=search%>');
		    </script>
			
		    <div style="position:relative ;">
		       
		    
		        <div>
		            <table class="table table-bordered table-hover stutable">
		                <thead>
		                    <tr>
		                        <th width="70">결제번호<br>(회원고유번호)</th>
		                        <th width="50">이름</th>
		                        <th width="150">강의명</th>
		                        <th width="120">아이디</th>
		                        <th width="100">결제/환불일시</th>
		                        <th width="100">결제금액</th>
		                        <th width="100">쿠폰사용여부</th>
		                        <th width="30">환불여부</th>
		                       
		                    </tr>
		                </thead>
		                <%if(list.isEmpty()){ %>
							<script>
							alert("조회된 내역이없습니다.")
							location.href= "javascript:history.back()";
							</script>
						<%}else{ %>
		                <tbody>
		                <%for(int i=0;i<list.size();i++){ %>
		                    <tr>
		                        <td><%=list.get(i).getPayNo()  %> (<%=list.get(i).getUserNo() %>)</td>
		                        <td><%=list.get(i).getUserName() %></td>
		                        <td><%=list.get(i).getClNo() %></td>
		                        <td><%=list.get(i).getUserId() %></td>
		                        <td><%=(list.get(i).getRefund()).equals("Y") ? list.get(i).getRefundDate() : list.get(i).getPayDate() %></td>
		                        <td><%=list.get(i).getFinalPayment() %>원</td>
		                        <td><%=list.get(i).getIsuCpNo()!=null ? list.get(i).getIsuCpNo() : "--" %></td>
		                        <td><%=(list.get(i).getRefund()).equals("Y") ? "O" : "X" %></td>
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
						 <a href="<%=request.getContextPath()%>/paymentselect2.bo?p=<%=doublePrev%>&search=<%=request.getAttribute("search")%>&check=<%=check%>">&lt&lt</a>
						 <%} %>
					 <%if(currentPage != 1){ %>
						<a href="<%=request.getContextPath()%>/paymentselect2.bo?p=<%=currentPage-1%>&search=<%=request.getAttribute("search")%>&check=<%=check%>">&lt</a>
						<%} %>
						<%for(int i=startPage;i<=endPage;i++){ %>
			            	<%if(i==currentPage){ %>
			            		<a href="<%=request.getContextPath()%>/paymentselect2.bo?p=<%=i%>&search=<%=request.getAttribute("search")%>&check=<%=check%>"><%=i %></a>
			            	<%}else{ %>
			            		<a href="<%=request.getContextPath()%>/paymentselect2.bo?p=<%=i%>&search=<%=request.getAttribute("search")%>&check=<%=check%>"><%=i %></a>
			            	<%} %>
		            	<%} %>
		            	<%if(currentPage != maxPage){ %>
							<a href="<%=request.getContextPath()%>/paymentselect2.bo?p=<%=currentPage+1%>&search=<%=request.getAttribute("search")%>&check=<%=check%>">&gt</a>
						<%} %>
						<%if(currentPage < maxPage - pageLimit ){ %>
							<a href="<%=request.getContextPath()%>/paymentselect2.bo?p=<%=doubleNext%>&search=<%=request.getAttribute("search")%>&check=<%=check%>">&gt&gt</a>
						<%} %>
					</div>
		        </div>
		    </div>
	    </div>
	</div>
	<%} %>
</body>
</html>