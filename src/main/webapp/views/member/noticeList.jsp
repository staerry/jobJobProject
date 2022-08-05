<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8" import="java.util.ArrayList, com.jj.notice.model.vo.Notice, com.jj.faq.model.vo.PageInfoFaq"%>
<%
	ArrayList<Notice> list = (ArrayList)request.getAttribute("list");
	
	PageInfoFaq pi = (PageInfoFaq)request.getAttribute("pi");
	
	int currentPage = pi.getCurrentPage();
	int startPage = pi.getStartPage();
	int endPage = pi.getEndPage();
	int maxPage = pi.getMaxPage();
%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<script src="https://kit.fontawesome.com/ea8287c514.js" crossorigin="anonymous"></script>
<meta name="viewport" content="width=device-width, initial-scale=1">
  <link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap@4.6.1/dist/css/bootstrap.min.css">
  <script src="https://cdn.jsdelivr.net/npm/jquery@3.6.0/dist/jquery.slim.min.js"></script>
  <script src="https://cdn.jsdelivr.net/npm/popper.js@1.16.1/dist/umd/popper.min.js"></script>
  <script src="https://cdn.jsdelivr.net/npm/bootstrap@4.6.1/dist/js/bootstrap.bundle.min.js"></script>
  <script src="https://kit.fontawesome.com/046431a501.js" crossorigin="anonymous"></script>
</head>
<style>
  .page-link {
    color: #6363FF; 
    background-color: #fff;
    border: 1.5px solid #6363FF; 
  }
  
  .page-item.active .page-link {
   z-index: 1;
   color: #555;
   font-weight:bold;
   background-color: #f1f1f1;
   border-color: #ccc;
   
  }
  
  .page-link:focus, .page-link:hover {
    color: white;
    background-color: #6363FF; 
    border-color: #ccc;
  }
  </style>
<body>

  <%@ include file="../common/menubar.jsp" %>

    <br><br>
    <h2 style="margin-left: 5%;">공지사항</h2><br>

    <table style="margin-left:10%;">
      <tr>
        <td>
          <div class="container">                      
              <div class="dropdown">
                <button type="button" class="btn btn-primary dropdown-toggle" style="background: #6363FF; border: none;" data-toggle="dropdown">
                  정렬
                </button>
                <div class="dropdown-menu">
                  <a class="dropdown-item" href="<%= contextPath %>/list.no?npage=1&nsort=1">최신순</a>
                  <a class="dropdown-item" href="<%= contextPath %>/list.no?npage=1&nsort=2">조회수</a>
                </div>
              </div>
          </div>
        </td>

	
        <td>
         
        </td>
      </tr>
    </table>

    <br>

    <div class="container">
                   
        <table class="table table-hover list-area">
          <thead align="center">
            <tr>
              <th>NO</th>
              <th>내용</th>
            </tr>
          </thead>

          <tbody align="center">
          	<% if(list.isEmpty()){ %>
          		<!-- case1: 공지글이 없는 경우 -->
	            <tr>
	              <td colspan="2">존재하는 공지사항이 없습니다.</td>
	            </tr>
	        <% }else{ %>
            	<!-- case2. 공지글이 있을 경우 -->
            	<% for(Notice n : list){ %>
		            <tr>
		              <td><%= n.getNoticeNo() %></td>
		              <td><%= n.getNoticeTitle() %></td>
		            </tr>
				<% } %>          
            <% } %>
          </tbody>
        </table>
    </div>

    <div class="paging-area" align="center">
        <ul class="pagination justify-content-center" style="margin:20px 0" >
        
        	<% if(currentPage != 1){ %>
            	<li class="page-item"><a class="page-link" href="<%=contextPath%>/list.no?npage=<%= currentPage-1 %>&nsort=<%= (int)request.getAttribute("nsort") %>">&lt;</a></li>
            <% } %>
            
            <% for(int p=startPage; p<=endPage; p++){ %>
            	<li class="page-item"><a class="page-link" href="<%=contextPath%>/list.no?npage=<%= p %>&nsort=<%= (int)request.getAttribute("nsort") %>"><%= p %></a></li>
            <% } %>
            
            <% if(currentPage != maxPage){ %>
            	<li class="page-item"><a class="page-link" href="<%=contextPath%>/list.no?npage=<%= currentPage+1 %>&nsort=<%= (int)request.getAttribute("nsort") %>">&gt;</a></li>
			<% } %>
        </ul>
    </div>
  
    <div class="search-area" align="center">

		<input type="text" name="keyhWord" id="bbb" class="form-control-sm mr-3" style="border-color: #6363FF;" placeholder="검색어 입력"><i style="cursor:pointer" class="fa-solid fa-magnifying-glass" onclick="searchNotice();"></i>
    </div>

    <script>
      $(function(){
        $(".list-area>tbody>tr").click(function(){

            const num = $(this).children().eq(0).text(); // 클릭했을 때의 글 번호

            location.href = '<%= contextPath %>/detail.no?Nno=' + num;

        })
      })
      
      function searchNotice(){
    	  location.href = "<%=contextPath%>/list.no?npage=1&nsort=1&keyWord=" + $('#bbb').val();
      }
    </script>

    <br><br><br>

    <br><br><br><br>
</body>
</html>