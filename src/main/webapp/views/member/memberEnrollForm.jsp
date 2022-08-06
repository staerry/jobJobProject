<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap@4.6.1/dist/css/bootstrap.min.css">
<script src="https://cdn.jsdelivr.net/npm/jquery@3.6.0/dist/jquery.slim.min.js"></script>
<script src="https://cdn.jsdelivr.net/npm/popper.js@1.16.1/dist/umd/popper.min.js"></script>
<script src="https://cdn.jsdelivr.net/npm/bootstrap@4.6.1/dist/js/bootstrap.bundle.min.js"></script>
<style>
    .outer{
        /* border: 3px solid rgb(190, 190, 190);  */
        background: white;
        color: black;
        width: 600px;
        margin: auto;
        margin-top: 50px;
    }
    
    input{
        text-decoration-color: rgb(190, 190, 190);
        text-decoration-thickness: 3px;
    }
    
            /* button{
        width: 300px;
        height: 30px;
        border-style: none;
        border-radius: 5px;
        background: #6363FF;
        color: white;
     } */


    button{
        width: 100px;
        height: 35px;
        border-style: none;
        border-radius: 5px;
        background: #6363FF;
        color: white;
    }

    .container{
        /*border:1px solid blue;*/ 
        width:1190px;
        height:auto;
        display:flex;
        flex-direction:row;
        justify-content: space-between;
        padding:28px 16px 100px 34px;
    }

    #enroll-form table{margin: auto; box-sizing: border-box;}
    #enroll-form input{margin: 5px;}

</style>
</head>
<body>

	<%@ include file="../common/menubar.jsp" %>

    <div class="container">

     <div class="outer">
    
            <br>
    
            <h2 align="center">니JOB 내JOB에서<br>꿈을 이뤄보세요.</h2>
            <br>
    
            <form action="<%= contextPath %>/agreeTerm.me" method="post" id="enroll-form">
    
                <table>
    
                    <tr>
                        <td></td>
                        <td><input type="text" name="userName" class="form-control" placeholder="이름(실명)입력" required></td>
                        <td>&nbsp;&nbsp;&nbsp;&nbsp;</td>
                        <td></td>
                    </tr>
    
                    <tr>
                        <td></td>
                        <td><input type="text" name="userId" maxlength="50" class="form-control" placeholder="이메일 주소 입력" required></td>
                        <td></td>
                        <td><button type="button" onclick="idCheck();">중복확인</button></td>
                    </tr>
    
                    <tr>
                        <td></td>
                        <td><input type="password" name="userPwd" id="pwd" maxlength="20" class="form-control" placeholder="비밀번호 입력" required onkeyup="pwdCheck();"></td>
                        <td></td>
                        <td></td>
                    </tr>
    
                    <tr>
                        <td></td>
                        <td><input type="password" id="checkPwd" maxlength="20" placeholder="비밀번호 재입력" class="form-control" required onkeyup="pwdCheck();"></td>
                        <td></td>
                        <td><span id="show" style="font-size: 10px;"></span></td>
                    </tr>
    
                    <tr>
                        <td></td>
                        <td><input type="text" name="userPhone" id="userPhone" maxlength="13" class="form-control" placeholder="핸드폰번호 입력(-포함)" required onkeyup="phoneCheck();"></td>
                        <td></td>
                        <td><span id="check" style="font-size: 10px;"></span></td>
                    </tr>
                 
                </table>
    
                <br>
    
                <div align="center">
                    <button type="submit" disabled>다음</button>
                    <button type="reset">초기화</button>
                </div>
                
                <script>

                    function pwdCheck(){
                        var pwd1 = $('#pwd').val(); 
                        var pwd2 = $('#checkPwd').val();
                        if(pwd1 != pwd2){
                            $('#show').html('비밀번호가 서로 일치하지 않습니다');
                            document.getElementById('show').style.color = "red";
                        } else {
                            $('#show').html('일치!');
                            document.getElementById('show').style.color = "blue";
                        }
                    }

                    function phoneCheck(){
                        var phone = $('#userPhone').val();

                        let regPhone = /^\d{3}-\d{4}-\d{4}$/;

                        if(regPhone.test(phone)){ // true 조건 맞음
                            $('#check').html('GOOD!');
                        }else{
                            $('#check').html('다시 입력해주세요.');
                        }
                    }

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
    </div>
    
    <br><br>
    
    <%@ include file="../common/footer.jsp" %>

</body>
</html>