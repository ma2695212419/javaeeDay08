<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>员工管理系统</title>
</head>
<body>
	操作者:&nbsp;&nbsp;&nbsp;&nbsp;${sessionScope.operator.nickname }
	<br>
	<a href="${pageContext.request.contextPath}/front/emp.action?methodName=logout">退出系统</a>
	<table algin="center" border="1px" cellspacing="0px">
		<tr>
			<td>姓名</td>
			<td>性别</td>
			<td>部门</td>
		</tr>
		<c:forEach items="${requestScope.empList }" var="e">
			<tr>
				<td>${e.nickname }</td>
				<td>
					<c:if test="${e.gender == 1}">男</c:if>
					<c:if test="${e.gender == 2}">女</c:if>
				</td>
				<td>${e.dept.id }</td>
			</tr>
		</c:forEach>
	</table>
</body>
</html>