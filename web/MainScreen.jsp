<%-- 
    Document   : MainScreen
    Created on : Apr 12, 2017, 5:15:13 PM
    Author     : Robert Forbes
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<jsp:useBean id="authorizedUser" class="agent.Agent" scope="session" />
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <link rel="stylesheet" href="css/navbar.css">
        <title>JSP Page</title>
    </head>
    <body>
        <jsp:include page="includes/navbar.jsp" />
        Welcome ${authorizedUser.firstName}! <br/>
        <% if (authorizedUser.getRoles().contains(agent.Role.ADMINISTRATOR)){ %>
        You shouldn't see this, unless you're an admin.
        <% } %>
        
    </body>
</html>
