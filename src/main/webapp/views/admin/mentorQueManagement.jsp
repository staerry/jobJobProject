<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<link rel="stylesheet" href="${pageContext.request.contextPath}/resources/css/admin/admin-table-paging.css">
<title>Insert title here</title>
<style>
	*{
		padding : 0;
		margin : 0;
		boxsizing : border-box;
	}
	.que-content{
		width : 1000px;
		margin : auto;
		text-align : left;
		padding : 10px 50px 10px 50px;
		border : 1px solid lightgray;
	}
	
	.que-content span {
		font-weight : bold;
		color : #666;
		font-size : 14px;
	}
	
	.que-content .date {
		font-weight : bold;
		color : #666;
		font-size : 12px;
	}
	
	.que-content pre {
		font-size : 14px;
	}
</style>
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
		    <h3>멘토 질문/답변 관리</h3>
		    
		    <table class="table table-bordered table-hover admin-table">
                <thead>
                    <tr>
                        <th width="30">번호</th>
                        <th width="400">질문제목</th>
                        <th width="100">작성자</th>
                        <th width="100">멘토명</th>
                        <th width="60">좋아요</th>
                        <th width="100">작성일</th>
                        <th width="60">삭제</th>
                    </tr>
                </thead>
                <tbody>
					<tr>
						<td>1</td>
						<td>제목</td>
						<td>홍길동</td>
						<td>멘토명</td>
						<td>20</td>
						<td>2022-12-12</td>
						<td>
							<button class="btn btn-sm btn-danger">삭제</button>
						</td>
					</tr>
					<tr class="answer" style="display : none">
						<td colspan="7">
							<div class="que-content">
								<span>질문 내용</span>
								<br>
								<pre>dfdfdfasdasdasds sadas</pre>
								<br>
								<span>답변 내용</span>
								<!-- if문 처리해서 답변이 없으면 답변이 없다고 뜨게 -->
								<!-- 여기도 게시글 없으면 게시글업다고 띄워주는거 작성 해야함 -->
								<pre>dfdfdfasdasdasds sadas</pre>
								<span class="date">2022-12-12</span>
								<!-- 여기까지 -->
							</div>
						</td>
					</tr>
                </tbody>
            </table>
            
            <script>
            	$(function(){
            		$(".admin-table > tbody > tr").click(function(){
            			if($(this).next().css("display") == "none"){
            				$(this).next().css("display", "");
            			}else{
            				$(this).next().css("display", "none");
            			}	
            		})
            	})
            </script>

            <div class="paging-area">
                <a href="">&lt</a>
                	<a href="" style="background-color : gray;">1</a>
                <a href="">&gt</a>
            </div>
		</div>
		
	</div>
	<%} %>
</body>
</html>