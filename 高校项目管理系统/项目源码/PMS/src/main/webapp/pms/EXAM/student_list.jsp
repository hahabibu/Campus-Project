<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@taglib uri="http://displaytag.sf.net" prefix="display"%>
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
			<li><a href="#">信息管理</a></li>
			<li>学生信息</li>
		</ul>
	</div>
	
	<!-- 提示信息 -->
	<div align="center">
		<div class="alert alert-warning"
			style="margin: 0px; padding: 5px; width: 80%;display:${empty info?'none':'block'} ">
			<button type="button" class="close" data-dismiss="alert">
				<span aria-hidden="true">&times;</span>
			</button>
			<p align="center" style="color: red;">学生信息管理-${info}</p>
		</div>
	</div>
			
	<div class="row alert alert-info" style="margin: 0px; padding: 3px;">
		<form
			action="${pageContext.request.contextPath}/student/student/listStudents.action"
			method="post" class="form-horizontal">
			
			<div class="row">
		    	<div class="col-sm-4">
		        	<div class="form-group">
		            	<label class="col-sm-3 control-label">学生学号</label>
		                <div class="col-sm-5">
		                	<input type="text" id="stuNum" name="stuNum" class="form-control input-sm" placeholder="请输入学生学号"/>
		                </div>
		            </div>
		        </div>
		        
		        <div class="col-sm-4">
		            <div class="form-group">
		            	<label class="col-sm-3 control-label">学生姓名</label>
		                <div class="col-sm-5">
		                	<input type="text" id="stuName" name="stuName" class="form-control input-sm" placeholder="请输入学生姓名"/>
		                </div>
		            </div>
		        </div>
		        
		        <div class="col-sm-4">
		        	<div class="form-group">
		            	<label class="col-sm-3 control-label">用户状态</label>
		                <div class="col-sm-5">
		                	<select class="form-control  input-sm" name="delTag">
								<option value="0">启用</option>
								<option value="1">禁用</option>
							</select> 
						</div>
		            </div>
		        </div>
		    </div>
		    
		    <div class="row">
		    	<div class="col-sm-4">
		        	<div class="form-group">
		            	<label class="col-sm-3 control-label">创建时间</label>
		                <div class="col-sm-5">
		                	<input type="text" id="createtime" name="createtime" readonly="readonly" onclick="WdatePicker()" 
		                	class="form-control input-sm" placeholder="请输入创建时间范围"/>
		                </div>
		            </div>
		        </div>
		        
		        <div class="col-sm-4">
		            <div class="form-group">
		            	<label class="col-sm-3 control-label">创建截止</label>
		                <div class="col-sm-5">
		                	<input type="text" id="deadline" name="deadline" readonly="readonly" onclick="WdatePicker()" 
		                	class="form-control input-sm" placeholder="请输入截止创建时间"/>
		                </div>
		            </div>
		        </div>
		        
		        <div class="col-sm-4">
		        	<div class="form-group">
		            	<label class="col-sm-3 control-label">注册渠道</label>
		                <div class="col-sm-5">
		                	<select class="form-control  input-sm" name="channel">
								<option value="PC端">PC端</option>
								<option value="手机端">手机端</option>
							</select> 
						</div>
		            </div>
		        </div>
		    </div>
		    
		     <div class="row">
				<div class="form-group">
					<div class="col-sm-3">
		           		&nbsp;
		           	</div>
		            <div class="col-sm-3">
		           		<input type="submit" class="btn btn-danger" value="查询" /> 
		           	</div>
		        
		            <div class="col-sm-3">
		              	<input type="reset" class="btn btn-info" value="取消" />
					</div>
					<div class="col-sm-3">
	                	 <input type="button" class="btn btn-success" value="添加" onClick="javascript:window.location='${pageContext.request.contextPath}/student/student/addStudentUI.action'"/>
					</div>
				</div>	
		    </div>	 
		</form>
	</div>

		<div class="row" style="padding: 15px; padding-top: 0px;">
		<table class="table  table-condensed table-striped">
		</table>
		<display:table class="table  table-condensed table-striped"
			name="list" pagesize="10"
			requestURI="${pageContext.request.contextPath}/student/student/listStudents.action }">
			<%-- <display:column property="stuId" title="编号"></display:column> --%>
			<display:column property="stuName" title="姓名"
				href="${pageContext.request.contextPath }/student/student/showStudent.action"
				paramId="stuId" paramProperty="stuId"></display:column>
			<display:column property="stuNum" title="学号"></display:column>
			<%-- <display:column property="stuName" title="姓名"></display:column> --%>
			<display:column property="department" title="所属部门"></display:column>
			<display:column property="majorName" title="所在专业"></display:column>
			<display:column property="channel" title="注册渠道"></display:column>
			<display:column property="createtime" title="创建时间" format="{0,date,dd-MM-yyyy}"></display:column>
			<display:column property="modifiedtime" title="修改时间" format="{0,date,dd-MM-yyyy}"></display:column>
			<display:column property="delTag" title="启用状态"></display:column>
			<display:column
				href="${pageContext.request.contextPath }/student/student/updateStudentUI.action"
				paramId="stuId" paramProperty="stuId" value="修改" title="修改"></display:column>
			<display:column
				href="${pageContext.request.contextPath }/student/student/deleteStudent.action"
				paramId="stuId" paramProperty="stuId" value="删除" title="删除"></display:column>
		</display:table>
	</div>

</body>
</html>
