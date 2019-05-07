<%@ page import="Chapter7_2.usermng.domain.User" %>
<%@ page import="Chapter7_2.usermng.domain.BorrowBook" %>
<%@ page import="java.util.ArrayList" %>
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
    <title>还书界面</title>
</head>
<body>
    <%--还书界面--%>
    <p style="color: red; font-size: 11pt; font-weight: 900;">
        ${msg }
    </p>
    <%
        User user= (User) request.getSession().getAttribute("session_user");
        ArrayList<BorrowBook> list= new JdbcUserDaoImpl().showAllBorrowedBook();
    %>
    <table border="2" bgcolor ="ccceee" width="650">
        <tr bgcolor="99cc66" align="center">
            <td>記錄条数</td><td>用户名</td><td>借阅书号</td><td>还书情况</td>
        </tr>
        <%
            int count=1;
            for (BorrowBook u :
                    list) {

        %>
        <tr align="center">
            <td><%=count++ %></td>
            <td><%=u.getB_name() %></td>
            <td><%=u.getBookno() %></td>
            <td><form action="/Chapter7_/BackBookServlet" method="post">
                <input type="hidden" name="id" value="<%=u.getBookno()%>" readonly/>
                <input type="submit" value="还书"/>
            </form></td>
        </tr>
        <%
            }
        %>
    </table>
</body>
</html>
