<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8" import="com.jj.admin.model.vo.UserInfoAd"%>
<%String contextPath = request.getContextPath(); %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">

<!--css-->

<link rel="stylesheet" href="${pageContext.request.contextPath}/resources/css/admin/admin-top.css">
<link rel="stylesheet" href="${pageContext.request.contextPath}/resources/css/setting.css">
<link rel="stylesheet" href="${pageContext.request.contextPath}/resources/css/admin/admin-setting.css">

<!--font-->
<link rel="preconnect" href="https://fonts.googleapis.com">
<link rel="preconnect" href="https://fonts.gstatic.com" crossorigin>
<link href="https://fonts.googleapis.com/css2?family=Noto+Sans+KR:wght@100;400;700&display=swap" rel="stylesheet">

<!--jQuery-->
<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.6.0/jquery.min.js"></script>

<!--bootstrap4-->
<link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap@4.6.1/dist/css/bootstrap.min.css">
<script src="https://cdn.jsdelivr.net/npm/popper.js@1.16.1/dist/umd/popper.min.js"></script>
<script src="https://cdn.jsdelivr.net/npm/bootstrap@4.6.1/dist/js/bootstrap.bundle.min.js"></script>

<!--fontAwesome-->
<script src="https://kit.fontawesome.com/ea8287c514.js" crossorigin="anonymous"></script>

<title>Insert title here</title>

</head>
<body>
	<% if(session.getAttribute("alertMsg") != null){ %>
		<script>
			alert('<%= session.getAttribute("alertMsg") %>');
		</script>
		<% session.removeAttribute("alertMsg"); %>
	<% } %>
	
    <div class="top-menu-area">
        <div class="mini-menu-area">
            <div>
                <a href="<%=contextPath%>/logoutAdmin.do"><i class="fas fa-sign-out-alt"></i>&nbsp로그아웃</a>
            </div>
            <span>&nbsp&nbsp&nbsp&nbsp|&nbsp&nbsp&nbsp&nbsp</span>
            <div>
            	<%if(session.getAttribute("UserInfoAd")!=null){ %>
                <b><%=((UserInfoAd)session.getAttribute("UserInfoAd")).getUserId() %></b>님
                <% }%>
            </div>
        </div>
    </div>
</body>
</html>