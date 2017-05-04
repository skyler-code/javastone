<%-- 
    Document   : callerHistory
    Created on : May 2, 2017, 1:46:50 PM
    Author     : NH228U24
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<jsp:useBean class="caller.HistoryBean" id="history" scope="session" />
<!DOCTYPE html>
<html>
    <jsp:include page="includes/navbar.jsp"/>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <link href="css/bootstrap.min.css" rel="stylesheet" type="text/css"/>
        <link href="css/bootstrapOverrides.css" rel="stylesheet" type="text/css"/>
        <link rel="stylesheet" href="css/navbar.css">
        <link rel="stylesheet" href="css/callerHistory.css" type="text/css">
        <title>Caller History </title>
    </head>
    <header>
        <h1>Call History for ${history.callerNumber} </h1>
    </header>
    <body class="container">
        <table class="table-bordered table-striped">
            <thead>
                <tr>
                    <th>Start Time</th>
                    <th>End Time</th>
                    <th>Description</th>
                </tr>
            </thead>
            <tbody>
                <c:forEach var="x" items="${history.history}">
                    <tr>
                        <td>${x.startTime}</td>
                        <td>${x.endTime}</td>
                        <td id="callDescription">${x.callDescription}</td>
                    </tr>
                </c:forEach>
            </tbody>
        </table>
        <footer>
            <p>Copyright &copy; 2017 - Crisis Management System - All rights reserved</p>
        </footer>
    </body>
</html>
