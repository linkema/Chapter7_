<%--
  Created by IntelliJ IDEA.
  User: YasanMa
  Date: 2019/4/18
  Time: 15:12
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>管理员界面</title>
</head>
    <frameset rows="20%,*">
        <frame src="Welcome.jsp" name="welcome">
        <frameset cols="60%,*">
            <frame src="GMmenu.jsp" name="all">
            <%--<frame src="Delete_User.jsp" name="GmUser">--%>
        </frameset>
    </frameset>

</html>
