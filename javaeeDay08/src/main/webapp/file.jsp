<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>图片上传</title>
</head>
<body>
		<form action="${pageContext.request.contextPath}/img.action?methodName=upload" method="post" enctype="multipart/form-data">
			<input type="file" name="upfile" id="" value="" />
			<input type="submit" value="上传"/>
		</form>
		<a href="http://localhost:8080/javaeeDay08/img.action?methodName=download&filename=139ce2100b82a19f667451086aa5bd0697eaefc2f08c8b.zip">下载</a>
</body>
</html>