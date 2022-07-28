<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>

<!-- css -->
<link rel="stylesheet" href="${pageContext.request.contextPath}/resources/css/mentorMypage/createClass.css">


<script src="https://kit.fontawesome.com/d9c0959348.js" crossorigin="anonymous"></script>
    
    <title>Document</title>
   


</head>
<body>

    <%@ include file="../common/menubar.jsp" %> 

<div class="wrapper">
    <div class="hello">
       <h2> 안녕하세요, 멘토님 <br>
        어떤 강의를 열고 싶으신가요? </h2>
        <br>
    </div>

    <form>
        <div class="open-class-body">
            <h3>카테고리 선택</h3>
            <select>
                <option>IT 개발</option>
                <option>마케팅/MD/영업</option>
                <option>회계/재무/금융</option>
                <option>전략/기획</option>
                <option>유통/무역/구매</option>
                <option>공사/공기업/공무원</option>
                <option>전문/특수</option>
                <option>진로탐색</option>
            </select>
        </div>

        <div class="open-class-body">
                <h3>클래스 제목</h3>
                <input type="text" name="" id="" placeholder="어떤 이야기를 전해 주시나요?">
        </div>

        <div class="open-class-body">
            <h3>커버 이미지</h3>

            <button type="submit">커버 이미지 업로드</button>
        </div>

        <div class="open-class-body">
                <h3>어떤 클래스인가요? (강의소개)</h3>
                <input type="text" name="" id="class-detail" placeholder="* 무엇을 배울 수 있나요, 무엇을 얻을 수 있나요?">
                
        
         </div>

        <div class="open-class-body">
            <h3>클래스 상세소개 (커리큘럼)</h3>
            <input type="text" name="" id="class-detail" placeholder="* 자세한 강의 커리큘럼을 적어주세요.">
        </div>
            
        <div class="open-class-body">
            <p>
            <span id="grey-area-top" style="font-size:1.5em; font-weight:bolder">마지막으로, 수강료를 입력해 주세요.</span> <br>
            <span class="grey-area "style="color:grey">(수강생이 지불하는 최종 수강료로, VAT 10%가 포함된 가격입니다.)</h4>
            <!-- <h2>최종 수강료</h2> -->
            <br><br>
            <input type="text" class="won" name="finalprice1" id="finalprice1" placeholder="원">
        </div>
        <br>
    <!-- <input type="text" name="" id="" placeholder=""> -->



            <div class="fianlprofit">
                    <label id=grey-area-top style="color:#6363FF; font-size:2em; font-weight:bolder">최종 정산금 안내 <i class="fa-solid fa-sack-dollar" style="color:orange"></i> </label><br>
                    <span class="grey-area ">멘토님께 정산되는 금액으로, 최종 수강료에서 VAT, 연결 수수료, 소득세 원청징수가 제외됩니다.</span>
                    
                    <div class="final-wrapper">
                        <div class="final">
                            <p>최종 수강료</p>
                            <input type="text" class="won" name="finalprice2" id="finalprice2" placeholder="원">
                        </div>

                        <div class="final" id="minus" style="margin-top:auto"><i class="fa-solid fa-minus"></i></div>
                        
                        <div class="final">
                            <p>VAT 10%</p>
                            <input type="text" class="won" name="vat" id="vat" placeholder="원">
                        </div>

                        <div class="final" id="minus" style="margin-top:auto"><i class="fa-solid fa-minus"></i></div>

                        <div class="final">
                            <p>연결 수수료 20%</p>
                            <input type="text" class="won" name="fee" id="fee" placeholder="원">
                        </div>

                        <div class="final" id="minus" style="margin-top:auto"><i class="fa-solid fa-minus"></i></div>

                        <div class="final"> 
                            <p>소득세 원천징수 3.3%</p>
                            <input type="text" class="won" name="incometax" id="incometax" placeholder="원">
                        </div>

                           
                            

                    </div>
                     
                    
                    
                </div>

                    <div width="500px" style="display:flex; justify-content:end;">
                    
                        <div class="final-result">
                                <i class="fa-solid fa-equals" style="margin: 0 38px";></i>
                             <input type="text" class="won" name="finalprofit" id="finalprofit" placeholder="원">
                            </div>
                 </div>

                 
                
                    
                    <!-- <div class="final-result">
                            <i class="fa-solid fa-equals"></i>
                         <input type="text" name="finalprofit" id="finalprofit" placeholder="원">
                        </div>
             </div> -->
            </form>


</div>

    
    
    
    
     <br>
     <br> 
     <br>
     <br>
     <br>
     <br> 
<%@ include file="../common/footer.jsp" %>
</body>
</html>