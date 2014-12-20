<%@include file="../include/common.jsp" %>
<%@ page contentType="text/html; charset=UTF-8" %>
<c:set var="_pageTitle" value="扣量" scope="request"/>
<c:set var="_underRate" value="active" scope="request"/>
<c:set var="_activeRate" value="active" scope="request"/>
<c:set var="_module" value="rate" scope="request"/>
<c:import url="../theme/${_theme}/header.jsp"></c:import>
<link rel="stylesheet" href="${basePath}static/jquery/jquery-ui.css" />
<!-- main content -->
		<div class="page-header"><h1>修改扣量</h1></div>
		<div id="pageContent">
			<c:import url="../theme/${_theme}/errors.jsp"></c:import>
			<form action="${basePath}rate/save" method="post" class="form-horizontal" enctype="multipart/form-data">
				<input name="id" type="hidden" value="${form.id}">
				<input name="_queryString" type="hidden" value="${param.queryString}">
                <div class="control-group required-field">
                    <label class="control-label">扣量率:</label>
                    <div class="controls">
                        <input name="info" value="${fn:escapeXml(form.info)}" type="text" class="input-large">
                        <span class="remark">小数，如：0.8</span>
                    </div>
                </div>
				<div class="form-actions">
				  <input class="btn btn-primary" type="submit" value="保存">
				  <button type="button" class="btn" onclick="javascript:history.go(-1)">取消</button>
				</div>
			</form>
        </div>
<!-- end main content -->
<c:import url="../theme/${_theme}/footer.jsp"></c:import>
<script src="${basePath}static/jquery/jquery-ui.js"></script>
