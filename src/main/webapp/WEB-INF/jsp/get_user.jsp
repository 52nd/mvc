<%@ page import="com.model.User" %>
<%@ page contentType="text/html;charset=UTF-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<html>
<head>
    <title>User details</title>
</head>
<body>

<% User user = (User) request.getAttribute("user");%>
<%--<spring:param name="user" value="${user}">--%>
<table border="1">
    <tr>
        <th>username</th>
        <th>password</th>
        <th>name</th>
        <th>email</th>
        <th>age</th>
    </tr>
    <tr>
        <td><%=user.getUsername()%></td>
        <td><%=user.getPassword()%></td>
        <td><%=user.getName()%></td>
        <td><%=user.getEmail()%></td>
        <td><%=user.getAge()%></td>
    </tr>
</table>
</body>
</html>
