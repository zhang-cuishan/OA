<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ page import="com.shizongger.oa.domain.*" %>    
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
	<head>
	    <title>岗位列表</title>
		<%@ include file="/WEB-INF/jsp/public/commons.jspf" %>
	</head>
	<body>
	 
	<div id="Title_bar">
	    <div id="Title_bar_Head">
	        <div id="Title_Head"></div>
	        <div id="Title"><!--页面标题-->
	            <img src="${pageContext.request.contextPath }/style/images/title_arrow.gif" height="13" border="0" width="13"> 岗位管理
	        </div>
	        <div id="Title_End"></div>
	    </div>
	</div>
	
	<div id="MainArea">
	    <table class="TableStyle" cellspacing="0" cellpadding="0">
	       
	        <!-- 表头-->
	        <thead>
	            <tr id="TableTitle" valign="MIDDLE" align="CENTER">
	            	<td width="200px">岗位名称</td>
	                <td width="300px">岗位说明</td>
	                <td>相关操作</td>
	            </tr>
	        </thead>
	
			<!--显示数据列表-->
	        <tbody id="TableData" class="dataContainer" datakey="roleList">
				<c:forEach items="${roleList }" var="role">
		        	<tr class="TableDetail1 demodata_record">
						<td>${role.name }&nbsp;</td>
						<td>${role.description }&nbsp;</td>
						<td><a onclick="return delConfirm()" href="role_delete.action?id=${role.id }">删除</a>
							<a href="role_updateUI.action?id=${role.id }">修改</a>
							<a href="role_privilegeUI.action?id=${role.id }">设置权限</a>
						</td>
					</tr>
				</c:forEach>
			</tbody>
	    </table>
	    
	    <!-- 其他功能超链接 -->
	    <div id="TableTail">
	        <div id="TableTail_inside">
	            <a href="role_addUI.action"><img src="${pageContext.request.contextPath }/style/images/createNew.png"></a>
	        </div>
	    </div>
	</div>
	</body>
</html>