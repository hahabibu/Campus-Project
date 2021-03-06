<%--
  Created by IntelliJ IDEA.
  User: utry
  Date: 2018/12/11
  Time: 14:39
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java"%>
<%@ taglib uri="http://displaytag.sf.net" prefix="display"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
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
			<li><a href="#">申报管理</a></li>
			<li>申报进度</li>
		</ul>
	</div>

	<form class="form-inline" method="post"
		action="${pageContext.request.contextPath }/declare/declareinfo/listDeclareRecord.action">
		<div class="row alert alert-info" style="margin: 0px; padding: 3px;">
			<div class="col-sm-1">查找条件:</div>
			<!-- <div class="col-sm-4">
				<select name="processStatus" class="form-control  input-sm">
					<option value="pass">请选择记录处理状态</option> 
					<option value="0">已提交</option>
					<option value="1">已通过立项检查</option>
					<option value="-1">未通过立项检查</option>
					<option value="2">已通过中期检查</option>
					<option value="-2">未通过中期检查</option>
					<option value="3">已通过结题验收</option>
					<option value="-3">未通过结题验收</option>
				</select>
			</div> -->
			<div class="col-sm-4">
				<select name="typeId" class="form-control  input-sm">
					<option value="pass">请选择记录所属类型</option>
					<c:forEach var="declareType" items="${declareTypeDTOList }">
						<option value="${declareType.typeId }">${declareType.typeName }</option>
					</c:forEach>
				</select>
			</div>
			<div class="col-sm-1">
				<input type="submit" class="btn btn-danger" value="查询" />
			</div>
		</div>
	</form>
	<!-- 提示信息 -->
	<div align="center">
		<div class="alert alert-warning"
			style="margin: 0px; padding: 5px; width: 80%;display:${empty info?'none':'block'} ">
			<button type="button" class="close" data-dismiss="alert">
				<span aria-hidden="true">&times;</span>
			</button>
			<p align="center" style="color: red;">申报进度-${info}</p>
		</div>
	</div>


	<div class="row" style="padding: 15px; padding-top: 0px;">
		<form>
			<table class="table  table-condensed table-striped">
				<tr>
					<th>记录编号</th>
					<th>项目名称</th>
					<th>项目类型</th>
					<th>申报人</th>
					<th>申报时间</th>
					<th>最近修改时间</th>
					<th>处理状态</th>
					<th>处理结果</th>
					<th>查阅</th>
				</tr>
				<c:forEach var="declareRecord" items="${list }">
					<tr>
						<td>${declareRecord.declareId }</td>
						<td>${declareRecord.itemInfo. itemName}</td>
						<td>${declareRecord.declareType. typeName}</td>
						<td>${declareRecord.userInfo.userName }</td>
						<td><fmt:formatDate type="both" pattern="yyyy-MM-dd"
								value="${declareRecord.createTime }" /></td>
						<td><fmt:formatDate type="both" pattern="yyyy-MM-dd"
								value="${declareRecord.modifiedTime }" /></td>
						<td>${declareRecord.processStatusContext }</td>
						<td title="${declareRecord.result }">${declareRecord.result }</td>
						<td>
							<%-- <a href="${pageContext.request.contextPath }/declare/declareinfo/showDeclareRecord.action?declareId='${declareRecord.declareId }'">查看详情</a> --%>
							<a href="javascript:showData('${declareRecord.declareId }')">查看详情</a>
						</td>
						<c:if test="${declareRecord.processStatus=='-1'||declareRecord.processStatus=='-2'||declareRecord.processStatus=='-3' }">
							<td>
								<%-- <input type="submit" class="btn btn-info" onclick="passCheck('${declareRecord.declareId }')" value="通过审核" /> --%>
								<a href="javascript:updateDeclareRecord('${declareRecord.declareId }')">重新编辑</a>
							</td>
						</c:if>
					</tr>
				</c:forEach>
			</table>
		</form>
	</div>
	
	<script type="text/javascript">
		function showData(declareId) {
			alert(declareId);
			var url = "${pageContext.request.contextPath }/declare/declareinfo/showDeclareRecord.action?declareId=" + declareId;
 			window.location.href = url; 
		}
		function updateDeclareRecord(declareId) {
			alert(declareId);
			var url = "${pageContext.request.contextPath }/declare/declareinfo/updateDeclareRecordUI.action?declareId=" + declareId;
 			window.location.href = url; 
		}
	</script>

</body>
</html>

<%-- <div class="row" style="padding: 15px; padding-top: 0px;">
			<display:table class="table  table-condensed table-striped"
				name="list" pagesize="10"
				requestURI="${pageContext.request.contextPath }/user/userinfo/listUserInfo.action">
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
					href="${pageContext.request.contextPath }/user/userinfo/updateUserInfoUI.action"
					paramId="userId" paramProperty="userId" value="修改" title="修改"></display:column>

				<display:column
					href="${pageContext.request.contextPath }/user/userinfo/deleteUserInfo.action"
					paramId="userId" paramProperty="userId" title="删除" value="删除">
				</display:column>
			</display:table>
		</div> --%>
