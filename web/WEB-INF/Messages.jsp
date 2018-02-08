<%--
  Created by IntelliJ IDEA.
  User: Paweł
  Date: 06.02.2018
  Time: 08:20
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

<div class="container">
    <div class="row">
        <div class="col-xs-12 col-md-8">
            <h2>Wiadomości w sprawie zwierząt</h2>
            <c:if test="${not empty requestScope.contactAnimals}">
                <c:forEach var="contactAnimal" items="${requestScope.contactAnimals}">
                    <div class="blog-post well">
                    <h3 class="blog-post-title"> Wiadomość nr: ${contactAnimal.id}</h3>
                    <p class="blog-post-meta">Imię: ${contactAnimal.username} </p>
                    <p class="blog-post-meta">Nazwisko: ${contactAnimal.surname}</p>
                    <p class="blog-post-meta">E-mail: ${contactAnimal.email}</p>
                    <p><img src="../resources/img/${contactAnimal.animal.animalPhoto}" alt="Kontak w sprawie tego zwierzęcia" class="thumbnail">Wiek: ${contactAnimalanimal.age}</p>
                    <p>Płeć: ${contactAnimal.animal.animalSex}</p>
                    <p>Opis: ${contactAnimal.animal.description}</p>
                    <p>Wiadomość od klienta: ${contactAnimal.message}</p>
                        <form action="/messages" method="post">
                            <input type="hidden" name="id" value="${contactAnimal.id}">
                            <button type="submit" name="submitValue" value="delete" class="btn btn-danger">Usuń zwierzę</button>
                        </form>
                    </div>
                </c:forEach>
            </c:if>
        </div>
        <div class="col-xs-12 col-md-4">
            <h2>Wiadomości kontaktowe </h2>
        </div>
    </div>
</div>

<jsp:include page="fragment/footer.jspf"/>
<script src="http://code.jquery.com/jquery-1.11.2.min.js" ></script>
<script src="http://code.jquery.com/jquery-migrate-1.2.1.min.js" ></script>
<script src="${pageContext.request.contextPath}/resources/js/bootstrap.js"></script>
</body>
</html>
