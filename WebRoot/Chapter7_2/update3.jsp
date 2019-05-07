<%@ page import="Chapter7_2.usermng.domain.Book" %><%--
  Created by IntelliJ IDEA.
  User: YasanMa
  Date: 2019/5/5
  Time: 17:16
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<form action="/Chapter7_/ModifyBookServlet" method="post">
    <table border="0" width="240" height="200">
        <%
            request.setCharacterEncoding("utf-8");
            response.setContentType("text/html;charset=utf-8");
            Book form= (Book) request.getAttribute("form");
        %>
        <tr><td>所查询的图书号</td><td><input type="text" name="oldid" value=<%=form.getBookNo() %>></td></tr>
        <tr><td>图书号</td><td><input name="id" value=<%=form.getBookNo() %>></td></tr>
        <tr><td>图书名</td><td><input name="name" value=<%=form.getBookName() %>></td></tr>
        <tr><td>作者名</td><td><input name="author" value=<%=form.getAuthor() %>></td></tr>
        <tr><td>價格</td><td><input name="price" value=<%=form.getPrice() %>></td></tr>
        <tr><td>图书号</td><td><input name="note" value=<%=form.getNote() %>></td></tr>
        <tr align="center">
            <td colspan="2">
                <input type="submit" value="提交">
                <input type="reset" value="取消">
            </td>
        </tr>
    </table>
</form>
</body>
</html>
