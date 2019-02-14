<%@ page contentType="text/html;charset=UTF-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>

<html>
<head>
    <title>All users from database</title>
</head>
<body>

<form action="/add" method="get">
    <input type="submit" value="add user">
</form>
<table border="1">
    <tr>
        <th>username</th>
        <th>password</th>
        <th>name</th>
        <th>email</th>
        <th>age</th>
        <th>actions</th>
    </tr>
    <c:forEach items= "${users}" var="user">
        <tr>
            <td>${user.username}</td>
            <td>${user.password}</td>
            <td>${user.name}</td>
            <td>${user.email}</td>
            <td>${user.age}</td>
            <td>
                <form action="/get" method="get">
                    <input type="hidden" name="id" value="${user.id}">
                    <input type="submit" value="show user">
                </form>
                <form action="/update" method="get">
                    <input type="hidden" name="id" value="${user.id}">
                    <input type="submit" value="update user">
                </form>
                <form action="/remove" method="post">
                    <input type="hidden" name="id" value="${user.id}">
                    <input type="submit" value="remove user">
                </form>
            </td>
        </tr>
    </c:forEach>

</table>
</body>
</html>
