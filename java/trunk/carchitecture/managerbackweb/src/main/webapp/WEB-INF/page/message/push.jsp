<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%-- <%@include file="../commons/commons.jsp"%> --%>
<html>
<head>
    <meta charset="UTF-8">
    <title>Document</title>
    <style>
        .box{
            width: 1000px;
            margin: 0 auto;
            border: 1px solid #000;
        }
        .box > div{
            width: 100%;
        }
        .box > div > label{
            text-align: center;
            display: block;
        }
        .box > div.title > label{
            text-align: center;
            display: block;
            float: left;
            width: 20%;
            height: 50px;
            line-height: 50px;
        }
        .box > div.title > textarea{
            width: 80%;
            resize: vertical;
            min-height: 50px;
            height: 50px;
            overflow-y: hidden;
        }
        .box > div.title1 > label{
            text-align: center;
            display: block;
            float: left;
            width: 20%;
            height: 20px;
            line-height: 20px;
        }
        .box > div.title1 > div{
            width: 80%;
            resize: vertical;
            height: 20px;
            overflow-y: hidden;
            float: left;
        }
        .box > div.title > select{
            width: 80%;
            resize: vertical;
            height: 50px;
            overflow-y: hidden;
            float: left;
        }
        .submit{
            height: 50px;
            text-align: center;
            line-height: 50px;
        }
        .submit >span{
            cursor: pointer;
            border-radius:  10px;
            border: 1px solid #000;
            padding: 5px;    
        }
    </style>
</head>
<body>
    <div class="box">
        <div><label for="">消息推送</label></div>
        <div class="title">
            <label for="">APP</label>
            <select>
              <option value ="突发新闻1">突发新闻1</option>
              <option value ="突发新闻2">突发新闻2</option>
              <option value="突发新闻3">突发新闻3</option>
              <option value="突发新闻4">突发新闻4</option>
            </select>
        </div>
        <div class="title">
            <label for="">通知内容</label>
            <textarea name="" id="" cols="30" rows="10"></textarea>
        </div>
        <div class="title">
            <label for="">IOS推送环境</label>
            <select>
              <option value ="测试环境1">测试环境</option>
              <option value ="测试环境2">测试环境</option>
              <option value="测试环境3">测试环境</option>
              <option value="测试环境4">测试环境</option>
            </select>
        </div>
        <div class="title">
            <label for="">消息内容</label>
            <textarea name="" id="" cols="30" rows="10"></textarea>
        </div>
        <div class="title">
            <label for="">MSG</label>
            <textarea name="" id="" cols="30" rows="10"></textarea>
        </div>
        <div class="title">
            <label for="">URl</label>
            <textarea name="" id="" cols="30" rows="10"></textarea>
        </div>
        <div class="title">
            <label for="">标识属性名称</label>
            <textarea name="" id="" cols="30" rows="10"></textarea>
        </div>
        <div class="title1">
            <label for="">推送平台</label>
            <div>
                <input type="radio" name='1'>全部
                <input type="radio" name='1'>安卓
                <input type="radio" name='1'>ios
            </div>
        </div>
        <div class="title">
            <label for="">推送目标(设备id)</label>
            <textarea name="" id="" cols="30" rows="10"></textarea>
        </div>
        <div class="title">
            <label for="">历史记录(只保存上次推送信息)</label>
            <textarea name="" id="" cols="30" rows="10"></textarea>
        </div>
        <div class="title">
            <label for="">上次推送</label>
            <textarea name="" id="" cols="30" rows="10"></textarea>
        </div>
        <div class="title">
            <label for="">时间</label>
            <textarea name="" id="" cols="30" rows="10"></textarea>
        </div>
        <div class="title">
            <label for="">通知内容</label>
            <textarea name="" id="" cols="30" rows="10"></textarea>
        </div>
        <div class="submit">
            <span>推送</span>
        </div>
    </div>
</body>
</html>