<%--
  Created by IntelliJ IDEA.
  User: utry
  Date: 2018/12/11
  Time: 14:39
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java"%>
<%@ taglib uri="http://displaytag.sf.net" prefix="display"%>
<%@ page import="org.apache.log4j.Logger"%>
<html>
<head>
<meta charset="utf-8">
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<title>首页</title>
<!-- 引入相关的文件 -->
<%@include file="/pms/public/commons.jspf"%>
</head>

<script type="text/javascript">
	/* window.onload=function(){
		var today=new Date();
		var submitTime=today.getFullYear()+'-'+(today.getMonth()+1)+'-'+today.getDate(); 
		$("#createTime").attr('value',submitTime);
	} */
	function loadTime() {
		var today = new Date();
		var submitTime = today.getFullYear() + '-' + (today.getMonth() + 1)
				+ '-' + today.getDate();
		$("#createTime").attr('value', submitTime);
		$("#modifiedTime").attr('value', submitTime);
		$("#middleTime").attr('value', submitTime);
		$("#endTime").attr('value', submitTime);
		// 设置期限年份+1
		today.setFullYear(today.getFullYear() + 1);
		var limitTime = today.getFullYear() + '-' + (today.getMonth() + 1)
				+ '-' + today.getDate();
		$("#middleTimeLimit").attr('value', limitTime);
		$("#endTimeLimit").attr('value', limitTime);
	}
</script>

<body onload="loadTime()">
	<div style="padding: 0px; margin: 0px;">
		<ul class="breadcrumb" style="margin: 0px;">
			<li><a href="#">项目审核</a></li>
			<li>申报类型管理</li>
		</ul>
	</div>

	<form class="form-inline"
		action="${pageContext.request.contextPath }/audit/declaretype/listDeclareType.action">
		<div class="row alert alert-info" style="margin: 0px; padding: 3px;">
			<div class="row">
				<div class="col-sm-6">
					<div class="form-group">
						<div class="col-sm-2">查找条件</div>
						<div class="col-sm-4">
							<input type="text" name="typeName" placeholder="请输入类型名称"
								class="form-control input-sm" />
						</div>
						<div class="col-sm-2">启用状态</div>
						<div class="col-sm-4">
							<select name="startStatus">
								<option value="-1">请选择启用标识</option>
								<option value="0">未启用</option>
								<option value="1">已启用</option>
								<!-- <option value="2">已过期</option> -->
							</select>
						</div>
					</div>
				</div>
				<div class="col-sm-6">
					<div class="form-group">
						<div class="col-sm-6">
							<input type="submit" class="btn btn-danger" value="查询" />
						</div>
						<div class="col-sm-6">
							<input type="button" class="btn btn-success" value="添加"
								onClick="javascript:window.location='${pageContext.request.contextPath}/audit/declaretype/addDeclareTypeUI.action'" />
						</div>
					</div>
				</div>
			</div>

			<div class="row">
				<div class="col-sm-6">
					<div class="form-group">
						<label class="col-sm-2 control-label">中期检查</label>
						<div class="col-sm-4">
							<input type="text" id="middleTime" name="middleTime"
								readonly="readonly" onclick="WdatePicker()"
								class="form-control input-sm" placeholder="请输入创建时间范围" />
						</div>
						<label class="col-sm-2 control-label">中期截止</label>
						<div class="col-sm-4">
							<input type="text" id="middleTimeLimit" name="middleTimeLimit"
								readonly="readonly" onclick="WdatePicker()"
								class="form-control input-sm" placeholder="请输入截止创建时间" />
						</div>
					</div>
				</div>

				<div class="col-sm-6">
					<div class="form-group">
						<label class="col-sm-2 control-label">结题验收</label>
						<div class="col-sm-4">
							<input type="text" id="endTime" name="endTime"
								readonly="readonly" onclick="WdatePicker()"
								class="form-control input-sm" placeholder="请输入创建时间范围" />
						</div>
						<label class="col-sm-2 control-label">结题截止</label>
						<div class="col-sm-4">
							<input type="text" id="endTimeLimit" name="endTimeLimit"
								readonly="readonly" onclick="WdatePicker()"
								class="form-control input-sm" placeholder="请输入截止创建时间" />
						</div>
					</div>
				</div>
			</div>
		</div>

		<!-- 提示信息 -->
		<div align="center">
			<div class="alert alert-warning"
				style="margin: 0px; padding: 5px; width: 80%;display:${empty info?'none':'block'} ">
				<button type="button" class="close" data-dismiss="alert">
					<span aria-hidden="true">&times;</span>

				</button>
				<p align="center" style="color: red;">申报类型管理-${info}</p>
			</div>
		</div>

		<div class="row" style="padding: 15px; padding-top: 0px;">
			<display:table class="table  table-condensed table-striped"
				name="list" pagesize="10"
				requestURI="${pageContext.request.contextPath }/audit/declaretype/listDeclareType.action">
				<%-- <display:column property="typeId" title="类型编号"></display:column> --%>
				<display:column property="typeName" title="类型名称"></display:column>
				<display:column property="createTime" title="创建时间"
					format="{0,date,yyyy年MM月dd日}"></display:column>
				<display:column property="modifiedTime" title="修改时间"
					format="{0,date,yyyy年MM月dd日}"></display:column>
				<display:column property="middleTime" title="中期检查期限"
					format="{0,date,yyyy年MM月dd日}"></display:column>
				<display:column property="endTime" title="结题验收期限"
					format="{0,date,yyyy年MM月dd日}"></display:column>
				<%-- <display:column property="startStatus" title="启用标识"></display:column> --%>
				<%-- <display:column property="startStatusContext" title="启用标识"></display:column> --%>
				<display:column property="startStatusContext" title="启用标识"></display:column>

				<display:column href="${pageContext.request.contextPath }/audit/declaretype/updateDeclareTypeUI.action"
					paramId="typeId" paramProperty="typeId" value="修改" title="修改"></display:column>

				<display:column
					href="${pageContext.request.contextPath }/audit/declaretype/deleteDeclareType.action"
					paramId="typeId" paramProperty="typeId" title="删除" value="删除">
				</display:column>
			</display:table>
		</div>
		
		<!-- <script type="text/javascript">
		    var dispObjs = document.getElementsByTagName("display:column");
		    for (var i=0; i<dispObjs.length; i++)
		    {
		        var disp = dispObjs[i];
		        if (disp.title == "typeId")
		        {
		            alert(disp.getAttribute("property") ); //改这一行
		            break;
		        }
		    }
		</script> -->

	<!-- 	<script type="text/javascript">
			function updateData(typeId) {
				alert(typeId);
				var url = "${pageContext.request.contextPath }/audit/declaretype/updateDeclareTypeUI.action?typeId="
						+ typeId;
				var info = window.confirm("您确认修改这条数据吗?");
				if (info) {
					window.location.href = url;
				}
			}
			function deleteData(typeId) {
				alert(typeId);
				alert(startStatus);
				// 判断当前是否能够删除（如果当前处于申报状态不能够进行删除）

				var url = "${pageContext.request.contextPath }/audit/declaretype/deleteDeclareType.action?typeId="
						+ typeId;
				var info = window.confirm("您确认删除这条数据吗?");
				if (info) {
					window.location.href = url;
				}
			}
		</script> -->

		<%--<div class="row" style="padding:15px; padding-top:0px; ">
        <table class="table  table-condensed table-striped">
            <tr>
                <th>用户编号</th>
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
            <tr>
                <td>1001</td>
                <td>猪八戒</td>
                <td>hahabibu@163.com</td>
                <td>80082008820</td>
                <td>441424xxxxxxxx0098</td>
                <td>禁用</td>
                <td>2018-12-02</td>
                <td>2018-12-02</td>
                <td>学生</td>
                <td>信息学员</td>
                <th>
                    <a href="user_update.html">修改</a>
                    <a href="">删除</a>
                </th>
            </tr>
        </table>
    </div>--%>
	</form>
</body>
</html>

