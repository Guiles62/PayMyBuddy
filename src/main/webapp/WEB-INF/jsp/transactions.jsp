<%@page contentType="text/html;charset=UTF-8" language="java" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
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
                <a href="/login.jsp">Home</a>
                <a href="/transfert">Transfert</a>
                <a href="/profile">Profile</a>
                <a href="/contact">Contact</a>
                <a href="/logoff">Log off</a></br>
        </div>
    </section>
    <p id="pages">Home / Transfert</p>
    <section id="send">
        <h5>Send Money</h5>
        <button class="connection" type="submit" style="float: right">Add Connection</button>
    </section>

    <section id="pay">
    <select name="friend" id="friend">
        <option selected disabled>Select A Connection</option>
        <option value="friend 1">friend 1</option>
        <option value="friend 2">friend 2</option>
    </select>
    <input class="quantity" id="quantity" min="0" name="quantity" value="0" type="number">
    <button class="pay" type="submit" style="float: right">Pay</button>
    </section>
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
