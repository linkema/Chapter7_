<%--
  Created by IntelliJ IDEA.
  User: YasanMa
  Date: 2019/4/18
  Time: 21:33
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>修改书籍数据界面</title>
</head>
<body>
<p style="color: red; font-size: 11pt; font-weight: 900;">
    ${msg }
</p>
请选择修改记录所满足的条件<hr width="100%" size="3">
<form action="/Chapter7_/ModifyBookServlet" method="post"> <br>
    书名号:<input type="text" name="id"><br>
    <input type="submit" value="提交">
    <input type="reset" value="取消">
</form>
</body>
</html>
