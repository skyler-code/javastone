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
        <link href="css/bootstrap.min.css" rel="stylesheet" type="text/css"/>
        <link href="css/bootstrapOverrides.css" rel="stylesheet" type="text/css"/>
        <link rel="stylesheet" href="css/navbar.css">
        <title>${authorizedUser.firstName} ${authorizedUser.lastName}</title>
    </head>
    <body>
        <jsp:include page="includes/navbar.jsp" />
        <div class="container">
            <div class="jumbotron container">
            <label class="col-lg-12"><h3>Username:<small>${authorizedUser.username}</small></h3></label>
            <label class="col-lg-12"><h3>Name:<small>${authorizedUser.firstName} ${authorizedUser.lastName}</small></h3></label>
            <label class="col-lg-12"><h3>Address:<small>${authorizedUser.address}, ${authorizedUser.city}, ${authorizedUser.state}</small></h3></label>
        </div> 
        </div>
               
    </body>
</html>
