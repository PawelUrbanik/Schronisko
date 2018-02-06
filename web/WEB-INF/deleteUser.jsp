<%--
  Created by IntelliJ IDEA.
  User: Paweł
  Date: 06.02.2018
  Time: 07:17
  To change this template use File | Settings | File Templates.
--%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<style><%@include file="/resources/css/styles.css"%></style>
<html>
<head>
    <title>Zarządzanie zasobem</title>
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

    <c:if test="${not empty requestScope.users}">
    <c:forEach var="user" items="${requestScope.users}">
    <div class="container">
    <div class="row">
        <div class="col-xs-12 col-sm-8 main">
            <div class="blog-post well">
                <h2 class="blog-post-title">Użytkownik: ${user.username} </h2>
                <p class="blog-post-meta">Imię: ${user.firstname} </p>
                 <p class="blog-post-meta">   Nazwisko: ${user.lastname}</p>
                <p><span class="glyphicon glyphicon-user">Email: ${user.email}</p>
                <form action="/deleteUser" method="post">
                    <input type="hidden" name="userId" value="${user.id}">
                    <c:if test="${user.id ne 1}">
                        <button type="submit" name="submitValue" value="delete" class="btn btn-danger">Usuń Pracownika</button>
                    </c:if>
                </form>
            </div>
        </div>
    </div>
    </c:forEach>
    </c:if>

<jsp:include page="fragment/footer.jspf"/>
<script src="http://code.jquery.com/jquery-1.11.2.min.js" ></script>
<script src="http://code.jquery.com/jquery-migrate-1.2.1.min.js" ></script>
<script src="${pageContext.request.contextPath}/resources/js/bootstrap.js"></script>
</body>
</html>