<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    
    <title>登录后界面</title>
	<!--
	<link rel="stylesheet" type="text/css" href="styles.css">
	-->
  </head>
  <frameset rows="20%,*">
      <frame src="Welcome.jsp" name="welcome">
      <frameset cols="50%,*">
          <frame src="userMenu.jsp" name="usermenu">
          <%--<frame src="Delete_User.jsp" name="GmUser">--%>
      </frameset>
  </frameset>

</html>
