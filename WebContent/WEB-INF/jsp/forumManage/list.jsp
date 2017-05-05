<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html><head>
    <title>版块列表</title>
	<%@ include file="/WEB-INF/jsp/public/commons.jspf" %>    
    <script type="text/javascript">
    </script>
    <style type="text/css">
    	.disabled{
    		color: gray;
    		cursor: pointer;
    	}    
    </style>
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
        
        <!-- 遍历forumList -->
        <s:iterator value="#forumList" status="status">
			<tr class="TableDetail1 demodata_record">
				<td>${name }&nbsp;</td>
				<td>${description }&nbsp;</td>
				<td>
					<s:a action="forumManage_delete?id=%{id}" onclick="return delConfirm()">删除</s:a>
					<s:a action="forumManage_editUI?id=%{id }">修改</s:a>
					<!-- 最上面不能往上移 -->
					<s:if test="#status.first">
						<span class="disabled">上移</span>
					</s:if>
					<s:else>
						<s:a action="forumManage_moveUp?id=%{id }">上移</s:a>
					</s:else>
					<!-- 最下面的不能再往下移动 -->
					<s:if test="#status.last">
						<span class="disabled">下移</span>
					</s:if>
					<s:else>
						<s:a action="forumManage_moveDown?id=%{id }">下移</s:a>
					</s:else>
				</td>
			</tr>
		</s:iterator>
		</tbody>
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