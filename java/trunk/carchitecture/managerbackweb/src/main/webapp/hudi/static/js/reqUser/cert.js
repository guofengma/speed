function updCert(adopt,id){
	var params = "adopt="+adopt+"&id="+id;
	$.post("${ctx}/yonghu/reqUser_updCert",params,function(data){
		if(data.errors==""){
			parent.parent.$.Huimodalalert('审核成功!',2000);
			parent.location.reload();
		}else{
			parent.parent.$.Huimodalalert('审核出错!',2000);
		}
		
	});
}


