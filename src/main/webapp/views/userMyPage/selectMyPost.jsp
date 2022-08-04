<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import = "java.util.ArrayList, com.jj.userMyPage.model.vo.Post" %>
<%
	ArrayList<Post> list = (ArrayList<Post>)request.getAttribute("list");		
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
  
    <div class="container">
      <br><br>
        <h2>내 게시글</h2>
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

          <!--검색결과 조회 시 -->
          <br>
          <span>검색결과 조회</span>
          <br><br>
          <table class="table table-hover">
            <thead>

                <tr style="background-color:whitesmoke">
                    <th colspan="6">&nbsp;&nbsp;&nbsp;&nbsp;
                    <input type="checkbox">&nbsp;&nbsp;전체선택&nbsp;&nbsp;&nbsp;&nbsp;
                    <button class="btn btn-sm btn-danger">삭제</button></th>
                </tr>
            </thead>
            <thead align="center">
              <tr>
                <th></th>
                <th>글 번호</th>
                <th>제목</th>
                <th>글쓴이</th>
                <th>작성일</th>
                <th>조회수</th>
              </tr>
            </thead>
            <tbody align="center">
            <% if(list.isEmpty()) { %>
              <tr>
                <td colspan="6">조회된 게시글이 없습니다.</td>
              </tr>
              <%} else{ %>
                <%for(Post p : list){ %>
              <tr>
                <td><input type="checkbox"></td>
                <td><p id="no"><%= p.getCmNo()%></p></td>
                <td><p><%= p.getCmTitle()%></p></td>
                <td><p><%= p.getUserName()%></p></td>
                <td><p><%= p.getCmEnrollDate()%></p></td>
                <td>
                	<p><%= p.getCmCount()%></p>
		      		<script>
		      			$(function(){
		      				$.ajax({
		      					url : /*서블릿호출값 */
		      					data : {no : $("#no").text()}, /*<- 키값 no입니다 서블릿에서 request.getParameter로 값 받아서 사용하세요*/
		      					success : function(){
		      						console.log("이게뜨면삭제댄거");
		      					},
		      					error : function(){
		      						console.log("ajax통신 실패");
		      					}
		      				})
		      			})
		      		</script>
                </td>
              </tr>
   				<% } %>
			<% } %> 

            </tbody>
          </table>
 
        <div class="paging-area" style="margin:auto;">
            <ul class="pagination justify-content-center" style="margin:20px 0">
                <li class="page-item"><a class="page-link" href="#">Previous</a></li>
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