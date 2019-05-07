<%@ page import="Chapter7_2.usermng.domain.User" %>
<%@ page import="java.util.ArrayList" %>
<%@ page import="Chapter7_2.usermng.domain.Book" %>
<%@ page import="Chapter7_2.usermng.dao.JdbcUserDaoImpl" %><%--
  Created by IntelliJ IDEA.
  User: YasanMa
  Date: 2019/5/6
  Time: 9:52
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>借书界面</title>
</head>
<body>
    <%--借书界面--%>
    <%
        User user= (User) request.getSession().getAttribute("session_user");
        ArrayList<Book> list= new JdbcUserDaoImpl().showAllBook();
    %>
    <p style="color: red; font-size: 11pt; font-weight: 900;">
        ${msg }
    </p>
    <table border="2" bgcolor ="ccceee" width="650">
        <tr bgcolor="99cc66" align="center">
            <td>記錄条数</td><td>书名号</td><td>书名</td><td>作者</td><td>价格</td><td>简介</td><td>借阅情况</td>
        </tr>
        <%
            int count=1;
            for (Book b :
                    list) {

        %>
        <tr align="center">
            <td><%=count++ %></td>
            <td><%=b.getBookNo()%></td>
            <td><%=b.getBookName() %></td>
            <td><%=b.getAuthor() %></td>
            <td><%=b.getPrice() %></td>
            <td><%=b.getNote() %></td>
            <td>
                <form action="/Chapter7_/BorrowBookServlet" method="post">
                    <input type="hidden" name="id" value="<%=b.getBookNo()%>" readonly/>
                    <input type="submit" value="借阅"/>
                </form>
            </td>
        </tr>
        <%
            }
        %>
    </table>
</body>
</html>
