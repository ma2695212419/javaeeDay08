<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>网页重定向</title>
</head>
<body>
	<form action="/session01.action" method="post">
		账号: <input type="text" name="account" id=""> 密码: <input
			type="password" name="password" id=""> <input type="submit"
			value="登录">
	</form>
	Cookie: JSESSIONID=node01vst2q3tdht8n2xh8bpscrml31.node0
	<br> 我是Session01的sessionId = node01vst2q3tdht8n2xh8bpscrml31
	<br> 我是Session02的sessionId = node01vst2q3tdht8n2xh8bpscrml31
	<br> 我是Session03的sessionId = node01vst2q3tdht8n2xh8bpscrml31
</body>
</html>