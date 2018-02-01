<%--
  Created by IntelliJ IDEA.
  User: Paweł
  Date: 2017-10-03
  Time: 09:03
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<style><%@include file="/resources/css/styles.css"%></style>
<html>
<head>
    <title>Login</title>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8" />
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <link href="${pageContext.request.contextPath}/resources/css/bootstrap.min.css" type="text/css" rel="stylesheet">
    <link href="${pageContext.request.contextPath}/resources/css/styles.css" type="text/css" rel="stylesheet">
</head>
<body>
        <jsp:include page="fragment/navbar.jspf"/>

<div class="container">

    <form class="form-signin" action="j_security_check" method="post">
        <h2 class="form-signin-heading">Zaloguj się</h2>
        <input name="j_username" type="text" class="form-control" placeholder="Nazwa użytkownika" required autofocus>
        <input name="j_password" type="password" class="form-control" placeholder="Hasło" required>
        <button class="btn btn-lg btn-primary btn-block" type="submit">Sign in</button>
        <a href="${pageContext.request.contextPath}/register">Zarejestruj</a>
    </form>

</div> <!-- /container -->
        <jsp:include page="fragment/footer.jspf"/>
        <script src="http://code.jquery.com/jquery-1.11.2.min.js" ></script>
        <script src="http://code.jquery.com/jquery-migrate-1.2.1.min.js" ></script>
        <script src="${pageContext.request.contextPath}/resources/js/bootstrap.js"></script>
</body>
</html>
