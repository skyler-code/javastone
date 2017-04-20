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
        <link rel="stylesheet" href="css/navbar.css">
    </head>
    <body>
        <jsp:include page="../includes/navbar.jsp"/>
        <h1>Active Calls</h1>
        <table id="calls">
                <tr class="head">
                    <td>Call ID</td>
                    <td>Duration</td>
                </tr>
            <% for (callRecord.CallRecordDTO call
                    : callRecord.CallRecordDAO.getOngoingCalls()) { %>
                <tr>
                    <td><%=call.getCall_Id()%></td>
                    <td><%=Duration.between(call.getStart_time(), LocalDateTime.now()).toString()%></td>
                </tr>
            <% } %>
        </table>
    </body>
</html>
