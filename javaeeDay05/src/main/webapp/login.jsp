<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>用户登录</title>
</head>
<body>
	<%-- ${pageContext.request.contextPath} 获取上下文 --%>
	<form action="${pageContext.request.contextPath}/front/emp.action?methodName=login" method="post">
		账号：<input type="text" name="account" /><br /> 
		密码：<input type="password" name="password" /><br /> 
		<input type="submit" value="登录" />
	<span>${requestScope.status }</span>
	</form>
	<img alt="" src="${pageContext.request.contextPath}/img/login.png">
</body>
</html>