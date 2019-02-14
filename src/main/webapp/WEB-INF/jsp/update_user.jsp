<%@ page import="com.service.UserService" %>
<%@ page import="com.service.UserServiceImpl" %>
<%@ page import="com.model.User" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags/form" %>
<html>
<head>
    <title>Removed user</title>
</head>
<body>

<div align="center">
    <h2>Update user profile in database:</h2>
</div>

<%--<form action="/update" method="post">--%>

    <%--<input type="hidden" name="id" value=<%= user.getId() %> >--%>
    <%--<label>username</label>--%>
    <%--<input type="text" name="username" value=<%= user.getUsername() %> placeholder="username" autofocus>--%>
    <%--<label>password</label>--%>
    <%--<input type="password" name="password" value=<%= user.getPassword() %> placeholder=password>--%>
    <%--<label>name</label>--%>
    <%--<input type="text" name="name" value=<%= user.getName() %> placeholder="name">--%>
    <%--<label>email</label>--%>
    <%--<input type="email" name="email" value=<%= user.getEmail() %> placeholder="email">--%>
    <%--<label>age</label>--%>
    <%--<input type="number" name="age" value=<%= user.getAge() %> placeholder="age">--%>
    <%--<input type="submit" value="update user">--%>
<%--</form>--%>

<div>
    <spring:form modelAttribute="user" method="post" action="/update_user">
        <label>username</label><spring:input path="username"/>
        <label>password</label><spring:input path="password"/>
        <label>name</label><spring:input path="name"/>
        <label>email</label><spring:input path="email"/>
        <label>age</label><spring:input path="age"/>
        <spring:button>update user</spring:button>
    </spring:form>
</div>

</body>
</html>
