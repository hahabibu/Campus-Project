<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
 <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
 <%@ taglib uri="http://displaytag.sf.net" prefix="display"%>
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
    	<li><a href="#">站内消息</a></li>
        <li>历史记录</li>
    </ul>
</div>
<div class="row alert alert-info"  style="margin:0px; padding:3px;" >
	<form action="${pageContext.request.contextPath }/message/messageinfo/listMessageInfo.action" method="post" class="form-horizontal">
		<div class="col-sm-1">记录类型</div>
	    <div class="col-sm-3">
	    	<!-- <input type="text" name="messageType" class="form-control input-sm"/> -->
	    	<select name="messageType">
	    		<option value="pass">默认所有</option>
	    		<c:forEach var="messageType" items="${messageTypeList }">
	    			<option value="${messageType.dataId }">${messageType.dataContent }</option>
	    		</c:forEach>
	    	</select>
	    </div>
	    <input type="submit" class="btn btn-danger" value="查询"/>
    </form>
</div>

 <!-- 提示信息 -->
	<div align="center">
		<div class="alert alert-warning"
			style="margin: 0px; padding: 5px; width: 80%;display:${empty info?'none':'block'} ">
			<button type="button" class="close" data-dismiss="alert">
				<span aria-hidden="true">&times;</span>

			</button>
			<p align="center" style="color: red;">消息管理-${info}</p>
		</div>
	</div>

    <div class="row" style="padding: 15px; padding-top: 0px;">
        <display:table class="table  table-condensed table-striped"
                       name="list" pagesize="10"
                       requestURI="${pageContext.request.contextPath }/user/userinfo/listUserInfo.action">
            <%-- <display:column property="messageId" title="消息编号"></display:column> --%>
            <display:column property="messageType" title="用户名称"></display:column>
            <display:column property="messageContent" title="电子邮箱"></display:column>
            <%-- <display:column property="userState" title="用户状态"></display:column> --%>
            <display:column property="createTime" title="生成时间" format="{0,date,yyyy年MM月dd日}"></display:column>
            <%-- <display:column property="receiver" title="接收人id"></display:column> --%>
            <display:column property="receiverName" title="接收人"></display:column>
            <%-- <display:column property="readStatus" title="已读状态"></display:column> --%>
            <display:column property="readStatusContext" title="已读状态"></display:column>

            
            <display:column
                    href="${pageContext.request.contextPath }/message/messageinfo/showMessageInfo.action"
                    paramId="messageId" paramProperty="messageId" title="查看" value="查看">
            </display:column>
            
            <display:column
                    href="${pageContext.request.contextPath }/message/messageinfo/deleteMessageInfo.action"
                    paramId="messageId" paramProperty="messageId" title="删除" value="删除">
            </display:column>
        </display:table>
    </div>


<%-- <div class="row" style="padding:15px; padding-top:0px; ">
	<table class="table  table-condensed table-striped">
    	<tr>
        	<th>消息编号</th>
            <th>接收对象</th>
            <th>创建时间</th>
            <th>已读状态</th>
            <th>消息类型</th>
            <th>消息内容</th>
            <th>操作</th>
        </tr>
        <c:forEach var="messageinfo" items="${messageinfoList }">
        	<tr>
	        	<td>${messageinfo.messageId }</td>
	            <td>${messageinfo }</td>
	            <td>${messageinfo }</td>
	            <td>${messageinfo }</td>
				<td>${messageinfo }</td>
				<td>${messageinfo }</td>
				<th>
					<a href="${pageContext.request.contextPath }/message/messageinfo/showMessageInfo.action">查看</a>
				</th>
	        </tr>
        </c:forEach>
    </table>
</div> --%>

</body>
</html>
