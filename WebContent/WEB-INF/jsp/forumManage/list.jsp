<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html><head>
    <title>版块列表</title>
	<%@ include file="/WEB-INF/jsp/public/commons.jspf" %>    
    <script type="text/javascript">
    </script>
</head>
<body>

<div id="Title_bar">
    <div id="Title_bar_Head">
        <div id="Title_Head"></div>
        <div id="Title"><!--页面标题-->
            <img src="${pageContext.request.contextPath }/style/images/title_arrow.gif" width="13" height="13" border="0"> 版块管理
        </div>
        <div id="Title_End"></div>
    </div>
</div>

<div id="MainArea">
    <table class="TableStyle" cellspacing="0" cellpadding="0">
       
        <!-- 表头-->
        <thead>
            <tr id="TableTitle" valign="MIDDLE" align="CENTER">
            	<td width="250px">版块名称</td>
                <td width="300px">版块说明</td>
                <td>相关操作</td>
            </tr>
        </thead>

		<!--显示数据列表-->
        <tbody id="TableData" class="dataContainer" datakey="forumList">
			
        <tr class="TableDetail1 demodata_record">
				<td>JavaSE/JavaEE&nbsp;</td>
				<td>Java开发有关的讨论都过来发帖&nbsp;</td>
				<td><a onclick="return delConfirm()" href="list.html">删除</a>
					<a href="saveUI.html">修改</a>
					<a href="#">上移</a>
					<a href="#">下移</a>
				</td>
			</tr><tr class="TableDetail1 demodata_record">
				<td>新功能建议&nbsp;</td>
				<td>把好的想法、先进思想和理念都随时提出来，供产品修改时使用&nbsp;</td>
				<td><a onclick="return delConfirm()" href="list.html">删除</a>
					<a href="saveUI.html">修改</a>
					<a href="#">上移</a>
					<a href="#">下移</a>
				</td>
			</tr><tr class="TableDetail1 demodata_record">
				<td>灌水专区&nbsp;</td>
				<td>大家可以尽情的来这里灌水&nbsp;</td>
				<td><a onclick="return delConfirm()" href="list.html">删除</a>
					<a href="saveUI.html">修改</a>
					<a href="#">上移</a>
					<a href="#">下移</a>
				</td>
			</tr></tbody>
    </table>
    
    <!-- 其他功能超链接 -->
    <div id="TableTail">
        <div id="TableTail_inside">
            <a href="forumManage_addUI.action"><img src="${pageContext.request.contextPath }/style/images/createNew.png"></a>
        </div>
    </div>
</div>

<div class="Description">
	说明：<br>
	1，显示的列表按其sortOrder值升序排列。<br>
	2，可以通过上移与下移功能调整顺序。最上面的不能上移，最下面的不能下移。<br>
</div>



</body></html>