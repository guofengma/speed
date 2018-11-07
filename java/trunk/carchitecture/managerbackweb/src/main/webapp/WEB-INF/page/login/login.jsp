<%@ page language="java" contentType="text/html; charset=utf-8" 
pageEncoding="utf-8"%>
<%@include file="../commons/commons.jsp"%>

<!DOCTYPE HTML>
<html>
<head>
<meta charset="utf-8">
<meta name="renderer" content="webkit|ie-comp|ie-stand">
<meta http-equiv="X-UA-Compatible" content="IE=edge,chrome=1">
<meta name="viewport"
	content="width=device-width,initial-scale=1,minimum-scale=1.0,maximum-scale=1.0,user-scalable=no" />
<meta http-equiv="Cache-Control" content="no-siteapp" />

<%-- <link rel="stylesheet" type="text/css" href="${ctx}/static/lib/layer/2.4/skin/layer.css" /> --%>
<link rel="stylesheet" type="text/css" href="${ctx}/hudi/static/lib/layui/css/layui.css" />
<link href="${ctx}/hudi/static/h-ui.admin/css/H-ui.login.css"
	rel="stylesheet" type="text/css" />
	
 <link href="${ctx}/hudi/static/h-ui/css/H-ui.min.css" rel="stylesheet"
	type="text/css" />
<link href="${ctx}/hudi/static/h-ui.admin/css/style.css" rel="stylesheet"
	type="text/css" />
<link href="${ctx}/hudi/static/lib/Hui-iconfont/1.0.8/iconfont.css"
	rel="stylesheet" type="text/css" />
<link rel="stylesheet" type="text/css" href="${ctx}/hudi/static/h-ui.admin/skin/default/skin.css" id="skin" />
<link rel="stylesheet" type="text/css" href="${ctx}/hudi/static/h-ui.admin/css/style.css" />
<%-- <link rel="stylesheet" type="text/css" href="${ctx}/hudi/static/lib/layer/2.4/skin/layer.css" /> --%>
<link rel="stylesheet" type="text/css" href="${ctx}/hudi/static/lib/layui/css/layui.css" />

<style>
.layui-laypage {float: right;margin-right: 20px};
</style>

<link rel="Bookmark" href="${ctx}/hudi/static/favicon.ico" >
<link rel="Shortcut Icon" href="${ctx}/hudi/static/favicon.ico" />
<link rel="stylesheet" type="text/css"
	href="${ctx}/hudi/static/h-ui.admin/css/H-ui.admin.css" />

	
<script type="text/javascript"
	src="${ctx}/hudi/static/lib/jquery/1.9.1/jquery.min.js"></script>
<script type="text/javascript" src="${ctx}/hudi/static/h-ui/js/H-ui.min.js"></script>
<script type="text/javascript" src="${ctx}/hudi/static/lib/laypage/1.2/laypage.js"></script>
<script type="text/javascript" src="${ctx}/hudi/static/lib/layer/2.4/layer.js"></script>
<script type="text/javascript" src="${ctx}/hudi/static/lib/layui/layui.js"></script>
<script type="text/javascript" src="${ctx}/hudi/static/h-ui.admin/js/H-ui.admin.js"></script>
<script type="text/javascript" src="${ctx}/hudi/static/lib/jquery.contextmenu/jquery.contextmenu.r2.js"></script>
<script type="text/javascript" src="${ctx}/hudi/static/lib/jquery.validation/1.14.0/jquery.validate.js"></script> 
<script type="text/javascript" src="${ctx}/hudi/static/lib/jquery.validation/1.14.0/validate-methods.js"></script> 
<script type="text/javascript" src="${ctx}/hudi/static/lib/jquery.validation/1.14.0/messages_zh.js"></script> 	
	
	
	
<!--[if lt IE 9]>
<script type="text/javascript" src="lib/html5shiv.js"></script>
<script type="text/javascript" src="lib/respond.min.js"></script>
<![endif]-->

<!--[if IE 6]>
<script type="text/javascript" src="lib/DD_belatedPNG_0.0.8a-min.js" ></script>
<script>DD_belatedPNG.fix('*');</script>
<![endif]-->
<title>后台登录 - 极速云后台管理系统</title>
<style>
.header{
background: #426374;
font-size: 35px;
color: white;
line-height: 60px;
font-family:KaiTi;
padding-left: 20px
}


    	.main{
           	width: 100%;
            height: 100%;
            padding-top: 100px;
			position:fixed;
			top:0;
			left:0;
			display: none;
			z-index: 9999;
        }
       /*  a{
            display: block;
            text-align: center;
            font-size: 20px;
            margin-top: 200px;
        } */
        .loading{
            z-index: 100;
            width: 80px;
            height: 80px;
            border-radius: 50%;
            margin: 0 auto;
            margin-top:270px;
            position: relative;
            border:5px solid #ff2323;
            -webkit-animation: turn 2s linear infinite;
        }
        .loading span{
            z-index: 100;
            display: inline-block;
            width: 30px;
            height: 30px;
            border-radius: 50%;
            background: #ff2323;
            position: absolute;
            left: 50%;
            margin-top: -15px;
            margin-left: -15px;
            -webkit-animation: changeBgColor 2s linear infinite;
        }
        @-webkit-keyframes changeBgColor{
            0%{
                background: #ff2323;
            }
            100%{
                background: #ff2323;
            }
        }
        @-webkit-keyframes turn{
            0%{
                -webkit-transform: rotate(0deg);
                border-color: #ff2323;
            }
            100%{
                -webkit-transform: rotate(360deg);
                border-color: #ff2323;
            }
        }
    

</style>
</head>
<body>	
	<div class="main">
    <div class="loading">
        <span></span>
    </div>
</div>	
	<input type="hidden" id="TenantId" name="TenantId" value="" />
	<div class="header">极速云后台管理系统</div>
	<div class="loginWraper">
		<div  class="loginBox">
			<form class="form form-horizontal" action="${ctx}/getLogin.do" method="post" id="loginForm">
				<div class="row cl">
					<label class="form-label col-xs-3"><i class="Hui-iconfont">&#xe60d;</i>
					</label>
					<div class="formControls col-xs-8">
						<input id="passport" name="passport" type="text" placeholder="账户"
							class="input-text size-L">
					</div>
				</div>
				<div class="row cl">
					<label class="form-label col-xs-3"><i class="Hui-iconfont">&#xe60e;</i>
					</label>
					<div class="formControls col-xs-8">
						<input id="passwd" name="passwd" type="password" placeholder="密码"
							class="input-text size-L">
					</div>
				</div>
				<div class="row cl">
					<div class="formControls col-xs-8 col-xs-offset-3">
						<input class="input-text size-L" type="text" placeholder="验证码" id="rand" name="rand"
							style="width:200px;margin-right: 10px"> <img src="${ctx}/static/yanzhengma.jsp" onClick="this.src='${ctx}/static/yanzhengma.jsp?abc='+encodeURI(Math.random())"  title="图片看不清？点击重新得到验证码" style="cursor:pointer;">
					</div>
				</div>
				
				<div class="row cl">
					<div class="formControls col-xs-8 col-xs-offset-3">
						<input name="submit" type="submit" class="btn btn-success radius size-L" id="submit"
							value="&nbsp;登&nbsp;&nbsp;&nbsp;&nbsp;录&nbsp;"> <input
							name="" type="reset" class="btn btn-default radius size-L"
							value="&nbsp;取&nbsp;&nbsp;&nbsp;&nbsp;消&nbsp;">
					</div>
				</div>
			</form>
		</div>
	</div>
	<div class="footer">Copyright  广州市少即多科技有限公司 </div>
	<script type="text/javascript" src="${ctx}/static/login.js"></script>
	<script type="text/javascript" src="${ctx}/static/lib/layer/2.4/layer.js"></script>
	<script type="text/javascript" src="${ctx}/static/lib/layui/layui.js"></script>	
</body>
</html>