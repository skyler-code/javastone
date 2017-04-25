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
<%@page import="serviceProviders.ServiceCategoryList"%>
<%@page import="serviceProviders.ServiceProviderList"%>
<%@page import="serviceProviders.ServiceCategory"%>
<%@page import="serviceProviders.ServiceProvider"%>
<%@page import="callRecord.CallRecordDAO"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<jsp:useBean id="callRecord" class="callRecord.CallRecordDTO" scope="session" />
<jsp:useBean id="authorizedUser" class="agent.Agent" scope="session" />
<jsp:useBean id="caller" class="caller.Caller" scope="session" />
<jsp:useBean id="callTypeList" class="callRecord.CallTypeList" scope="session" />
<jsp:useBean id="serviceProvidersList" class="serviceProviders.ServiceProviderList" scope="session"/>
<jsp:useBean id="serviceCategoriesList" class="serviceProviders.ServiceCategoryList" scope="session"/>


<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <script src="js/jquery-3.2.1.min.js" type="text/javascript"></script>
        <script src="js/bootstrap.min.js" type="text/javascript"></script>
        <link rel="stylesheet" href="css/logCallCss.css" type="text/css">
        <link rel="stylesheet" href="css/navbar.css">
        <link href="css/bootstrap.min.css" rel="stylesheet" type="text/css"/>
        <title>LogCall</title>
    </head>
    <body>
        <jsp:include page="includes/navbar.jsp"/>
        <header>
            <h1>Log current call</h1>
            <p class="statusMessage">${logCallMessage}</p>
        </header>
        <div class="mainContent">
            <form action="CallRecordHandler" method="POST">
                <div class="left">
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
                </div>

                <div class="right">
                    <section>
                        <label for="callerFirstname" id="lblCallerFirstname">Caller First Name</label>
                        <input name="callerFirstname" id="callerFirstname" type="text" value="${caller.firstname}"><br>
                    </section>
                    <section>
                        <label for="callerLastname" id="lblCallerLastname">Caller Last Name</label>
                        <input name="callerLastname" id="callerLastname" type="text" value="${caller.lastname}"><br>
                    </section>
                    <section>
                        <label for="callerNotes" id="lblCallerNotes">Callers notes</label>
                        <textarea name="callerNotes" id="callerNotes" rows="5" cols="30">${caller.callerNotes}</textarea>
                    </section>
                </div>

                <input type="submit" value="confirm" >
            </form>


        </div>

        <div class="panel-group" id="accordion" style="display:inline-table">
            <c:forEach var="serviceCategory" items="${serviceCategoriesList.serviceCategories}">
                <div class="panel panel-default">
                    <div class="panel-heading">
                        <h4 class="panel-title">
                            <a data-toggle="collapse" data-parent="#accordion" href="#${serviceCategory.serviceCategoryName.replaceAll("\\s+","")}">${serviceCategory.serviceCategoryName}</a>
                        </h4>
                    </div>
                    <div id="${serviceCategory.serviceCategoryName.replaceAll("\\s+","")}" class="panel-collapse collapse">
                        <c:forEach var="serviceProvider" items="${serviceProvidersList.serviceProviders}">
                            <c:if test="${serviceProvider.serviceCategoryName == serviceCategory.serviceCategoryName}">
                                <div class="panel-body">
                                    ${serviceProvider.serviceProviderName} : ${serviceProvider.serviceProviderPhoneNumber} <br/>
                                </div>
                            </c:if>
                        </c:forEach>
                    </div>
                </div>
            </c:forEach>
        </div>
        <footer>
            <p>Copyright &copy; 2017 - Crisis Management System - All rights reserved</p>
        </footer>
    </body>
</html>
