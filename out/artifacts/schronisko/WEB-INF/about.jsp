<%--
  Created by IntelliJ IDEA.
  User: Paweł
  Date: 31.01.2018
  Time: 11:39
  To change this template use File | Settings | File Templates.
--%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<style><%@include file="/resources/css/styles.css"%></style>
<html>
<head>
    <title>O aplikacji</title>
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


    <div class="container-fluid main-photo">
        <div class="row">
            <div class="container">
                <div class="row">
                    <div class="col-xs-8 col-xs-offset-2 caption2">
                        <h1>Aplikacja 4 łapy</h1>
                        <p>Auor: <a class="btn-link" href="https://github.com/PawelUrbanik">Paweł Urbanik</a> </p>
                        <p>Aplikacja umożliwia znalezienie nowego domu potrzebującym zwierzętom</p>
                        <p><strong>1.</strong> Przeglądasz dostępne zwierzęta dostępne w schronisku</p>
                        <p><strong>2.</strong> Kontaktujesz się z nami w sprawaie konkretnego zwierzęcia</p>
                        <p><strong>3.</strong> Ustalamy Twoją wizytę w schronisku i prowadzimy dalsze procesy</p>
                        <a href="/review" class="btn btn-default"><strong>Przeglądaj aktualnie dostępne zwierzęta</strong></a>

                    </div>
                </div>
            </div>
        </div>
    </div>


    <jsp:include page="fragment/footer.jspf"/>
    <script src="http://code.jquery.com/jquery-1.11.2.min.js" ></script>
    <script src="http://code.jquery.com/jquery-migrate-1.2.1.min.js" ></script>
    <script src="${pageContext.request.contextPath}/resources/js/bootstrap.js"></script>

    </body>
</html>
