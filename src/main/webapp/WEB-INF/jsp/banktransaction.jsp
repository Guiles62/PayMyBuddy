<<%@page contentType="text/html;charset=UTF-8" language="java" %>
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
      <p><h5>Bank Transaction</h5></p>
      <form method="post" action="/newbanktransaction">
        <p><input type="text" placeholder="RIB" id="rib" name="rib"></p>
        <p><input class="amount" id="amount" min="0" name="amount" value="0" type="number"></p>
        <p><button class="search" type="submit">Send Bank Transfert </button></p>
      </form>
      <form method="post" action="/newpmbtransaction">
        <p><input type="text" placeholder="RIB" id="rib2" name="rib"></p>
        <p><input class="amount" id="amount2" min="0" name="amount" value="0" type="number"></p>
        <p><button class="search" type="submit">Send PMB Transfert</button></p>
      </form>
    </section>
  </div>
</div>
</body>
</html>
