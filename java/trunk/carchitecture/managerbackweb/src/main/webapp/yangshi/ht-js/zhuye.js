//ajax获取各级菜单
var templatenav="";
	$.ajax({
            //几个参数需要注意一下
                type: "GET",//方法类型
                dataType: "json",//预期服务器返回的数据类型
                url: "menu/getGjMenus.do" ,//url
               // data:{id:$(this).attr("data-id")},
                success: function (result) {
                    console.log(result.data);//打印服务端返回的数据(调试用)
                  templatenav=result.data;
                   console.log(templatenav)                  
                   setnav();
                },             
            });
	$("#search::after").click(function(){
		alert(11111)
	})