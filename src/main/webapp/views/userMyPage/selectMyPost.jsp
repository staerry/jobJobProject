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
          <div class="checkbox-group">
          <table class="table table-hover">
            <thead>

                <tr style="background-color:whitesmoke">
                  <th colspan="6">&nbsp;&nbsp;&nbsp;&nbsp;
                    <input type="checkbox" name="check" id="checkAll">
                    <label for="checkAll">전체선택</label>&nbsp;&nbsp;&nbsp;&nbsp;
                    <button class="btn btn-sm btn-danger" onclick="deleteChecked();">삭제</button></th>
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
                          <td><input type="checkbox" class="selectedCheck" name="check" value="<%= p.getCmNo()%>"></td>
                          <td><p><%= p.getCmNo()%></p></td>
                          <td><p><%= p.getCmTitle()%></p></td>
                          <td><p><%= p.getUserName()%></p></td>
                          <td><p><%= p.getCmEnrollDate()%></p></td>
                          <td><p><%= p.getCmCount()%></p></td>
                        </tr>
                        <% } %>
                        <% } %> 
                      </tbody>
                    </table>
                  </div>
                  
    <script>

	    $(".checkbox-group").on("click", "#checkAll", function(){
        	$(this).parents(".checkbox-group").find("input").prop("checked", $(this).is(":checked"));
        	
        });
        
	    $(".checkbox-group").on("click", ".selectedCheck", function(){
	        var isChecked = true;
	
	        $(".checkbox-group .selectedCheck").each(function(){
	            isChecked = isChecked && $(this).is(":checked");
	        });
	
	        $("#checkAll").prop("checked", isChecked);
	
	      });
         
      	// 선택 삭제에 대한 함수
         function deleteChecked(){
            
            var deleteElement = "";
            
            // 체크된 게시글에 순차적으로 접근해 해당 요소의 val()값을 ,로 연결해 하나의 문자열 만들기
            $("input[name=check]:checked").each(function(){
               deleteElement = deleteElement + ($(this).val()) + ",";
            })   
                 
            // "value값, value값, ... value값," 와 같은 형태의 문자열이 만들어지므로
            // 마지막 ","을 삭제해야 "value값, ... value값" 형태로 WHERE CM_NO IN ( ? ) 안에 넣을 수 있음
            // => 이것을 "동적 SQL문"이라고 함!!
            deleteElement = deleteElement.substring(0, deleteElement.lastIndexOf(","));
                  
            $.ajax({
               url:"<%=contextPath%>/myPostDelete.my", // 서블릿주소
               data:{
                  userNo:$("<%=loginUser.getUserNo()%>").val(),
                  cmNo:deleteElement // 삭제할 요소들 (3, 4, 5, ... 번호)
                  },
               success:function(result){
            	  if(result > 0){
                      alert("선택한 게시글 삭제에 성공하였습니다.");
                      location.reload(); // = url재요청
            		  
            	  }
               }, 
               error:function(){
                  alert("선택한 게시글 삭제에 실패하였습니다.");
               }
            })
            
          }
      
     </script>
 
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

    </div>
    <%@ include file="../common/footer.jsp" %>

</body>
</html>