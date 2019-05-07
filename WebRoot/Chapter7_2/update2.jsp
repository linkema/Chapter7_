<%@ page import="Chapter7_2.usermng.domain.Book" %>
<%@ page import="java.util.ArrayList" %><%--
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
<table border="2" bgcolor ="ccceee" width="650">
    <tr bgcolor="99cc66" align="center">
        <td>記錄条数</td><td>书名号</td><td>书名</td><td>作者</td><td>价格</td><td>简介</td>
    </tr>
    <%
        ArrayList<Book> list=(ArrayList<Book>) request.getAttribute("list");
        int count=1;
        for (Book b :
                list) {

    %>
    <tr align="center">
        <td><%=count++ %></td>
        <td><%=b.getBookNo() %></td>
        <td><%=b.getBookName() %></td>
        <td><%=b.getAuthor() %></td>
        <td><%=b.getPrice() %></td>
        <td><%=b.getNote() %></td>
    </tr>
    <%
        }
    %>
</table>
</body>
</html>
