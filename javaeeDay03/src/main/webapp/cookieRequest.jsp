<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>cookieRequest</title>
</head>
<body>
	<!-- 
	<a href="/javaeeDay03/cookie.action?methodName=writeCookie">设置Cookie</a>
	<a href="/javaeeDay03/cookie.action?methodName=readCookie">读取cookie1</a> 
	-->
	<a href="${pageContext.request.contextPath}/cookie.action?methodName=writeCookie">设置Cookie</a>
	<a href="${pageContext.request.contextPath}/cookie.action?methodName=readCookie">读取cookie1</a>
	<a href="/shop/car">读取cookie2</a>
	<hr />
	<a href="/sessionAction?methodName=addSession">设置session</a>
	<a href="/sessionAction?methodName=readSession">读取session</a>
	<br>Content-Type: text/html;charset=iso-8859-1
	<br>Content-Type: text/html;charset=utf-8
	<br>c1=2019-07-17 11:20:30; c2=2019-07-17 11:20:30; c3=2019-07-17 11:20:30; JSESSIONID=node01hmyzzquenyaccqmat8gaf3d41.node0
	<br>c1=2019-07-17 11:20:30
	<br>c2=2019-07-17 11:20:30
	<br>c3=2019-07-17 11:20:30
	<br>JSESSIONID=node01hmyzzquenyaccqmat8gaf3d41.node0
	<br>状态保持<br>
	Cookie<br>
		概述<br>
			由服务器端进行创建，保存在客户端（硬盘——物理文件<br>
		为什么有Cookie<br>
			1、解决Http协议的无状态<br>
			2、存储系统信息（为了程序提高用户体验性）<br>

		为什么有的Cookie浏览器重新打开后就消失了？<br>
			Cookie可以分为：内存中的Cookie和文件中的Cookie<br>
		缺点<br>
			1、安全性较低<br>
			2、可以被禁用<br>

		重点（应用）<br>
			1、Cookie的创建及读取<br>
			2、设置过期时间及访问路径<br>
		

	Session	<br>
		概述<br>
			表示一次会话（浏览器打开到浏览器关闭）。Session存储在服务器的内存中。<br>
		为什么有Session<br>
			1、解决HttpServlet协议的无状态<br>
			2、存储系统信息（为了程序提高用户体验性）<br>
		重点（应用）<br>
			1、获取Session对象<br>
				HttpSession session = request对象.getSession();<br>
			2、设置Session的值<br>
				session对象.setAttribute("名"，值);<br>	
			3、读取Session的值<br>
				Session对象.getAttribute("名");<br>
			4、移除Session的属性值<br>
				Session对象.removeAttribute("名");<br>
			5、设置过期时间<br>
				session对象.setMaxInactiveInterval(秒)<br>
			6、session失效<br>
				session对象.invalidate();<br>

		session的特点<br>
			1、session无法删除<br>

	Cookie与Session区别<br>
		1、Session存储在服务器端；Cookie存储在客户端<br>
		2、Session存储在内存中；Cookie存储在硬盘中<br>
		3、Session的安全性较高；Cookie的安全性较低<br>
		4、Session可以存储较大的数据；Cookie存储的数据量较小（10K）<br>
		5、Session的读取效率较高；Cookie的读取效率较低<br>
</body>
</html>