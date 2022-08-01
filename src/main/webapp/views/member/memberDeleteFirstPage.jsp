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
<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.6.0/jquery.min.js"></script>

<style>
	#red{color:red;}
    input{width: 40px; height: 40px;}
 
    
</style>

</head>
<body>
    <%@ include file="../common/menubar.jsp" %>
    <br><br>
    <div align="center" class="checkbox-group">
        <form action="<%= contextPath %>/deleteSecond.me" method="post" id="delete-form">

                
                <table>
                    <tr>
                        <th colspan="2">
                            <h2>회원탈퇴에 앞서<span style="color:#6363FF;"> 유의사항 및 안내</span>를 반드시 읽고 진행해 주세요! <br><br>
                            </h2>
                        </th>
                        </tr>

                    <tr>
                        <th>
                            <h5>니JOB내JOB 아이디는 재사용 및 복구 불가 안내 </h5><br>
                            <h6>회원탈퇴 진행 시 본인을 포함한 타인 모두 <span id="red">아이디 재사용이나 복구가 불가능합니다.</span>
                                신중히 선택하신 후 결정해주세요.</h6>
                        </th>
                        <td><input type="checkbox" id="check1" class="requiredCheck"></td>
                    </tr>
                        
                    <tr>
                        <td colspan="2">
                            <hr>
                        </td>
                    </tr>
                    
                    <tr>
                        <th>
                            <br>
                            <h5>내 정보 및 개인형 서비스 이용 기록 삭제 안내</h5>
                            <br>
                            <h6>내 정보 및 개인형 서비스 이용기록이 모두 삭제되며, <span id="red">삭제된 데이터는 복구되지 않습니다.</span><br>
                                삭제되는 서비스를 확인하시고, 필요한 데이터는 미리 백업을 해주세요.</h6>
                        </th>
                            
                        
                                
                        <td><input type="checkbox" id="check2" class="requiredCheck"></td>
                    
                    </tr>
                
                    <tr>
                        <td colspan="2">
                            <hr>
                        </td>
                    </tr>
                
                    <tr>
                        <th>
                            <br>
                            <h5> 게시판형 서비스에 등록한 게시글 삭제 불가 안내</h5><br>
                            <h6>삭제를 원하는 게시글이 있다면 반드시 회원탈퇴 전 비공개 처리하거나, 삭제하시기 체바랍니다.<br>
                                탈퇴 후에는 회원정보가 삭제되어 본인 여부를 확인할 수 있는 방법이 없어,
                                <span id="red">게시글을 임의로 삭제해드릴 수 없습니다.</span>
                            </h6>
                        </th>
                        
                    
                            
                        <td><input type="checkbox" id="check3" class="requiredCheck"></td>
                    
                    
                    </tr>
                
                    <tr>
                        <td colspan="2">
                            <hr>
                        </td>
                    </tr>
                
                    <tr>
                        
                            <td align="right">
                                <label for="checkAll">전체 동의하기</label>
                            </td>
                            <td align="right">
                                <input type="checkbox" class="input_check" id="checkAll" style="width: 20px; height: 20px;">
                                
                            </td>
                        
                    </tr>
                
                <tr align="center">
                    <td colspan="2"><br>
                        <button type="reset" class="btn btn-primary" id="returnBtn" onclick="location.href='<%=contextPath%>'">탈퇴 취소</button>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
                        <button class="btn btn-danger" id="nextBtn" disabled >확인</button>
                    </td>
                </tr>
                
            </table>
        </form>
    </div>
        
        <script>

        $(".checkbox-group").on("click", "#checkAll", function(){
        	$(this).parents(".checkbox-group").find("input").prop("checked", $(this).is(":checked"));
        	
        });
        
	    $(".checkbox-group").on("click", ".requiredCheck", function(){
	        var isChecked = true;
	
	        $(".checkbox-group .requiredCheck").each(function(){
	            isChecked = isChecked && $(this).is(":checked");
	        });
	
	        $("#checkAll").prop("checked", isChecked);
	
	    });
        
        

        
        
        $(function(){
            $("#delete-form :checkbox").change(function(){
                let flag = true;

                $(".requiredCheck").each(function(){
                    if(!$(this).prop("checked")){
                        flag = false;
                    }
                })
                if(flag == false){ 
                    $('#nextBtn').attr('disabled', 'disabled');
                }else{ 
                    $('#nextBtn').removeAttr("disabled");
                }
            })
        })

        </script>

    </div>
    <br><br>
    <%@ include file="../common/footer.jsp" %>
        
        
</body>
</html>