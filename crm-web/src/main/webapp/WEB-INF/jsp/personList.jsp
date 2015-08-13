<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%--
  Created by IntelliJ IDEA.
  User: Alexander
  Date: 09.08.2015
  Time: 12:14
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title></title>
</head>
<body>
personlist
  <c:forEach items="${requestScope.get(\"persons\")}" var="p">
    <c:out value="${p}"/>

  </c:forEach>
</body>
</html>
