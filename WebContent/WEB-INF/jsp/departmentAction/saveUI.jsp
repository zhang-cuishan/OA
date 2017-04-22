<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ page import="com.shizongger.oa.domain.*" %>  	
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<title>部门设置</title>
<%@ include file="/WEB-INF/jsp/public/commons.jspf" %>
</head>
<body>

	<!-- 标题显示 -->
	<div id="Title_bar">
		<div id="Title_bar_Head">
			<div id="Title_Head"></div>
			<div id="Title">
				<!--页面标题-->
				<img src="style/images/title_arrow.gif" height="13" border="0"
					width="13"> 部门信息
			</div>
			<div id="Title_End"></div>
		</div>
	</div>

	<!--显示表单内容-->
	<div id="MainArea">
		<c:if test="${department.id == null}">
			<form action="department_add.action" method="post">
		</c:if>
		<c:if test="${department.id != null }">
			<form action="department_edit.action" method="post">
		</c:if>
			<div class="ItemBlock_Title1">
				<!-- 信息说明<DIV CLASS="ItemBlock_Title1">
        	<IMG BORDER="0" WIDTH="4" HEIGHT="7" SRC="style/blue/images/item_point.gif" /> 部门信息 </DIV>  -->
			</div>
			
			<!-- 隐藏表单，提交需要更改的用户的id -->
			<input type="hidden" name="id" value="${department.id }"> 
			<!-- 表单内容显示 -->
			<div class="ItemBlockBorder">
				<div class="ItemBlock">
					<table class="mainForm" cellspacing="0" cellpadding="0">
						<tbody>
							<tr>
								<td width="100">上级部门</td>
								<td>
								<select name="parentId" class="SelectStyle">
										<option value="0" selected="selected">请选择部门</option>
										<c:forEach items="${deptList }" var="dept">
											<c:if test="${dept.id == parentId }">
												<option value="${dept.id }" selected="selected">${dept.name }</option>
											</c:if>
											<c:if test="${dept.id != parentId }">
												<option value="${dept.id }">${dept.name }</option>
											</c:if>											
										</c:forEach>
								</select>
								</td>
							</tr>
							<tr>
								<td>部门名称</td>
								<td><input name="name" class="InputStyle" type="text" value="${department.name }"> * </td>
							</tr>
							<tr>
								<td>职能说明</td>
								<td>
									<textarea name="description" class="TextareaStyle">${department.description }</textarea>
								</td>
							</tr>
						</tbody>
					</table>
				</div>
			</div>

			<!-- 表单操作 -->
			<div id="InputDetailBar">
				<input src="style/images/save.png" type="image">
				<a href="javascript:history.go(-1);">
				<img src="style/images/goBack.png"></a>
			</div>
		</form>
	</div>

	<div class="Description">
		说明：<br> 1，上级部门的列表是有层次结构的（树形）。<br>
		2，如果是修改：上级部门列表中不能显示当前修改的部门及其子孙部门。因为不能选择自已或自已的子部门作为上级部门。<br>
	</div>

</body>
</html>