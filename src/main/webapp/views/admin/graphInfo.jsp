<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<link rel="stylesheet" href="${pageContext.request.contextPath}/resources/css/admin/graphInfo.css">
<script src="https://cdnjs.cloudflare.com/ajax/libs/Chart.js/2.5.0/Chart.min.js"></script>

<title>Insert title here</title>
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
	    <h3>쿠폰등록</h3>
    <select name="selectNo">
        <option value="1">쿠폰등록및관리</option>
        <option value="2">쿠폰발송</option>
    </select>
    <br><br>
    <script>
        $(function(){
            $("#selectNo").on('change',function(){
                if($(this).val()==2){
                    location.href="<%=request.getContextPath()%>/refundRequest.bo";
                }
                 
            })
        })
    </script>
    <br>
    <div class="checks">
        <span style="font-size:25px ; font-weight: bolder; margin-left: 3%; color: #6363ff; float: left;">
            ▶ 사이트현황
        </span>
     </div>
     <br><br>
    <div style="margin-bottom:-25px ;">
    <span style="font-size:25px ; font-weight: bolder; margin-left: 3%; color: #6363ff;">
        ━ 
    </span> &nbsp;
    <span style="font-size:25px ; font-weight: bolder;">날짜선택</span>
    </div>
    <br> <br>

    &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;<input type="date" value="" id="lastDate">&nbsp;&nbsp;&nbsp; ~&nbsp;&nbsp;&nbsp;<input type="date" value="" id="currentDate">
     <br>
     <div style="width:45% ; height:45%" id="abc">
        <canvas id="line-chart" width="300" height="250"></canvas>
    </div>
     
    
    <script>
    const lastdate = new Date(new Date().setMonth(new Date().getMonth() - 1)).toISOString().substring(0, 10);
    const currentdate = new Date().toISOString().substring(0, 10);
    
    document.getElementById('lastDate').value = lastdate
    document.getElementById('currentDate').value = currentdate
    
    new Chart(document.getElementById("line-chart"), {
        type: 'line',
        data: {
        labels: [220801,220802,220803,220804,220805,220806,220807],
        datasets: [{ 
            data: [10,12,9,8,5,6,7],
            label: "일일접속자수",
            borderColor: "#3e95cd",
            fill: false
        }, { 
            data: [0,10,20,30,40,50],
            
            borderColor: "white",
            fill: false
        }, { 
            data: [],
            label: "Europe",
            borderColor: "#3cba9f",
            fill: false
        }, 
        ]
        },
        options: {
            title: {
            display: true,
            text: '접속자수'
            }
        }
        });

            
       
            
			$(function(){
				
			
           
            $.ajax({
                url:"<%=request.getContextPath()%>/graphDetail.de",
                data:{
                  "lastdate":lastdate,
                  'currentdate':currentdate
                },
                success:function(data){
                    
                },
                error:function(){
                      
                }
            })
            
          
			})
        
    </script>
	 <%} %>   
        
</body>
</html>