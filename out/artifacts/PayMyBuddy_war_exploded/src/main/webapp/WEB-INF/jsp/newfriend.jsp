<%@page contentType="text/html;charset=UTF-8" language="java" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<html>
<head>
    <title>Pay My Buddy</title>
    <!-- css -->
    <link rel="stylesheet" href="bootstrap.min.css">
    <link rel="stylesheet" href="newfriend.css">
</head>
<body>

<div class="container-fluid">
    <div class="container">
        <section>
            <p><em>Pay My Buddy</em></p>
            <p><h5>Add a friend</h5></p>
            <form method="post" action="/addfriend">
            <p><input type="email" style="background-image: url(/email.png);background-position: left; background-repeat: no-repeat" placeholder="Email" id="email" name="email"></p>
            <p><button class="search" type="submit">add friend</button></p>
            </form>
        </section>
    </div>
</div>
</body>
</html>
