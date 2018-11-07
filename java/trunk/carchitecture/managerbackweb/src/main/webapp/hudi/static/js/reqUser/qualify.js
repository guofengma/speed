function commit() {
	$("#form-qualify").ajaxSubmit(function(result) {
		console.log(result);
		if(result.status == 1) {
			layer.open({
				title: '保存失败',
				content: result.errors[0].msg
			});

		}
		else if (result.status == 0){
			parent.parent.$.Huimodalalert('保存成功!',2000);		
			parent.location.reload();
		}
	});
}

$(document).ready(function() {
	$("#submit").on("click",function(){
		commit();
	});

});


