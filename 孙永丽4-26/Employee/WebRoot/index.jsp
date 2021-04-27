<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <base href="<%=basePath%>">
    
    <title>My JSP 'index.jsp' starting page</title>
	<meta http-equiv="pragma" content="no-cache">
	<meta http-equiv="cache-control" content="no-cache">
	<meta http-equiv="expires" content="0">    
	<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
	<meta http-equiv="description" content="This is my page">
	<!--
	<link rel="stylesheet" type="text/css" href="styles.css">
	-->
	<!-- <script type="text/javascript">
 		 var contextPath = "${ctx}";
	</script> -->
	<style type="text/css">
		.div{
			width:250px;
			height:100px;
			border:1px solid;
		}
	</style>
	
  </head>
  
  <body>
  <div class="div">
  	<form action="javaScript:void(0)" >
    	<input type="text" value="admin" name="usercode" class="usercode" /><br />
    	<input type="text" value="123" name="userpasswd" class="userpasswd" /><br />
    	<input type="button" value="登录"  id="LoginUser" />
    </form>
  </div>
  		<script type="text/javascript" src="<%=basePath%>/static/js/jquery-1.12.4.js"></script>
    	<script type="text/javascript" src="<%=basePath%>/static/js/login.js"></script>
  </body>
</html>
