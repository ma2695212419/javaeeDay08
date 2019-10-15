<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>员工详细信息</title>
</head>
<body>
	操作者:&nbsp;&nbsp;&nbsp;&nbsp;${sessionScope.operator.nickname }
	<br>
	<a href="${pageContext.request.contextPath}/front/emp.action?methodName=logout">退出系统</a>
	<table align="center" border="1px" cellspacing="0px" cellpadding="0px" width="400px" height="400px">
		<tr align="center">
			<td>姓名:</td>
			<td>${requestScope.emp.nickname }</td>
		</tr>
		<tr align="center">
			<td>账号:</td>
			<td>${requestScope.emp.account }</td>
		</tr>
		<tr align="center">
			<td>性别:</td>
			<td>
				<c:if test="${emp.gender == 1}">男</c:if>
				<c:if test="${emp.gender == 2}">女</c:if>
			</td>
		</tr>
		<tr align="center">
			<td>生日:</td>
			<td>${requestScope.emp.birthday }</td>
		</tr>
		<tr align="center">
			<td>部门:</td>
			<td>${requestScope.emp.dept.name }</td>
		</tr>
		<tr align="center">
			<td colspan="2">
				<a href="${pageContext.request.contextPath}/front/emp.action?methodName=queryEmps">返回</a>
			</td>
		</tr>
	</table>
</body>
</html>