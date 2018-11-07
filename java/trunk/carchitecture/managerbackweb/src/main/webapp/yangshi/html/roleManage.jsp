<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@include file="../commons/commons.jsp"%>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <title>Document</title>
    <meta name="renderer" content="webkit">
    <meta http-equiv="X-UA-Compatible" content="IE=edge,chrome=1">
    <meta name="viewport" content="width=device-width, initial-scale=1, maximum-scale=1">
    <meta name="apple-mobile-web-app-status-bar-style" content="black">
    <meta name="apple-mobile-web-app-capable" content="yes">
    <meta name="format-detection" content="telephone=no">
    <link rel="stylesheet" href="../layui/css/layui.css" media="all" />
    <!--<link rel="stylesheet" type="text/css" href="http://www.jq22.com/jquery/font-awesome.4.6.0.css">-->
    <link rel="stylesheet" href="${ctx}/yangshi/libcss/public.css" />
    <link rel="stylesheet" href="${ctx}/yangshi/css/log.css" />
    <link rel="stylesheet" href="${ctx}/yangshi/icon/iconfont.css" />
    <link rel="stylesheet" href="${ctx}/yangshi/css/userManage.css" />
</head>
<body>
<div class="layui-content clearfix">
    <div class="unit-nav">
        <div>角色管理</div>
        <ul>
            <li class="active"><i class="layui-icon">&#xe617;</i> 系统角色</li>
        </ul>
    </div>
    <div class="layui-main-right fr clearfix">
        <div class="site-demo-button" style="width: 90%;margin-left: 20px;margin-top: 10px;">
            <button class="layui-btn layui-btn-normal" data-method="setTop" data-id="creatingRoles" id="creatingRoles" data-url="html/creatingRole.html"><i class="iconfont icon-iconjia" ></i>新建角色</button>
            <button class="layui-btn layui-btn-danger" id="del"><i class="iconfont icon-shanchu"></i>删除选中</button>
        </div>
        <table id="layui-table" class="layui-table" style="margin:20px auto;">
            <thead>
                <tr>
                    <th>角色名称</th>
                    <th>权限标识</th>
                    <th>状态</th>
                    <th>操作</th>
                </tr>
            </thead>
            <tbody>
                <tr>
                    <td>项目1</td>
                    <td>标识1</td>
                    <td><i class="iconfont icon-yuanxing red"></i></td>
                    <td>
                        <span>
                            <i class="iconfont icon-shezhi"></i><i class="iconfont icon-arrow"></i>
                        </span>
                    </td>
                </tr>
                <tr class="selected">
                    <td>项目1</td>
                    <td>标识2</td>
                    <td><i class="iconfont icon-yuanxing red"></i></td>
                    <td>
                        <span>
                            <i class="iconfont icon-shezhi"></i><i class="iconfont icon-arrow"></i>
                        </span>
                    </td>
                </tr>
                <tr>
                    <td>项目1</td>
                    <td>标识3</td>
                    <td><i class="iconfont icon-yuanxing red"></i></td>
                    <td>
                        <span>
                            <i class="iconfont icon-shezhi"></i><i class="iconfont icon-arrow"></i>
                        </span>
                    </td>
                </tr>   
                <tr>
                    <td>项目1</td>
                    <td>标识4</td>
                    <td><i class="iconfont icon-yuanxing red"></i></td>
                    <td>
                        <span>
                            <i class="iconfont icon-shezhi"></i><i class="iconfont icon-arrow"></i>
                        </span>
                    </td>
                </tr>   
                <tr>
                    <td>项目1</td>
                    <td>标识5</td>
                    <td><i class="iconfont icon-yuanxing red"></i></td>
                    <td>
                        <span>
                            <i class="iconfont icon-shezhi"></i><i class="iconfont icon-arrow"></i>
                        </span>
                    </td>
                </tr>
                <tr>
                    <td>项目1</td>
                    <td>标识6</td>
                    <td><i class="iconfont icon-yuanxing red"></i></td>
                    <td>
                        <span>
                            <i class="iconfont icon-shezhi"></i><i class="iconfont icon-arrow"></i>
                        </span>
                    </td>
                </tr>   
                <tr>
                    <td>项目1</td>
                    <td>标识7</td>
                    <td><i class="iconfont icon-yuanxing red"></i></td>
                    <td>
                        <span>
                            <i class="iconfont icon-shezhi"></i><i class="iconfont icon-arrow"></i>
                        </span>
                    </td>
                </tr>
                <tr>
                    <td>项目1</td>
                    <td>标识8</td>
                    <td><i class="iconfont icon-yuanxing red"></i></td>
                    <td>
                        <span>
                            <i class="iconfont icon-shezhi"></i><i class="iconfont icon-arrow"></i>
                        </span>
                    </td>
                </tr>   
                <tr>
                    <td>项目1</td>
                    <td>标识9</td>
                    <td><i class="iconfont icon-yuanxing red"></i></td>
                    <td>
                        <span>
                            <i class="iconfont icon-shezhi"></i><i class="iconfont icon-arrow"></i>
                        </span>
                    </td>
                </tr>   
                <tr>
                    <td>项目1</td>
                    <td>标识10</td>
                    <td><i class="iconfont icon-yuanxing red"></i></td>
                    <td>
                        <span>
                            <i class="iconfont icon-shezhi"></i><i class="iconfont icon-arrow"></i>
                        </span>
                    </td>
                </tr>                   
            </tbody>
        </table>
        <div id="page"><div class="layui-box layui-laypage layui-laypage-default" id="layui-laypage-1"><a href="javascript:;" class="layui-laypage-prev layui-disabled" data-page="0">上一页</a><span class="layui-laypage-curr"><em class="layui-laypage-em"></em><em>1</em></span><a href="javascript:;" data-page="2">2</a><a href="javascript:;" data-page="3">3</a><a href="javascript:;" data-page="4">4</a><a href="javascript:;" data-page="5">5</a><span class="layui-laypage-spr">…</span><a href="javascript:;" class="layui-laypage-last" title="尾页" data-page="150">150</a><a href="javascript:;" class="layui-laypage-next" data-page="2">下一页</a></div></div>
        <div id="pageTitle">
            显示第<i id="start">1</i>至<i id="end">10</i>条结果，共<i id="count">1500</i>条(每页显示10条)
        </div>
    </div>
</div>
<div id="check">
    <ul>
        <li>查看权限</li>
        <li>分配权限</li>
        <li>分配用户</li>
        <li>修改信息</li>
        <li>删除</li>
        <li>启用</li>
        <li>禁用</li>
    </ul>
</div>
 <div class="pfix rela usertit none">
    <!--基本信息框-->
    <div class="abso none" id="caidan">
        <div>
            <p> </p>
            <p> </p>
        </div>
        <div>
            <ul>
                <li>
                    <span>所属单位</span><span>123123</span>
                </li>
                <li>
                    <span>角色名称</span><span>大冬瓜</span>
                </li>
                <li>
                    <span>权限标识</span><span>asd12454cass</span>
                </li>
                <li>
                    <span>角色说明</span><span>最棒的单位</span>
                </li>
            </ul>
        </div>
        <div>
            <button class="layui-btn userTitNone" style="width: 200px;margin:20px 100px;">知道了</button>
        </div>
    </div> 
    <div class="abso none" id="amend">
        <div>
            <p> </p>
            <p> </p>
            <span class="close">X</span>
        </div>
        <div>
            <ul>
                <li>
                    <span>单位名称</span><input type="text" placeholder="请填写相关信息">
                </li>
                <li>
                    <span>所属单位</span><input type="text" placeholder="请填写相关信息">
                </li>
                <li>
                    <span>角色名称</span><input type="text" placeholder="请填写相关信息">
                </li>
                <li>
                    <span>权限标识</span><input type="text" placeholder="请填写相关信息">
                </li>
                <li>
                    <span>角色说明</span><input type="text" placeholder="请填写相关信息">
                </li>
            </ul>
        </div>
        <div>
            <button class="layui-btn amenduser" style="width: 200px;margin:20px 100px;">修改</button>
        </div>
    </div> 
 </div>
</body>
<script src="${ctx}/yangshi/layui/layui.js"></script>
<script src="${ctx}/yangshi/lib/jquery.min.js"></script>
<!-- <script src="../lib/Eject.js"></script> -->
<script>
    var start = null;
    var end = null;
    var count = 1500;
    var layer = null;
    $("#count").html(count);
    layui.use(['laypage','layedit'], function(){
      var laypage = layui.laypage,
      layer = layui.layer;
      //执行一个laypage实例
      laypage.render({
            elem: 'page' ,//注意，这里的 test1 是 ID，不用加 # 号
            count: count ,//数据总数，从服务端得到
            jump: function(obj, first){
            //obj包含了当前分页的所有参数，比如：
//          console.log(obj.curr); //得到当前页，以便向服务端请求对应页的数据。
//          console.log(obj.limit); //得到每页显示的条数
            start = obj.curr*10 - 9;
            end = obj.curr*10
//          console.log(start + end);
            $("#start").html(start);
            $("#end").html(end);
            //首次不执行
            if(!first){
            //do something
            }
        }
      });
    });


    $("#layui-table").on("click","tbody tr",function(){
        $(this).addClass("selected").siblings().removeClass("selected");
    });

    $("#del").on("click",function(){
        $.each($("#layui-table tbody tr"),function(i,ele){
            if ($(ele).hasClass("selected")) {
                if (confirm("是否删除")) {
                    $(ele).remove();
                }
            }
        })
    });

    $("#layui-table").on("click","tbody tr span",function(){
        $("#check").css({
            left:$(this).offset().left,
            top:$(this).offset().top + 25
        })
    });
    
    var checkpage = null;
    $("#layui-table").on("click","tbody tr span",function(event){
        checkpage = $(this).parents("tr").index();
        event.stopPropagation();
        $("#check").css({
            left:$(this).offset().left,
            top:$(this).offset().top + 25,
            display:"block"
        })
    });


    $("#check").on("click","ul li",function(){
        if ($(this).html() === '删除') {
            if (confirm("是否删除")) {
                $("#layui-table tbody tr").eq(checkpage).remove();
            }
        }else if($(this).html() === '启用'){
            $("#layui-table tbody tr").eq(checkpage).find(".icon-yuanxing").removeClass("red").addClass("green");
        }else if($(this).html() === '禁用'){
            $("#layui-table tbody tr").eq(checkpage).find(".icon-yuanxing").removeClass("green").addClass("red");
        }else if($(this).html() === '查看权限'){
           $("#caidan").show();
           $(".usertit").show();
        }else if($(this).html() === '修改信息'){
           $("#amend").show();
           $(".usertit").show();
        }
    })

    $(".userTitNone").click(function(){
        $("#caidan").hide();
        $(".usertit").hide();
    })

    $(".amenduser").click(function(){
        var inputs =$("#amend").find("ul li input");
        var unitsname = $.trim(inputs.eq(0).val());
        var name = $.trim(inputs.eq(1).val());
        var unitscode = $.trim(inputs.eq(2).val());
        var unitsintroduce = $.trim(inputs.eq(3).val());
        var unitssite = $.trim(inputs.eq(4).val());
        var unitsphone = $.trim(inputs.eq(5).val());
        if ( unitsname === '') {
            layer.alert('请填写单位名称', {
              title: '请填写相关信息'
            })
            return false;
        }
        if ( name === '') {
            layer.alert('请填写名称', {
              title: '请填写相关信息'
            })
            return false;
        }
        if ( unitscode === '') {
            layer.alert('请填写单位代码', {
              title: '请填写相关信息'
            })
            return false;
        }
        if ( unitsintroduce === '') {
            layer.alert('请填写单位介绍', {
              title: '请填写相关信息'
            })
            return false;
        }
        if ( unitssite === '') {
            layer.alert('请填写单位地址', {
              title: '请填写相关信息'
            })
            return false;
        }
        if ( unitsphone === '') {
            layer.alert('请填写单位手机', {
              title: '请填写相关信息'
            })
            return false;
        }
        $("#amend").hide();
        $(".usertit").hide();
    })


    $("#amend").on("click",".close",function(){
        $("#amend").hide();
        $(".usertit").hide();
    })




    $("body").click(function(){
        $("#check").hide();
    })

    $("#creatingRoles").click(function(){
        parent.parentaddtab($(this))
    })


</script>
</html>