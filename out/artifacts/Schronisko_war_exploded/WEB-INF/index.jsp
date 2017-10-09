<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%--
  Created by IntelliJ IDEA.
  User: Paweł
  Date: 2017-09-26
  Time: 13:16
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
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
  <!--<jsp:include page="fragment/navbar.jspf"/> -->
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
  
  
  
  <jsp:include page="fragment/footer.jspf"/>
  <script src="http://code.jquery.com/jquery-1.11.2.min.js" ></script>
  <script src="http://code.jquery.com/jquery-migrate-1.2.1.min.js" ></script>
  <script src="${pageContext.request.contextPath}/resources/js/bootstrap.js"></script>
  </body>

</html>
