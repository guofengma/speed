var phone = "";
var name = "";
var laypage,layer;

function isNull(text) {
	if (text == null){
		return "";
	}else {
		return text;
	}
}

function showCert(id){
	var url = ctx+"/yonghu/qcUser_cert?id="+id;
	layer_show('实名认证',url,1100,500);
}
function showQuality(id){
	
	var url = ctx+"/yonghu/qcUser_quality?id="+id;
	layer_show('资格审查',url,800,200);
}

function getData(){
	$.getJSON(ctx+'/yonghu/qcUser_listDo', {page: 1,phone:phone,name:name}, function(res){ //从第6页开始请求。返回的json格式可以任意定义
		laypage.render({
			elem: 'page', //容器。值支持id名、原生dom对象，jquery对象。【如该容器为】：&lt;div id="page1">&lt;/div>
	        count: res.count, //通过后台拿到的总页数
	        jump: function(e){ //触发分页后的回调
	            $.getJSON(ctx+'/yonghu/qcUser_listDo', {page: e.curr,phone:phone,name:name}, function(res){
	                //渲染
	                var view = document.getElementById('content'); //你也可以直接使用jquery               
	                var content="";
	                for(var o in res.result){
	                	if (res.result[o].isCert == 2 || res.result[o].isQualify == 2){
	                		 content = content + "<tr class='text-c warning'>";
	                	}else {
	                		 content = content + "<tr class='text-c'>";
	                	}
	                content = content
	                +"<td>"+isNull(res.result[o].id)+"</td>"
	                +"<td>"+isNull(res.result[o].username)+"</td>"
	                +"<td>"+isNull(res.result[o].name)+"</td>"
	                +"<td>"+isNull(res.result[o].sex)+"</td>"
	                +"<td>"+isNull(res.result[o].phone)+"</td>"
	                +"<td>"+isNull(res.result[o].email)+"</td>"
	                +"<td>"+isNull(res.result[o].companyName)+"</td>"
	                +"<td>"+isNull(res.result[o].address)+"</td>";
	                
	                if (res.result[o].isCert == 0){
	                	content = content + "<td>"+"未认证"+"</td>";
	                }else if(res.result[o].isCert == 1){
	                	content = content + "<td><a class='btn btn-link size-S' onclick='showCert("+res.result[o].id+")'>已认证</a></td>";
	                }else{
	                	content = content + "<td><a class='btn btn-link size-S' onclick='showCert("+res.result[o].id+")'>审核中</a></td>";
	                }
	                
	                if (res.result[o].isQualify== 0 ){
	                	content = content + "<td><a class='btn btn-link size-S' onclick='showQuality("+res.result[o].id+")'>未通过</a></td>";
	                }else if(res.result[o].isQualify== 1){
	                	content = content + "<td>"+"已通过"+"</td>";
	                }else {
	                	content = content + "<td><a class='btn btn-link size-S' onclick='showQuality("+res.result[o].id+")'>培训中</a></td>";
	                }
	                content = content +"<td>"+isNull(res.result[o].createTime)+"</td>"
	                +"<td>"
	                +"<a class='btn  btn-primary size-MINI radius' style='margin-right:2.5px;margin-left:2.5px' onclick='admin_edit("+res.result[o].id+")'><i class='Hui-iconfont'>&#xe6df;</i> 修改</a>"
	                +"<a class='btn  btn-danger size-MINI radius' style='margin-right:2.5px;margin-left:2.5px' onclick='admin_del("+res.result[o].id+",this)'><i class='Hui-iconfont'>&#xe609;</i> 删除</a>"
	                +"<a class='btn  btn-primary size-MINI radius' style='margin-right:2.5px;margin-left:2.5px' onclick='pipei("+res.result[o].id+")'><i class='Hui-iconfont'>&#xe6df;</i> 匹配</a>"
	                +"<a class='btn  btn-danger size-MINI radius' style='margin-right:2.5px;margin-left:2.5px' onclick='tousu("+res.result[o].id+")'><i class='Hui-iconfont'>&#xe6df;</i> 投诉</a>"
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
function pingjia(id){
	var url = ctx+"/qcUser_pingjia?id="+id;
	layer_show('QC用户评价',url,900,500);
}
function tousu(id){
	var url = ctx+"/qcUser_tousu?id="+id;
	layer_show('投诉QC用户',url,900,500);
}
function pipei(id){
	var url = ctx+"/qcUser_pipei?id="+id;
	layer_show('匹配QC订单',url,900);
}
function admin_edit(id){		
	var url = ctx+"/qcUser_edit?id="+id;
	layer_show('编辑QC用户',url,800);
}
function admin_del(id,obj){
	layer.confirm('确认要删除吗？',function(index){
		$.ajax({
			//data:{'id':id},
			//type: 'POST',
			url: '${ctx}/yonghu/qcUser_del?id='+id,
			dataType: 'json',
			success: function(data){
				$(obj).parents("tr").remove();
				$("#size").html($("#size").html()-1);
				layer.msg('已删除!',{icon:1,time:1000});
			},
			error:function(data) {
				console.log(data.msg);
			},
		});		
	});
}
$(document).ready(function() {
	
	$("#search").on("click",function(){
		phone = $("#phone").val();
		name = $("#name").val();
		getData();
	});
	
	layui.use(['laypage', 'layer'], function(){
		laypage = layui.laypage;
	  	layer = layui.layer;
		 getData();
		});
});


