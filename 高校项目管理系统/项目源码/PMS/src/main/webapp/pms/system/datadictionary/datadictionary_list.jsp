<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://displaytag.sf.net/el" prefix="display-el" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
	<meta charset="utf-8">
	<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
	<title>首页</title>
	<!-- 引入相关的文件 -->
    <%@include file="/pms/public/commons.jspf"%>
</head>

<body>
<div style="padding:0px; margin:0px;">
 <ul class="breadcrumb" style="  margin:0px; " >
    	<li><a href="#">系统管理</a></li>
        <li>数据字典</li>
    </ul>
</div>

<div class="row alert alert-info"  style="margin:0px; padding:3px;" >
	<form action="${pageContext.request.contextPath }/system/datadictionary/listDataDictionary.action" method="post" class="form-horizontal">
		<div class="col-sm-1">数据类型:</div>
	    <div class="col-sm-2">
	    	<input type="text" name="dataContent" class="form-control input-sm"/>
	    </div>
	    <div class="col-sm-2">
	    	<select name="dataType">
	    		<option value="-1">默认所有</option>
	    		<c:forEach var="dt" items="${dataTypeList }" >
	    			<option value="${dt }">${dt }</option>
	    		</c:forEach>
	    	</select>
	    </div>
	    <div class="col-sm-2">
	    	<input type="submit" class="btn btn-danger" value="查询"/>
	    	<a class="btn btn-success" href="${pageContext.request.contextPath }/system/datadictionary/addDataDictionaryUI.action">添加</a>
	    </div>
	</form>
</div>

	<!-- 提示信息 -->
	<div align="center">
		<div class="alert alert-warning"
			style="margin: 0px; padding: 5px; width: 80%;display:${empty info?'none':'block'} ">
			<button type="button" class="close" data-dismiss="alert">
				<span aria-hidden="true">&times;</span>

			</button>
			<p align="center" style="color: red;">数据字典管理-${info}</p>
		</div>
	</div>
	
<div class="row" style="padding:15px; padding-top:0px; ">
	<table class="table  table-condensed table-striped">
    	<tr>
        	<th>数据编号</th>
            <th>数据内容</th>
            <th>数据类型</th>
            <th>数据描述</th>
            <th>操作</th>
        </tr>
        <c:forEach var="dd" items="${dataDictionaryList }">
	       	<tr>
	        	<td>${dd.dataId }</td>
	            <td>${dd.dataContent }</td>
	            <td>${dd.dataType }</td>
	            <td>${dd.dataDescr }</td>
	            <th>
	            	<%-- <a href="${pageContext.request.contextPath }/system/datadictionary/updateDataDictionaryUI.action?dataId='${dd.dataId }'">修改</a> 
	            	<a href="${pageContext.request.contextPath }/system/datadictionary/deleteDataDictionary.action?dataId='${dd.dataId }'">删除</a> --%>
	            	<a href="javascript:updateData('${dd.dataId }')">修改</a>
	            	<a href="javascript:deleteData('${dd.dataId }')">删除</a>
	            </th>
	        </tr>
		</c:forEach>
    </table>
</div>

	<script type="text/javascript">
		function deleteData(dataId) {
			alert(dataId);
			var url = "${pageContext.request.contextPath }/system/datadictionary/deleteDataDictionary.action?dataId=" + dataId;
			var info = window.confirm("您确认删除这条数据吗?");
			if (info) {
 				 window.location.href = url; 
			}
		}
		
		function updateData(dataId) {
			alert(dataId);
			var url = "${pageContext.request.contextPath }/system/datadictionary/updateDataDictionaryUI.action?dataId=" + dataId;
 			window.location.href = url; 
		}
	</script>
</body>
</html>