<%--
  Created by IntelliJ IDEA.
  User: sdlylzhr
  Date: 2018/12/6
  Time: 14:33
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>登录</title>
    <style>
        .mainContent {
            width: 400px;
            margin: 0 auto;
            text-align: center;
        }
    </style>
</head>
<body>
<div class="mainContent">

    <form action="/login">

        <table border="1px" align="center">
            <tr>
                <td>用户名：</td>
                <td><input type="text" name="uname"></td>
            </tr>
            <tr>
                <td>密码：</td>
                <td><input type="password" name="pwd"></td>
            </tr>
        </table>
        <input type="submit" value="登录">
    </form>
</div>
</body>
</html>
