<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<html>
<head>
    <title>user</title>
    <link href="<c:url value="/css/common.css"/>" rel="stylesheet" type="text/css">
</head>
<body>
<table>
    <thead>
    <tr>
        <th>firstname</th>
        <th>lastname</th>
        <th>email</th>
        <th>role</th>
    </tr>
    </thead>
    <tbody>
    <c:forEach items="${users}" var="user">
        <tr>
            <td>${user.firstname}</td>
            <td>${user.lastname}</td>
            <td>${user.email}</td>
            <td>${user.role}</td>
        </tr>
    </c:forEach>
    </tbody>
</table>
</body>
</html>