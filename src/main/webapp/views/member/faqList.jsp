<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8" import="java.util.ArrayList, com.jj.faq.model.vo.Faq, com.jj.faq.model.vo.PageInfoFaq"%>
<%
	ArrayList<Faq> list = (ArrayList)request.getAttribute("list");
	
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
    <h2 style="margin-left: 5%;">도움이 필요하신가요?</h2><br>

    <table style="margin-left:10%;">
      <tr>
        <td>
          <div class="container">                      
              <div class="dropdown">
                <button type="button" class="btn btn-primary dropdown-toggle" style="background: #6363FF; border: none;" data-toggle="dropdown">
                  정렬
                </button>
                <div class="dropdown-menu">
                  <a class="dropdown-item" href="<%= contextPath %>/list.faq?cpage=1&sort=1">최신순</a>
                  <a class="dropdown-item" href="<%= contextPath %>/list.faq?cpage=1&sort=2">조회수</a>
                </div>
              </div>
          </div>
        </td>

      <td>
          <div class="container">
            <!-- 모달 여는 버튼 -->
            <button type="button" class="btn" data-toggle="modal" data-target="#myModal" style="float: right; background: lightgray; color: black;">
              1:1 문의하기 
            </button>
          
            <!-- 모달 -->
            
            <!-- <!--<input type="hidden" name="userNo" value="">-->
            <form action="<%= contextPath %>/insert.mtm" id="enroll-form" method="post">
              
              <div class="modal" id="myModal">
                <div class="modal-dialog">
                  <div class="modal-content">

                    <!-- 모달 Header -->
                    <div class="modalHeader" style="margin-top: 3%; margin-right: 3%; margin-left: 3%;">
                      <button type="button" class="close" data-dismiss="modal">&times;</button>
                      <h4 class=>1:1 문의하기</h4>
                      <div style="font-size: 10px;">문제가 해결되지 않으셨다면 1:1 로 문의하세요.<br>
                      문의 주신 내용은 48시간 내로 최대한 빠르게 답변드리도록 하겠습니다. 
                      이메일을 확인해주세요.</div>
                    </div>

                    <hr>
                    
                    <!-- Modal body -->
                    <div class="modal-body" style="padding: 3%;">
                      <input type="text" name="mtmTitle" placeholder="제목" style="width: 100%;" required><br><br>
                      <textarea name="mtmContent" style="width:100%; resize: none;" cols="30" rows="10" placeholder="내용" required></textarea><br><br>

                      <div>
                      <input type="checkbox">
                      <span style="font-size: 10px;">개인정보 수집 및 이용에 동의합니다. 1:1 문의를 위한 최소한의 개인정보만을 수집하고 있습니다. 개인정보는 ‘개인정보 처리방침’에 근거하여 관리됩니다.</span>
                      </div>

                    </div>
                    
                    <!-- Modal footer -->
                    <div class="modal-footer">
                      <button type="submit" class="btn" style="background: #6363FF; color: white;">문의하기</button>
                    </div>
                    
                  </div>
                </div>
              </div>
            </form>

          </div>
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
            	<% for(Faq fq : list){ %>
		            <tr>
		              <td><%= fq.getFaqNo() %></td>
		              <td><%= fq.getFaqTitle() %></td>
		            </tr>
				<% } %>          
            <% } %>
          </tbody>
        </table>
    </div>

    <div class="paging-area" align="center">
        <ul class="pagination justify-content-center" style="margin:20px 0" >
        
        	<% if(currentPage != 1){ %>
            	<li class="page-item"><a class="page-link" href="<%=contextPath%>/list.faq?cpage=<%= currentPage-1 %>&sort=<%= (int)request.getAttribute("sort") %>">&lt;</a></li>
            <% } %>
            
            <% for(int p=startPage; p<=endPage; p++){ %>
            	<li class="page-item"><a class="page-link" href="<%=contextPath%>/list.faq?cpage=<%= p %>&sort=<%= (int)request.getAttribute("sort") %>"><%=p %></a></li>
            <% } %>
            
            <% if(currentPage != maxPage){ %>
            	<li class="page-item"><a class="page-link" href="<%=contextPath%>/list.faq?cpage=<%= currentPage+1 %>&sort=<%= (int)request.getAttribute("sort") %>">&gt;</a></li>
			<% } %>
        </ul>
    </div>
  
    <div class="search-area" align="center">

      <input type="search" class="form-control-sm mr-3" style="border-color: #6363FF;" placeholder="검색어 입력"><i class="fa-solid fa-magnifying-glass"></i> 

    </div>

    <script>
      $(function(){
        $(".list-area>tbody>tr").click(function(){

            const num = $(this).children().eq(0).text(); // 클릭했을 때의 글 번호

            // 요청할 url ? 키 = 벨류 & 키 = 벨류
            // 요청시 전달값 '키=벨류' 로 넘기는걸 => 쿼리스트링
            // /web/list.faq.no?no=xx
            location.href = '<%= contextPath %>/detail.faq?no=' + num;

        })
      })
    </script>




    <br><br><br>

    <br><br><br><br>
</body>
</html>