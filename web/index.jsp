<%-- 
    Document   : index
    Created on : Apr 8, 2017, 12:52:26 PM
    Author     : Skyler Hiscock
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <meta name="viewport" content="width=device-width, initial-scale=1">
        <title>Login</title>
    </head>
    <body>
        <h1>Login</h1>
        <p>${message}</p>
        <form action="LoginHandler" method="GET">
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
