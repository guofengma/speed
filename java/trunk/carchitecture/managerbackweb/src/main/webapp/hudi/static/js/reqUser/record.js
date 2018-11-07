var name = "";
var laypage,layer;
var certifiType = ["未认证","个人认证","企业认证"];
var adopt = ["未上传","待审核","审核通过","审核失败"];
var type = ["","预约QC","平台跟单"];
var money = ["","美元","人民币"];
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
	$.getJSON(ctx+'/money/pay_listDo', {page: 1,type:2,reqUserId:$("#reId").val()}, function(res){ //浠庣6椤靛紑濮嬭姹傘�杩斿洖鐨刯son鏍煎紡鍙互浠绘剰瀹氫箟
		laypage.render({
			elem: 'page', //瀹瑰櫒銆傚�鏀寔id鍚嶃�鍘熺敓dom瀵硅薄锛宩query瀵硅薄銆傘�濡傝瀹瑰櫒涓恒�锛�lt;div id="page1">&lt;/div>
	        count: res.count, //閫氳繃鍚庡彴鎷垮埌鐨勬�椤垫暟
	        jump: function(e){ //瑙﹀彂鍒嗛〉鍚庣殑鍥炶皟
	        	console.log(e);
	            $.getJSON(ctx+'/money/pay_listDo', {page: e.curr,type:2,reqUserId:$("#reId").val()}, function(res){
	                //娓叉煋
	                var view = document.getElementById('content'); //浣犱篃鍙互鐩存帴浣跨敤jquery               
	                var content="";
	                var i = 0;
	                for(var o in res.result){  
                	i = i+1;
                	content = content + "<tr class='text-c'>"
	                +"<td>"+i+"</td>"
	                +"<td>"+isNull(res.result[o].paySum)+"</td>"
	                +"<td>"+isNull(money[res.result[o].paySumUnit])+"</td>"
	                +"<td>"+isNull(type[res.result[o].type])+"</td>"
	                +"<td>"+isNull(res.result[o].createTime)+"</td>"
	                +"<td>"+isNull(res.result[o].payContent)+"</td>"
	                +"</td>"
	                +"</tr>"; 
	                }
	                view.innerHTML = content;
	            });
	        }
	    	});
		}); 
	$.getJSON(ctx+'/reqUser_listDoReq', {page: 1,id:$("#reId").val()}, function(res){ //浠庣6椤靛紑濮嬭姹傘�杩斿洖鐨刯son鏍煎紡鍙互浠绘剰瀹氫箟
		laypage.render({
			elem: 'page', //瀹瑰櫒銆傚�鏀寔id鍚嶃�鍘熺敓dom瀵硅薄锛宩query瀵硅薄銆傘�濡傝瀹瑰櫒涓恒�锛�lt;div id="page1">&lt;/div>
	        count: res.count, //閫氳繃鍚庡彴鎷垮埌鐨勬�椤垫暟
	        jump: function(e){ //瑙﹀彂鍒嗛〉鍚庣殑鍥炶皟
	        	console.log(e);
	            $.getJSON(ctx+'/reqUser_listDoReq', {page: e.curr,id:$("#reId").val()}, function(res){
	                //娓叉煋
	                var view = document.getElementById('content3'); //浣犱篃鍙互鐩存帴浣跨敤jquery               
	                var content="";
	                var i = 0;
	                for(var o in res.result){  
                	i = i+1;
                	//一级码等于用户的唯一码，显示"一级"
                	if($("#salCode").val()==res.result[o].firstIntroduceId){
                		content = content + "<tr class='text-c'>"
    	                +"<td>"+i+"</td>"
    	                +"<td>"+isNull(res.result[o].phone)+"</td>"
    	                +"<td>"+isNull(res.result[o].email)+"</td>"
    	                +"<td>"+isNull(res.result[o].username)+"</td>"
    	                +"<td>"+"一级"+"</td>"
    	                +"<td>"+isNull(res.result[o].createTime)+"</td>"	                   	               
    	                +"</tr>"; 
                		//二级码等于用户的唯一码，显示"二级"
                	}else if($("#salCode").val()==res.result[o].secondIntroduceId){
                		content = content + "<tr class='text-c'>"
    	                +"<td>"+i+"</td>"
    	                +"<td>"+isNull(res.result[o].phone)+"</td>"
    	                +"<td>"+isNull(res.result[o].email)+"</td>"
    	                +"<td>"+isNull(res.result[o].username)+"</td>"
    	                +"<td>"+"二级"+"</td>"
    	                +"<td>"+isNull(res.result[o].createTime)+"</td>"	                   	               
    	                +"</tr>"; 
                	}
                	/*content = content + "<tr class='text-c'>"
	                +"<td>"+i+"</td>"
	                +"<td>"+isNull(res.result[o].phone)+"</td>"
	                +"<td>"+isNull(res.result[o].email)+"</td>"
	                +"<td>"+isNull(res.result[o].username)+"</td>"
	                +"<td>"+isNull(res.result[o].saleManaCode)+"</td>"
	                +"<td>"+isNull(res.result[o].createTime)+"</td>"	               
	                +"</td>"
	                +"</tr>"; */
	                }
	                view.innerHTML = content;
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
	var url = ctx+"/reqUser_edit?id="+id;
	layer_show('编辑PC用户',url,800);
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


