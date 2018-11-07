var qcOrderNum = "";
var stateId = "";
var laypage,layer;
var state = ["","待审核","待支付","服务中","待确定","待评价","已完成","已取消","已完成"];
var stateVal="";
console.log("000:"+parseInt($("#stateVal").val()))
if($("#stateVal").val()==""){
	stateVal=null;
}else{	
	stateVal=parseInt($("#stateVal").val());
}
var stateId=stateVal;
function isNull(text) {
	if (text == null){
		return "";
	}else {
		return text;
	}
}
function getData(){
	$.getJSON(ctx+'/order/qcOrder_listDo', {page: 1,qcOrderNum:qcOrderNum,stateId:stateId}, function(res){ //从第6页开始请求。返回的json格式可以任意定义
		laypage.render({
			elem: 'page', //容器。值支持id名、原生dom对象，jquery对象。【如该容器为】：&lt;div id="page1">&lt;/div>
	        count: res.count, //通过后台拿到的总页数
	        jump: function(e){ //触发分页后的回调
	        	$.getJSON(ctx+'/order/qcOrder_listDo', {page: e.curr,qcOrderNum:qcOrderNum,stateId:stateId}, function(res){
	                //渲染
	                var view = document.getElementById('content'); //你也可以直接使用jquery               
	                var content="";
	                var i = 0;
	                for(var o in res.result){  
	                	i = i+1;  
		                content = content + 
		                "<tr class='text-c'>"
		                +"<td>"+i+"</td>"
		                +"<td>"+isNull(res.result[o].qcOrderNum)+"</td>"
		                +"<td>"+isNull(res.result[o].taskGoal)+"</td>"
		                +"<td>"+isNull(res.result[o].clientName)+"</td>"
		                +"<td>"+isNull(res.result[o].factoryName)+"</td>"
		                +"<td>"+isNull(res.result[o].createTime)+"</td>"
		                +"<td class='td-manage' >";//style='text-align:right;padding-right:20px;'
		                if (res.result[o].stateId == 1){
		                	content = content+state[res.result[o].stateId]
		                	+"<input class='btn btn-primary radius size-S' type='button' value='通过审核' onclick = 'changeState("+res.result[o].id+",2)' style='margin-left:10px;'>";
		                	
		                }else if (res.result[o].stateId >= 2){
		                	content = content+state[res.result[o].stateId]
		                }else{
		                	content = content+state[1]
		                }
		                content = content+"</td>";
		                if (res.result[o].stateId == 6){
		                	content = content+"<td><input class='btn btn-danger radius size-S' type='button' value='评价' style='margin-left:10px;' onclick = 'edit("+res.result[o].id+")'></td>"
		                }else if (res.result[o].stateId == 8){
		                	content = content+"<td>已评价</td>"
		                }else{
		                	content = content +"<td>未完成</td>";
		                }
		                content = content
		                +"<td>"
		                +"<a class='btn  btn-primary size-MINI radius' style='margin-right:2.5px;margin-left:2.5px' onclick='edit("+res.result[o].id+")'><i class='Hui-iconfont'>&#xe6df;</i> 修改</a>"
                        +"<a class='btn  btn-danger size-MINI radius' style='margin-right:2.5px;margin-left:2.5px' onclick='del("+res.result[o].id+",this)'><i class='Hui-iconfont'>&#xe609;</i> 删除</a>"
                        +"<a class='btn  btn-primary size-MINI radius' style='margin-right:2.5px;margin-left:2.5px' onclick='pingjia("+res.result[o].id+")'><i class='Hui-iconfont'>&#xe6df;</i> 评价</a>"                       
                        +"</td>"
		                +"</tr>"; 
	                }
	                view.innerHTML = content;
	            });
	        }
		});
	}); 
}

function edit(id){
	var url = ctx+"/order/qcOrder_edit?id="+id;
	layer_show('编辑QC订单',url,900,600);
}

function pingjia(id){
	var url = ctx+"/order/qcOrder_pingjia?id="+id;
	layer_show('QC订单评价',url,900,300);
}

function del(id,obj){
	layer.confirm('确认要删除吗？',function(index){
		$.ajax({
			data:{'id':id},
			url: '${ctx}/order/qcOrder_del',
			dataType: 'json',
			success: function(data){
				if (data.status == 0){
					$(obj).parents("tr").remove();
					$("#size").html($("#size").	html()-1);
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
		console.log("000:"+parseInt($("#stateVal").val()))
		var stateVal2="";
		if($("#stateVal").val()==""){
			stateVal2=null;
		}else{	
			stateVal2=parseInt($("#stateVal").val());
		}		
		stateId=stateVal2;
		console.log("11:"+stateId)
		
		getData();
	});
	
	layui.use(['laypage', 'layer'], function(){
		laypage = layui.laypage;
	  	layer = layui.layer;
		getData();
	});
});


