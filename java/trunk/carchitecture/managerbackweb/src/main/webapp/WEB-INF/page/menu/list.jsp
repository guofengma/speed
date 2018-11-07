<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@include file="../commons/commons.jsp"%>
<!DOCTYPE html>
<head>
<meta charset="utf-8" />
<title>菜单管理</title>
</head>

<body>
	<form action="${ctx }/menu/list.do" id="submit-form">
	<div class="page-body">
		<div class="row">
			<div class="col-xs-12 col-md-12">
				<div class="widget">
					<div class="widget-header ">
						<span class="widget-caption">菜单管理</span>
					</div>
					<div class="widget-body">
                        <div class="controls">
                             <div class="input-group">
                             	<a id="editabledatatable_new" class="btn btn-default" href="${ctx }/menu/add.do">添加菜单 </a>
								<%-- <input type="text" class="form-control" style="width:200px;margin-right: 5px;" value="${bean.name }" name="name" placeholder="名称">
								<button type="submit" class="btn btn-default" style="height:34px" onClick="search()">搜索</button> --%>
                             </div>
                    	</div>
                    </div>
                    
                     
						<table class="table table-striped table-bordered table-hover"
							id="simpledatatable">
							<thead>
								<tr>								   
								 	<th>编号</th>
								 	<th>菜单名称</th>
								 	<th>url</th>
								 	<th>父级菜单</th>
								 	<th>创建时间</th>
								 	<th>操作</th>
								</tr>
							</thead>
							<tbody>
								<c:forEach items="${pagination.rows }" var="item">                                      	   
                                   <tr>
	                                 <td>${item.id }</td>   
	                                 <td>${item.name }</td>
								 	 <td>${item.url }</td>   
								 	 <td>${item.parentName }</td>
								 	 <td>	
										<fmt:formatDate value="${item.creationTime }" type="date" pattern="yyyy-MM-dd HH:mm" />                                           
                             		 </td>                              
                             		 <td>                             
				                         <a href="javascript:void(0)" class="btn btn-info btn-xs edit" onclick="edit('user','${item.id}')"><i class="fa fa-edit"></i>编辑</a>
				                         <a href="javascript:void(0)" class="btn btn-danger btn-xs delete" onclick="del('user','${item.id}')"><i class="fa fa-trash-o"></i>删除</a>
	                                 </td>
                                   </tr>
                                </c:forEach>
							</tbody>
						</table>
						<%@include file="../commons/page.jsp"%>
					</div>
				</div>
			</div>
		</div>
	</form>
<script src="${ctx }/js/menu/list.js"></script>
</body>
<script type="text/javascript">
	function search(){
		$("#submit-form").submit();
	}
	
</script>
</html>