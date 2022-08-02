<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8" import="java.util.ArrayList, com.jj.member.model.vo.SlideAttachment" %>
    
<%
	ArrayList<SlideAttachment> list = (ArrayList<SlideAttachment>)request.getAttribute("SlideAttachment");
%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<link rel="stylesheet" href="${pageContext.request.contextPath}/resources/css/admin/admin-table-paging.css">
<link rel="stylesheet" href="${pageContext.request.contextPath}/resources/css/admin/slideManagement.css">
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
			    <h3>슬라이드 이미지 관리</h3>
			 
			    <table class="table table-bordered table-hover admin-table">
	                <thead>
	                    <tr>
	                        <th width="60">번호</th>
	                        <th width="300">슬라이드 이미지</th>
	                        <th>파일명</th>
	                        <th width="150">업로드일</th>
	                        <th width="150">삭제/수정</th>
	                    </tr>
	                </thead>
	                <tbody>
	                	<% if(list.isEmpty()){ %>
		                	<tr>
			                    <td colspan="5">조회된 슬라이드 이미지가 없습니다.</td>
			                </tr>
		                <% } %>
		                <% for(SlideAttachment i : list){ %>
			                <tr>
			                    <td><%= i.getFileNo() %></td>
			                    <td>
			                    	<img src="<%= i.getFilePath() %>/<%= i.getFileName() %>" alt="슬라이드이미지<%= i.getFileNo() %>" height="70">
			                    </td>
			                    <td><%= i.getFileName() %></td>
								<td><%= i.getUploadDate() %></td>
			                    <td>
			                    	<button class="btn btn-sm btn-warning" onclick="">수정</button>
			                    	<button class="btn btn-sm btn-danger" onclick="deleteImg(<%= i.getFileNo() %>);">삭제</button>
			                    	
			                    	<script>
			                    		function deleteImg(num){
			                    			if(confirm("삭제 하시겠습니까?")){
			                    				console.log(num);
			                    				location.href='<%= contextPath %>/deleteSlide.ad?no=' + num;
			                    			}
			                    		}
			                    	</script>
			                    </td>
			                </tr>
		                <% } %>
	                </tbody>
	            </table>
	            
	            <div class="table-bottom-btn" style="float : right; margin-top : 50px;">
	            	<% if(list.size() != 5){ %>
	            		<button type="button" id="add-img">이미지등록</button>
	            	<% } %>
	            </div>
			</div>
		</div>
		
		<!-- 이미지 등록 모달창 출력용 스크립트 -->
		<script>
			$(function(){
				$("#add-img").click(function(){
					$(".add-slide-img-wrap").toggle();
				})
			})
		</script>
		
		<!-- 이미지 등록 모달창 -->
		<div class="add-slide-img-wrap" style="display : none;">
			<form action="insertSlide.ad" method="post" id="add-form" enctype="multipart/form-data">
				<h4>이미지 등록</h4>
				<table>
					<tr>
						<td>
							<div class="file-form">
								<input type="file" name="fileName">
							</div>
						</td>
					</tr>
					<tr>
						<td>
							<button type="button" class="btn btn-sm btn-danger" onclick="$('.add-slide-img-wrap').css('display', 'none');">취소</button>
							<button type="submit" class="btn btn-sm btn-info" onclick="return add();">등록</button>
							
							<script>
								function add(){
									if(confirm("등록 하시겠습니까?")){
										return true;
									}else{
										return false;
									}
								}
							</script>
						</td>
					</tr>
				</table>
			</form>
		</div><!-- 이미지 등록 모달창 끝 -->
	<%} %>
</body>
</html>