<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@include file="../commons/commons.jsp"%>
<!DOCTYPE html>
<head>
<meta charset="utf-8" />
<title>后台日志</title>
</head>

<body>
	<form action="${ctx }/Logrecord/list.do" id="submit-form">
	<div class="page-body">
		<div class="row">
			<div class="col-xs-12 col-md-12">
				<div class="widget">
					<div class="widget-header ">
						<span class="widget-caption">日志记录</span>
					</div>
					<div class="widget-body">
                       <!--  <div class="controls">
                             <div class="input-group">
								<input type="date"   name="staDate" placeholder="开始时间">
								<input type="date" class="form-control" style="width:200px;margin-right: 5px;"  name="endDate" placeholder="结束时间">
								<button type="submit" class="btn btn-default" style="height:34px" onClick="search()">搜索</button>
                             </div>
                    	</div> -->
                    </div>
                    
                     
						<table class="table table-striped table-bordered table-hover"
							id="simpledatatable">
							<thead>
								<tr>
								    <th>编号</th>
									<th>日志类型</th>
									<th>日志内容</th>
									<th>执行类</th>
									<th>操作人</th>
									<th>操作时间</th>																									
								</tr>
							</thead>
							<tbody>
								 <c:forEach items="${pagination.rows }" var="item" varStatus="sta">                                      	   
                                        <tr>
	                                 <td>${sta.index+1 }</td>
                                     <td>
                                     	<c:if test="${item.type==1 }">用户登录</c:if>
                                     	<c:if test="${item.type==2 }">用户退出</c:if>
                                     </td>
                                     <td>${item.content }</td>                                  
                                   <td>${item.makeClass }</td>
									<td>${item.makePeople }</td>
									<td><fmt:formatDate value="${item.makeTime }" type="date" pattern="yyyy-MM-dd HH:mm" /></td>									
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
<script src="${ctx }/js/logrecord/list.js"></script>
</body>
<script type="text/javascript">
	function search(){
		$("#submit-form").submit();
	}
	
</script>
</html>