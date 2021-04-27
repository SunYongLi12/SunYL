<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%
	String path = request.getContextPath();
	String basePath = request.getScheme() + "://" + request.getServerName() + ":" + request.getServerPort()
			+ path + "/";
%>
<!DOCTYPE html>
<html>
<head>
<meta charset="utf-8">
<title>修改权限</title>
<meta name="renderer" content="webkit">
<meta http-equiv="X-UA-Compatible" content="IE=edge,chrome=1">
<meta name="viewport"
	content="width=device-width, initial-scale=1, maximum-scale=1">
<meta name="apple-mobile-web-app-status-bar-style" content="black">
<meta name="apple-mobile-web-app-capable" content="yes">
<meta name="format-detection" content="telephone=no">
<link rel="stylesheet" href="<%=basePath%>/common/layui/css/layui.css" />
<script type="text/javascript"
	src="<%=basePath%>/common/layui/css/layui-v2.5.5/layui.all.js"></script>
<script type="text/javascript"
	src="<%=basePath%>/static/js/jquery-1.12.4.js"></script>
</head>
<body class="childrenBody">
	<div class="layui-form">
		<!-- 编号 -->
		<div class="layui-form-item layui-row layui-col-xs12"
			style="display: none;">
			<label class="layui-form-label">编号</label>
			<div class="layui-input-block">
				<input type="text" class="layui-input userName" id="id" disabled=""
					lay-verify="uname" placeholder="编号">
			</div>
		</div>
		<!--权限名 -->
		<div class="layui-form-item layui-row layui-col-xs12">
			<label class="layui-form-label">权限名</label>
			<div class="layui-input-block">
				<input type="text" class="layui-input userName" id="mname"
					lay-verify="uname" placeholder="请输入权限名">
			</div>
		</div>
		<!-- 请求的路径 -->
		<!-- <div class="layui-form-item layui-row layui-col-xs12">
		<label class="layui-form-label">父级id</label>
		<div class="layui-input-block">
			<input type="text" class="layui-input userName" id="parentid" lay-verify="uname" placeholder="请输入请求标识">
		</div>
	</div> -->
		<!-- 选择类型 -->
		<div class="layui-form-item layui-row layui-col-xs12">
			<label class="layui-form-label">选择类型</label>
			<div class="layui-input-block">
				<select name="mtype" id="type2" lay-filter="type2">
					<option value="0">-- 请选择 --</option>
					<option value="1">-- 菜单 --</option>
					<option value="2">-- 目录 --</option>
					<option value="3">-- 按钮 --</option>
				</select>
			</div>
		</div>
		<div class="layui-form-item layui-row layui-col-xs12" id="btnclss"
			style="display:none">
			<!-- 按钮样式 -->
			<div class="layui-form-item layui-row layui-col-xs12">
				<label class="layui-form-label">按钮样式</label>
				<div class="layui-input-block" id="btnType"></div>
			</div>
		</div>
		<!-- 按钮代码 -->
		<div class="layui-form-item layui-row layui-col-xs12">
			<label class="layui-form-label">执行体</label>
			<div class="layui-input-block" id="btnHtml">
				<input type="text" class="layui-input userName" id="mbtn"
					placeholder="请输入执行的方法体">
			</div>
		</div>
		<div class="layui-form-item layui-row layui-col-xs12">
			<label class="layui-form-label">当前上级</label>
			<div class="layui-input-block">
				<input type="text" class="layui-input userName" readonly
					id="fatherType2" placeholder="上级权限名">
			</div>
		</div>
		<!-- 属于哪一级 -->
		<div class="layui-form-item layui-row layui-col-xs12" id="fatherclass">
			<label class="layui-form-label">修改上级</label>
			<div class="layui-input-block">
				<select name="father" id="father" lay-filter="father">

				</select>
			</div>
		</div>
		<!-- 提交 -->
		<div class="layui-form-item layui-row layui-col-xs12">
			<div class="layui-input-block">
				<button class="layui-btn layui-btn-lg" id="menuAjax">修改权限</button>
			</div>
		</div>
	</div>
	<script type="text/javascript"
		src="common/layui/css/layui-v2.5.5/layui.js"></script>
	<script type="text/javascript"
	src="<%=basePath%>/static/js/MenuUpdate.js"></script>
</body>
</html>