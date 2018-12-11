<%--
  Created by IntelliJ IDEA.
  User: utry
  Date: 2018/12/11
  Time: 14:39
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@taglib uri="http://displaytag.sf.net" prefix="display"%>
<html>
<head>
    <meta charset="utf-8">
    <meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
    <title>首页</title>
    <!-- 引入相关的文件 -->
    <%@include file="/view/public/commons.jspf"%>
</head>

<body>
<div style="padding:0px; margin:0px;">
    <ul class="breadcrumb" style="  margin:0px; " >
        <li><a href="#">学员管理</a></li>
        <li>查询学员</li>
    </ul>
</div>
<form class="form-inline">
    <div class="row alert alert-info"  style="margin:0px; padding:3px;" >

        <div class="form-group">
            <label class="" for="activename">学员姓名：</label>
            <input type="email" class="form-control" id="activename" placeholder="请输入学员姓名">
        </div>

        <input type="button"   class="btn btn-danger"     value="查询"/>
        <a  class="btn btn-success"  href="user_add.html">添加学员</a>

    </div>

    <div class="row" style="padding: 15px; padding-top: 0px;">
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
            <display:column property="createTime" title="注册时间"></display:column>
            <display:column property="roleId" title="用户角色"></display:column>
            <display:column property="roleName" title="用户角色"></display:column>
            <display:column property="department" title="所属部门"></display:column>
            <display:column property="departmentContext" title="所属部门"></display:column>

            <display:column
                    href="${pageContext.request.contextPath }/user/userinfo/updateUserInfo.action"
                    paramId="studentId" paramProperty="studentId" value="修改" title="修改"></display:column>

            <display:column
                    href="${pageContext.request.contextPath }/user/userinfo/deleteUserInfo.action"
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
</form>
</body>
</html>

