<%--
  Created by IntelliJ IDEA.
  User: Paweł
  Date: 2017-10-05
  Time: 14:23
  To change this template use File | Settings | File Templates.
--%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<style><%@include file="/resources/css/styles.css"%></style>
<c:set var="privigiles" scope="session" value="${sessionScope.privigiles}"/>
<html>
<head>
    <title>Nowy pracownik</title>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8" />
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <link href="${pageContext.request.contextPath}/resources/css/bootstrap.min.css" type="text/css" rel="stylesheet">
    <link href="${pageContext.request.contextPath}/resources/css/styles.css" type="text/css" rel="stylesheet">
</head>
<body>

    <c:choose>
    <c:when test="${privigiles eq 'staff'}">
        <jsp:include page="fragment/navbarStaff.jsp"/>
    </c:when>
    <c:when test="${privigiles eq 'admin'}">
        <jsp:include page="fragment/navbarAdmin.jspf"/>
    </c:when>
    <c:otherwise>
        <jsp:include page="fragment/navbar.jspf"/>
    </c:otherwise>
    </c:choose>
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

        <jsp:include page="fragment/footer.jspf"/>
        <script src="http://code.jquery.com/jquery-1.11.2.min.js" ></script>
        <script src="http://code.jquery.com/jquery-migrate-1.2.1.min.js" ></script>
        <script src="${pageContext.request.contextPath}/resources/js/bootstrap.js"></script>
</body>
</html>
