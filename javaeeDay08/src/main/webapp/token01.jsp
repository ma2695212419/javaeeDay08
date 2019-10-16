<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<!DOCTYPE HTML>
<html>
  <head>
    <title>Form表单</title>
    <script type="text/javascript">
	    function dosubmit(){
	        //获取表单提交按钮
	        var btnSubmit = document.getElementById("submit");
	        //将表单提交按钮设置为不可用，这样就可以避免用户再次点击提交按钮
	        btnSubmit.disabled= "disabled";
	        //返回true让表单可以正常提交
	        return true;
	    }
    </script>
  </head>
  
  <body>
      <form action="${pageContext.request.contextPath}/token.action?methodName=token01" onsubmit="return dosubmit()" method="post">
        用户名：<input type="text" name="username">
        <input type="submit" value="提交" id="submit">
    </form>
  </body>
</html>
