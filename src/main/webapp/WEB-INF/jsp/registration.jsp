
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<html>
<head>
    <title>Pay My Buddy</title>
    <!-- css -->
    <link rel="stylesheet" href="bootstrap.min.css">
    <link rel="stylesheet" href="login.css">
</head>
<body>

<div class="container-fluid">
    <div class="container">
        <section>
            <p><em>Register</em></p>
            <form method="post" action="newuser"></form>
            <p><input type="name" placeholder="Name" id="name" name="name"></p>
            <p><input type="email" style="background-image: url(/email.png);background-position: left; background-repeat: no-repeat" placeholder="Email" id="email" name="email"></p>
            <p><input type="password" style="background-image: url(/password.png); background-position: left; background-repeat: no-repeat" placeholder="Password" id="password" name="password"></p>
            <p><button class="login" type="submit">Login</button></p>
        </section>
    </div>
</div>
</body>
</html>
