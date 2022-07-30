<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import="com.jj.common.model.vo.PageInfo, com.jj.member.model.vo.Member, java.util.ArrayList"%>
<%
	PageInfo pi = (PageInfo)request.getAttribute("pi");
	ArrayList<Member> list = (ArrayList<Member>)request.getAttribute("list");
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
<link rel="stylesheet" href="${pageContext.request.contextPath}/resources/css/admin/paymentSelect.css">
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
		        <option value="2">결제내역순으로 조회</option>
		    </select>
		    <script>
		    	$(function(){
		    		$("#selectNo").on('change',function(){
		    			if($(this).val()==2){
		    				location.href="<%=request.getContextPath()%>/paymentselect2.bo";
		    			}
		    			 
		    		})
		    	})
		    </script>
			<br><br>
		    <div class="checks">
		        <div id="formwraping">
		            <form action="<%= request.getContextPath() %>/paymentselect.bo" style="">
		            	<input type="hidden" name="p" value="1">
		                &nbsp;
		                <input type="checkbox" id="check1" name="check" value="1" checked> 
		                <label for="check1">회원</label>
		                &nbsp;
		                <input type="checkbox" id="check2" name="check" value="2"> 
		                <label for="check2">탈퇴한회원</label> 
		                &nbsp;&nbsp;
		                <input type="text" style="line-height: 30px; width: 200px; text-align:center" id="searchclick" placeholder="이름또는 회원번호로 검색" name="search">
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
			
			<% if(check[0].equals("2")){ %>
				$('#check1').prop('checked',false)
				$('#check2').prop('checked',true)
			<%}%>
		    </script>
			
		    <div style="position:relative ;">
		        <div class="detailInfo positionab" style="display:none">
		        	<div class="close close2"></div>
            		<br><br>
		            &nbsp;&nbsp;&nbsp;&nbsp;<h3 style="text-align:center;">xxx님의 결제내역</h3>
		            <form>
		                <table class="table table-bordered table-hover stutable">
		                    <tr>
		                        <th>결제종류</th>
		                        <th>결제강의</th>
		                        <th>결제(환불)일시</th>
		                        <th>최종결제금액</th>
		                        <th>사용한쿠폰</th>
		                        <th>결제상태</th>
		
		                    </tr>
		                    <tr>
		                        <td>구매</td>
		                        <td>c++.....</td>
		                        <td>22.01.01</td>
		                        <td>100000원</td>
		                        <td>회원가입축하쿠폰</td>
		                        <td>완료</td>
		                    </tr>
		                    <tr>
		                        <td>환불</td>
		                        <td>c++.....</td>
		                        <td>22.01.01</td>
		                        <td>100000원</td>
		                        <td>회원가입축하쿠폰</td>
		                        <td>대기</td>
		                    </tr>
		                    <tr>
		                        <td>환불</td>
		                        <td>c++.....</td>
		                        <td>22.01.01</td>
		                        <td>100000원</td>
		                        <td>회원가입축하쿠폰</td>
		                        <td>완료</td>
		                    </tr>
		                   
		                </table>
		                <br><br>
		                <div align="center">
		                    <span class="arrowL" style="margin-right:100px ;"></span>
		                    <span class="arrowR"></span>
		                </div>
		            </form>
		        </div>
		        <div>
		            <table class="table table-bordered table-hover stutable">
		                <thead>
		                    <tr>
		                        <th width="100">번호(회원고유번호)</th>
		                        <th width="100">이름</th>
		                        <th width="130">아이디</th>
		                        <th width="80">회원등급</th>
		                        <th width="120">상세보기</th>
		                       
		                    </tr>
		                </thead>
		                <%if(list.isEmpty()){ %>
							<script>
							alert("조회된 회원이없습니다.")
							location.href= "javascript:history.back()";
							</script>
						<%}else{ %>
		                <tbody>
		                <%for(int i=0;i<list.size();i++){ %>
		                    <tr>
		                        <td class="notext"><%=lpage-i %>(<%=list.get(i).getUserNo() %>)</td>
		                        <td class="nametext"><%=list.get(i).getUserName() %></td>
		                        <td><%=list.get(i).getUserId() %></td>
		                        <td><%=(list.get(i).getUserDivision())==1 ? "수강생" : "멘토" %></td>
		                        
		                        <td><button type="button" class="button1" >결제내역 상세보기</button></td>
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
						 <a href="<%=request.getContextPath()%>/paymentselect.bo?p=<%=doublePrev%>&search=<%=request.getAttribute("search")%>&check=<%=check[0]%>">&lt&lt</a>
						 <%} %>
					 <%if(currentPage != 1){ %>
						<a href="<%=request.getContextPath()%>/paymentselect.bo?p=<%=currentPage-1%>&search=<%=request.getAttribute("search")%>&check=<%=check[0]%>">&lt</a>
						<%} %>
						<%for(int i=startPage;i<=endPage;i++){ %>
			            	<%if(i==currentPage){ %>
			            		<a href="<%=request.getContextPath()%>/paymentselect.bo?p=<%=i%>&search=<%=request.getAttribute("search")%>&check=<%=check[0]%>"><%=i %></a>
			            	<%}else{ %>
			            		<a href="<%=request.getContextPath()%>/paymentselect.bo?p=<%=i%>&search=<%=request.getAttribute("search")%>&check=<%=check[0]%>"><%=i %></a>
			            	<%} %>
		            	<%} %>
		            	<%if(currentPage != maxPage){ %>
							<a href="<%=request.getContextPath()%>/paymentselect.bo?p=<%=currentPage+1%>&search=<%=request.getAttribute("search")%>&check=<%=check[0]%>">&gt</a>
						<%} %>
						<%if(currentPage < maxPage - pageLimit ){ %>
							<a href="<%=request.getContextPath()%>/paymentselect.bo?p=<%=doubleNext%>&search=<%=request.getAttribute("search")%>&check=<%=check[0]%>">&gt&gt</a>
							<%} %>
					</div>
		        </div>
		    </div>  
		</div>
	</div>
	<%} %>
	<script>
	$('.button1').click(function(e){
		$.ajax({
			url:"<%=request.getContextPath()%>/payDetail.li",
			data:{
				prevNo:$(this).parent().siblings('.notext').text(),
				p:1
				},
			success:function(m){
				
			},error:function(){
				alert('수정정보를 찾지 못했습니다');
				e.preventDefault();
			}
		})
		
		$('#DName').val($(this).parent().siblings('.idtext').text())
		$('#mNo').val($(this).parent().siblings('.notext').text())
		
		$('.detailInfo').css('display',"")
	})
	</script>
</body>
</html>