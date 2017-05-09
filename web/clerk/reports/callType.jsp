<%-- 
    Document   : callType
    Created on : Apr 27, 2017, 2:11:22 PM
    Author     : Ryan Spurgetis
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@page import="java.util.ArrayList"%>
<%@page import="java.time.LocalDateTime"%>
<%@page import="callRecord.CallRecordDAO"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<jsp:useBean id="reportBean" class="report.ReportMaker" scope="session" />
<jsp:useBean id="callTypeList" class="callRecord.CallTypeList" scope="session" />
<jsp:useBean id="callItemBean" class="callRecord.CallRecordDTO" scope="session" />
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <link rel="stylesheet" href="css/navbar.css">
        <link href="css/bootstrap.min.css" rel="stylesheet" type="text/css"/>
        <link href="css/bootstrapOverrides.css" rel="stylesheet" type="text/css"/>
        <link href="css/navbar.css" rel="stylesheet" type="text/css"/>
        <title>Call Type Report</title>
    </head>
    <body class="container">
        <h1>Call Type Report</h1>
        <p>Enter the information to generate a report of all calls by on call type.</p>
        <section>
            <form action="ReportHandler" method="GET" class="form-inline">
                <input type="hidden" name="reportType" value="Call type report" />
                <div class="form-group">
                    <label for="callTypeName" id="lblCallTypeName">Call Type: </label>
                    <select name="callTypeName">
                        <option value="Select">Select</option>
                        <c:forEach var="callType" items="${callTypeList.callTypeList}">
                            <option value="${callType.callTypeName}" title="${callType.description}">
                                ${callType.callTypeName}
                            </option>
                        </c:forEach>
                    </select><br>
                    <button type="submit" class="btn btn-primary" >Submit</button><br>
                </div>
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
                    <c:forEach var="callTR" items="${reportBean.callTypeReport}">
                        <tr>
                            <td>${callTR.callId}</td>

                            <td>${callTR.agent_id}</td>

                            <td>${callTR.caller_Id}</td>

                            <td>${callTR.call_description}</td>

                            <td>${callTR.call_type_name}</td>

                            <td>${callTR.start_time}</td>

                            <td>${callTR.end_time}</td>
                        </tr>
                        <!--<tr>
                            <td><%--${callTR.end_time}--%></td> --Need to update with date formatting 
                        </tr>-->
                    </c:forEach>
                </tbody>
            </table>
            <p>Item count ${reportBean.callTypeReport.size()}</p>
        </div>
    </body>
</html>
