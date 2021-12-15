<%@page contentType="text/html;charset=UTF-8" language="java" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<html>
<head>
    <title>Pay My Buddy</title>
    <!-- css -->
    <link rel="stylesheet" href="bootstrap.min.css">
    <link rel="stylesheet" href="profil.css">

</head>
<header>
    <section id="entete">
        <p><em>Pay My Buddy</em></p>
        <div id="liens" style="float: right">
            <a href="/login.jsp">Home</a>
            <a href="/transfert">Transfert</a>
            <a href="/profile">Profile</a>
            <a href="/contact">Contact</a>
            <a href="/logoff">Log off</a></br>
        </div>
    </section>
    <p id="pages">Home / Profile</p>
</header>
<body>
<h5>My Profile</h5>
<div id="data">
<table id="table-firstname">
    <thead>
            <tr class="text-white">
                <th>Firstname : </th>
            </tr>
    </thead>
    <tbody>
    <c:forEach items="${users}" var="users">
        <tr>
            <td>${users.firstname}</td>
        </tr>
    </c:forEach>
    </tbody>
</table>
</br>
<table id="table-lastname">
    <thead>
        <tr class="text-white">
            <th>Lastname : </th>
        </tr>
    </thead>
    <tbody>
    <c:forEach items="${users}" var="users">
        <tr>
            <td>${users.lastname}</td>
        </tr>
    </c:forEach>
    </tbody>
</table>
</br>
<table id="table-email">
    <thead>
    <tr class="text-white">
        <th>Email : </th>
    </tr>
    </thead>
    <tbody>
    <c:forEach items="${users}" var="users">
        <tr>
            <td>${users.email}</td>
        </tr>
    </c:forEach>
    </tbody>
</table>
</br>
<table id="table-pass">
    <thead>
    <tr class="text-white">
        <th>Password : </th>
    </tr>
    </thead>
    <tbody>
    <c:forEach items="${users}" var="users">
        <tr>
            <td>${users.password}</td>
        </tr>
    </c:forEach>
    </tbody>
</table>
</div>
</body>
</html>
