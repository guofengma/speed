<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%-- <%@include file="/WEB-INF/web/comm/includeTld.jsp"%> --%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
<head>
<base href="<%=basePath%>">
 
    
    <title>视频直播</title>
    
	<meta http-equiv="pragma" content="no-cache">
	<meta http-equiv="cache-control" content="no-cache">
	<meta http-equiv="expires" content="0">    
	<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
	<meta http-equiv="description" content="This is my page">
	<!--
	<link rel="stylesheet" type="text/css" href="styles.css">
	-->

  </head>
  
  <body>
   <div id="id_video_container" style="width:100%;height:1px;"></div>
<script src="http://qzonestyle.gtimg.cn/open/qcloud/video/live/h5/live_connect.js"></script>
 <script type="text/javascript">
            (function(){
               var option ={"channel_id":"16093104850682172482","app_id":"1251002029","width":"1024","height":"768"};
               new qcVideo.Player(
                       /*代码中的id_video_container将会作为播放器放置的容器使用,可自行替换*/
                       "id_video_container",
                       option
                   );
             })()
 </script>   
 </body>
 </html>

