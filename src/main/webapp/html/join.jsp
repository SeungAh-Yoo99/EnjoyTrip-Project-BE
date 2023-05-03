<%--
  Created by IntelliJ IDEA.
  User: kimsg
  Date: 2023-03-27
  Time: 오전 12:27
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html lang="en">
<head>
    <meta charset="UTF-8"/>
    <meta http-equiv="X-UA-Compatible" content="IE=edge"/>
    <meta name="viewport" content="width=], initial-scale=1.0"/>
    <title>Document</title>
</head>
<body>
<div id="join">
    <form action="signUp" method="post">
        <span>이름 :</span>
        <input type="text" name="name" id="name"/><br/>
        <span>아이디 :</span>
        <input type="text" name="id" id="id"/><br/>
        <span>비밀번호 :</span>
        <input type="password" name="pw" id="pw"/><br/>
        <span>비밀번호확인 :</span>
        <input type="password" name="pw_check" id="pw_check"/><br/>
        <span>이메일 :</span>
        <input type="text" name="email_1" id="email_1"/>@<input
            type="text"
            name="email_2"
            id="email_2"
    /><br/>
        <input type="submit" value="가입"/>
        <input type="button" value="뒤로가기" onclick="window.history.back()"/>
        <input type="reset" value="초기화"/>
    </form>
</div>
</body>
</html>
