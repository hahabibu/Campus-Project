<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%--
  Created by IntelliJ IDEA.
  User: utry
  Date: 2018/12/11
  Time: 14:36
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <meta charset="utf-8">
    <meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
    <title>首页</title>
    <!-- 引入相关的文件 -->
    <%@include file="/pms/public/commons.jspf"%>
</head>

<!-- <script language="JavaScript">  -->
<script type="text/javascript"> 
	/* window.onload=function(){
		var today=new Date();
		var submitTime=today.getFullYear()+'-'+(today.getMonth()+1)+'-'+today.getDate(); 
		$("#createTime").attr('value',submitTime);
	} */
	function loadTime(){
		var today=new Date();
		var submitTime=today.getFullYear()+'-'+(today.getMonth()+1)+'-'+today.getDate(); 
		$("#createTime").attr('value',submitTime);
		$("#modifiedTime").attr('value',submitTime);
		$("#middleTime").attr('value',submitTime);
		$("#endTime").attr('value',submitTime);
	}
</script> 

<body onload="loadTime()">
<div style="padding:0px; margin:0px;">
    <ul class="breadcrumb" style="  margin:0px; " >
        <li><a href="#">项目审核</a></li>
        <li><a href="#">申报类型管理</a></li>
        <li>添加申报类型</li>
    </ul>
</div>

<form action="${pageContext.request.contextPath }/audit/declaretype/addDeclareType.action" method="post" onsubmit="saveData()" class="form-horizontal">
    <h5 class="page-header alert-info" style="padding:10px; margin:0px; margin-bottom:5px;">基本信息</h5>
    <!--开始 -->
    <div class="row">
        <div class="col-sm-5">
            <div class="form-group">
                <label class="col-sm-3 control-label">类型编号</label>
                <div class="col-sm-9">
                    <input type="text" name="typeId" class="form-control input-sm" placeholder="请输入类型编号" readonly="readonly"/>
                </div>
            </div>
        </div>
        <div class="col-sm-5">
            <div class="form-group">
                <label class="col-sm-3 control-label">类型名称</label>
                <div class="col-sm-9">
                    <input type="text" name="typeName" class="form-control input-sm" placeholder="请输入类型名称"/>
                </div>
            </div>
        </div>
    </div>
    <!-- 结束 -->

    <!--开始 -->
    <div class="row">
        <div class="col-sm-5">
            <div class="form-group">
                <label class="col-sm-3 control-label">创建时间</label>
                <div class="col-sm-9">
                    <input type="text" id="createTime" name="createTime" class="form-control input-sm" readonly="readonly"/>
                </div>
            </div>
        </div>
        <div class="col-sm-5">
            <div class="form-group">
                <label class="col-sm-3 control-label">修改时间</label>
                <div class="col-sm-9">
                    <input type="text" id="modifiedTime" name="modifiedTime" class="form-control input-sm" readonly="readonly"/>
                </div>
            </div>
        </div>
    </div>
    <!--结束 -->
    
    <!--开始 -->
    <div class="row">
        <div class="col-sm-5">
            <div class="form-group">
                <label class="col-sm-3 control-label">中期检查期限</label>
                <div class="col-sm-9">
                    <input type="text" id="middleTime" name="middleTime" class="form-control input-sm" onclick="WdatePicker({autoPickDate:true,dateFmt:'yyyy-MM-dd'})" readonly="readonly"/>
                </div>
            </div>
        </div>
        <div class="col-sm-5">
            <div class="form-group">
                <label class="col-sm-3 control-label">结题验收期限</label>
                <div class="col-sm-9">
                    <input type="text" id="endTime" name="endTime" class="form-control input-sm" onclick="WdatePicker({autoPickDate:true,dateFmt:'yyyy-MM-dd'})" readonly="readonly"/>
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
                    <textarea name="typeDescr" class="form-control" rows="3" cols="50" placeholder="请输入备注信息"></textarea>
                </div>
            </div>
        </div>
    </div>

    <div class="row">
        <div class="col-sm-3 col-sm-offset-4">
            <input  type="submit" class="btn btn-success" value="保存"/>
            <input  type="reset" class="btn btn-grey" value="取消"/>
            <a class="btn btn-warning" href="${pageContext.request.contextPath }/audit/declaretype/listDeclareType.action">返回上一级</a>
        </div>
    </div>
    
    <!-- 添加隐藏标识存储启用状态，由用户决定是否启用 -->
	<input type="hidden" id="startStatus" name="startStatus" />
</form>

	<script type="text/javascript">
		function saveData() {
			var info = window.confirm("您确认启用该申报项？");
			if (info) {
				$("#startStatus").val("1");
				return true;
			} else {
				// window.location.href = "${pageContext.request.contextPath }/marketactive/emailinfo/addEmailInfo.action?type=0";
				$("#startStatus").val("0");
				return true;
			}
		}
	</script>
</body>
</html>
