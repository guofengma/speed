var loginname;
var laypage,layer;

function isNull(text) {
	if (text == null){
		return "";
	}else {
		return text;
	}
}

function enable(id,obj){
    $.ajax({
        data:{'id':id,'disabled':false},
        url: '${ctx}/admin/sysUser_editDo',
        dataType: 'json',
        success: function(data){
            if (data.status == 0){
                $(obj).html("<i class='Hui-iconfont'>&#xe631;</i> 禁用");
                $(obj).removeClass("btn-success");
                $(obj).addClass("btn-danger");
                $(obj).parent().parent().find("td")[3].innerHTML="<span class='label label-success radius'>已启用</span>";
                $(obj).attr("onclick","disable("+id+",this)")
                layer.msg('已启用!',{icon:1,time:1000});
            }else {
                layer.msg('启用失败!',{icon:2,time:1000});
            }
        },
        error:function(data) {
            console.log(data.msg);
        },
    });
}

function disable(id,obj){
    layer.confirm('确认要禁用该用户吗？',function(index){
        $.ajax({
            data:{'id':id,'disabled':true},
            url: '${ctx}/admin/sysUser_editDo',
            dataType: 'json',
            success: function(data){
                console.log(data);
                if (data.status == 0){
                    $(obj).html("<i class='Hui-iconfont'>&#xe601;</i> 启用");
                    $(obj).addClass("btn-success");
                    $(obj).removeClass("btn-danger");
                    $(obj).parent().parent().find("td")[3].innerHTML="<span class='label label-warning radius'>已禁用</span>";
                    $(obj).attr("onclick","enable("+id+",this)")
                    layer.msg('已禁用!',{icon:1,time:1000});
                }else {
                    layer.msg('禁用失败!',{icon:2,time:1000});
                }

            },
            error:function(data) {
                console.log(data.msg);
            },
        });
    });
}

function edit(id) {
	var url = ctx+"/base/sysUser_add?id="+id;
	layer_show('编辑管理员',url,800);
}

function resetPassword(id) {
    console.log(id);
    layer.open({
        title:"重置密码",
        type: 2,
        area: ['350px', '200px'],
        content: "${ctx}/admin/sysUser_resetPassword?id="+id//这里content是一个DOM，注意：最好该元素要存放在body最外层，否则可能被其它的相对元素所影响
    });
}
function del(id,obj) {
    layer.confirm('确认要删除该用户吗？',function(index){
        $.ajax({
            data:{'id':id},
            url: '${ctx}/admin/sysUser_delete',
            dataType: 'json',
            success: function(data){
                if (data.status == 0){
                    $(obj).parents("tr").remove();
                    $("#size").html($("#size").html()-1);
                    layer.msg('已删除!',{icon:1,time:1000});
                }else {
                    layer.msg('删除失败!',{icon:2,time:1000});
                }

            },
            error:function(data) {
                console.log(data.msg);
            },
        });
    });
}

function getData(){
	$.getJSON(ctx+'/admin/sysUser_listDo', {page: 1,loginname:loginname}, function(res){ //从第1页开始请求。返回的json格式可以任意定义

		laypage.render({
			elem: 'page', //容器。值支持id名、原生dom对象，jquery对象。【如该容器为】：&lt;div id="page1">&lt;/div>
	        count: res.count, //通过后台拿到的总页数
	        jump: function(e){ //触发分页后的回调
	            $.getJSON(ctx+'/admin/sysUser_listDo', {page: e.curr,loginname:loginname}, function(res){
	                //渲染
                    console.log(res);
	                var view = document.getElementById('content'); //你也可以直接使用jquery               
	                var content="";
	                for(var o in res.result) {
                        content = content
							+ "<tr class='text-c'>"
                            + "<td>" + (parseInt((res.pageNo-1) * res.pageSize)+parseInt(o)+1)+"</td>"
                            + "<td>" + isNull(res.result[o].loginname) + "</td>"
                            + "<td>" + isNull(res.result[o].nickname) + "</td>";
						if (res.result[o].disabled){
                            content = content + "<td><span class='label label-warning radius'>已禁用</span></td>"
						}else {
                            content = content + "<td><span class='label label-success radius'>已启用</span></td>"
						}
                        content = content+ "<td>" + isNull(res.result[o].opat) + "</td>"
							+"<td width='300px'>"
								if (res.result[o].disabled){
                                    content = content+"<a class='btn  btn-success size-MINI radius' style='margin-right:2.5px;margin-left:2.5px' onclick='enable("+res.result[o].id+",this)'><i class='Hui-iconfont'>&#xe601;</i> 启用</a>"
								}else {
                                    content = content+"<a class='btn  btn-danger  size-MINI radius' style='margin-right:2.5px;margin-left:2.5px' onclick='disable("+res.result[o].id+",this)'><i class='Hui-iconfont'>&#xe631;</i> 禁用</a>"
								}

                        content = content+"<a class='btn  btn-primary size-MINI radius' style='margin-right:2.5px;margin-left:2.5px' onclick='resetPassword("+res.result[o].id+")'><i class='Hui-iconfont'>&#xe63f;</i> 重置密码</a>"
                            +"<a class='btn  btn-primary size-MINI radius' style='margin-right:2.5px;margin-left:2.5px' onclick='edit("+res.result[o].id+")'><i class='Hui-iconfont'>&#xe6df;</i> 修改</a>"
                            +"<a class='btn  btn-danger size-MINI radius' style='margin-right:2.5px;margin-left:2.5px' onclick='del("+res.result[o].id+",this)'><i class='Hui-iconfont'>&#xe609;</i> 删除</a>"
							+"</td>"
							+"</tr>"
                    }
	                view.innerHTML = content;
	            });
	        }
	    });
	}); 
}

$(document).ready(function() {
	
	$("#search").on("click",function(){
        loginname = $("#loginname").val();
		getData();
	});
	
	layui.use(['laypage', 'layer'], function(){
		laypage = layui.laypage;
	  	layer = layui.layer;
		 getData();
		});
});


