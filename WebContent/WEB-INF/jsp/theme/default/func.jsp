<%@ include file="../../include/common.jsp"%>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<c:choose>
	<c:when test="${_module=='popInfo' }">
        <li class="${_underPop}"><a href="${basePath}popInfo/list">PopInfo列表</a></li>
    </c:when>
	<c:when test="${_module=='system' }">
		<c:if test="${rommer:isAdmin()}">
			<li class="${_underSysUser}"><a href="${basePath}sysuser/list">系统用户</a></li>
		</c:if>
		<li class="${_underUserInfo}"><a href="${basePath}sysuser/${isUnderUserInfo?'info_modify':'modify'}/${rommer:uid()}">信息修改</a></li>
	</c:when>
</c:choose>
