<%-- 
    Document   : navbar
    Created on : Apr 20, 2017, 12:34:05 PM
    Author     : Ethan Jorgensen
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<jsp:useBean id="authorizedUser" class="agent.Agent" scope="session" />

<div id="navbar">
    <ul>
    <li><a href="MainScreen.jsp">Main</a></li>
    <% if (authorizedUser.getRoles().contains(agent.Role.DATACLERK)) { %>
    <li><a href="clerk/active.jsp">Ongoing</a></li>
    <% } %>
    <% if (authorizedUser.getRoles().contains(agent.Role.AGENT)) { %>
    <li><a href="logCall.jsp">Log</a></li>
    <% } %>
    <% if (authorizedUser != null & authorizedUser.getFirstName().length() > 0) { %>
    <li><a href="index.jsp"><%= authorizedUser.getFirstName() %></a></li>
    <% } else { %>
    <li><a href="index.jsp">Login</a></li>
    <li><a href="dataClerkMain.jsp">Data Clerk</a></li>
    <% } %>
</div>