<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8" import="com.jj.member.model.vo.Member"%>
 
   
 
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<!--      fontawesome-->
<link href="assets/fontawesome-free/css/all.min.css" rel="stylesheet" type="text/css">
 <script src="https://kit.fontawesome.com/d9c0959348.js" crossorigin="anonymous"></script>


<!-- js -->
 <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.6.0/jquery.min.js"></script>

 
<style>
 .side-menu {
            top: 160px;
            width: 45px;
            z-index: 10;
            background: #6363FF;
            border-right: 1px solid rgba(0, 0, 0, 0.07);
            bottom: 50px;
            height: 100%;
            margin-bottom: -70px;
            margin-top: 0px;
            padding-bottom: 70px;
            position: fixed;
            box-shadow: 0 0px 24px 0 rgb(0 0 0 / 6%), 0 1px 0px 0 rgb(0 0 0 / 2%);
        }

        .sidebar-inner {
            height: 100%;
            padding-top: 30px;
        }

        #sidebar-menu,
        #sidebar-menu ul,
        #sidebar-menu li,
        #sidebar-menu a {
            border: 0;
            font-weight: normal;
            line-height: 1;
            list-style: none;
            margin: 0;
            padding: 0;
            position: relative;
            text-decoration: none;
        }

        #sidebar-menu>ul>li a {
            color: #fff;
            font-size: 20px;
            display: block;
            padding: 14px 0px;
            margin: 0px 0px 0px 8px;
            border-top: 1px solid rgba(0, 0, 0, 0.1);
            border-bottom: 1px solid rgba(255, 255, 255, 0.05);
            width: 28px;
            cursor: pointer;
        }
        
      s

        #sidebar-menu .fas {
            padding-left: 6px;
        }

        /* 사이드 메뉴 */
        input[type="search"] {
            width: 180px;
            margin: 0 auto;
            margin-left: 9px;
            border: 2px solid #797979;
            font-size: 14px;
            margin-top: 10px;
            padding: 4px 0 4px 14px;
            border-radius: 50px;
        }

        .left_sub_menu {
            width: 200px;
            z-index: 10;
            background: white;
            border-right: 1px solid rgba(0, 0, 0, 0.07);
            bottom: 50px;
            height: 500px;
            margin-bottom: -70px;
            margin-top: 0px;
            padding-bottom: 0px;
            box-shadow: 0 0px 24px 0 rgb(0 0 0 / 6%), 0 1px 0px 0 rgb(0 0 0 / 2%);
            color: black;
        }

        .sub_menu {
            margin-top: 50px;
        }

        .left_sub_menu>.sub_menu li.large:hover {
            color: white;
            background-color: #6363FF;  
            /* 우리 색깔 */
        }

        .left_sub_menu>.sub_menu li {
            color: #333;
            font-size: 17px;
            font-weight: 600;
            padding: 20px 0px 8px 14px;
            border-bottom: 1px solid #e1e1e1;
        }
        
         .left_sub_menu>.sub_menu li> a:hover {
            color: #6363FF;
            background-color:white;
            /* font-size: 17px;
            font-weight: 600;
            padding: 20px 0px 8px 14px; */
            border-bottom: 1px solid #e1e1e1;
        }
        
        
         
        

        .sub_menu>h2 {
            padding-bottom: 4px;
            border-bottom: 3px solid #797979;
            margin-top: 30px;
            font-size: 21px;
            font-weight: 600;
            color: #333;
            margin-left: 10px;
            margin-right: 10px;
            font-family: 'NotoKrB';
            line-height: 35px;
        }

        .sub_menu .fas {
            color: #ff5858;
            font-size: 20px;
            line-height: 20px;
            float: right;
            margin-right: 20px;
        }

        .sub_menu>.big_menu>.small_menu li {
            color: #333;
            font-size: 14px;
            font-weight: 600;
            border-bottom: 0px solid #e1e1e1;
            margin-left: 14px;
            padding-top: 8px;
        }
        
        .sub_menu>.big_menu>.small_menu li:hover {
            color: #333; 
            
            font-size: 14px;
            font-weight: 600;
            border-bottom: 0px solid #e1e1e1;
            margin-left: 14px;
            padding-top: 8px;
        }
        
        
        
        

        .big_menu {
            cursor: pointer;
        }

        ul {
            padding-inline-start: 0px;
        }

        a {
            color: #797979;
            text-decoration: none;
            background-color: transparent;
        }
        
        
        

        ul {
            list-style: none;
        }

        ol,
        ul {
            margin-top: 0;
            margin-bottom: 10px;
        }

        .has_sub {
            width: 100%;
        }

        /* .overlay {
            position: fixed;
            width: 100%;
            height: 100%;
            background: rgba(0, 0, 0, 0.7);
        } */

        .hide_sidemenu {
            display: none;
        }

</style>

</head>
<body>

<!-- 왼쪽 사이드 메뉴 스크립트 -->
<script>
    $(function () {
    	/* 처음부터 닫혀있는 채 햄버거버튼만 보이게하는 기능 - 필요없음 */
       /*  $(".left_sub_menu").hide(); */
        $(".has_sub").click(function () {
            $(".left_sub_menu").fadeToggle(300);
        });
        // 왼쪽메뉴 드롭다운
        $(".sub_menu ul.small_menu").hide();
        $(".sub_menu ul.big_menu").click(function () {
            $("ul", this).slideToggle(300);
        });
        // 외부 클릭 시 좌측 사이드 메뉴 숨기기- x
       /*  $('.overlay').on('click', function () {
            $('.left_sub_menu').fadeOut();
            $('.hide_sidemenu').fadeIn();
        }); */
    });
    
   /*  $(".sub_menu.big_menu.small_menu.li.a").click(
    		  function () {
    		    $(".sub_menu.big_menu.small_menu.li").css("color", "#6363FF");
    		    $(".sub_menu.big_menu.small_menu.li").css("background-color", "white");
    		    
    		  },  */
    		 


</script>
 
    <div id="wrapper">
        <div class="topbar">
            <!-- 왼쪽 메뉴 -->
<!--             <div class="left side-menu">
                <div class="sidebar-inner">
                    <div id="sidebar-menu">
                        <ul>
                            <li class="has_sub"><a href="javascript:void(0);" class="waves-effect">
                                <i class="fas fa-bars"></i>
                            </a></li>
                        </ul>
                    </div>
                </div>
            </div> -->
            <!-- 왼쪽 서브 메뉴 -->
            <div class="left_sub_menu">
                <div class="sub_menu">
                    
                   
                    <ul class="big_menu">
                        <li class="large">마이페이지 <i class="arrow fas fa-angle-right"></i></li>
                        <ul class="small_menu">
                            <li><a href="#">개인정보 수정</a></li>
                            
                            <li><a href="">회원 탈퇴</a></li>
                        </ul>
                    </ul>
                    
                    <ul class="big_menu">
                        <li class="large">멘토 <i class="arrow fas fa-angle-right"></i></li>
                        <ul class="small_menu">
                            <li><a href="<%=request.getContextPath() %>/myPage.my">나의 클래스관리</a></li>
                            
                            	
						  <% Member m = (Member)request.getSession().getAttribute("loginUser"); 
						  if((m.getMtGrade())== 1) {   // 현직자 상태%>
							<!--  <li><a href="#">질문답변</a></li>	 -->		
										
			
								<% }else { // 강의자상태  %>
                           
                            <li><a href="<%=request.getContextPath() %>/mtProEdit.my">나의 프로필 관리</a></li>
                            <li><a href="#">질문답변</a></li>
                            <%} %>
                            <!-- <li><a href="">소메뉴1-3</a></li>
                            <li><a href="#">소메뉴1-4</a></li> -->
                        </ul>
                    </ul>
                    
                    <ul class="big_menu">
                        <li class="large">커뮤니티 <i class="arrow fas fa-angle-right"></i></li>
                        <ul class="small_menu">
                            <li><a href="#">내 게시글</a></li>
                            <li><a href="#">내 댓글</a></li>
                        </ul>
                    </ul>
                    
                    
                   <!--  <ul class="big_menu">
                        <li>MYPAGE</li>
                    </ul> -->
                </div>
            </div>
            <!-- <div class="overlay"></div> -->
        </div>
       
</div>
</body>
</html>