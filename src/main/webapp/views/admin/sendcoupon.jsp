<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import="com.jj.common.model.vo.PageInfo, com.jj.coupon.vo.Coupon, java.util.ArrayList, com.jj.member.model.vo.Member"%>
<%
	PageInfo pi = (PageInfo)request.getAttribute("pi");
	ArrayList<Coupon> list = (ArrayList<Coupon>)request.getAttribute("list");
	ArrayList<Member> list2 = (ArrayList<Member>)request.getAttribute("list2");
	String check = (String)request.getAttribute("check");
	String search = (String)request.getAttribute("search");
	
	int lpage = (int)request.getAttribute("lpage");
	int currentPage = pi.getCurrentPage();
	int startPage = pi.getStartPage();
	int endPage = pi.getEndPage();
	int maxPage = pi.getMaxPage();
	int pageLimit = pi.getPageLimit();
	
	int doublePrev = pageLimit*(currentPage/pageLimit);
	int doubleNext = pageLimit*(currentPage/pageLimit+1)+1;
%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<link rel="stylesheet" href="${pageContext.request.contextPath}/resources/css/admin/sendcoupon.css">
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
            <h3>쿠폰관리</h3>
            <select name="selectNo" id="selectNo">
                <option value="1">쿠폰등록및관리</option>
                <option value="2" selected>쿠폰발송</option>
                <option value="3">회원쿠폰조회</option>
            </select>
            <br><br>
            <script>
                $(function(){
                    $("#selectNo").on('change',function(){
                        if($(this).val()==1){
                            location.href="<%=request.getContextPath()%>/couponManage.ad?p=1";
                        }
                         
                    })
                    
                     $("#selectNo").on('change',function(){
                        if($(this).val()==3){
                            location.href="<%=request.getContextPath()%>/selectCoupon.li?p=1";
                        }  
                    })
                })
            </script>
            <br>
            <div class="checks">
                <div style="font-size:25px ; font-weight: bolder; margin-left: 3%; color: #6363ff;">
                    ▶  쿠폰발송하기
                </div>
            </div>
        
            <br>
            
            <div style="margin-bottom:-25px ;">
            <span style="font-size:25px ; font-weight: bolder; margin-left: 3%; color: #6363ff;">
                ━ 
            </span> &nbsp;
            <span style="font-size:25px ; font-weight: bolder;">1. 발송쿠폰선택</span>
            </div>
            
            <div>
                <table class="table table-bordered table-hover stutable">
                    <thead>
                        <tr>
                            <th width="20">선택</th>
                            <th width="20">번호</th>
                            <th width="50">쿠폰번호</th>
                            <th width="100">쿠폰명</th>
                            <th width="80">할인금액</th>
                            <th width="50">상태</th>
                            <th width="25">등록일</th>
                            
                           
                        </tr>
                    </thead>
                    <%if(list.isEmpty()){ %>
							<script>
							alert("조회된 쿠폰이 없습니다.")
							location.href= "javascript:history.back()";
							</script>
					<%}else{ %>
                    <tbody>
                    	<%for(int i=0;i<list.size();i++){ %>
                        <tr>
                            <td>
                                <div class="checks2">
                                    <input type="radio" id="radio<%=i %>" name="grade"> 
                                    <label for="radio<%=i%>"></label>
                                </div>
                            </td>
                            <td><%=lpage-i %></td>
	                        <td  class="cpNo"><%=list.get(i).getCpNo() %></td>
	                        <td class="cpName"><%=list.get(i).getCpName() %></td>
	                        <td><%=list.get(i).getDiscount() %>원</td>
	                        <td><%=(list.get(i).getCpStatus()).equals("Y") ? "발급가능" : "발급불가" %></td>
	                        <td><%=list.get(i).getCpAddDate() %></td>
                        </tr>
                        <%} %>
                    </tbody>
					<%} %>                   
                </table>
                
                <span class="totalpage">
                    <%=currentPage %> 페이지 / <%=maxPage %> 페이지  
                </span>
        
                <div class="paging-area">
                    	<%if(currentPage > pageLimit ){ %>
						 <a href="<%=request.getContextPath()%>/sendCoupon.ad?p=<%=doublePrev%>">&lt&lt</a>
						 <%} %>
						 <%if(currentPage != 1){ %>
						<a href="<%=request.getContextPath()%>/sendCoupon.ad?p=<%=currentPage-1%>">&lt</a>
						<%} %>
						<%for(int i=startPage;i<=endPage;i++){ %>
			            	<%if(i==currentPage){ %>
			            		<a href="<%=request.getContextPath()%>/sendCoupon.ad?p=<%=i%>"><%=i %></a>
			            	<%}else{ %>
			            		<a href="<%=request.getContextPath()%>/sendCoupon.ad?p=<%=i%>"><%=i %></a>
			            	<%} %>
		            	<%} %>
		            	<%if(currentPage != maxPage){ %>
							<a href="<%=request.getContextPath()%>/sendCoupon.ad?p=<%=currentPage+1%>">&gt</a>
						<%} %>
						<%if(currentPage < maxPage - pageLimit ){ %>
							<a href="<%=request.getContextPath()%>/sendCoupon.ad?p=<%=doubleNext%>">&gt&gt</a>
						<%} %>
                </div>
            </div>
            <br><br>
            <div>
                <span style="font-size:25px ; font-weight: bolder; margin-left: 3%; color: #6363ff;">
                    ━ 
                </span> &nbsp;
                <span style="font-size:25px ; font-weight: bolder;">2. 회원선택</span>
            </div>
            <br>
            <div class="Wbox" style="margin-left:20px ;">
                <div class="search1">
                    <div class="search2">
                    <input type="text" style="line-height: 30px; width: 200px;" id="searchclick" placeholder="  이름또는 회원번호로 검색">
                    <button type="button" id="searchbtn" style="line-height: 30px;" class="btnpurple">검색</button>
                    </div>
                </div>
                
                <span class="sall">
                    <div class="checks1">
                        <input type="checkbox" id="ch1"> 
                        <label for="ch1">전체선택</label>
                        
                        <input type="checkbox" id="ch2"> 
                        <label for="ch2" style="padding-left: 290px;">전체선택</label>
                    </div>
                </span>
                
                <script>
                $('#ch1').on('click',function(){
                	if($('#ch1').prop('checked')){
                		$('.userNo').prop('checked',true)
                	}else{
                		$('.userNo').prop('checked',false)
                	}
                })
                
                 $('#ch2').on('click',function(){
                	if($('#ch2').prop('checked')){
                		$('.selectNo').prop('checked',true)
                	}else{
                		$('.selectNo').prop('checked',false)
                	}
                })
               
                </script>
                
                
                <div>
                   <ul class="lbox">
                   		<%for(int i=0;i<list2.size();i++){ %>
                        <li>
                            <div class="checks11 v1">
                                <input type="checkbox" id="aaa<%=list2.get(i).getUserNo() %>" class="userNo" name="userNo" value=<%=list2.get(i).getUserNo()%>>     
                                <label for="aaa<%=list2.get(i).getUserNo() %>"><%=list2.get(i).getUserName()%>(<%=list2.get(i).getUserId()%>)</label>
                            </div>  
                        </li>
                        <%} %>
                   </ul>
                </div>
                <div class="cbox">
                    <div align="center" style="margin-top:70px ; font-size:70px;">
                        <div><button class="btns rbtn">›</button></div>
                        
                        <div><button class="btns lbtn">‹</button></div>
                    </div>
                </div>
                <div>
                    <ul class="rbox">
                        
                   </ul>
                </div>
                
                <div class="sendbtn">
                    <br><br>    
                    <button type="button" class="button1" id="sendcp">쿠폰발송</button>
                </div>
                <script>
            		let rNo = [];
            		let lNo = [];
            		
                	$('.rbtn').on('click',function(){
                		$('#ch1').prop('checked',false)
                	
                		let arr = [];
                    	var li = $('input[class="userNo"]:checked');
						$(li).each(function(){
							arr.push($(this).val())
							$(this).parent().parent().css('display','none')
							
						})
						
						for(let i=0;i<arr.length;i++){
							rNo.push(arr[i])
						}
					
						$.ajax({
							
							url:"<%= request.getContextPath() %>/rbutton.cl",
							data:{
								"rNo":rNo.join(',')
							},
							type:"post",
							success:function(list){
								let a = "";
								for(let i=0;i<list.length;i++){
									a +=   '<li>'
			                           + 	'<div class="checks11">'
	                                   +			'<input type="checkbox" class="selectNo" id="bbb'+list[i].userNo+'" value='+list[i].userNo+'>'     
	                                   +			'<label for="bbb'+list[i].userNo+'">'+list[i].userName+'('+list[i].userId+')</label>'
	                            	   +		'</div>'
	                        		   +	'</li>'
								}
								
								$('.rbox').html(a);
							},
							error:function(list){
								alert('오류')
							}
							
						})
					})
					
					$('.lbtn').on('click',function(){
						$('#ch2').prop('checked',false)
                	
                		let arr = [];
                    	var li = $('input[class="selectNo"]:checked');
						$(li).each(function(){
							arr.push($(this).val())
							$(this).parent().parent().css('display','none')
							
						})
						console.log(arr)
						
						for(let i=0;i<arr.length;i++){
							for(let j=0;j<rNo.length;j++){
								if(arr[i]==rNo[j]){
									$('#aaa'+rNo[j]).parent().parent().css('display','')
									$('#aaa'+rNo[j]).prop('checked',false)
									rNo.splice(j,1)
								}
							}
						}
						
					
						console.log(rNo)
						console.log(rNo.join(','))
						$.ajax({
							
							url:"<%= request.getContextPath() %>/rbutton.cl",
							data:{
								"rNo":rNo.join(',')
							},
							type:"post",
							success:function(list){
								let a = "";
								for(let i=0;i<list.length;i++){
									a +=   '<li>'
			                           + 	'<div class="checks11">'
	                                   +			'<input type="checkbox" id="aaa'+i+'" value='+list[i].userNo+'>'     
	                                   +			'<label for="aaa'+i+'">'+list[i].userName+'('+list[i].userId+')</label>'
	                            	   +		'</div>'
	                        		   +	'</li>'
								}
								
								$('.rbox').html(a);
							},
							error:function(list){
								alert('선택회원없음')
							}
							
						})
					})
					
					$('#searchbtn').on('click',function(){
				
						if($('#searchclick').val()==""){
							$('.userNo').parent().parent().css('display','')
							for(let i=0;i<rNo.length;i++){
								$('#aaa'+rNo[i]).parent().parent().css('display','none')
							}
						}else{
							$.ajax({
								url:"<%= request.getContextPath() %>/sbutton.cl",
								data:{
									"search":$('#searchclick').val()
								},
								type:"post",
								success:function(list){
									console.log(list)
									$('.userNo').parent().parent().css('display','none')
									
									for(let i=0;i<list.length;i++){
										$('#aaa'+list[i]).parent().parent().css('display','')
									}
									
									for(let i=0;i<list.length;i++){
										for(let j=0;j<rNo.length;j++){
											if(list[i]==rNo[j]){
												$('#aaa'+list[i]).parent().parent().css('display','none')
											}
										}
									}
								},error:function(){
									alert('오류')
								}
							})
						}
					})
					
					$('#sendcp').on('click',function(){
						let cp = $('input[name="grade"]:checked')
						let cpNo = cp.parent().parent().siblings('.cpNo').text()
						let userNo = rNo.join(',')
						
					
							for(let i=0;i<rNo.length;i++){
							$.ajax({
								url:"<%= request.getContextPath() %>/cpSendButton.cl",
								data:{
									"cpNo":cpNo,
									"userNo":rNo[i]
								},
								type:"post",
								success:function(result){
									if(result>0){
										
									}else{
										alert('쿠폰전달이 중간에 실패했습니다('+i+'번째'+rNo[i]+'번 회원번호에서 오류).')
										
									}
								},
								error:function(){
									alert('오류')
									
								}
							})
						}
						
						alert('쿠폰전달에 성공했습니다.')
						location.href="<%= request.getContextPath() %>/couponManage.ad?p=1"
					})
					
				</script>
            </div>
	    </div>
	</div>
	<%} %>
</body>
</html>