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
        				<c:if test="${empty bean.id}">新增</c:if>            
                    	<c:if test="${!empty bean.id}">编辑</c:if>
                    </span>
                   
                </div>
                <div class="widget-body">
                    <form id="saveOrUpdate" class="form-horizontal form-bordered" role="form" enctype="multipart/form-data" method="post" action="${ ctx}/roleMgt/save.do">
                    	<input type="hidden" name="id" value="${bean.id }"/>
                    	<div class="form-group">
	                        <label for="inputEmail3" class="col-sm-2 control-label no-padding-right">角色名</label>
	                        <div class="col-sm-10">
	                        	<input type="text" class="form-control" id="roleName" name="roleName" value="${bean.roleName }" placeholder="角色名" data-bv-notempty="true"
	                                          data-bv-notempty-message="角色名不能为空"/>
	                        </div>
                        </div>
                         <div class="form-group">
                        	<label for="inputPassword3" class="col-sm-2 control-label no-padding-right">说明</label>
                        	<div class="col-sm-10">
                                  <input type="text" class="form-control" id="description" name="description" value="${bean.description }" placeholder="说明" />
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
		if(!$('#roleName')){
			warningAlert("请输入角色名");
			return;
		}
		else{
			$("#saveOrUpdate").ajaxSubmit(function(result) {
				  if(result.status == 1){
					  window.location.href = '${ctx}' + "/roleMgt/list.do";
				  }else{
					  warningAlert(result.message[0].msg);
				  }
				});
			return false;
		}
	}

</script>
</html>
