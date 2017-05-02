<%-- 
    Document   : navbar
    Created on : Apr 20, 2017, 12:34:05 PM
    Author     : Ethan Jorgensen
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<jsp:useBean id="authorizedUser" class="agent.Agent" scope="session" />
<div id="navbar">
    <ul>
    <% if (authorizedUser.getRoles().contains(agent.Role.DATACLERK)) { %>
    <li><a href="/JavaStone/clerk/active.jsp">Ongoing</a></li>
    <li><a href="/JavaStone/clerk/dataClerkMain.jsp">Data Clerk</a></li>
    <% } %>
    <% if (authorizedUser.getRoles().contains(agent.Role.AGENT)) { %>
    <li><a href="/JavaStone/incomingCalls.jsp">Incoming</a></li>
    <!--li><a href="/JavaStone/logCall.jsp">Log</a></li-->
    <% } %>
    <% if (authorizedUser != null & authorizedUser.getFirstName().length() > 0) { %>
    <li><a href="/JavaStone/changePassword.jsp">Change Password</a></li>
    <li><a href="/JavaStone/LogoutHandler">Logout</a></li>
    <% } else { %>
    <li><a href="/JavaStone/index.jsp">Login</a></li>
    
    <% } %>
</div>