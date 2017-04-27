<%-- 
    Created on : Apr 11, 2017
    Modified on: Apr 25, 2017
    Author     : Victor Algarin
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
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
        <title>Data Clerk Main</title>
    </head>
    <body>
        Welcome ${authorizedUser.firstName}! <br/>      

        <form action="ClerkHandler" method="POST">
            <p>To create an account for new employees, fill out fields below and click Add New Account</p>
            <p>${message}</p>
            
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
                            <label for="username">Password:</label>
                        </td>
                        <td>
                            <input type="text" name="password" id="password"/>
                        </td>
                    </tr>
                    <tr>
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

    </body>
</html>
