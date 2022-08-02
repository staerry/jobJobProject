<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>

	<!-- 왼쪽 메뉴바 -->
	       <div class="mentor-category-area">
	       <form method="get" action="<%= request.getContextPath() %>/list.lt">
	          <div class="category-navi">
	              <ul class="category-select">
	                  <li id="select-all">
	                      <input type="checkbox" id="checkall" checked>
	                      <label for="all">전체</label>
	                      <!-- 전체 선택하면 나머지 체크박스에 모두 체크되게 가능? -->
	                  </li>
	                  <li>
	                      <input type="checkbox" id="it" name="category" value="1">
	                      <label for="it">IT 개발</label>
	                  </li>
	                  <li>
	                      <input type="checkbox" id="marketing" name="category" value="2">
	                      <label for="marketing">마케팅•MD•영업</label>
	                  </li>
	                  <li>
	                      <input type="checkbox" id="accounting" name="category" id="accounting" value="3">
	                      <label for="accounting">회계•재무•금융</label>
	                  </li>
	                  <li>
	                      <input type="checkbox" id="strategy" name="category" id="strategy" value="4">
	                      <label for="strategy">전략•기획</label>
	                  </li>
	                  <li>
	                      <input type="checkbox" id="distribution" name="category" id="distribution" value="5">
	                      <label for="distribution">유통•무역•구매</label>
	                  </li>
	                  <li>
	                      <input type="checkbox" id="public" name="category" id="public" value="6">
	                      <label for="public">공사•공기업•공무원</label>
	                  </li>
	                  <li>
	                      <input type="checkbox" id="special" name="category" id="special" value="7">
	                      <label for="special">전문•특수</label>
	                  </li>
	              </ul>  
	              
	              <script>
 	             $(document).ready(function() {
	            	 $("#checkall").click(function() {
	            		 if($("#checkall").is(":checked")) $("input[name=category]").prop("checked", true);
	            		 else $("input[name=category]").prop("checked", false);
	            	 });
	            	 
	            	 $("input[name=category]").click(function() {
	            		 var total = $("input[name=category]").length;
	            		 var checked = $("input[name=category]:checked").length;
	            		 
	            		 if(total != checked) $("#checkall").prop("checked", false);
	            		 else $("#checkall").prop("checked", true);
	            	 });	 
	             }); 

	              </script>
	              
	              <div class="search-btn-area">
	                  <button id="mentor-search" type="submit">멘토 찾기</button>  
	              </div>
	          </form>
	          </div>
	          
	          <script>
	          function searchLtr(){
	        	  
	        	  $.ajax({
	        		  url
	        	  })
	          }
	          
	          </script>
	      </div>
	

</body>
</html>