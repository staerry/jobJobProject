<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8" import="com.jj.classSelect.model.vo.Vod" %>
    
<%
	Vod vod = (Vod)request.getAttribute("vod");
%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<link rel="stylesheet" href="${pageContext.request.contextPath}/resources/css/admin/mentor-regist-info.css">
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
	    	<!--이 부분에 좌측메뉴 넣으세요-->
	    <div class="left">
			<%@ include file="common/menubar.jsp" %>
		</div>
	
		<!--이 부분은 우측 컨텐츠 입니다.-->
		<div class="right">
	        <h3>강의 등록 정보</h3>

			<table class="admin-table">
					<tr>
						<th width="150">강의 제목</th>
						<td><%= vod.getVodTitle() %></td>
					</tr>
					<tr>
						<th>강의 영상 첨부파일</th>
						<td>
							<video src="<%= contextPath %>/<%= vod.getVodFile() %>">강의 영상</video>
						</td>
					</tr>
			</table>

			<div class="mentoRegistInfo-controller-btn">
				<div class="left-controller">
					<button type="button" onclick="approval(1);">승인</button>
					<button type="button" onclick="approval(2);">거절</button>
				</div>
				
				<script>
					function approval(answer){
						if(answer == 1){
							if(confirm("승인 하시겠습니까?")){
								location.href="<%= contextPath %>/vodApproval.ad?no=<%= vod.getVodNo() %>&answer=1";
							}
						}else{
							if(confirm("거절 하시겠습니까?")){
								location.href="<%= contextPath %>/vodApproval.ad?no=<%= vod.getVodNo() %>&answer=2";
							}
						}
					}
				</script>
				
				<div class="right-controller">
					<button type="button" onclick="history.back();">돌아가기</button>
				</div>
			</div>
	    </div>
	</div>
	<%} %>
</body>
</html>