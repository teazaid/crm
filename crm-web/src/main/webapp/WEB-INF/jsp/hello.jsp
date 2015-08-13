<%--
  Created by IntelliJ IDEA.
  User: Alexander
  Date: 07.08.2015
  Time: 23:33
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c"
           uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page import="org.pnt.product.model.Person" %>
<html>
<head>
    <title></title>
</head>
<body>


  <% Person p = (Person)request.getAttribute("myString") ;
  System.out.println(p.getFirstName()); %>


<c:out value="${request.getAttribute(\"myString\")}" />



</body>
</html>
