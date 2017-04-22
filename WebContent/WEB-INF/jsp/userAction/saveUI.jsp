<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ page import="com.shizongger.oa.domain.*" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
	<title>用户信息</title>
	<%@ include file="/WEB-INF/jsp/public/commons.jspf" %>
</head>
<body>

	<!-- 标题显示 -->
	<div id="Title_bar">
		<div id="Title_bar_Head">
			<div id="Title_Head"></div>
			<div id="Title">
				<!--页面标题-->
				<img src="style/images/title_arrow.gif" border="0" width="13" height="13"> 用户信息
			</div>
			<div id="Title_End"></div>
		</div>
	</div>

	<!--显示表单内容-->
	<div id="MainArea">
		<c:if test="${user.id != null }">
			<form action="user_update.action" method="post">
		</c:if>
		<c:if test="${user.id == null }">
			<form action="user_add.action" method="post">
		</c:if>
			<div class="ItemBlock_Title1">
				<!-- 信息说明 -->
				<div class="ItemBlock_Title1">
					<img src="style/blue/images/item_point.gif" border="0" width="4" height="7"> 用户信息
				</div>
			</div>

			<!-- 隐藏表单，提交需要更改的用户的id -->
			<input type="hidden" name="id" value="${user.id }"> 
			
			<!-- 表单内容显示 -->
			<div class="ItemBlockBorder">
				<div class="ItemBlock">
					<table class="mainForm" cellspacing="0" cellpadding="0">
						<tbody>
							<tr>
								<td width="100">所属部门</td>
								<td><select name="departmentId" class="SelectStyle">
										<option value="0">请选择部门</option>
										<c:forEach items="${departmentList }" var="department">
											<c:if test="${user.department.id == department.id }">
												<option value="${department.id }" selected="selected">${department.name }</option>
											</c:if>
											<c:if test="${user.department.id != department.id }">
												<option value="${department.id }">${department.name }</option>
											</c:if>
										</c:forEach>
								</select></td>
							</tr>
							<tr>
								<td>登录名</td>
								<td>
								<c:if test="${user.id != null }">
									<input name="loginName" class="InputStyle" type="text" value="${user.loginName }" readonly="readonly"> * （登录名要唯一）
								</c:if>
								<c:if test="${user.id == null }">
									<input name="loginName" class="InputStyle" type="text" value="${user.loginName }" > * （登录名要唯一）
								</c:if>
								
								</td>
							</tr>
							<tr>
								<td>姓名</td>
								<td><input name="name" class="InputStyle" type="text" value="${user.name }"> * </td>
							</tr>
							<tr>
								<td>性别</td>
								<td>
								<c:if test="${user.gender=='male' }">
									<input name="gender" value="male" id="male" type="RADIO" checked="checked"><labelfor="male">男</label>
									<input name="gender" value="female" id="female" type="RADIO"><label for="female">女</label>
								</c:if>
								<c:if test="${user.gender!='male' }">
									<input name="gender" value="male" id="male" type="RADIO"><labelfor="male">男</label>
									<input name="gender" value="female" id="female" type="RADIO" checked="checked"><label for="female">女</label>
								</c:if>
								</td>
							</tr>
							<tr>
								<td>联系电话</td>
								<td><input name="phoneNumber" class="InputStyle" type="text" value="${user.phoneNumber }"></td>
							</tr>
							<tr>
								<td>E-mail</td>
								<td><input name="email" class="InputStyle" type="text" value="${user.email }"></td>
							</tr>
							<tr>
								<td>备注</td>
								<td><textarea name="description" class="TextareaStyle" >${user.description }</textarea></td>
							</tr>
						</tbody>
					</table>
				</div>
			</div>

			<div class="ItemBlock_Title1">
				<!-- 信息说明 -->
				<div class="ItemBlock_Title1">
					<img src="style/blue/images/item_point.gif" border="0" width="4"
						height="7"> 岗位设置
				</div>
			</div>

			<!-- 表单内容显示 -->
			<div class="ItemBlockBorder">
				<div class="ItemBlock">
					<table class="mainForm" cellspacing="0" cellpadding="0">
						<tbody>
							<tr>
								<td width="100">岗位</td>
								<td><select name="roleIdList" multiple="true" size="10" class="SelectStyle">
										<c:forEach items="${roleList }" var="role">
											<option value="${role.id }">${role.name }</option>
										</c:forEach>
								</select> 按住Ctrl键可以多选或取消选择</td>
							</tr>
						</tbody>
					</table>
				</div>
			</div>

			<!-- 表单操作 -->
			<div id="InputDetailBar">
				<input src="style/images/save.png" type="image"> <a
					href="javascript:history.go(-1);"><img
					src="style/images/goBack.png"></a>
			</div>
		</form>
	</div>

	<div class="Description">
		说明：<br> 1，用户的登录名要唯一，在填写时要同时检测是否可用。<br>
		2，新建用户后，密码被初始化为"1234"。<br> 3，密码在数据库中存储的是MD5摘要（不是存储明文密码）。<br>
		4，用户登录系统后可以使用“个人设置→修改密码”功能修改密码。<br>
		5，新建用户后，会自动指定默认的头像。用户可以使用“个人设置→个人信息”功能修改自已的头像<br>
		6，修改用户信息时，登录名不可修改。
	</div>
</body>
</html>