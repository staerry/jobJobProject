<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page  import="java.util.ArrayList, com.jj.common.model.vo.PageInfo, com.jj.mentorMyPage.model.vo.MtQuestion"%>
<%
	ArrayList<MtQuestion> list =  (ArrayList<MtQuestion>)request.getAttribute("list");
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
        <h2>내 답변</h2>
        
         
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
                <% if(list.isEmpty()) { %>
              <tr>
                <td colspan="6">조회된 게시글이 없습니다.</td>
              </tr>
              <%} else{ %>
                <%for(MtQuestion m : list){ %>
              
                <th><%= m.getMtQueNo() %></th>
                <th><%= m.getQueContent()  %></th>
                
                <th><%=m.getQueEnrolldate()  %></th>
               <!--  <th>내 답변 상태</th> -->
                <%if(m.getAnsDate() != null){ %> 
                <th><%= m.getQueContent()  %></th>
                <th><%= m.getAnsDate()  %></th>
                <%} else{%>
                <th>답변대기중</th>
                
              </tr>
            </thead>
            <tbody align="center">
          
              <tr>
                <td><p></p></td>
              
   				<% } %>
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