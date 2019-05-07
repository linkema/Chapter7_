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
    <title>增加书籍信息界面</title>
</head>
<body>
<p style="color: red; font-size: 11pt; font-weight: 900;">${msg }</p>
<form action="/Chapter7_/InsertBookServlet" method="post">
    <table border="0" width="300" height="240">
        <tr><td>图书号</td><td><input type="text" name="id"></td></tr>
        <tr><td>图书名</td><td><input type="text" name="name"></td></tr>
        <tr><td>作者</td><td><input type="text" name="author"></td></tr>
        <tr><td>价格</td><td><input type="text" name="price"></td></tr>
        <tr><td>备注字段</td><td><input type="text" name="note"></td></tr>
        <tr align="center">
            <td colspan="2">
                <input type="submit" value ="提交">
                <input type="reset" value="取消">
            </td>
        </tr>
    </table>
</form>
<br>
</body>
</html>
