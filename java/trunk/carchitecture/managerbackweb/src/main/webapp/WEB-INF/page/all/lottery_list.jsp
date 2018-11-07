<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@include file="../commons/commons.jsp"%>
<!DOCTYPE html>
<head>
<meta charset="utf-8" />
<title>彩票</title>

</head>
<!-- /Head -->
<!-- Body -->

<body>



	<!-- /Page Sidebar -->
	<!-- Page Content -->
	<form action="../lottery/list.do" id="formId">
	<input type="hidden" name="code" value="${code}"/>
	<div class="page-body">
		<div class="row">
			<div class="col-xs-12 col-md-12">
				<div class="widget">
					<div class="widget-header ">
						<span class="widget-caption">彩票</span>
					</div>
            <%--    <div class="controls">
	                   <div class="input-group">
	                       <span class="input-group-addon">
	                           <i class="fa fa-calendar"></i>
	                       </span><input class="form-control date-picker" style="width:200px" id="id-date-picker-1" type="text" name="time" value="${time }" data-date-format="yyyy-mm-dd"/>
	                   </div>
	               </div> --%>
					<div class="widget-body">
	                    <form class="form-inline" role="form" method="get">
	                        <div class="controls">
<!--                                  <div class="input-group"> -->
<!--                                      <span class="input-group-addon"> -->
<!--                                          <i class="fa fa-calendar"></i> -->
<!--                                      </span> -->
                                     
<!--                                      <input class="form-control date-picker" style="width:200px" id="id-date-picker-1" type="text" name="time1" value="${time }" data-date-format="yyyy-mm-dd"/> -->
<!--                                      <label>—to</label> -->
<!-- 									<input class="form-control date-picker2" style="width:200px" id="id-date-picker-2" type="text" name="time2" value="${time }" data-date-format="yyyy-mm-dd"/> -->
<!-- 									<button type="submit" class="btn btn-default" style="height:34px" onClick="search()">搜索</button> -->
<!--                                  </div> -->
                                 <div class="input-group">
                                     <span class="input-group-addon">
                                         <i class="fa fa-calendar"></i>
                                     </span>
                                     <input class="form-control date-picker" style="width:200px;margin-right: 5px;" id="id-date-picker-1" type="text" name="startTime" value="${startTime }" data-date-format="yyyy-mm-dd"/>
                                     <span style="position: relative;z-index: 2;float: left;margin-bottom: 0px;margin-top: 7px;margin-right: 5px;">—</span>
									<input class="form-control date-picker2" style="width:200px" id="id-date-picker-2" type="text" name="endTime" value="${endTime }" data-date-format="yyyy-mm-dd"/>
									<button type="submit" class="btn btn-default" style="height:34px" onClick="search()">搜索</button>
                                 </div>
                             </div>
	                       <%--  <div class="input-group">
	                            <input class="form-control date-picker" style="width:200px" id="id-date-picker-1" type="text" name="time" value="${time }" data-date-format="yyyy-mm-dd">
	                            <span  class="input-group-addon">
	                                <i class="fa fa-calendar"></i>
	                            </span>
	                      		<button type="submit" class="btn btn-default" onClick="search()">搜索</button>
	                        </div> --%>
	                    </form>
                    </div>
                     
						<table class="table table-striped table-bordered table-hover"
							id="simpledatatable">
							<thead>
								<tr>
									<th>时间</th>
									<th>期数</th>
									<th>开奖号码</th>
								</tr>
							</thead>
							<tbody>
								 <c:forEach items="${pagination.rows }" var="lottery">
                                      	   <%--  <input type="hidden" name="id" value="${"lottery.openTime }"/> --%>
                                            <tr>
	                                      	    <td>
	                                            	<fmt:formatDate value="${lottery.lotteryTime }" type="date" pattern="yyyy-MM-dd HH:mm" />
	                                            </td>
                                                <td>${lottery.number }</td>
                                                <td>${lottery.winningNumber }</td>
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
	<!-- /Page Container -->
	<!-- Main Container -->



</body>
<script type="text/javascript">
		jeDate({
		dateCell:".date-picker",//isinitVal:true,
	//	format:"YYYY-MM-DD",
		isTime:true, //isClear:false,
		minDate:"2014-09-19 00:00:00"
	})
		/* jeDate({
		dateCell:".date-picker2",//isinitVal:true,
		format:"YYYY-MM-DD",
		isTime:false, //isClear:false,
		minDate:"2014-09-19 00:00:00"
	}) */
	 jeDate({
		dateCell:".date-picker2",
		//isinitVal:true,
		isTime:true, 
		//isClear:true,
		minDate:"2014-09-19 00:00:00"
	})
	function search(){
// 		var temptime = $("#id-date-picker-1").val();
// 		$("#time").val(temptime);
		$("#formId").submit();
	}
	
</script>

<!--  /Body -->
</html>