<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ page import="com.shizongger.oa.domain.*" %> 
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
	<title>配置权限</title>
	<%@ include file="/WEB-INF/jsp/public/commons.jspf" %>
</head>
<body>

<!-- 标题显示 -->
<div id="Title_bar">
    <div id="Title_bar_Head">
        <div id="Title_Head"></div>
        <div id="Title"><!--页面标题-->
            <img src="${pageContext.request.contextPath }/style/images/title_arrow.gif" width="13" height="13" border="0"> 配置权限
        </div>
        <div id="Title_End"></div>
    </div>
</div>

<!--显示表单内容-->
<div id="MainArea">
    <form action="role_setPrivilege.action">
        <div class="ItemBlock_Title1"><!-- 信息说明 --><div class="ItemBlock_Title1">
        	<img src="${pageContext.request.contextPath }/style/blue/images/item_point.gif" width="4" height="7" border="0"> 正在为【${name }】配置权限 </div> 
        </div>
        
        <!-- 隐藏表单 -->
		<input type="hidden" name="id" value="${id }" />
		        
        <!-- 表单内容显示 -->
        <div class="ItemBlockBorder">
            <div class="ItemBlock">
                <table class="mainForm" cellspacing="0" cellpadding="0">
					<!--表头-->
					<thead>
						<tr id="TableTitle" valign="MIDDLE" align="LEFT">
							<td style="padding-left: 7px;" width="300px">
								<!-- 如果把全选元素的id指定为selectAll，并且有函数selectAll()，就会有错。因为有一种用法：可以直接用id引用元素 -->
								<input id="cbSelectAll" onClick="$('[name=privilegeIds]').attr('checked', this.checked)" type="CHECKBOX">
								<label for="cbSelectAll">全选</label>
							</td>
						</tr>
					</thead>
                   
			   		<!--显示数据列表-->
					<tbody id="TableData">
						<tr class="TableDetail1">
							<!-- 显示权限树 -->
							<td>
								<ul id="tree" class="treeview">
									<c:forEach items="${privilegeList }" var="privilege">
									<li id="li_128">
										<input name="privilegeIds" type="checkbox" value="${privilege.id }">
										<label for="cb_128"><span class="folder" id="128">${privilege.name }</span></label>
									</li>									
									</c:forEach>
								</ul>
							</td>
						</tr>
					</tbody>
                </table>
            </div>
        </div>
        
        <!-- 表单操作 -->
        <div id="InputDetailBar">
            <input src="${pageContext.request.contextPath }/style/images/save.png" type="image">
            <a href="javascript:history.go(-1);"><img src="${pageContext.request.contextPath }/style/images/goBack.png"></a>
        </div>
    </form>
</div>

<div class="Description">
	说明：<br>
	1，选中一个权限时：<br>
	&nbsp;&nbsp;&nbsp;&nbsp; a，应该选中 他的所有直系上级。<br>
	&nbsp;&nbsp;&nbsp;&nbsp; b，应该选中他的所有直系下级。<br>
	2，取消选择一个权限时：<br>
	&nbsp;&nbsp;&nbsp;&nbsp; a，应该取消选择 他的所有直系下级。<br>
	&nbsp;&nbsp;&nbsp;&nbsp; b，如果同级的权限都是未选择状态，就应该取消选中他的直接上级，并递归向上做这个操作。<br>
	3，全选/取消全选。<br>
	4，默认选中当前岗位已有的权限。<br>
</div>
</body>
</html>