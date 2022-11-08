<%-- 
    Document   : home
    Created on : Nov 2, 2022, 1:25:40 PM
    Author     : x
--%>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>
       
            <c:if test="${sessionScope.account eq null}">
            click
            <a href="login">here</a> to login.
        </c:if>
            <br/>
            <a href="timetable?lid=1">Timetable</a> <br/>
            <a href="takeatt?id=1">Take attendance</a>
    </body>
</html>
