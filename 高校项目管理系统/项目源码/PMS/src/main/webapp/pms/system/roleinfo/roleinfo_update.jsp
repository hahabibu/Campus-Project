<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
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

<script type="text/javascript">
	window.onload=function(){
		var today=new Date();
		var submitTime=today.getFullYear()+'-'+(today.getMonth()+1)+'-'+today.getDate(); 
		$("#modifiedTime").attr('value',submitTime);
	} 
</script>

<body>
<div style="padding:0px; margin:0px;">
 <ul class="breadcrumb" style="  margin:0px; " >
    	<li><a href="#">系统管理</a></li>
        <li><a href="#">角色管理</a></li>
        <li>修改角色信息</li>
    </ul>
</div>

<form action="${pageContext.request.contextPath}/system/roleinfo/updateRoleInfo.action" method="post" class="form-horizontal">

    <h5 class="page-header alert-info" style="padding:10px; margin:0px; margin-bottom:5px;">基本信息</h5>
	<div class="row">
    	<div class="col-sm-5">
        	<div class="form-group">
            	<label class="col-sm-3 control-label">角色编号</label>
                <div class="col-sm-9">
                	<input type="text" name="roleId" value="${roleInfo.roleId }" class="form-control input-sm" readonly="readonly"/>
                </div>
            </div>
        </div>
        <div class="col-sm-5">
            <div class="form-group">
            	<label class="col-sm-3 control-label">角色名称</label>
                <div class="col-sm-9">
                	<input type="text" name="roleName" value="${roleInfo.roleName }" class="form-control input-sm"/>
                </div>
            </div>
        </div>
    </div>
    
    <div class="row">
    	<div class="col-sm-5">
        	<div class="form-group">
            	<label class="col-sm-3 control-label">创建时间</label>
                <div class="col-sm-9">
                	<input type="text" name="createTime" value="<fmt:formatDate value="${roleInfo.createTime }" pattern="yyyy-MM-dd" type="both"/>" class="form-control input-sm" readonly="readonly"/>
                </div>
            </div>
        </div>
        <div class="col-sm-5">
            <div class="form-group">
            	<label class="col-sm-3 control-label">修改时间</label>
                <div class="col-sm-9">
                	<input type="text" id="modifiedTime" name="modifiedTime" onclick="WdatePicker({autoPickDate:true,dateFmt:'yyyy-MM-dd'})" class="form-control input-sm" readonly="readonly"/>
                </div>
            </div>
        </div>
    </div>
    
    <h5 class="page-header alert-info" style="padding:10px; margin:0px; margin-bottom:5px;">备注信息</h5>
    	<div class="row">
	    	<div class="col-sm-10">
	        	<div class="form-group">
	            	<label class="col-sm-3 control-label">备注</label>
	                <div class="col-sm-9">
	                	<textarea class="form-control" name="roleDescr" placeholder="请填写角色备注信息">${roleInfo.roleDescr }</textarea>
	                </div>
	            </div>
	        </div>
	    </div>
 
	   	<div class="row">
	    	<div class="col-sm-3 col-sm-offset-4">
	        	<input  type="submit" class="btn btn-success" value="保存"/>
	            <input  type="reset" class="btn  btn-danger" value="取消"/>
	            <a class="btn btn-warning" href="${pageContext.request.contextPath}/system/roleinfo/listRoleInfo.action">返回上一级</a>
	        </div>
	    </div>
</form>

</body>
</html>
