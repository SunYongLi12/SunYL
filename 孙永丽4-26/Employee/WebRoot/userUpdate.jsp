<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%
	String path = request.getContextPath();
	String basePath = request.getScheme() + "://" + request.getServerName() + ":" + request.getServerPort()
			+ path + "/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
<head>
<base href="<%=basePath%>">

<title>My JSP 'UserInsert.jsp' starting page</title>

<meta http-equiv="pragma" content="no-cache">
<meta http-equiv="cache-control" content="no-cache">
<meta http-equiv="expires" content="0">
<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
<meta http-equiv="description" content="This is my page">
<!--
	<link rel="stylesheet" type="text/css" href="styles.css">
	-->
<link rel="stylesheet" href="<%=basePath %>/common/layui/css/layui.css" />
</head>

<body>
	<form>
		<input type="hidden" name="id" id="id"
					lay-verify="required" autocomplete="off"
					class="layui-input">
		<div class="layui-form-item">
			<label class="layui-form-label">登录名</label>
			<div class="layui-input-inline">
				<input type="text" name="usercode" id="usercode"
					lay-verify="required" placeholder="请输入登录名" autocomplete="off"
					class="layui-input">
			</div>
		</div>

		<div class="layui-form-item">
			<label class="layui-form-label">用户名</label>
			<div class="layui-input-inline">
				<input type="text" name="username" id="username"
					lay-verify="required" placeholder="请输入用户名" autocomplete="off"
					class="layui-input">
			</div>
		</div>

		<div class="layui-form-item">
			<label class="layui-form-label">密码</label>
			<div class="layui-input-inline">
				<input type="text" name="password" id="password"
					placeholder="默认密码123456" value="123456" autocomplete="off"
					class="layui-input">
			</div>
		</div>

		<div class="layui-form-item">
			<label class="layui-form-label">手机号</label>
			<div class="layui-input-inline">
				<input type="text" name="phone" id="phone" lay-verify="required"
					placeholder="请输入手机号" autocomplete="off" class="layui-input">
			</div>
		</div>

		<div class="layui-form-item">
			<label class="layui-form-label">地址</label>
			<div class="layui-input-inline">
				<input type="text" name="address" id="address" lay-verify="required"
					placeholder="请输入地址" autocomplete="off" class="layui-input">
			</div>
		</div>

		<div class="layui-form-item">
			<label class="layui-form-label">角色</label>
			<div class="layui-input-inline">
				<select name="role" id="role" lay-filter="role1">
					<option value="请选择">请选择</option>
					<option value="1">系统管理员</option>
					<option value="2">经理</option>
					<option value="3">普通用户</option>
				</select>
			</div>
		</div>

		<div class="layui-form-item">
			<button class="layui-btn layui-btn-fluid" id="submit"
				lay-filter="addUser">修改用户</button>
		</div>

	</form>
	<script type="text/javascript" src="<%=basePath %>/common/layui/layui.js"></script>
	<script type="text/javascript" src="<%=basePath%>/static/js/jquery-1.12.4.js"></script>
	<script type="text/javascript" src="<%=basePath%>/static/js/userUpdate.js"></script>
	
	
</body>
</html>
