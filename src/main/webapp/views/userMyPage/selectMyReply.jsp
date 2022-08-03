<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import = "java.util.ArrayList, com.jj.userMyPage.model.vo.Reply" %>
<%
	ArrayList<Reply> list = (ArrayList<Reply>)request.getAttribute("list");		
%>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Document</title>
    <link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap@4.6.1/dist/css/bootstrap.min.css">
<script src="https://cdn.jsdelivr.net/npm/jquery@3.6.0/dist/jquery.slim.min.js"></script>
<script src="https://cdn.jsdelivr.net/npm/popper.js@1.16.1/dist/umd/popper.min.js"></script>
<script src="https://cdn.jsdelivr.net/npm/bootstrap@4.6.1/dist/js/bootstrap.bundle.min.js"></script>
</head>
<body>
    <%@ include file="../common/menubar.jsp" %>
    <br><br>
    <div class="container">
        <h2>내 댓글</h2>
        <form action="/myPostSearch.do">
          <div class="form-check-inline">
            <label class="form-check-label" for="all">
              <input type="radio" class="form-check-input" id="all" name="category" value="all" checked>전체
            </label>
          </div>
          <div class="form-check-inline">
            <label class="form-check-label" for="QnA">
              <input type="radio" class="form-check-input" id="QnA" name="category" value="QnA">질문&답변
            </label>
          </div>
          <div class="form-check-inline">
            <label class="form-check-label" for="study">
              <input type="radio" class="form-check-input" id="study" name="category" value="study">스터디
            </label>
          </div>
          <div class="form-check-inline">
            <label class="form-check-label" for="counsel">
              <input type="radio" class="form-check-input" id="counsel" name="category" value="counsel">고민상담
            </label>
          </div>
          <div class="form-check-inline">
            <label class="form-check-label" for="review">
              <input type="radio" class="form-check-input" id="review" name="category" value="review">후기
            </label>
          </div>
          <br><br>
          <input type="text" placeholder="키워드 입력">
          <button type="submit" class="btn" style="background-color: #6363FF; color: white;">검색</button>
          <br>

          
          <br>
          <span>검색결과 조회</span>
          <br><br>
          <table class="table table-hover">
            <thead>

                <tr style="background-color:whitesmoke">
                    <th colspan="6">
                    <input type="checkbox">&nbsp;&nbsp;&nbsp;&nbsp;전체선택&nbsp;&nbsp;
                    <button class="btn btn-sm btn-danger">삭제</button></th>
                </tr>
            </thead>

            <tbody>
           	<% if(list.isEmpty()) { %>
	        	<tr>
	        		<td>조회된 댓글이 없습니다.</td>
	        	</tr>
            	<%} else{ %>
            		<%for(Reply r : list){ %>
				<tr>
				  <td><input type="checkbox"></td>
				  <td>
				    <p><%= r.getReplyEnrollDate() %></p>
				   <p><%= r.getReplyContent() %></p>
				  </td>
				</tr>
				<% } %>
			<% } %>
     
            </tbody>
          </table>
 
        <div class="paging-area" style="margin:auto;">
            <ul class="pagination justify-content-center" style="margin:20px 0">
                <li class="page-item disabled"><a class="page-link" href="#">Previous</a></li>
                <li class="page-item"><a class="page-link" href="#">1</a></li>
                <li class="page-item"><a class="page-link" href="#">2</a></li>
                <li class="page-item"><a class="page-link" href="#">3</a></li>
                <li class="page-item"><a class="page-link" href="#">4</a></li>
                <li class="page-item"><a class="page-link" href="#">5</a></li>
                <li class="page-item"><a class="page-link" href="#">Next</a></li>
              </ul>
        </div>

    </form>
</div>

 <%@ include file="../common/footer.jsp" %>
</body>
</html>