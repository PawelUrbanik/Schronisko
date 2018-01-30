<%--
  Created by IntelliJ IDEA.
  User: Paweł
  Date: 2017-10-03
  Time: 09:03
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Login</title>
</head>
<body>

<div class="container">

    <form class="form-signin" action="j_security_check" method="post">
        <h2 class="form-signin-heading">Zaloguj się</h2>
        <input name="j_username" type="text" class="form-control" placeholder="Nazwa użytkownika" required autofocus>
        <input name="j_password" type="password" class="form-control" placeholder="Hasło" required>
        <button class="btn btn-lg btn-primary btn-block" type="submit">Sign in</button>
        <a href="${pageContext.request.contextPath}/register">Zarejestruj</a>
    </form>

</div> <!-- /container -->

</body>
</html>
