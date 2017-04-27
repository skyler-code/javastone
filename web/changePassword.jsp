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
        <link href="css/bootstrap.min.css" rel="stylesheet" type="text/css"/>
        <link href="css/bootstrapOverrides.css" rel="stylesheet" type="text/css"/>
        <title>Update Password</title>
    </head>
    <body>
        <jsp:include page="includes/navbar.jsp" />
        <div class="container-fluid">
            <div class="jumbotron">
                <h1>Change Password</h1>
                <p>${message}</p>
                <form action="UpdatePasswordHandler" method="POST" class="form-horizontal">
                    <div class="form-group">
                        <label class="col-sm-2 control-label">Current Password: </label>
                        <div class="col-sm-10"><input class="form-control" type="password" name="OldPassword"/></div>
                    </div>
                    <div class="form-group">
                        <label class="col-sm-2 control-label">New Password: </label>
                        <div class="col-sm-10"><input class="form-control" type="password" name="NewPassword"/></div>
                    </div>
                    <div class="form-group">
                        <label class="col-sm-2 control-label">Confirm Password: </label>
                        <div class="col-sm-10"><input class="form-control" type="password" name="ConfirmPassword"/></div>
                    </div>
                    <div class="form-group">
                        <div class="col-sm-offset-2 col-sm-10">
                            <button type="submit" class="btn btn-default">Submit</button>
                        </div>
                    </div>
                </form>
            </div>
        </div>
        
        
        
    </body>
</html>
