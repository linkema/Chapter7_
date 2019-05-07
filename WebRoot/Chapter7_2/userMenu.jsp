<%--
  Created by IntelliJ IDEA.
  User: YasanMa
  Date: 2019/4/24
  Time: 8:08
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<%--建立一个数据库，一个触发器设置为在数据存储之前，如果本数据库的数据多于14则添加数据失败，并将要
    借的书籍信息放到这个新建的数据库中。
    CREATE TABLE book_borrow (bookname VARCHAR (10) , b_date VARCHAR(10) )

CREATE TRIGGER limitLog
ON book_borrow
instead of
INSERT
AS IF
(SELECT COUNT(*) FROM
book_borrow WHERE b_name IN (SELECT b_name FROM inserted))<8
INSERT INTO book_borrow SELECT * FROM FROM inserted
或者将即将插入的信息做个按照用户查询得到一个借阅书本量再在sevice层进行判断和给出msg
    --%>
<p><a href="Borrow_Book.jsp">借书</a> </p>
<p><a href="Back_Book.jsp">还书</a> </p>
</body>
</html>
