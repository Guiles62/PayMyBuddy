<%@page contentType="text/html;charset=UTF-8" language="java" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<html>
<head>
    <title>Pay My Buddy</title>
    <!-- css -->
    <link rel="stylesheet" href="bootstrap.min.css">
    <link rel="stylesheet" href="transactions.css">

</head>
<section id="page">
<header>
    <section id="entete">
                <p><em>Pay My Buddy</em></p>
        <div id="liens" style="float: right">
                <a href="/login">Home</a>
                <a href="/transfert">Transfert</a>
                <a href="/profil">Profile</a>
                <a href="/contact">Contact</a>
                <a href="/logoff">Log off</a></br>
        </div>
    </section>
    <p id="pages">Home / Transfert</p>
    <section id="send">
        <h5>Send Money</h5>
        <form action="/newfriend" method="get">
        <button  class="connection" type="submit" style="float: right" > Add Connection</button>
        </form>
    </section>
<table>
    <thead>
    </thead>
    <tbody>
    <section id="pay">
        <form method="post" action="/newtransaction">
    <select name="user" id="user">
        <option selected disabled>Select A Connection</option>
        <option>
        <c:forEach items="${user}" var="user">
            <tr class="border border-dark">
                <td>${user.userFriends}</td>
                <td>${user.firstname}</td>
            </tr>
            </c:forEach>

        </option>
    </select>
    <input class="amount" id="amount" min="0" name="amount" value="0" type="number">
    <input type="text" placeholder="Description" id="description" name="description">
    <button class="pay" type="submit" style="float: right">Pay</button>

        </form>
    </section>
    </tbody>
</table>
</header>
<body>
<h5 id="transactions">My Transactions</h5>
<div id="table">
<table>
    <Thead>
        <tr class="text-white">
            <th>Connections</th>
            <th>Description</th>
            <th>Amount</th>
        </tr>
    </Thead>

    <tbody>
    <c:forEach items="${transaction}" var="transaction">
        <tr>
            <td>${transaction.cost}</td>
            <td>${transaction.description}</td>
            <td>${transaction.amount}</td>
        </tr>
    </c:forEach>
    </tbody>
</table>
</div>
</body>
</section>
</html>
