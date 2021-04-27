<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<ul class="layui-nav layui-nav-tree" lay-filter="test">
	<c:forEach var="i" items="${list}">
		<li class="layui-nav-item layui-nav-itemed">
		<c:if test="${i.type == 1}">
				<a class="" href="javascript:;">${i.mname}</a>
				<dl class="layui-nav-child">
					<c:forEach var="n" items="${list}">
						<c:if test="${n.parentid == i.id}">
							<dd>
								<a href="javascript:;" id="aa"
									onclick="sidebar('${n.id}','${n.url}')">${n.mname}</a>
							</dd>
						</c:if>
					</c:forEach>
				</dl>
			</c:if>
		</li>
	</c:forEach>
</ul>
