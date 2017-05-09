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
        <link href="css/bootstrap.min.css" rel="stylesheet" type="text/css"/>
        <link rel="stylesheet" href="css/navbar.css">
        <link href="css/bootstrapOverrides.css" rel="stylesheet" type="text/css"/>
        <title>Login</title>
    </head>
    <body>
        
        <jsp:include page="includes/navbar.jsp" />
        <div class="container">

        <div class="container-fluid">
                <div class="jumbotron">
                    <h1>Login</h1>
                    <p>${message}</p>
                    <form action="LoginHandler" method="POST">
                        <div>
                            <div class="form-group">
                                <label>Username: </label>
                                <input class="form-control" type="text" name="Username"/>
                            </div>
                            
                            <div class="form-group">
                                <label>Password </label>
                                <input class="form-control" type="password" name="Password"/>
                            </div>
                            <input type="submit" class="btn btn-primary btn-md btn-block" value="Submit">
                        </div>
                        
                        
                    </form>
                </div>
            </div>
        </div>
            
    </body>
</html>
