<%@ include file="../../include/common.jsp"%>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<form id="toolbar_form" method="post" style="display: none">
	<c:forEach var="item" items="${query.items}">
		<input type="hidden" name="${item.name}" value="${item.value}"/>
	</c:forEach>
</form>
<c:if test="${param.create !=null}">
<input onclick="javascript:location.href='${param.create}'" type="button" class="btn" name="_action_create" value="创建">
</c:if>
<c:if test="${param.modify !=null}">
<input type="button" class="btn" onclick="javascript:doWithSingleItem('${param.modify}')" name="_action_modify" value="修改">
</c:if>
<c:if test="${param.delete !=null}">
<input type="button" class="btn" onclick="javascript:doWithMultiItem('${param.delete}','请确认是否要删除？')" name="_action_delete" value="删除">
</c:if>
<c:if test="${param.typeDelete !=null}">
<input type="button" class="btn" onclick="javascript:doWithMultiItemAjax('${param.typeDelete}','请确认是否要删除？');return false;" name="_action_type_delete" value="删除">
</c:if>
<c:if test="${param.goBack !=null}">
<input type="button" class="btn" onclick="javascript:doGoBack()" name="_action_go_back" value="返回">
</c:if>
<script>
	var toolbar_form=document.getElementById("toolbar_form");
	function getIds(){
		var id="";
		var ids=document.getElementsByName("ids");
		for(var i=0;i<ids.length;i++){
			if(ids[i].checked)
				id+=ids[i].value+"-"; 
		}
		if(id!="")
			id=id.substring(0,id.length-1);
		return id;
	}
	function getId(){
		var id=-1;
		var ids=document.getElementsByName("ids");
		for(var i=0;i<ids.length;i++){
			if(ids[i].checked){
				if(id==-1) 
					id=ids[i].value; 
				else 
					return -2;
			}
		} 
		return id;
	}
    function setQueryString(){
        var queryString="";
        $.each($("#search_form input"), function(i,param){
            if(param.type!="submit" && param.value!="")
                queryString+=param.name+"="+param.value+"&";
        });
        $.each($("#search_form select"), function(i,param){
            if(param.value!="")
                queryString+=param.name+"="+param.value+"&";
        });
        queryString+="_page="+$("#paginator .active a").html();
        $('<input />').attr('type', 'hidden')
                .attr('name', "queryString")
                .attr('value', encodeURI(queryString))
                .appendTo('#toolbar_form');
    }
    function selectSingleItems(){
        var id=getId();
        if(id==-1){
            alert("请选择相应的操作项！");
            return;
        }else if(id==-2){
            alert("只能选择一个操作项！");
            return;
        }
        return id;
    }
    function doWithNoneItem(path){
        toolbar_form.action=path;
        setQueryString();
        toolbar_form.submit();
    }
    function doWithSingleItem(path){
        var id=selectSingleItems();
        if(id){
            toolbar_form.action=path+"/"+id;
            setQueryString();
            toolbar_form.submit();
        }
    }
    function selectMultiItems(confirmMsg){
        var ids=getIds();
        if(ids==""){
            alert("请选择相应的操作项！");
            return;
        }
        if(confirmMsg && !confirm(confirmMsg)){
            return;
        }
        return ids;
    }
    function doWithMultiItem(path, confirmMsg){
        var ids=selectMultiItems(confirmMsg);
        if(ids){
            toolbar_form.action=path+"/"+ids;
            setQueryString();
            toolbar_form.submit();
        }
    }
    function doWithMultiItemAjax(path, confirmMsg){
        var ids=selectMultiItems(confirmMsg);
        if(ids){
            var request = $.ajax({
                type : "POST",
                url : path+"/"+id,
                data : {}
            });
            request.done(function(msg) {
                var result=eval(msg);
                if(result.success){
                    gotoPage($("#paginator .active a").html());
                }else{
                    alert(result.msg);
                }
            });
            request.fail(function(msg) {
                alert("服务器繁忙，请稍后再试!");
            });
        }
    }
    
    function buttonTest()
    {
    	//app = ygRSuGO+8Zatoynz6oRAU6HftVv+wLXdV0nKcOtDQmxgmeSrzOSeoV8TJMS0zZnQ2JerP9l93wOR4\\/BfXuLWjgfmryGgN+vmH7o64pMXoLM=
    	//pop = gAnztVPN3meJcOzLsr65uUtdsFq1Y18NfQrOIN8OQ31pg64sGksVZCbR7JjHfwS+fMHJ2lVYn6TyD2l14rfHmooJ+Sr4Xo95lLrKPLiBHy0Q2VpkqJs\\/mVVmocOcoOVKD\\/JuwJwBnPeqYJtAOHqaQmkIp4rpfc+XGro67pjpMdmffyKfXvpQ5KIfDoMAC9TVQkwlZPSNKHm/EHD0HtVkF4R6bcZkTmVY
    	//ygRSuGO+8ZY\\/tUyeJWidpnXB0mgqJe4tgCVgPCsN+KgoyjTTg6fGBLyMVZpoWmxgK1LxIueXeTuwr8ueFlJ3ScvS0BK+09soFg+J+QgNMF7M\\/Ltlgn7A0u6CCEhn7+sld2y1vcuAb1\\/M9iYCITxrvQ==
    	var data = {"data":"gAnztVPN3meJcOzLsr65uUtdsFq1Y18NfQrOIN8OQ31pg64sGksVZCbR7JjHfwS+fMHJ2lVYn6TyD2l14rfHmooJ+Sr4Xo95lLrKPLiBHy0Q2VpkqJs\\/mVVmocOcoOVKD\\/JuwJwBnPeqYJtAOHqaQmkIp4rpfc+XGro67pjpMdmffyKfXvpQ5KIfDoMAC9TVQkwlZPSNKHm/EHD0HtVkF4R6bcZkTmVY"}; 
    	 $.ajax({
    		 type: "POST",
    		 //contentType : 'application/json',
    		 //url: "/updateBrowerInfos",
    		 url: "${basePath}updatePopInfos",
    		 //url: "/downloadurl",
    		 data: data,
    		 dataType: 'json',
    		 success: function(data) {
    			if (data && data.txt)
    			{
    				alert(data.txt);	 
    			}
    			else
    			{
    				alert('no data return');
    			}
    		 }
    		 });
    }

</script>
<c:if test="${param.goBack !=null}">
<script>
function doGoBack(){
	var param="${param.goBack}";
	if(param=="true"){
		history.go(-1);
	}else{
		location.href=param;
	}
}
</script>
</c:if>