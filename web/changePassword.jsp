<%-- 
    Document   : changePassword
    Created on : Apr 25, 2017, 12:39:47 PM
    Author     : Robert Forbes
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <link rel="stylesheet" href="css/navbar.css">
        <title>Update Password</title>
    </head>
    <body>
        <jsp:include page="includes/navbar.jsp" />
        <p>${message}</p>
        <form action="UpdatePasswordHandler" method="POST">
            <label>Current Password: </label>
            <input type="password" name="OldPassword"/>
            <br>
            <label>New Password: </label>
            <input type="password" name="NewPassword"/>
            <br>
            <label>Confirm Password: </label>
            <input type="password" name="ConfirmPassword"/>
            <br>
            <input type="submit" value="Submit">
        </form>
    </body>
</html>
