<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<style>
	#red{color:red;}
</style>

</head>
<body>

    <div>

        <table border="1">
            
            <tr>
                <th colspan="2">회원탈퇴에 앞서 <span style="color:blue">유의사항 및 안내</span>를 반드시 읽고 진행해 주세요! <br><br><br>
                </th>
            </tr>
            
            <tr>
                <th>니JOB내JOB 아이디는 재사용 및 복구 불가 안내 <br><br>
                    회원탈퇴 진행 시 본인을 포함한 타인 모두 <span id="red">아이디 재사용이나 복구가 불가능합니다.</span>
                    신중히 선택하신 후 결정해주세요
                </th>

                <td><input type="checkbox"></td>
                
            </tr>
            
            <tr>
                <th>내 정보 및 개인형 서비스 이용 기록 삭제 안내 <br><br>
                    내 정보 및 개인형 서비스 이용기록이 모두 삭제되며, <span id="red">삭제된 데이터는 복구되지 않습니다.</span>
                    삭제되는 서비스를 확인하시고, 필요한 데이터는 미리 백업을 해주세요.
                </th>
                
                <td><input type="checkbox"></td>
                
            </tr>
            
            <tr>
                <th>게시판형 서비스에 등록한 게시글 삭제 불가 안내 <br><br>
                    삭제를 원하는 게시글이 있다면 반드시 회원탈퇴 전 비공개 처리하거나, 삭제하시기 바랍니다.
                    탈퇴 후에는 회원정보가 삭제되어 본인 여부를 확인할 수 있는 방법이 없어,
                    <span id="red">게시글을 임의로 삭제해드릴 수 없습니다.</span>
                </th>
                
                <td><input type="checkbox"></td>
                
            </tr>

            <tr align="center">
                <td colspan="2">
                    <button type="reset">탈퇴 취소</button>
                    <button>확인</button>
                
                </td>
                
            </tr>

        </table>

    </div>


</body>
</html>