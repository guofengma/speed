if ((getQueryString("request_locale") || "") == "en_US") {
	  $(".language").find(".language-checked").html("English");
}

function getQueryString (key) {
	// 去掉字符串首字母?号
	var search = location.search.slice(1);
	
	// 使用&符号得到每一个key=val
	var searchArr = search.split('&');
	var tempArr = null;
	var searchObj = {};
	
	// 遍历数组中的每一个key=val字符串，使用=号劈开，
	// 然后以key为名，val为值添加到searchObj对象中。
	for( var i =0, len = searchArr.length; i < len; i++) {
	    tempArr = searchArr[i].split('=');
	    searchObj[ tempArr[0] ] = tempArr[1];
	}
	
	// 有参数返回指定值，没有参数返回全部值
	return arguments.length? searchObj[key]: searchObj;
	//return searchObj;
}

function login(){
		$(".main").show();	
		var index = layer.load(0, {shade: false}); //0代表加载的风格，支持0-2
		$("#loginForm").ajaxSubmit(function(result) {
			console.log(result.status);			
			if(result.status == 2) {
				$(".main").hide();	
				layer.close(index); 
				layer.open({
					title: '登录失败',
					content: result.message[0].msg
				});
	
			}
			else if (result.status == 1){
				$(".main").hide();	
				layer.close(index); 
				layer.open({
					title: '提示',
					content: '登录成功'
				});

				window.location.href ="/speedback/home.do";				
			}
		});
	}

$(document).ready(function() {
	
	$("#rand").keyup(function(event){  
         if(event.keyCode ==13){  
           login(); 
         }  
       });
	 
	$("#submit").on("click",function(){
		login();
		return false;
	});
});