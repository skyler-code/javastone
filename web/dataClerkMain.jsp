<%-- 
    Document   : dataClerkMain
    Created on : Apr 20, 2017, 1:06:36 PM
    Author     : NH228U23
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<jsp:useBean id="authorizedUser" class="agent.Agent" scope="session" />
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>
        Welcome ${authorizedUser.firstName}! <br/>
        <form>
            <label for="newAccount">Add New Account</label>
            <input type="submit" name="newAccount"/>
        </form>     
    </body>
</html>
