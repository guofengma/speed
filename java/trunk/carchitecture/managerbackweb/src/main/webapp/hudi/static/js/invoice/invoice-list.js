var laypage,layer;
var invoname = "";
var invotype = "";
var accept = "";
var failId = "";
function isNull(text) {
	if (text == null){
		return "";
	}else {
		return text;
	}
}

function getData(){
	$.getJSON(ctx+'/money/invoice_listDo', {page: 1,invoname:invoname,invotype:invotype,accept:accept}, function(res){ //从第6页开始请求。返回的json格式可以任意定义
		laypage.render({
			elem: 'page', //容器。值支持id名、原生dom对象，jquery对象。【如该容器为】：&lt;div id="page1">&lt;/div>
	        count: res.count, //通过后台拿到的总页数
	        jump: function(e){ //触发分页后的回调
	        	console.log(e);
	            $.getJSON(ctx+'/money/invoice_listDo', {page: e.curr,invoname:invoname,invotype:invotype,accept:accept}, function(res){
	                //渲染
	                var view = document.getElementById('content'); //你也可以直接使用jquery               
	                var content="";
	                var i = 0;
	                for(var o in res.result){  
	                	i = i+1;
	                	if (res.result[o].state == 1){
	                		 content = content + "<tr class='text-c warning'>";
	                	}else {
	                		 content = content + "<tr class='text-c'>";
	                	}
	                content = content+"<td>"+i+"</td>"
	                +"<td>"+isNull(res.result[o].invonum)+"</td>";
	                
	                if(res.result[o].invotype == 1){
	                	 content = content +"<td>普通发票</td>";
	                }else{
	                	content = content +"<td>增值税发票</td>";
	                }
	                content = content +"<td>"+isNull(res.result[o].amount)+"</td>"
	                +"<td>"+isNull(res.result[o].invoname)+"</td>"
	                +"<td>"+isNull(res.result[o].applyTime)+"</td>";
	                if (res.result[o].accept == 1){
	                	content = content+"<td>待审核"
		                //状态更换成2
		                +"<input class='btn btn-primary radius size-S' type='button' style='margin-left:10px;' value='审核通过' onclick = 'changeState("+res.result[o].id+",2)'>";
	                }else if (res.result[o].accept == 2){
	                	content = content+"<td>已开票";
	                }
	                content = content//+"<input class='btn btn-danger radius size-S' type='button' value='删除' style='margin-left:10px;' onclick = 'del("+res.result[o].id+",this)'>"
	                +"</td>"
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
			url: '${ctx}/order/invoice_del',
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

function changeState(id,accept){
	$.ajax({
		data:{'id':id,'accept':accept},
		url: '${ctx}/money/invoice_editDo',
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
function showFailInput(id){
	$("#modal-demo").modal("show");
	failId = id;
};

$(document).ready(function() {
	$("#search").on("click",function(){
		invoname = $("#invoname").val();
		invotype = $("#invotype").val();
		accept = $("#accept").val();
		getData();
	});
	
	$("#submitFailReason").on("click",function(){
		$(this).attr("");
		$.ajax({
			data:{'id':failId,'failReason':$("#failReason").val(),'state':4},
			url: '${ctx}/money/invoice_editDo',
			dataType: 'json',
			success: function(data){
				if (data.status == 0){
					layer.msg('提交成功!',{icon:1,time:1000});
					$("#modal-demo").modal("hide");
				}else {
					layer.msg('提交失败!',{icon:1,time:1000});
				}
			
			},
			error:function(data) {
				console.log(data.msg);
			},
		});		
	});
	
	layui.use(['laypage', 'layer'], function(){
		laypage = layui.laypage;
	  	layer = layui.layer;
		 getData();
	});	
	
});

