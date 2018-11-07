<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@include file="../commons/commons.jsp"%>
<!DOCTYPE html>
<head>
    <meta charset="utf-8" />
    <title>Data Tables</title>
</head>
<body >
<div class="page-body">
    <div class="row">
        <div class="col-xs-12 col-md-12">
            <div class="widget">
                <div class="widget-header ">
                    <span class="widget-caption">
        				分配菜单
                    </span>
                </div>
                <div class="widget-body" style="height: 1513px;">
	                <div class="col-lg-offset-4 col-lg-8">
	                    <a class="btn btn-palegreen" onclick="save()">保存</a>
	                    <a class="btn" href="${ ctx}/roleMgt/list.do">取消</a>
	                </div>
                    <form id="saveOrUpdate" class="form-horizontal form-bordered" role="form" enctype="multipart/form-data" method="post" action="${ ctx}/roleMgt/save_menu.do">
					<input type="hidden" value="${roleId }" name="roleId"/>
					<div>
						<c:forEach items="${menus}" var="menu">
							<div class="menuDiv">
								<h3>
									<div class="checkbox">
		                                <label>
		                                    <input type="checkbox" name="menuIds" <c:if test="${fn:contains(menuids,menu.id)}">checked</c:if> value="${menu.id }">
		                                    <span class="text">${menu.name }</span>
		                                </label>
		                            </div>
								</h3>
								<ul style="background: none;">
									<c:forEach items="${menu.list}" var="subMenu">
									   	<c:choose>
									   		<c:when test="${fn:length(subMenu.list) > 0}">
									   			<li class="subMenuClass subMenu_downBg"  style="background: none;color:black;margin-left:30px" value="${subMenu.id}">
												   	<div class="checkbox">
		                                                <label>
		                                                    <input type="checkbox" value="${subMenu.id }">
		                                                    <span class="text">${subMenu.name }</span>
		                                                </label>
		                                            </div>
												   	
												   	<c:forEach items="${subMenu.list}" var="tMenu">
													   	<li style="margin-left:50px">
													   		<div class="checkbox">
		                                                <label>
		                                                    <input name="menuIds" type="checkbox" value="${tMenu.id }" <c:if test="${fn:contains(menuids,tMenu.id)}">checked</c:if>>
		                                                    <span class="text">${tMenu.name }</span>
		                                                </label>
		                                            </div>
													   	</li>
													</c:forEach>
											   	</li>
									   		</c:when>
									   		<c:otherwise>
									   			<li style="margin-left:30px">
											   		<div class="checkbox">
		                                                <label>
		                                                    <input name="menuIds" type="checkbox" value="${subMenu.id }" <c:if test="${fn:contains(menuids,subMenu.id)}">checked</c:if>>
		                                                    <span class="text">${subMenu.name }</span>
		                                                </label>
		                                            </div>
											   	</li>
									   		</c:otherwise>
									   	</c:choose>
									</c:forEach>
								</ul>
							</div>
						</c:forEach>
					</div>
					<div>
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
		$("#saveOrUpdate").ajaxSubmit(function(result) {
			  if(result.status == 1){
				  window.location.href = '${ctx}' + "/roleMgt/list.do";
			  }else{
				  warningAlert(result.message[0].msg);
			  }
			});
		return false;
	}

</script>
</html>
