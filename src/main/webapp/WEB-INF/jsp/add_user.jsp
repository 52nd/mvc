<%@ taglib prefix="spring" uri="http://www.springframework.org/tags/form" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Removed user</title>
</head>
<body>

<div align="center">
    <h2>Add new user to database:</h2>
</div>
<%--<form action="/add" method="post">--%>
<%--<input type="text" name="username" autofocus required placeholder="username">--%>
<%--<input type="password" name="password" required placeholder="password">--%>
<%--<input type="text" name="name" required placeholder="name">--%>
<%--<input type="email" name="email" required placeholder="email">--%>
<%--<input type="number" name="age" required placeholder="age">--%>
<%--<input type="submit" value="add user">--%>
<%--<input type="reset" value="reset fields">--%>
<%--</form>--%>
<div>
    <spring:form modelAttribute="user" method="post" action="/add">
        <label>username</label><spring:input path="username"/>
        <label>password</label><spring:input path="password"/>
        <label>name</label><spring:input path="name"/>
        <label>email</label><spring:input path="email"/>
        <label>age</label><spring:input path="age"/>
        <spring:button>add user</spring:button>
    </spring:form>
</div>

</body>
</html>
