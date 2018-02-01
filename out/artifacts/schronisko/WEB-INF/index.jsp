<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%--
  Created by IntelliJ IDEA.
  User: Paweł
  Date: 2017-09-26
  Time: 13:16
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<style><%@include file="/resources/css/styles.css"%></style>
<c:set var="privigiles" scope="session" value="${sessionScope.privigiles}"/>
<html>
  <head>
    <title>$Title$</title>
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
          <div class="col-xs-8 col-xs-offset-2 caption">
            <h1>Patrz na świat z innej perspektywy</h1>
            <p>Nasza aplikacja pozwala znalezc dom potrzebującym zwierzętom</p>
            <p>Internetowy donejt</p>
            <a href="#" class="btn btn-default">Kup <strong>pożywienie</strong></a>
            <a href="#" class="btn btn-link">Przekaż <strong>pieniądze</strong></a>

          </div>
        </div>
      </div>
    </div>
  </div>
  <div class="container-fluid features">
    <div class="row">
      <div class="col-xs-12 col-sm-4"><span class="glyphicon glyphicon-heart"></span>
        <h3>Serce</h3></div>
      <div class="col-xs-12 col-sm-4"><span class="glyphicon glyphicon-picture"></span><h3>Troska</h3></div>
      <div class="col-xs-12 col-sm-4"><span class="glyphicon glyphicon-globe"></span><h3>Miłość</h3></div>
    </div>
  </div>

  <div id="carousel-example-generic" class="carousel slide" data-ride="carousel">
    <!-- Wskazniki -->
    <ol class="carousel-indicators">
      <li data-target="#carousel-example-generic" data-slide-to="0" class="active"></li>
      <li data-target="#carousel-example-generic" data-slide-to="1"></li>
      <li data-target="#carousel-example-generic" data-slide-to="1"></li>
    </ol>

    <!-- Slajdy -->
    <div class="carousel-inner" role="listbox">
      <div class="item active">
        <img src="../resources/img/cat-3080965_1920.jpg" alt="kotek">
        <div class="carousel-caption">
          Rudzielec
        </div>
      </div>

      <div class="item">
        <img src="../resources/img/chihuahua-624924_1920.jpg" alt="chihuahua">
        <div class="carousel-caption">
          Chihuahua
        </div>
      </div>
      <div class="item">
        <img src="../resources/img/dog-2437110_1920.jpg" alt="dog">
        <div class="carousel-caption">
          Dog
        </div>
      </div>
    </div>

    <!-- strzałki -->
    <a class="left carousel-control" href="#carousel-example-generic" role="button" data-slide="prev">
      <span class="glyphicon glyphicon-chevron-left" aria-hidden="true"></span>
      <span class="sr-only">Poprzednie</span>
    </a>
    <a class="right carousel-control" href="#carousel-example-generic" role="button" data-slide="next">
      <span class="glyphicon glyphicon-chevron-right" aria-hidden="true"></span>
      <span class="sr-only">Nastepne</span>
    </a>
  </div>

  <div class="container call-to-action">
    <div class="row">
      <div class="col-xs-12">
        <h2>Nie pozwol na zmarnowanie talentu</h2>
        <a href="#" class="btn btn-default">Kup aplikacje za 29.99</a><br>
        <a href="#" class="btn btn-link">Wyprobuj demo</a>
      </div>
    </div>
  </div>

  <jsp:include page="fragment/footer.jspf"/>
  <script src="http://code.jquery.com/jquery-1.11.2.min.js" ></script>
  <script src="http://code.jquery.com/jquery-migrate-1.2.1.min.js" ></script>
  <script src="${pageContext.request.contextPath}/resources/js/bootstrap.js"></script>
  </body>

</html>
