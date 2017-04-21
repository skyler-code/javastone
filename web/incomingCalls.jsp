<%-- 
    Document   : incomingCalls
    Created on : Apr 20, 2017, 1:01:02 PM
    Author     : Dan Brown
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<jsp:useBean id="callList" class="calls.IncomingCallList" scope="session" />
<!DOCTYPE html>
<html>
    <jsp:include page="includes/navbar.jsp"/>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <link rel="stylesheet" href="css/navbar.css">
        <link rel="stylesheet" href="css/incomingCall.css" type="text/css"
    </head>
    <body>
        <header>
            <h1>Incoming calls</h1>
        </header>
        <section>
            <c:forEach var="call" items="${callList.incomingCallList}">
                <p>Call: ${call.phoneNumber}
                <a href="<c:url value="RequestHandler">
                    <c:param name="task" value="logCall" />
                    <c:param name="caller_phone" value="${call.phoneNumber}" />
                   </c:url>">Answer Call</a><br>
                </c:forEach></p>
        </section>
        <footer>
            <p>Copyright &copy; 2017 - Crisis Management System - All rights reserved</p>
        </footer>
    </body>
</html>
