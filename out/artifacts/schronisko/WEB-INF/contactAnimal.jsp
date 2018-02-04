<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%--
  Created by IntelliJ IDEA.
  User: Paweł
  Date: 02.02.2018
  Time: 10:16
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<style><%@include file="/resources/css/styles.css"%></style>
<html>
<head>
    <title>Title</title>
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

    <c:if test="${not empty requestScope.animal}">
        <div class="container well">
            <div class="row">
                <div class="col-xs-12 col-sm-8">
                    <div class="blog-post">
                        <h2 class="blog-post-title"><a href="#contactAnimal"> ${requestScope.animal.name}</a> </h2>
                        <p class="blog-post-meta">Rodzaj: ${requestScope.animal.animalType}</p>
                        <p><img src="../resources/img/${requestScope.animal.animalPhoto}" alt="Kontak w sprawie tego zwierzęcia" class="thumbnail">Wiek: ${requestScope.animal.age}</p>
                        <p>Płeć: ${requestScope.animal.animalSex}</p>
                        <p>Opis: ${requestScope.animal.description}</p>
                    </div>
                </div>
                <div class="col-xs-12 col-sm-4">
                    <form action="contactAnimal" method="post">
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
                        <input type="hidden" class="form-control" name="animalId" value="${requestScope.animal.animalId}">
                        <button type="submit" class="btn btn-default">Zainteresowana(y)</button>
                    </form>
                </div>
            </div>
        </div>
    </c:if>


<jsp:include page="fragment/footer.jspf"/>
<script src="http://code.jquery.com/jquery-1.11.2.min.js" ></script>
<script src="http://code.jquery.com/jquery-migrate-1.2.1.min.js" ></script>
<script src="${pageContext.request.contextPath}/resources/js/bootstrap.js"></script>
</body>
</html>
