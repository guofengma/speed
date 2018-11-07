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
		var name=$("input[name='name']").val();
		var url=$("input[name='url']").val();
		var parId1=$("input[name='parId1']").attr("data-id");
		var parId2=$("input[name='parId2']").attr("data-id");
		if(typeof(parId1)=="undefined"){
			alert("父级菜单未选择!");
			return false;
		}
		/*//父级菜单选中时,而子级菜单未选
		if(typeof(parId1)!="undefined"&&parId1!=0&&typeof(parId2)=="undefined"){
			alert("子级菜单未选择!");
			return false;
		}*/
		if( $(".layui-form-item1").css("display")!='none'&&typeof(parId2)=="undefined" ){
			alert("子级菜单未选择!");
			return false;
		} 
		if(!name){
			alert("名称不能为空!");
			return false;
		}
		if(typeof(parId2)!="undefined"&&parId2!=0&&!url){
			alert("路径不能为空!");
			return false;
		}
		alert(name+"-"+url+"-"+parId1+"-"+parId2);
		var parentId=0;
		//如果子节点被选中有效值，选取子节点的值
		if(typeof(parId2)!="undefined"&&parId2!=0){
			parentId=parId2;
		}else{
			parentId=parId1;
		}			
			//后台代码
		   	$.ajax({
            //几个参数需要注意一下
                type: "POST",//方法类型
                url: "saveDo.do" ,//url
               data:{
            	   id:null,
            	   name:name,
            	   url:url,
            	   parentId:parentId
               },
                success: function (result) {                      
                	console.log(result);
                    if (result.status==1) {
                        alert("SUCCESS");
                        //前端源码
                        $(".form").addClass("none");
                		$(".select").removeClass("none");
                		location.reload(); 
                    }else{
                    	alert(result.message[0].msg);                    	
                    }
                    ;
                },                
                 error : function(result) {
                    alert("异常！");
                }            
            });
		return false;
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
		var lis = $("#menuFirm  .U1").children();
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
	$("#menuBut1").click(function(){
		$("#menu1").removeClass("none")	
	})
	//选项
	$("#menu1").children("ul").children("li").click(			
		function(){$(this).addClass("white");$(this).siblings().removeClass("white");},
	)
	//按钮
	$("#menuCel1").click(function(){
		$("#menu1").addClass("none")
	})
	//确认
	$("#menuFirm1").click(function(){
		var lis = $("#menu1 .U2").children();
		for(var i = lis.length-1;i>=0;i--){
			if(lis[i].className == "white"){
				$("#menuCom1").val(lis[i].innerText);
				$("#menuCom1").attr("data-id",$(lis[i]).attr("data-id"));
				console.log($(lis[i]).attr("data-id"))
				$("#menu1").addClass("none");
								
				return false;
			}
		}
		alert("请选择菜单");
	})	
	//选项
	$("#menu").children("ul").children("li").click(			
		function(){$(this).addClass("white");$(this).siblings().removeClass("white");},
	)	
	//选项
	$("#menu1").on('click','li',function(){
		$(this).addClass("white");$(this).siblings().removeClass("white");
	})
	//按钮
	$("#menuCel").click(function(){
		$("#menu").addClass("none")
	})
	//确认
	$("#menuFirm").click(function(){		
		var lis = $("#menu .U2").children();
//		console.log(lis.length)
		for(var i = lis.length-1;i>=0;i--){
			if(lis[i].className == "white"){
				$("#menuCom").val(lis[i].innerText);
				$("#menuCom").attr("data-id",$(lis[i]).attr("data-id"));
				console.log($(lis[i]).attr("data-id"))
				$("#menu").addClass("none");
								
		    		$.ajax({
			            //几个参数需要注意一下
			            type: "get",//方法类型
			            dataType: "json",//预期服务器返回的数据类型
			            data:{
			            	id:$(lis[i]).attr("data-id")
			            },
			            url: 'getNodes.do',
			            success: function (result) {			            	
			            	/*if($(lis[i]).attr("data-id") == 0){
			            		alert("腹肌")
			            	}*/
			            	if(result.message[0].code==100001){
			            		var html = '<li data-id="0">无父节点--</li>';
				                for ( var i= 0 ; i < result.data.length ;i++) {
									html += '<li data-id="'+result.data[i].id +'">'+ result.data[i].name +'</li>'
								}
								$("#menu1 .U2").html(html);
								$(".layui-form-item1").show()		            		
			            	}else if(result.message[0].code==100010){
			            		$(".layui-form-item1").hide()
			            	}else if(result.message[0].code==100009){
			            		$(".layui-form-item1").hide()
			            	}
			            	
			            	/*if(result.data.length == 0 ){
			            		$(".layui-form-item1").hide()
			            	}
			            	else 
			            	if($(lis[i]).attr("data-id") == 0){
			            		$(".layui-form-item1").hide()
			            	}
			            	else if($(lis[i]).attr("data-id") != 0){

				            	var html = '<li data-id="0">无父节点--</li>';
				                for ( var i= 0 ; i < result.data.length ;i++) {
									html += '<li data-id="'+result.data[i].id +'">'+ result.data[i].name +'</li>'
								}
								$("#menu1 .U2").html(html);
								$(".layui-form-item1").show()
			            	}*/
			            },
			            error : function() {
			                alert("异常！");
			            }
			            
			        });	  
				
				return false;
			}
		}
		alert("请选择菜单");
	})		
}
