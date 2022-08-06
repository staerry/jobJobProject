<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8" import="java.util.ArrayList, com.jj.chat.Chat" %>
<%
	ArrayList<Chat> list = (ArrayList<Chat>)request.getAttribute("Chat");
%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<style>
	.chat-manager{
		width : 100%;
		display : flex;
		justify-content: space-between;
		border : 3px solid #dee2e6;
	}

	.user-list{
		width : 15%;
		height : 700px;
		overflow: auto;
		text-align: center;
	}

	/*채팅버튼 부분*/
	.chat-send .message:focus,
	.chat-view .you-chat:focus,
	.chat-view .my-chat:focus{
		outline: none;
	}

	.chat-view{
		width : 70%;
		height : 700px;
		padding : 15px 15px 0 15px;
	}

	.chat-view .you-chat{
		background : rgb(236, 236, 236);
		display : inline-block;
		padding : 5px;
		border-radius: 5px;
		border-style : none;
		margin-bottom: 10px;
		font-size : 14px;
	}

	.chat-view .my-chat{
		background : #6363ff;
		color : white;
		display : inline-block;
		padding : 5px;
		border-radius: 5px;
		border-style : none;
		text-align: right;
		float : right;
		margin-bottom: 10px;
		font-size : 14px;
	}

	.chat{
		width : 100%;
		height : 600px;
		overflow : auto;
	}

	.chat-send{
		width : 100%;
		height : 70px;
		display : flex;
		justify-content: space-between;
		margin-top : 10px;
	}
	.chat-send .message{
		width : 80%;
		height : 100%;
		font-size : 14px;
		border: 1px solid #6363ff;
		padding : 3px;
		border-radius: 5px;
	}
	
	.chat-send button{
		width : 18%;
		height : 100%;
		font-size : 14px;
		background-color: #6363ff;
		border-radius: 5px;
		color : white;
		border-style : none;
	}
</style>
</head>
<body>
	<%if(session.getAttribute("UserInfoAd") == null){ %>
		<script>
			alert("유효하지않은 접근입니다.");
			location.href="<%= request.getContextPath() %>/login.ad";
		</script>
	<%}else{ %>
	
	<%@ include file="common/topbar.jsp" %>
	
	<div class="content-wrap">
		<div class="left">
			<%@ include file="common/menubar.jsp" %>
		</div>
	
		<div class="right">
		    <h3>실시간 문의 관리</h3>

			<div class="chat-manager">
				<div class="user-list">
					<table class="table table-bordered table-hover admin-table">
						<thead>
							<tr>
								<th width="60">문의를 보낸 사용자</th>
							</tr>
						</thead>
						<tbody>
							<% if(list.isEmpty()){ %>
								<tr>
									<td style="cursor : pointer;">-</td>
								</tr>	
							<% } else { %>
								<% for(Chat i : list){ %>
									<tr class="username" onclick="viewChat(<%= i.getUser_no() %>);">
										<td style="cursor : pointer;"><%= i.getUserName() %></td>
										<td class="userno" style="display : none;"><%= i.getUser_no() %></td>
									</tr>							
								<% } %>	
							<% } %>
						</tbody>
					</table>
				</div>
				
				<div class="chat-view">
					<div class="chat">
<!-- 						<textarea class="you-chat" style="resize : none;" readonly cols="70" rows="2"></textarea><br>
						 <textarea class="my-chat" style="resize : none;" readonly cols="70" rows="2"></textarea><br> -->
					</div>
					<div class="chat-send">
						<textarea class="message" style="resize : none;"></textarea>
						<button onclick="sendMessage();">전송</button>
						<div id="result" style="display : none;"></div>
					</div>
				</div>
				
				<script>
					function viewChat(num){
						
						 let interval = setInterval(function() {
							/*db에 있는 유저의 메세지를 출력하기위해 db에 insert되었을 때 ajax를 재호출 함*/
							$.ajax({
								url : "selectChatting.ad",
								data : {userno : num},
								success : function(result){
									$("#result").text(num);
									let value = "";
									for(let i = 0; i < result.length; i++){
										if(result[i].sendTo == "관리자1"){
											value += '<textarea class="you-chat" style="resize : none;" readonly cols="80" rows="2">' + result[i].message + '</textarea><br>'
										}else{
											value +=  '<textarea class="my-chat" style="resize : none;" readonly cols="80" rows="2">' + result[i].message + '</textarea><br>'
										}
										
										$(".chat").html(value);
										clearInterval(interval);
									}
								},
								error : function(){
									console.log("채팅 메세지 출력 부분 ajax통신 실패");
								}
							})
						}, 300);
					}
				</script>
				
				<script>
					function sendMessage(){
						
						let userNo = $("#result").text();
						
						$.ajax({
							url : "chatting.ad",
							data : {userno : userNo,
									message : $(".message").val()
								   },
							success : function(result){
								/*메세지가 db에 삽입되면 textarea창을 비우고 스크롤을 가장 아래로 내려줌*/
								viewChat(userNo);
								$(".message").val("");
								$(".chat").scrollTop($(".chat")[0].scrollHeight);
							},
							error : function(){
								console.log("채팅부분 ajax통신 실패");	
							}
						})
					}
				</script>
			</div>
		</div>
	</div>
	<%} %>
</body>
</html>