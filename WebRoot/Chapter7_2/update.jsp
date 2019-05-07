
<%@ page import="Chapter7_2.usermng.domain.User" %>
<%@ page import="java.util.ArrayList" %><%--
  Created by IntelliJ IDEA.
  User: YasanMa
  Date: 2019/4/23
  Time: 22:57
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<meta http-equiv="refresh" content="3;url=Chapter7_2/GMmenu.jsp"/>
<head>
    <title>Title</title>
</head>
<body>
<table border="2" bgcolor ="ccceee" width="650">
    <tr bgcolor="99cc66" align="center">
        <td>記錄条数</td><td>用户名</td><td>密码</td>
    </tr>
    <%
        ArrayList<User> list=(ArrayList<User>) request.getAttribute("list");
        int count=1;
        for (User u :
                list) {

    %>
    <tr align="center">
        <td><%=count++ %></td>
        <td><%=u.getUsername() %></td>
        <td><%=u.getPassword() %></td>
    </tr>
    <%
        }
    %>
</table>
</body>
</html>
