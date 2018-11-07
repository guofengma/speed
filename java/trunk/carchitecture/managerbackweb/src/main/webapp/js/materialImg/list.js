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
    					//$("#submit-form").submit();       					
    					window.location.href = "list.do?typeId="+backData.data;
    				} else{
    					warningAlert(backData.message[0].msg);
    				}
    			});
        }
    });*/
	var shifou=confirm("你确定删除吗?");
	if(shifou==true){
		var url = "del.do";
		var sendData = {
				"id": id
			};
			$.post(url,sendData, function(backData) {
				if(backData.status == 1){
					//$("#submit-form").submit();       					
					window.location.href = "list.do?mId="+backData.data;
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
	//鑾峰彇褰撳墠缃戝潃锛屽锛�http://localhost:8083/uimcardprj/share/meun.jsp  
    var curWwwPath = window.document.location.href;  
    //鑾峰彇涓绘満鍦板潃涔嬪悗鐨勭洰褰曪紝濡傦細 uimcardprj/share/meun.jsp  
    var pathName = window.document.location.pathname;  
   
    var pos = curWwwPath.indexOf(pathName);  
    //鑾峰彇涓绘満鍦板潃锛屽锛�http://localhost:8083  
    var localhostPaht = curWwwPath.substring(0,pos);  
    //鑾峰彇甯�/"鐨勯」鐩悕锛屽锛�uimcardprj  
    var projectName= pathName.substring(0,pathName.substr(1).indexOf('/')+1);
    var url = localhostPaht + projectName +"/file/down.do?id="+id;
	
    $("#url").html(url);
    $("#mymodal").modal("toggle");
}