<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import="com.jj.common.model.vo.PageInfo, com.jj.member.model.vo.Member, java.util.ArrayList"%>
<%
	PageInfo pi = (PageInfo)request.getAttribute("pi");
	ArrayList<Member> list = (ArrayList<Member>)request.getAttribute("list");
	String check = (String)request.getAttribute("check");
	String search = (String)request.getAttribute("search");
	
	int lpage = (int)request.getAttribute("lpage");
	int currentPage = pi.getCurrentPage();
	int startPage = pi.getStartPage();
	int endPage = pi.getEndPage();
	int maxPage = pi.getMaxPage();
%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<link rel="stylesheet" href="${pageContext.request.contextPath}/resources/css/admin/mentorInfo.css">
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
	        <h3>멘토 정보</h3>
			<h5>멘토 리스트</h5>

			<div class="checks">
				<div id="formwraping">
					<form action="<%=request.getContextPath()%>/mentorInfo.li" style="">
						<input type="hidden" name="p" value="1">
						&nbsp;
						<input type="checkbox" id="check1" name="check" value="1" class="set" checked> 
						<label for="check1">현직자</label>
						&nbsp;
						<input type="checkbox" id="check2" name="check" value="2" class="set" checked> 
						<label for="check2">강의자</label>
						<input type="checkbox" id="check3" name="check" value="3" > 
						<label for="check3">탈퇴한멘토</label> &nbsp;&nbsp;
						<input type="text" name="search" style="line-height: 30px; width: 200px; text-align:center" id="searchclick" placeholder="이름또는 회원번호로 검색" >
						<button type="submit" id="searchbtn" style="line-height: 30px;" class="btnpurple">검색</button>
					</form>
				</div>
			</div>
			
			<script>
				
					$('#check3').on('click',function(){
						console.log($(this).prop('checked'))
						if($(this).prop('checked')){
							$('#check1').prop('checked',false)
							$('#check2').prop('checked',false)
						}
					})
					
					$('#check2').on('click',function(){
						console.log($(this).prop('checked'))
						if($(this).prop('checked')){
							$('#check3').prop('checked',false)
						}
					})
					
					$('#check1').on('click',function(){
						console.log($(this).prop('checked'))
						if($(this).prop('checked')){
							$('#check3').prop('checked',false)
						}
					})
		
				
			</script>
			
			<div style="position:relative ;">
				<div class="detailInfo positionab" style="display:none">
					<h3>멘토정보수정</h3>
					<form>
						<table class="table table-bordered table-hover stutable">
							<tr>
								<th>이름</th>
								<td width="10px"><input type="text" style="margin-right:100px ;" disabled></td>
							</tr>
							<tr>
								<th>멘토분류</th>
								<td width="10px">
									<div class="checks2">
										<input type="radio" id="radio11" name="grade" value="1"> 
										<label for="radio11">현직자</label>
										&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
										<input type="radio" id="radio22" name="grade" value="2"> 
										<label for="radio22">강의자</label> 
									</div>
								</td>
							</tr>
							<tr>
								<th height="300px"><br><br><br><br><br>멘토분야</th>
								<td>
									<div class="checks2">
										<br>
										&nbsp;&nbsp;&nbsp;&nbsp;
										<input type="radio" id="radio2" name="cate"> 
										<label for="radio2">마케팅,MD,영업</label>
										&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
										&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
										<input type="radio" id="radio1" name="cate"> 
										<label for="radio1">IT개발</label>
										&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
										<br><br>
										<input type="radio" id="radio3" name="cate"> 
										<label for="radio3">회계,재무,금융</label>
										&nbsp;&nbsp;
										&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
										<input type="radio" id="radio4" name="cate"> 
										<label for="radio4">전략,기획</label> 
										<br><br>
										<input type="radio" id="radio5" name="cate"> 
										<label for="radio5">유통,무역,구매&nbsp;&nbsp;&nbsp;</label>
										&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
										<input type="radio" id="radio7" name="cate"> 
										<label for="radio7">전문,특수</label>
										<br><br>
										<input type="radio" id="radio6" name="cate"> 
										&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
										<label for="radio6">공사,공기업,공무원</label> 
										&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
										
									</div>
								</td>
							</tr>
						</table>
						<br><br>
						<div align="center">
							<button class="button2 cancel" type="button">취소</button>  &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp; <button class="button3">수정</button>
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
								<th width="120">이메일</th>
								<th width="100">전화번호</th>
								<th width="50">가입일/탈퇴일</th>
								<th width="130">상세보기</th>
							</tr>
						</thead>
						<%if(list.isEmpty()){ %>
							<script>
							alert("조회된 회원이없습니다.")
							location.href= "javascript:history.back()";
							</script>
						<%}else{ %>
							<%for(int i=0;i<list.size();i++){ %>
								<tr>
									<td><%=lpage-i %>(<%=list.get(i).getUserNo() %>)</td>
									<td id="idtext"><%=list.get(i).getUserName() %></td>
									<td><%=list.get(i).getUserId() %></td>
									<td>
										<%if(list.get(i).getUserEmail()!=null) {%>
											<%=list.get(i).getUserEmail() %>
										<%}else{ %>
										--
										<%} %>
									</td>
									<td><%if(list.get(i).getUserPhone()!=null) {%>
											<%=list.get(i).getUserEmail() %>
										<%}else{ %>
											--
										<%} %>
									</td>
									<td><%=list.get(i).getEnrollDate() %></td>
									<td>
										<%if(list.get(i).getUserStatus().equals("N")){ %>
											<button type="button" class="button1">수정</button>
											<button type="button" class="outbutton">탈퇴</button>
										<%}else{ %>
											<button type="button" id="searchbtn">복구</button>
										<%} %>
									</td>
								</tr>
							<%} %>
						<%} %>	
						</tbody>
					</table>
					
					<span class="totalpage">
						<%=currentPage %> 페이지 / <%=maxPage %> 페이지 
					</span>

					<div class="paging-area">
					 <a href="">&lt&lt</a>
					 <%if(currentPage != 1){ %>
						<a href="<%=request.getContextPath()%>/mentorInfo.li?p=<%=currentPage-1%>&search=<%=request.getAttribute("search")%>&check=<%=check%>">&lt</a>
						<%} %>
						<%for(int i=startPage;i<=endPage;i++){ %>
			            	<%if(i==currentPage){ %>
			            		<a href="<%=request.getContextPath()%>/mentorInfo.li?p=<%=i%>&search=<%=request.getAttribute("search")%>&check=<%=check%>"><%=i %></a>
			            	<%}else{ %>
			            		<a href="<%=request.getContextPath()%>/mentorInfo.li?p=<%=i%>&search=<%=request.getAttribute("search")%>&check=<%=check%>"><%=i %></a>
			            	<%} %>
		            	<%} %>
		            	<%if(currentPage != maxPage){ %>
							<a href="<%=request.getContextPath()%>/mentorInfo.li?p=<%=currentPage+1%>&search=<%=request.getAttribute("search")%>&check=<%=check%>">&gt</a>
						<%} %>
						<a href="">&gt&gt</a>
					</div>
				</div>
			</div>  
		</div>
		<script>
		$(function(){
			
			if(<%=check.equals("all") || check.equals("none")%>){
				
			}else if(<%=check.equals("1")%>){
				$('#check1').prop('checked',true);	
				$('#check2').prop('checked',false);	
				$('#check3').prop('checked',false);	
			}else if(<%=check.equals("2")%>){
				$('#check2').prop('checked',true);	
				$('#check1').prop('checked',false);	
				$('#check3').prop('checked',false);		
			}else{
				$('#check3').prop('checked',true);	
				$('#check1').prop('checked',false);	
				$('#check2').prop('checked',false);	
			}
			
			$('#searchclick').val('<%=search%>');
			
		})
		
		$('.button1').click(function(){
			$('.detailInfo').css('display',"")
		})
		
		$('.cancel').click(function(){
			$('.detailInfo').css('display','none')
		})
		
	</script>
	</div>
	<%} %>
</body>
</html>