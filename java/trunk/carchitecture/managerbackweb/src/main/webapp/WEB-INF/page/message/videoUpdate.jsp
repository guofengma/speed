<%@ page language="java" import="java.util.*" pageEncoding="UTF-8" contentType="text/html; charset=UTF-8" %>
<%-- <%@include file="/WEB-INF/web/comm/includeTld.jsp"%> --%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
<head>
<base href="<%=basePath%>">
      <title>视频编辑</title>
       <script type="text/javascript">
			var jsBasePath="<%=basePath%>";
	  </script>
	<script type="text/javascript" src="<%=basePath%>js/jquery-1.7.1.min.js"></script>  
	<script type="text/javascript" src="<%=basePath%>js/ajaxfileupload.js"></script>
 
    <script type="text/javascript" src="<%=basePath%>js/jquery.form.js"></script>
	<script type="text/javascript" src="<%=basePath%>js_jquery/interface/video.js"></script>  	
</head>

  <body leftmargin="0" topmargin="0">
  <div class="mian_content_righttitle">${requestScope.result}</div>
  <s:form  id="updatefromId"  name="updatefromId"  action="">

  <table width="950" border="1" cellpadding="0" cellspacing="0" bgcolor="#FFFFFF">
      <tr>
    <td height="62" colspan="8"><div id="message">
    </div></td>
    </tr>
      <tr>
      <td colspan="2"><div align="center">视频编辑</div></td>
    </tr>
    
    <tr>
      <td width="151">标　题</td>
      <td width="783"><input name="Title" type="text" id="Title" value="${video.title}"  size="52"  maxlength="70" /></td>
    </tr>
    <tr>
      <td width="151">副标题</td>
      <td width="783"><input name="subTitle" type="text" id="subTitle" value="${video.subtitle}"  size="92"  maxlength="200" /></td>
    </tr>
    <tr>
      <td><span class="hangj">标　　签：</span></td>
      <td><input name="tag" type="text" id="tag" size="92" value="${video.tag}" maxlength="200" /></td>
    </tr>
    <tr>
      <td height="30"><span class="hangj">类　　型：</span></td>
      <td>
        <c:choose>
          <c:when test='${video.typeName=="综合"}'  >
         <input name="isAuto" type="radio" value="综合"  checked="checked" />
综合
  <input type="radio" name="isAuto" value="新闻" />
新闻
<input type="radio" name="isAuto" value="娱乐" />
娱乐
<input type="radio" name="isAuto" value="体育" />
体育
<input type="radio" name="isAuto" value="军事" />
军事
<input type="radio" name="isAuto" value="综艺" />
综艺
<input type="radio" name="isAuto" value="电影" />
电影
<input type="radio" name="isAuto" value="电视剧" />
电视剧
<input type="radio" name="isAuto" value="财经" />
财经
<input type="radio" name="isAuto" value="少儿" />
少儿
          </c:when>
           <c:when test='${video.typeName=="新闻"}'  >
                  <input name="isAuto" type="radio" value="综合"  />
综合
  <input type="radio" name="isAuto" value="新闻"  checked="checked"/>
新闻
<input type="radio" name="isAuto" value="娱乐" />
娱乐
<input type="radio" name="isAuto" value="体育" />
体育
<input type="radio" name="isAuto" value="军事" />
军事
<input type="radio" name="isAuto" value="综艺" />
综艺
<input type="radio" name="isAuto" value="电影" />
电影
<input type="radio" name="isAuto" value="电视剧" />
电视剧
<input type="radio" name="isAuto" value="财经" />
财经
<input type="radio" name="isAuto" value="少儿" />
少儿
          </c:when>
           <c:when test='${video.typeName=="娱乐"}' >
                  <input name="isAuto" type="radio" value="综合"  />
综合
  <input type="radio" name="isAuto" value="新闻" />
新闻
<input type="radio" name="isAuto" value="娱乐" checked="checked" />
娱乐
<input type="radio" name="isAuto" value="体育" />
体育
<input type="radio" name="isAuto" value="军事" />
军事
<input type="radio" name="isAuto" value="综艺" />
综艺
<input type="radio" name="isAuto" value="电影" />
电影
<input type="radio" name="isAuto" value="电视剧" />
电视剧
<input type="radio" name="isAuto" value="财经" />
财经
<input type="radio" name="isAuto" value="少儿" />
少儿
          </c:when>
           <c:when test='${video.typeName=="体育"}'  >
                  <input name="isAuto" type="radio" value="综合"  />
综合
  <input type="radio" name="isAuto" value="新闻" />
新闻
<input type="radio" name="isAuto" value="娱乐" />
娱乐
<input type="radio" name="isAuto" value="体育" checked="checked"  />
体育
<input type="radio" name="isAuto" value="军事" />
军事
<input type="radio" name="isAuto" value="综艺" />
综艺
<input type="radio" name="isAuto" value="电影" />
电影
<input type="radio" name="isAuto" value="电视剧" />
电视剧
<input type="radio" name="isAuto" value="财经" />
财经
<input type="radio" name="isAuto" value="少儿" />
少儿
          </c:when>
           <c:when test='${video.typeName=="军事"}' >
                  <input name="isAuto" type="radio" value="综合"  />
综合
  <input type="radio" name="isAuto" value="新闻" />
新闻
<input type="radio" name="isAuto" value="娱乐" />
娱乐
<input type="radio" name="isAuto" value="体育" />
体育
<input type="radio" name="isAuto" value="军事" checked="checked"/>
军事
<input type="radio" name="isAuto" value="综艺" />
综艺
<input type="radio" name="isAuto" value="电影" />
电影
<input type="radio" name="isAuto" value="电视剧" />
电视剧
<input type="radio" name="isAuto" value="财经" />
财经
<input type="radio" name="isAuto" value="少儿" />
少儿
          </c:when>
         
           <c:when  test='${video.typeName=="综艺"}'  >
                  <input name="isAuto" type="radio" value="综合"  />
综合
  <input type="radio" name="isAuto" value="新闻" />
新闻
<input type="radio" name="isAuto" value="娱乐" />
娱乐
<input type="radio" name="isAuto" value="体育" />
体育
<input type="radio" name="isAuto" value="军事" />
军事
<input type="radio" name="isAuto" value="综艺"  checked="checked"/>
综艺
<input type="radio" name="isAuto" value="电影" />
电影
<input type="radio" name="isAuto" value="电视剧" />
电视剧
<input type="radio" name="isAuto" value="财经" />
财经
<input type="radio" name="isAuto" value="少儿" />
少儿
          </c:when>
           <c:when  test='${video.typeName=="电影"}' >
                  <input name="isAuto" type="radio" value="综合"  />
综合
  <input type="radio" name="isAuto" value="新闻" />
新闻
<input type="radio" name="isAuto" value="娱乐" />
娱乐
<input type="radio" name="isAuto" value="体育" />
体育
<input type="radio" name="isAuto" value="军事" />
军事
<input type="radio" name="isAuto" value="综艺" />
综艺
<input type="radio" name="isAuto" value="电影" checked="checked"/>
电影
<input type="radio" name="isAuto" value="电视剧" />
电视剧
<input type="radio" name="isAuto" value="财经" />
财经
<input type="radio" name="isAuto" value="少儿" />
少儿
          </c:when>
           <c:when test='${video.typeName=="电视剧"}'  >
                  <input name="isAuto" type="radio" value="综合"  />
综合
  <input type="radio" name="isAuto" value="新闻" />
新闻
<input type="radio" name="isAuto" value="娱乐" />
娱乐
<input type="radio" name="isAuto" value="体育" />
体育
<input type="radio" name="isAuto" value="军事" />
军事
<input type="radio" name="isAuto" value="综艺" />
综艺
<input type="radio" name="isAuto" value="电影" />
电影
<input type="radio" name="isAuto" value="电视剧" checked="checked"/>
电视剧
<input type="radio" name="isAuto" value="财经" />
财经
<input type="radio" name="isAuto" value="少儿" />
少儿
          </c:when>
         
           <c:when test='${video.typeName=="财经"}' >
                  <input name="isAuto" type="radio" value="综合"  />
综合
  <input type="radio" name="isAuto" value="新闻" />
新闻
<input type="radio" name="isAuto" value="娱乐" />
娱乐
<input type="radio" name="isAuto" value="体育" />
体育
<input type="radio" name="isAuto" value="军事" />
军事
<input type="radio" name="isAuto" value="综艺" />
综艺
<input type="radio" name="isAuto" value="电影" />
电影
<input type="radio" name="isAuto" value="电视剧" />
电视剧
<input type="radio" name="isAuto" value="财经" checked="checked"/>
财经
<input type="radio" name="isAuto" value="少儿" />
少儿
          </c:when>
      
           <c:when test='${video.typeName=="少儿"}' >
            <input name="isAuto" type="radio" value="综合"  />
综合
  <input type="radio" name="isAuto" value="新闻" />
新闻
<input type="radio" name="isAuto" value="娱乐" />
娱乐
<input type="radio" name="isAuto" value="体育" />
体育
<input type="radio" name="isAuto" value="军事" />
军事
<input type="radio" name="isAuto" value="综艺" />
综艺
<input type="radio" name="isAuto" value="电影" />
电影
<input type="radio" name="isAuto" value="电视剧" />
电视剧
<input type="radio" name="isAuto" value="财经" />
财经
<input type="radio" name="isAuto" value="少儿" checked="checked"/>
少儿
          </c:when>
          <c:otherwise>
     
      <input name="isAuto" type="radio" value="综合" checked="checked" />
综合
  <input type="radio" name="isAuto" value="新闻" />
新闻
<input type="radio" name="isAuto" value="娱乐" />
娱乐
<input type="radio" name="isAuto" value="体育" />
体育
<input type="radio" name="isAuto" value="军事" />
军事
<input type="radio" name="isAuto" value="综艺" />
综艺
<input type="radio" name="isAuto" value="电影" />
电影
<input type="radio" name="isAuto" value="电视剧" />
电视剧
<input type="radio" name="isAuto" value="财经" />
财经
<input type="radio" name="isAuto" value="少儿" />
少儿
         </c:otherwise>
        </c:choose>
      <input  id="isAutoValue" name="isAutoValue" value=""  type="text"  style="display:none"/></td>
    </tr>
     <tr>
      <td><span class="hangj">视频上传：</span></td>
      <td><input name="fileUpload" type="file"  id="videoUrl"   size="50" />
          <span class="text12">*支持格式(mp4)</span><input  id="videovalue" name="videovalue" value="${video.videourl}"  type="text"  style="display:none"/></td>
      <td width="8"></td>
    </tr>
    <tr>
      <td><span class="hangj">海　　报：</span></td>
      <td>
      <!-- <s:form action="interface/viode_uploadPic" method="post" id="myfrom" enctype="multipart/form-data">
        <input name="fileUpload" type="file"  id="fileUpload"  size="50" />
     
        <input class="sub" type="button" name="uploadId" id="uploadId" value="上传" />
        <span class="text12">*图片大小(120*90) </span>  <input  id="picvalue" name="picvalue"  type="text">11</input>
</s:form>  -->

        <input name="fileUpload" type="file"  id="fileUpload"    size="50" />
        <span class="text12">
        *选择图片格式为jpg/jpeg/png </span><input  id="picvalue" name="picvalue" value="${video.picurl}"  type="text"  style="display:none"/>
      </td>
    </tr>
    <tr>
      <td>&nbsp;</td>
      <td><img src="<%=basePath%>${video.picurl}" ></img></td>
    </tr>
    <tr>
      <td><span class="hangj">简　　介：</span></td>
      <td><textarea name="Introduction" id="Introduction" cols="100"   rows="10">${video.introduction}</textarea></td>
    </tr>

     <tr>
      <td>&nbsp;</td>
      <td>导演：
        <input name="filmDirector" type="text" id="filmDirector"  value="${video.director}"  size="22"  maxlength="50"/>
　主演/主持人：
<input name="filmPlayer" type="text" id="filmPlayer" size="42" value="${video.starring}"   maxlength="50"/></td>
    </tr>
    <tr>
      <td>&nbsp;</td>
      <td>是否连续发布：
      <c:choose>
          <c:when test="${video.isrelease==1}" >
           <input type="radio" name="Comments" value="1" checked="checked" />
        是
  <input type="radio" name="Comments" value="2"  />
        否
          </c:when>
          <c:otherwise>
      <input type="radio" name="Comments" value="1"  />
        是
  <input type="radio" name="Comments" value="2"  checked="checked" />
        否
         </c:otherwise>
        </c:choose>
        
       　 <input  id="CommentsValue" name="CommentsValue" value=""  type="text"  style="display:none"/> </td>
    </tr>
        <tr>
      <td colspan="2"><div align="center">
         <input type="hidden" name="videoId"  id="videoId" value="${video.videoId}"/>
          <input type="hidden" name="videoName"  id="videoName" value="${video.videoName}"/>
          <input class="sub2" type="submit" name="tiaojia" id="tiaojia"   value="更新" />
        　
  <input class="sub2" type="button" name="cancel" value="取消" />
      </div></td>
    </tr>

  </table>
  </s:form>
  <br>
  </body>
</html>
