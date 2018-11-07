var name = "";
var laypage,layer;
var certifiType = ["未认证","个人认证","企业认证"];
var adopt = ["未上传","待审核","审核通过","审核失败"];

function isNull(text) {
	if (text == null){
		return "";
	}else {
		return text;
	}
}

function showCert(id){
	var url = ctx+"/yonghu/reqUser_cert?id="+id;
	layer_show('实名认证',url,1100,500);
}

function getData(){
	$.getJSON(ctx+'/yonghu/reqUser_listDo', {page: 1,name:name}, function(res){ //从第6页开始请求。返回的json格式可以任意定义
		laypage.render({
			elem: 'page', //容器。值支持id名、原生dom对象，jquery对象。【如该容器为】：&lt;div id="page1">&lt;/div>
	        count: res.count, //通过后台拿到的总页数
	        jump: function(e){ //触发分页后的回调
	            $.getJSON(ctx+'/yonghu/reqUser_listDo', {page: e.curr,name:name}, function(res){
	                //渲染
	                var view = document.getElementById('content'); //你也可以直接使用jquery               
	                var content="";
	                var i = 0;
	                for(var o in res.result){
	                	i = i+1;
	                	if (res.result[o].isCert == 2 || res.result[o].isQualify == 2){
	                		 content = content + "<tr class='text-c warning'>";
	                	}else {
	                		 content = content + "<tr class='text-c'>";
	                	}
	                content = content
	                +"<td>"+i+"</td>"
	                +"<td>"+isNull(res.result[o].username)+"</td>"
	                +"<td>"+isNull(res.result[o].name)+"</td>"
	                +"<td>"+isNull(res.result[o].sex)+"</td>"
	                +"<td>"+isNull(res.result[o].phone)+"</td>"
	                +"<td>"+isNull(res.result[o].email)+"</td>"
	                +"<td>"+isNull(res.result[o].companyName)+"</td>"
	                + "<td>"+certifiType[res.result[o].certifiType]+"</td>";
	                if(res.result[o].adopt == 1){
	                	content = content + "<td><a class='btn btn-link size-S' onclick='showCert("+res.result[o].id+")'>"+adopt[res.result[o].adopt]+"</a></td>";
	                }else{
	                	content = content + "<td>"+adopt[res.result[o].adopt]+"</td>";
	                }
	                content = content +"<td>"
	                +"<a class='btn  btn-primary size-MINI radius' style='margin-right:2.5px;margin-left:2.5px' onclick='admin_edit("+res.result[o].id+")'><i class='Hui-iconfont'>&#xe6df;</i> 修改</a>"
	                +"<a class='btn  btn-danger size-MINI radius' style='margin-right:2.5px;margin-left:2.5px' onclick='admin_del("+res.result[o].id+",this)'><i class='Hui-iconfont'>&#xe609;</i> 删除</a>"                   
	                +"<a class='btn  btn-primary size-MINI radius' style='margin-right:2.5px;margin-left:2.5px' onclick='admin_record("+res.result[o].id+")'><i class='Hui-iconfont'>&#xe6df;</i> 记录详情</a>"
	                +"</td>"+"</tr>";
	                view.innerHTML = content;
	                }
	            });
	        }
	    	});
			}); 
}

function admin_add(title,url,w,h){
	layer_show(title,url,w,h);
}
//弹框记录详情
function admin_record(id){		
	var url = ctx+"/reqUser_record?id="+id;
	layer_show('PC用户记录',url,800);
}
function admin_edit(id){		
	var url = ctx+"/reqUser_edit?id="+id;
	layer_show('编辑PC用户',url,800);
}
function admin_del(id,obj){
	layer.confirm('确认要删除吗？',function(index){
		$.ajax({
			//data:{'id':id},
			//type: 'POST',
			url: '${ctx}/reqUser_delete?id='+id,
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
		name = $("#name").val();
		getData();
	});
	
	layui.use(['laypage', 'layer'], function(){
		laypage = layui.laypage;
	  	layer = layui.layer;
		 getData();
		});
});


