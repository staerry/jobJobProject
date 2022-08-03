<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import="com.jj.common.model.vo.PageInfo, com.jj.coupon.vo.IssuanceCoupon, java.util.ArrayList"%>
<%
	PageInfo pi = (PageInfo)request.getAttribute("pi");
	ArrayList<IssuanceCoupon> list = (ArrayList<IssuanceCoupon>)request.getAttribute("list");
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
<link rel="stylesheet" href="${pageContext.request.contextPath}/resources/css/admin/newselectCoupon.css">
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
	            <form action="<%=request.getContextPath() %>/selectCoupon.li">
	            	<input type="hidden" name="p" value="1">
	                &nbsp;
	                <input type="checkbox" id="check1" name="check" value="1" checked> 
	                <label for="check1">사용전</label>
	                &nbsp;
	                <input type="checkbox" id="check2" name="check" value="2"> 
	                <label for="check2">사용완료</label> 
	                &nbsp;&nbsp;
	                <input type="text" style="line-height: 30px; width: 200px; text-align:center;" id="searchclick" name="search" placeholder="이름,회원번호,쿠폰번호">
	                <label for="searchclick"><button id="searchbtn" style="line-height: 30px;" class="btnpurple">검색</button></label>
	            </form>
	        </div>
	    </div>
	    
	     <script>
		 	   	
	     	$(function(){
	     		if(<%=check.equals("1")%>){
			    	 $('#check1').prop('checked',true);	
					 $('#check2').prop('checked',false);	
				}else{
					$('#check1').prop('checked',false);	
					$('#check2').prop('checked',true);	
				}
	     	})
				
				$('#searchclick').val('<%=search%>');
		
		    	
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
	                    	<th width="25">--</th>
	                        <th width="50">회원번호</th>
	                        <th width="50">보유쿠폰번호</th>
	                        <th width="100">보유쿠폰명</th>
	                        <th width="50">상태</th>
	                        <th width="30">발급일</th>
	                        <th width="70">요청처리</th>
	                       
	                    </tr>
	                </thead>
	                <%if(list.isEmpty()){ %>
							<script>
							alert("조회된 내역이 없습니다.")
							location.href= "javascript:history.back()";
							</script>
					<%}else{ %>
	                <tbody>
	                	<%for(int i=0;i<list.size();i++){ %>
		                    <tr>
		                    	<input type="hidden" class="no" value="<%=list.get(i).getIsuCpNo() %>">
		                    	<td><%=lpage-i %></td>
		                        <td class="userName"><%=list.get(i).getUserNo() %> (<%=list.get(i).getUserName() %>)</td>
		                        <td class="cpNo"><%=list.get(i).getCpNo() %></td>
		                        <td class="cpName"><%=list.get(i).getCpName()%></td>
		                        <td><%=(list.get(i).getCpStatus()).equals("N") ? "사용가능" : "사용완료" %></td>
		                        <td><%=list.get(i).getCpIssuDate() %></td>
		                        <td>
		                        	<%if((list.get(i).getCpStatus()).equals("N")){ %>
		                        		<button type="button" class="button2">쿠폰회수</button>
		                        	<%}else{ %>
		                        		<button type="button" class="button1">쿠폰재지급</button>
		                        	<%} %>
		                        </td>
		                    </tr>
		                <%} %>
	                </tbody>
	                <%} %>
	            </table>
	            
	            <script>
	            	$('.button2').click(function(){
	            		let start = $(this).parent().siblings('.userName').text().indexOf('(');
	            		let end = $(this).parent().siblings('.userName').text().indexOf(')');
	            		let name = $(this).parent().siblings('.userName').text().substring(start+1,end);
	            		let cp = $(this).parent().siblings('.cpName').text()
	            		if(confirm(name+' 님의 '+cp+" 을(를) 회수하시겠습니까?")){
	            			location.href = "<%=request.getContextPath()%>/deleteUserCp.de?no="+$(this).parent().siblings('.no').val()
	            		}
	            	})
	            	
	            	$('.button1').click(function(){
	            		let start = $(this).parent().siblings('.userName').text().indexOf('(');
	            		let end = $(this).parent().siblings('.userName').text().indexOf(')');
	            		let name = $(this).parent().siblings('.userName').text().substring(start+1,end);
	            		let userNo = $(this).parent().siblings('.userName').text().substring(0,start-1);
	            		let cp = $(this).parent().siblings('.cpName').text()	
	            		if(confirm(name+' 님의 '+cp+" 을(를) 재지급하시겠습니까?")){
	            			location.href = "<%=request.getContextPath()%>/insertUserCp.up?userNo="+userNo+"&cpNo="+$(this).parent().siblings('.cpNo').text()
	            		}
	            	})
	            </script>
	            
	            <span class="totalpage">
	                <%=currentPage %> 페이지 / <%=maxPage %> 페이지  
	            </span>
	
	            <div class="paging-area">
	                <%if(currentPage > pageLimit ){ %>
						 <a href="<%=request.getContextPath()%>/selectCoupon.li?p=<%=doublePrev%>&search=<%=request.getAttribute("search")%>&check=<%=check%>">&lt&lt</a>
						 <%} %>
					 <%if(currentPage != 1){ %>
						<a href="<%=request.getContextPath()%>/selectCoupon.li?p=<%=currentPage-1%>&search=<%=request.getAttribute("search")%>&check=<%=check%>">&lt</a>
						<%} %>
						<%for(int i=startPage;i<=endPage;i++){ %>
			            	<%if(i==currentPage){ %>
			            		<a href="<%=request.getContextPath()%>/selectCoupon.li?p=<%=i%>&search=<%=request.getAttribute("search")%>&check=<%=check%>"><%=i %></a>
			            	<%}else{ %>
			            		<a href="<%=request.getContextPath()%>/selectCoupon.li?p=<%=i%>&search=<%=request.getAttribute("search")%>&check=<%=check%>"><%=i %></a>
			            	<%} %>
		            	<%} %>
		            	<%if(currentPage != maxPage){ %>
							<a href="<%=request.getContextPath()%>/selectCoupon.li?p=<%=currentPage+1%>&search=<%=request.getAttribute("search")%>&check=<%=check%>">&gt</a>
						<%} %>
						<%if(currentPage < maxPage - pageLimit ){ %>
							<a href="<%=request.getContextPath()%>/selectCoupon.li?p=<%=doubleNext%>&search=<%=request.getAttribute("search")%>&check=<%=check%>">&gt&gt</a>
						<%} %>
	            </div>
	        </div>
	    </div>
	    </div>
	</div>
	<%} %>    
</body>
</html>