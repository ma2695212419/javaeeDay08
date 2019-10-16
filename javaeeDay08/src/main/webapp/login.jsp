<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>用户登录</title>
<script src="${pageContext.request.contextPath}/webjars/jquery/3.4.1/dist/jquery.min.js" type="text/javascript" charset="utf-8"></script>
<script src="${pageContext.request.contextPath}/js/login.js" type="text/javascript" charset="utf-8"></script>
</head>
<body>
	<%-- ${pageContext.request.contextPath} 获取上下文 --%>
	<form id="loginForm" action="${pageContext.request.contextPath}/front/emp.action?methodName=login" method="post">
		账号：<input type="text" id="account" name="account" /><br /> 
		密码：<input type="password" id="password" name="password" /><br /> 
	</form>
	<button id="loginBtn">登录</button>
	<span>${requestScope.status }</span>
</body>
</html>