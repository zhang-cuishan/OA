<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ page import="com.shizongger.oa.domain.*" %>  	
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
	<head>
		<title>岗位设置</title>
		<%@ include file="/WEB-INF/jsp/public/commons.jspf" %>
	</head>
	<body> 
	
	<!-- 标题显示 -->
	<div id="Title_bar">
	    <div id="Title_bar_Head">
	        <div id="Title_Head"></div>
	        <div id="Title"><!--页面标题-->
	            <img src="${pageContext.request.contextPath }/style/images/title_arrow.gif" height="13" border="0" width="13"> 岗位设置
	        </div>
	        <div id="Title_End"></div>
	    </div>
	</div>
	
	<!--显示表单内容-->
	<div id="MainArea">
		<c:if test="${role.id == null }">
			<form action="role_add.action" method="post">
		</c:if>
		<c:if test="${role.id != null }">
			<form action="role_update.action" method="post">
		</c:if>
	    
	    	<!-- 隐藏的id -->
	    	<input type="hidden" name="id" value="${role.id }">
	    
	        <div class="ItemBlock_Title1"><!-- 信息说明<DIV CLASS="ItemBlock_Title1">
	        	<IMG BORDER="0" WIDTH="4" HEIGHT="7" SRC="${pageContext.request.contextPath }/style/blue/images/item_point.gif" /> 岗位信息 </DIV>  -->
	        </div>
	        
	        <!-- 表单内容显示 -->
	        <div class="ItemBlockBorder">
	            <div class="ItemBlock">
	                <table class="mainForm" cellspacing="0" cellpadding="0">
	                    <tbody><tr>
	                        <td width="100">岗位名称</td>
	                        <td><input name="name" class="InputStyle" type="text" value="${role.name }"> *</td>
	                    </tr>
	                    <tr>
	                        <td>岗位说明</td>
	                        <td><textarea name="description" class="TextareaStyle">${role.description }</textarea></td>
	                    </tr>
	                </tbody></table>
	            </div>
	        </div>
	        
	        <!-- 表单操作 -->
	        <div id="InputDetailBar">
	            <input src="${pageContext.request.contextPath }/style/images/save.png" type="image">
	            <a href="javascript:history.go(-1);"><img src="${pageContext.request.contextPath }/style/images/goBack.png"></a>
	        </div>
	    </form>
	</div>
	
	</body>
</html>