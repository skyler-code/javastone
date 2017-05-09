<%-- 
    Document   : active
    Created on : Apr 13, 2017, 12:40:58 PM
    Author     : nh228u15
--%>

<%@page import="java.time.Duration"%>
<%@page import="java.time.LocalDateTime"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<jsp:useBean id="authorizedUser" class="agent.Agent" scope="session" />
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Active Calls</title>
        <link rel="stylesheet" href="../css/bootstrap.min.css">
        <link rel="stylesheet" href="../css/bootstrap-theme.min.css">
        <link rel="stylesheet" href="../css/navbar.css">
        <link rel="stylesheet" href="../css/tabular.css">
        <script src="../js/jquery-3.2.1.min.js"></script>
        <script src="../js/active.js"></script>
    </head>
    <body>
        <jsp:include page="../includes/navbar.jsp"/>
        <div class="container">
            <h1>Active Calls</h1>
        <table id="calls" class="table">
                <tr class="head">
                    <td>Call ID</td>
                    <td>Duration</td>
                    <td>Listen</td>
                </tr>
            <% for (callRecord.CallRecordDTO call
                    : callRecord.CallRecordDAO.getOngoingCalls()) { %>
                <tr>
                    <td><%=call.getCall_Id()%></td>
                    <td><%=util.DurationUtility.formatDuration(
                            Duration.between(
                                    call.getStart_time(),
                                    LocalDateTime.now()
                            )
                    )%></td>
                    <td><input type="button" class="listen" value="Listen"/></td>
                </tr>
            <% } %>
        </table>
        </div>
    </body>
</html>
