<%--
  Created by IntelliJ IDEA.
  User: YasanMa
  Date: 2019/4/17
  Time: 14:16
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>输入数字界面</title>
</head>
<body>
<form  action="output1.jsp" method="post" >
    请输入第一个数据的实部：<input name="r1"/><br>
    请输入第一个数据的虚部：<input name="i1"/><br>
    选择运算类型:
    <select name="option">
        <option>+</option>
        <option>-</option>
        <option>*</option>
        <option>/</option>
    </select><br>
    <br>
    请输入第二个数据的实部：<input name="r2"/><br>
    请输入第二个数据的虚部：<input name="i2"/><br>
    <input type="submit" value="计算"/>
    <input type="reset" value="取消"/>
</form>
</body>
</html>
