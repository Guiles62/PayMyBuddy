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
    <div class="container-fluid">
        <div class="container">
            <div class="form-group row">
                <button type="button" class="col-md-2 btn btn-success">Pay My Buddy</button>
                <div class="col-md-6">
                    <a href="/home" class="btn btn-default float-end">Home</a>
                    <a href="/transfert" class="btn btn-default float-end">Transfert</a>
                    <a href="/profile" class="btn btn-default float-end">Profile</a>
                    <a href="/contact" class="btn btn-default float-end" >Contact</a>
                    <a href="/logoff" class="btn btn-default float-end">Log off</a>
                </div>
            </div>
        </div>
    </div>
</header>
<body>
<div class="container-fluid">
    <div class="container">
        <div class="form-group row">
<table>
    <thead>
        <div class="container">
            <div class="form-group row">
    <tr class="p-3 mb-2 bg-success text-white border border-dark">
        <th>Firstname</th>
        <th>Lastname</th>
        <th>Email</th>
        <th>Role</th>
    </tr>
            </div>
        </div>
    </thead>
    <tbody>
    <c:forEach items="${user}" var="user">
        <tr class="border border-dark">
            <td>${user.firstname}</td>
            <td>${user.lastname}</td>
            <td>${user.email}</td>
            <td>${user.role}</td>
        </tr>
    </c:forEach>
    </tbody>
</table>
        </div>
    </div>
</div>
</body>
</html>