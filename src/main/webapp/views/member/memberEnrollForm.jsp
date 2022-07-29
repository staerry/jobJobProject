<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<style>
     .outer{
            border: 3px solid rgb(190, 190, 190); 
            background: white;
            color: black;
            width: 600px;
            margin: auto;
            margin-top: 50px;
        }
    
        input{
                /* border-style: none; */
                text-decoration-line: underline;
                text-decoration-color: rgb(190, 190, 190);
                text-decoration-thickness: 3px;
            }
    
        button{
            width: 100px;
            height: 25px;
            border-style: none;
            border-radius: 5px;
            background: #6363FF;
            color: white;
        }
    
        #enroll-form table{margin: auto;}
        #enroll-form input{margin: 5px;}

</style>
</head>
<body>

	<%@ include file="../common/menubar.jsp" %>

     <div class="outer">
    
            <br>
    
            <h2 align="center">니JOB 내JOB에서<br>꿈을 이뤄보세요.</h2>
            <br>
    
            <form action="<%= contextPath %>/agreeTerm.me" method="post" id="enroll-form">
    
                <table>
    
                    <tr>
                        <td></td>
                        <td><input type="text" name="userName" placeholder="이름(실명)입력" required></td>
                        <td></td>
                    </tr>
    
                    <tr>
                        <td></td>
                        <td><input type="text" name="userId" maxlength="50" placeholder="이메일 주소 입력" required></td>
                        <td><button type="button" onclick="idCheck();">중복확인</button></td>
                    </tr>
    
                    <tr>
                        <td></td>
                        <td><input type="password" name="userPwd" maxlength="20" placeholder="비밀번호 입력" required></td>
                        <td></td>
                    </tr>
    
                    <tr>
                        <td></td>
                        <td><input type="password" maxlength="20" placeholder="비밀번호 재입력" required></td>
                        <td></td>
                    </tr>
    
                    <tr>
                        <td></td>
                        <td><input type="text" name="userPhone" maxlength="13" placeholder="핸드폰번호 입력(-포함해서 입력)" required></td>
                        <td></td>
                    </tr>
                 
                </table>
    
                <br>
    
                <div align="center">
                    <button type="submit" disabled>다음</button>
                    <button type="reset">초기화</button>
                </div>
                
                <script>

                	function idCheck(){
                		// 중복확인 버튼 클릭시 사용자가 입력한 아이디값을 넘겨서 "조회요청(존재하는지 안하는지)"
                		// => 응답데이터 돌려받기
                		// 1) 사용불가능일(NNNNN) 경우 => alert로 메세지 출력, 다시 입력할 수 있도록 유도
                		// 2) 사용가능일(NNNNY) 경우 => 진짜 사용할껀지 의사를 물어볼꺼임 (confirm메소드)
                		// 					> 사용하겠다는 경우 => 더이상 아이디 수정 못하도록, 회원가입버튼 활성화
                		//					> 사용안하겠다는 경우 => 다시 입력할 수 있도록 유도
                		
                		// 아이디 입력하는 input요소 객체
                		const $idInput = $("#enroll-form input[name=userId]");

                        //let regExp = /^[A-Za-z0-9]([-_.]?[A-Za-z0-9])*@[A-Za-z0-9]([-_.]?[A-Za-z0-9])*[.]*[a-zA-Z]{2,3}$/i;

                        let regExp = /^[a-z0-9A-Z]+[!#$%&*+-=?^_`/(){|}~]*[a-zA-Z0-9]*@[\w]+\.[a-zA-Z0-9-]+[.]*[a-zA-Z0-9]+$/i;
                        
                        if(regExp.test($idInput.val())){ //조건에 맞음

                            $.ajax({
                			url:"<%= contextPath%>/idCheck.me",
                			data:{checkId:$idInput.val()},
                			success:function(result){
                				
                				if(result == "NNNNN"){ // 사용 불가능일 경우
                					alert("이미 존재하거나 탈퇴한 회원의 아이디입니다.");
                					$idInput.focus(); // id입력칸 깜빡이도록
                				}else{// 사용 가능일 경우
                					if(confirm("멋진 아이디네요! 사용하시겠습니까?")){//사용하겠다
                						$("#enroll-form :submit").removeAttr("disabled");
                						$idInput.attr("readonly", true);
                					}else{//사용안하겠다
                						$idInput.focus();
                					}
                				}
                				
                			},error:function(){
                				console.log("아이디 중복체크용 ajax 통신 실패");
                			}
                			
                		});

                        }else{ // 틀림
                            alert("이메일형식에 맞게 입력해주세요.");
                            $idInput.focus();
                        }
                		
                	}
                </script>
    
                <br><br>
    
            </form>
    
    
        </div>
    
    <br><br>
    
    <%@ include file="../common/footer.jsp" %>

</body>
</html>