<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@include file="../commons/commons.jsp"%>
<!DOCTYPE html>
<head>
<meta charset="utf-8" />
<title>用户管理</title>
</head>

<body>
	<form action="${ctx }/userMgt/list.do" id="submit-form">
	<div class="page-body">
		<div class="row">
			<div class="col-xs-12 col-md-12">
				<div class="widget">
					<div class="widget-header ">
						<span class="widget-caption">用户管理</span>
					</div>
					<div class="widget-body">
                        <div class="controls">
                             <div class="input-group">
								<input type="text" class="form-control" style="width:200px;margin-right: 5px;" value="${bean.phone }" name="phone" placeholder="手机号码">
								<button type="submit" class="btn btn-default" style="height:34px" onClick="search()">搜索</button>
                             </div>
                    	</div>
                    </div>
                     
						<table class="table table-striped table-bordered table-hover"
							id="simpledatatable">
							<thead>
								<tr>
									<th>手机号码</th>
									<th>用户号</th>
									<th>昵称</th>
									<th>性别</th>
									<th>生日</th>
									<th>最后登录时间</th>
									<th>注册时间</th>
								</tr>
							</thead>
							<tbody>
								 <c:forEach items="${pagination.rows }" var="item">
                                      	   <%--  <input type="hidden" name="id" value="${"lottery.openTime }"/> --%>
                                            <tr>
	                                      	    
                                                <td>${item.phone }</td>
                                                <td>${item.userCode }</td>
                                                <td>${item.nick }</td>
                                                <td>
                                                	<c:if test="${item.sex == 0}">女</c:if>
                                                	<c:if test="${item.sex == 1}">男</c:if>
                                               	</td>
                                                <td>
	                                            	<fmt:formatDate value="${item.birthday }" type="date" pattern="yyyy-MM-dd HH:mm" />
	                                            </td>
                                                <td>
	                                            	<fmt:formatDate value="${item.lastLoginTime }" type="date" pattern="yyyy-MM-dd HH:mm" />
	                                            </td>
                                                <td>
	                                            	<fmt:formatDate value="${item.createTime }" type="date" pattern="yyyy-MM-dd HH:mm" />
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

</body>
<script type="text/javascript">
	function search(){
		$("#submit-form").submit();
	}
	
</script>
</html>