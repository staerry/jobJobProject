<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<meta name="viewport" content="width=device-width, initial-scale=1">
<link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap@4.6.1/dist/css/bootstrap.min.css">
<script src="https://cdn.jsdelivr.net/npm/jquery@3.6.0/dist/jquery.slim.min.js"></script>
<script src="https://cdn.jsdelivr.net/npm/popper.js@1.16.1/dist/umd/popper.min.js"></script>
<script src="https://cdn.jsdelivr.net/npm/bootstrap@4.6.1/dist/js/bootstrap.bundle.min.js"></script>
<title>Insert title here</title>
<style>
    .container{
    /*border:1px solid blue;*/ 
    width:1190px;
    height:auto;
    display:flex;
    flex-direction:row;
    justify-content: space-between;
    padding:28px 16px 100px 34px;
    }
    input[type="text"]{
        width: 300px;
    }
    input[type="file"]{
        width: 300px;
    }
    #btn1{
        width: 100px;
        height: 35px;
        border-style: none;
        border-radius: 5px;
        background: #6363FF;
        color: white;
    }
    }
</style>
</head>
<body>

	<%@ include file="../common/menubar.jsp" %>

    <div class="container">

        <table style="margin: auto;">

            <br><br>
            <form action="<%= contextPath %>/insertMentor.me" method="post" enctype="multipart/form-data" id="enroll-form">

                <tr>
                    <td>
                        <div class="log-in">

                            <h2 align="center">니Job 내Job에서<br>경험을 공유해주세요</h2><br>
                            
                            <div class="left">
                                <div class="col">
                                	<input type="text" class="form-control"  placeholder="이름(실명)입력" name="mtName" required>
                                </div><br>
                                <div class="col">
                                	<input type="text" class="form-control" placeholder="이메일 주소 입력" name="mtId" required>
                                    <p> </p>
                                    <button type="button" id="btn1" onclick="idCheck();" style="float: right;">중복확인</button>
                                    <span id="show1"></span>
                                    
                                </div><br>
                                <div class="col">
                                    <input type="password" id="pwd" class="form-control" placeholder="비밀번호 입력" name="mtPwd" required onkeyup="checkPW();">
                                </div><br>
                                <div class="col">
                                    <input type="password" id="checkPwd" class="form-control" placeholder="비밀번호 재입력" required onkeyup="checkPW();">
                                    <span id="show"></span>
                                </div><br>
                                
                                <div class="col">
                                    <input type="text" id="userPhone" class="form-control" placeholder="핸드폰 번호 입력" name="mtPhone" required onkeyup="phoneCheck();">
                                	<span id="check"></span>
                                </div><br>
                                
                                <div class="col">
                                    <span>관심분야(1개 선택해주세요)</span><br>
                                        
                                    <input type="radio" name="field" id="computer" value="1" checked>
                                    <label for="computer">IT개발</label>&nbsp;

                                    <input type="radio" name="field" id="marketing" value="2">
                                    <label for="marketing">마케팅/MD/영업</label>
                                    <br>
            
                                    <input type="radio" name="field" id="banking" value="3">
                                    <label for="banking">회계/재무/금융</label>&nbsp;
            
                                    <input type="radio" name="field" id="planning" value="4">
                                    <label for="planning">전략/기획</label><br>
            
                                    <input type="radio" name="field" id="trading" value="5">
                                    <label for="trading">유통/무역/구매</label>&nbsp;
            
                                    <input type="radio" name="field" id="government" value="6">
                                    <label for="government">공사/공기업/공무원</label>
                                    <br>
            
                                    <input type="radio" name="field" id="special" value="7">
                                    <label for="special">전문/특수</label>
                                    
                                </div>
                            </div>
                        </div>
                        

                    </td>
                    <td>
                        <div class="confirm">

                            <h2 align="center">현직자 인증하기</h2>
                            
                            <div class="right">
                                <h4 align="center">서류인증 (신분증 + 사원증)</h4><br>

                                <div class="col">
                                    <input type="text" class="form-control" placeholder="현재 소속된 회사" name="mtCompany" required>
                                </div><br>
                                <div class="col">
                                    <input type="text" class="form-control" placeholder="현재 직무" name="mtPosition" required>
                                </div><br>

                                <div class="col">
                                    <span>사원증 사진 첨부</span>
                                    <input type="file" class="form-control" name="mtEmpCard" required>
                                </div><br>
                                
                                <div class="col">
                                    <span>신분증 사진 첨부</span>
                                    <input type="file" class="form-control" name="mtIdCard" required>
                                </div>
                            </div>
                        </div>

                    </td>
                </tr>

                <tr>
                    <td colspan="2" align="center">
                        <button type="submit" id="abcd" class="btn btn-primary" style="background: #6363FF; border: none; width: 400px;" disabled>다음</button>
                    </td>
                </tr>

            </form>

        </table>
        <br><br>
        
        <script>
	        function checkPW(){
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
	        	
	        	if(regPhone.test(phone)){//핸드폰 형식 맞음
	        		$('#check').html('GOOD!');
	        		document.getElementById('check').style.color = 'blue';
	        		$('#abcd').removeAttr("disabled");
	        	}else{ // 핸드폰 형식 아님
	        		$('#check').html('핸드폰 번호를 입력해주세요.');
	        	}
	        }
	        
	        function idCheck(){
        		
        		// 아이디 입력하는 input요소 객체
        		const $idInput = $("input[name=mtId]");

                let regExp = /^[a-z0-9A-Z]+[!#$%&*+-=?^_`/(){|}~]*[a-zA-Z0-9]*@[\w]+\.[a-zA-Z0-9-]+[.]*[a-zA-Z0-9]+$/i;
                
                if(regExp.test($idInput.val())){ //조건에 맞음

                    $.ajax({
        			url:"<%= contextPath%>/idCheck.me",
        			data:{checkId:$idInput.val()},
        			success:function(result){
        				
        				if(result == "NNNNN"){ // 사용 불가능일 경우
        					 //$('#show1').html('이미 존재하거나 탈퇴한 회원의 아이디입니다.');
        		            // document.getElementById('show1').style.color = "red";
        		             //$idInput.focus();
        					
        		             
        		            alert("이미 존재하거나 탈퇴한 회원의 아이디입니다.");
        					$idInput.focus(); // id입력칸 깜빡이도록
        				
        				}else{// 사용 가능일 경우
        					if(confirm("멋진 아이디네요! 사용하시겠습니까?")){//사용하겠다
        						//$("#enroll-form :submit").removeAttr("disabled");
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
        
       
        
    </div>
    
    <%@ include file="../common/footer.jsp" %>

</body>
</html>