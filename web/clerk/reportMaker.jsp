<%-- 
    Document   : reportMaker
    Created on : Apr 27, 2017, 1:07:54 PM
    Author     : Ryan Spurgetis
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@page import="java.time.LocalDateTime"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<jsp:useBean id="reportBean" class="report.ReportMaker" scope="session" />
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <link rel="stylesheet" href="css/navbar.css">
        <link href="css/bootstrap.min.css" rel="stylesheet" type="text/css"/>
        <link href="css/bootstrapOverrides.css" rel="stylesheet" type="text/css"/>
        <link href="css/navbar.css" rel="stylesheet" type="text/css"/>
        <title>Report Maker</title>
    </head>
    <body class="container">
        <h1>Report Maker</h1>
        <form action="ReportHandler" method="GET" class="form-inline">
            <div class="form-group">
                <label for="reportType" id="lblReportType">Select Report Type: </label><br>
                <select name='reportType'>
                    <c:forEach var="reportItem" items="${reportBean.reports}">
                        <option>${reportItem}</option>
                    </c:forEach>

                </select>
                <button type="submit" class="btn btn-primary" >Submit</button><br>
            </div>
        </form>
    </body>
</html>
