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
                <a href="/transactions">Transfert</a>
                <a href="/profil">Profile</a>
                <a href="/contact">Contact</a>
                <a href="<c:url value="/logout" />">Logout</a></br>
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
        <form action="/newtransaction" method="post">
    <select name="userfriends" id="userfriends">
        <option selected disabled>Select A Connection</option>
        <c:forEach var="userfriends" items="${userfriends}">
                <option>${userfriends.firstname}</option>
            </c:forEach>
    </select>
    <input class="amount" id="amount" min="0" name="amount" value="0" type="number">
    <input type="text" placeholder="Description" id="description" name="description">
    <button class="pay" type="submit" style="float: right">Pay</button>
        </form>
    </section>
    <section id="error">
    <c:if test="${error!=null}">
        <p style="color: red" ><strong>${error}</strong></p>
    </c:if>
    </section>
    <section id="bank&delete">
        <form action="/banktransaction" method="get">
            <button  class="connection" type="submit" style="float: right" > Bank Transactions</button>
        </form>
        <form action="/deleteafriend" method="get">
            <button  class="connection" type="submit" style="float: right" > Delete Connection</button>
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
            <td>${transaction.userRecipient.firstname}</td>
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
