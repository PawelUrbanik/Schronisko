<%--
  Created by IntelliJ IDEA.
  User: Paweł
  Date: 2017-10-05
  Time: 14:23
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Nowy pracownik</title>
</head>
<body>
<div class="container">

    <form class="form-signin" action="/addStaff" method="post">
        <h2 class="form-signin-heading">Dodaj nowego pracownika</h2>
        <input name="inputFirstName" type="text" class="form-control" placeholder="Imię" required autofocus>
        <input name="inputLastname" type="text" class="form-control" placeholder="Nazwisko" required autofocus>
        <input name="inputEmail" type="email" class="form-control" placeholder="Email" required autofocus>
        <input name="inputUsername" type="text" class="form-control" placeholder="Nazwa użytkownika" required autofocus>
        <input name="inputPassword" type="password" class="form-control" placeholder="Hasło" required>
        <button class="btn btn-lg btn-primary btn-block" type="submit">Dodaj</button>
    </form>

</div> <!-- /container -->
</body>
</html>
