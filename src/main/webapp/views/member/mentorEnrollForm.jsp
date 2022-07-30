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
</style>
</head>
<body>

	<%@ include file="../common/menubar.jsp" %>

    <div class="container">

        <table style="margin: auto;">

            <br><br>
            <form action="<%= contextPath %>/insertMentor.me" method="post" enctype="multipart/form-data">

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
                                </div><br>
                                <div class="col">
                                    <input type="password" class="form-control" placeholder="비밀번호 입력" name="mtPwd" required>
                                </div><br>
                                <div class="col">
                                    <input type="password" class="form-control" placeholder="비밀번호 재입력" required>
                                </div><br>
                                
                                <div class="col">
                                    <input type="text" class="form-control" placeholder="핸드폰 번호 입력" name="mtPhone" required>
                                </div><br>
                                
                                <div class="col">
                                    <span>관심분야</span><br>
                                        
                                    <input type="checkbox" name="interest" id="computer" value="IT개발">
                                    <label for="computer">IT개발</label>&nbsp;

                                    <input type="checkbox" name="interest" id="marketing" value="마케팅/MD/영업">
                                    <label for="marketing">마케팅/MD/영업</label>
                                    <br>
            
                                    <input type="checkbox" name="interest" id="banking" value="회계/재무/금융">
                                    <label for="banking">회계/재무/금융</label>&nbsp;
            
                                    <input type="checkbox" name="interest" id="planning" value="전략/기획">
                                    <label for="planning">전략/기획</label><br>
            
                                    <input type="checkbox" name="interest" id="trading" value="유통/무역/구매">
                                    <label for="trading">유통/무역/구매</label>&nbsp;
            
                                    <input type="checkbox" name="interest" id="government" value="공사/공기업/공무원">
                                    <label for="government">공사/공기업/공무원</label>
                                    <br>
            
                                    <input type="checkbox" name="interest" id="special" value="전문/특수">
                                    <label for="special">전문/특수</label>
                                    
                                </div>
                            </div>
                        </div>
                        

                    </td>
                    <td>
                        <div class="confirm">

                            <h2 align="center">현직자 인증하기</h2><br>
                            
                            <div class="right">
                                <h4 align="center">서류인증 (신분증 + 사원증)</h4><br>

                                <div class="col">
                                    <input type="text" class="form-control" placeholder="현재 소속된 회사" name="mtCompany" required>
                                </div><br>
                                <div class="col">
                                    <input type="text" class="form-control" placeholder="현재 직급" name="mtPosition" required>
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
                        <button type="submit" class="btn btn-primary" style="background: #6363FF; border: none; width: 400px;">다음</button>
                    </td>
                </tr>

            </form>

        </table>
        <br><br>
    </div>
    
    <%@ include file="../common/footer.jsp" %>

</body>
</html>