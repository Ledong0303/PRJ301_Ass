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
        <style>
            .fpt img{
                width: 30%;
                height: 40%;
            }
            h1{
                display: flex;
               
            }
            .op h1{
                align-content: center;
            }

        </style>
    </head>
    <body>
        <h1>
            Home
        
        <div class="fpt">
            <img src="./img/Logo_Đại_học_FPT.png" />  
        </div>
        </h1>
       <br/>
        <c:if test="${sessionScope.account ne null}">
            Hello ${sessionScope.account.displayname}, click
            <a href="logout">here</a> to logout.
        </c:if>
        <c:if test="${sessionScope.account eq null}">
            <h1>click<a href="login"> here </a> to login.</h1>
        </c:if>
        <br/>
        <div class="op">
            <h1><a href="timetable?lid=1">Timetable</a> <br/></h1>
        <h1><a href="takeatt?id=1">Takeatt</a></h1>
        </div>
    </body>
</html>
