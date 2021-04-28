<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
<head>
<base href="<%=basePath%>">

<title>My JSP 'FloInsert.jsp' starting page</title>

<meta http-equiv="pragma" content="no-cache">
<meta http-equiv="cache-control" content="no-cache">
<meta http-equiv="expires" content="0">
<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
<meta http-equiv="description" content="This is my page">
<!--
	<link rel="stylesheet" type="text/css" href="styles.css">
	-->

<link rel="stylesheet" href="<%=basePath%>/common/layui/css/layui.css" />



</head>

<body>
	<form>
		<div class="layui-form-item">
			<label class="layui-form-label">新花名</label>
			<div class="layui-input-inline">
				<input type="text" name="flowername" id="flowername"
					lay-verify="required" placeholder="请输入新花名" autocomplete="off"
					class="layui-input">
			</div>
		</div>
		
		<div class="layui-form-item layui-row layui-col-xs12">
			<div class="layui-input-block">
				<button class="layui-btn layui-btn-lg" id="menuAjax">新增花类</button>
			</div>
		</div>
		
	</form>
	
	<script type="text/javascript" src="<%=basePath%>/common/layui/css/layui-v2.5.5/layui.all.js"></script>
	<script type="text/javascript" src="<%=basePath%>/static/js/jquery-1.12.4.js"></script>
	<script type="text/javascript" src="<%=basePath%>/static/js/flowerInsert.js"></script>
	
</body>
</html>
