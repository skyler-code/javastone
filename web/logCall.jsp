<%-- 
    Document   : logCall
    Created on : Apr 11, 2017, 3:13:32 PM
    Modified on: Apr 16, 2017, 3:40:00 PM, DB
    Author     : Dan Brown
--%>

<%@page import="java.time.LocalDateTime"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@page import="java.util.ArrayList"%>
<%@page import="callRecord.CallType"%>
<%@page import="agent.Agent"%>
<%@page import="callRecord.CallRecordDAO"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<jsp:useBean id="callRecord" class="callRecord.CallRecordDTO" scope="session" />
<jsp:useBean id="authorizedUser" class="agent.Agent" scope="session" />
<jsp:useBean id="caller" class="caller.caller" scope="session" />
<jsp:useBean id="callTypeList" class="callRecord.CallTypeList" scope="session" />


<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <link rel="stylesheet" href="css/logCallCss.css" type="text/css">
        <link rel="stylesheet" href="css/navbar.css">
        <title>LogCall</title>
    </head>
    <body>
        <jsp:include page="includes/navbar.jsp"/>
        <header>
            <h1>Log current call</h1>
            <p style="color: red;">${logCallMessage}</p>
        </header>
        
        <form action="CallRecordHandler" method="POST">
            <%-- 
            <section>
            <label for="callId" id="lblCallId">Call ID</label>
            <input name="callId" id="callId" type="text" readonly="readonly" value="<c:out value="${callRecord.call_Id}" default="000000" />"><br>
            </section>
            --%>
            <section>
            <label for="agentId" id="lblAgentId">Agent ID</label>
            <input name="agentId" id="agentId" type="text" readonly="readonly" value="<c:out value="${authorizedUser.userID}" default="000000" />"><br>
            </section>
            
            <section>
            <label for="callerPhone" id="lblCallerPhone">Caller Phone</label>
            <input name="callerPhone" id="callerPhone" type="text" value="${caller.phoneNumber}" readonly="readonly"><br>
            </section>
            
            <section>
            <label for="callDescription" id="lblCallDescription">Description</label>
            <textarea name="callDescription" id="callDescription" type="text" rows="10" cols="30" ></textarea><br>
            </section>
            
            <section>
            <label for="callTypeName" id="lblCallTypeName">Call Type</label>
            <select name="callTypeName" id="callTypeName">
                <option value="Select">Select</option>
                <c:forEach var="callType" items="${callTypeList.callTypeList}">
                    <option value="${callType.callTypeName}" title="${callType.description}">
                        ${callType.callTypeName}
                    </option>
                </c:forEach>
            </select><br>
            </section>
            
            <section>
            <label for="startTime" id="lblStartTime">Start Time</label>
            
            <c:set var="now" value="${LocalDateTime.now()}" />
            <input name="startTime" id="startTime" type="text" readonly="readonly" value="${now}"><br>
            </section>
            
            
            <input type="submit" value="confirm" > 
        </form>
        
        <footer>
            <p>Copyright &copy; 2017 - Crisis Management System - All rights reserved</p>
        </footer>
    </body>
</html>
