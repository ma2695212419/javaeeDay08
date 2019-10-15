<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
	<head>
		<meta charset="UTF-8">
		<title>添加员工</title>
		<script src="${pageContext.request.contextPath}/webjars/jquery/3.4.1/dist/jquery.min.js" type="text/javascript" charset="utf-8"></script>
		<script src="${pageContext.request.contextPath}/my97/4.8/WdatePicker.js" type="text/javascript" charset="utf-8"></script>
		<script src="${pageContext.request.contextPath}/my97/4.8/lang/zh-cn.js" type="text/javascript" charset="utf-8"></script>
		<script src="${pageContext.request.contextPath}/js/add.js" type="text/javascript" charset="utf-8"></script>
	</head>
	<body>
		操作者:&nbsp;&nbsp;&nbsp;&nbsp;${sessionScope.operator.nickname }
		<br>
		<a href="${pageContext.request.contextPath}/front/emp.action?methodName=logout">退出系统</a>
		<form id="addEmp" action="${pageContext.request.contextPath}/back/emp.action?methodName=addEmp" method="post">
			<table align="center" border="1px" cellspacing="0px" cellpadding="0px" width="400px" height="400px">
				<tr align="center">
					<td>姓名:</td>
					<td>
						<input type="text" id="nickname" name="nickname" value="" placeholder="请输入姓名" autocomplete="off" />
					</td>
				</tr>
				<tr align="center">
					<td>账号:</td>
					<td>
						<input type="text" id="account" name="account" value="" placeholder="请输入账号" autocomplete="off" />
						<span id="checkMsg"></span>
					</td>
				</tr>
`				<tr align="center">
					<td>性别:</td>
					<td>
						<label for="male">男</label>&nbsp;&nbsp;
						<input type="radio" name="gender" id="male" value="1" checked="checked">
						&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
						<label for="female">女</label>&nbsp;&nbsp;
						<input type="radio" name="gender" id="female" value="2">
					</td>
				</tr>
				<tr align="center">
					<td>生日:</td>
					<td>
						<input class="Wdate" type="text" id="birthday" name="birthday" value="" autocomplete="off" readonly="readonly"
						 onClick="WdatePicker({el:this,dateFmt:'yyyy-MM-dd'})" />
					</td>
				</tr>
				<tr align="center">
					<td>部门:</td>
					<td>
						<select name="did">
							<option value="0" selected="selected">请选择</option>
							<c:forEach items="${requestScope.deptMap.data }" var="dept">
								<option value="${dept.id }">${dept.name }</option>
							</c:forEach>
						</select>
					</td>
				</tr>
				<c:if test="${sessionScope.operator.powernum == 1}">
					<tr align="center">
					<td>角色:</td>
					<td>
						<select name="did">
							<option value="2">普通员工</option>
							<option value="1">管理员</option>
						</select>
					</td>
				</tr>
				</c:if>
				<tr align="center">
					<td colspan="2">
						 <button type="button" id="addEmpBtn">提交</button><span>${requestScope.msg }</span>
						<a href="${pageContext.request.contextPath}/front/emp.action?methodName=queryEmps">返回</a>
					</td>
				</tr>
			</table>
		</form>
	</body>
</html>
