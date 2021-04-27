<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%

String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>
<!DOCTYPE html>
<html>
<head>
	<meta charset="utf-8">
	<title>新增用户</title>
	<meta name="renderer" content="webkit">
	<meta http-equiv="X-UA-Compatible" content="IE=edge,chrome=1">
	<meta name="viewport" content="width=device-width, initial-scale=1, maximum-scale=1">
	<meta name="apple-mobile-web-app-status-bar-style" content="black">
	<meta name="apple-mobile-web-app-capable" content="yes">
	<meta name="format-detection" content="telephone=no">
	<link rel="stylesheet" href="<%=basePath %>/common/layui/css/layui-v2.5.5/css/layui.css" media="all" />
	<link rel="stylesheet" href="<%=basePath %>/common/layui/css/public.css" media="all" />
</head>
<body class="childrenBody">

<form class="layui-form">
	
	<!--权限名 -->
	<div class="layui-form-item layui-row layui-col-xs12">
		<label class="layui-form-label">NAME</label>
		<div class="layui-input-block">
			<input type="text" class="layui-input userName" id="mname" lay-verify="uname" placeholder="请输入权限名">
		</div>
	</div>
	<!-- 选择类型 -->
	<div class="layui-form-item layui-row layui-col-xs12">
		<label class="layui-form-label">TYPE</label>
		<div class="layui-input-block">
	      <select name="type" id="type2" lay-filter="type2">
	      	<option value="0">-- 请选择 --</option>
	        <option value="1">-- 目录 --</option>
	        <option value="2">-- 菜单 --</option>
	        <option value="3">-- 按钮 --</option>
	      </select>
	    </div>
	</div>
	<!-- 按钮样式 -->
	<div class="layui-form-item layui-row layui-col-xs12">
		<label class="layui-form-label">FID</label>
		<div class="layui-input-block">
		<select name="FID" lay-filter="type3"  id="FID">
			
	    </select>
	    </div>
	</div>
	
	<!-- 按钮样式 -->
	<div id="sty" class="layui-form-item layui-row layui-col-xs12" style="display:none;">
		<label class="layui-form-label">STYLE</label>
		<div class="layui-input-block" id="btnType">
		
	    </div>
	</div>
	<!-- 按钮代码 -->
	<div class="layui-form-item layui-row layui-col-xs12">
		<label class="layui-form-label">BTN</label>
		<div class="layui-input-block"  id="btnHtml">
	    	<input type="text" class="layui-input userName" id="mbtn" placeholder="请输入代码样式">
	    </div>
	</div>
	<!-- 请求地址servlet -->
	<div class="layui-form-item layui-row layui-col-xs12">
		<label class="layui-form-label">URL</label>
		<div class="layui-input-block">
			<input type="text" class="layui-input userName" id="murl" lay-verify="uname" placeholder="请输入请求路径">
		</div>
	</div>
	<!-- 请求js -->
	<div class="layui-form-item layui-row layui-col-xs12">
		<label class="layui-form-label">JS</label>
		<div class="layui-input-block">
			<input type="text" class="layui-input userName" id="mjs" lay-verify="uname" placeholder="请输入js路径">
		</div>
	</div>
	<!-- 提交 -->
	<div class="layui-form-item layui-row layui-col-xs12">
		<div class="layui-input-block">
			<button class="layui-btn layui-btn-lg" id="menuAjax" lay-submit lay-filter="menuUser">添加权限</button>
		</div>
	</div>
</form>
<script type="text/javascript" src="<%=basePath %>/common/layui/css/layui-v2.5.5/layui.js"></script>
<script type="text/javascript" src="<%=basePath %>/BackJs/jquery-1.12.4.js"></script>
<script type="text/javascript" src="<%=basePath %>/common/popjs/QXadd.js"></script>
</body>
</html>