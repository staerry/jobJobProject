<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8" import="com.jj.faq.model.vo.Faq"%>
<%
	Faq fq = (Faq)request.getAttribute("faq");
%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<meta name="viewport" content="width=device-width, initial-scale=1">
  <link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap@4.6.1/dist/css/bootstrap.min.css">
  <script src="https://cdn.jsdelivr.net/npm/jquery@3.6.0/dist/jquery.slim.min.js"></script>
  <script src="https://cdn.jsdelivr.net/npm/popper.js@1.16.1/dist/umd/popper.min.js"></script>
  <script src="https://cdn.jsdelivr.net/npm/bootstrap@4.6.1/dist/js/bootstrap.bundle.min.js"></script>
</head>
<title>Insert title here</title>
<style>
   
    .container{
    width:1190px;
    height:auto;
    flex-direction:row;
    justify-content: space-between;
    padding:28px 16px 100px 34px;
}

</style>
</head>
<body>

	<%@ include file="../common/menubar.jsp" %>

    <div class="container" align="center">
        
        <div class="outer">

            <br>

            <form action="" method="post">

                <table>
                    <tr>
                        <td colspan="2" width="200"><p style="font-size: 20px; border: 1px solid lightgray; border-radius: 5px; margin: 0;"><%= fq.getFaqTitle() %></p></td>
                        <td width="200" style="text-align:right; font-size: 12px;"><%= fq.getFaqEnrolldate() %></td>
                    </tr>

                    <tr>
                        <td colspan="3" style="text-align: right; font-size: 13px"><%= fq.getUserNo() %></td>
                    </tr>

                    <tr>
                        <td colspan="3" style="font-size: 14px;">
                            <textarea name="content" cols="100" rows="10" style="resize:none; border: 1px solid lightgray; border-radius: 5px;"><%= fq.getFaqAnswer() %></textarea>
                            <!--<p style="height: 300px; border: 1px solid lightgray; border-radius: 5px;"><%= fq.getFaqAnswer() %></p>-->
                        </td>
                    </tr>
                    
                    <tr>
                        <td colspan="3"><hr></td>
                    </tr>

                    <tr>
                        <td colspan="2">
                        	<% if(fq.getFaqNo() == 1){ %>
								<!-- 이전으로 버튼 비활성화 하기 -->
								                        		
                        	<%} else{ %>
                        		<a href="<%= contextPath %>/detail.faq?no=<%= fq.getFaqNo() - 1 %>" class="btn btn-sm" style="background: lightgray;">이전글로</a>
                        	<% } %>
                            
                        </td>
                        <td>
                            <a href="<%=contextPath %>/list.faq" class="btn btn-sm"  style="float:right; background: #6363FF; color: white;">목록으로</a>
                        </td>
                    </tr>

                </table>




            </form>

        </div>
    </div>


</body>
</html>