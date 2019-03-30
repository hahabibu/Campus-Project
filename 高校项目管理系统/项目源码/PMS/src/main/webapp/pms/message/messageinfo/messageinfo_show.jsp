<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
	<meta charset="utf-8">
	<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
	<title>首页</title>
	<%@include file="/pms/public/commons.jspf"%>
</head>

<body>
<div style="padding:0px; margin:0px;">
 <ul class="breadcrumb" style="  margin:0px; " >
    	<li><a href="#">消息管理</a></li>
        <li><a href="#">历史记录</a></li>
        <li>查看消息详情</li>
  </ul>
</div>

<form action="" class="form-horizontal">
    <h5 class="page-header alert-info" style="padding:10px; margin:0px; margin-bottom:5px;">基本信息</h5>
	<div class="row">
    	<div class="col-sm-5">
        	<div class="form-group">
            	<label class="col-sm-3 control-label">消息编号</label>
                <div class="col-sm-9">
                	<input type="text" name="messageId" value="${messageInfo.messageId }" class="form-control input-sm" readonly="readonly"/>
                </div>
            </div>
        </div>
        <div class="col-sm-5">
            <div class="form-group">
            	<label class="col-sm-3 control-label">接收对象</label>
                <div class="col-sm-9">
                	<input type="text" name="receiver" value="${messageInfo.receiverName }"  class="form-control input-sm" readonly="readonly" />
                </div>
            </div>
        </div>
    </div>
    
    <div class="row">
    	<div class="col-sm-5">
        	<div class="form-group">
            	<label class="col-sm-3 control-label">创建时间</label>
                <div class="col-sm-9">
                	<input type="text" name="createTime" value="<fmt:formatDate value="${messageInfo.createTime }" pattern="yyyy-MM-dd" type="both"/>"/>
                </div>
            </div>
        </div>
        <div class="col-sm-5">
            <div class="form-group">
            	<label class="col-sm-3 control-label">已读状态</label>
                <div class="col-sm-9">
                	<input type="text" name="readStatusContext" value="${messageInfo.readStatusContext }" class="form-control input-sm" placeholder="已读状态" readonly="readonly"/>
                </div>
            </div>
        </div>
    </div>
    
    <h5 class="page-header alert-info" style="padding:10px; margin:0px; margin-bottom:5px;">消息详情</h5>
    	<div class="row">
	    	<div class="col-sm-10">
	        	<div class="form-group">
	            	<label class="col-sm-3 control-label">消息类型</label>
	                <div class="col-sm-9">
	                	<input type="text" name="messageType" readonly="readonly" value="${messageInfo.messageType }" class="form-control input-sm" placeholder="请输入消息类型"/>
	                </div>
	            </div>
	        </div>
	    </div>
	   
    	<div class="row">
	    	<div class="col-sm-10">
	        	<div class="form-group">
	            	<label class="col-sm-3 control-label">消息内容</label>
	                <div class="col-sm-9">
	                	<textarea class="form-control" readonly="readonly">${messageInfo.messageContent }</textarea>
	                </div>
	            </div>
	        </div>
	    </div>
	    
	    <div class="row">
	        <div class="col-sm-3 col-sm-offset-4">
	            <a class="btn btn-warning" href="${pageContext.request.contextPath}/message/messageinfo/listMessageInfo.action">返回上一级</a> 
	            <%-- <a href="javascript:readData('${messageInfo.messageId }')">已读</a> --%>
	        </div>
	    </div>
	    
	  <!--   <script type="text/javascript">
		    function readData(messageId) {
				alert(messageId);
				var url = "${pageContext.request.contextPath}/message/messageinfo/readMessageInfo.action?messageId=" + messageId;
	 			window.location.href = url; 
			}
	    </script> -->
</form>

</body>
</html>
