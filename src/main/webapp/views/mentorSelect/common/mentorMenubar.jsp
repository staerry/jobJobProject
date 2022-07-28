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
	          <div class="category-navi">
	              <ul class="category-select">
	                  <li id="select-all">
	                      <input type="checkbox" name="mtCategory" value="all" checked>
	                      <label for="all">전체</label>
	                      <!-- 전체 선택하면 나머지 체크박스에 모두 체크되게 가능? -->
	                  </li>
	                  <li>
	                      <input type="checkbox" id="it" name="mtCategory" value="it">
	                      <label for="it">IT 개발</label>
	                  </li>
	                  <li>
	                      <input type="checkbox" id="marketing" name="mtCategory" value="marketing">
	                      <label for="marketing">마케팅•MD•영업</label>
	                  </li>
	                  <li>
	                      <input type="checkbox" id="accounting" name="mtCategory" id="accounting">
	                      <label for="accounting">회계•재무•금융</label>
	                  </li>
	                  <li>
	                      <input type="checkbox" id="strategy" name="mtCategory" id="strategy">
	                      <label for="strategy">전략•기획</label>
	                  </li>
	                  <li>
	                      <input type="checkbox" id="distribution" name="mtCategory" id="distribution">
	                      <label for="distribution">유통•무역•구매</label>
	                  </li>
	                  <li>
	                      <input type="checkbox" id="public" name="mtCategory" id="public">
	                      <label for="public">공사•공기업•공무원</label>
	                  </li>
	                  <li>
	                      <input type="checkbox" id="special" name="mtCategory" id="special">
	                      <label for="special">전문•특수</label>
	                  </li>
	              </ul>  
	              
	              <div class="search-btn-area">
	                  <button id="mentor-search">멘토 찾기</button>  
	              </div>
	          </div>
	      </div>
	

</body>
</html>