<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@include file="../commons/commons.jsp"%>
<!DOCTYPE html>
<head>
<meta charset="utf-8" />
<title>轮播列表</title>

</head>
<!-- /Head -->
<!-- Body -->
<body>



	<!-- /Page Sidebar -->
	<!-- Page Content -->
	<form action="../banner/list.do" id="formId">
		<div class="page-body">

			<div class="row">
				<div class="col-xs-12 col-md-12">
					<div class="widget">
						<div class="widget-body">
							<div class="table-toolbar">
								<a id="editabledatatable_new"
									href="${ pageContext.request.contextPath }/banner/add.do"
									class="btn btn-default"> 增加轮播 </a>
							</div>
							<table class="table" id="editabledatatable">
								<thead>
									<tr>
										<th>幻灯片名称</th>
										<th>幻灯片</th>
										<th>排序</th>
										<th>操作</th>
									</tr>
								</thead>
								<tbody>
									<c:forEach items="${pagination.rows }" var="banner">
										<input type="hidden" name="id" value="${banner.id }" />
										<tr>
											<td>${banner.showName }</td>
											<td><img width="40" height="40" src="${banner.showImg }" />
											</td>
											</td>
											<td>${banner.sort }</td>
											<td><a
												href="${ pageContext.request.contextPath }/banner/edit.do?id=${banner.id }"
												class="btn btn-info btn-xs edit"><i class="fa fa-edit"></i>
													编辑</a> <a
												href="${ pageContext.request.contextPath }/banner/delete.do?id=${banner.id }"
												class="btn btn-danger btn-xs delete"><i
													class="fa fa-trash-o"></i> 删除</a></td>
										</tr>
									</c:forEach>
								</tbody>
							</table>
							<%@include file="../commons/page.jsp"%>
						</div>
					</div>
				</div>
			</div>
		</div>
	</form>
	<!-- /Page Body -->
	<!-- /Page Container -->
	<!-- Main Container -->





</body>

<!--  /Body -->
</html>
