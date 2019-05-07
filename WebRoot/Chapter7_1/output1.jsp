<%@ page import="Chapter7_1.Jisuanfushu" %><%--
  Created by IntelliJ IDEA.
  User: YasanMa
  Date: 2019/4/17
  Time: 14:16
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>信息显示界面</title>
</head>
<body>结果是：
    <%
        double r1=Double.parseDouble(request.getParameter("r1"));
        double i1=Double.parseDouble(request.getParameter("i1"));
        String option=request.getParameter("option");
        double r2=Double.parseDouble(request.getParameter("r2"));
        double i2=Double.parseDouble(request.getParameter("i2"));
        Jisuanfushu c=new Jisuanfushu(r1,i1);
        Jisuanfushu d=new Jisuanfushu(r2,i2);
        String result="";
        if(option.equals("+")){
            result=c.add(d).formart();
        }else if(option.equals("-")){
            result=c.sub(d).formart();
        }else if(option.equals("*")){
            result=c.mul(d).formart();
        }else {
            result=c.div(d).formart();
        }
        out.print(result);
    %>
</body>
</html>
