<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@include file="../commons/commons.jsp"%>
<!DOCTYPE html>
<head>
<meta charset="utf-8" />
<title>后台</title>
</head>

<body>
	<form action="${ctx }/roleMgt/list.do" id="submit-form">
	<div class="page-body">
		<div class="row">
			<div class="col-xs-12 col-md-12">
				<div class="widget">
                     <div class="table-toolbar">
						<a id="editabledatatable_new" class="btn btn-default" href="${ctx }/roleMgt/add.do">添加角色 </a>
					</div>
						<table class="table table-striped table-bordered table-hover"
							id="simpledatatable">
							<thead>
								<tr>
									<th>角色名称</th>
									<th>状态</th>
									<th>备注</th>
									<th>添加时间</th>
									<th>操作</th>
								</tr>
							</thead>
							<tbody>
								 <c:forEach items="${pagination.rows }" var="item">
                                      	   <%--  <input type="hidden" name="id" value="${"lottery.openTime }"/> --%>
                                            <tr>
	                                      	    
                                                <td>${item.roleName }</td>
                                                <td>
                                                	<c:if test="${item.status == -1}">无效</c:if>
                                                	<c:if test="${item.status == 1}">有效</c:if>
                                               	</td>
                                               	<td>${item.description }</td>
                                                <td>
	                                            	<fmt:formatDate value="${item.createTime }" type="date" pattern="yyyy-MM-dd HH:mm" />
	                                            </td>
	                                            <td>
	                                            	<a href="${ctx }/roleMgt/edit.do?id=${item.id}" class="btn btn-info btn-xs edit"><i class="fa fa-edit"></i>分配菜单</a>
	                                            	<a href="#" class="btn btn-danger btn-xs delete" onclick="del('${item.id}')"><i class="fa fa-trash-o"></i>Delete</a>
	                                            </td>
                                            </tr>
                                      	  </c:forEach>
							</tbody>
						</table>
						<%@include file="../commons/page.jsp"%>
					</div>
				</div>
	</form>

</body>
<script type="text/javascript">
	function search(){
		$("#submit-form").submit();
	}
	
	function del(id){
		bootbox.confirm("你确定删除吗?", function (result) {
            if (result) {
            	var url = '${ctx }' + "/roleMgt/del.do";
        		var sendData = {
        				"id": id
        			};
        			$.post(url,sendData, function(backData) {
        				if(backData.status == 1){
        					$("#submit-form").submit();
        				} else{
        					warningAlert(backData.message[0].msg);
        				}
        			});
            }
        });
		
	}
</script>
</html>