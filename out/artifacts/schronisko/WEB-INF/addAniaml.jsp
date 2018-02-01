<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<style><%@include file="/resources/css/styles.css"%></style>
<c:set var="privigiles" scope="session" value="${sessionScope.privigiles}"/>
<html>
<head>
    <title>Nowe zwierzę</title>
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
    </c:choose>

    <div class="container">
    <%--@declare id="form-signin"--%><form class="form-signin" action="/addAnimal" method="post">
        <h2 class="form-signin-heading">Dodaj nowe zwierzę</h2>
        <input name="inputName" type="text" class="form-control" placeholder="Nazwa" required autofocus><br>
        Płeć:
        <input type="radio" name="inputGender" value="male" checked> Male
        <input type="radio" name="inputGender" value="female"> Female<br>
        Age:
        <input name="inputAge" type="text" class="form-control" placeholder="Wiek" required autofocus><br>
        Rodzaj:
        <input name="inputType" type="radio" value="cat" checked> Kot <br>
        <input name="inputType" type="radio" value="dog"> Pies <br>
        <input name="inputType" type="radio" value="other"> Inny <br>
        Aktywność:
        <input type="radio" name="inputActivity" value="low" > Mała
        <input type="radio" name="inputActivity" value="medium" checked>  Srednia
        <input type="radio" name="inputActivity" value="high"> Duża <br>
        Opis:<br>
        <textarea rows="4" cols="50" name="inputDescription" class="form-control" placeholder="Opis" required></textarea><br>
        <input type="file" name="inputPhoto">Wybierz plik <br>
        <button class="btn btn-lg btn-primary btn-block" type="submit">Dodaj</button>
    </form>

</div> <!-- /container -->

    <jsp:include page="fragment/footer.jspf"/>
    <script src="http://code.jquery.com/jquery-1.11.2.min.js" ></script>
    <script src="http://code.jquery.com/jquery-migrate-1.2.1.min.js" ></script>
    <script src="${pageContext.request.contextPath}/resources/js/bootstrap.js"></script>
</body>
</html>
