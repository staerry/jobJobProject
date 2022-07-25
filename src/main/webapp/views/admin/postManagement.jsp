<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<link rel="stylesheet" href="${pageContext.request.contextPath}/resources/css/admin/admin-table-paging.css">
<link rel="stylesheet" href="${pageContext.request.contextPath}/resources/css/admin/mentor-post-management.css">
<title>Insert title here</title>
</head>
<body>
	<%@ include file="common/topbar.jsp" %>
	
	<div class="content-wrap">
	
	<div class="left">
		<%@ include file="common/menubar.jsp" %>
	</div>
	
		<div class="right">
		    <h3>게시글 관리</h3>
		    
			<ul class="mentor-post-category">
				<li>
					<input type="radio" name="category" id="work" value="work" checked>
		    		<label for="work">직무질문</label>
				</li>
				<li>
					<input type="radio" name="category" id="study" value="study">
		    		<label for="study">스터디</label>
				</li>
				<li>
					<input type="radio" name="category" id="worry" value="worry">
		    		<label for="worry">고민상담</label>
				</li>
				<li>
					<input type="radio" name="category" id="review" value="review">
		    		<label for="review">수강평</label>
				</li>
			</ul>
		    
		    <table class="table table-bordered table-hover admin-table">
                <thead>
                    <tr>
                        <th width="60">번호</th>
                        <th>게시글 제목</th>
                        <th width="70">댓글</th>
                        <th width="100">작성자</th>
                        <th width="100">등록일</th>
                    </tr>
                </thead>
                <tbody>
                    <tr>
                        <td>10</td>
                        <td>아직도 진로를 결정하지 못해 헤매고 있습니다.</td>
                        <td>0</td>
                        <td>홍길동</td>
                        <td>2022-12-12</td>
                    </tr>
                </tbody>
            </table>

            <div class="paging-area">
                <a href="">&lt</a>
                <a href="">1</a>
                <a href="">2</a>
                <a href="">3</a>
                <a href="">4</a>
                <a href="">5</a>
                <a href="">&gt</a>
            </div>
		</div>
		
	</div>
</body>
</html>