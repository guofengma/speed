<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%-- <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="cl"%>
<%@ taglib uri="http://java.sun.com/jstl/core_rt" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<%@include file="../commons/messageModals.jsp"%> --%>
<%@include file="../commons/commons.jsp"%>
<!DOCTYPE html>
<!--
BeyondAdmin - Responsive Admin Dashboard Template build with Twitter Bootstrap 3.2.0
Version: 1.0.0
Purchase: http://wrapbootstrap.com
-->
<html xmlns="http://www.w3.org/1999/xhtml">
<!-- Head -->
<head>
    <meta charset="utf-8" />
    <title>首页</title>

    <meta name="description" content="Dashboard" />
    <meta name="viewport" content="width=device-width, initial-scale=1.0" />
    <meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
    
    <!--Basic Styles-->
	<link href="static/assets/css/bootstrap.min.css" rel="stylesheet" />
	<link id="bootstrap-rtl-link" href="" rel="stylesheet" />
	<link href="static/assets/css/font-awesome.min.css" rel="stylesheet" />
	<link href="static/assets/css/weather-icons.min.css" rel="stylesheet" />
	
	<!--Fonts-->
	<link
		href="https://fonts.googleapis.com/css?family=Open+Sans:300italic,400italic,600italic,700italic,400,600,700,300"
		rel="stylesheet" type="text/css">
	
	<!--Beyond styles-->
	<link href="static/assets/css/beyond.min.css" rel="stylesheet"
		type="text/css" />
	<link href="static/assets/css/demo.min.css" rel="stylesheet" />
	<link href="static/assets/css/typicons.min.css" rel="stylesheet" />
	<link href="static/assets/css/animate.min.css" rel="stylesheet" />
	<link id="skin-link" href="" rel="stylesheet" type="text/css" />
	
	<style type="text/css">
	.page-sidebar .sidebar-header-wrapper .searchinput{
		width: 180px;
	}
	.page-sidebar .sidebar-header-wrapper .search{
		position: absolute;
	    top: 0;
	    right: 0;
	    width: 40px;
	    height: 40px;
	    z-index: 100;
	    font-size: 28px;
	    text-align: center;
	    cursor: pointer;
	    text-decoration: none;
	}	
	</style>
	<!--Skin Script: Place this script in head to load scripts for skins and rtl support-->
	<script src="static/assets/js/skins.min.js"></script>
    
    
     <!--Google Analytics::Demo Only-->
    <!--Basic Scripts-->
	<script type="text/javascript">
		function pageTo(iClass,title,url){
			if(url!=null && url!=''){
				$("#imgI").addClass(iClass)
				$("#titleH1").html(title);
				$("#iframepage").attr("src",url);
			}else{
				warningAlert("功能完善中...");
			}
    	}
    
    	//解决当窗口改变大小的时候执行js事件，以让iframe自适就高度
    	function changeFrameHeight(){
		    var ifm = document.getElementById("iframepage"); 
		    ifm.height=document.documentElement.clientHeight;
		    var pageHeaderDiv = $("#pageHeaderDiv").css("width").replace("px","");
		    ifm.width= parseInt(pageHeaderDiv);
		}
		//window.onresize的作用就是当窗口大小改变的时候会触发这个事件。
		window.onresize=function(){  
		     changeFrameHeight();  
		} 
	</script>
</head>
<!-- /Head -->
<!-- Body -->
<body>
    <!-- Loading Container -->
    <div class="loading-container">
        <div class="loading-progress">
            <div class="rotator">
                <div class="rotator">
                    <div class="rotator colored">
                        <div class="rotator">
                            <div class="rotator colored">
                                <div class="rotator colored"></div>
                                <div class="rotator"></div>
                            </div>
                            <div class="rotator colored"></div>
                        </div>
                        <div class="rotator"></div>
                    </div>
                    <div class="rotator"></div>
                </div>
                <div class="rotator"></div>
            </div>
            <div class="rotator"></div>
        </div>
    </div>
    <!--  /Loading Container -->
    <!-- Navbar -->
    <div class="navbar">
        <div class="navbar-inner">
            <div class="navbar-container">
                <!-- Navbar Barnd -->
                <div class="navbar-header pull-left">
                    <a href="#" class="navbar-brand">
                        <small>
                            <img src="static/assets/img/jishuyunSmall.png" alt="" />
                        </small>
                    </a>
                </div>
                <!-- /Navbar Barnd -->

                <!-- Sidebar Collapse -->
                <div class="sidebar-collapse" id="sidebar-collapse">
                    <i class="collapse-icon fa fa-bars"></i>
                </div>
                <!-- /Sidebar Collapse -->
                <!-- Account Area and Settings --->
                <div class="navbar-header pull-right">
                    <div class="navbar-account">
                        <ul class="account-area">
                            <li>
                                <a class="login-area dropdown-toggle" data-toggle="dropdown">
                                    <div class="avatar" title="View your public profile">
                                        <img src="static/assets/img/avatars/adam-jansen.jpg">
                                    </div>
                                    <section>
                                        <h2><span class="profile"><span>您好，${USER.userName }</span></span></h2>
                                    </section>
                                </a>
                                <!--Login Area Dropdown-->
                                <ul class="pull-right dropdown-menu dropdown-arrow dropdown-login-area">
                                    <li class="username"><a>${USER.userName }</a></li>
                                    <!--Avatar Area-->
                                    <li>
                                        <div class="avatar-area">
                                            <img src="static/assets/img/avatars/adam-jansen.jpg" class="avatar">
                                            <span class="caption">${USER.userName }</span>
                                        </div>
                                    </li>
                                     <li>
                                    	 <a href="${ctx }/logout.do">退出</a>
                                    </li>
                                </ul>
                            </li>
                        </ul>
                    </div>
                </div>
                <!-- /Account Area and Settings -->
            </div>
        </div>
    </div>
    <!-- /Navbar -->
    <!-- Main Container -->
    <div class="main-container container-fluid">
        <!-- Page Container -->
        <div class="page-container">
            <!-- Page Sidebar -->
            <div class="page-sidebar" id="sidebar" style="left: 0px">
			    <!-- Page Sidebar Header-->
			    <div class="sidebar-header-wrapper">
			        <input type="text" class="searchinput" id="searchinput"/>
			        <a class="search" href="javascript:pageTo('menu-icon fa fa-pencil-square-o','菜单管理',' menu/add.do')">+</a>
			        <i class="searchicon fa fa-search" onclick="anniu()"></i>
			        <div class="searchhelper">Search Reports, Charts, Emails or Notifications</div>
			    </div>
			    <ul class="nav sidebar-menu">
			        <li>
			            <a href="javascript:pageTo('menu-icon glyphicon glyphicon-home','首页','')"> <i class="menu-icon glyphicon glyphicon-home"></i> <span class="menu-text"> 首页 </span> </a>
			        </li>
			        <c:forEach items="${menus}" var="menu">
				        <li>
				            <a href="javascript:;" class="menu-dropdown"> <i class="menu-icon fa fa-pencil-square-o"></i> <span class="menu-text">${menu.name }</span> <i class="menu-expand"></i> </a>
				            <ul class="submenu">
				            	<c:forEach items="${menu.list}" var="subMenu">
					                <li>
					                	<c:choose>
					                	<c:when  test="${subMenu.list!=null&&fn:length(subMenu.list) > 0}">
					                		<a class="menu-dropdown" href="javascript:pageTo('menu-icon fa fa-pencil-square-o','${subMenu.name }','${subMenu.url }')"> <span class="menu-text">${subMenu.name }</span><i class="menu-expand"></i> </a>
					                		<ul class="submenu">
								            	<c:forEach items="${subMenu.list}" var="subMenu2">
									                <li>
									                    <a href="javascript:pageTo('menu-icon fa fa-pencil-square-o','${subMenu2.name }','${subMenu2.url }')"> <span class="menu-text">${subMenu2.name }</span> </a>
					                
					                		
					                
								               		 </li>
							                	</c:forEach>
							           		 </ul>
					                	</c:when>
					                	 <c:otherwise> 
					                	 		<a href="javascript:pageTo('menu-icon fa fa-pencil-square-o','${subMenu.name }','${subMenu.url }')"> <span class="menu-text">${subMenu.name }</span> </a>
					                	 </c:otherwise>
					                	</c:choose>
					                    <%-- <a href="javascript:pageTo('menu-icon fa fa-pencil-square-o','${subMenu.name }','${subMenu.url }')"> <span class="menu-text">${subMenu.name }</span> </a> --%>
					                </li>
				                </c:forEach>
				            </ul>
				        </li>
			        </c:forEach>
			        <!-- 原来菜单
			        
			        <li>
			            <a href="javascript:pageTo('menu-icon fa fa-picture-o','图片管理','banner/list.do')">
			                <i class="menu-icon fa fa-picture-o"></i> <span class="menu-text">
										图片管理 </span> </a>
			        </li>
			        <li>
			            <a href="javascript:pageTo('menu-icon fa fa-tasks','单页管理','single/list.do')"> <i class="menu-icon fa fa-tasks"></i> <span class="menu-text">
										单页管理 </span> </a>
			        </li>
			        <li>
			            <a href="javascript:;" class="menu-dropdown"> <i class="menu-icon fa fa-pencil-square-o"></i> <span class="menu-text"> 文章管理 </span> <i class="menu-expand"></i> </a>
			            <ul class="submenu">
			                <li>
			                    <a href="javascript:pageTo('menu-icon fa fa-pencil-square-o','文章管理&nbsp;&nbsp;/&nbsp;&nbsp;文章列表','')"> <span class="menu-text">文章列表</span> </a>
			                </li>
			                <li>
			                    <a href="javascript:pageTo('menu-icon fa fa-pencil-square-o','文章管理&nbsp;&nbsp;/&nbsp;&nbsp;文章分类','')">
			                        <span class="menu-text">文章分类</span> </a>
			                </li>
			            </ul>
			        </li>
			        <li>
			            <a href="javascript:;" class="menu-dropdown"> <i class="menu-icon glyphicon glyphicon-tasks"></i> <span class="menu-text">时时彩</span> <i class="menu-expand"></i> </a>
			            <ul class="submenu">
			                <li>
			                    <a href="javascript:pageTo('menu-icon glyphicon glyphicon-tasks','时时彩&nbsp;&nbsp;/&nbsp;&nbsp;重庆时时彩','lottery/list.do?code=cqssc')"> <span class="menu-text">重庆时时彩</span> </a>
			                </li>
			                <li>
			                    <a href="javascript:pageTo('menu-icon glyphicon glyphicon-tasks','时时彩&nbsp;&nbsp;/&nbsp;&nbsp;天津时时彩','lottery/list.do?code=tjssc')"> <span class="menu-text">天津时时彩</span> </a>
			                </li>
			                <li>
			                    <a href="javascript:pageTo('menu-icon glyphicon glyphicon-tasks','时时彩&nbsp;&nbsp;/&nbsp;&nbsp;新疆时时彩','lottery/list.do?code=xjssc')"> <span class="menu-text">新疆时时彩</span> </a>
			                </li>
			            </ul>
			        </li>
			        <li>
			            <a href="#" class="menu-dropdown"> <i class="menu-icon fa fa-th"></i> <span class="menu-text">
										官方时时彩 </span> <i class="menu-expand"></i> </a>
			            <ul class="submenu">
			                <li>
			                    <a href="javascript:pageTo('menu-icon fa fa-th','官方时时彩&nbsp;&nbsp;/&nbsp;&nbsp;分分彩','')"> <span class="menu-text">分分彩</span>
			                    </a>
			                </li>
			                <li>
			                    <a href="javascript:pageTo('menu-icon fa fa-th','官方时时彩&nbsp;&nbsp;/&nbsp;&nbsp;三分彩','')"> <span class="menu-text">三分彩</span>
			                    </a>
			                </li>
			                <li>
			                    <a href="javascript:pageTo('menu-icon fa fa-th','官方时时彩&nbsp;&nbsp;/&nbsp;&nbsp;北京5分彩','')"> <span class="menu-text">北京5分彩</span>
			                    </a>
			                </li>
			                <li>
			                    <a href="javascript:pageTo('menu-icon fa fa-th','官方时时彩&nbsp;&nbsp;/&nbsp;&nbsp;韩国1.5分彩','lottery/list.do?code=hgklb')"> <span class="menu-text">韩国1.5分彩</span>
			                    </a>
			                </li>
			                <li>
			                    <a href="javascript:pageTo('menu-icon fa fa-th','官方时时彩&nbsp;&nbsp;/&nbsp;&nbsp;台湾5分彩','lottery/list.do?code=twbingo')"> <span class="menu-text">台湾5分彩</span>
			                    </a>
			                </li>
			                <li>
			                    <a href="javascript:pageTo('menu-icon fa fa-th','官方时时彩&nbsp;&nbsp;/&nbsp;&nbsp;加拿大3.5分彩','lottery/list.do?code=jndbsklb')"> <span class="menu-text">加拿大3.5分彩</span>
			                    </a>
			                </li>
			                <li>
			                    <a href="javascript:pageTo('menu-icon fa fa-th','官方时时彩&nbsp;&nbsp;/&nbsp;&nbsp;新德里1.5分彩','lottery/list.do?code=xdlklb')"> <span class="menu-text">新德里1.5分彩</span>
			                    </a>
			                </li>
			                <li>
			                    <a href="javascript:pageTo('menu-icon fa fa-th','官方时时彩&nbsp;&nbsp;/&nbsp;&nbsp;新加坡2分彩','lottery/list.do?code=sgkeno')"> <span class="menu-text">新加坡2分彩</span>
			                    </a>
			                </li>
			            </ul>
			        </li>
			        <li>
			            <a href="#" class="menu-dropdown"> <i class="menu-icon fa fa-table"></i> <span class="menu-text">
										官方3D </span> <i class="menu-expand"></i> </a>
			            <ul class="submenu">
			                <li>
			                    <a href="javascript:pageTo('menu-icon fa fa-table','官方3D&nbsp;&nbsp;/&nbsp;&nbsp;北京5分3D','')"> <span class="menu-text">北京5分3D</span>
			                    </a>
			                </li>
			                <li>
			                    <a href="javascript:pageTo('menu-icon fa fa-table','官方3D&nbsp;&nbsp;/&nbsp;&nbsp;韩国1.5分3D','')"> <span class="menu-text">韩国1.5分3D</span>
			                    </a>
			                </li>
			            </ul>
			        </li>
			        <li>
			            <a href="javascript:;" class="menu-dropdown"> <i class="menu-icon fa fa-bar-chart-o"></i> <span class="menu-text">
										快3 </span> <i class="menu-expand"></i> </a>
			            <ul class="submenu">
			                <li>
			                    <a href="javascript:pageTo('menu-icon fa fa-bar-chart-o','快3&nbsp;&nbsp;/&nbsp;&nbsp;江苏快3','lottery/list.do?code=jsks')"> <span class="menu-text">江苏快3</span> </a>
			                </li>
			                <li>
			                    <a href="javascript:pageTo('menu-icon fa fa-bar-chart-o','快3&nbsp;&nbsp;/&nbsp;&nbsp;安徽快3','lottery/list.do?code=ahks')"> <span class="menu-text">安徽快3</span> </a>
			                </li>
			                <li>
			                    <a href="javascript:pageTo('menu-icon fa fa-bar-chart-o','快3&nbsp;&nbsp;/&nbsp;&nbsp;吉林快3','lottery/list.do?code=jlks')"> <span class="menu-text">吉林快3</span> </a>
			                </li>
			                <li>
			                    <a href="javascript:pageTo('menu-icon fa fa-bar-chart-o','快3&nbsp;&nbsp;/&nbsp;&nbsp;湖北快3','lottery/list.do?code=hbks')"> <span class="menu-text">湖北快3</span> </a>
			                </li>
			            </ul>
			        </li>
			        <li>
			            <a href="#" class="menu-dropdown"> <i class="menu-icon fa fa-align-right"></i> <span class="menu-text">
										11选5 </span> <i class="menu-expand"></i> </a>
			            <ul class="submenu">
			                <li>
			                    <a href="javascript:pageTo('menu-icon fa fa-align-right','11选5&nbsp;&nbsp;/&nbsp;&nbsp;山东11选5','lottery/list.do?code=sdsyxw')"> <span class="menu-text">山东11选5</span> </a>
			                </li>
			                <li>
			                    <a href="javascript:pageTo('menu-icon fa fa-align-right','11选5&nbsp;&nbsp;/&nbsp;&nbsp;广东11选5','lottery/list.do?code=gdsyxw')"> <span class="menu-text">广东11选5</span> </a>
			                </li>
			                <li>
			                    <a href="javascript:pageTo('menu-icon fa fa-align-right','11选5&nbsp;&nbsp;/&nbsp;&nbsp;安徽111选5','lottery/list.do?code=ahsyxw')"> <span class="menu-text"> 安徽11选5</span> </a>
			                </li>
			                <li>
			                    <a href="javascript:pageTo('menu-icon fa fa-align-right','11选5&nbsp;&nbsp;/&nbsp;&nbsp;江西11选5','lottery/list.do?code=jxsyxw')"> <span class="menu-text">江西11选5</span> </a>
			                </li>
			                <li>
			                    <a href="javascript:pageTo('menu-icon fa fa-align-right','11选5&nbsp;&nbsp;/&nbsp;&nbsp;上海11选5','lottery/list.do?code=shsyxw')"> <span class="menu-text">上海11选5</span> </a>
			                </li>
			            </ul>
			        </li>
			        <li>
			            <a href="#" class="menu-dropdown"> <i class="menu-icon glyphicon glyphicon-paperclip"></i> <span class="menu-text">其他彩种 </span> <i class="menu-expand"></i> </a>
			            <ul class="submenu">
			                <li>
			                    <a href="javascript:pageTo('menu-icon glyphicon glyphicon-paperclip','其他彩种&nbsp;&nbsp;/&nbsp;&nbsp;北京PK10','lottery/list.do?code=bjpks')"> <span class="menu-text">北京PK10</span> </a>
			                </li>
			                <li>
			                    <a href="javascript:pageTo('menu-icon glyphicon glyphicon-paperclip','其他彩种&nbsp;&nbsp;/&nbsp;&nbsp;幸运农场','lottery/list.do?code=xync')"> <span class="menu-text">幸运农场</span> </a>
			                </li>
			                <li>
			                    <a href="javascript:pageTo('menu-icon glyphicon glyphicon-paperclip','其他彩种&nbsp;&nbsp;/&nbsp;&nbsp;北京快乐8','lottery/list.do?code=bjklb')"> <span class="menu-text">北京快乐8</span> </a>
			                </li>
			                <li>
			                    <a href="javascript:pageTo('menu-icon glyphicon glyphicon-paperclip','其他彩种&nbsp;&nbsp;/&nbsp;&nbsp;福彩3D','lottery/list.do?code=fcsd')"> <span class="menu-text">福彩3D</span> </a>
			                </li>
			                <li>
			                    <a href="javascript:pageTo('menu-icon glyphicon glyphicon-paperclip','其他彩种&nbsp;&nbsp;/&nbsp;&nbsp;排列3','lottery/list.do?code=pls')"> <span class="menu-text">排列3</span> </a>
			                </li>
			                <li>
			                    <a href="javascript:pageTo('menu-icon glyphicon glyphicon-paperclip','其他彩种&nbsp;&nbsp;/&nbsp;&nbsp;上海时时乐','lottery/list.do?code=shssl')"> <span class="menu-text">上海时时乐</span> </a>
			                </li>
			            </ul>
			        </li>
			        <li>
			            <a href="#" class="menu-dropdown"> <i class="menu-icon fa fa-user"></i> <span class="menu-text">
										会员管理 </span> <i class="menu-expand"></i> </a>
			            <ul class="submenu">
			                <li>
			                    <a href="javascript:pageTo('menu-icon fa fa-user','会员管理&nbsp;&nbsp;/&nbsp;&nbsp;会员列表','')"> <span class="menu-text">会员列表</span>
			                    </a>
			                </li>
			            </ul>
			        </li>-->
			    </ul>
			    <!-- /Sidebar Menu -->
			</div>

            <!-- /Page Sidebar -->
            <!-- Page Content -->
            <div class="page-content">
                <!-- Page Breadcrumb -->
                <%-- 
                <div class="page-breadcrumbs">
                    <ul class="breadcrumb">
                        <li>
                            <i class="fa fa-home"></i>
                            <a href="#">Home</a>
                        </li>
                        <li class="active">Dashboard</li>
                    </ul>
                </div>
                --%>
                <!-- /Page Breadcrumb -->
                <!-- Page Header -->
                <div id="pageHeaderDiv" class="page-header position-relative">
                    <div class="header-title">
                    	<i id="imgI" class="menu-icon glyphicon glyphicon-home"></i>
                        <h1 id="titleH1">首页</h1>
                    </div>
                    <!--Header Buttons-->
                    <div class="header-buttons">
                        <a class="sidebar-toggler" href="#">
                            <i class="fa fa-arrows-h"></i>
                        </a>
                        <a class="refresh" id="refresh-toggler" href="">
                            <i class="glyphicon glyphicon-refresh"></i>
                        </a>
                        <a class="fullscreen" id="fullscreen-toggler" href="#">
                            <i class="glyphicon glyphicon-fullscreen"></i>
                        </a>
                    </div>
                    <!--Header Buttons End-->
                </div>
                <!-- /Page Header -->
                <!-- Page Body -->
                 <div class="page-body"  style="padding-left: 10px;padding-top: 10px;">
                    <div class="row">
	                    <div class="col-lg-12 col-sm-12 col-xs-12">
	                    	<iframe src="" id="iframepage" scrolling="no" onload="changeFrameHeight()" frameborder="0"></iframe>
	                    </div>
                    </div>
                 </div>
                <!-- /Page Body -->
            </div>
            <!-- /Page Content -->
        </div>
        <!-- /Page Container -->
        <!-- Main Container -->

    </div>

	<!--Beyond Scripts-->
	<script src="static/assets/js/beyond.min.js"></script>
	
	
	<!--Page Related Scripts-->
	<!--Sparkline Charts Needed Scripts-->
	<script src="static/assets/js/charts/sparkline/jquery.sparkline.js"></script>
	<script src="static/assets/js/charts/sparkline/sparkline-init.js"></script>
	
	<!--Easy Pie Charts Needed Scripts-->
	<script src="static/assets/js/charts/easypiechart/jquery.easypiechart.js"></script>
	<script src="static/assets/js/charts/easypiechart/easypiechart-init.js"></script>
	
	<!--Flot Charts Needed Scripts-->
	<script src="static/assets/js/charts/flot/jquery.flot.js"></script>
	<script src="static/assets/js/charts/flot/jquery.flot.resize.js"></script>
	<script src="static/assets/js/charts/flot/jquery.flot.pie.js"></script>
	<script src="static/assets/js/charts/flot/jquery.flot.tooltip.js"></script>
	<script src="static/assets/js/charts/flot/jquery.flot.orderBars.js"></script>
    <script>
        (function (i, s, o, g, r, a, m) {
            i['GoogleAnalyticsObject'] = r; i[r] = i[r] || function () {
                (i[r].q = i[r].q || []).push(arguments)
            }, i[r].l = 1 * new Date(); a = s.createElement(o),
            m = s.getElementsByTagName(o)[0]; a.async = 1; a.src = g; m.parentNode.insertBefore(a, m)
        })(window, document, 'script', 'http://www.google-analytics.com/analytics.js', 'ga');

        ga('create', 'UA-52103994-1', 'auto');
        ga('send', 'pageview');
		
		function anniu(){
			var name=$("#searchinput").val();								
			window.location.href = "home.do?name="+name;
		}
    </script>

</body>
<!--  /Body -->
</html>
