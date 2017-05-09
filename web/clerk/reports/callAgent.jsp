<%-- 
    Document   : callAgent
    Created on : May 3, 2017, 10:24:58 PM
    Author     : Ryan Spurgetis
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@page import="java.util.ArrayList"%>
<%@page import="java.time.LocalDateTime"%>
<%@page import="callRecord.CallRecordDAO"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<jsp:useBean id="reportBean" class="report.ReportMaker" scope="session" />
<%--<jsp:useBean id="callTypeList" class="callRecord.CallTypeList" scope="session" />
<jsp:useBean id="callItemBean" class="callRecord.CallRecordDTO" scope="session" />--%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <link rel="stylesheet" href="css/navbar.css">
        <link href="css/bootstrap.min.css" rel="stylesheet" type="text/css"/>
        <link href="css/bootstrapOverrides.css" rel="stylesheet" type="text/css"/>
        <link href="css/navbar.css" rel="stylesheet" type="text/css"/>
        <title>Call Agent Report</title>
    </head>
    <body class="container">
        <h1>Call Agent Report</h1>
        <p>Enter the information to generate a report of all calls by on call type.</p>
        <section>
            <form action="ReportHandler" method="GET" class="form-inline">
                <div class="form-group">
                    <input type="hidden" name="reportType" value="Call by agent report" />
                    <label for="agentId" id="lblAgentId">Agent ID: </label>
                    <input name="agentId" class="form-control" type="text" />
                </div>
                <button type="submit" class="btn btn-primary " >Submit</button><br>
            </form><br>
        </section>
        <div class="table-bordered">
            <table border="1">
                <tr>
                    <th> Call ID </th>
                    <th> User ID </th>
                    <th> Caller Phone </th>
                    <th> Call Description </th>
                    <th> Call Type </th>
                    <th> Start time </th>
                    <th> End time </th>
                </tr>
                <tbody>
                    <c:forEach var="callAR" items="${reportBean.callAgentReport}">
                        <tr>
                            <td>${callAR.callId}</td>

                            <td>${callAR.agent_id}</td>

                            <td>${callAR.caller_Id}</td>

                            <td>${callAR.call_description}</td>

                            <td>${callAR.call_type_name}</td>

                            <td>${callAR.start_time}</td>

                            <td>${callAR.end_time}</td>
                        </tr>
                        <!--<tr>
                            <td><%--${callTR.end_time}--%></td> --Need to update with date formatting 
                        </tr>-->
                    </c:forEach>
                </tbody>
            </table>
            <p>Item count ${reportBean.callAgentReport.size()}</p>
        </div>
    </body>
</html>

