var laypage,layer;

function isNull(text) {
	if (text == null){
		return "";
	}else {
		return text;
	}
}
function getData(){
	$.getJSON(ctx+'/order/qcComment_listDo', {page: 1}, function(res){ //从第6页开始请求。返回的json格式可以任意定义
		laypage.render({
			elem: 'page', //容器。值支持id名、原生dom对象，jquery对象。【如该容器为】：&lt;div id="page1">&lt;/div>
	        count: res.count, //通过后台拿到的总页数
	        jump: function(e){ //触发分页后的回调
	        	$.getJSON(ctx+'/order/qcComment_listDo', {page: e.curr}, function(res){
	                //渲染
	                var view = document.getElementById('content'); //你也可以直接使用jquery               
	                var content="";
	                var i = 0;
	                for(var o in res.result){  
	                	i = i+1;  
		                content = content + 
		                "<tr class='text-c'>"
		                +"<td>"+i+"</td>"
		                +"<td>"+isNull(res.result[o].reqUserId)+"</td>"
		                +"<td>"+isNull(res.result[o].qcId)+"</td>"
		                +"<td>"+isNull(res.result[o].qcOrderId)+"</td>"
		                +"<td>"+isNull(res.result[o].grade)+"</td>"
		                +"<td>"+isNull(res.result[o].createTime)+"</td>"
		                +"</tr>"; 
	                }
	                view.innerHTML = content;
	            });
	        }
		});
	}); 
}

function del(id,obj){
	layer.confirm('确认要删除吗？',function(index){
		$.ajax({
			data:{'id':id},
			url: '${ctx}/order/qcComment_del',
			dataType: 'json',
			success: function(data){
				if (data.status == 0){
					$(obj).parents("tr").remove();
					$("#size").html($("#size").html()-1);
					layer.msg('已删除!',{icon:1,time:1000});
				}else {
					layer.msg('删除失败!',{icon:1,time:1000});
				}
			
			},
			error:function(data) {
				console.log(data.msg);
			},
		});		
	});
}

function changeState(id,stateId){
	$.ajax({
		data:{'id':id,'stateId':stateId},
		url: '${ctx}/money/qcOrder_editDo',
		dataType: 'json',
		success: function(data){
			if (data.status == 0){
				layer.msg('更改成功!',{icon:1,time:1000});
				getData();
			}else {
				layer.msg('更改失败!',{icon:1,time:1000});
			}
		
		},
		error:function(data) {
			console.log(data.msg);
		},
	});		
}

$(document).ready(function() {
	
	$("#search").on("click",function(){
		qcOrderNum = $("#qcOrderNum").val();
		getData();
	});
	
	layui.use(['laypage', 'layer'], function(){
		laypage = layui.laypage;
	  	layer = layui.layer;
		getData();
	});
});


