<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta charset="utf-8">
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<title>首页</title>
<!-- 引入相关的文件 -->
<%@include file="/view/public/commons.jspf"%>
</head>

<body>
	<div style="padding: 0px; margin: 0px;">
		<ul class="breadcrumb" style="margin: 0px;">
			<li><a href="#">营销管理</a></li>
			<li>营销活动</li>
			<li>添加活动</li>
		</ul>
	</div>

	<form
		action="${pageContext.request.contextPath }/marketactive/marketactive/addMarketActive.action"
		method="post" class="form-horizontal">
		<h5 class="page-header alert-info"
			style="padding: 10px; margin: 0px; margin-bottom: 5px;">基本信息</h5>
		<div class="row">
			<div class="col-sm-5">
				<div class="form-group">
					<label class="col-sm-3 control-label">编号</label>
					<div class="col-sm-9">
						<input type="text" name="activeId" class="form-control input-sm"
							readonly="readonly" placeholder="请输入编号" />
					</div>
				</div>
			</div>
			<div class="col-sm-5">
				<div class="form-group">
					<label class="col-sm-3 control-label">活动名称</label>
					<div class="col-sm-9">
						<input type="text" name="activeName" class="form-control input-sm"
							placeholder="请输入活动名称" />
					</div>
				</div>
			</div>
		</div>
		<!--开始 -->
		<div class="row">
			<div class="col-sm-5">
				<div class="form-group">
					<label class="col-sm-3 control-label">开始时间</label>
					<div class="col-sm-9">
						<input type="text" name="activeStart" onclick="WdatePicker()"
							readonly="readonly" class="form-control input-sm"
							placeholder="请输入开始时间" />
					</div>
				</div>
			</div>
			<div class="col-sm-5">
				<div class="form-group">
					<label class="col-sm-3 control-label">活动状态</label>
					<div class="col-sm-5">
						<select name="activeState" class="form-control input-sm">
							<c:forEach var="activeState" items="${activeState_map }">
								<option value="${activeState.value }">${activeState.key }</option>
							</c:forEach>
						</select>
					</div>
				</div>
			</div>
		</div>
		<!--结束 -->
		<!--开始 -->
		<div class="row">
			<div class="col-sm-5">
				<div class="form-group">
					<label class="col-sm-3 control-label">结束时间</label>
					<div class="col-sm-9">
						<input type="text" name="activeEnd" class="form-control input-sm"
							readonly="readonly" onclick="WdatePicker()" placeholder="请输入结束时间" />
					</div>
				</div>
			</div>
			<div class="col-sm-5">
				<div class="form-group">
					<label class="col-sm-3 control-label">活动类型</label>
					<div class="col-sm-5">
						<select name="activeType" class="form-control input-sm">
							<c:forEach var="activeType" items="${activeType_map }">
								<option value="${activeType.value }">${activeType.key }</option>
							</c:forEach>
						</select>
					</div>
				</div>
			</div>
		</div>
		<!--结束 -->
		<!--开始 -->
		<div class="row">
			<div class="col-sm-5">
				<div class="form-group">
					<label class="col-sm-3 control-label">成本预算</label>
					<div class="col-sm-6">
						<input type="text" name="activeCosteEstimate"
							class="form-control input-sm" placeholder="请输入成本预算" />
					</div>
				</div>
			</div>
			<div class="col-sm-5">
				<div class="form-group">
					<label class="col-sm-3 control-label">实际成本</label>
					<div class="col-sm-6">
						<input type="text" name="activeCoste"
							class="form-control input-sm" placeholder="请输入实际成本" />
					</div>
				</div>
			</div>
		</div>
		<!--结束 -->
		<!--开始 -->
		<div class="row">
			<div class="col-sm-5">
				<div class="form-group">
					<label class="col-sm-3 control-label">预期反应</label>
					<div class="col-sm-6">
						<select name="activeRefectEstimate" class="form-control input-sm">
							<c:forEach var="activeRefectEstimate"
								items="${activeRefectEstimate_map }">
								<option value="${activeRefectEstimate.value }">${activeRefectEstimate.key }</option>
							</c:forEach>
						</select>
					</div>
				</div>
			</div>
			<div class="col-sm-5">
				<div class="form-group">
					<label class="col-sm-3 control-label">预期学员</label>
					<div class="col-sm-6">
						<input type="text" name="activeStudent"
							class="form-control input-sm" placeholder="请输入预期学员" />
					</div>
				</div>
			</div>
		</div>
		<!--结束 -->
		<h5 class="page-header alert-info"
			style="padding: 10px; margin: 0px; margin-bottom: 5px;">描述信息</h5>
		<div class="row">
			<div class="col-sm-10">
				<div class="form-group">
					<label class="col-sm-3 control-label">描述信息</label>
					<div class="col-sm-9">
						<textarea class="form-control" name="activeContent"></textarea>
					</div>
				</div>

			</div>

		</div>

		<div class="row">
			<div class="col-sm-3 col-sm-offset-4">
				<input type="submit" class="btn btn-success" value="保存" /> <a
					class="btn btn-warning"
					href="${pageContext.request.contextPath }/marketactive/marketactive/listMarketActive.action">返回上一级</a>
			</div>
		</div>
	</form>

</body>
</html>
