<%-- 
    Document   : active
    Created on : Apr 13, 2017, 12:40:58 PM
    Author     : nh228u15
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Active Calls</title>
    </head>
    <body>
        <h1>Active Calls</h1>
        <div id="calls">
            <% for (callRecord.CallRecordDTO call
                    : callRecord.CallRecordDAO.getOngoingCalls()) { %>
                
                <span><%=call.getCall_Id()%></span>
                
            <% } %>
        </div>
    </body>
</html>
