<%-- 
    Created on : Apr 11, 2017
    Modified on: Apr 25, 2017
    Author     : Victor Algarin
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<jsp:useBean id="authorizedUser" class="agent.Agent" scope="session" />
<%@page import="agent.Agent"%>
<!DOCTYPE html>

<%
    Agent dataClerk = (Agent) request.getAttribute("Agent");

    String username = "";
    String fName = "";
    String lName = "";
    String phone = "";
    String address = "";
    String city = "";
    String zip = "";

    if (null != dataClerk) {
        username = dataClerk.getUsername();
        fName = dataClerk.getFirstName();
        lName = dataClerk.getLastName();
        phone = dataClerk.getPhoneNumber();
        address = dataClerk.getAddress();
        city = dataClerk.getCity();
        zip = dataClerk.getZipCode();
    }
%>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <script src="../js/jquery-3.2.1.min.js" type="text/javascript"></script>
        <script src="../js/bootstrap.min.js" type="text/javascript"></script>
        <link rel="stylesheet" href="../css/logCallCss.css" type="text/css">
        <link rel="stylesheet" href="../css/navbar.css">
        <link href="../css/bootstrap.min.css" rel="stylesheet" type="text/css"/>
        <title>Data Clerk Main</title>
    </head>
    <body>
        <jsp:include page="../includes/navbar.jsp"/>
        <div class="container">
            <form action="ClerkHandler" method="POST">
            <p><br />To create an account for new employees, fill out fields below and click Add New Account</p>
            <p class="statusMessage">${message}</p>

            <table>
                <tbody>
                    <tr>
                        <td>
                            <label for="username">Username:</label>
                        </td>
                        <td>
                            <input type="text" name="username" id="username"/>
                        </td>
                    </tr>
                    <tr>
                        <td>
                            <label for="password">Password:</label>
                        </td>
                        <td>
                            <input type="password" name="password" id="password"/>
                        </td>
                    </tr>
                    <tr>
                        <td>
                            <label for="passwordConfirm">Confirm Password:</label>
                        </td>
                        <td>
                            <input type="password" name="passwordConfirm" id="passwordConfirm"/>
                        </td>
                    </tr>
                        <td>
                            <label for="fName">First Name:</label>
                        </td>
                        <td>
                            <input type="text" name="fName" id="fName"/>
                        </td>
                    </tr>
                    <tr>
                        <td>
                            <label for="lName">Last Name:</label>
                        </td>
                        <td>
                            <input type="text" name="lName" id="lName"/>
                        </td>
                    </tr>
                    <tr>
                        <td>
                            <label for="phone">Phone Number:</label>
                        </td>
                        <td>
                            <input type="text" name="phone" id="phone"/>
                        </td>
                    </tr>
                    <tr>
                        <td>
                            <label for="address">Address:</label>
                        </td>
                        <td>
                            <input type="text" name="address" id="address"/>
                        </td>
                    </tr>
                    <tr>
                        <td>
                            <label for="city">City:</label>
                        </td>
                        <td>
                            <input type="text" name="city" id="city"  />
                        </td>
                    </tr>
                    <tr>
                        <td>
                            <label for="state">State:</label>
                        </td>
                        <td>
                            <input type="text" name="state" id="state"/>
                        </td>
                    </tr>
                    <tr>
                        <td>
                            <label for="zip">Zip Code:</label>
                        </td>
                        <td>
                            <input type="text" name="zip" id="zip" />
                        </td>
                    </tr>
                </tbody>
            </table><br/>
            <label for="newAccount">Add New Account</label>
            <input type="submit" name="newAccount"/>
        </form>
        <div class="btn-link">
        <a href='<c:url value="../RequestHandler" > <c:param name="task" value="report" /> </c:url>' >
        Create Reports</a>
        </div>
        </div>
    </body>
</html>
