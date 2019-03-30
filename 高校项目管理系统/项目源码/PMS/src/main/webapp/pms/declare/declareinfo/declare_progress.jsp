<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://displaytag.sf.net" prefix="display"%>
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

<body>
<div style="padding:0px; margin:0px;">
 <ul class="breadcrumb" style="  margin:0px; " >
    	<li><a href="#">申报管理</a></li>
        <li>申报进度</li>
    </ul>
</div>
<div class="row alert alert-info"  style="margin:0px; padding:3px;" >
	<form class="form-horizontal">
		<div class="col-sm-2">记录类型</div>
	    <div class="col-sm-3">
	    	<input type="text"  class="form-control input-sm"/>
	    </div>
	   <!--  <div class="col-sm-3">
	    	<select>
	    		<option></option>
	    	</select>
	    </div> -->
	    <input type="button"   class="btn btn-danger"   value="查询"/>
    </form>
</div>
	<div class="row" style="padding: 15px; padding-top: 0px;">
        <display:table class="table  table-condensed table-striped"
                       name="list" pagesize="10"
                       requestURI="${pageContext.request.contextPath }/">
            <display:column property="declareId" title="申报id"></display:column>
            <display:column property="itemId" title="申报项目id"></display:column>
            <display:column property="typeId" title="申报类型"></display:column>
            <display:column property="userId" title="申报用户id"></display:column>
            <display:column property="createTime" title="创建时间"></display:column>
            <display:column property="modifiedTime" title="修改时间"></display:column>
            <display:column property="processStatus" title="申报处理状态"></display:column>
            <display:column property="result" title="申报结果"></display:column>
            <display:column property="delTag" title="删除标识"></display:column>

            <display:column
                    href="${pageContext.request.contextPath }"
                    paramId="studentId" paramProperty="studentId" value="修改" title="修改"></display:column>

			<display:column
                    href="${pageContext.request.contextPath }"
                    paramId="studentId" paramProperty="studentId" title="删除" value="删除">
            </display:column>
        </display:table>
    </div>

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

</body>
</html>
