<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
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
    	<li><a href="#">系统管理</a></li>
        <li>数据字典</li>
        <li>修改数据</li>
    </ul>
</div>

<form action="${pageContext.request.contextPath }/system/datadictionary/updateDataDictionary.action" method="post" class="form-horizontal">
    <h5 class="page-header alert-info" style="padding:10px; margin:0px; margin-bottom:5px;">基本信息</h5>
	<div class="row">
    	<div class="col-sm-5">
        	<div class="form-group">
            	<label class="col-sm-3 control-label">数据编号</label>
                <div class="col-sm-9">
                	<input type="text" name="dataId" value="${dataDictionary.dataId }" class="form-control input-sm" placeholder="请输入编号" readonly="readonly"/>
                </div>
            </div>
        </div>
        <div class="col-sm-5">
            <div class="form-group">
            	<label class="col-sm-3 control-label">数据内容</label>
                <div class="col-sm-9">
                	<input type="text" name="dataContent" value="${dataDictionary.dataContent }" class="form-control input-sm" placeholder="请输入数据内容"/>
                </div>
            </div>
        </div>
    </div>
    
   	<div class="row">
    	<div class="col-sm-5">
        	<div class="form-group">
            	<label class="col-sm-3 control-label">所属类型</label>
                <div class="col-sm-9">
                	<input type="text" name="dataType" value="${dataDictionary.dataType }" class="form-control input-sm" placeholder="请输入数据所属类型"/>
                </div>
            </div>
        </div>
    </div>
    
    <h5 class="page-header alert-info" style="padding:10px; margin:0px; margin-bottom:5px;">描述信息</h5>
    	<div class="row">
    	<div class="col-sm-10">
        	<div class="form-group">
            	<label class="col-sm-3 control-label">数据描述</label>
                <div class="col-sm-9">
                	<textarea class="form-control" name="dataDescr" placeholder="请输入数据描述">${dataDictionary.dataDescr }</textarea>
                </div>
            </div>
        </div>
    </div>
 
   	<div class="row">
    	<div class="col-sm-3 col-sm-offset-4">
        	<input  type="submit" class="btn btn-success" value="保存"/>
            <a class="btn btn-warning" href="${pageContext.request.contextPath }/system/datadictionary/listDataDictionary.action">返回上一级</a>
        </div>
    </div>
</form>

</body>
</html>