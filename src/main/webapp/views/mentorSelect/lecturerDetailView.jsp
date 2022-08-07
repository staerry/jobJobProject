<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"
import="com.jj.mentorSelect.model.vo.Lecturer, com.jj.classSelect.model.vo.Class, java.util.ArrayList, com.jj.mentorSelect.model.vo.MtQuestion"
%>

<% Lecturer l=(Lecturer)request.getAttribute("l"); ArrayList<Class> classList = (ArrayList<Class>
)request.getAttribute("classList");

%>

<!DOCTYPE html>
<html>

<head>
	<meta charset="UTF-8">

	<!-- css -->
	<link rel="stylesheet" href="${pageContext.request.contextPath}/resources/css/setting.css">
	<link rel="stylesheet"
		href="${pageContext.request.contextPath}/resources/css/mentorSelect/lecturerDetailView.css">
	<meta charset="UTF-8">

	<!-- 부트스트랩 아이콘 -->
	<link rel="stylesheet"
		href="https://cdn.jsdelivr.net/npm/bootstrap-icons@1.7.1/font/bootstrap-icons.css">

	<!-- 부트스트랩 -->
	<link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap@4.6.1/dist/css/bootstrap.min.css">
	<script src="https://cdn.jsdelivr.net/npm/jquery@3.6.0/dist/jquery.slim.min.js"></script>
	<script src="https://cdn.jsdelivr.net/npm/popper.js@1.16.1/dist/umd/popper.min.js"></script>
	<script src="https://cdn.jsdelivr.net/npm/bootstrap@4.6.1/dist/js/bootstrap.bundle.min.js"></script>


	<title>Insert title here</title>
</head>

<body>

	<%@ include file="../common/menubar.jsp" %>

		<!-- 전체를 감싸는 div -->
		<div class="container">
			<div class="mentor-detail-main">
				<!-- 왼쪽 멘토 프로필 카드 -->
				<div class="card-area">
					<!-- 멘토 사진 감싸는 부분 -->
					<div class="image-wrap">
						<div class="image-inner">
							<% if(l.getLtrProfilePath() !=null) { %>
								<img src="<%= contextPath %>/<%= l.getLtrProfilePath() %>"
									id="mentor-image">
								<% }else { %>
									<p>준비 중입니다.</p>
									<% } %>
						</div>
					</div>

					<div class="profile-wrap">
						<table id="mentor-profile">
							<tr id="mentor-field">
								<td>
									<%= l.getLtrCategory() %>
								</td>
							</tr>
							<tr id="mentor-name">
								<td>
									<%= l.getUserName() %><span>&nbsp;멘토</span>
								</td>
							</tr>
							<tr id="mentor-job">
								<td>
									<%= l.getLtrCompany() %>
								</td>
							</tr>
							<tr id="mentor-stat">
								<td>
									<%= l.getLtrJob() %>
								</td>
							</tr>
						</table>
					</div>
				</div>

				<!-- 오른쪽 멘토 소개 -->
				<div class="introduce-area">
					<div class="mentor-info">
						<h4>대표 멘토링 분야</h4>
						<p>
							<%= l.getLtrCategory() %>
						</p>
						<br>

						<h4>멘토 소개</h4>
						<% if(l.getLtrInfo() !=null) { %>
							<p>
								<%= l.getLtrInfo() %>
							</p>
							<% }else {%>
								<p>준비 중입니다.</p>
								<% } %>
									<br>

									<h4>주요 경력</h4>
									<% if(l.getLtrCareer() !=null) { %>
										<p>
											<%= l.getLtrCareer() %>
										</p>
										<% }else { %>
											<p>준비 중입니다.</p>
											<% } %>
					</div>
				</div>
			</div>

			<hr>

			<!-- 강의 리스트 -->
			<div class="class-area">
				<h3>강의</h3>
				<!-- 등록된 클래스가 있을 경우 -->
				<div class="mentor-class-list">
					<% if(!classList.isEmpty()) { %>
						<% for(Class c : classList) { %>
							<div class="class-thumbnail"
								onclick="location.href='<%= contextPath %>/detail.cl?class=<%= c.getClNo() %>';">
								<img src="<%= c.getClThumbnailPath() %>" width="200" height="150"
									style="margin: 10px">
								<p style="margin: 10px">
									<%= c.getClTitle() %>
										<br>
										<%= c.getUserNo() %>
								</p>
							</div>
							<% } %>
								<% }else { %>
									<p>등록된 콘텐츠가 없습니다.</p>
									<% } %>
				</div>

				<hr>

				<div class="question-area">
					<div class="question-header">
						<h3>멘토에게 질문하기</h3>
					</div>

					<!-- 멘토에게 질문 작성 -->
					<div class="question-insert">
						<table class="question-write">

							<!-- 로그인한 회원에게만 댓글 허용 -->
							<% if(loginUser==null) {%>
								<div class="not-login">
									<p>질문을 남기시려면 로그인을 먼저 진행해 주세요!</p>
								</div>
								<% }else { %>
									<tr>
										<td><textarea row="1" cols="50" style="resize:none"
												id="question-title" onclick="if(this.value=='멘토님에게 궁금한 질문을 남겨주세요!'){this.value=''}">멘토님에게 궁금한 질문을 남겨주세요!</textarea></td>
									</tr>
									<tr>
										<td><textarea row="3" cols="50" style="resize:none"
												id="question-content"
												minlength="50"
												onclick="if(this.value=='서로 예의를 지켜 존중하는 문화를 만들어가요.'){this.value=''}">서로 예의를 지켜 존중하는 문화를 만들어가요.</textarea></td>
									</tr>
									<tr>
										<td align="right"><button id="question-enroll-btn"
												onclick="insertQuestion();">질문 등록</button></td>
									</tr>
									<% } %>

						</table>

						<script>

							$(function () {
								selectQnaList();
								setInterval(selectQnaList, 1000);

							})

							function insertQuestion() {

								$.ajax({
									url: "<%= contextPath %>/qinsert.lt",
									data: {
										// 작성자 번호(서블릿에서 처리), 제목, 내용, 멘토번호 넘김
										queTitle: $("#question-title").val(),
										queContent: $("#question-content").val(),
										ansNo:<%= l.getUserNo() %>},
									type: "post",
									success: function (result) {
										console.log("멘토에게 질문하기 질문 작성용 AJAX 통신 성공")
										if (result > 0) {    // 성공했을 경우 새 댓글이 아래 보이게 함
											selectQnaList();
											$("#question-title").val("");
											$("#question-content").val("");
										}
									}, error: function () {
										console.log("멘토에게 질문하기 질문 작성용 AJAX 통신 실패");
									}
								})

							}

						</script>

						<div class="question-reply-select">

							<table class="user-question">

							</table>
							<br>

							<table class="lecturer-reply">

							</table>


							<script>

								$(function () {
									selectQnaList();
									setInterval(selectQnaList, 1000);
								})

								function selectQnaList() {

									$.ajax({
										url: "<%= contextPath %>/qlist.lt",
										data: { ltrNo:<%= l.getUserNo() %>},
										success: function (list) {
											console.log("멘토에게 질문하기 질문 조회용 AJAX 통신 성공");

											let value = "";     // 질문 + 답변을 한 쌍으로 반복                                

											if (Array.isArray(list) && list.length == 0) {
												value += "<table class='no-question'><tr><td>첫 번째 질문의 주인공이 되어주세요!</td></tr></table>"
											} else {
												for (let i = 0; i < list.length; i++) {
													value += "<table class='user-question'>"
														+ "<tr><td id='user-question-writer'>" + list[i].queWriterName + "</td></tr>"
														+ "<tr><td id='user-question-date'>" + list[i].queDate + "</td></tr>"
														+ "<tr><td id='user-question-title'>" + list[i].queTitle + "</td></tr>"
														+ "<tr><td id='user-question-content'>" + list[i].queContent + "</td></tr>"
														+ "</table>";
													if (list[i].ansDate != null) {	 // 멘토(강의자)의 답변이 작성된 경우	
														value += "<table class='lecturer-reply'>"
															+ "<tr><td id='lec-reply-writer'>" + list[i].ansWriterName + "&nbsp;<i class='fas fa-check-circle'></i></td></tr>"
															+ "<tr><td id='lec-reply-date'>" + list[i].ansDate + "</td></tr>"
															+ "<tr><td id='lec-reply-content'>" + list[i].ansContent + "</td></tr>"
															+ "</table>"
															+ "<hr>";
													} else {	// 멘토(강의자)의 답변이 아직 작성되지 않은 경우
														value += "<table><tr><td align='right'><div id='no-reply'>멘토님의 답변을 기다리는 중입니다.&nbsp;&nbsp;<i class='fas fa-comment-dots'></i></div></td></tr></table><hr>";
													}
												}

												$(".question-reply-select").html(value);
											}
										}, error: function () {
											console.log("멘토에게 질문하기 질문 조회용 ajax 통신 실패");
										}
									})
								}
							</script>

						</div>

					</div>
				</div>
			</div>
		</div>

		<%@ include file="../common/footer.jsp" %>
</body>

</html>