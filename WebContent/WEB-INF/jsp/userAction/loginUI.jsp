<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=gbk">
	<title>Itcast OA</title>
	<link href="${pageContext.request.contextPath }/style/blue/login.css" type="text/css" rel="stylesheet">
</head>
<body leftmargin="0" topmargin="0" class="PageBody" marginwidth="0" marginheight="0">
<form method="post" name="actForm" action="${pageContext.request.contextPath }/user_login.action">
    <div id="CenterAreaBg">
        <div id="CenterArea">
            <div id="LogoImg"><img src="${pageContext.request.contextPath }/style/blue/images/logo.png" border="0"></div>
            <div id="LoginInfo">
                <table width="100%" cellspacing="0" cellpadding="0" border="0">
                    <tbody><tr>
                        <td class="Subject" width="45"><img src="${pageContext.request.contextPath }/style/blue/images/login/userId.gif" border="0"></td>
                        <td><input size="20" class="TextField" name="loginName" type="text"></td>
                        <td rowspan="2" style="padding-left:10px;"><input src="${pageContext.request.contextPath }/style/blue/images/login/userLogin_button.gif" type="image"></td>
                    </tr>
                    <tr>
                        <td class="Subject"><img src="${pageContext.request.contextPath }/style/blue/images/login/password.gif" border="0"></td>
                        <td><input size="20" class="TextField" name="password" type="password"></td>
                    </tr>
                </tbody></table>
            </div>
            <div id="CopyRight"><a href="javascript:void(0)">&copy; 2010 版权所有 itcast</a></div>
        </div>
    </div>
</form>
</body>
</html>