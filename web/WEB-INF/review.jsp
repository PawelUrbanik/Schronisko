<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%--
  Created by IntelliJ IDEA.
  User: Paweł
  Date: 31.01.2018
  Time: 08:56
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<style><%@include file="/resources/css/styles.css"%></style>
<html>
<head>
    <title>Przegląd</title>
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

        <c:if test="${not empty requestScope.animals}">
            <c:forEach var="animal" items="${requestScope.animals}">
                <div class="container">
                    <div class="row">
                        <div class="col-xs-12 col-sm-8 main">
                            <div class="blog-post">
                                <h2 class="blog-post-title"><a href="#contactAnimal"> ${animal.name}</a> </h2>
                                <p class="blog-post-meta">Rodzaj: ${animal.animalType}</p>
                                <p><img src="../resources/img/${animal.animalPhoto}" alt="Kontak w sprawie tego zwierzęcia" class="thumbnail">Wiek: ${animal.age}</p>
                                <p>Płeć: ${animal.animalSex}</p>
                                <p>Opis: ${animal.description}</p>
                                <a href="#contactAnimal" class="btn btn-default">Skontaktuj się i przygarnij</a>
                            </div>
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
