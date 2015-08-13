<%--
  Created by IntelliJ IDEA.
  User: Alexander
  Date: 09.08.2015
  Time: 13:16
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@taglib uri="http://www.springframework.org/tags/form" prefix="form" %>
<%@taglib uri="http://www.springframework.org/tags" prefix="s" %>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="f" %>
<%@taglib uri="http://jakarta.apache.org/taglibs/standard/scriptfree" prefix="sf" %>
<html>
<head>
    <title></title>
</head>
<body>
<table>
    <form:form method="POST" action="/addPerson">

        <tr>
            <td>Email:</td>
            <td><form:input path="email"/></td>
        </tr>
        <tr>
            <td>Name:</td>
            <td><form:input path="firstName"/></td>
        </tr>
        <tr>
            <td>Last Name:</td>
            <td><form:input path="lastName"/></td>
        </tr>
        <tr>
            <td>Middle Name</td>
            <td><form:input path="middleName"/></td>
        </tr>


        <tr>
            <td><input type="submit" value="Submit"></td>
        </tr>
    </form:form>
</table>
</body>
</html>
