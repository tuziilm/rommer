<%@include file="../include/common.jsp" %>
<%@ page contentType="text/html; charset=UTF-8" %>
<c:set var="_pageTitle" value="销量统计" scope="request"/>
<c:set var="_underPop" value="active" scope="request"/>
<c:set var="_activePopInfo" value="active" scope="request"/>
<c:set var="_module" value="popInfo" scope="request"/>
<c:import url="../theme/${_theme}/header.jsp"></c:import>
<!-- main content -->
	<div class="page-header"><h1>销量统计</h1></div>
	<c:import url="search.jsp">
	</c:import>
		<div id="list">
			<table class="table table-bordered table-striped">
				<c:choose>
					<c:when test="${not hasDatas}">
						<tr>
							<td>没有记录!</td>
						</tr>
					</c:when>
					<c:otherwise>
						<tr>
							<th>客户channel</th>
							<th>国家</th>
                            <th>次数</th>
                            <th>日期</th>
						</tr>
						<c:forEach var="data" items="${datas}">
							<tr>
                                <td>${data.channel}</td>
                                <td>${countryMap[data.country].chineseName}</td>
								<td>${data.count}</td>
								<td>${data.lastShowAdDate}</td>
							</tr>
						</c:forEach>
					</c:otherwise>
				</c:choose>
			</table>
		</div>
		<div class="row-fluid">
            <div class="span4 toolbar">总数：${total}</div>
			<div class="span8 paginator">
				
				<c:import url="../theme/${_theme}/paginator.jsp"></c:import>
			</div>
		</div>
<!-- end main content -->
<c:import url="../theme/${_theme}/footer.jsp"></c:import>
<script src="${basePath}static/jquery/jquery-ui.js"></script>
<script src="${basePath}static/jquery/jquery.ui.datepicker-zh-TW.js"></script>
<script>
    $(function() {
    	$( "#startTime" ).datepicker( $.datepicker.regional[ "zh-TW" ] );
        $( "#endTime" ).datepicker( $.datepicker.regional[ "zh-TW" ] );
    });
</script>
