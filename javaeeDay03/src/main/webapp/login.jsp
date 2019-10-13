<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>用户登录</title>
</head>
<body>
	<form action="/javaeeDay03/user.action?methodName=login" method="post">
		账号：<input type="text" name="account" /><br />
		密码：<input type="password" name="password" /><br />
		<input type="submit" value="登录" />
	</form>
</body>
</html>