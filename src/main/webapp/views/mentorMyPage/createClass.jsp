<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<meta name="viewport" content="width=device-width, initial-scale=1">
<!-- css -->
<link rel="stylesheet" href="${pageContext.request.contextPath}/resources/css/setting.css">
<link rel="stylesheet" href="${pageContext.request.contextPath}/resources/css/userMyPage/mainTemplate.css">
<link rel="stylesheet" href="${pageContext.request.contextPath}/resources/css/MentorMyPage/createClass.css">
    
    <script src="https://kit.fontawesome.com/d9c0959348.js" crossorigin="anonymous"></script>   
<!-- 부트스트랩 -->
   <!--  <link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap@4.6.1/dist/css/bootstrap.min.css">
    <script src="https://cdn.jsdelivr.net/npm/popper.js@1.16.1/dist/umd/popper.min.js"></script>
    <script src="https://cdn.jsdelivr.net/npm/bootstrap@4.6.1/dist/js/bootstrap.bundle.min.js"></script> -->
    
<title>Insert title here</title>
<style>
wrapper{
    margin-left:100px;
    width:1040px;
    
}
.hello>*{
	margin:40px 0px 20px 0px;
	padding-top:20px;
}

.open-class-body{
    margin-bottom: 20px;
    
}

.open-class-body>h3{
margin-bottom:15px;
	}

.open-class-body> input{
    width:250px;
    
}


.open-class-body > #class-detail{
    margin-bottom: 15px;
    width:300px;
    height:100px;
}


.grey-area{
    color:grey;
    margin-bottom:30px;
    
}

.final>p{
    font-weight: bolder;
    font-size:14px;
    
    
}


.final-wrapper{
    display:inline-flex; flex-direction: row; justify-content: space-evenly;
}
.final-wrapper>*{
    margin:20px;
}
.final-wrapper>p{
    text-align:center;
}
.final{
margin-left:0px;}



.won::placeholder{text-align: right;
padding-right: 3px;
}

</style>

</head>
<body>
	<%@ include file="../common/menubar.jsp" %>
	
    <div class="main-web-wrap">
			        <div class="left-content">
			            <!--여기에 좌측 메뉴-->
			            <!-- 멘토마이페이지 좌측바  -->
			            
			            <%@ include file="common/mypageSidebarMentor.jsp" %> 
			        </div>
			        
	        <div class="right-content">
	            <!--여기에 컨텐츠-->
	            
	            <h2 style="color : #6363ff">나의 클래스</h2>
	            <h3 style="margin:20px 0px;">새로운 클래스 만들기</h3>
	            
	            
	            	<div class="wrapper">
						    <p class="hello">
						       <h4> 안녕하세요, 멘토님 어떤 강의를 열고 싶으신가요? </h4>
						        <br>
						    </p>
						
				    	<form action="<%=contextPath%>/createClass.my"  method="post" enctype="multipart/form-data">
				        <div class="open-class-body">
				            <h3>강의 분야(1개만 선택)</h3>
				            <div class="col">
                                    <input type="radio" name="clCategory" id="computer" value="1" checked>
                                    <label for="computer">IT개발</label>&nbsp;

                                    <input type="radio" name="clCategory" id="marketing" value="2">
                                    <label for="marketing">마케팅/MD/영업</label>
                                    <br>
            
                                    <input type="radio" name="clCategory" id="banking" value="3">
                                    <label for="banking">회계/재무/금융</label>&nbsp;
            
                                    <input type="radio" name="clCategory" id="planning" value="4">
                                    <label for="planning">전략/기획</label><br>
            
                                    <input type="radio" name="clCategory" id="trading" value="5">
                                    <label for="trading">유통/무역/구매</label>&nbsp;
            
                                    <input type="radio" name="clCategory" id="government" value="6">
                                    <label for="government">공사/공기업/공무원</label>
                                    <br>
            
                                    <input type="radio" name="clCategory" id="special" value="7">
                                    <label for="special">전문/특수</label>
                                    
                                </div>
				        </div>
	
				        <div class="open-class-body">
				                <h3>클래스 제목</h3>
				                <input type="text" name="className" placeholder="클래스의 이름을 입력해주세요" required>
				        </div>
				        
				         <div class="open-class-body">
				                <h3>클래스 소제목</h3>
				                <input type="text" name="classSubName" placeholder="어떤 이야기를 전해 주시나요?" required>
				        </div>
	
					        <div class="open-class-body">
					            <h3>커버 이미지 첨부</h3>
								<input type="file" class="form-control" name="clImg" required>
					        </div>
					
					        <div class="open-class-body">
					                <h3>어떤 클래스인가요? (강의소개)</h3>
					                <input type="text" name="classInfo" id="classInfo" placeholder="* 무엇을 배울 수 있나요, 무엇을 얻을 수 있나요?" required>
					                
					         
					         </div>
					
					        <div class="open-class-body">
					            <h3>클래스 상세소개 (커리큘럼)</h3>
					            <input type="text" name="curri" id="class-detail" placeholder="* 자세한 강의 커리큘럼을 적어주세요." required>
					        </div>
					            
					       <div class="open-class-body">
					            <p>
					            <span id="grey-area-top" style="font-size:1.5em; font-weight:bolder">마지막으로, 수강료를 입력해 주세요.<i class="fa-solid fa-sack-dollar" style="color:orange"></i> </span> <br>
					            <span class="grey-area "style="color:grey">(수강생이 지불하는 최종 수강료로, VAT 10%가 포함된 가격입니다.)</span>
					           
					            <input type="text" class="won" name="clPrice" id="finalprice1" placeholder="원" required>
					        </div> 
					        <br> 
					 
							<br>
                            <button type="submit"  style="border:none; background-color:#6363ff; color:white; width:130px; height:50px; align:center; border-radius:4px">최종제출</button>
						</form>
	
	
	            <!-- <div class="fianlprofit">
	                    <label id=grey-area-top style="color:#6363FF; font-size:2em; font-weight:bolder">최종 정산금 안내 <i class="fa-solid fa-sack-dollar" style="color:orange"></i> </label><br>
	                    <span class="grey-area ">멘토님께 정산되는 금액으로, 최종 수강료에서 VAT, 연결 수수료, 소득세 원청징수가 제외됩니다.</span>
						 -->
	                   	<!-- <div class="final-wrapper">
	                        <div class="final">
	                            <p>최종 수강료</p>
	                            <input type="text" class="won" name="finalprice2" id="finalprice2" placeholder="원">
	                        </div>
	
	                        <div class="final" id="minus" style="margin-top:auto"><i class="fa-solid fa-minus"></i></div>
	                        
	                        <div class="final">
	                            <p>세금포함 수수료30%</p>
	                            <input type="text" class="won" name="vat" id="vat" placeholder="원">
	                        </div> -->
	
	                       
                           
                            

                   		 </div> 
                     
               	 </div>
               	 
               	 

                    <div  style="display:flex; width:200px; justify-content:end;">
                    	<!-- <div class="final-result" style="margin: 0 10px 10px 400px">
                                <i class="fa-solid fa-equals" ></i></div>
                           <div>  <input type="text" class="won" name="clPrice" id="finalprofit" placeholder="원">
                            </div>
                           <br>
                           </div> -->
                        
    
                 	</div>
	            	
	            
	        </div>
   
    	    
  		</div>
  		
     
     <br>
     <br> 
     <br>
     <br>
     <br>
     <br> 
<%@ include file="../common/footer.jsp" %>
  
</body>
<script>


</script>
</html>