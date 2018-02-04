<%--
  Created by IntelliJ IDEA.
  User: Paweł
  Date: 01.02.2018
  Time: 10:14
  To change this template use File | Settings | File Templates.
--%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<style><%@include file="/resources/css/styles.css"%></style>
<html>
<head>
    <title>Kontakt</title>
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

<div class="container well">
<form action="contact" method="post">
    <div class="form-group">
        <label for="name">Imię</label>
        <input type="text" name="name" class="form-control" id="name" placeholder="Imię">
    </div>
    <div class="form-group">
        <label for="surname">Nazwisko</label>
        <input type="text" name="surname" class="form-control" id="surname" placeholder="Nazwisko">
    </div>
    <div class="form-group">
        <label for="email">Email</label>
        <input type="email" class="form-control" id="email" name="email" placeholder="Email">
    </div>
    <div class="form-group">
        <label for="message" >Wiadomość</label>
        <textarea class="form-control" name="message" id="message" placeholder="Wpisz wiadomość"></textarea>
    </div>
    <button type="submit" class="btn btn-default">Wyślij wiadomość</button>
</form>
</div>
<jsp:include page="fragment/footer.jspf"/>
<script src="http://code.jquery.com/jquery-1.11.2.min.js" ></script>
<script src="http://code.jquery.com/jquery-migrate-1.2.1.min.js" ></script>
<script src="${pageContext.request.contextPath}/resources/js/bootstrap.js"></script>

</body>
</html>
