<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import = "java.util.ArrayList, com.jj.userMyPage.model.vo.Payment" %>
<%
  ArrayList<Payment> list = (ArrayList<Payment>)request.getAttribute("list");	
%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
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
        <h2>결제내역</h2>
        <br><br>
        <h4><span style="color: #6363FF;">강의리스트</span>로 조회</h4>
         <br>
          <table class="table table-hover">
            <thead align="center">
              <tr>
                <th>강의명</th>
                <th>강사명</th>
                <th>결제일자</th>
                <th>결제내역</th>
              </tr>
            </thead>
            <tbody align="center">
              <% if(list.isEmpty()) { %>
                <tr>
                  <td>결제내역이 없습니다.</td>
                </tr>
                <%} else{ %>
                  <%for(Payment p : list){ %>
	              <tr>
	                <td><%= p.getClTitle()%></td>
	                <td><%= p.getUserName()%></td>
	                <td><%= p.getPayDate()%></td>
	                <td>
	                  <button onclick="location.href='<%=contextPath%>/paymentDetails.my?payNo=<%= p.getPayNo() %>'" class="btn" style="background-color: #6363FF; color: white;">결제상세내역</button>
	                  <button onclick="location.href='<%=contextPath%>/paymentRefund.my'"class="btn btn-danger">환불신청</button>
	                
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
        
          

          <script>
          
   
            function refund(){
             
            	if (widow.confirm("환불신청 하시겠습니까?")){
            		window.alert("환불신청 성공");
            	}else{
            		window.alert("취소 버튼을 클릭했습니다")
            	}
                  
        
          }
            
          </script>
        
		</div>

 <%@ include file="../common/footer.jsp" %>
</body>
</html>