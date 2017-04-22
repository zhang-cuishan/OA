<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix ="s" uri="/struts-tags"%>
<%@ page import="com.shizongger.oa.domain.*" %> 
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
	<title>导航菜单</title>
	<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
	<script language="JavaScript" src="${pageContext.request.contextPath }/script/jquery.js"></script>
	<script language="JavaScript" src="${pageContext.request.contextPath }/script/menu.js"></script>
	<link type="text/css" rel="stylesheet" href="style/blue/menu.css">
	<script type="text/javascript">
		function menuClick(menu) {
			$(menu).next("ul").toggle();
		}		
	</script>
</head>
<body style="margin: 0">
	<div id="Menu">
		<ul id="MenuUl">
			<%-- 显示一级菜单 --%>
			<s:iterator value="#application.topPrivilegeList">
				<s:if test="#session.user.hasPrivilegeByName(name)">
				<li class="level1">
					<div onClick="menuClick(this);" class="level1Style">
						<img src="style/images/MenuIcon/${id}.gif" class="Icon" />
						${name}
					</div>
					<ul style="" class="MenuLevel2" id="aa">
						<%-- 显示二级菜单 --%>
						<s:iterator value="children">
							<s:if test="#session.user.hasPrivilegeByName(name)">
							<li class="level2">
								<div class="level2Style">
									<img src="style/images/MenuIcon/menu_arrow_single.gif" />
									<a target="right" href="${pageContext.request.contextPath}${url}.action"> ${name}</a>
								</div>
							</li>
							</s:if>
						</s:iterator>
					</ul> 
				</li>
				</s:if>
			</s:iterator>
		</ul>
	</div>
</body>
</html>