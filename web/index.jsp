<%-- 
    Document   : index
    Created on : Apr 8, 2017, 12:52:26 PM
    Author     : Skyler Hiscock
--%>

<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>
        <h1>Hello World!</h1>
        
        <a href="<c:url value="RequestHandler" > <c:param name="task" value="logCall" /> </c:url>" >
                View Detail</a>
    </body>
</html>
