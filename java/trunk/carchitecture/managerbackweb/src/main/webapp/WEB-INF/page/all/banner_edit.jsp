<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@include file="/WEB-INF/page/commons/commons.jsp"%>
<!DOCTYPE html>

<head>
    <meta charset="utf-8" />
    <title>Data Tables</title>

    
</head>
<!-- /Head -->
<!-- Body -->
<body>
  
                <!-- Page Body -->
                <div class="page-body">
                  
                    <div class="row">
                        <div class="col-xs-12 col-md-12">
                            <div class="widget">
                                <div class="widget-header ">
                                    <span class="widget-caption">编辑轮播</span>
                                   
                                </div>
                                <div class="widget-body">
                                    
                                    <form id="picUpload" class="form-horizontal form-bordered" role="form" enctype="multipart/form-data" method="post" action="${ pageContext.request.contextPath }/banner/update.do">
                                            <input type="hidden" name="id" value="${id }"/>
                                            <input type="hidden" name="type" value="pc">
                                            <div class="form-group">
                                                <label for="inputEmail3" class="col-sm-2 control-label no-padding-right">轮播名称</label>
                                                <div class="col-sm-10">
                                                    <input type="text" class="form-control" id="inputEmail3" name="showName" value="${banner.showName }" placeholder="轮播名称"
														data-bv-notempty="true"
                                                        data-bv-notempty-message="轮播名称不可为空"/>
                                                </div>
                                            </div>
                                            <div class="form-group">
                                                <label for="inputPassword3" class="col-sm-2 control-label no-padding-right">缩略图</label>
                                                <div class="col-sm-10">
                                                	<img width="100" height="100" id="allUrl" src="${banner.showImg }"/>
													<input type="hidden" name="showImg" value="${banner.showImg }" id="showImg"
															data-bv-notempty="true"
                                                         data-bv-notempty-message="缩略图不可为空"/>
                                                    <input type="file" name="img" class="form-control" id="inputPassword3"  onchange="uploadPic()" placeholder=""
                                                   		 />
                                                </div>
                                            </div>                                            
                                            <div class="form-group">
                                                <label for="inputPassword3" class="col-sm-2 control-label no-padding-right">链接地址</label>
                                                <div class="col-sm-10">
                                                    <input type="text" class="form-control" id="inputPassword3" name="showLink" value="${banner.showLink }" placeholder="链接地址"
                                                   			data-bv-notempty="true"
                                                            data-bv-notempty-message="链接地址不可为空"/>
                                                </div>
                                            </div>
                                            <div class="form-group">
                                                <label for="inputPassword3" class="col-sm-2 control-label no-padding-right">排序</label>
                                                <div class="col-sm-10">
                                                    <input type="text" class="form-control" id="inputPassword3" name="sort" value="${banner.sort }" placeholder="排序"
                                                    		data-bv-notempty="true"
                                                            data-bv-notempty-message="排序不可为空" />
                                                </div>
                                            </div>
                                            <div class="form-group">
                                                <div class="col-sm-offset-2 col-sm-10">
                                                    <button type="submit" class="btn btn-palegreen">提交</button>
                                                </div>
                                            </div>
                                        </form>
                                      
                                </div>
                            </div>
                        </div>
                    </div>
                </div>
                <!-- /Page Body -->
            </div>
            <!-- /Page Content -->
        </div>
        <!-- /Page Container -->
        <!-- Main Container -->

    </div>

</body>
<!--  /Body -->
 <script>
        $(document).ready(function () {
        
            $('#picUpload').bootstrapValidator();
            
        });
    </script>
</html>
