<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@include file="../commons/commons.jsp"%>
<!DOCTYPE html>

<head>
    <meta charset="utf-8" />
    <title>Data Tables</title>

    
</head>
<body>
<div class="page-body">
    <div class="row">
        <div class="col-xs-12 col-md-12">
            <div class="widget">
                <div class="widget-header ">
                    <span class="widget-caption">
        				<c:if test="${empty id}">新增</c:if>            
                    	<c:if test="${!empty id}">编辑</c:if>
                    </span>
                   
                </div>
                <div class="widget-body">
                    <form id="saveOrUpdate" class="form-horizontal form-bordered" role="form" enctype="multipart/form-data" method="post" action="${ ctx}/adminMgt/save.do">
                    	<input type="hidden" name="id" value="${id }"/>
                    	<div class="form-group">
	                        <label for="inputEmail3" class="col-sm-2 control-label no-padding-right">用户名</label>
	                        <div class="col-sm-10">
	                        	<input type="text" class="form-control" id="userName" name="userName" value="${bean.userName }" placeholder="用户名" data-bv-notempty="true"
	                                          data-bv-notempty-message="用户名不能为空"/>
	                        </div>
                        </div>
                         <div class="form-group">
                        	<label for="inputPassword3" class="col-sm-2 control-label no-padding-right">手机号码</label>
                        	<div class="col-sm-10">
                                  <input type="text" class="form-control" id="phone" name="phone" value="${bean.phone }" placeholder="手机号码"
                                  		data-bv-notempty="true"
                                          data-bv-notempty-message="手机号码不能为空" />
                              </div>
                        </div>
                        <div class="form-group">
	                         <label for="inputPassword3" class="col-sm-2 control-label no-padding-right">密码</label>
	                         <div class="col-sm-10">
	                             <input type="password" class="form-control" id="userPwd" name="userPwd" value="${bean.userPwd }" placeholder="密码"
	                           			data-bv-notempty="true"
	                                    data-bv-notempty-message="密码不能为空"/>
                            </div>
                        </div>
                       <!--<div class="form-group">
	                         <label for="inputPassword3" class="col-sm-2 control-label no-padding-right">确认密码</label>
	                         <div class="col-sm-10">
	                             <input type="text" class="form-control" id="submitUserPwd"  placeholder="确认密码"
	                           			data-bv-notempty="true"
	                                    data-bv-notempty-message="确认密码不能为空"/>
                            </div>
                        </div>  -->
                        <div class="form-group">
	                         <label for="inputPassword3" class="col-sm-2 control-label no-padding-right">角色</label>
	                         <div class="col-lg-4 col-sm-4 col-xs-4">
                                 <div class="checkbox">
                                 	<c:forEach items="${roles }" var="role">
	                                 	 <label>
	                                         <input name="roleids" type="checkbox" value="${role.id }" >
	                                         <span class="text">${role.roleName }</span>
	                                     </label>
                                 	</c:forEach>
                                 </div>
                             </div>
                        </div>
                            <div class="form-group">
                                <div class="col-sm-offset-2 col-sm-10">
                                    <a class="btn btn-palegreen" href="javascript:save()">提交</a>
                                </div>
                     	</div>
                 	</form>
                </div>
            </div>
        </div>
    </div>
</div>
</body>
<script>
	$(document).ready(function () {
	    $('#picUpload').bootstrapValidator();
	});
	
	var save =function(){
		if(!$('#userName')){
			warningAlert("请输入用户名");
			return;
		}
		if(!$('#phone')){
			warningAlert("请输入电话号码");
			return;
		}
		if(!$('#userPwd')){
			warningAlert("请输入密码");
			return;
		}
		var chk_value =[]; 
		$('input[name="roleids"]:checked').each(function(){ 
			chk_value.push($(this).val()); 
			}); 
		if(chk_value.length == 0){
			warningAlert("请选择角色");
			return;
		}else{
			$("#saveOrUpdate").ajaxSubmit(function(result) {
				  if(result.status == 1){
					  window.location.href = '${ctx}' + "/adminMgt/list.do";
				  }else{
					  warningAlert(result.message[0].msg);
				  }
				});
			return false;
		}
	}

</script>
</html>
