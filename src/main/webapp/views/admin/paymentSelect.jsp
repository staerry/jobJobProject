<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import="com.jj.common.model.vo.PageInfo, com.jj.member.model.vo.Member, java.util.ArrayList"%>
<%
	PageInfo pi = (PageInfo)request.getAttribute("pi");
	ArrayList<Member> list = (ArrayList<Member>)request.getAttribute("list");
	String[] check = (String[])request.getAttribute("check");
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
<link rel="stylesheet" href="${pageContext.request.contextPath}/resources/css/admin/paymentSelect.css">
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
	        <h3>결제내역조회</h3>
		    <select name="selectNo" id="selectNo">
		        <option value="1">회원리스트로 조회</option>
		        <option value="2">결제내역순으로 조회</option>
		    </select>
		    <script>
		    	$(function(){
		    		$("#selectNo").on('change',function(){
		    			if($(this).val()==2){
		    				location.href="<%=request.getContextPath()%>/paymentselect2.bo?p=1";
		    			}
		    			 
		    		})
		    	})
		    </script>
			<br><br>
		    <div class="checks">
		        <div id="formwraping">
		            <form action="<%= request.getContextPath() %>/paymentselect.bo" style="">
		            	<input type="hidden" name="p" value="1">
		                &nbsp;
		                <input type="checkbox" id="check1" name="check" value="1" checked> 
		                <label for="check1">회원</label>
		                &nbsp;
		                <input type="checkbox" id="check2" name="check" value="2"> 
		                <label for="check2">탈퇴한회원</label> 
		                &nbsp;&nbsp;
		                <input type="text" style="line-height: 30px; width: 200px; text-align:center" id="searchclick" placeholder="이름,회원번호,결제번호" name="search">
		                <label for="searchclick"><button id="searchbtn" style="line-height: 30px;" class="btnpurple">검색</button></label>
		            </form>
		        </div>
		    </div>
		    
		    <script>
		    $('#check2').on('click',function(){
				if($(this).prop('checked')){
					$('#check1').prop('checked',false)
				}
			})
			
			$('#check1').on('click',function(){
				if($(this).prop('checked')){
					$('#check2').prop('checked',false)
				}
			})
			
			<% if(check[0].equals("2")){ %>
				$('#check1').prop('checked',false)
				$('#check2').prop('checked',true)
			<%}%>
			
			$('#searchclick').val('<%=search%>')
		    </script>
			
		    <div style="position:relative ;">
		        <div class="detailInfo positionab" style="display:none">
		        	<div class="close close2"></div>
            		<br><br>
		            &nbsp;&nbsp;&nbsp;&nbsp;<h3 style="text-align:center;" id="main"></h3>
		            <form>
		            	<input type="hidden" id="pagenum" value="0" name="p">
		            	<input type="hidden" id="userno" value="0" name="no">
		                <table class="table table-bordered table-hover stutable">
		                    <thead>
			                    <tr>
			                        <th>결제강의</th>
			                        <th>결제수단</th>
			                        <th>결제일시</th>
			                        <th>최종결제금액</th>
			                        <th>사용한쿠폰</th>
			                        <th>환불여부</th>
			
			                    </tr>
		                    </thead>
		                    <tbody id="payselect">
			                    <tr>
			                        <td></td>
			                        <td></td>
			                        <td></td>
			                        <td></td>
			                        <td></td>
			                        <td></td>
			                    </tr>
		                    </tbody>
		                </table>
		                <br><br>
		                <div align="center">
		                    <span class="arrowL" style="margin-right:100px; cursor:pointer"></span>
		                    <span class="arrowR" style="cursor:pointer"></span>
		                </div>
		            </form>
		        </div>
		        <script>
		        	$(".close").on('click',function(){
		        		$('.detailInfo').css('display','none');
		        	})
		        </script>
		        <div>
		            <table class="table table-bordered table-hover stutable">
		                <thead>
		                    <tr>
		                        <th width="100">번호(회원고유번호)</th>
		                        <th width="100">이름</th>
		                        <th width="130">아이디</th>
		                        <th width="80">회원등급</th>
		                        <th width="120">상세보기</th>
		                       
		                    </tr>
		                </thead>
		                <%if(list.isEmpty()){ %>
							<script>
							alert("조회된 회원이없습니다.")
							location.href= "javascript:history.back()";
							</script>
						<%}else{ %>
		                <tbody>
		                <%for(int i=0;i<list.size();i++){ %>
		                    <tr>
		                        <td class="notext"><%=lpage-i %> (<%=list.get(i).getUserNo() %>)</td>
		                        <td class="nametext"><%=list.get(i).getUserName() %></td>
		                        <td><%=list.get(i).getUserId() %></td>
		                        <td><%=(list.get(i).getUserDivision())==1 ? "수강생" : "멘토" %></td>
		                        
		                        <td><button type="button" class="button1" >결제내역 상세보기</button></td>
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
						 <a href="<%=request.getContextPath()%>/paymentselect.bo?p=<%=doublePrev%>&search=<%=request.getAttribute("search")%>&check=<%=check[0]%>">&lt&lt</a>
						 <%} %>
					 <%if(currentPage != 1){ %>
						<a href="<%=request.getContextPath()%>/paymentselect.bo?p=<%=currentPage-1%>&search=<%=request.getAttribute("search")%>&check=<%=check[0]%>">&lt</a>
						<%} %>
						<%for(int i=startPage;i<=endPage;i++){ %>
			            	<%if(i==currentPage){ %>
			            		<a href="<%=request.getContextPath()%>/paymentselect.bo?p=<%=i%>&search=<%=request.getAttribute("search")%>&check=<%=check[0]%>"><%=i %></a>
			            	<%}else{ %>
			            		<a href="<%=request.getContextPath()%>/paymentselect.bo?p=<%=i%>&search=<%=request.getAttribute("search")%>&check=<%=check[0]%>"><%=i %></a>
			            	<%} %>
		            	<%} %>
		            	<%if(currentPage != maxPage){ %>
							<a href="<%=request.getContextPath()%>/paymentselect.bo?p=<%=currentPage+1%>&search=<%=request.getAttribute("search")%>&check=<%=check[0]%>">&gt</a>
						<%} %>
						<%if(currentPage < maxPage - pageLimit ){ %>
							<a href="<%=request.getContextPath()%>/paymentselect.bo?p=<%=doubleNext%>&search=<%=request.getAttribute("search")%>&check=<%=check[0]%>">&gt&gt</a>
						<%} %>
					</div>
		        </div>
		    </div>  
		</div>
	</div>
	<%} %>
	<script>
	$('.button1').click(function(e){
		$('#main').text($(this).parent().siblings('.nametext').text()+'님의 결제내역')
		$.ajax({
			url:"<%=request.getContextPath()%>/payDetail.li",
			data:{
				prevNo:$(this).parent().siblings('.notext').text(),
				p:1
				},
			success:function(list){
				
				if(list.length==0){
					let result = ""
					result += "<tr>"
							+	"<td colspan='6'>조회된 결과가 없습니다.</td>"
							+"</tr>";
					$('#payselect').html(result)
					$('.arrowR').css('display','none')
					$('.arrowL').css('display','none')
				}else{
					let result=""
					for(let i=0;i<list.length;i++){
						let a = ""
						let b = ""
						let c = ""
						let d = ""
						let e = ""
						let f = ""
						let g = ""
					
							a = "<td>"+list[i].payDate+"</td>"	
						
						if(list[i].isuCpNo==null){
							b = "<td>--</td>"
						}else{
						b = "<td>"+list[i].isuCpNo+"</td>"	
						}
						if(list[i].refund=='Y'){
							c = "<td>환불완료</td>"
						}else if(list[i].refund=='D'){
							c = "<td>환불거절</td>"
						}else{
							c = "<td>--</td>"	
						}
						if(list[i].orderName==null){
							d="--"
						}else{
							d=list[i].orderName
						}
						if(list[i].orderPhone==null){
							e="--"
						}else{
							e=list[i].orderPhone
						}
						if(list[i].orderEmail==null){
							f="--"
						}else{
							f=list[i].orderEmail
						}
						if(list[i].refundDate==null){
							g="--"
						}else{
							g=list[i].refundDate
						}
	    			   result += '<tr class="def">'
	    						+	"<td>"+list[i].clNo+"</td>"
	    						+	"<td>"+list[i].payment+"</td>"
	    						+	a
	    						+	"<td>"+list[i].finalPayment+"</td>"
	    						+	b
	    						+	c
	    						+"</tr>"
	    						+ "<tr class='add1' style='display:none;'>"
	    						+	"<th>주문자명</th>"
	    						+	"<td colspan='2' style='text-align:left'>"+d+"</td>"
	    						+	"<th>주문자번호</th>"
	    						+	"<td colspan='2' style='text-align:left'>"+e+"</td>"
	    						+"</tr>"
	    						+ "<tr class='add1' style='display:none;'>"
	    						+	"<th>주문자이메일</th>"
	    						+	"<td colspan='2' style='text-align:left'>"+f+"</td>"
	    						+	"<th>환불일시</th>"
	    						+	"<td colspan='2' style='text-align:left'>"+g+"</td>"
	    						+"</tr>"
	    			}
					$('#pagenum').val(list[0].pi.currentPage)
					$('#userno').val(list[0].userNo)
					if($('#pagenum').val()=='1'){
	        			$('.arrowL').css('display','none')
	        		}else{
	        			$('.arrowL').css('display','')
	        		}
					if($('#pagenum').val()==list[0].pi.maxPage){
	        			$('.arrowR').css('display','none')
	        		}else{
	        			$('.arrowR').css('display','')
	        		}
					console.log(parseInt($('#pagenum').val())+1)
					
					$('#payselect').html(result)
					
					
					
				}
			},error:function(){
				alert('정보를 찾지 못했습니다');
				e.preventDefault();
			}
		})

		$('.detailInfo').css('display',"")
	})
	
	
		 
		 $(document).on("click",".def",function(){
				
				
            	const $li = $(this).next();
            	const $li2 = $(this).next().next();

                if( $li.css("display") == "none" ){
                     
                	$('.add1').slideUp();
                       
                      $li.slideDown();
                      $li2.slideDown();
                      
                  }else{
                      $li.slideUp(); 
                      $li2.slideUp(); 
                      
                  }
            })
              
       
	
	
	$('.arrowR').click(function(e){
		$.ajax({
			url:"<%=request.getContextPath()%>/payDetail.li",
			data:{
				no:$('#userno').val(),
				p:parseInt($('#pagenum').val())+1
				},
			success:function(list){
				
				if(list.length==0){
					let result = ""
					result += "<tr>"
							+	"<td colspan='6'>조회된 결과가 없습니다.</td>"
							+"</tr>";
					$('#payselect').html(result)
					$('.arrowR').css('display','none')
					$('.arrowL').css('display','none')
				}else{
					let result=""
						for(let i=0;i<list.length;i++){
							let a = ""
							let b = ""
							let c = ""
							let d = ""
							let e = ""
							let f = ""
							let g = ""
						
								a = "<td>"+list[i].payDate+"</td>"	
							
							if(list[i].isuCpNo==null){
								b = "<td>--</td>"
							}else{
							b = "<td>"+list[i].isuCpNo+"</td>"	
							}
							if(list[i].refund=='Y'){
								c = "<td>환불완료</td>"
							}else if(list[i].refund=='D'){
								c = "<td>환불거절</td>"
							}else{
								c = "<td>--</td>"	
							}
							if(list[i].orderName==null){
								d="--"
							}else{
								d=list[i].orderName
							}
							if(list[i].orderPhone==null){
								e="--"
							}else{
								e=list[i].orderPhone
							}
							if(list[i].orderEmail==null){
								f="--"
							}else{
								f=list[i].orderEmail
							}
							if(list[i].refundDate==null){
								g="--"
							}else{
								g=list[i].refundDate
							}
		    			   result += '<tr class="def">'
		    						+	"<td>"+list[i].clNo+"</td>"
		    						+	"<td>"+list[i].payment+"</td>"
		    						+	a
		    						+	"<td>"+list[i].finalPayment+"</td>"
		    						+	b
		    						+	c
		    						+"</tr>"
		    						+ "<tr class='add1' style='display:none;'>"
		    						+	"<th>주문자명</th>"
		    						+	"<td colspan='2' style='text-align:left'>"+d+"</td>"
		    						+	"<th>주문자번호</th>"
		    						+	"<td colspan='2' style='text-align:left'>"+e+"</td>"
		    						+"</tr>"
		    						+ "<tr class='add1' style='display:none;'>"
		    						+	"<th>주문자이메일</th>"
		    						+	"<td colspan='2' style='text-align:left'>"+f+"</td>"
		    						+	"<th>환불일시</th>"
		    						+	"<td colspan='2' style='text-align:left'>"+g+"</td>"
		    						+"</tr>"
		    			}
						$('#pagenum').val(list[0].pi.currentPage)
						$('#userno').val(list[0].userNo)
						if($('#pagenum').val()=='1'){
		        			$('.arrowL').css('display','none')
		        		}else{
		        			$('.arrowL').css('display','')
		        		}
						if($('#pagenum').val()==list[0].pi.maxPage){
		        			$('.arrowR').css('display','none')
		        		}else{
		        			$('.arrowR').css('display','')
		        		}
						console.log(parseInt($('#pagenum').val())+1)
						
						$('#payselect').html(result)
				}
			},error:function(){
				alert('정보를 찾지 못했습니다');
				e.preventDefault();
			}
		})
	})
	
	$('.arrowL').click(function(e){
		$.ajax({
			url:"<%=request.getContextPath()%>/payDetail.li",
			data:{
				no:$('#userno').val(),
				p:parseInt($('#pagenum').val())-1
				},
			success:function(list){
				
				if(list.length==0){
					let result = ""
					result += "<tr>"
							+	"<td colspan='6'>조회된 결과가 없습니다.</td>"
							+"</tr>";
					$('#payselect').html(result)
					$('.arrowR').css('display','none')
					$('.arrowL').css('display','none')
				}else{
					let result=""
						for(let i=0;i<list.length;i++){
							let a = ""
							let b = ""
							let c = ""
							let d = ""
							let e = ""
							let f = ""
							let g = ""
						
								a = "<td>"+list[i].payDate+"</td>"	
							
							if(list[i].isuCpNo==null){
								b = "<td>--</td>"
							}else{
							b = "<td>"+list[i].isuCpNo+"</td>"	
							}
							if(list[i].refund=='Y'){
								c = "<td>환불완료</td>"
							}else if(list[i].refund=='D'){
								c = "<td>환불거절</td>"
							}else{
								c = "<td>--</td>"	
							}
							if(list[i].orderName==null){
								d="--"
							}else{
								d=list[i].orderName
							}
							if(list[i].orderPhone==null){
								e="--"
							}else{
								e=list[i].orderPhone
							}
							if(list[i].orderEmail==null){
								f="--"
							}else{
								f=list[i].orderEmail
							}
							if(list[i].refundDate==null){
								g="--"
							}else{
								g=list[i].refundDate
							}
		    			   result += '<tr class="def">'
		    						+	"<td>"+list[i].clNo+"</td>"
		    						+	"<td>"+list[i].payment+"</td>"
		    						+	a
		    						+	"<td>"+list[i].finalPayment+"</td>"
		    						+	b
		    						+	c
		    						+"</tr>"
		    						+ "<tr class='add1' style='display:none;'>"
		    						+	"<th>주문자명</th>"
		    						+	"<td colspan='2' style='text-align:left'>"+d+"</td>"
		    						+	"<th>주문자번호</th>"
		    						+	"<td colspan='2' style='text-align:left'>"+e+"</td>"
		    						+"</tr>"
		    						+ "<tr class='add1' style='display:none;'>"
		    						+	"<th>주문자이메일</th>"
		    						+	"<td colspan='2' style='text-align:left'>"+f+"</td>"
		    						+	"<th>환불일시</th>"
		    						+	"<td colspan='2' style='text-align:left'>"+g+"</td>"
		    						+"</tr>"
		    			}
						$('#pagenum').val(list[0].pi.currentPage)
						$('#userno').val(list[0].userNo)
						if($('#pagenum').val()=='1'){
		        			$('.arrowL').css('display','none')
		        		}else{
		        			$('.arrowL').css('display','')
		        		}
						if($('#pagenum').val()==list[0].pi.maxPage){
		        			$('.arrowR').css('display','none')
		        		}else{
		        			$('.arrowR').css('display','')
		        		}
						console.log(parseInt($('#pagenum').val())+1)
						
						$('#payselect').html(result)
				}
			},error:function(){
				alert('정보를 찾지 못했습니다');
				e.preventDefault();
			}
		})
	})
	
	
	</script>
</body>
</html>