<%-- 
    Document   : index
    Created on : Apr 8, 2017, 12:52:26 PM
    Author     : Skyler Hiscock
--%>

<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<jsp:useBean id="authorizedUser" class="agent.Agent" scope="session" />
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <meta name="viewport" content="width=device-width, initial-scale=1">
        <link rel="stylesheet" href="css/navbar.css">
        <title>Login</title>
    </head>
    <body>
        <jsp:include page="includes/navbar.jsp"/>
        <a href="<c:url value="RequestHandler" > <c:param name="task" value="logCall" /> </c:url>" >
                Log call link</a>

            <h1>Login</h1>
            <p>${message}</p>
        <form action="LoginHandler" method="POST">
            <label>Username: </label>
            <input type="text" name="Username"/>
            <br>
            <label>Password </label>
            <input type="password" name="Password"/>
            <br>
            <input type="submit" value="Submit">
        </form>
    </body>
</html>
