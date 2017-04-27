<%-- 
    Document   : emergencyservices
    Created on : Apr 27, 2017, 12:40:32 PM
    Author     : Michael Takrama
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Emergency Services</title>
        <link href="css/bootstrap.css" rel="stylesheet" type="text/css"/>
        <link href="css/bootstrap-theme.css" rel="stylesheet" type="text/css"/>
        <link href="css/navbar.css" rel="stylesheet" type="text/css"/>
        <jsp:useBean id="emergencyService" class="callSession.EmergencyService" scope="session" />
    </head>
    <body>
        <jsp:include page="includes/navbar.jsp" />

        <form method="post" action="">
            <c:forEach items="${emergencyService.emergencyServices}}" var="ems" varStatus="line" > 
                <div class="radio">
                    <label><input type="radio" name="opems1" value=${ems.Id}>${ems.Name}</label>
                </div>
            </c:forEach>

            <!--Emergency Services-->
            <div class="radio">
                <label><input type="radio" name="opems1" value="1">Already Dead Emergency Services</label>
            </div>

            <div class="radio">
                <label><input type="radio" name="opems1" value="2">Probably Going To Die Emergency Services</label>
            </div>
            <!--End of Emergency Services-->     

            <input type="submit" class="btn btn-primary" value="Route Call"/> 
        </form>

    </body>
</html>
