<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>  
<%@ taglib uri="/test" prefix="test"%>  <!--uri与tld文件中配的uri相同-->  
  
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">  
<html>  
  <head>    
    <title>输出客户机的IP</title>  
  </head>  
    
  <body>  
    您的IP是：<test:viewIP/>  
      
    <!--该标签相当于执行下面脚本代码-->  
    <%   
        String ip = request.getRemoteAddr();  
        out.write(ip);  
    %>     
  </body>  
</html>