<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
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
	<table border="1px" cellspacing="0px" cellpadding="0px" align="center" width="600px" height="480px">
		<tr align="center">
			<th>序号</th>
			<th>姓名</th>
			<th>性别</th>
			<th>生日</th>
			<th>部门</th>
			<th>操作</th>
		</tr>
		<%-- 
			c:forEach 遍历集合 相当于 java中的增强for循环 foreach
			var		集合中的每一个元素的值
			begin	从哪个index开始
			end		到那个index结束
			begin + end相当于集合中的subList(fromIndex, toIndex)方法
			step	步长值
			varStatus 对象中	index	从零开始
			varStatus 对象中	count	从一开始
			
			
			++++++++++++++++++++++++++++++++++++++
			
			
			c:if 相当于java中的if(){}
			test 判断条件
			
			
			++++++++++++++++++++++++++++++++++++++
			
			
			<fmt:formatDate value="被格式化的时间" pattern="格式" />
		 --%>
		<c:forEach items="${requestScope.empMap.data}" var="emp" varStatus="status">
			<c:if test="${status.count % 2 == 0 }">
				<tr align="center">
					<td>${status.count}</td>
					<td>${emp.nickname}</td>
					<td>
						<c:if test="${emp.gender == 1}">男</c:if>
						<c:if test="${emp.gender == 2}">女</c:if>
					</td>
					<td>
					<fmt:formatDate value="${emp.birthday}" pattern="yyyy年MM月dd日" />
					</td>
					<td>${emp.dept.name}</td>
					<td>
						<a href="${pageContext.request.contextPath}/front/emp.action?methodName=queryEmpByUuid&uuid=${emp.uuid}">详情</a>
						<%-- 当操作者的角色是超级管理员或者部门是管理员的员工 --%>
						<c:if test="${operator.powernum == 1 || operator.did == 2 }">
							修改 
							<a href="${pageContext.request.contextPath}/front/emp.action?methodName=addEmp">新增</a>
							<a href="${pageContext.request.contextPath}/back/emp.action?methodName=removeEmpByUuid&uuid=${emp.uuid}">删除</a>
						</c:if>
					</td>
				</tr>
			</c:if>
			<c:if test="${status.count % 2 == 1 }">
				<tr align="center" bgcolor="lightgray">
					<td>${status.count}</td>
					<td>${emp.nickname}</td>
					<td>
						<c:if test="${emp.gender == 1}">男</c:if>
						<c:if test="${emp.gender == 2}">女</c:if>
					</td>
					<td>
					<fmt:formatDate value="${emp.birthday}" pattern="yyyy年MM月dd日" />
					</td>
					<td>${emp.dept.name}</td>
					<td>
						<a href="${pageContext.request.contextPath}/front/emp.action?methodName=queryEmpByUuid&uuid=${emp.uuid}">详情</a>
						<%-- 当操作者的角色是超级管理员或者部门是管理员的员工 --%>
						<c:if test="${operator.powernum == 1 || operator.did == 2 }">
							修改   
							<a href="${pageContext.request.contextPath}/front/emp.action?methodName=addEmp">新增</a>
							<a href="${pageContext.request.contextPath}/back/emp.action?methodName=removeEmpByUuid&uuid=${emp.uuid}">删除</a>
						</c:if>
					</td>
				</tr>
			</c:if>
		</c:forEach>
	</table>
</body>
</html>