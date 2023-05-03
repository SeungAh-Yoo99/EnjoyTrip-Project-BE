<%--
  Created by IntelliJ IDEA.
  User: kimsg
  Date: 2023-03-27
  Time: 오전 12:37
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html lang="en">
<head>
    <meta charset="UTF-8"/>
    <meta http-equiv="X-UA-Compatible" content="IE=edge"/>
    <meta name="viewport" content="width=device-width, initial-scale=1.0"/>
    <title>로그인</title>
    <style></style>
</head>
<body>
<div class="login">
    <div>로그인</div>
    <form action="login" , method="post">
        <span id="id_label">아이디</span>
        <input type="text" id="id" name="id" value=""/><br/>
        <span id="pw_label">비밀번호</span>
        <input type="password" id="pw" name="pw" value=""/><br/>
        <input type="submit" value="로그인"/>
        <input type="button" value="회원가입" onclick="location.href='signupForm'"></input>
        <input type="button" value="아이디/비밀번호 찾기" onclick="location.href='signupForm'"/>
        <input type="button" value="회원정보 수정" onclick="location.href='signupForm'"/>
        <input type="button" value="회원정보 조회" onclick="location.href='signupForm'"/>
    </form>
</div>
</body>
</html>

