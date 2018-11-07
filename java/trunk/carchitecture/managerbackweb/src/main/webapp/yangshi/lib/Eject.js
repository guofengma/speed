window.onload = function(){
	
	$("#layui-table").children("tbody").children("tr").children("td").toggle(
		function(){
			$(this).parent().addClass("selected")
		},
		function(){
			$(this).parent().removeClass("selected")
		}
	)
	
	$("#del").click(function(){
		if(confirm("确定删除信息？")){
			var del = document.getElementsByClassName("selected");
			for(var i=del.length-1;i>=0;i--){
				del[i].parentNode.removeChild(del[i]);
			}
		}else{
			return false
		}
	})
	
	$("#layui-table").children("tbody").children("tr").children("td").children("span").toggle(
		function(){
			var x = $(this).offset().left;var y = $(this).offset().top + 30;
			$('.fix').css({"top":y + "px","left":x + "px"})
		},
		function(){
			$('.fix').css({"top":-165,"left":0})
		}
	)


	

	
	//用户信息弹出
	$('#tit').click(function(){$(".usertit").removeClass("none");$("#usertit").removeClass("none")});
	//用户信息消失
	$(".userTitNone").click(function(){$(".usertit").addClass("none");$("#usertit").addClass("none")});
	
	//权限弹出	
	$('#Pow').click(function(){$(".usertit").removeClass("none");$("#userPow").removeClass("none")});
	//权限消失
	$(".userPowNone").click(function(){$(".usertit").addClass("none");$("#userPow").addClass("none")});	
	
	//修改密码弹出
	$('#Pass').click(function(){$(".usertit").removeClass("none");$("#userPass").removeClass("none")});
	//修改密码消失
	$(".userPassNone").click(function(){$(".usertit").addClass("none");$("#userPass").addClass("none")});	
	
	
	
	
	
	
	
	


}