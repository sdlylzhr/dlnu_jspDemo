<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%--
  Created by IntelliJ IDEA.
  User: sdlylzhr
  Date: 2018/12/6
  Time: 8:53
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
    <link rel="stylesheet" href="/css/base.css">
</head>
<body>

<c:if test="${username == null}" var="result">

<div>
    <a href="/loginview">登录</a>
    <a href="/register">注册</a>
</div>
</c:if>

<c:if test="${result == false}">
    <a href="#">${username}</a>
</c:if>

<div>

<table border="1px">

    <tr>
        <th>身份证号</th>
        <th>姓名</th>
        <th>密码</th>
        <th>住址</th>
        <th>生日</th>
    </tr>

    <%--jsp从request域中取得后台查询的所有用户数据， 使用for循环生成tr标签--%>
    <c:forEach var="user" items="${uList}">

        <%--循环的每一条数据都是user对象，可以使用${变量名.属性名}的形式获取值--%>
        <tr>
            <td>${user.id}</td>
            <td>${user.username}</td>
            <td>${user.password}</td>
            <td>${user.address}</td>
            <td>${user.birthday}</td>
        </tr>
    </c:forEach>
</table>

</div>


</body>
</html>
