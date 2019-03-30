<%--
  Created by IntelliJ IDEA.
  User: utry
  Date: 2018/12/11
  Time: 14:52
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
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
        <li><a href="#">用户管理</a></li>
        <li>修改用户信息</li>
    </ul>
</div>

<form action="${pageContext.request.contextPath }/user/userinfo/updateUserInfo.action" class="form-horizontal">
    <h5 class="page-header alert-info" style="padding:10px; margin:0px; margin-bottom:5px;">基本信息</h5>
    <!--开始 -->
    <div class="row">
        <div class="col-sm-5">
            <div class="form-group">
                <label class="col-sm-3 control-label">用户编号</label>
                <div class="col-sm-9">
                    <input type="text" name="userId" value="${userInfo.userId}" class="form-control input-sm" placeholder="请输入编号" readonly="readonly"/>
                </div>
            </div>
        </div>
        <div class="col-sm-5">
            <div class="form-group">
                <label class="col-sm-3 control-label">用户名称</label>
                <div class="col-sm-9">
                    <input type="text" name="userName" value="${userInfo.userName}" class="form-control input-sm" placeholder="请输入姓名"/>
                </div>
            </div>
        </div>
    </div>
    <!-- 结束 -->

    <!--开始 -->
    <div class="row">
        <div class="col-sm-5">
            <div class="form-group">
                <label class="col-sm-3 control-label">电子邮箱</label>
                <div class="col-sm-9">
                    <input type="email" name="email" value="${userInfo.email}" class="form-control input-sm" placeholder="请输入电子邮箱"/>
                </div>
            </div>
        </div>
        <div class="col-sm-5">
            <div class="form-group">
                <label class="col-sm-3 control-label">联系方式</label>
                <div class="col-sm-9">
                    <input type="text" name="phone" value="${userInfo.phone}" class="form-control input-sm" placeholder="请输入联系方式"/>
                </div>
            </div>
        </div>
    </div>
    <!--结束 -->

    <!--开始 -->
    <div class="row">
        <div class="col-sm-5">
            <div class="form-group">
                <label class="col-sm-3 control-label">身份证号</label>
                <div class="col-sm-9">
                    <input type="text" name="idcard" value="${userInfo.idcard}" class="form-control input-sm" placeholder="请输入身份证号"/>
                </div>
            </div>
        </div>
        <div class="col-sm-5">
            <div class="form-group">
                <label class="col-sm-3 control-label">用户状态</label>
                <div class="col-sm-9">
                    <select name="userState" class="form-control input-sm">
                        <option value="0" ${'0'==userInfo.userState?'selected':'' }>启用</option>
                        <option value="1">禁用</option>
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
                <label class="col-sm-3 control-label">注册时间</label>
                <div class="col-sm-9">
                    <input type="text" name="createTime" value="<fmt:formatDate value="${userInfo.createTime }" pattern="yyyy-MM-dd" type="both"/>" class="form-control input-sm" readonly="readonly"/>
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
    <!--结束 -->

    <!--开始 -->
    <div class="row">
        <div class="col-sm-5">
            <div class="form-group">
                <label class="col-sm-3 control-label">用户角色</label>
                <div class="col-sm-9">
                    <select name="department" class="form-control input-sm">
                        <c:forEach var="roleInfo" items="${roleInfoList}">
                            <option value="${roleInfo.roleId}" ${roleInfo.roleId==userInfo.roleId?'selected':'' }>${roleInfo.roleName}</option>
                        </c:forEach>
                    </select>
                </div>
            </div>
        </div>
        <div class="col-sm-5">
            <div class="form-group">
                <label class="col-sm-3 control-label">所属部门</label>
                <div class="col-sm-9">
                    <select name="roleId" class="form-control input-sm">
                        <c:forEach var="dept" items="${departmentList}">
                            <option value="${dept.dataId}" ${dept.dataId==userInfo.department?'selected':'' }>${dept.dataContent}</option>
                        </c:forEach>
                    </select>
                </div>
            </div>
        </div>
    </div>
    <!--结束 -->

    <h5 class="page-header alert-info" style="padding:10px; margin:0px; margin-bottom:5px;">备注信息</h5>
    <div class="row">
        <div class="col-sm-10">
            <div class="form-group">
                <label class="col-sm-3 control-label">备注信息</label>
                <div class="col-sm-9">
                    <textarea class="form-control" name="userDescr">${userInfo.userDescr}</textarea>
                </div>
            </div>
        </div>
    </div>

    <h5 class="page-header alert-info" style="padding:10px; margin:0px; margin-bottom:5px;">账号信息</h5>
    <!--开始 -->
    <div class="row">
        <div class="col-sm-5">
            <div class="form-group">
                <label class="col-sm-3 control-label">用户账号</label>
                <div class="col-sm-9">
                    <input type="text" name="loginAccount" value="${userInfo.loginAccount}" class="form-control input-sm" placeholder="请输入用户账号"/>
                </div>
            </div>
        </div>
        <div class="col-sm-5">
            <div class="form-group">
                <label class="col-sm-3 control-label">用户密码</label>
                <div class="col-sm-9">
                    <input type="password" name="loginPassword" value="${userInfo.loginPassword}" class="form-control input-sm" placeholder="请输入姓名"/>
                </div>
            </div>
        </div>
    </div>
    <!-- 结束 -->

    <div class="row">
        <div class="col-sm-3 col-sm-offset-4">
            <input  type="submit" class="btn btn-success" value="保存"/>
            <a class="btn btn-warning" href="${pageContext.request.contextPath }/user/userinfo/listUserInfo.action">返回上一级</a>
        </div>
    </div>
</form>
</body>
</html>
