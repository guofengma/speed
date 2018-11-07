$(document).ready(function() {
	$("#form-comment-edit").validate({		
		onkeyup:false,
		focusCleanup:false,
		success:"valid",
		submitHandler:function(form){
			$(form).ajaxSubmit({
				type: 'post',
				url: "${ctx}/qcComment_edit" ,
				dataType: 'json',						
				success: function(data){
					parent.parent.$.Huimodalalert('操作成功!',2000);		
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

function preview(file){  
	if (file.files && file.files[0]){  
		var reader = new FileReader();  
		reader.onload = function(evt){  
              // prevDiv.innerHTML = '<img width="100%" height="100%" id="qw_img" src="' + evt.target.result + '" />';
			$('.preview').attr('src' , evt.target.result);
		}    
		reader.readAsDataURL(file.files[0]);  
	}else{  
             // prevDiv.innerHTML = '<div class="img" style="filter:progid:DXImageTransform.Microsoft.AlphaImageLoader(sizingMethod=scale,src=\'' + file.value + '\'"></div>';  
		$('.preview').attr('src' , file.value);
	}  
} 
