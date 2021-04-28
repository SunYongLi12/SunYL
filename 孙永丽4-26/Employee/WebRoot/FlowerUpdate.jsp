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
			<label class="layui-form-label">花名</label>
			<div class="layui-input-inline">
				<input type="text" name="flower" id="flower"
					lay-verify="required" placeholder="请输入花名" autocomplete="off"
					class="layui-input">
			</div>
		</div>

		<div class="layui-form-item">
			<button class="layui-btn layui-btn-fluid" id="s"
				lay-filter="addUser">修改</button>
		</div>

	</form>
	<script type="text/javascript" src="<%=basePath %>/common/layui/layui.js"></script>
	<script type="text/javascript" src="<%=basePath%>/static/js/jquery-1.12.4.js"></script>
	<script type="text/javascript" src="<%=basePath%>/static/js/FlowerUpdate.js"></script>
	
	
</body>
</html>
