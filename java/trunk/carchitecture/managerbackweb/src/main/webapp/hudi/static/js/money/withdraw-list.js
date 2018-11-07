var laypage,layer;
var name = "";
var phone = "";
var state = "";
var failId = "";
function isNull(text) {
	if (text == null){
		return "";
	}else {
		return text;
	}
}

function getData(){
	$.getJSON(ctx+'/money/withdraw_listDo', {page: 1,name:name,phone:phone,state:state}, function(res){ //从第6页开始请求。返回的json格式可以任意定义
		laypage.render({
			elem: 'page', //容器。值支持id名、原生dom对象，jquery对象。【如该容器为】：&lt;div id="page1">&lt;/div>
	        count: res.count, //通过后台拿到的总页数
	        jump: function(e){ //触发分页后的回调
	        	console.log(e);
	            $.getJSON(ctx+'/money/withdraw_listDo', {page: e.curr,name:name,phone:phone,state:state}, function(res){
	                //渲染
	                var view = document.getElementById('content'); //你也可以直接使用jquery               
	                var content="";
	                for(var o in res.result){
	                	if (res.result[o].state == 1){
	                		 content = content + "<tr class='text-c warning'>";
	                	}else {
	                		 content = content + "<tr class='text-c'>";
	                	}
	                content = content +"<td>"+isNull(res.result[o].id)+"</td>"
	                +"<td>"+isNull(res.result[o].name)+"</td>"
	                +"<td>"+isNull(res.result[o].phone)+"</td>"
	                +"<td>"+isNull(res.result[o].money)+"</td>"
	                if (res.result[o].moneyUnit == 1){
	                	content = content +"<td>人民币</td>";
	                }else {
	                	content = content +"<td>美元</td>";
	                }
	                
	                if (res.result[o].type == 1){
	                	content = content +"<td>PC用户</td>";
	                }else {
	                	content = content +"<td>QC用户</td>";
	                }
                        content = content +"<td>"+isNull(res.result[o].bankAccount)+"</td>"
                        +"<td>"+isNull(res.result[o].openingBank)+"</td>"

	                if (res.result[o].state == 1){
	                	content = content +"<td>审核中</td>";
	                }else if (res.result[o].state == 2){
	                	content = content +"<td>提现中</td>";
	                }else if (res.result[o].state == 3){
	                	content = content +"<td>已到账</td>";
	                }else if (res.result[o].state == 4){
	                	content = content +"<td>提现失败</td>";
	                }                
	                content = content +"<td>"+isNull(res.result[o].createTime)+"</td>"
	                +"<td class='td-manage' style='text-align: right;padding-right:20px;'>"
	                if (res.result[o].state == 1){
	                	//状态更换成2
	                content = content+"<input class='btn btn-primary radius size-S' type='button' value='审核通过' onclick = 'changeState("+res.result[o].id+",2)'>";
	                }else if (res.result[o].state == 2){
	                	content = content+"<input class='btn btn-primary radius size-S' type='button' value='已到账' onclick = 'changeState("+res.result[o].id+",3)'>";
	                	content = content+"<input class='btn btn-warning radius size-S' type='button' value='提现失败' onclick = 'showFailInput("+res.result[o].id+")' style='margin-left:10px;'>";
	                }
	                content = content+"<input class='btn btn-danger  radius 	size-S' type='button' value='删除' style='margin-left:10px;' onclick = 'del("+res.result[o].id+",this)'>"
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
			url: '${ctx}/money/withdraw_del',
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

function changeState(id,state){
	$.ajax({
		data:{'id':id,'state':state},
		url: '${ctx}/money/withdraw_editDo',
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
		name = $("#name").val();
		phone = $("#phone").val();
		state = $("#state").val();
		getData();
	});
	
	$("#submitFailReason").on("click",function(){
		$(this).attr("");
		$.ajax({
			data:{'id':failId,'failReason':$("#failReason").val(),'state':4},
			url: '${ctx}/money/withdraw_editDo',
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


