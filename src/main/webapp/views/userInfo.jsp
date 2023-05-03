<%--
  Created by IntelliJ IDEA.
  User: kimsg
  Date: 2023-03-27
  Time: 오전 3:46
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
    name = ${requestScope.userInfo.name}<hr><br>
    id = ${requestScope.userInfo.id}<hr><br>
    email_1 = ${requestScope.userInfo.email_1}<hr><br>
    email_2 = ${requestScope.userInfo.email_2}<hr><br>
    <a href="/trip">메인 화면으로</a>
    <a href="modifyForm">회원정보 수정</a>
    <a href="delete?id=${requestScope.userInfo.id}">회원 탈퇴</a>
    <a href="logout">로그아웃</a>
</body>
</html>
