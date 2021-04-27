<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<div id="AllPermissions">
	<div id="button" style="display: none;">
		<c:forEach var="a" items="${list}">
    		${a.mbtn}
		</c:forEach>
	</div>
	<table class="layui-hide" id="test" lay-filter="test"></table>
</div>
