<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
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
    <title>Title</title>
</head>
<body>

<div class="mainContent">

    <form action="/register">

        <table>
            <tr>
                <td>用户名:</td>
                <td><input type="text" name="uname"></td>
            </tr>
            <tr>
                <td>密码：</td>
                <td><input type="password" name="pwd"></td>
            </tr>
            <tr>
                <td>重复密码：</td>
                <td><input type="password" name="repwd"></td>
            </tr>
        </table>
    </form>






</div>


</body>
</html>
