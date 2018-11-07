<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@include file="../commons/commons.jsp"%>
<!DOCTYPE html>
<head>
<meta charset="utf-8" />
<title>素材库管理</title>
</head>

<body>
	<form action="${ctx }/material/list.do?typeId=${typeId}" id="submit-form">
	<input type="hidden" name="typeId" value="${typeId}">
	<div class="page-body">
		<div class="row">
			<div class="col-xs-12 col-md-12">
				<div class="widget">
					<div class="widget-header ">
						<span class="widget-caption">${protype.name }素材</span>
					</div>
					<%-- <div class="widget-body">
                        <div class="controls">
                             <div class="input-group">
								<input class="form-control" style="width:200px;margin-right: 5px;"  name="name" value="${bean.content}">
									
								<button type="submit" class="btn btn-default" style="height:34px" onClick="search()">搜索</button>
                             </div>
                    	</div>
                    </div>	 --%>				                    
                      <div class="table-toolbar">
						<a id="editabledatatable_new" href="${ctx }/material/add.do?typeId=${typeId}"
							class="btn btn-default">添加${protype.name }素材</a>
					</div>
						<table class="table table-striped table-bordered table-hover"
							id="simpledatatable">
							<thead>
								<tr>
								    <th>编号</th>								   
									<th>标题</th>
									<th>内容</th>																									
									<th>操作</th>								
								</tr>
							</thead>
							<tbody>
								 
								 <c:forEach items="${pagination.rows }" var="item" varStatus="status">
								 
								 
								 <tr>
                                      	   <%--  <input type="hidden" name="id" value="${"lottery.openTime }"/> --%>
                                           
				                                 <td>${item.id }</td>                                  	 			                                   
			                                    <td><a href="${ctx }/materialImage/list.do?mId=${item.id}">${item.title }</a></td> 	
			                                    <%-- <td>${item.title }</td> --%>
			                                    <td>${item.content }</td>		                                    			                                                                                                                                     									                                                                                                        
                                            	<td>
		                                      	  	<a href="javascript:void(0)" class="btn btn-info btn-xs edit" onclick="edit('user','${item.id}')"><i class="fa fa-edit"></i>编辑</a>
		                              		   		<a href="javascript:void(0)" class="btn btn-danger btn-xs delete" onclick="del('user','${item.id}')"><i class="fa fa-trash-o"></i>删除</a>
                                      	  		</td>
                                            
                                          </tr>   
                                 </c:forEach>
                                
                                   
                                   
							</tbody>
						</table>
						 <a class="btn btn-palegreen" href="${ctx}/materiaType/list.do">返回</a>  
						<%@include file="../commons/page.jsp"%>
					</div>
				</div>
			</div>
		</div>
	</form>
<script src="${ctx }/js/material/list.js"></script>
</body>
<script type="text/javascript">
	function search(){
		$("#submit-form").submit();
	}
</script>
</html>