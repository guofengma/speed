<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%-- <%@include file="/WEB-INF/web/comm/includeTld.jsp"%> --%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<base href="<%=basePath%>">
      <script type="text/javascript">
			var jsBasePath="<%=basePath%>";
		</script>
    <title>API接口测试</title>
	<script type="text/javascript" src="<%=basePath%>js/jquery-1.7.1.min.js"></script>  
	<script type="text/javascript" src="<%=basePath%>js_jquery/interface/listCooperation.js"></script>  
    <script type="text/javascript" src="<%=basePath%>js_jquery/interface/push.js"></script>  
    <script type="text/javascript" src="<%=basePath%>js_jquery/interface/video.js"></script>  
      <script type="text/javascript" src="<%=basePath%>js_jquery/interface/redis.js"></script> 
    

  </head>
  
<body leftmargin="0" topmargin="0">
  <table width="1095" height="375" border="1" cellpadding="0" cellspacing="0" bgcolor="#FFFFFF">
    <tr>
    <td height="62" colspan="8"><div id="message">

    </div></td>
    </tr>
  <tr>
    <td width="97">
<input type="button" name="button" id="tijiao"  value="分页列表"></td>
     <td width="80"><input type="submit" name="button2" id="tokenBotton" value="上传token"></td>
    <td width="80"><input type="submit" name="button2" id="button2" value="消息提醒"></td>
    <td width="128"><input type="button" name="button3" id="pushButton" value="内容推送"></td>
    <td width="158"><input type="submit" name="videoButton" id="videoButton" value="视频播放列表 "></td>
    <td width="145"><a href="http://2356.liveplay.myqcloud.com/2356_a396c946021411e6b91fa4dcbef5e35a.m3u8"><input type="submit" name="videoButton" id="videoButton" value="视频直播"></a></td>
    <td width="149"><input type="button" name="redisConn" id="redisConn" value="redis连接 "></td>
    <td width="149"><input type="button" name="redisAdd" id="redisAdd" value="redis添加key "></td>
  
  
  </tr>
  <tr>
     <td width="149"><input type="button" name="redisget" id="redisget" value="redis获取keys "></td>
    <td>&nbsp;</td>
    <td>&nbsp;</td>
    <td>&nbsp;</td>
    <td>&nbsp;</td>
    <td>&nbsp;</td>
    <td>&nbsp;</td>
    <td>&nbsp;</td>
  </tr>
  <tr>
    <td>&nbsp;</td>
    <td>&nbsp;</td>
    <td>&nbsp;</td>
    <td>&nbsp;</td>
    <td>&nbsp;</td>
    <td>&nbsp;</td>
    <td>&nbsp;</td>
    <td>&nbsp;</td>
  </tr>
  <tr>
    <td>&nbsp;</td>
    <td>&nbsp;</td>
    <td>&nbsp;</td>
    <td>&nbsp;</td>
    <td>&nbsp;</td>
    <td>&nbsp;</td>
    <td>&nbsp;</td>
    <td>&nbsp;</td>
  </tr>
  <tr>
    <td>&nbsp;</td>
    <td>&nbsp;</td>
    <td>&nbsp;</td>
    <td>&nbsp;</td>
    <td>&nbsp;</td>
    <td>&nbsp;</td>
    <td>&nbsp;</td>
    <td>&nbsp;</td>
  </tr>
  <tr>
    <td>&nbsp;</td>
    <td>&nbsp;</td>
    <td>&nbsp;</td>
    <td>&nbsp;</td>
    <td>&nbsp;</td>
    <td>&nbsp;</td>
    <td>&nbsp;</td>
    <td>&nbsp;</td>
  </tr>
  <tr>
    <td>&nbsp;</td>
    <td>&nbsp;</td>
    <td>&nbsp;</td>
    <td>&nbsp;</td>
    <td>&nbsp;</td>
    <td>&nbsp;</td>
    <td>&nbsp;</td>
    <td>&nbsp;</td>
  </tr>
  <tr>
    <td>&nbsp;</td>
    <td>&nbsp;</td>
    <td>&nbsp;</td>
    <td>&nbsp;</td>
    <td>&nbsp;</td>
    <td>&nbsp;</td>
    <td>&nbsp;</td>
    <td>&nbsp;</td>
  </tr>
  <tr>
    <td>&nbsp;</td>
    <td>&nbsp;</td>
    <td>&nbsp;</td>
    <td>&nbsp;</td>
    <td>&nbsp;</td>
    <td>&nbsp;</td>
    <td>&nbsp;</td>
    <td>&nbsp;</td>
  </tr>
  <tr>
    <td>&nbsp;</td>
    <td>&nbsp;</td>
    <td>&nbsp;</td>
    <td>&nbsp;</td>
    <td>&nbsp;</td>
    <td>&nbsp;</td>
    <td>&nbsp;</td>
    <td>&nbsp;</td>
  </tr>
</table>
  </body>
</html>
