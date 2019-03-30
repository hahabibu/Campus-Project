<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<%@ taglib uri="http://displaytag.sf.net" prefix="display"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<html>
<head>
<meta charset="utf-8">
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<title>首页</title>
<!-- 引入相关的文件 -->
<%@include file="/pms/public/commons.jspf"%>
</head>

<body>
	<div style="padding: 0px; margin: 0px;">
		<ul class="breadcrumb" style="margin: 0px;">
			<li><a href="#">系统管理</a></li>
			<li>角色变更</li>
		</ul>
	</div>
	<script type="text/javascript">
		function query(condition) {
			$("#keyword").attr("name", condition.value);
		}
	</script>
	<form class="form-inline"
		action="${pageContext.request.contextPath }/system/roleinfo/listUserRoleInfo.action">
		<div class="row alert alert-info" style="margin: 0px; padding: 3px;">
			<div class="col-sm-1">条件:</div>
			<div class="col-sm-3">
				<select class="form-control  input-sm" onchange="query(this)"
					name="condition">
					<option value="">请选择查询条件</option>
					<option value="userName">用户名称</option>
					<option value="phone">联系方式</option>
				</select>
			</div>
			<div class="col-sm-3">
				<input type="text" id="keyword" class="form-control input-sm" />
			</div>
			<input type="submit" class="btn btn-danger" value="查询" />
		</div>
	</form>
	
	<!-- 提示信息 -->
	<div align="center">
		<div class="alert alert-warning"
			style="margin: 0px; padding: 5px; width: 80%;display:${empty info?'none':'block'} ">
			<button type="button" class="close" data-dismiss="alert">
				<span aria-hidden="true">&times;</span>
			</button>
			<p align="center" style="color: red;">用户角色变更-${info}</p>
		</div>
	</div>

	<script type="text/javascript">
		function setUserId(userId){
			$("#userId").val(userId);
		}
		/* function setRoleId(){
			$("#roleId").attr("value",condition.value);
		} */
		/* function doSubmit(){
			alert('roleId封装:'+condition.value);
			$("#roleId").attr("value",condition.value);
			// return true;
		} */
	</script>
	<!-- 角色变更模态弹出框 -->
	<form method="post" action="${pageContext.request.contextPath }/system/roleinfo/updateUserRoleInfo.action" class="form-inline">
		<input type="hidden" id="userId" name="userId"/>
		<!-- <input type="hidden" id="roleId" name="roleId"/> -->
		<!--a.声明模态框-->
		<div class="modal fade" id="myModal" role="dialog">
			<!--b.声明模态框的窗口-->
			<div class="modal-dialog" role="document">
				<!--c.声明模态框的内容-->
				<div class="modal-content">
					<!--模态框的内容1：头部标题-->
					<div class="modal-header">
						<div class="close" data-dismiss="modal">&times;</div>
						<h4 class="modal-title">角色变更</h4>
					</div>
					<!--模态框的内容2：body-->
					<div class="modal-body">
						<div class="row">
							<div class="col-md-4">
								<select name="roleId">
									<c:forEach var="roleInfo" items="${roleInfoList }">
										<option value="${roleInfo.roleId }">${roleInfo.roleName }</option>
									</c:forEach>
								</select>
							</div>
							<!-- <div class="col-md-4">内容2</div> -->
							<!-- <div class="col-md-4">内容3</div> -->
						</div>
					</div>
					<!--模态框的内容3:footer脚注-->
					<div class="modal-footer">
						<!-- <button class="btn btn-info">保存修改</button>
						<button class="btn btn-default">关闭</button> -->
						<input type="submit" class="btn btn-info" value="保存修改"/>
					</div>
				</div>
			</div>
		</div>
	</form>

	<%-- <div class="row" style="padding: 15px; padding-top: 0px;">
			<display:table class="table  table-condensed table-striped"
				name="list" pagesize="10"
				requestURI="${pageContext.request.contextPath }/user/userinfo/listUserRoleInfo.action">
				<display:column property="userId" title="用户编号"></display:column>
				<display:column property="userName" title="用户名称"></display:column>
				<display:column property="email" title="电子邮箱"></display:column>
				<display:column property="phone" title="联系方式"></display:column>
				<display:column property="idcard" title="身份证号"></display:column>
				<display:column property="userState" title="用户状态"></display:column>
				<display:column property="userStateContext" title="用户状态"></display:column>
				<display:column property="createTime" title="注册时间"
					format="{0,date,yyyy年MM月dd日}"></display:column>
				<display:column property="roleId" title="用户角色"></display:column>
				<display:column property="roleName" title="用户角色"></display:column>
				<display:column property="department" title="所属部门"></display:column>
				<display:column property="departmentContext" title="所属部门"></display:column>

				<display:column
					href="${pageContext.request.contextPath }/system/roleinfo/updateUserRoleInfo.action"
					paramId="userId" paramProperty="userId" value="角色变更" title="操作"></display:column>
			</display:table>
		</div> --%>

	<div class="row" style="padding: 15px; padding-top: 0px;">
		<table class="table  table-condensed table-striped">
			<tr>
				<!-- <th>用户编号</th> -->
				<th>用户名称</th>
				<th>电子邮箱</th>
				<th>联系方式</th>
				<th>身份证号</th>
				<th>用户状态</th>
				<th>注册时间</th>
				<th>修改时间</th>
				<th>用户角色</th>
				<th>所属部门</th>
				<th>操作</th>
			</tr>
			<c:forEach var="userInfo" items="${list }">
				<tr>
					<%-- <td>${userInfo.userId }</td> --%>
					<td>${userInfo.userName }</td>
					<td>${userInfo.email }</td>
					<td>${userInfo.phone }</td>
					<td>${userInfo.idcard }</td>
					<td>${userInfo.userStateContext }</td>
					<td><fmt:formatDate type="both"
							value="${userInfo.createTime }" /></td>
					<td><fmt:formatDate type="both"
							value="${userInfo.modifiedTime }" /></td>
					<td>${userInfo.roleName }</td>
					<td>${userInfo.departmentContext }</td>
					<th>
						<!-- <a href="user_update.html">角色变更</a> -->
						<button type="button" onclick="setUserId('${userInfo.userId }')" class="btn btn-info" data-toggle="modal"
							href="#myModal">角色变更</button>
					</th>
				</tr>
			</c:forEach>
		</table>
	</div>

</body>
</html>

