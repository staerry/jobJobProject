<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import="com.jj.common.model.vo.PageInfo, com.jj.pay.model.vo.Pay, java.util.ArrayList"%>
<%
	PageInfo pi = (PageInfo)request.getAttribute("pi");
	ArrayList<Pay> list = (ArrayList<Pay>)request.getAttribute("list");
	String[] check = (String[])request.getAttribute("check");
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
<link rel="stylesheet" href="${pageContext.request.contextPath}/resources/css/admin/newrefundFinish.css">
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
		                    location.href="<%=request.getContextPath()%>/refundRequest.li?p=1";
		                }
		                 
		            })
		            
		            $('#searchclick').val('<%=search%>')
		            
		            if(<%= check.length == 1 && check[0].equals("1")%>){
		            	$('#check2').prop('checked',false)
		            }
					if(<%= check.length==1 && check[0].equals("2")%>){
						$('#check1').prop('checked',false)
		            }
		        })
		    </script>
		    <div class="checks">
		        <div id="formwraping">
		            <form action="<%=request.getContextPath()%>/refundFinish.li" style="">
		            	<input type="hidden" name="p" value="1">
		                &nbsp;
		                <input type="checkbox" id="check1" name="check" value="1" checked> 
		                <label for="check1">승인목록</label>
		                &nbsp;
		                <input type="checkbox" id="check2" name="check" value="2" checked> 
		                <label for="check2">거절목록</label> 
		                &nbsp;&nbsp;
		                <input type="text" style="line-height: 30px; width: 200px; text-align:center" id="searchclick" name="search" placeholder="이름,회원번호,결제번호">
		                <label for="searchclick"><button id="searchbtn" style="line-height: 30px;" class="btnpurple">검색</button></label>
		            </form>
		        </div>
		    </div>
		    
		    <script>
		    	
		    </script>
			
		    <div style="position:relative ;">
		       
		    
		        <div>
		            <table class="table table-bordered table-hover stutable">
		                <thead>
		                    <tr>
		                        <th width="20">번호</th>
		                        <th width="80">결제번호<br>(회원고유번호)</th>
		                        <th width="50">이름</th>
		                        <th width="100">아이디</th>
		                        <th width="100">환불요청강의</th>
		                        <th width="100">요청처리일</th>
		                        <th width="100">처리결과</th>
		                       
		                    </tr>
		                </thead>
		                 <%if(list.isEmpty()){ %>
							<tbody>
		                    <tr>
		                        <td colspan='7'>조회된 환불내역이 없습니다.</td>
		                    </tr>
		                
		                </tbody>
		            	</table>
						<%}else{ %>
		                <tbody>
		                	<%for(int i=0;i<list.size();i++){ %>
			                    <tr>
			                        <td><%=lpage-i %></td>
			                        <td><%=list.get(i).getPayNo() %> (<%=list.get(i).getUserNo() %>)</td>
			                        <td><%=list.get(i).getUserName() %></td>
			                        <td><%=list.get(i).getUserId() %></td>
			                        <td><%=list.get(i).getClNo() %></td>
			                        <td><%=list.get(i).getRefundDate() %></td>
			                        <%if(list.get(i).getRefund().equals("Y")){ %>
			                        <td style="color:#6363ff;font-weight: bold;">승인</td>
			                        <%}else{ %>
			                        <td style="color:#ff0000;font-weight: bold;">거절</td>
			                        <%} %>
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
						 <a href="<%=request.getContextPath()%>/refundFinish.li?p=<%=doublePrev%>&search=<%=request.getAttribute("search")%>&check=<%=check%>">&lt&lt</a>
						 <%} %>
					 	<%if(currentPage != 1){ %>
						<a href="<%=request.getContextPath()%>/refundFinish.li?p=<%=currentPage-1%>&search=<%=request.getAttribute("search")%>&check=<%=check%>">&lt</a>
						<%} %>
						<%for(int i=startPage;i<=endPage;i++){ %>
			            	<%if(i==currentPage){ %>
			            		<a href="<%=request.getContextPath()%>/refundFinish.li?p=<%=i%>&search=<%=request.getAttribute("search")%>&check=<%=check%>"><%=i %></a>
			            	<%}else{ %>
			            		<a href="<%=request.getContextPath()%>/refundFinish.li?p=<%=i%>&search=<%=request.getAttribute("search")%>&check=<%=check%>"><%=i %></a>
			            	<%} %>
		            	<%} %>
		            	<%if(currentPage != maxPage){ %>
							<a href="<%=request.getContextPath()%>/refundFinish.li?p=<%=currentPage+1%>&search=<%=request.getAttribute("search")%>&check=<%=check%>">&gt</a>
						<%} %>
						<%if(currentPage < maxPage - pageLimit ){ %>
							<a href="<%=request.getContextPath()%>/refundFinish.li?p=<%=doubleNext%>&search=<%=request.getAttribute("search")%>&check=<%=check%>">&gt&gt</a>
						<%} %>
		            </div>
		        </div>
		    </div>
	    </div>
	</div>
	<%} %>
</body>
</html>