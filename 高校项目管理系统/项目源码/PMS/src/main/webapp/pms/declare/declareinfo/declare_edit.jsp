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
	<%@include file="/pms/public/commons.jspf"%>
</head>

<style type="text/css">
#customer table.text td {
	font-family: "楷体";
	font-size: 20px;
	/* text-align: center; */
	padding: 3px 7px 2px 50px; /*设置边距（上右下左--顺时针） ;*/
}
</style>
<script type="text/javascript">
	function addMore() {
		// 获取当前的父标签
		var td = document.getElementById("upload");
		// 定义要新建的标签
		var br = document.createElement("br");
		var input = document.createElement("input");
		input.type = "file";
		input.name = "file";
		var button = document.createElement("input");
		button.type = "button";
		button.value = "remove";
		button.onclick = function removeElement() {
			// 移除
			td.removeChild(br);
			td.removeChild(input);
			td.removeChild(button);
		}
		// 将标签进行添加
		td.appendChild(br);
		td.appendChild(input)
		td.appendChild(button);
	}
</script>

<body id="customer">
	<div style="padding: 0px; margin: 0px;">
		<ul class="breadcrumb" style="margin: 0px;">
			<li><a href="#">申报管理</a></li>
			<li>申报材料</li>
		</ul>
	</div>
	<form
		action="${pageContext.request.contextPath }/declare/declareinfo/addItemInfo.action"
		method="post" onsubmit="return doSubmit()" name="form1"
		class="form-horizontal" enctype="multipart/form-data">
		<div class="row alert alert-info" style="margin: 0px; padding: 3px;">
			<div class="col-sm-2">记录类型</div>
			<div class="col-sm-3">
				<select name="typeId" class="form-control  input-sm">
					<!-- <option value="pass">请选择记录所属类型</option> -->
					<c:forEach var="declareType" items="${declareTypeDTOList }">
						<option value="${declareType.typeId }">${declareType.typeName }</option>
					</c:forEach>
				</select>
			</div>
		</div>

		<div class="row" style="padding: 15px; padding-top: 0px;">
			<div class="col-sm-9">
				<table class="table table-bordered table-striped table-hover text"
					align="center">
					<tr>
						<th colspan="4" style="text-align: center"><h2>项目申报表</h2></th>
					</tr>

					<tr>
						<td>项目名称</td>
						<td colspan="3"><input type="text" name="itemName"
							placeholder="请输入项目名称" /></td>
					</tr>

					<tr>
						<td>负责人</td>
						<td><input type="text" name="principal"
							placeholder="请填写项目负责人" /></td>
						<td>所属专业</td>
						<td><input type="text" name="profession"
							placeholder="请选择所属专业" /></td>
					</tr>

					<tr>
						<td>联系方式</td>
						<td><input type="text" name="phone" placeholder="请输入联系方式" /></td>
						<td>电子邮箱</td>
						<td><input type="text" name="email" placeholder="请输入电子邮箱" /></td>
					</tr>

					<tr>
						<td>申报级别</td>
						<td colspan="3"><input type="radio" name="itemClass"
							value="院级" checked="checked" />院级 <input type="radio"
							name="itemClass" value="校级" />校级 <!-- <select name="itemClass">
								<option value="">校级</option>
								<option value="">院级</option>
						</select> --></td>
					</tr>

					<tr>
						<td>项目成员（全体）</td>
						<td colspan="3"><textarea name="members" rows="5" cols="75"
								placeholder="请填写项目成员信息"></textarea></td>
					</tr>

					<tr>
						<td colspan="1">项目内容（附件资料）</td>
						<!--<form action="${pageContext.request.contextPath }/FileUploadServletDemo2" method="post" enctype="multipart/form-data">-->
						<td colspan="3" id="upload"><input type="file" name="file" />
							<button type="button" onclick="addMore()">上传更多</button></td>
						<!--</form>-->
					</tr>

					<tr>
						<td colspan="1">立项承诺</td>
						<td colspan="3"><textarea name="commitment" rows="5"
								cols="75" placeholder="这家伙很懒，啥也不写!"></textarea></td>
					</tr>

					<tr>
						<td colspan="2">
							<!-- <a href="javascript:saveData()">修改</a> --> <!-- <a onclick="saveData()">修改</a> -->
							<!-- <input type="submit" class="btn btn-info" value="提交" /> -->
 							<!-- <input type="submit" class="btn btn-info" onclick="saveData()" value="保存" /> -->
						</td>
						<td colspan="2">
							<!--  <a href="javascript:submitData()" >提交</a> --> <!-- <a onclick="submitData()" >提交</a> -->
							<input type="submit" class="btn btn-info" onclick="submitData()" value="提交" />
						</td>
					</tr>

				</table>

				<input type="hidden" id="delTag" name="delTag" />
				<script type="text/javascript">
					function saveData() {
						$("#delTag").val("1");
						return true;
						/* var url = "${pageContext.request.contextPath }/declaration/declarationinfo/addDeclarationInfo.action";
						window.location.href = url; */
					}
					function submitData() {
						$("#delTag").val("0");
						return true;
						/* var url = "${pageContext.request.contextPath }/declaration/declarationinfo/addDeclarationInfo.action";
						window.location.href = url; */
					}
					function doSubmit() {
						var info = window.confirm("您确认提交数据吗?提交后将不可修改！");
						if (info) {
							return true;
						}
						return false;
					}
				</script>
			</div>
		</div>
	</form>
</body>
</html>