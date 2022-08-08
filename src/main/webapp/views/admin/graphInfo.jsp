<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<link rel="stylesheet" href="${pageContext.request.contextPath}/resources/css/admin/newgrap.css">
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
	    <h3>홈페이지 정보</h3>
 
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
     <div>
     <div >
    <div style="margin-bottom:-25px ;">
    <span style="font-size:25px ; font-weight: bolder; margin-left: 3%; color: #6363ff;">
        ━ 
    </span> &nbsp;
    <span style="font-size:25px ; font-weight: bolder;">날짜선택</span>

    <span style="font-size:25px ; font-weight: bolder; margin-left: 3%; color: #6363ff; margin-left: 40%">
        ━ 
    </span> &nbsp;
    <span style="font-size:25px ; font-weight: bolder;">일자별요약</span>
    </div>
    
    <br> <br>
	<div>
    &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;<input type="date" value="" id="lastDate">&nbsp;&nbsp;&nbsp; ~&nbsp;&nbsp;&nbsp;<input type="date" value="" id="currentDate"> &nbsp;&nbsp;&nbsp; 
    <select name="len" id="len" style="height:30px; width:80px; text-align:center" >
	    <option value=5 >5&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;</option>
	    <option value=7>7&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;</option>
    </select>
    <span style="padding-left: 30%">
    <input type="date" value="" id="selDate">
    </span>
    </div>
     <br><br>
     <div style="width:45%; float:left; ; height:45%" id="abc" >
        <canvas id="line-chart" width="300" height="250"></canvas>
    </div>
    </div> 
    <br>
    <div style="width:45% ; height:65%; float:left; margin:5%; margin-top: 0%  ">
    	<table class="table table-bordered ">
	    	<thead>
	    		<tr>
	    			<th>일자</th>
	    			<th>강의구매수</th>
	    			<th>매출액</th>
	    			<th>가입수</th>
	    			<th>문의수</th>
	    			<th>게시글수</th>
	    		</tr>
	    	</thead>
	    	<tbody>
	    		<tr>
	    			<td id="a1"></td>
	    			<td id="a2"></td>
	    			<td id="a3"></td>
	    			<td id="a4"></td>
	    			<td id="a5"></td>
	    			<td id="a6"></td>
	    		</tr>
	    		<tr>
	    			<td id="b1"></td>
	    			<td id="b2"></td>
	    			<td id="b3"></td>
	    			<td id="b4"></td>
	    			<td id="b5"></td>
	    			<td id="b6"></td>
	    		</tr>
	    		<tr>
	    			<td id="c1"></td>
	    			<td id="c2"></td>
	    			<td id="c3"></td>
	    			<td id="c4"></td>
	    			<td id="c5"></td>
	    			<td id="c6"></td>
	    		</tr>
	    		<tr>
	    			<td id="d1"></td>
	    			<td id="d2"></td>
	    			<td id="d3"></td>
	    			<td id="d4"></td>
	    			<td id="d5"></td>
	    			<td id="d6"></td>
	    		</tr>
	    		<tr>
	    			<td id="e1"></td>
	    			<td id="e2"></td>
	    			<td id="e3"></td>
	    			<td id="e4"></td>
	    			<td id="e5"></td>
	    			<td id="e6"></td>
	    		</tr>
	    		<tr>
	    			<td id="f1"></td>
	    			<td id="f2"></td>
	    			<td id="f3"></td>
	    			<td id="f4"></td>
	    			<td id="f5"></td>
	    			<td id="f6"></td>
	    		</tr>
	    		<tr>
	    			<td id="g1"></td>
	    			<td id="g2"></td>
	    			<td id="g3"></td>
	    			<td id="g4"></td>
	    			<td id="g5"></td>
	    			<td id="g6"></td>
	    		</tr>
	    		<tr>
	    			<th id="h1">총합계</th>
	    			<td id="h2"></td>
	    	 		<td id="h3"></td>
	    			<td id="h4"></td>
	    			<td id="h5"></td>
	    			<td id="h6"></td>
	    		</tr>
	    		
	    	</tbody>
    	</table>
    </div>
    </div>
    <script>
    
    var timezoneOffset = new Date().getTimezoneOffset() * 60000;
	var kr = new Date(Date.now() - timezoneOffset);
	var kr2 = new Date(Date.now() - timezoneOffset);
	
    const lastdate = new Date(kr.setMonth(kr.getMonth() - 1)).toISOString().substring(0, 10);
    const currentdate = kr2.toISOString().substring(0, 10);
    
    $(function(){
    	$.ajax({
    		url:"<%=request.getContextPath()%>/boardDetail.de",
    		success:function(list){
    			console.log(list)
    			$('#a1').text(list[0].date)
    			$('#a2').text(list[0].classBuy)
    			$('#a3').text(list[0].sale)
    			$('#a4').text(list[0].join)
    			$('#a5').text(list[0].que)
    			$('#a6').text(list[0].board)
    			
    			$('#b1').text(list[1].date)
    			$('#b2').text(list[1].classBuy)
    			$('#b3').text(list[1].sale)
    			$('#b4').text(list[1].join)
    			$('#b5').text(list[1].que)
    			$('#b6').text(list[1].board)
    			
    			$('#c1').text(list[2].date)
    			$('#c2').text(list[2].classBuy)
    			$('#c3').text(list[2].sale)
    			$('#c4').text(list[2].join)
    			$('#c5').text(list[2].que)
    			$('#c6').text(list[2].board)
    			
    			$('#d1').text(list[3].date)
    			$('#d2').text(list[3].classBuy)
    			$('#d3').text(list[3].sale)
    			$('#d4').text(list[3].join)
    			$('#d5').text(list[3].que)
    			$('#d6').text(list[3].board)
    			
    			$('#e1').text(list[4].date)
    			$('#e2').text(list[4].classBuy)
    			$('#e3').text(list[4].sale)
    			$('#e4').text(list[4].join)
    			$('#e5').text(list[4].que)
    			$('#e6').text(list[4].board)
    			
    			$('#f1').text(list[5].date)
    			$('#f2').text(list[5].classBuy)
    			$('#f3').text(list[5].sale)
    			$('#f4').text(list[5].join)
    			$('#f5').text(list[5].que)
    			$('#f6').text(list[5].board)
    			
    			$('#g1').text(list[6].date)
    			$('#g2').text(list[6].classBuy)
    			$('#g3').text(list[6].sale)
    			$('#g4').text(list[6].join)
    			$('#g5').text(list[6].que)
    			$('#g6').text(list[6].board)
    			
    			let b=0; let c=0; let d=0; let e=0; let f=0; 
    			
    			for(let i=0;i<7;i++){
        			b +=list[i].classBuy
        			c += list[i].sale
        			d += list[i].join
        			e += list[i].que
        			f += list[i].board
    			}
    			
    			
    			$('#h2').text(b)
    			$('#h3').text(c)
    			$('#h4').text(d)
    			$('#h5').text(e)
    			$('#h6').text(f)
    			
    		},error:function(){
    			alert('error')
    		}
    	})
    })
    
    $('#selDate').change(function(){
    	if($('#selDate').val()>currentdate){
    		alert('유효한 날짜로 검색해주세요.')
    		$('#selDate').val(currentdate)
    	}else{
    	
    	$.ajax({
    		url:"<%=request.getContextPath()%>/boardDetail.de",
    		data:{
    			day: $('#selDate').val()
    		},
    		success:function(list){
    			console.log(list)
    			$('#a1').text(list[0].date)
    			$('#a2').text(list[0].classBuy)
    			$('#a3').text(list[0].sale)
    			$('#a4').text(list[0].join)
    			$('#a5').text(list[0].que)
    			$('#a6').text(list[0].board)
    			
    			$('#b1').text(list[1].date)
    			$('#b2').text(list[1].classBuy)
    			$('#b3').text(list[1].sale)
    			$('#b4').text(list[1].join)
    			$('#b5').text(list[1].que)
    			$('#b6').text(list[1].board)
    			
    			$('#c1').text(list[2].date)
    			$('#c2').text(list[2].classBuy)
    			$('#c3').text(list[2].sale)
    			$('#c4').text(list[2].join)
    			$('#c5').text(list[2].que)
    			$('#c6').text(list[2].board)
    			
    			$('#d1').text(list[3].date)
    			$('#d2').text(list[3].classBuy)
    			$('#d3').text(list[3].sale)
    			$('#d4').text(list[3].join)
    			$('#d5').text(list[3].que)
    			$('#d6').text(list[3].board)
    			
    			$('#e1').text(list[4].date)
    			$('#e2').text(list[4].classBuy)
    			$('#e3').text(list[4].sale)
    			$('#e4').text(list[4].join)
    			$('#e5').text(list[4].que)
    			$('#e6').text(list[4].board)
    			
    			$('#f1').text(list[5].date)
    			$('#f2').text(list[5].classBuy)
    			$('#f3').text(list[5].sale)
    			$('#f4').text(list[5].join)
    			$('#f5').text(list[5].que)
    			$('#f6').text(list[5].board)
    			
    			$('#g1').text(list[6].date)
    			$('#g2').text(list[6].classBuy)
    			$('#g3').text(list[6].sale)
    			$('#g4').text(list[6].join)
    			$('#g5').text(list[6].que)
    			$('#g6').text(list[6].board)
    			
    			let b=0; let c=0; let d=0; let e=0; let f=0; 
    			
    			for(let i=0;i<7;i++){
        			b +=list[i].classBuy
        			c += list[i].sale
        			d += list[i].join
        			e += list[i].que
        			f += list[i].board
    			}
    			
    			
    			$('#h2').text(b)
    			$('#h3').text(c)
    			$('#h4').text(d)
    			$('#h5').text(e)
    			$('#h6').text(f)
    			
    		},error:function(){
    			alert('error')
    		}
    	})
    	}
    })
    
    $(function(){
    	
    	var timezoneOffset = new Date().getTimezoneOffset() * 60000;
    	var kr = new Date(Date.now() - timezoneOffset);
    	var kr2 = new Date(Date.now() - timezoneOffset);
    	
        const lastdate = new Date(kr.setMonth(kr.getMonth() - 1)).toISOString().substring(0, 10);
        const currentdate = kr2.toISOString().substring(0, 10);
        
        document.getElementById('lastDate').value = lastdate
        document.getElementById('currentDate').value = currentdate
        document.getElementById('selDate').value = currentdate
        
        $.ajax({
            url:"<%=request.getContextPath()%>/graphDetail.de",
            data:{
              "lastdate":lastdate,
              'currentdate':currentdate,
              "s":$('#len').val()
            },
            success:function(list){
            	new Chart(document.getElementById("line-chart"), {
                    type: 'line',
                    data: {
                    labels: [list[0].x,list[1].x,list[2].x,list[3].x,list[4].x],
                    datasets: [{ 
                        data: [list[0].y,list[1].y,list[2].y,list[3].y,list[4].y],
                        label: "수강생수",
                        borderColor: "#3e95cd",
                        fill: false
                    }, { 
                        data: [list[5].y,list[6].y,list[7].y,list[8].y,list[9].y],
                        label: "멘토수",
                        borderColor: "#3cba9f",
                        fill: false
                    }, { 
                    	data: [list[10].y,list[11].y,list[12].y,list[13].y,list[14].y],
                        label: "전체회원수",
                        borderColor: "#8e5ea2",
                        fill: false
                    }, { 
                    	data: [list[14].y+10,0],
                        label: "",
                        borderColor: "white",
                        fill: false
                    },
                    ]
                    },options: {
                        title: {
                            display: true,
                            text: '회원증가추세'
                          }
                        }
                    
                    });
            },
            error:function(){
                  
            }
        })

    })
    
    $('#lastDate').change(function(){
    	console.log($('#lastDate').val())
    	
		if($('#lastDate').val()>$('#currentDate').val() || $('#currentDate').val()>currentdate){
			alert('정확한범위를 설정하세요.')
			$('#lastDate').val(lastdate)
		}else{
    	
    	$.ajax({
            url:"<%=request.getContextPath()%>/graphDetail.de",
            data:{
              "lastdate":$('#lastDate').val(),
              'currentdate':$('#currentDate').val(),
              "s":$('#len').val()
            },
            success:function(list){
            	if($('#len').val()==5){
            		new Chart(document.getElementById("line-chart"), {
                    type: 'line',
                    data: {
                    labels: [list[0].x,list[1].x,list[2].x,list[3].x,list[4].x],
                    datasets: [{ 
                        data: [list[0].y,list[1].y,list[2].y,list[3].y,list[4].y],
                        label: "수강생수",
                        borderColor: "#3e95cd",
                        fill: false
                    }, { 
                    	 data: [list[5].y,list[6].y,list[7].y,list[8].y,list[9].y],
                        label: "멘토수",
                        borderColor: "#3cba9f",
                        fill: false
                    }, { 
                        data: [list[10].y,list[11].y,list[12].y,list[13].y,list[14].y],
                        label: "전체회원수",
                        borderColor: "#8e5ea2",
                        fill: false
                    }, { 
                    	data: [list[14].y+10,0],
                        label: "",
                        borderColor: "#FFFFFF",
                        fill: false
                    },
                    ]
                    },options: {
                        title: {
                            display: true,
                            text: '회원증가추세'
                          }
                        }
                   
                    });
            	}else if($('#len').val()==7){
            		new Chart(document.getElementById("line-chart"), {
                        type: 'line',
                        data: {
                        labels: [list[0].x,list[1].x,list[2].x,list[3].x,list[4].x,list[5].x,list[6].x],
                        datasets: [{ 
                            data: [list[0].y,list[1].y,list[2].y,list[3].y,list[4].y,list[5].y,list[6].y],
                            label: "수강생수",
                            borderColor: "#3e95cd",
                            fill: false
                        }, { 
                        	data: [list[7].y,list[8].y,list[9].y,list[10].y,list[11].y,list[12].y,list[13].y],
                            label: "멘토수",
                            borderColor: "#3cba9f",
                            fill: false
                        }, { 
                        	data: [list[14].y,list[15].y,list[16].y,list[17].y,list[18].y,list[19].y,list[20].y],
                            label: "전체회원수",
                            borderColor: "#8e5ea2",
                            fill: false
                        }, { 
                        	data: [list[20].y+10],
                            label: "",
                            borderColor: "#FFFFFF",
                            fill: false
                        },
                        ]
                        },options: {
                            title: {
                                display: true,
                                text: '회원증가추세'
                              }
                            }
                       
                        });
            	}
            },
            error:function(){
                  alert('error')
            }
        })
		}
	})
	
	$('#len').change(function(){
    	console.log($('#lastDate').val())
		if($('#lastDate').val()>$('#currentDate').val() || $('#currentDate').val()>currentdate){
			alert('정확한범위를 설정하세요.')
		}else{
    	
    	$.ajax({
            url:"<%=request.getContextPath()%>/graphDetail.de",
            data:{
              "lastdate":$('#lastDate').val(),
              'currentdate':$('#currentDate').val(),
              "s":$('#len').val()
            },
            success:function(list){
            	if($('#len').val()==5){
            		new Chart(document.getElementById("line-chart"), {
                    type: 'line',
                    data: {
                    labels: [list[0].x,list[1].x,list[2].x,list[3].x,list[4].x],
                    datasets: [{ 
                        data: [list[0].y,list[1].y,list[2].y,list[3].y,list[4].y],
                        label: "수강생수",
                        borderColor: "#3e95cd",
                        fill: false
                    }, { 
                    	 data: [list[5].y,list[6].y,list[7].y,list[8].y,list[9].y],
                        label: "멘토수",
                        borderColor: "#3cba9f",
                        fill: false
                    }, { 
                        data: [list[10].y,list[11].y,list[12].y,list[13].y,list[14].y],
                        label: "전체회원수",
                        borderColor: "#8e5ea2",
                        fill: false
                    }, { 
                    	data: [list[14].y+10,0],
                        label: "",
                        borderColor: "#FFFFFF",
                        fill: false
                    },
                    ]
                    },options: {
                        title: {
                            display: true,
                            text: '회원증가추세'
                          }
                        }
                   
                    });
            	}else if($('#len').val()==7){
            		new Chart(document.getElementById("line-chart"), {
                        type: 'line',
                        data: {
                        labels: [list[0].x,list[1].x,list[2].x,list[3].x,list[4].x,list[5].x,list[6].x],
                        datasets: [{ 
                            data: [list[0].y,list[1].y,list[2].y,list[3].y,list[4].y,list[5].y,list[6].y],
                            label: "수강생수",
                            borderColor: "#3e95cd",
                            fill: false
                        }, { 
                        	data: [list[7].y,list[8].y,list[9].y,list[10].y,list[11].y,list[12].y,list[13].y],
                            label: "멘토수",
                            borderColor: "#3cba9f",
                            fill: false
                        }, { 
                        	data: [list[14].y,list[15].y,list[16].y,list[17].y,list[18].y,list[19].y,list[20].y],
                            label: "전체회원수",
                            borderColor: "#8e5ea2",
                            fill: false
                        }, { 
                        	data: [list[20].y+10,0],
                            label: "",
                            borderColor: "#FFFFFF",
                            fill: false
                        },
                        ]
                        },options: {
                            title: {
                                display: true,
                                text: '회원증가추세'
                              }
                            }
                       
                        });
            	}
            },
            error:function(){
                  alert('error')
            }
        })
		}
	})
	
	$('#currentDate').change(function(){
    	
		if($('#lastDate').val()>$('#currentDate').val() || $('#currentDate').val()>currentdate){
			alert('정확한범위를 설정하세요.')
			$('#currentDate').val(currentdate)
		}else{
    	
    	$.ajax({
            url:"<%=request.getContextPath()%>/graphDetail.de",
            data:{
              "lastdate":$('#lastDate').val(),
              'currentdate':$('#currentDate').val(),
              "s":$('#len').val()
            },
            success:function(list){
            	if($('#len').val()==5){
            		new Chart(document.getElementById("line-chart"), {
                    type: 'line',
                    data: {
                    labels: [list[0].x,list[1].x,list[2].x,list[3].x,list[4].x],
                    datasets: [{ 
                        data: [list[0].y,list[1].y,list[2].y,list[3].y,list[4].y],
                        label: "수강생수",
                        borderColor: "#3e95cd",
                        fill: false
                    }, { 
                    	 data: [list[5].y,list[6].y,list[7].y,list[8].y,list[9].y],
                        label: "멘토수",
                        borderColor: "#3cba9f",
                        fill: false
                    }, { 
                        data: [list[10].y,list[11].y,list[12].y,list[13].y,list[14].y],
                        label: "전체회원수",
                        borderColor: "#8e5ea2",
                        fill: false
                    }, { 
                    	data: [list[14].y+10,0],
                        label: "",
                        borderColor: "#FFFFFF",
                        fill: false
                    },
                    ]
                    },options: {
                        title: {
                            display: true,
                            text: '회원증가추세'
                          }
                        }
                   
                    });
            	}else if($('#len').val()==7){
            		new Chart(document.getElementById("line-chart"), {
                        type: 'line',
                        data: {
                        labels: [list[0].x,list[1].x,list[2].x,list[3].x,list[4].x,list[5].x,list[6].x],
                        datasets: [{ 
                            data: [list[0].y,list[1].y,list[2].y,list[3].y,list[4].y,list[5].y,list[6].y],
                            label: "수강생수",
                            borderColor: "#3e95cd",
                            fill: false
                        }, { 
                        	data: [list[7].y,list[8].y,list[9].y,list[10].y,list[11].y,list[12].y,list[13].y],
                            label: "멘토수",
                            borderColor: "#3cba9f",
                            fill: false
                        }, { 
                        	data: [list[14].y,list[15].y,list[16].y,list[17].y,list[18].y,list[19].y,list[20].y],
                            label: "전체회원수",
                            borderColor: "#8e5ea2",
                            fill: false
                        }, { 
                        	data: [list[20].y+10,0],
                            label: "",
                            borderColor: "#FFFFFF",
                            fill: false
                        },
                        ]
                        },options: {
                            title: {
                                display: true,
                                text: '회원증가추세'
                              }
                            }
                       
                        });
            	}
            },
            error:function(){
                  alert('error')
            }
        })
		}
	})


        
    </script>
    </div>
    </div>
	 <%} %>   
        
</body>
</html>