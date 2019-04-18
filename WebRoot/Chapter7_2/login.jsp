<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>


<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <title>My JSP 'login.jsp' starting page</title>
    
	<meta http-equiv="pragma" content="no-cache">
	<meta http-equiv="cache-control" content="no-cache">
	<meta http-equiv="expires" content="0">    
	<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
	<meta http-equiv="description" content="This is my page">
	<!--
	<link rel="stylesheet" type="text/css" href="styles.css">
	-->

  </head>
  
  <body>
<h1>登录页面</h1>
<%--
1. 显示表单页面
2. 显示错误信息(输入校验(略)，后端校验)
3. 回显表单数据
 --%>
 <p style="color: red; font-size: 11pt; font-weight: 900;">
 	${msg }
 </p>
<form action="/Chapter7_/LoginServlet" method="post">
	用户名：<input type="text" name="username"/>
		<span style="color: #ff770b; font-size: 10pt; font-weight: 900;"></span>
	<br/>
	密　码：<input type="password" name="password" />
		<span style="color: #ffaf1e; font-size: 10pt; font-weight: 900;"></span>
	<br/>
	<input type="submit" value="登录"/>
</form>
	<a href="regist.jsp">注册</a>

  </body>
</html>
