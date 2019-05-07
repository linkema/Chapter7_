<%--
  Created by IntelliJ IDEA.
  User: YasanMa
  Date: 2019/4/18
  Time: 21:32
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>查询书界面</title>
</head>
<body>
<h1>  请选择查询条件</h1> <br> <p style="color: red; font-size: 11pt; font-weight: 900;">
    ${msg }
</p>

<form action="/Chapter7_/SearchBookServlet" method="post">
    图书号<input type="text" name="id"><br>
    <input type="submit" value="提交">
    <input type="reset" value="取消">
</form>
</body>
</html>
