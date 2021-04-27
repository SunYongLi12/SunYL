<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%
	String path = request.getContextPath();
	String basePath = request.getScheme() + "://" + request.getServerName() + ":" + request.getServerPort()
			+ path + "/";
%>
<link rel="stylesheet" href="<%=basePath %>/common/layui/css/layui.css">
<script src="<%=basePath %>/common/layui/layui.js"></script>
<script type="text/javascript" src="<%=basePath %>/BackJs/jquery-1.12.4.js"></script>
<div style="width: 500px;">
	<form class="layui-form" action="javascript:void(0)" method="post">
		<div class="layui-form-item">
			<label class="layui-form-label">输入框</label>
			<div class="layui-input-block">
				<input type="text" name="name" id="name" required
					lay-verify="required" placeholder="请输入账号" autocomplete="off"
					class="layui-input">
			</div>
		</div>
		<div class="layui-form-item">
			<label class="layui-form-label">密码框</label>
			<div class="layui-input-block">
				<input type="password" name="pwd" id="pwd" required
					lay-verify="required" placeholder="请输入密码" autocomplete="off"
					class="layui-input">
			</div>
		</div>
		<div class="layui-form-item">
			<div class="layui-input-block">
				<button class="layui-btn" onclick="deng();" lay-submit lay-filter="formDemo">立即提交</button>
				<button type="reset" class="layui-btn layui-btn-primary">重置</button>
			</div>
		</div>
	</form>
	<script type="text/javascript" src="<%=basePath %>/Login.js"></script>
</div>

