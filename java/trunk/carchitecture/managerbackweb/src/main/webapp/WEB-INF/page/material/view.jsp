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
                    <form id="saveOrUpdate" class="form-horizontal form-bordered" role="form" enctype="multipart/form-data" method="post" action="${ ctx}/material/saveDo.do">
                    	<input type="hidden" id = "id" name="id" value="${bean.id }"/>
                    	<%-- <c:if test="${!empty bean.type }"><input type="text" id = "type" name="type" value="${bean.type }"/></c:if> --%>
                    	<c:if test="${!empty typeId }"><input type="hidden" id = "type" name="typeId" value="${typeId }"/></c:if>
                    	<c:if test="${empty bean.id}">                    		    
                        	<div class="form-group">
	                        	<label for="inputEmail3" class="col-sm-2 control-label no-padding-right">标题</label>
	                        	<div class="col-sm-10">
	                        		<input type="text" class="form-control" id="contentmin" name="title" 
	                        				placeholder="标题" data-bv-notempty="true" data-bv-notempty-message="标题不能为空" />
	                        	</div>
	                        	
                        	</div>  
                        	<div class="form-group">
	                        	<label for="inputEmail3" class="col-sm-2 control-label no-padding-right">内容</label>
	                        	<div class="col-sm-10">
	                        		<input type="text" class="form-control" id="contentmax" name="content" 
	                        				placeholder="内容" data-bv-notempty="true" data-bv-notempty-message="内容不能为空" />
	                        	</div>
	                        	
                        	</div>      
                        	<div class="form-group">
	                        	<label for="inputEmail3" class="col-sm-2 control-label no-padding-right">上传照片</label>
	                        	<div class="col-sm-10">
	                        		<input type="file" class="file" id="file" name="file" data-show-upload="true"
	                        				placeholder="照片内容" data-bv-notempty="true" data-bv-notempty-message="照片不能为空" />
	                        	</div>
	                        	
                        	</div>                     	
                        </c:if>
                        <c:if test="${!empty bean.id}">  
                        	<%-- <div><input type="hidden" name="pid" value="${bean.pid }"> </div>         --%>              	
                    		<div class="form-group">
	                        	<label for="inputEmail3" class="col-sm-2 control-label no-padding-right">标题</label>
	                        	<div class="col-sm-10">
	                        		<input type="text" class="form-control" id="contentmin" name="title"  value = "${bean.title}"
	                        				placeholder="标题" data-bv-notempty="true" data-bv-notempty-message="标题不能为空" />
	                        	</div>
                        	</div>  
                        	<div class="form-group">
	                        	<label for="inputEmail3" class="col-sm-2 control-label no-padding-right">内容</label>
	                        	<div class="col-sm-10">
	                        		<input type="text" class="form-control" id="contentmax" name="content" value="${bean.content }"
	                        				placeholder="内容" data-bv-notempty="true" data-bv-notempty-message="内容不能为空" />
	                        	</div>
	                        	
                        	</div>   
                        	<div class="form-group">
	                        	<label for="inputEmail3" class="col-sm-2 control-label no-padding-right">上传照片</label>
	                        	<div class="col-sm-10">	                        	
	                        		<input type="file" class="file" id="file" name="file" 
	                        				placeholder="上传照片" data-bv-notempty="true" data-bv-notempty-message="照片不能为空"/>
	                        	</div>
	                        	
                        	</div>                       	
                        </c:if>
                        <div class="form-group">
                            <div class="col-sm-offset-2 col-sm-10">
                                <a class="btn btn-palegreen" href="javascript:save()">提交</a>
                                <a class="btn btn-palegreen" href="${ctx}/material/list.do?typeId=${typeId}">返回</a>
                              
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
		if(!$('#contentmin').val()){
			warningAlert("请输入移动端内容");
			return;
		}
		if(!$('#contentmax').val()){
			warningAlert("请输入PC端内容");
			return;
		}
		$("#saveOrUpdate").ajaxSubmit(function(result) {			
			  if(result.status == 1){
				  window.location.href = '${ctx}' + "/material/list.do?typeId="+'${typeId}';
			  }else{
				  warningAlert(result.message[0].msg);
			  }
		});
	}

</script>
</html>
