<%--
  Created by IntelliJ IDEA.
  User: Paweł
  Date: 2017-09-26
  Time: 13:16
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
  <head>
    <title>$Title$</title>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8" />
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <link href="${pageContext.request.contextPath}/resources/css/bootstrap.min.css" type="text/css" rel="stylesheet">
    <link href="${pageContext.request.contextPath}/resources/css/styles.css" type="text/css" rel="stylesheet">
  </head>
  <body>
  <jsp:include page="fragment/navbar.jspf"/>
  
  
  
  <jsp:include page="fragment/footer.jspf"/>
  <script src="http://code.jquery.com/jquery-1.11.2.min.js" ></script>
  <script src="http://code.jquery.com/jquery-migrate-1.2.1.min.js" ></script>
  <script src="${pageContext.request.contextPath}/resources/js/bootstrap.js"></script>
  </body>

</html>
