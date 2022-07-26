<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8" import="com.jj.notice.model.vo.Notice"%>
<%
	Notice n = (Notice)request.getAttribute("notice");
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

                <table>
                    <tr>
                        <td colspan="2" width="200"><p style="font-size: 20px; border: 1px solid lightgray; border-radius: 5px; margin: 0;"><%= n.getNoticeTitle() %></p></td>
                        <td width="200" style="text-align:right; font-size: 12px;">등록일 : <%= n.getNoticeEnrolldate() %></td>
                    </tr>

                    <tr>
                        <td colspan="3" style="text-align: right; font-size: 13px"><%= n.getUserNo() %></td>
                    </tr>

                    <tr>
                        <td colspan="3" style="font-size: 14px;">
                            <textarea name="content" cols="100" rows="10" style="resize:none; border: 1px solid lightgray; border-radius: 5px;" readonly="readonly" disabled><%= n.getNoticeContent() %></textarea>
                        </td>
                    </tr>
                    
                    <tr>
                        <td colspan="3" style="text-align: right; font-size: 12px">수정일 : <%= n.getNoticeModifydate() %></td>
                    </tr>

                    <tr>
                        <td colspan="2">
                        	<% if(n.getNoticeNo() == 1){ %>
								<!-- 이전으로 버튼 비활성화 하기 -->
								                        		
                        	<%} else{ %>
                        		<a href="<%= contextPath %>/detail.no?Nno=<%= n.getNoticeNo() - 1 %>" class="btn btn-sm" style="background: lightgray;">이전글로</a>
                        	<% } %>
                            
                        </td>
                        <td>
                            <a href="<%=contextPath %>/list.no?npage=1&nsort=1" class="btn btn-sm"  style="float:right; background: #6363FF; color: white;">목록으로</a>
                        </td>
                    </tr>

                </table>

        </div>
    </div>

</body>
</html>