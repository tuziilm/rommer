<%@include file="../include/common.jsp" %>
<%@ page contentType="text/html; charset=UTF-8" %>
<c:set var="_pageTitle" value="扣量" scope="request"/>
<c:set var="_underRate" value="active" scope="request"/>
<c:set var="_activeRate" value="active" scope="request"/>
<c:set var="_module" value="rate" scope="request"/>
<c:import url="../theme/${_theme}/header.jsp"></c:import>
<script type="text/javascript" src="${basePath}static/theme/${_theme}/global.js"></script>
<!-- main content -->
		<div class="page-header"><h1>扣量列表</h1></div>
		<c:import url="../theme/default/name_search.jsp">
            <c:param name="action" value="${basePath}rate/list"/>
        </c:import>
        <br/><br/>
		<div id="list">
			<table class="table table-bordered table-striped">
				<c:choose>
					<c:when test="${not hasDatas}">
						<tr>
							<td>没有任务记录!</td>
						</tr>
					</c:when>
					<c:otherwise>
						<tr>
							<th></th>
							<th>编号</th>
							<th>扣量</th>
						</tr>
						<c:forEach var="data" items="${datas}" varStatus="it">
							<tr>
								<td class="checkbox_td">
									<input type="checkbox" name="ids" value="${data.id}"/>
								</td>
								<td>${fn:escapeXml(data.id)}</td>
								<td>${fn:escapeXml(data.info)}</td>
							</tr>
						</c:forEach>
					</c:otherwise>
				</c:choose>
			</table>
		</div>
		<div class="row-fluid">
			<div class="span4 toolbar">
				<c:import url="../theme/${_theme}/toolbar.jsp">
					<c:param name="create">${basePath}rate/create</c:param>
                    <c:param name="delete">${basePath}rate/delete</c:param>
					<c:param name="modify">${basePath}rate/modify</c:param>
				</c:import>
			</div>
			<div class="span8 paginator">
				<c:import url="../theme/${_theme}/paginator.jsp"></c:import>
			</div>
		</div>
<!-- end main content -->
<c:import url="../theme/${_theme}/footer.jsp"></c:import>