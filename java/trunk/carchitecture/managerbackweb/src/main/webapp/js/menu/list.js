function search(){
	$("#submit-form").submit();
}
var del = function(requesturl, id){
	/*bootbox.confirm("你确定删除吗?", function (result) {
        if (result) {
        	var url = "del.do";
    		var sendData = {
    				"id": id
    			};
    			$.post(url,sendData, function(backData) {
    				if(backData.status == 1){
    					$("#submit-form").submit();
    				} else{
    					warningAlert(backData.message[0].msg);
    				}
    			});
        }
    });*/
	var shifou=confirm("如果该菜单包含子菜单,会一并删除,你确定继续删除吗?");
	if(shifou==true){
		var url = "del.do";
		var sendData = {
				"id": id
			};
			$.post(url,sendData, function(backData) {
				if(backData.status == 1){
					$("#submit-form").submit();					
				} else{
					warningAlert(backData.message[0].msg);
				}
			});
	}
}

var edit = function(url, id){
	 window.location.href = "edit.do?id="+id;
}

var down = function(url, id){
	 window.location.href = "down.do?id="+id;
}

var share = function(id){
	//获取当前网址，如： http://localhost:8083/uimcardprj/share/meun.jsp  
    var curWwwPath = window.document.location.href;  
    //获取主机地址之后的目录，如： uimcardprj/share/meun.jsp  
    var pathName = window.document.location.pathname;  
   
    var pos = curWwwPath.indexOf(pathName);  
    //获取主机地址，如： http://localhost:8083  
    var localhostPaht = curWwwPath.substring(0,pos);  
    //获取带"/"的项目名，如：/uimcardprj  
    var projectName= pathName.substring(0,pathName.substr(1).indexOf('/')+1);
    var url = localhostPaht + projectName +"/file/down.do?id="+id;
	
    $("#url").html(url);
    $("#mymodal").modal("toggle");
}