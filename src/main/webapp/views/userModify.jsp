<%--
  Created by IntelliJ IDEA.
  User: kimsg
  Date: 2023-03-27
  Time: 오전 4:23
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<form action="modify?id=${requestScope.userInfo.id}" method="post">
    아이디 : ${requestScope.userInfo.id}<br>
    <input type="text" name="name"><br>
    메일 : ${requestScope.userInfo.email_1} @ ${requestScope.userInfo.email_2}<br>
    <input type="submit" value="이름 수정">
</form>
</body>
</html>
