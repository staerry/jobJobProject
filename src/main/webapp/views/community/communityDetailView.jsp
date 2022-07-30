<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8" import="com.jj.community.model.vo.Community"%>
    
<%
	Community c = (Community)request.getAttribute("c");
%>    
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">

<!-- css -->
<link rel="stylesheet" href="${pageContext.request.contextPath}/resources/css/setting.css">
<link rel="stylesheet" href="${pageContext.request.contextPath}/resources/css/community/communityDetailView.css">

<!-- 폰트어썸 --> 
<script src="https://kit.fontawesome.com/ea8287c514.js" crossorigin="anonymous"></script>

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

        <div class="community-detail-area">
            <table class="community-detail-content">
                <tr>
                    <td colspan="2">
                        <div class="board-btns">
                            <span><button id="content-category"><%= c.getCommCategory() %></button></span>
                             
                             <!--로그인 + 글 주인 회원에게만 수정, 버튼이 보이게 함 -->
                             <%if(loginUser != null && loginUser.getUserId().equals(c.getCommWriterId())) { %>                                                       	
                             <span class="edit-delete-btn">
                                <button id="edit-btn"><a href="<%= contextPath %>/updateForm.co?contentNo=<%=c.getCommNo()%>"><i class="far fa-eraser"></i>&nbsp;수정</a></button>
                                <button id="delete-btn"><a href="<%= contextPath %>/delete.co?contentNo=<%=c.getCommNo()%>" onclick="return userConfirm();"><i class="far fa-trash"></i>&nbsp;삭제</a></button>                            
                             </span>
                             
	                            <script>
	                            	function userConfirm() {
	                            		if(confirm('게시물을 삭제하시겠습니까?')) {
	                            			return true;
	                            		}else {
	                            			return false;
	                            		}
	                            	}
	                            </script>
                            <% } %>
                                                        
                        </div>
                    </td>
                </tr>
                <tr>
                    <td colspan="2" id="content-title"><%= c.getCommTitle() %></td>
                </tr>
                <tr>
                    <td id="content-writer"><%= c.getCommWriter() %></td>
                    <td id="content-date"><%= c.getCreateDate() %></td>
                </tr>
                <tr>
                    <td id="content-count" colspan="2">
                        <span>조회수 <%= c.getCount() %></span>
                        
                    </td>
                </tr>
                <tr>
                    <td id="content-body" colspan="2"><p><%= c.getCommContent() %></p></td>
                </tr>
            </table>
        
            <br>

            <!-- 뒤로가기(목록으로), 찜 버튼 -->
            <div class="back-zzim-btn">
                <button onclick="history.back();"><i class="fas fa-arrow-left"></i></button>
                <button onclick=""><i class="far fa-heart">&nbsp;<%= c.getLikeCount() %></i></button>
                <!-- 찜 누르기 전에는 빈 하트, 나중에는 찬 하트로 바뀌게 구현 -->
            </div>

            <!-- 댓글 작성 영역 -->
            <div class="reply-area">
                <table class="community-reply">
                    <tr>
                        <td id="reply-head">
                        <% if (loginUser != null) { %>
                            <span id="reply-please"><%= loginUser.getUserName() %>님, 답변해주세요!&nbsp;&nbsp;<i class="fas fa-comment-dots"></i></span>
                        <% } else { %>
                        <span id="reply-please">로그인 후 댓글 작성이 가능합니다. &nbsp;&nbsp;<i class="fas fa-comment-dots"></i></span>
                        <% } %>    
                            <span id="reply-sub-please">모두에게 도움이 되는 답변의 주인공이 되어주세요!</span>
                        </td>
                    </tr>
                    <tr>
                        <td ></td>
                    </tr>
                    <tr>
                        <td id="reply-write">
                        <!-- 로그인한 회원만 댓글 등록 허용 -->
                            <% if (loginUser != null) { %>
                            <textarea cols="95" rows="3" style="resize:none" id="reply-body"></textarea>
                            <button id="reply-enroll">댓글 등록</button>
                            <% } %>
                        </td>
                        
                        <!-- 직무질문 게시판의 경우 멘토회원에게만 댓글 허용 -->
						<!-- user_division 이용하면 됨 -->
						                        
                </table>
            </div>

            <!-- 댓글 목록 영역 -->
            <div class="reply-list-area">
                <table class="reply-list">
<!--                     <tr>
                        <td id="reply-userId">회원명</td>
                        <td id="reply-content">%= 댓글 내용 %</td>
                        <td id="reply-date">%= xxxx-xx-xx HH:MI%</td>
                    </tr>  -->           
                </table>
                
                <script>
                	$(function(){
                		selectReplyList();
                	})
                	
                	function selectReplyList(){
                		
                		$.ajax({
                			url:"<%= contextPath %>/rlist.co",
                			data:{contentNo:<%= c.getCommNo() %>},
                			success:function(list){
                				let value ="";
                				
                				if(Array.isArray(list) && list.length==0) {
                					value += "<tr><td> &nbsp;&nbsp; 아직 등록된 댓글이 없습니다. 첫 번째 댓글을 남겨주세요. 🥺 </td></tr>";
	                				
                				}else {
                					for(let i=0; i<list.length; i++) {
	                					value += "<tr>"
	                					             + "<td id='reply-userId'>" + list[i].userNo + "</td>"
	                					             + "<td id='reply-content'>" + list[i].replyContent + "</td>"
	                					             + "<td id='reply-date'>" + list[i].createDate + "</td>"
	                					       + "</tr>";
	                				}
                				}
	                				
                				$(".reply-list").html(value);
                				
                			},error:function(){
                				console.log("댓글목록 조회용 ajax 통신 실패");
                			}
                		})
                	}
                </script>
            </div>
        </div>
    </div>
	
	
	<%@ include file="../common/footer.jsp" %>
</body>
</html>