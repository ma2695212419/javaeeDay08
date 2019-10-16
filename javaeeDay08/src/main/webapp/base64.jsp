<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>base64</title>
<script src="${pageContext.request.contextPath}/webjars/jquery/3.4.1/dist/jquery.min.js" type="text/javascript" charset="utf-8"></script>
<script src="${pageContext.request.contextPath}/res/jquery.base64.js" type="text/javascript" charset="utf-8"></script>
</head>
<body>
	<script type="text/javascript">
		/*
			$.base64.encode(str)	加密
			$.base64.decode(str)	解密
			$.base64.btoa(str)  	加密
			$.base64.atob(str)  	解密
		*/
		let encoder = $.base64.encode("admin")
		let decoder = $.base64.decode(encoder)
		window.console.log(encoder)
		window.console.log(decoder)
		let btoa = window.btoa("admin")
		let atob = window.atob(btoa)
		window.console.log(btoa)
		window.console.log(atob)
	</script>
</body>
</html>