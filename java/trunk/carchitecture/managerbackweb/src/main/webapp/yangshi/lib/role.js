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
	
	$(window).click(function(){console.log(123)})
	
	
}
