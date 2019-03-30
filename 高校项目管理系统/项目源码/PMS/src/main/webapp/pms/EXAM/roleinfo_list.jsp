<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>
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
        <li>角色管理</li>
    </ul>
</div>
<div class="row alert alert-info"  style="margin:0px; padding:3px;" >
	<form class="form-horizontal" method="post" action="${pageContext.request.contextPath}/system/roleinfo/listRoleInfo.action">
		<div class="col-sm-1">角色名称:</div>
	    <div class="col-sm-3">
	    	<input type="text" name="roleName"  class="form-control input-sm"/>
	    </div>
	    <div class="col-sm-3">
	    	<input type="submit" class="btn btn-danger" value="查询"/>
	    	<input type="button" class="btn btn-success" value="添加" onClick="javascript:window.location='${pageContext.request.contextPath}/system/roleinfo/addRoleInfoUI.action'"/>
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
			<p align="center" style="color: red;">角色管理-${info}</p>
		</div>
	</div>
	
<div class="row" style="padding:15px; padding-top:0px; ">
	<table class="table  table-condensed table-striped">
    	<tr>
        	<th>角色编号</th>
            <th>角色名称</th>
            <th>创建时间</th>
            <th>修改时间</th>
            <th>角色描述</th>
             <th>操作</th>
        </tr>
       	<c:forEach var="roleInfo" items="${roleInfoList }">
       		<tr>
	        	<td>${roleInfo.roleId }</td>
	            <td>${roleInfo.roleName }</td>
	            <td><fmt:formatDate type="both" value="${roleInfo.createTime }" /></td>
	            <td><fmt:formatDate type="both" value="${roleInfo.modifiedTime }" /></td>
				<td title="${roleInfo.roleDescr }">${roleInfo.roleDescr }</td>
				<th>
					<a href="javascript:updateData('${roleInfo.roleId }')">修改</a>
					<%-- <a href="${pageContext.request.contextPath}/system/roleinfo/updateRoleInfoUI.action?roleInfo='${roleInfo.roleId }'">修改</a>  --%>
					<%-- <a href="${pageContext.request.contextPath}/system/roleinfo/deleteRoleInfo.action?roleInfo='${roleInfo.roleId }'">删除</a> --%>
					<a href="javascript:deleteData('${roleInfo.roleId }')">删除</a>
				</th>
	        </tr>
       	</c:forEach>
          
    </table>
</div>

	<script type="text/javascript">
		function deleteData(roleId) {
			alert(roleId);
			var url = "${pageContext.request.contextPath }/system/roleinfo/deleteRoleInfo.action?roleId=" + roleId;
			var info = window.confirm("您确认删除这条数据吗?");
			if (info) {
				/* window.location.href = "${pageContext.request.contextPath }/system/roleinfo/deleteRoleInfo.action?roleId="; */
 				 window.location.href = url; 
			}
		}
		
		function updateData(roleId) {
			alert(roleId);
			var url = "${pageContext.request.contextPath }/system/roleinfo/updateRoleInfoUI.action?roleId=" + roleId;
			/* window.location.href = "${pageContext.request.contextPath }/system/roleinfo/deleteRoleInfo.action?roleId="; */
 			window.location.href = url; 
		}
	</script>

</body>
</html>
