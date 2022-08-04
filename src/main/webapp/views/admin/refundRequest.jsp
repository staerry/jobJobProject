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
<link rel="stylesheet" href="${pageContext.request.contextPath}/resources/css/admin/refundRequest.css">
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
		        <option value="2">처리완료내역</option>
		    </select>
		    <br><br>
		    <script>
		        $(function(){
		            $("#selectNo").on('change',function(){
		                if($(this).val()==2){
		                    location.href="<%=request.getContextPath()%>/refundFinish.li?p=1";
		                }
		                 
		            })
		            
		            $('#searchclick').val('<%=search%>')
		        })
		    </script>
		    <div class="checks">
		        <div id="formwraping">
		            <form action="<%=request.getContextPath() %>/refundRequest.li">
		               	<input type="hidden" name="p" value="1">
		                <input type="text" style="line-height: 30px; width: 200px; text-align:center;" id="searchclick" placeholder="이름,회원번호,결제번호" name="search">
		                <label for="searchclick"><button id="searchbtn" style="line-height: 30px;" class="btnpurple">검색</button></label>
		            </form>
		        </div>
		    </div>
			
		    <div style="position:relative ;">
		       
		    
		        <div>
		            <table class="table table-bordered table-hover stutable">
		                <thead>
		                    <tr>
		                        <th width="20">--</th>
		                        <th width="80">결제번호<br>(회원고유번호)</th>
		                        <th width="50">이름</th>
		                        <th width="150">아이디</th>
		                        <th width="150">환불강의</th>
		                        <th width="25">결제일</th>
		                        <th width="100">요청처리</th>
		                       
		                    </tr>
		                </thead>
		                <%if(list.isEmpty()){ %>
							<tbody>
		                    <tr>
		                        <td colspan='7'>조회된 환불요청이 없습니다.</td>
		                    </tr>
		                
		                </tbody>
		            	</table>
						<%}else{ %>
		                <tbody>
		                	<%for(int i=0;i<list.size();i++){ %>
			                    <tr>
			                    	<input type="hidden" class="isucpNo" value=<%=list.get(i).getIsuCpNo()==null ? 0 : list.get(i).getIsuCpNo() %>>
			                    	<input type="hidden" class="clNo" value=<%=list.get(i).getClNo() %>>
			                        <td><%=lpage-i %></td>
			                        <td class="payNo"><%=list.get(i).getPayNo()%> (<%=list.get(i).getUserNo()%>)</td>
			                        <td class="userName"><%=list.get(i).getUserName() %></td>
			                        <td><%=list.get(i).getUserId() %></td>
			                        <td><%=list.get(i).getClTitle() %></td>
			                        <td><%=list.get(i).getPayDate()%></td>
			                        <td><button class="button1 access">승인</button>&nbsp;&nbsp;<button class="outbutton">거절</button></td>
			                    </tr>
		                	<%} %>
		                </tbody>
		                <%} %>
		            </table>
		            
		            <script>
			            $(".access").click(function(){
	                		if(confirm($(this).parent().siblings('.userName').text()+'님의 환불요청을 승인하시겠습니까?')){
	                			let start = $(this).parent().siblings('.payNo').text().indexOf('(');
	    	            		let end = $(this).parent().siblings('.payNo').text().indexOf(')');
	    	            		let payNo = $(this).parent().siblings('.payNo').text().substring(0,start-1);
	    	            		let userNo = $(this).parent().siblings('.payNo').text().substring(start+1,end);
	    	            		let clNo = $(this).parent().siblings('.clNo').val();
	    	            		let isucpNo = $(this).parent().siblings('.isucpNo').val();
	                			location.href = '<%=request.getContextPath()%>/refundAccess.up?payNo='+payNo+'&isucpNo='+isucpNo+'&userNo='+userNo+'&clNo='+clNo
	                		}
	                	})
	                	
	                	$(".outbutton").click(function(){
	                		if(confirm($(this).parent().siblings('.userName').text()+'님의 환불요청을 거절하시겠습니까?')){
	                			let start = $(this).parent().siblings('.payNo').text().indexOf('(');
	    	            		let end = $(this).parent().siblings('.payNo').text().indexOf(')');
	    	            		let payNo = $(this).parent().siblings('.payNo').text().substring(0,start-1);
	                			location.href = '<%=request.getContextPath()%>/refundDeny.up?payNo='+payNo
	                		}
	                	})
	                	
	                	
		            </script>
		            
		            <span class="totalpage">
		               <%=currentPage %> 페이지 / <%=maxPage %> 페이지  
		            </span>
		
		            <div class="paging-area">
		                <%if(currentPage > pageLimit ){ %>
						 <a href="<%=request.getContextPath()%>/paymentselect.bo?p=<%=doublePrev%>&search=<%=request.getAttribute("search")%>">&lt&lt</a>
						 <%} %>
					 	<%if(currentPage != 1){ %>
						<a href="<%=request.getContextPath()%>/paymentselect.bo?p=<%=currentPage-1%>&search=<%=request.getAttribute("search")%>">&lt</a>
						<%} %>
						<%for(int i=startPage;i<=endPage;i++){ %>
			            	<%if(i==currentPage){ %>
			            		<a href="<%=request.getContextPath()%>/paymentselect.bo?p=<%=i%>&search=<%=request.getAttribute("search")%>>"><%=i %></a>
			            	<%}else{ %>
			            		<a href="<%=request.getContextPath()%>/paymentselect.bo?p=<%=i%>&search=<%=request.getAttribute("search")%>"><%=i %></a>
			            	<%} %>
		            	<%} %>
		            	<%if(currentPage != maxPage && currentPage < maxPage){ %>
							<a href="<%=request.getContextPath()%>/paymentselect.bo?p=<%=currentPage+1%>&search=<%=request.getAttribute("search")%>">&gt</a>
						<%} %>
						<%if(currentPage < maxPage - pageLimit ){ %>
							<a href="<%=request.getContextPath()%>/paymentselect.bo?p=<%=doubleNext%>&search=<%=request.getAttribute("search")%>">&gt&gt</a>
						<%} %>
		            </div>
		        </div>
		    </div>
	    </div>
	</div>
	<%} %>
</body>
</html>