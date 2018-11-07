var laypage,layer;

function isNull(text) {
	if (text == null){
		return "";
	}else {
		return text;
	}
}

function getData(){
	$.getJSON(ctx+'/base/country_listDo', {page: 1}, function(res){ //从第6页开始请求。返回的json格式可以任意定义
		laypage.render({
			elem: 'page', //容器。值支持id名、原生dom对象，jquery对象。【如该容器为】：&lt;div id="page1">&lt;/div>
	        count: res.count, //通过后台拿到的总页数
	        jump: function(e){ //触发分页后的回调
	            $.getJSON(ctx+'/base/country_listDo', {page: e.curr}, function(res){
	                //渲染
	                var view = document.getElementById('content'); //你也可以直接使用jquery               
	                var content="";
	                var i = 0;
	                for(var o in res.result){
		                i = i + 1;
		                content = content + "<tr class='text-c'>"
		                +"<td>"+i+"</td>"
		                +"<td>"+isNull(res.result[o].name)+"</td>"
		                +"<td>"+isNull(res.result[o].createDate)+"</td>"
		                +"<td class='td-manage'>"
		                +"<a title='编辑' href='javascript:;' onclick = 'edit("+res.result[o].id+")' class='ml-5' style='text-decoration:none'><i class='Hui-iconfont'>&#xe6df;</i></a>"
		                +"<a title='删除' href='javascript:;' onclick = 'del("+res.result[o].id+",this)' class='ml-5' style='text-decoration:none'><i class='Hui-iconfont'>&#xe6e2;</i></a>"
		                +"</td>"
		                +"</tr>"; 
	                }
	                view.innerHTML = content;
	            });
	        }
	    	});
			}); 
}

function add(){
	var url = ctx+"/base/country_add";
	layer_show('添加国家',url,700,200);
}

function edit(id){
	var url = ctx+"/base/country_edit?id="+id;
	layer_show('编辑国家',url,700,200);
}

function del(id,obj){

	layer.confirm('确认要删除吗？',function(index){
		$.ajax({
			data:{'id':id},
			url: '${ctx}/base/country_del',
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
	layui.use(['laypage', 'layer'], function(){
		laypage = layui.laypage;
	  	layer = layui.layer;
		 getData();
	});

});


