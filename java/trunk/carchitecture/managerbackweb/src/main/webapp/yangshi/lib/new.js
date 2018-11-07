window.onload = function(){
	$(".cli").toggle(
		function(){
			$(this).parent().children("ul").removeClass("none");
			$(this).removeClass("icon-arrow-fill-right").addClass("icon-jiantouxia");
		},
		function(){
			$(this).parent().children("ul").addClass("none");
			$(this).removeClass("icon-jiantouxia").addClass("icon-arrow-fill-right");
		}
	)
	
	$("#next").click(function(){
		$(".form").addClass("none");
		$(".select").removeClass("none");
	})
	
	$("#prev").click(function(){
		$(".select").addClass("none");
		$(".form").removeClass("none");
	})	
	
	//角色管理弹出
	$("#roleBut").click(function(){
		$("#role").removeClass("none")	
	})
	//选项
	$("#role").children("ul").children("li").click(
		function(){$(this).addClass("white");$(this).siblings().removeClass("white");},
	)
	//按钮
	$("#roleCel").click(function(){
		$("#role").addClass("none")
	})
	//确认
	$("#roleFirm").click(function(){
		var lis = $(".U1").children();
//		console.log(lis.length)
		for(var i = lis.length-1;i>=0;i--){
			if(lis[i].className == "white"){
				$("#roleCom").val(lis[i].innerText);
				$("#role").addClass("none");
				return false;
			}
		}
		alert("请选择单位");
	})	
	
	
	//菜单管理弹出
	$("#menuBut").click(function(){
		$("#menu").removeClass("none")	
	})
	//选项
	$("#menu").children("ul").children("li").click(
		function(){$(this).addClass("white");$(this).siblings().removeClass("white");},
	)
	//按钮
	$("#menuCel").click(function(){
		$("#menu").addClass("none")
	})
	//确认
	$("#menuFirm").click(function(){
		var lis = $(".U2").children();
//		console.log(lis.length)
		for(var i = lis.length-1;i>=0;i--){
			if(lis[i].className == "white"){
				$("#menuCom").val(lis[i].innerText);
				$("#menu").addClass("none");
				return false;
			}
		}
		alert("请选择菜单");
	})		
	
	//用户管理弹出
	$("#userBut").click(function(){
		$("#user").removeClass("none")	
	})
	//选项
	$("#user").children("ul").children("li").click(
		function(){$(this).addClass("white");$(this).siblings().removeClass("white");},
	)
	//按钮
	$("#userCel").click(function(){
		$("#user").addClass("none")
	})
	//确认
	$("#userFirm").click(function(){
		var lis = $(".U3").children();
//		console.log(lis.length)
		for(var i = lis.length-1;i>=0;i--){
			if(lis[i].className == "white"){
				$("#userCom").val(lis[i].innerText);
				$("#user").addClass("none");
				return false;
			}
		}
		alert("请选择菜单");
	})	
	
	
	//修改用户信息
	$("#modiBut").click(function(){
		$("#modi").removeClass("none")	
	})
	//选项
	$("#modi").children("ul").children("li").click(
		function(){$(this).addClass("white");$(this).siblings().removeClass("white");},
	)
	//按钮
	$("#modiCel").click(function(){
		$("#modi").addClass("none")
	})
	//确认
	$("#modiFirm").click(function(){
		var lis = $(".U4").children();
//		console.log(lis.length)
		for(var i = lis.length-1;i>=0;i--){
			if(lis[i].className == "white"){
				$("#modiCom").val(lis[i].innerText);
				$("#modi").addClass("none");
				return false;
			}
		}
		alert("请选择菜单");
	})		
}
