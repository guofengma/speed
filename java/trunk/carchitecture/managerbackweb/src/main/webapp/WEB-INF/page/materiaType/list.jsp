<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@include file="../commons/commons.jsp"%>
<!DOCTYPE html>
<head>
<meta charset="utf-8" />
<title>类型管理</title>
</head>

<body>
	<form action="${ctx }/materiaType/list.do" id="submit-form">
	<div class="page-body">
		<div class="row">
			<div class="col-xs-12 col-md-12">
				<div class="widget">
					<div class="widget-header ">
						<span class="widget-caption">素材类型管理</span>
					</div>					                    
                      <div class="table-toolbar">
						<a id="editabledatatable_new" href="${ctx }/materiaType/add.do"
							class="btn btn-default">添加类型</a>
					</div>
						<table class="table table-striped table-bordered table-hover"
							id="simpledatatable">
							<thead>
								<tr>
								    <th>编号</th>
									<th>素材类型</th>									
									<th>操作</th>								
								</tr>
							</thead>
							<tbody>
								 <c:forEach items="${pagination.rows }" var="item">
                                      	   <%--  <input type="hidden" name="id" value="${"lottery.openTime }"/> --%>
                                            <tr>
	                                 <td>${item.id }</td>
                                     <td><a href="${ctx }/material/list.do?typeId=${item.id}">${item.name }</a> </td>                                    									
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
<script src="${ctx }/js/materiaType/list.js"></script>
</body>
<script type="text/javascript">
	function search(){
		$("#submit-form").submit();
	}
	
</script>
</html>