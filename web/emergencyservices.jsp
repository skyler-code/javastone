<%-- 
    Document   : emergencyservices
    Created on : Apr 27, 2017, 12:40:32 PM
    Author     : Michael Takrama
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<jsp:useBean id="emergencyService" class="callSession.EmergencyService" scope="session" />
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Emergency Services</title>
        <link href="css/bootstrap.css" rel="stylesheet" type="text/css"/>
        <link href="css/bootstrap-theme.css" rel="stylesheet" type="text/css"/>
        <link href="css/navbar.css" rel="stylesheet" type="text/css"/>
    </head>
    <body>
        <jsp:include page="includes/navbar.jsp" />
        <div class="container">
            <form method="POST" action="">
            <c:forEach items="${emergencyService.emergencyServices}" var="ems"> 
                <div class="radio">
                    <label><input type="radio" name="opems1" value="${ems.id}">${ems.name} || Description: ${ems.description} || Specialty: ${ems.specialty}</label>
                </div>
            </c:forEach>

            <!--Emergency Services-->
<!--            <div class="radio">
                <label><input type="radio" name="opems1" value="1">Already Dead Emergency Services</label>
            </div>

            <div class="radio">
                <label><input type="radio" name="opems1" value="2">Probably Going To Die Emergency Services</label>
            </div>-->
            <!--End of Emergency Services-->     

            <input type="submit" class="btn btn-primary" value="Route Call"/> 
        </form>
        </div>
    </body>
</html>
