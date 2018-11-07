$(document).ready(function() {
	$("#form-price-add").validate({		
		onkeyup:false,
		focusCleanup:false,
		success:"valid",
		submitHandler:function(form){
			$(form).ajaxSubmit({
				type: 'post',
				url: "${ctx}/money/price_addDo" ,
				dataType: 'json',						
				success: function(data){
					parent.parent.$.Huimodalalert('添加成功!',2000);		
					parent.location.reload();				
					//layer.msg('添加成功!');
				},
                error: function(XmlHttpRequest, textStatus, errorThrown){
					layer.msg('error!',{icon:1,time:1000});
				}
			});			
		}
	});
});


