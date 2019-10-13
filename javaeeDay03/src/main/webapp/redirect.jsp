<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>网页重定向</title>
</head>
<body>
	<form action="/redirect01.action" method="post">
		账号: <input type="text" name="account" id=""> 
		密码: <input type="password" name="password" id=""> 
		<input type="submit" value="登录">
	</form>
	http://localhost:8080/redirect03.action<br>
	Status Code: 302 Found<br>
	Location: http://localhost:8080/redirect02.action<br>
	Status Code: 302 Found<br>
	Location: http://localhost:8080/redirect03.action<br>
	跳转<br>
	概述<br>
		在servlet中实现资源的跳转。包含请求转发和重定向两种方式<br>
	重定向<br>
		概述<br>
			请求发送给服务器后，服务器产生新的地址并发送给客户端；<br>
			客户端接收到新地址后重新发送请求并得到响应。<br>
		实现<br>
			response对象.sendRedirect(URL);<br>
	请求转发<br>
		概述<br>
			请求发送给服务器，服务器经过内部跳转后将响应结果发送给客户端。<br>
		实现<br>
			request对象.getRequestDispatcher(URL).forward(request对象，response对象);<br>

	问<br>
		请求转发与重定向有什么不同？<br>
		1、重定向地址栏发生改变；请求转发地址栏不发生改变<br>
		2、重定向需要进行二次跳转；请求转发一次跳转完成<br>
		3、重定向过程中参数会丢失；请求转发过程中参数不会丢失<br>
		4、重定向可以跳转到服务器以外的资源；请求转发无法跳转到服务器以外的资源<br>
		5、重定向一次跳转后返回302码及ULR地址；请求转发直接返回200<br>

	使用<br>
		1、重定向：a、服务器外的跳转；b、浏览器地址栏需要改变<br>
		2、请求转发：a、不访问外部资源；b、不能丢参数失<br>
</body>
</html>