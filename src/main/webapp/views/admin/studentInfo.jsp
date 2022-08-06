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
	int pageLimit = pi.getPageLimit();
	
	int doublePrev = pageLimit*(currentPage/pageLimit);
	int doubleNext = pageLimit*(currentPage/pageLimit+1)+1;
%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<link rel="stylesheet" href="${pageContext.request.contextPath}/resources/css/admin/newstudentInfo.css">
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
	        <h3>수강생 정보</h3>
			<h5>수강생 리스트</h5>

			<div class="checks">
				<div id="formwraping">
					<form action="<%=request.getContextPath() %>/stuInfo.li" >
						<input type="hidden" name="p" value="1">
						&nbsp;
						<input type="checkbox" id="check1" name="check" value="1" checked> 
						<label for="check1">활동중인회원</label>
						&nbsp;
						<input type="checkbox" id="check2" name="check" value="2"> 
						<label for="check2">탈퇴한회원</label> &nbsp;
						<input type="text" style="line-height: 30px; width: 200px; text-align:center" id="searchclick" placeholder="  이름또는 회원번호로 검색" id="search" name="search">
						<label for="searchclick"><button id="searchbtn" style="line-height: 30px;" class="btnpurple" type="submit">검색</button></label>
					</form>
				</div>
			</div>
					
			<table class="table table-bordered table-hover stutable">
				<thead>
					<tr>
						<th width="100">조회번호(회원고유번호)</th>
						<th width="100">이름</th>
						<th width="150">아이디</th>
						<th width="150">이메일</th>
						<th width="100">전화번호</th>
						<th width="50">가입일<br>(탈퇴일)</th>
						<th width="80">강제탈퇴</th>
					</tr>
				</thead>
				<tbody>
					<%if(list.isEmpty()){ %>
					<script>
					alert("조회된 회원이없습니다.")
					location.href= "javascript:history.back()";
					</script>
				<%}else{ %>
					<%for(int i=0;i<list.size();i++){ %>
						<tr>
							<td><%=lpage-i %> (<%=list.get(i).getUserNo() %>)</td>
							<td id="idt"><%=list.get(i).getUserName() %></td>
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
									<button type="button" class="outbutton outMem">탈퇴</button>
								<%}else{ %>
									<button type="button" id="searchbtn" class="restoreMem">복구</button>
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
			<%if(currentPage > pageLimit ){ %>
			 <a href="<%=request.getContextPath()%>/stuInfo.li?p=<%=doublePrev%>&search=<%=request.getAttribute("search")%>&check=<%=check%>">&lt&lt</a>
			 <%} %>
			 <%if(currentPage != 1){ %>
				<a href="<%=request.getContextPath()%>/stuInfo.li?p=<%=currentPage-1%>&search=<%=request.getAttribute("search")%>&check=<%=check%>">&lt</a>
				<%} %>
				<%for(int i=startPage;i<=endPage;i++){ %>
	            	<%if(i==currentPage){ %>
	            		<a href="<%=request.getContextPath()%>/stuInfo.li?p=<%=i%>&search=<%=request.getAttribute("search")%>&check=<%=check%>" style="background:#6363ff; color:white;"><%=i %></a>
	            	<%}else{ %>
	            		<a href="<%=request.getContextPath()%>/stuInfo.li?p=<%=i%>&search=<%=request.getAttribute("search")%>&check=<%=check%>"><%=i %></a>
	            	<%} %>
            	<%} %>
            	<%if(currentPage != maxPage){ %>
					<a href="<%=request.getContextPath()%>/stuInfo.li?p=<%=currentPage+1%>&search=<%=request.getAttribute("search")%>&check=<%=check%>">&gt</a>
				<%} %>
				<%if(currentPage <= maxPage - pageLimit ){ %>
				<a href="<%=request.getContextPath()%>/stuInfo.li?p=<%=doubleNext%>&search=<%=request.getAttribute("search")%>&check=<%=check%>">&gt&gt</a>
				<%} %>
			</div>
		</div>
		<script>
			$(function(){
				
				if(<%=check.equals("all")%>){
					$('#check2').prop('checked',true);
				}else if(<%=check.equals("2")%>){
					$('#check2').prop('checked',true);	
					$('#check1').prop('checked',false);	
				}else{
					$('#check1').prop('checked',true);	
				}
				
				$('#searchclick').val('<%=search%>');
			})
			
			$('.outMem').click(function(){
				console.log($(this).parent().prev().prev().prev().prev().text())
				if(confirm($(this).parent().prev().prev().prev().prev().prev().text()+'님을 탈퇴처리 하시겠습니까?')){
					const $name = $(this).parent().prev().prev().prev().prev().prev().text()
					const $id = $(this).parent().prev().prev().prev().prev().text()
					location.href="<%=request.getContextPath()%>/withdrawalStu.up?name="+$name+"&id="+$id;
				}else{
					alert('취소하였습니다.')
				}		
			})
			
			$('.restoreMem').click(function(){
				console.log($(this).parent().prev().prev().prev().prev().text())
				if(confirm($(this).parent().prev().prev().prev().prev().prev().text()+'님을 다시 회원으로 복구하시겠습니까?')){
					const $name = $(this).parent().prev().prev().prev().prev().prev().text()
					const $id = $(this).parent().prev().prev().prev().prev().text()
					location.href="<%=request.getContextPath()%>/restoreStu.up?name="+$name+"&id="+$id;
				}else{
					alert('취소하였습니다.')
				}		
			})
		</script>
	    
	</div>
	<%} %>
</body>
</html>